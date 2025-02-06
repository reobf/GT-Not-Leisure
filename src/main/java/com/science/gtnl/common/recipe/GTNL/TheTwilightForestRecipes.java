package com.science.gtnl.common.recipe.GTNL;

import static gregtech.api.enums.Mods.TwilightForest;

import com.dreammaster.item.ItemList;
import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.recipe.IRecipePool;
import com.science.gtnl.common.recipe.RecipeRegister;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTUtility;

public class TheTwilightForestRecipes implements IRecipePool {

    final RecipeMap<?> TTFR = RecipeRegister.TheTwilightForestRecipes;

    @Override
    public void loadRecipes() {

        RecipeBuilder.builder()
            .itemInputs(GTUtility.copyAmount(0, GTNLItemList.NagaBook.get(1)))
            .itemOutputs(
                GTModHandler.getModItem(TwilightForest.ID, "item.trophy", 1, 1),
                GTModHandler.getModItem(TwilightForest.ID, "item.nagaScale", 16),
                ItemList.NagaScaleFragment.getIS(32),
                ItemList.NagaScaleChip.getIS(64))
            .outputChances(1000, 10000, 5000, 2500)
            .noOptimize()
            .duration(600)
            .eut(1966080)
            .addTo(TTFR);
    }
}
