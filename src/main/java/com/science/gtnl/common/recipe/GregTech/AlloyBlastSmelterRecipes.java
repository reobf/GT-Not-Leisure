package com.science.gtnl.common.recipe.GregTech;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.materials.MaterialPool;
import com.science.gtnl.common.recipe.IRecipePool;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.api.recipe.GTPPRecipeMaps;
import gtPlusPlus.core.material.MaterialsElements;

public class AlloyBlastSmelterRecipes implements IRecipePool {

    final RecipeMap<?> aBS = GTPPRecipeMaps.alloyBlastSmelterRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(3),
                GTOreDictUnificator.get(MaterialsElements.getInstance().GERMANIUM.getDust(3)),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 3))
            .fluidInputs(Materials.Nitrogen.getGas(10000))
            .fluidOutputs(MaterialPool.Germaniumtungstennitride.getMolten(2304))
            .specialValue(0)
            .noOptimize()
            .duration(9600)
            .eut(30720)
            .addTo(aBS);
    }
}
