package com.science.gtnl.common.hatch;

import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_INPUT_HATCH_2x2;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

import com.cleanroommc.modularui.utils.fluid.FluidStackTank;
import com.gtnewhorizons.modularui.api.ModularUITextures;
import com.gtnewhorizons.modularui.api.math.Pos2d;
import com.gtnewhorizons.modularui.api.screen.ModularWindow;
import com.gtnewhorizons.modularui.api.screen.UIBuildContext;
import com.gtnewhorizons.modularui.common.widget.FluidSlotWidget;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.modularui.IAddUIWidgets;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.MTEHatchOutput;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GTUtility;

// 此处无法判断同一仓室下多个槽位，导致只能输出一种流体并填满第一个槽位，推测可能无法检查其他槽位
public class QuadrupleOutputHatch extends MTEHatchOutput implements IAddUIWidgets {

    public FluidStack[] mStoredFluid;
    public FluidStackTank[] fluidTanks;
    public int mCapacityPer;
    public byte mMode = 0;
    public String lockedFluidName = null;

    public QuadrupleOutputHatch(int aID, String aName, String aNameRegional, int aTier) {
        super(
            aID,
            aName,
            aNameRegional,
            aTier,
            new String[] { "Fluid Output for Multiblocks",
                "Capacity: " + GTUtility.formatNumbers(8000L * (1L << aTier)) + "L",
                "Right click with screwdriver to restrict output",
                "Can be restricted to put out Items and/or Steam/No Steam/1 specific Fluid",
                "Restricted Output Hatches are given priority for Multiblock Fluid output" },
            4);
        mStoredFluid = new FluidStack[4];
        fluidTanks = new FluidStackTank[4];
        mCapacityPer = getCapacityPerTank(aTier, 4);
        initializeFluidTanks(4);
    }

