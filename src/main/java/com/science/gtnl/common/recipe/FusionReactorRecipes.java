package com.science.gtnl.common.recipe;

import static gregtech.api.util.GTRecipeConstants.FUSION_THRESHOLD;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GTValues;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;

public class FusionReactorRecipes implements IRecipePool {

    final RecipeMap<?> fR = RecipeMaps.fusionRecipes;

    @Override
    public void loadRecipes() {
        GTValues.RA.stdBuilder()
            .fluidInputs(FluidRegistry.getFluidStack("hydrogen", 144), FluidRegistry.getFluidStack("molten.boron", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("plasma.carbon", 144))
            .duration(10)
            .eut(7680)
            .metadata(FUSION_THRESHOLD, 20000000)
            .addTo(fR);
    }
}
