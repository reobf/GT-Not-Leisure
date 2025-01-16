package com.science.gtnl.common.recipe.GregTech;

import static gregtech.api.util.GTRecipeConstants.DISSOLUTION_TANK_RATIO;

import com.science.gtnl.common.materials.MaterialPool;
import com.science.gtnl.common.recipe.IRecipePool;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTOreDictUnificator;
import gtnhlanth.api.recipe.LanthanidesRecipeMaps;

public class DissolutionTankRecipes implements IRecipePool {

    final RecipeMap<?> DTR = LanthanidesRecipeMaps.dissolutionTankRecipes;

    @Override
    public void loadRecipes() {
        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3))
            .fluidInputs(Materials.NitricAcid.getFluid(100), Materials.Water.getFluid(900))
            .fluidOutputs(MaterialPool.RareEarthHydroxides.getFluidOrGas(1000))
            .metadata(DISSOLUTION_TANK_RATIO, 1)
            .specialValue(0)
            .noOptimize()
            .duration(50)
            .eut(480)
            .addTo(DTR);
    }
}
