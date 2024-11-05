package com.science.gtnl.common.machine;

import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_ME_HATCH;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_ME_HATCH_ACTIVE;
import static gregtech.common.tileentities.machines.MTEHatchOutputME.fluidAEInsert;
import static net.minecraft.util.StatCollector.translateToLocal;

import java.math.BigInteger;
import java.util.*;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

import com.science.gtnl.Utils.TextUtils;

import appeng.api.AEApi;
import appeng.api.implementations.IPowerChannelState;
import appeng.api.networking.GridFlags;
import appeng.api.networking.security.BaseActionSource;
import appeng.api.networking.security.IActionHost;
import appeng.api.networking.security.MachineSource;
import appeng.api.storage.IMEMonitor;
import appeng.api.storage.data.IAEFluidStack;
import appeng.api.storage.data.IAEItemStack;
import appeng.api.storage.data.IItemList;
import appeng.api.util.AECableType;
import appeng.me.GridAccessException;
import appeng.me.helpers.AENetworkProxy;
import appeng.me.helpers.IGridProxyable;
import appeng.util.IWideReadableNumberConverter;
import appeng.util.Platform;
import appeng.util.ReadableNumberConverter;
import gregtech.GTMod;
import gregtech.api.enums.ItemList;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.MTEHatchOutputBus;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GTUtility;

public class MTEIntegratedOutputHatchME extends MTEHatchOutputBus implements IPowerChannelState {

    // 使用 2^1024 作为 baseCapacity 的值
    private BigInteger baseCapacity = BigInteger.valueOf(2)
        .pow(1024);

    private BaseActionSource requestSource = null;
    private @Nullable AENetworkProxy gridProxy = null;
    final IItemList<IAEFluidStack> fluidCache = AEApi.instance()
        .storage()
        .createFluidList();
    final IItemList<IAEItemStack> itemCache = AEApi.instance()
        .storage()
        .createItemList();
    long lastOutputTick = 0;
    long lastInputTick = 0;
    long tickCounter = 0;
    boolean additionalConnection = false;

    public MTEIntegratedOutputHatchME(int aID, String aName, String aNameRegional, int aTier) {
        super(
            aID,
            aName,
            aNameRegional,
            aTier,
            new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                    + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") },
            getSlots(aTier));
    }

