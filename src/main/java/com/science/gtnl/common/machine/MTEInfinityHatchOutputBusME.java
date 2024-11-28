package com.science.gtnl.common.machine;

import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_ME_HATCH;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_ME_HATCH_ACTIVE;
import static net.minecraft.util.StatCollector.translateToLocal;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

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

import com.science.gtnl.Utils.TextUtils;

import appeng.api.AEApi;
import appeng.api.implementations.IPowerChannelState;
import appeng.api.networking.GridFlags;
import appeng.api.networking.security.BaseActionSource;
import appeng.api.networking.security.IActionHost;
import appeng.api.networking.security.MachineSource;
import appeng.api.storage.IMEMonitor;
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
import journeymap.shadow.org.jetbrains.annotations.NotNull;

public class MTEInfinityHatchOutputBusME extends MTEHatchOutputBus implements IPowerChannelState {

    public BigInteger baseCapacity = BigInteger.valueOf(2)
        .pow(1024);

    public BaseActionSource requestSource = null;
    public @Nullable AENetworkProxy gridProxy = null;
    final IItemList<IAEItemStack> itemCache = AEApi.instance()
        .storage()
        .createItemList();
    long lastOutputTick = 0;
    long lastInputTick = 0;
    long tickCounter = 0;
    boolean additionalConnection = false;

    public MTEInfinityHatchOutputBusME(int aID, String aName, String aNameRegional, int aTier) {
        super(
            aID,
            aName,
            aNameRegional,
            aTier,
            new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.InfinityOutputBusME.desc.0"),
                translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                    + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") },
            getSlots(aTier));
    }

    public MTEInfinityHatchOutputBusME(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, getSlots(aTier), aDescription, aTextures);
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEInfinityHatchOutputBusME(mName, mTier, mDescriptionArray, mTextures);
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

    public long getCachedAmount() {
        long itemAmount = 0;
        for (IAEItemStack item : itemCache) {
            itemAmount += item.getStackSize();
        }
        return itemAmount;
    }

    public BigInteger getCacheCapacity() {
        return baseCapacity;
    }

    /**
     * Check if the internal cache can still fit more items in it
     */
    public boolean canAcceptItem() {
        return BigInteger.valueOf(getCachedAmount())
            .compareTo(getCacheCapacity()) < 0;
    }

