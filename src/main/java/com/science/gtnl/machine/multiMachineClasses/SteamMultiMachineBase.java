package com.science.gtnl.machine.multiMachineClasses;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import gregtech.api.logic.ProcessingLogic;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.OverclockCalculator;
import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.base.MTESteamMultiBase;

public abstract class SteamMultiMachineBase<T extends SteamMultiMachineBase<T>> extends MTESteamMultiBase<T> {

    public SteamMultiMachineBase(String aName) {
        super(aName);
    }

    public SteamMultiMachineBase(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    @Override
    protected ProcessingLogic createProcessingLogic() {
        return new ProcessingLogic() {

            @Override
            @Nonnull
            protected OverclockCalculator createOverclockCalculator(@NotNull GTRecipe recipe) {
                return OverclockCalculator.ofNoOverclock(recipe)
                    .setEUtDiscount(1.33F)
                    .setSpeedBoost(1.5F);
            }
        }.setMaxParallelSupplier(this::getMaxParallelRecipes);
    }

    @Override
    public int getMaxParallelRecipes() {
        return 32;
    }

    // endregion

}
