package com.science.gtnl.common;

import gregtech.api.gui.modularui.GTUITextures;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMapBackend;
import gregtech.api.recipe.RecipeMapBuilder;
import gregtech.nei.formatter.HeatingCoilSpecialValueFormatter;

public class RecipeRegister {

    public static final RecipeMap<RecipeMapBackend> RecombinationFusionReactorRecipes = RecipeMapBuilder
        // #tr gtnl.recipe.RecombinationFusionReactorRecipes
        // #zh_CN 重聚变反应堆
        .of("gtnl.recipe.RecombinationFusionReactorRecipes", RecipeMapBackend::new)
        .maxIO(16, 16, 16, 16)
        .neiSpecialInfoFormatter(HeatingCoilSpecialValueFormatter.INSTANCE)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .frontend(GeneralFrontend::new)
        .neiHandlerInfo(
            builder -> builder.setDisplayStack(GTNLItemList.GenerationEarthEngine.get(1))
                .setMaxRecipesPerPage(1))
        .disableOptimize()
        .build();

}