    public MTEIntegratedOutputHatchME(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, getSlots(aTier), aDescription, aTextures);
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEIntegratedOutputHatchME(mName, mTier, mDescriptionArray, mTextures);
    }

    @Override
    public ITexture[] getTexturesActive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, TextureFactory.of(OVERLAY_ME_HATCH_ACTIVE) };
    }

    @Override
    public ITexture[] getTexturesInactive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, TextureFactory.of(OVERLAY_ME_HATCH) };
    }

    @Override
    public void onFirstTick(IGregTechTileEntity aBaseMetaTileEntity) {
        super.onFirstTick(aBaseMetaTileEntity);
        getProxy().onReady();
    }

    @Override
    public boolean storeAll(ItemStack aStack) {
        aStack.stackSize = store(aStack);
        return aStack.stackSize == 0;
    }

    @Override
    public int fill(FluidStack aFluid, boolean doFill) {
        if (doFill) {
            return tryFillAE(aFluid);
        } else {
            if (aFluid == null) return 0;
            return aFluid.amount;
        }
    }

    private long getCachedFluidAmount() {
        long fluidAmount = 0;
        for (IAEFluidStack fluid : fluidCache) {
            fluidAmount += fluid.getStackSize();
        }
        return fluidAmount;
    }

    private long getCachedItemAmount() {
        long itemAmount = 0;
        for (IAEItemStack item : itemCache) {
            itemAmount += item.getStackSize();
        }
        return itemAmount;
    }

    private BigInteger getCacheCapacity() {
        return baseCapacity;
    }

    public boolean canAcceptFluid() {
        return BigInteger.valueOf(getCachedFluidAmount())
            .compareTo(getCacheCapacity()) < 0;
    }

    public boolean canAcceptItem() {
        return BigInteger.valueOf(getCachedItemAmount())
            .compareTo(getCacheCapacity()) < 0;
    }

    public int tryFillAE(final FluidStack aFluid) {
        if (aFluid == null) return 0;
        if (canAcceptFluid() || (lastInputTick == tickCounter)) {
            fluidCache.add(
                AEApi.instance()
                    .storage()
                    .createFluidStack(aFluid));
            lastInputTick = tickCounter;
            return aFluid.amount;
        }
        return 0;
    }

    public int store(final ItemStack stack) {
        if (canAcceptItem() || (lastInputTick == tickCounter)) {
            itemCache.add(
                AEApi.instance()
                    .storage()
                    .createItemStack(stack));
            lastInputTick = tickCounter;
            return 0;
        }
        return stack.stackSize;
    }

    private BaseActionSource getRequest() {
        if (requestSource == null) requestSource = new MachineSource((IActionHost) getBaseMetaTileEntity());
        return requestSource;
    }

    @Override
    public AECableType getCableConnectionType(ForgeDirection side) {
        return isOutputFacing(side) ? AECableType.SMART : AECableType.NONE;
    }

    private void updateValidGridProxySides() {
        if (additionalConnection) {
            getProxy().setValidSides(EnumSet.complementOf(EnumSet.of(ForgeDirection.UNKNOWN)));
        } else {
            getProxy().setValidSides(EnumSet.of(getBaseMetaTileEntity().getFrontFacing()));
        }
    }

    @Override
    public void onFacingChange() {
        updateValidGridProxySides();
    }

    @Override
    public void onScrewdriverRightClick(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ) {
        getBaseMetaTileEntity().getCoverInfoAtSide(side)
            .isGUIClickable();
    }

    @Override
    public boolean onWireCutterRightClick(ForgeDirection side, ForgeDirection wrenchingSide, EntityPlayer aPlayer,
        float aX, float aY, float aZ) {
        additionalConnection = !additionalConnection;
        updateValidGridProxySides();
        aPlayer.addChatComponentMessage(
            new ChatComponentTranslation("GT5U.hatch.additionalConnection." + additionalConnection));
        return true;
    }

    @Override
    public boolean onRightclick(IGregTechTileEntity aBaseMetaTileEntity, EntityPlayer aPlayer) {
        if (!aBaseMetaTileEntity.isServerSide()) {
            return false; // 只在服务器端处理
        }
        Map<String, Long> fluidMap = getCachedFluids();
        Map<String, Long> itemMap = getCachedItems();

        for (Map.Entry<String, Long> entry : fluidMap.entrySet()) {
            aPlayer.addChatComponentMessage(new ChatComponentText(entry.getKey() + ": " + entry.getValue() + " mB"));
        }
        for (Map.Entry<String, Long> entry : itemMap.entrySet()) {
            aPlayer.addChatComponentMessage(new ChatComponentText(entry.getKey() + ": " + entry.getValue() + " items"));
        }
        return true;
    }

    private Map<String, Long> getCachedItems() {
        Map<String, Long> itemMap = new HashMap<>();
        for (IAEItemStack item : itemCache) {
            String itemName = item.getItem()
                .getItemStackDisplayName(item.getItemStack());
            long itemCount = item.getStackSize();
            itemMap.put(itemName, itemMap.getOrDefault(itemName, 0L) + itemCount);
        }
        return itemMap;
    }

    private Map<String, Long> getCachedFluids() {
        Map<String, Long> fluidMap = new HashMap<>();
        for (IAEFluidStack fluid : fluidCache) {
            String fluidName = fluid.getFluid()
                .getLocalizedName(fluid.getFluidStack());
            long fluidAmount = fluid.getStackSize();
            fluidMap.put(fluidName, fluidMap.getOrDefault(fluidName, 0L) + fluidAmount);
        }
        return fluidMap;
    }

    @Override
    public AENetworkProxy getProxy() {
        if (gridProxy == null) {
            if (getBaseMetaTileEntity() instanceof IGridProxyable) {
                gridProxy = new AENetworkProxy(
                    (IGridProxyable) getBaseMetaTileEntity(),
                    "proxy",
                    ItemList.Hatch_Output_ME.get(1),
                    true);
                gridProxy.setFlags(GridFlags.REQUIRE_CHANNEL);
                updateValidGridProxySides();
                if (getBaseMetaTileEntity().getWorld() != null) gridProxy.setOwner(
                    getBaseMetaTileEntity().getWorld()
                        .getPlayerEntityByName(getBaseMetaTileEntity().getOwnerName()));
            }
        }
        return this.gridProxy;
    }

    private void flushCachedStack() {
        if (fluidCache.isEmpty() && itemCache.isEmpty()) return;
        AENetworkProxy proxy = getProxy();
        if (proxy == null) {
            return;
        }
        try {
            IMEMonitor<IAEFluidStack> fluidMonitor = proxy.getStorage()
                .getFluidInventory();
            IMEMonitor<IAEItemStack> itemMonitor = proxy.getStorage()
                .getItemInventory();
            for (IAEFluidStack s : fluidCache) {
                if (s.getStackSize() == 0) continue;
                IAEFluidStack rest = fluidAEInsert(proxy.getEnergy(), fluidMonitor, s, getRequest());
                if (rest != null && rest.getStackSize() > 0) {
                    s.setStackSize(rest.getStackSize());
                    continue;
                }
                s.setStackSize(0);
            }
            for (IAEItemStack s : itemCache) {
                if (s.getStackSize() == 0) continue;
                IAEItemStack rest = Platform.poweredInsert(proxy.getEnergy(), itemMonitor, s, getRequest());
                if (rest != null && rest.getStackSize() > 0) {
                    s.setStackSize(rest.getStackSize());
                    break;
                }
                s.setStackSize(0);
            }
        } catch (final GridAccessException ignored) {}
        lastOutputTick = tickCounter;
    }

    @Override
    public boolean isPowered() {
        return getProxy() != null && getProxy().isPowered();
    }

    @Override
    public boolean isActive() {
        return getProxy() != null && getProxy().isActive();
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        if (getBaseMetaTileEntity().isServerSide()) {
            tickCounter = aTick;
            if (tickCounter > (lastOutputTick + 40)) flushCachedStack();
            if (tickCounter % 20 == 0) getBaseMetaTileEntity().setActive(isActive());
        }
        super.onPostTick(aBaseMetaTileEntity, aTick);
    }

    @Override
    public void addAdditionalTooltipInformation(ItemStack stack, List<String> tooltip) {
        if (stack.hasTagCompound() && stack.stackTagCompound.hasKey("baseCapacity")) {
            tooltip.add(
                "Current cache capacity: " + EnumChatFormatting.YELLOW
                    + ReadableNumberConverter.INSTANCE.toWideReadableForm(
                        new BigInteger(stack.stackTagCompound.getString("baseCapacity")).longValue())
                    + "L");
        }
    }

    @Override
    public boolean isGivingInformation() {
        return true;
    }

    @Override
    public String[] getInfoData() {
        List<String> ss = new ArrayList<>();
        ss.add(
            "The hatch is " + ((getProxy() != null && getProxy().isActive()) ? EnumChatFormatting.GREEN + "online"
                : EnumChatFormatting.RED + "offline" + getAEDiagnostics()) + EnumChatFormatting.RESET);
        IWideReadableNumberConverter nc = ReadableNumberConverter.INSTANCE;

        BigInteger cacheCapacity = baseCapacity.compareTo(
            BigInteger.valueOf(2)
                .pow(1024))
            > 0 ? BigInteger.valueOf(2)
                .pow(1024) : baseCapacity;

        ss.add("Cache capacity: " + nc.toWideReadableForm(cacheCapacity.longValue()) + " units");

        if (fluidCache.isEmpty() && itemCache.isEmpty()) {
            ss.add("The hatch has no cached fluids or items");
        } else {
            if (!fluidCache.isEmpty()) {
                ss.add(String.format("The hatch contains %d cached fluids: ", fluidCache.size()));
                for (IAEFluidStack s : fluidCache) {
                    ss.add(
                        s.getFluidStack()
                            .getLocalizedName() + ": "
                            + EnumChatFormatting.GOLD
                            + nc.toWideReadableForm(s.getStackSize())
                            + " mB"
                            + EnumChatFormatting.RESET);
                }
            }
            if (!itemCache.isEmpty()) {
                ss.add(String.format("The hatch contains %d cached item stacks: ", itemCache.size()));
                for (IAEItemStack s : itemCache) {
                    ss.add(
                        s.getItemStack()
                            .getDisplayName() + ": "
                            + EnumChatFormatting.GOLD
                            + nc.toWideReadableForm(s.getStackSize())
                            + EnumChatFormatting.RESET);
                }
            }
        }
        return ss.toArray(new String[0]);
    }

    @Override
    public void setItemNBT(NBTTagCompound aNBT) {
        super.setItemNBT(aNBT);
        aNBT.setString("baseCapacity", baseCapacity.toString());
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
        NBTTagList fluids = new NBTTagList();
        for (IAEFluidStack s : fluidCache) {
            if (s.getStackSize() == 0) continue;
            NBTTagCompound tag = new NBTTagCompound();
            NBTTagCompound tagFluidStack = new NBTTagCompound();
            s.getFluidStack()
                .writeToNBT(tagFluidStack);
            tag.setTag("fluidStack", tagFluidStack);
            tag.setLong("size", s.getStackSize());
            fluids.appendTag(tag);
        }
        aNBT.setTag("cachedFluids", fluids);

        NBTTagList items = new NBTTagList();
        for (IAEItemStack s : itemCache) {
            if (s.getStackSize() == 0) continue;
            NBTTagCompound tag = new NBTTagCompound();
            tag.setTag("itemStack", GTUtility.saveItem(s.getItemStack()));
            tag.setLong("size", s.getStackSize());
            items.appendTag(tag);
        }
        aNBT.setTag("cachedItems", items);

        aNBT.setBoolean("additionalConnection", additionalConnection);
        aNBT.setString("baseCapacity", baseCapacity.toString());
        getProxy().writeToNBT(aNBT);
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);

        NBTBase t = aNBT.getTag("cachedStack"); // legacy
        if (t instanceof NBTTagCompound) itemCache.add(
            AEApi.instance()
                .storage()
                .createItemStack(GTUtility.loadItem((NBTTagCompound) t)));
        t = aNBT.getTag("cachedItems");
        if (t instanceof NBTTagList l) {
            for (int i = 0; i < l.tagCount(); ++i) {
                NBTTagCompound tag = l.getCompoundTagAt(i);
                if (!tag.hasKey("itemStack")) { // legacy #868
                    itemCache.add(
                        AEApi.instance()
                            .storage()
                            .createItemStack(GTUtility.loadItem(l.getCompoundTagAt(i))));
                    continue;
                }
                NBTTagCompound tagItemStack = tag.getCompoundTag("itemStack");
                final IAEItemStack s = AEApi.instance()
                    .storage()
                    .createItemStack(GTUtility.loadItem(tagItemStack));
                if (s != null) {
                    s.setStackSize(tag.getLong("size"));
                    itemCache.add(s);
                } else {
                    GTMod.GT_FML_LOGGER.warn(
                        "An error occurred while loading contents of ME Output Hatch. This item has been voided: "
                            + tagItemStack);
                }
            }
        }

        NBTBase fluidTag = aNBT.getTag("cachedFluids");
        if (fluidTag instanceof NBTTagList l) {
            for (int i = 0; i < l.tagCount(); ++i) {
                NBTTagCompound tag = l.getCompoundTagAt(i);
                NBTTagCompound tagFluidStack = tag.getCompoundTag("fluidStack");
                final IAEFluidStack s = AEApi.instance()
                    .storage()
                    .createFluidStack(GTUtility.loadFluid(tagFluidStack));
                if (s != null) {
                    s.setStackSize(tag.getLong("size"));
                    fluidCache.add(s);
                } else {
                    GTMod.GT_FML_LOGGER.warn(
                        "An error occurred while loading contents of ME Output Hatch. This fluid has been voided: "
                            + tagFluidStack);
                }
            }
        }

        additionalConnection = aNBT.getBoolean("additionalConnection");
        baseCapacity = new BigInteger(aNBT.getString("baseCapacity"));
        if (baseCapacity.equals(BigInteger.ZERO)) {
            baseCapacity = BigInteger.valueOf(2)
                .pow(1024);
        }
        getProxy().readFromNBT(aNBT);
    }
}
