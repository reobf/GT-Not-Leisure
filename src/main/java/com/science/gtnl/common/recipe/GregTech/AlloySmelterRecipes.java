package com.science.gtnl.common.recipe.GregTech;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.recipe.IRecipePool;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;

public class AlloySmelterRecipes implements IRecipePool {

    final RecipeMap<?> aSR = RecipeMaps.alloySmelterRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(new ItemStack(Items.glowstone_dust, 1), new ItemStack(Items.clay_ball, 1))
            .itemOutputs(GTNLItemList.ClayedGlowstone.get(2))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(16)
            .addTo(aSR);
    }
}
