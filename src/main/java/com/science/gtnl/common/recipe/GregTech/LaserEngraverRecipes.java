package com.science.gtnl.common.recipe.GregTech;

import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.recipe.IRecipePool;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;

public class LaserEngraverRecipes implements IRecipePool {

    final RecipeMap<?> lER = RecipeMaps.laserEngraverRecipes;

    @Override
    public void loadRecipes() {

        GTValues.RA.stdBuilder()
            .itemInputs(GTNLItemList.NinefoldInputHatchUHV.get(1), ItemList.Quantum_Tank_IV.get(1))
            .itemOutputs(GTNLItemList.HumongousNinefoldInputHatch.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(7864320)
            .addTo(lER);

    }
}
