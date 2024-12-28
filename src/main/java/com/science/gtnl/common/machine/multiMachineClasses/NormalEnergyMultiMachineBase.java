package com.science.gtnl.common.machine.multiMachineClasses;

import static com.science.gtnl.Utils.Utils.mergeArray;

import java.math.BigInteger;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.science.gtnl.misc.OverclockType;

import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.GTUtility;
import gregtech.api.util.OverclockCalculator;

public abstract class NormalEnergyMultiMachineBase<T extends NormalEnergyMultiMachineBase<T>>
    extends MultiMachineBase<T> {

    public NormalEnergyMultiMachineBase(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public NormalEnergyMultiMachineBase(String aName) {
        super(aName);
    }

    protected static final String ZERO_STRING = "0";

    protected boolean isRecipeProcessing = false;
    protected BigInteger costingEU = BigInteger.ZERO;
    protected String costingEUText = ZERO_STRING;
    protected int cycleNum = 4; // Default cycle number for multiple recipes

    @Override
    protected void startRecipeProcessing() {
        isRecipeProcessing = true;
        super.startRecipeProcessing();
    }

    @Override
    protected void endRecipeProcessing() {
        super.endRecipeProcessing();
        isRecipeProcessing = false;
    }

    @Override
    protected ProcessingLogic createProcessingLogic() {
        return new GTNL_ProcessingLogic() {

            @NotNull
            @Override
            public CheckRecipeResult process() {
                setEuModifier(getEuModifier());
                setSpeedBonus(getSpeedBonus());
                setOverclockType(
                    isEnablePerfectOverclock() ? OverclockType.PerfectOverclock : OverclockType.NormalOverclock);
                return super.process();
            }

            @Nonnull
            @Override
            protected OverclockCalculator createOverclockCalculator(@Nonnull GTRecipe recipe) {
                return super.createOverclockCalculator(recipe);
            }
        }.setMaxParallelSupplier(this::getLimitedMaxParallel);
    }

    @Nonnull
    @Override
    public CheckRecipeResult checkProcessing() {
        costingEU = BigInteger.ZERO;
        costingEUText = ZERO_STRING;

        boolean succeeded = false;
        CheckRecipeResult finalResult = CheckRecipeResultRegistry.SUCCESSFUL;
        for (int i = 0; i < cycleNum; i++) {
            CheckRecipeResult r = processOnce();
            if (!r.wasSuccessful()) {
                finalResult = r;
                break;
            }
            succeeded = true;
        }

        updateSlots();
        if (!succeeded) return finalResult;
        costingEUText = GTUtility.formatNumbers(costingEU);

        mEfficiency = 10000;
        mEfficiencyIncrease = 10000;
        mMaxProgresstime = getProcessingTime();

        return CheckRecipeResultRegistry.SUCCESSFUL;
    }

    public CheckRecipeResult processOnce() {
        if (!isRecipeProcessing) startRecipeProcessing();
        setupProcessingLogic(processingLogic);

        CheckRecipeResult result = doCheckRecipe();
        if (!result.wasSuccessful()) {
            return result;
        }

        BigInteger costEU = BigInteger.valueOf(processingLogic.getCalculatedEut())
            .multiply(BigInteger.valueOf(processingLogic.getDuration()));

        int m = getExtraEUCostMultiplier();
        if (m > 1) {
            costEU = costEU.multiply(BigInteger.valueOf(m));
        }

        // 打印能量消耗信息
        System.out.println("Energy cost for this cycle: " + costEU);

        IGregTechTileEntity baseMetaTileEntity = getBaseMetaTileEntity();
        if (baseMetaTileEntity == null || !baseMetaTileEntity.decreaseStoredEnergyUnits(costEU.longValue(), false)) {
            return CheckRecipeResultRegistry.insufficientPower(costEU.longValue());
        }

        costingEU = costingEU.add(costEU);

        mOutputItems = mergeArray(mOutputItems, processingLogic.getOutputItems());
        mOutputFluids = mergeArray(mOutputFluids, processingLogic.getOutputFluids());

        endRecipeProcessing();
        return result;
    }

    public int getExtraEUCostMultiplier() {
        return 1;
    }

    public int getProcessingTime() {
        return processingLogic.getDuration();
    }

}
