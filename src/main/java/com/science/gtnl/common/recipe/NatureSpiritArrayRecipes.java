package com.science.gtnl.common.recipe;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.RecipeRegister;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTUtility;

public class NatureSpiritArrayRecipes implements IRecipePool {

    final RecipeMap<?> NSAR = RecipeRegister.NatureSpiritArrayRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "manaResource", 1, 0))
            .fluidOutputs(FluidRegistry.getFluidStack("fluidmana", 3500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(NSAR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "manaResource", 1, 1))
            .fluidOutputs(FluidRegistry.getFluidStack("fluidmana", 6500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(NSAR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "manaResource", 1, 2))
            .fluidOutputs(FluidRegistry.getFluidStack("fluidmana", 10500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(NSAR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(24))
            .fluidOutputs(FluidRegistry.getFluidStack("fluidmana", 1000000))
            .noOptimize()
            .duration(20)
            .eut(7864320)
            .addTo(NSAR);
    }
}
