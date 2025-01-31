package com.science.gtnl.common.machine.multiMachineClasses;

import static gregtech.api.util.GTUtility.validMTEList;

import net.minecraft.item.ItemStack;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.science.gtnl.common.GTNLItemList;

import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.MTEHatchMaintenance;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.OverclockCalculator;

public abstract class GTMMultiMachineBase<T extends GTMMultiMachineBase<T>> extends MultiMachineBase<T> {

    protected int mCasing;
    protected int ParallelTier;
    protected static final String STRUCTURE_PIECE_MAIN = "main";
    protected static String[][] shape;
    protected int horizontalOffSet;
    protected int verticalOffSet;
    protected int depthOffSet;

    public GTMMultiMachineBase(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GTMMultiMachineBase(String aName) {
        super(aName);
    }

    @Override
    public boolean isEnablePerfectOverclock() {
        return false;
    }

    @Override
    public float getSpeedBonus() {
        return 1;
    }

    @Override
    public ProcessingLogic createProcessingLogic() {
        return new ProcessingLogic() {

            @NotNull
            @Override
            public OverclockCalculator createOverclockCalculator(@NotNull GTRecipe recipe) {
                return OverclockCalculator.ofNoOverclock(recipe)
                    .setEUtDiscount(0.8 - (ParallelTier / 50.0))
                    .setSpeedBoost(0.6 - (ParallelTier / 200.0));
            }
        }.setMaxParallelSupplier(this::getMaxParallelRecipes);
    }

    @Override
    public int getMaxParallelRecipes() {
        if (ParallelTier <= 1) {
            return 16;
        } else {
            return (int) Math.pow(4, ParallelTier - 2);
        }
    }

    public int getParallelTier(ItemStack inventory) {
        if (inventory == null) return 0;
        if (inventory.isItemEqual(GTNLItemList.LVParallelControllerCore.getInternalStack_unsafe())) {
            return 1;
        } else if (inventory.isItemEqual(GTNLItemList.MVParallelControllerCore.getInternalStack_unsafe())) {
            return 2;
        } else if (inventory.isItemEqual(GTNLItemList.HVParallelControllerCore.getInternalStack_unsafe())) {
            return 3;
        } else if (inventory.isItemEqual(GTNLItemList.EVParallelControllerCore.getInternalStack_unsafe())) {
            return 4;
        } else if (inventory.isItemEqual(GTNLItemList.IVParallelControllerCore.getInternalStack_unsafe())) {
            return 5;
        } else if (inventory.isItemEqual(GTNLItemList.LuVParallelControllerCore.getInternalStack_unsafe())) {
            return 6;
        } else if (inventory.isItemEqual(GTNLItemList.ZPMParallelControllerCore.getInternalStack_unsafe())) {
            return 7;
        } else if (inventory.isItemEqual(GTNLItemList.UVParallelControllerCore.getInternalStack_unsafe())) {
            return 8;
        } else if (inventory.isItemEqual(GTNLItemList.UHVParallelControllerCore.getInternalStack_unsafe())) {
            return 9;
        } else if (inventory.isItemEqual(GTNLItemList.UEVParallelControllerCore.getInternalStack_unsafe())) {
            return 10;
        } else if (inventory.isItemEqual(GTNLItemList.UIVParallelControllerCore.getInternalStack_unsafe())) {
            return 11;
        } else if (inventory.isItemEqual(GTNLItemList.UMVParallelControllerCore.getInternalStack_unsafe())) {
            return 12;
        } else if (inventory.isItemEqual(GTNLItemList.UXVParallelControllerCore.getInternalStack_unsafe())) {
            return 13;
        }
        return 0;
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, horizontalOffSet, verticalOffSet, depthOffSet);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        return survivialBuildPiece(
            STRUCTURE_PIECE_MAIN,
            stackSize,
            horizontalOffSet,
            verticalOffSet,
            depthOffSet,
            elementBudget,
            env,
            false,
            true);
    }

    @Override
    public boolean getDefaultHasMaintenanceChecks() {
        return true;
    }

    @Override
    public boolean shouldCheckMaintenance() {
        return true;
    }

    @Override
    public void checkMaintenance() {
        if (!shouldCheckMaintenance()) return;

        if (getRepairStatus() != getIdealStatus()) {
            for (MTEHatchMaintenance tHatch : validMTEList(mMaintenanceHatches)) {
                if (tHatch.mAuto) tHatch.autoMaintainance();
                if (tHatch.mWrench) mWrench = true;
                if (tHatch.mScrewdriver) mScrewdriver = true;
                if (tHatch.mSoftHammer) mSoftHammer = true;
                if (tHatch.mHardHammer) mHardHammer = true;
                if (tHatch.mSolderingTool) mSolderingTool = true;
                if (tHatch.mCrowbar) mCrowbar = true;

                tHatch.mWrench = false;
                tHatch.mScrewdriver = false;
                tHatch.mSoftHammer = false;
                tHatch.mHardHammer = false;
                tHatch.mSolderingTool = false;
                tHatch.mCrowbar = false;
            }
        }
    }
}
