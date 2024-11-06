package com.science.gtnl.common.machine;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import com.glodblock.github.common.item.FCBaseItemCell;
import com.glodblock.github.common.storage.IStorageFluidCell;

import appeng.api.AEApi;
import appeng.api.storage.data.IAEFluidStack;
import appeng.api.storage.data.IItemList;
import appeng.util.IWideReadableNumberConverter;
import appeng.util.ReadableNumberConverter;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.common.tileentities.machines.MTEHatchOutputME;

public class MTEInfinityHatchOutputME extends MTEHatchOutputME {

    private final BigInteger baseCapacity;

    public MTEInfinityHatchOutputME(int aID, String aName, String aNameRegional) {
        super(
            aID,
            aName,
            aNameRegional);
        this.baseCapacity = BigInteger.valueOf(2)
            .pow(1024);
    }

    public MTEInfinityHatchOutputME(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, aDescription, aTextures);
        this.baseCapacity = BigInteger.valueOf(2)
            .pow(1024);
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEInfinityHatchOutputME(mName, mTier, mDescriptionArray, mTextures);
    }

    private BigInteger getCacheCapacity() {
        ItemStack upgradeItemStack = mInventory[0];
        if (upgradeItemStack != null && upgradeItemStack.getItem() instanceof IStorageFluidCell) {
            return BigInteger.valueOf(((FCBaseItemCell) upgradeItemStack.getItem()).getBytes(upgradeItemStack))
                .multiply(BigInteger.valueOf(2048));
        }
        return baseCapacity;
    }

    private long getParentCachedAmount() {
        try {
            Method method = MTEHatchOutputME.class.getDeclaredMethod("getCachedAmount");
            method.setAccessible(true);
            return (long) method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private IItemList<IAEFluidStack> getParentFluidCache() {
        try {
            Field field = MTEHatchOutputME.class.getDeclaredField("fluidCache");
            field.setAccessible(true);
            return (IItemList<IAEFluidStack>) field.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return AEApi.instance()
                .storage()
                .createFluidList();
        }
    }

    @Override
    public boolean canAcceptFluid() {
        return BigInteger.valueOf(getParentCachedAmount())
            .compareTo(getCacheCapacity()) < 0;
    }

    @Override
    public boolean onRightclick(IGregTechTileEntity aBaseMetaTileEntity, EntityPlayer aPlayer) {
        List<String> fluidInfo = new ArrayList<>();
        fluidInfo.add(
            "The bus is " + ((getProxy() != null && getProxy().isActive()) ? EnumChatFormatting.GREEN + "online"
                : EnumChatFormatting.RED + "offline") + EnumChatFormatting.RESET);
        IWideReadableNumberConverter nc = ReadableNumberConverter.INSTANCE;

        BigInteger cacheCapacity = baseCapacity;
        fluidInfo.add("Fluid cache capacity: " + nc.toWideReadableForm(cacheCapacity.longValue()) + " mB");

        IItemList<IAEFluidStack> fluidCache = getParentFluidCache();

        if (fluidCache.isEmpty()) {
            fluidInfo.add("The bus has no cached fluids");
        } else {
            fluidInfo.add(String.format("The bus contains %d cached fluids: ", fluidCache.size()));
            int counter = 0;
            for (IAEFluidStack s : fluidCache) {
                fluidInfo.add(
                    s.getFluidStack()
                        .getLocalizedName() + ": "
                        + EnumChatFormatting.GOLD
                        + nc.toWideReadableForm(s.getStackSize())
                        + " mB"
                        + EnumChatFormatting.RESET);
                if (++counter > 100) break;
            }
        }

        for (String info : fluidInfo) {
            aPlayer.addChatMessage(new ChatComponentText(info));
        }

        return true;
    }
}