    /**
     * Attempt to store items in connected ME network. Returns how many items did not fit (if the network was down e.g.)
     *
     * @param stack input stack
     * @return amount of items left over
     */
    public int store(final ItemStack stack) {
        // Always allow insertion on the same tick so we can output the entire recipe
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

    public BaseActionSource getRequest() {
        if (requestSource == null) requestSource = new MachineSource((IActionHost) getBaseMetaTileEntity());
        return requestSource;
    }

    @Override
    public AECableType getCableConnectionType(ForgeDirection forgeDirection) {
        return isOutputFacing(forgeDirection) ? AECableType.SMART : AECableType.NONE;
    }

    public void updateValidGridProxySides() {
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

        List<String> itemInfo = getCachedItems();
        for (String info : itemInfo) {
            aPlayer.addChatComponentMessage(new ChatComponentText(info));
        }

        return true;
    }

    public IItemList<IAEItemStack> getParentItemCache() {
        try {
            Field field = MTEInfinityHatchOutputBusME.class.getDeclaredField("itemCache");
            field.setAccessible(true);
            return (IItemList<IAEItemStack>) field.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return AEApi.instance()
                .storage()
                .createItemList();
        }
    }

    public @NotNull List<String> getCachedItems() {
        List<String> itemInfo = new ArrayList<>();
        itemInfo.add(
            "The bus is " + ((getProxy() != null && getProxy().isActive()) ? EnumChatFormatting.GREEN + "online"
                : EnumChatFormatting.RED + "offline") + EnumChatFormatting.RESET);

        IItemList<IAEItemStack> itemCache = getParentItemCache();

        if (itemCache.isEmpty()) {
            itemInfo.add("The bus has no cached items");
        } else {
            itemInfo.add(String.format("The bus contains %d cached items: ", itemCache.size()));
            int counter = 0;
            for (IAEItemStack s : itemCache) {
                itemInfo.add(
                    s.getItemStack()
                        .getDisplayName() + ": "
                        + EnumChatFormatting.GOLD
                        + s.getStackSize()
                        + " items"
                        + EnumChatFormatting.RESET);
                if (++counter > 100) break;
            }
        }
        return itemInfo;
    }

    @Override
    public AENetworkProxy getProxy() {
        if (gridProxy == null) {
            if (getBaseMetaTileEntity() instanceof IGridProxyable) {
                gridProxy = new AENetworkProxy(
                    (IGridProxyable) getBaseMetaTileEntity(),
                    "proxy",
                    ItemList.Hatch_Output_Bus_ME.get(1),
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

    public void flushCachedStack() {
        AENetworkProxy proxy = getProxy();
        if (proxy == null) {
            return;
        }
        try {
            IMEMonitor<IAEItemStack> sg = proxy.getStorage()
                .getItemInventory();
            for (IAEItemStack s : itemCache) {
                if (s.getStackSize() == 0) continue;
                IAEItemStack rest = Platform.poweredInsert(proxy.getEnergy(), sg, s, getRequest());
                if (rest != null && rest.getStackSize() > 0) {
                    s.setStackSize(rest.getStackSize());
                    break;
                }
                s.setStackSize(0);
            }
        } catch (final GridAccessException ignored) {

        }
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
                        new BigInteger(stack.stackTagCompound.getString("baseCapacity")).longValue()));
        }
    }

    @Override
    public void setItemNBT(NBTTagCompound aNBT) {
        super.setItemNBT(aNBT);
        aNBT.setString("baseCapacity", baseCapacity.toString());
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);

        NBTTagList items = new NBTTagList();
        for (IAEItemStack s : itemCache) {
            if (s.getStackSize() == 0) continue;
            NBTTagCompound tag = new NBTTagCompound();
            tag.setTag("itemStack", GTUtility.saveItem(s.getItemStack()));
            tag.setLong("size", s.getStackSize());
            items.appendTag(tag);
        }
        aNBT.setBoolean("additionalConnection", additionalConnection);
        aNBT.setTag("cachedItems", items);
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
                        "An error occurred while loading contents of ME Output Bus. This item has been voided: "
                            + tagItemStack);
                }
            }
        }
        additionalConnection = aNBT.getBoolean("additionalConnection");
        baseCapacity = new BigInteger(aNBT.getString("baseCapacity"));
        // Set the base capacity of existing hatches to be 2^1024
        if (baseCapacity.equals(BigInteger.ZERO)) {
            baseCapacity = BigInteger.valueOf(2)
                .pow(1024);
        }
        getProxy().readFromNBT(aNBT);
    }

    @Override
    public boolean isGivingInformation() {
        return true;
    }

    @Override
    public String[] getInfoData() {
        List<String> ss = new ArrayList<>();
        ss.add(
            "The bus is " + ((getProxy() != null && getProxy().isActive()) ? EnumChatFormatting.GREEN + "online"
                : EnumChatFormatting.RED + "offline" + getAEDiagnostics()) + EnumChatFormatting.RESET);
        IWideReadableNumberConverter nc = ReadableNumberConverter.INSTANCE;

        // 获取并转换 BigInteger 值
        BigInteger cacheCapacity = baseCapacity.compareTo(
            BigInteger.valueOf(2)
                .pow(1024))
            > 0 ? BigInteger.valueOf(2)
                .pow(1024) : baseCapacity;

        ss.add("Item cache capacity: " + nc.toWideReadableForm(cacheCapacity.longValue()));
        if (itemCache.isEmpty()) {
            ss.add("The bus has no cached items");
        } else {
            ss.add(String.format("The bus contains %d cached stacks: ", itemCache.size()));
            int counter = 0;
            for (IAEItemStack s : itemCache) {
                ss.add(
                    s.getItem()
                        .getItemStackDisplayName(s.getItemStack()) + ": "
                        + EnumChatFormatting.GOLD
                        + nc.toWideReadableForm(s.getStackSize())
                        + EnumChatFormatting.RESET);
                if (++counter > 100) break;
            }
        }
        return ss.toArray(new String[itemCache.size() + 2]);
    }
}
