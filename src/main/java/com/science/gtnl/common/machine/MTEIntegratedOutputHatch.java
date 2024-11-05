package com.science.gtnl.common.machine;

import static gregtech.api.enums.Textures.BlockIcons.*;
import static gregtech.api.util.GTUtility.moveMultipleItemStacks;

import java.lang.ref.WeakReference;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

import com.gtnewhorizons.modularui.api.forge.ItemHandlerHelper;
import com.gtnewhorizons.modularui.api.math.Alignment;
import com.gtnewhorizons.modularui.api.screen.ModularWindow;
import com.gtnewhorizons.modularui.api.screen.UIBuildContext;
import com.gtnewhorizons.modularui.common.widget.DrawableWidget;
import com.gtnewhorizons.modularui.common.widget.FakeSyncWidget;
import com.gtnewhorizons.modularui.common.widget.TextWidget;

import gregtech.GTMod;
import gregtech.api.enums.ItemList;
import gregtech.api.gui.modularui.GTUITextures;
import gregtech.api.gui.widgets.PhantomItemButton;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.fluid.IFluidStore;
import gregtech.api.interfaces.metatileentity.IFluidLockable;
import gregtech.api.interfaces.metatileentity.IItemLockable;
import gregtech.api.interfaces.modularui.IAddUIWidgets;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.MTEHatch;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTUtility;
import gregtech.common.gui.modularui.widget.FluidLockWidget;

