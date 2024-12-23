package com.science.gtnl.common.recipe;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.RecipeRegister;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTModHandler;

public class DesulfurizerRecipes implements IRecipePool {

    final RecipeMap<?> DesR = RecipeRegister.DesulfurizerRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemOutputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2022))
            .fluidInputs(FluidRegistry.getFluidStack("gas_sulfuricgas", 12000))
            .fluidOutputs(FluidRegistry.getFluidStack("gas_gas", 12000))
            .specialValue(0)
            .noOptimize()
            .duration(120)
            .eut(30)
            .addTo(DesR);

        RecipeBuilder.builder()
            .itemOutputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2022))
            .fluidInputs(FluidRegistry.getFluidStack("liquid_sulfuricnaphtha", 12000))
            .fluidOutputs(FluidRegistry.getFluidStack("liquid_naphtha", 12000))
            .specialValue(0)
            .noOptimize()
            .duration(120)
            .eut(30)
            .addTo(DesR);

        RecipeBuilder.builder()
            .itemOutputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2022))
            .fluidInputs(FluidRegistry.getFluidStack("liquid_sufluriclight_fuel", 12000))
            .fluidOutputs(FluidRegistry.getFluidStack("liquid_light_fuel", 12000))
            .specialValue(0)
            .noOptimize()
            .duration(120)
            .eut(30)
            .addTo(DesR);

        RecipeBuilder.builder()
            .itemOutputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2022))
            .fluidInputs(FluidRegistry.getFluidStack("liquid_sulfuricheavy_fuel", 12000))
            .fluidOutputs(FluidRegistry.getFluidStack("liquid_heavy_fuel", 12000))
            .specialValue(0)
            .noOptimize()
            .duration(120)
            .eut(30)
            .addTo(DesR);
    }
}
