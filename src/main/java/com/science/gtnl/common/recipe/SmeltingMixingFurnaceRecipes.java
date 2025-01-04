package com.science.gtnl.common.recipe;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.RecipeRegister;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTUtility;

public class SmeltingMixingFurnaceRecipes implements IRecipePool {

    final RecipeMap<?> SMFR = RecipeRegister.SmeltingMixingFurnaceRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.zirconium", 144),
                FluidRegistry.getFluidStack("plasma.carbon", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.zirconiumcarbide", 1440))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(15)
            .addTo(SMFR);
    }
}
