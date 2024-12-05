package com.science.gtnl.common.machine.multiMachineClasses;

import javax.annotation.Nonnull;

import gregtech.api.util.GTRecipe;
import gregtech.api.util.ParallelHelper;

public class ProcessingLogic extends gregtech.api.logic.ProcessingLogic {

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
}
