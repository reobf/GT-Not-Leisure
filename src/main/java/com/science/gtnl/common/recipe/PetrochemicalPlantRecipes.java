package com.science.gtnl.common.recipe;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.RecipeRegister;

import gregtech.api.recipe.RecipeMap;

public class PetrochemicalPlantRecipes implements IRecipePool {

    final RecipeMap<?> PPR = RecipeRegister.PetrochemicalPlantRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .fluidInputs(
                FluidRegistry.getFluidStack("liquid_heavy_oil", 1000),
                FluidRegistry.getFluidStack("steam", 1000))
            .fluidOutputs(
                FluidRegistry.getFluidStack("ethylene", 450),
                FluidRegistry.getFluidStack("methane", 450),
                FluidRegistry.getFluidStack("helium", 10),
                FluidRegistry.getFluidStack("propane", 30),
                FluidRegistry.getFluidStack("propene", 300),
                FluidRegistry.getFluidStack("ethane", 45),
                FluidRegistry.getFluidStack("butane", 60),
                FluidRegistry.getFluidStack("butene", 240),
                FluidRegistry.getFluidStack("butadiene", 150),
                FluidRegistry.getFluidStack("liquid_toluene", 240),
                FluidRegistry.getFluidStack("benzene", 1200),
                FluidRegistry.getFluidStack("octane", 20))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(1920)
            .addTo(PPR);
    }
}
