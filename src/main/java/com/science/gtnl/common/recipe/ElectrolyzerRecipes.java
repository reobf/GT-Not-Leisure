package com.science.gtnl.common.recipe;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.materials.MaterialPool;

import gregtech.api.enums.OrePrefixes;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTModHandler;
import gtPlusPlus.api.recipe.GTPPRecipeMaps;

public class ElectrolyzerRecipes implements IRecipePool {

    final RecipeMap<?> electrolyzer = GTPPRecipeMaps.electrolyzerNonCellRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs()
            .fluidInputs(MaterialPool.FluoroboricAcide.getFluidOrGas(1000))
            .itemOutputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2009))
            .fluidOutputs(FluidRegistry.getFluidStack("hydrogen", 1000), FluidRegistry.getFluidStack("fluorine", 4000))
            .specialValue(0)
            .noOptimize()
            .duration(840)
            .eut(60)
            .addTo(electrolyzer);

        RecipeBuilder.builder()
            .itemInputs(MaterialPool.NitronsoniumTetrafluoroborate.get(OrePrefixes.dust, 7))
            .itemOutputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2009))
            .fluidOutputs(
                FluidRegistry.getFluidStack("nitrogen", 1000),
                FluidRegistry.getFluidStack("oxygen", 1000),
                FluidRegistry.getFluidStack("fluorine", 4000))
            .specialValue(0)
            .noOptimize()
            .duration(840)
            .eut(60)
            .addTo(electrolyzer);

        RecipeBuilder.builder()
            .itemInputs()
            .fluidInputs(MaterialPool.BoronFluoride.getFluidOrGas(1000))
            .itemOutputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2009))
            .fluidOutputs(FluidRegistry.getFluidStack("fluorine", 3000))
            .specialValue(0)
            .noOptimize()
            .duration(640)
            .eut(30)
            .addTo(electrolyzer);

        RecipeBuilder.builder()
            .itemInputs()
            .fluidInputs(MaterialPool.Benzaldehyde.getFluidOrGas(1000))
            .itemOutputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 7, 2010))
            .fluidOutputs(FluidRegistry.getFluidStack("hydrogen", 6000), FluidRegistry.getFluidStack("oxygen", 1000))
            .specialValue(0)
            .noOptimize()
            .duration(112)
            .eut(60)
            .addTo(electrolyzer);

        RecipeBuilder.builder()
            .itemInputs()
            .fluidInputs(MaterialPool.HydroboromicAcid.getFluidOrGas(1000))
            .itemOutputs()
            .fluidOutputs(
                FluidRegistry.getFluidStack("molten.bromine", 1000),
                FluidRegistry.getFluidStack("hydrogen", 1000))
            .specialValue(0)
            .noOptimize()
            .duration(72)
            .eut(30)
            .addTo(electrolyzer);

        RecipeBuilder.builder()
            .itemInputs(MaterialPool.PotassiumSulfate.get(OrePrefixes.dust, 7))
            .fluidInputs()
            .itemOutputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 2, 2025),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2022))
            .fluidOutputs(FluidRegistry.getFluidStack("oxygen", 4000))
            .specialValue(0)
            .noOptimize()
            .duration(168)
            .eut(60)
            .addTo(electrolyzer);
    }
}