    public QuadrupleOutputHatch(String aName, int aSlot, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, 4, aTier, aDescription, aTextures);
        mStoredFluid = new FluidStack[4];
        fluidTanks = new FluidStackTank[4];
        mCapacityPer = getCapacityPerTank(aTier, 4);
        initializeFluidTanks(4);
    }

    public void initializeFluidTanks(int aSlot) {
        for (int i = 0; i < aSlot; i++) {
            final int index = i;
            fluidTanks[i] = new FluidStackTank(
                () -> mStoredFluid[index],
                fluid -> mStoredFluid[index] = fluid,
                mCapacityPer);
        }
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new QuadrupleOutputHatch(mName, getMaxType(), mTier, mDescriptionArray, mTextures);
    }

    public int getMaxType() {
        return mStoredFluid.length;
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
        aNBT.setByte("mMode", mMode);
        if (lockedFluidName != null && !lockedFluidName.isEmpty()) {
            aNBT.setString("lockedFluidName", lockedFluidName);
        } else {
            aNBT.removeTag("lockedFluidName");
        }
        if (mStoredFluid != null) {
            for (int i = 0; i < mStoredFluid.length; i++) {
                if (mStoredFluid[i] != null) {
                    aNBT.setTag("mFluid" + i, mStoredFluid[i].writeToNBT(new NBTTagCompound()));
                }
            }
        }
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        mMode = aNBT.getByte("mMode");
        lockedFluidName = aNBT.getString("lockedFluidName");
        if (lockedFluidName.isEmpty()) {
            lockedFluidName = null;
        }
        if (mStoredFluid != null) {
            for (int i = 0; i < mStoredFluid.length; i++) {
                if (aNBT.hasKey("mFluid" + i)) {
                    mStoredFluid[i] = FluidStack.loadFluidStackFromNBT(aNBT.getCompoundTag("mFluid" + i));
                }
            }
        }
    }

    public int getCapacityPerTank(int aTier, int aSlot) {
        return (int) (8000L * (1L << aTier) / aSlot);
    }

    @Override
    public FluidStack getFluid() {
        for (FluidStack tFluid : mStoredFluid) {
            if (tFluid != null && tFluid.amount > 0) return tFluid;
        }
        return null;
    }

    @Override
    public int fill(FluidStack aFluid, boolean doFill) {
        if (aFluid == null || aFluid.getFluid()
            .getID() <= 0 || aFluid.amount <= 0 || !canTankBeFilled() || !isFluidInputAllowed(aFluid)) return 0;

        int totalFilled = 0;

        for (int i = 0; i < mStoredFluid.length; i++) {
            if (mStoredFluid[i] != null && mStoredFluid[i].isFluidEqual(aFluid)) {
                int tFilled = Math.min(aFluid.amount - totalFilled, mCapacityPer - mStoredFluid[i].amount);
                if (doFill && tFilled > 0) {
                    mStoredFluid[i].amount += tFilled;
                    totalFilled += tFilled;
                    getBaseMetaTileEntity().markDirty();
                } else if (tFilled > 0) {
                    totalFilled += tFilled;
                }
                if (totalFilled >= aFluid.amount) return totalFilled;
            }
        }

        for (int i = 0; i < mStoredFluid.length; i++) {
            if (mStoredFluid[i] == null) {
                int tFilled = Math.min(aFluid.amount - totalFilled, mCapacityPer);
                if (doFill && tFilled > 0) {
                    mStoredFluid[i] = aFluid.copy();
                    mStoredFluid[i].amount = tFilled;
                    totalFilled += tFilled;
                    getBaseMetaTileEntity().markDirty();
                } else if (tFilled > 0) {
                    totalFilled += tFilled;
                }
                if (totalFilled >= aFluid.amount) return totalFilled;
            }
        }

        return totalFilled; // 返回已填充的流体总量
    }

    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
        if (getFluid() == null || !canTankBeEmptied()) return null;
        if (getFluid().amount <= 0 && isFluidChangingAllowed()) {
            setFluid(null, getFluidSlot(getFluid()));
            getBaseMetaTileEntity().markDirty();
            return null;
        }
        FluidStack tRemove = getFluid().copy();
        tRemove.amount = Math.min(maxDrain, tRemove.amount);
        if (doDrain) {
            getFluid().amount -= tRemove.amount;
            getBaseMetaTileEntity().markDirty();
        }
        if (getFluid() == null || getFluid().amount <= 0 && isFluidChangingAllowed()) {
            setFluid(null, getFluidSlot(getFluid())); // 使用getFluidSlot方法清空液体槽
            getBaseMetaTileEntity().markDirty();
        }
        return tRemove;
    }

    @Override
    public void onScrewdriverRightClick(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ) {
        if (!getBaseMetaTileEntity().getCoverInfoAtSide(side)
            .isGUIClickable()) return;
        if (aPlayer.isSneaking()) {
            mMode = (byte) ((mMode + 4) % 5);
        } else {
            mMode = (byte) ((mMode + 1) % 5);
        }
        switch (mMode) {
            case 0 -> {
                GTUtility.sendChatToPlayer(aPlayer, GTUtility.trans("108", "Outputs misc. Fluids, Steam, and Items"));
                this.setLockedFluidName(null);
            }
            case 1 -> {
                GTUtility.sendChatToPlayer(aPlayer, GTUtility.trans("109", "Outputs Steam and Items"));
                this.setLockedFluidName(null);
            }
            case 2 -> {
                GTUtility.sendChatToPlayer(aPlayer, GTUtility.trans("110", "Outputs Steam and misc. Fluids"));
                this.setLockedFluidName(null);
            }
            case 3 -> {
                GTUtility.sendChatToPlayer(aPlayer, GTUtility.trans("111", "Outputs Steam"));
                this.setLockedFluidName(null);
            }
            case 4 -> {
                GTUtility.sendChatToPlayer(aPlayer, GTUtility.trans("112", "Outputs only misc. Fluids"));
                this.setLockedFluidName(null);
            }
        }
    }

    public boolean hasFluid(FluidStack aFluid) {
        if (aFluid == null) return false;
        for (FluidStack tFluid : mStoredFluid) {
            if (aFluid.isFluidEqual(tFluid)) return true;
        }
        return false;
    }

    public int getFluidAmount(FluidStack tFluid) {
        int tSlot = getFluidSlot(tFluid);
        if (tSlot != -1) {
            return mStoredFluid[tSlot].amount;
        }
        return 0;
    }

    public void setFluid(FluidStack aFluid, int aSlot) {
        if (aSlot < 0 || aSlot >= getMaxType()) return;
        mStoredFluid[aSlot] = aFluid;
    }

    public void addFluid(FluidStack aFluid, int aSlot) {
        if (aSlot < 0 || aSlot >= getMaxType()) return;
        if (aFluid.equals(mStoredFluid[aSlot])) mStoredFluid[aSlot].amount += aFluid.amount;
        if (mStoredFluid[aSlot] == null) mStoredFluid[aSlot] = aFluid.copy();
    }

    public int getFluidSlot(FluidStack tFluid) {
        if (tFluid == null) return -1;
        for (int i = 0; i < mStoredFluid.length; i++) {
            if (isSlotMatchingFluid(i, tFluid)) return i;
        }
        return -1;
    }

    public boolean isSlotEmpty(int slot) {
        if (slot < 0 || slot >= mStoredFluid.length) return false;
        return mStoredFluid[slot] == null;
    }

    public boolean isSlotMatchingFluid(int slot, FluidStack fluid) {
        if (slot < 0 || slot >= mStoredFluid.length || fluid == null) return false;
        return fluid.isFluidEqual(mStoredFluid[slot]);
    }

    @Override
    public void addUIWidgets(ModularWindow.Builder builder, UIBuildContext buildContext) {
        final int SLOT_NUMBER = 4;
        final Pos2d[] positions = new Pos2d[] { new Pos2d(70, 25), new Pos2d(88, 25), new Pos2d(70, 43),
            new Pos2d(88, 43), };

        for (int i = 0; i < SLOT_NUMBER; i++) {
            builder.widget(
                new FluidSlotWidget(fluidTanks[i]).setBackground(ModularUITextures.FLUID_SLOT)
                    .setPos(positions[i]));
        }
    }

    @Override
    public void onPreTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        if (aBaseMetaTileEntity.isServerSide()) {
            mFluid = getFluid();
        }
        super.onPreTick(aBaseMetaTileEntity, aTick);
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);
        if (aBaseMetaTileEntity.isServerSide() && aBaseMetaTileEntity.isAllowedToWork() && mStoredFluid != null) {
            for (int i = 0; i < getMaxType(); i++) {
                if (mStoredFluid[i] != null && mStoredFluid[i].amount <= 0) {
                    mStoredFluid[i] = null;
                }
            }
        }
    }

    @Override
    public boolean isValidSlot(int aIndex) {
        return aIndex >= 4;
    }

    public boolean canTankBeFilled() {
        return true;
    }

    public boolean canTankBeEmptied() {
        return true;
    }

    public boolean isFluidChangingAllowed() {
        return true;
    }

    @Override
    public int getCapacity() {
        return mCapacityPer;
    }

    public boolean tryToLockHatch(EntityPlayer aPlayer, ForgeDirection side) {
        if (!getBaseMetaTileEntity().getCoverInfoAtSide(side)
            .isGUIClickable()) return false;
        if (lockedFluidName == null) return false;
        final ItemStack tCurrentItem = aPlayer.inventory.getCurrentItem();
        if (tCurrentItem == null) return false;
        FluidStack tFluid = FluidContainerRegistry.getFluidForFilledItem(tCurrentItem);
        if (tFluid == null && tCurrentItem.getItem() instanceof IFluidContainerItem)
            tFluid = ((IFluidContainerItem) tCurrentItem.getItem()).getFluid(tCurrentItem);
        if (tFluid != null) {
            if (lockedFluidName != null && !lockedFluidName.equals(
                tFluid.getFluid()
                    .getName())) {
                GTUtility.sendChatToPlayer(
                    aPlayer,
                    String.format(
                        "%s %s",
                        GTUtility.trans(
                            "151.3",
                            "Hatch is locked to a different fluid. To change the locking, empty it and made it locked to the next fluid with a screwdriver. Currently locked to"),
                        StatCollector.translateToLocal(lockedFluidName)));
            } else {
                lockedFluidName = tFluid.getFluid()
                    .getName();
                GTUtility.sendChatToPlayer(
                    aPlayer,
                    String.format(
                        "%s (%s)",
                        GTUtility.trans("151.2", "Outputs 1 specific Fluid"),
                        tFluid.getLocalizedName()));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean onRightclick(IGregTechTileEntity aBaseMetaTileEntity, EntityPlayer aPlayer, ForgeDirection side,
        float aX, float aY, float aZ) {
        if (tryToLockHatch(aPlayer, side)) return true;
        return super.onRightclick(aBaseMetaTileEntity, aPlayer, side, aX, aY, aZ);
    }

    @Override
    public String getLockedFluidName() {
        return lockedFluidName;
    }

    @Override
    public void setLockedFluidName(String lockedFluidName) {
        this.lockedFluidName = lockedFluidName;
        markDirty();
    }

    @Override
    public ITexture[] getTexturesActive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, TextureFactory.of(OVERLAY_INPUT_HATCH_2x2) };
    }

    @Override
    public ITexture[] getTexturesInactive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, TextureFactory.of(OVERLAY_INPUT_HATCH_2x2) };
    }

    // 其他自定义的方法和功能...

}
