package com.science.gtnl.recipe;

import static com.science.gtnl.Utils.TextHandler.texter;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.RecipeRegister;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTModHandler;

public class PortalToAlfheimRecipes implements IRecipePool {

    final RecipeMap<?> PTAR = RecipeRegister.PortalToAlfheimRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "bread", 1))
            .itemOutputs(
                GTModHandler.getModItem("IC2", "blockNuke", 64)
                    .setStackDisplayName(texter("Elves don't like bread.", "PTARRecipes.1")))
            .noOptimize()
            .duration(120)
            .eut(0)
            .addTo(PTAR);
    }
}
