package com.science.gtnl.common.recipe;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.materials.MaterialPool;

import gregtech.api.enums.OrePrefixes;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTModHandler;
import gtPlusPlus.api.recipe.GTPPRecipeMaps;

public class MixerRecipes implements IRecipePool {

    final RecipeMap<?> mixer = GTPPRecipeMaps.mixerNonCellRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 3, 2685),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 3, 2837))
            .itemOutputs()
            .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 1000))
            .fluidOutputs(MaterialPool.SilicaGelBase.getFluidOrGas(1000))
            .specialValue(0)
            .noOptimize()
            .duration(130)
            .eut(480)
            .addTo(mixer);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("miscutils", "itemDustSodiumNitrate", 5))
            .itemOutputs()
            .fluidInputs(FluidRegistry.getFluidStack("water", 1000))
            .fluidOutputs(MaterialPool.SodiumNitrateSolution.getFluidOrGas(1000))
            .specialValue(0)
            .noOptimize()
            .duration(80)
            .eut(120)
            .addTo(mixer);

        RecipeBuilder.builder()
            .itemInputs(MaterialPool.AmmoniumChloride.get(OrePrefixes.dust, 6))
            .itemOutputs()
            .fluidOutputs(
                FluidRegistry.getFluidStack("nitrogen", 1000),
                FluidRegistry.getFluidStack("hydrogen", 4000),
                FluidRegistry.getFluidStack("chlorine", 1000))
            .specialValue(0)
            .noOptimize()
            .duration(48)
            .eut(60)
            .addTo(mixer);

    }
}
