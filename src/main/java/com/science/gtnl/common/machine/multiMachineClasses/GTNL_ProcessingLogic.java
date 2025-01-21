package com.science.gtnl.common.machine.multiMachineClasses;

import javax.annotation.Nonnull;

import com.science.gtnl.misc.OverclockType;

import gregtech.api.logic.ProcessingLogic;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.ParallelHelper;

public class GTNL_ProcessingLogic extends ProcessingLogic {

    /**
     * Override to tweak parallel logic if needed.
     */
    @Nonnull
    @Override
    protected ParallelHelper createParallelHelper(@Nonnull GTRecipe recipe) {
        return new ParallelHelper().setRecipe(recipe)
            .setItemInputs(inputItems)
            .setFluidInputs(inputFluids)
            .setAvailableEUt(availableVoltage * availableAmperage)
            .setMachine(machine, protectItems, protectFluids)
            .setRecipeLocked(recipeLockableMachine, isRecipeLocked)
            .setMaxParallel(maxParallel)
            .setEUtModifier(euModifier)
            .enableBatchMode(batchSize)
            .setConsumption(true)
            .setOutputCalculation(true);
    }

    public GTNL_ProcessingLogic setOverclockType(OverclockType t) {
        setOverclock(t.timeReduction, t.powerIncrease);
        return this;
    }
}
