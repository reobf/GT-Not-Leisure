package com.science.gtnl.common.recipe.GregTech;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.materials.MaterialPool;
import com.science.gtnl.common.recipe.IRecipePool;

import gregtech.api.enums.Materials;
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
            .fluidInputs(Materials.RedMud.getFluid(1000L), Materials.HydrochloricAcid.getFluid(4000))
            .fluidOutputs(MaterialPool.NeutralisedRedMud.getFluidOrGas(2000))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(120)
            .addTo(mixer);

    }
}