public class MTEIntegratedOutputHatch extends MTEHatch
    implements IFluidStore, IFluidLockable, IItemLockable, IAddUIWidgets {

    private String lockedFluidName = null;
    private ItemStack lockedItem = null;
    private WeakReference<EntityPlayer> playerThatLockedfluid = null;
    public byte mMode = 0;
    private static final String DATA_STICK_DATA_TYPE = "outputBusFilter";
    private static final String LOCKED_ITEM_NBT_KEY = "lockedItem";

    public MTEIntegratedOutputHatch(int aID, String aName, String aNameRegional, int aTier, String[] strings) {
        super(
            aID,
            aName,
            aNameRegional,
            aTier,
            getSlots(aTier),
            new String[] { "Item and Fluid Output for Multiblocks",
                "Item Capacity: " + getSlots(aTier) + " stack" + (getSlots(aTier) >= 2 ? "s" : ""),
                "Fluid Capacity: " + GTUtility.formatNumbers(8000L * (1L << aTier)) + "L",
                "Right click with screwdriver to restrict output", "Left click with data stick to save filter config",
                "Right click with data stick to load filter config",
                "Can be restricted to output Items and/or specific Fluids",
                "Restricted Output Hatches are given priority for Multiblock output" });
    }

    public MTEIntegratedOutputHatch(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, getSlots(aTier), aDescription, aTextures);
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEIntegratedOutputHatch(mName, mTier, mDescriptionArray, mTextures);
    }

    @Override
    public ITexture[] getTexturesActive(ITexture aBaseTexture) {
        return GTMod.gregtechproxy.mRenderIndicatorsOnHatch
            ? new ITexture[] { aBaseTexture, TextureFactory.of(OVERLAY_PIPE_OUT), TextureFactory.of(FLUID_OUT_SIGN),
                TextureFactory.of(ITEM_OUT_SIGN) }
            : new ITexture[] { aBaseTexture, TextureFactory.of(OVERLAY_PIPE_OUT) };
    }

    @Override
    public ITexture[] getTexturesInactive(ITexture aBaseTexture) {
        return GTMod.gregtechproxy.mRenderIndicatorsOnHatch
            ? new ITexture[] { aBaseTexture, TextureFactory.of(OVERLAY_PIPE_OUT), TextureFactory.of(FLUID_OUT_SIGN),
                TextureFactory.of(ITEM_OUT_SIGN) }
            : new ITexture[] { aBaseTexture, TextureFactory.of(OVERLAY_PIPE_OUT) };
    }

    @Override
    public boolean isSimpleMachine() {
        return true;
    }

    @Override
    public boolean isFacingValid(ForgeDirection facing) {
        return true;
    }

    @Override
    public boolean isAccessAllowed(EntityPlayer aPlayer) {
        return true;
    }

    @Override
    public boolean isValidSlot(int aIndex) {
        return true;
    }

    @Override
    public boolean onRightclick(IGregTechTileEntity aBaseMetaTileEntity, EntityPlayer aPlayer, ForgeDirection side,
        float aX, float aY, float aZ) {
        if (tryToLockHatch(aPlayer, side)) return true;
        return super.onRightclick(aBaseMetaTileEntity, aPlayer, side, aX, aY, aZ);
    }

    @Override
    public void onLeftclick(IGregTechTileEntity aBaseMetaTileEntity, EntityPlayer aPlayer) {
        if (!acceptsItemLock() || !(aPlayer instanceof EntityPlayerMP)) {
            return;
        }
        final ItemStack dataStick = aPlayer.inventory.getCurrentItem();
        if (!ItemList.Tool_DataStick.isStackEqual(dataStick, false, true)) {
            return;
        }

        dataStick.stackTagCompound = getCopiedData(aPlayer);
        dataStick.setStackDisplayName("Output Bus Configuration");
        aPlayer.addChatMessage(new ChatComponentTranslation("GT5U.machines.output_bus.saved"));
    }

    public boolean storeAll(ItemStack aStack) {
        markDirty();

        if (lockedItem != null && !lockedItem.isItemEqual(aStack)) {
            return false;
        }

        for (int i = 0, mInventoryLength = mInventory.length; i < mInventoryLength && aStack.stackSize > 0; i++) {
            ItemStack tSlot = mInventory[i];
            if (GTUtility.isStackInvalid(tSlot)) {
                int tRealStackLimit = Math.min(getInventoryStackLimit(), aStack.getMaxStackSize());
                if (aStack.stackSize <= tRealStackLimit) {
                    mInventory[i] = aStack;
                    return true;
                }
                mInventory[i] = aStack.splitStack(tRealStackLimit);
            } else {
                int tRealStackLimit = Math.min(getInventoryStackLimit(), tSlot.getMaxStackSize());
                if (tSlot.stackSize < tRealStackLimit && tSlot.isItemEqual(aStack)
                    && ItemStack.areItemStackTagsEqual(tSlot, aStack)) {
                    if (aStack.stackSize + tSlot.stackSize <= tRealStackLimit) {
                        mInventory[i].stackSize += aStack.stackSize;
                        return true;
                    } else {
                        aStack.stackSize -= tRealStackLimit - tSlot.stackSize;
                        mInventory[i].stackSize = tRealStackLimit;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);
        if (aBaseMetaTileEntity.isServerSide() && aBaseMetaTileEntity.isAllowedToWork() && (aTick & 0x7) == 0) {
            final IInventory inventoryEntity = aBaseMetaTileEntity
                .getIInventoryAtSide(aBaseMetaTileEntity.getFrontFacing());
            if (inventoryEntity != null) {
                moveMultipleItemStacks(
                    aBaseMetaTileEntity,
                    inventoryEntity,
                    aBaseMetaTileEntity.getFrontFacing(),
                    aBaseMetaTileEntity.getBackFacing(),
                    null,
                    false,
                    (byte) 64,
                    (byte) 1,
                    (byte) 64,
                    (byte) 1,
                    mInventory.length);
                for (int i = 0; i < mInventory.length; i++) {
                    if (mInventory[i] != null && mInventory[i].stackSize <= 0) mInventory[i] = null;
                }
            }

            if (mFluid != null) {
                IFluidHandler fluidEntity = aBaseMetaTileEntity
                    .getITankContainerAtSide(aBaseMetaTileEntity.getFrontFacing());
                if (fluidEntity != null) {
                    GTUtility.moveFluid(
                        aBaseMetaTileEntity,
                        fluidEntity,
                        aBaseMetaTileEntity.getFrontFacing(),
                        Math.max(1, mFluid.amount),
                        null);
                }
            }
        }
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
        aNBT.setByte("mMode", mMode);
        if (isFluidLocked() && lockedFluidName != null && lockedFluidName.length() != 0) {
            aNBT.setString("lockedFluidName", lockedFluidName);
        } else {
            aNBT.removeTag("lockedFluidName");
        }
        if (lockedItem != null) {
            aNBT.setTag(LOCKED_ITEM_NBT_KEY, lockedItem.writeToNBT(new NBTTagCompound()));
        }
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        mMode = aNBT.getByte("mMode");
        if (isFluidLocked()) {
            lockedFluidName = aNBT.getString("lockedFluidName");
        }
        lockedFluidName = GTUtility.isStringInvalid(lockedFluidName) ? null : lockedFluidName;
        if (aNBT.hasKey(LOCKED_ITEM_NBT_KEY)) {
            lockedItem = ItemStack.loadItemStackFromNBT(aNBT.getCompoundTag(LOCKED_ITEM_NBT_KEY));
        }
    }

    @Override
    public void addUIWidgets(ModularWindow.Builder builder, UIBuildContext buildContext) {
        switch (mTier) {
            case 0 -> getBaseMetaTileEntity().add1by1Slot(builder);
            case 1 -> getBaseMetaTileEntity().add2by2Slots(builder);
            case 2 -> getBaseMetaTileEntity().add3by3Slots(builder);
            default -> getBaseMetaTileEntity().add4by4Slots(builder);
        }

        builder.widget(
            new DrawableWidget().setDrawable(GTUITextures.PICTURE_SCREEN_BLACK)
                .setPos(98, 16)
                .setSize(71, 45))
            .widget(new FluidLockWidget(this).setPos(149, 41))
            .widget(
                new PhantomItemButton(this).setPos(getGUIWidth() - 25, 40)
                    .setBackground(PhantomItemButton.FILTER_BACKGROUND))
            .widget(
                new TextWidget("Locked Fluid").setDefaultColor(COLOR_TEXT_WHITE.get())
                    .setPos(101, 20))
            .widget(TextWidget.dynamicString(() -> {
                FluidStack fluidStack = FluidRegistry.getFluidStack(lockedFluidName, 1);
                return fluidStack != null ? fluidStack.getLocalizedName() : "None";
            })
                .setDefaultColor(COLOR_TEXT_WHITE.get())
                .setTextAlignment(Alignment.CenterLeft)
                .setMaxWidth(65)
                .setPos(101, 30))
            .widget(new FakeSyncWidget.ByteSyncer(() -> mMode, val -> mMode = val));
    }

    private boolean tryToLockHatch(EntityPlayer aPlayer, ForgeDirection side) {
        if (!getBaseMetaTileEntity().getCoverInfoAtSide(side)
            .isGUIClickable()) return false;
        if (!isFluidLocked()) return false;
        final ItemStack tCurrentItem = aPlayer.inventory.getCurrentItem();
        if (tCurrentItem == null) return false;
        FluidStack tFluid = FluidContainerRegistry.getFluidForFilledItem(tCurrentItem);
        if (tFluid == null && tCurrentItem.getItem() instanceof IFluidContainerItem)
            tFluid = ((IFluidContainerItem) tCurrentItem.getItem()).getFluid(tCurrentItem);
        if (tFluid != null) {
            if (getLockedFluidName() != null && !getLockedFluidName().equals(
                tFluid.getFluid()
                    .getName())) {
                GTUtility.sendChatToPlayer(
                    aPlayer,
                    String.format(
                        "%s %s",
                        GTUtility.trans(
                            "151.3",
                            "Hatch is locked to a different fluid. To change the locking, empty it and make it locked to the next fluid with a screwdriver. Currently locked to"),
                        StatCollector.translateToLocal(getLockedFluidName())));
            } else {
                setLockedFluidName(
                    tFluid.getFluid()
                        .getName());
                if (mMode == 8) GTUtility.sendChatToPlayer(
                    aPlayer,
                    String.format(
                        "%s (%s)",
                        GTUtility.trans("151.1", "Outputs items and 1 specific Fluid"),
                        tFluid.getLocalizedName()));
                else GTUtility.sendChatToPlayer(
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

    public byte getMode() {
        return mMode;
    }

    public boolean outputsSteam() {
        return mMode < 4;
    }

    public boolean outputsLiquids() {
        return mMode % 2 == 0 || mMode == 9;
    }

    public boolean outputsItems() {
        return mMode % 4 < 2 && mMode != 9;
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
    public void lockFluid(boolean lock) {
        if (lock) {
            if (!isFluidLocked()) {
                this.mMode = 9;
                markDirty();
            }
        } else {
            this.mMode = 0;
            setLockedFluidName(null);
            markDirty();
        }
    }

    @Override
    public boolean isFluidLocked() {
        return mMode == 8 || mMode == 9;
    }

    @Override
    public boolean acceptsFluidLock(String name) {
        return true;
    }

    @Override
    public boolean isEmptyAndAcceptsAnyFluid() {
        return mMode == 0 && getFluidAmount() == 0;
    }

    @Override
    public boolean canStoreFluid(@Nonnull FluidStack fluidStack) {
        if (mFluid != null && !GTUtility.areFluidsEqual(mFluid, fluidStack)) {
            return false;
        }
        if (isFluidLocked()) {
            if (lockedFluidName == null) {
                return true;
            }
            return lockedFluidName.equals(
                fluidStack.getFluid()
                    .getName());
        }
        if (GTModHandler.isSteam(fluidStack)) {
            return outputsSteam();
        }
        return outputsLiquids();
    }

    @Override
    public int getTankPressure() {
        return +100;
    }

    @Override
    protected void onEmptyingContainerWhenEmpty() {
        if (this.lockedFluidName == null && this.mFluid != null && isFluidLocked()) {
            this.setLockedFluidName(
                this.mFluid.getFluid()
                    .getName());
            final EntityPlayer player;
            if (playerThatLockedfluid == null || (player = playerThatLockedfluid.get()) == null) return;
            GTUtility.sendChatToPlayer(
                player,
                String.format(GTUtility.trans("151.4", "Successfully locked Fluid to %s"), mFluid.getLocalizedName()));
            playerThatLockedfluid = null;
        }
    }

    @Override
    public boolean isGivingInformation() {
        return true;
    }

    @Override
    public String[] getInfoData() {
        return new String[] { EnumChatFormatting.BLUE + "Integrated Output Hatch" + EnumChatFormatting.RESET,
            "Stored Fluid:",
            EnumChatFormatting.GOLD + (mFluid == null ? "No Fluid" : mFluid.getLocalizedName())
                + EnumChatFormatting.RESET,
            EnumChatFormatting.GREEN + GTUtility.formatNumbers(mFluid == null ? 0 : mFluid.amount)
                + " L"
                + EnumChatFormatting.RESET
                + " "
                + EnumChatFormatting.YELLOW
                + GTUtility.formatNumbers(getCapacity())
                + " L"
                + EnumChatFormatting.RESET,
            (!isFluidLocked() || lockedFluidName == null) ? "Not Locked"
                : ("Locked to " + StatCollector.translateToLocal(
                    FluidRegistry.getFluidStack(lockedFluidName, 1)
                        .getUnlocalizedName())) };
    }

    @Override
    public boolean acceptsItemLock() {
        return true;
    }

    @Override
    public void setLockedItem(@Nullable ItemStack itemStack) {
        if (itemStack == null) {
            clearLock();
        } else {
            lockedItem = ItemHandlerHelper.copyStackWithSize(itemStack, 1);
        }
    }

    @Nullable
    @Override
    public ItemStack getLockedItem() {
        return lockedItem;
    }

    @Override
    public void clearLock() {
        lockedItem = null;
    }

    @Override
    public boolean isLocked() {
        return lockedItem != null;
    }

    public NBTTagCompound getCopiedData(EntityPlayer player) {
        final NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("type", DATA_STICK_DATA_TYPE);
        if (lockedItem != null) {
            nbt.setTag(LOCKED_ITEM_NBT_KEY, lockedItem.writeToNBT(new NBTTagCompound()));
        }
        return nbt;
    }

    public boolean pasteCopiedData(EntityPlayer player, NBTTagCompound nbt) {
        if (nbt == null || !DATA_STICK_DATA_TYPE.equals(nbt.getString("type"))) return false;
        if (nbt.hasKey(LOCKED_ITEM_NBT_KEY)) {
            lockedItem = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag(LOCKED_ITEM_NBT_KEY));
        } else {
            lockedItem = null;
        }
        return true;
    }

    public String getCopiedDataIdentifier(EntityPlayer player) {
        return DATA_STICK_DATA_TYPE;
    }
}
