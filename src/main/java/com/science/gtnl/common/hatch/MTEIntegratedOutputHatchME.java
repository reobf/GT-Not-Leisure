package com.science.gtnl.common.hatch;

import java.util.EnumSet;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.ForgeDirection;

import appeng.api.AEApi;
import appeng.api.networking.GridFlags;
import appeng.api.networking.security.BaseActionSource;
import appeng.api.networking.security.IActionHost;
import appeng.api.networking.security.MachineSource;
import appeng.api.storage.IMEMonitor;
import appeng.api.storage.data.IAEItemStack;
import appeng.api.storage.data.IItemList;
import appeng.me.GridAccessException;
import appeng.me.helpers.AENetworkProxy;
import appeng.me.helpers.IGridProxyable;
import appeng.util.Platform;
import gregtech.GTMod;
import gregtech.api.enums.ItemList;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.util.GTUtility;
import gregtech.common.tileentities.machines.MTEHatchOutputME;

public class MTEIntegratedOutputHatchME extends MTEHatchOutputME {

    public long baseCapacity;

    public BaseActionSource requestSource = null;
    public @Nullable AENetworkProxy gridProxy = null;
    final IItemList<IAEItemStack> itemCache = AEApi.instance()
        .storage()
        .createItemList();
    long lastOutputTick = 0;
    long lastInputTick = 0;
    long tickCounter = 0;
    boolean additionalConnection = false;

    // 构造函数，确保参数类型匹配父类的构造函数
    public MTEIntegratedOutputHatchME(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
        this.baseCapacity = Long.MAX_VALUE;
    }

    public MTEIntegratedOutputHatchME(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, aDescription, aTextures);
        this.baseCapacity = Long.MAX_VALUE;
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEIntegratedOutputHatchME(mName, mTier, mDescriptionArray, mTextures);
    }

    @Override
    public void onFirstTick(IGregTechTileEntity aBaseMetaTileEntity) {
        super.onFirstTick(aBaseMetaTileEntity);
        getProxy().onReady();
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
    public AENetworkProxy getProxy() {
        if (gridProxy == null) {
            if (getBaseMetaTileEntity() instanceof IGridProxyable) {
                gridProxy = new AENetworkProxy(
                    (IGridProxyable) getBaseMetaTileEntity(),
                    "proxy",
                    ItemList.Hatch_Output_Bus_ME.get(1),
                    true);
                gridProxy.setFlags(GridFlags.REQUIRE_CHANNEL);
                updateGridProxySides();
                if (getBaseMetaTileEntity().getWorld() != null) gridProxy.setOwner(
                    getBaseMetaTileEntity().getWorld()
                        .getPlayerEntityByName(getBaseMetaTileEntity().getOwnerName()));
            }
        }
        return this.gridProxy;
    }

    // 实现更新代理侧的逻辑
    public void updateGridProxySides() {
        if (additionalConnection) {
            getProxy().setValidSides(EnumSet.complementOf(EnumSet.of(ForgeDirection.UNKNOWN)));
        } else {
            getProxy().setValidSides(EnumSet.of(getBaseMetaTileEntity().getFrontFacing()));
        }
    }

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

    public boolean canAcceptItem() {
        return getCachedAmount() < baseCapacity;
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
        } catch (final GridAccessException ignored) {}
        lastOutputTick = tickCounter;
    }

    public BaseActionSource getRequest() {
        if (requestSource == null) requestSource = new MachineSource((IActionHost) getBaseMetaTileEntity());
        return requestSource;
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
        aNBT.setLong("baseCapacity", baseCapacity);
        getProxy().writeToNBT(aNBT);
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        NBTBase t = aNBT.getTag("cachedStack");
        if (t instanceof NBTTagCompound) itemCache.add(
            AEApi.instance()
                .storage()
                .createItemStack(GTUtility.loadItem((NBTTagCompound) t)));
        t = aNBT.getTag("cachedItems");
        if (t instanceof NBTTagList l) {
            for (int i = 0; l.tagCount() > i; i++) {
                NBTTagCompound tag = l.getCompoundTagAt(i);
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
        baseCapacity = aNBT.getLong("baseCapacity");
        if (baseCapacity == 0) {
            baseCapacity = Long.MAX_VALUE;
        }
        getProxy().readFromNBT(aNBT);
    }
}
