package com.science.gtnl.common;

import com.science.gtnl.recipe.Special.RealArtificialStar_SpecialValueFormatter;

import gregtech.api.gui.modularui.GTUITextures;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMapBackend;
import gregtech.api.recipe.RecipeMapBuilder;

public class RecipeRegister {

    public static final RecipeMap<GTNL_RecipeMapBackend> RecombinationFusionReactorRecipes = RecipeMapBuilder
        .of("gtnl.recipe.RecombinationFusionReactorRecipes", GTNL_RecipeMapBackend::new)
        .maxIO(16, 16, 16, 16)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .frontend(GeneralFrontend::new)
        .neiHandlerInfo(
            builder -> builder.setDisplayStack(GTNLItemList.GenerationEarthEngine.get(1))
                .setMaxRecipesPerPage(1))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> BloodSoulTradingRecipes = RecipeMapBuilder
        .of("gtnl.recipe.BloodSoulTradingRecipes")
        .maxIO(4, 0, 1, 1)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.BloodSoulSacrificialArray.get(1)))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> BloodDemonInjectionRecipes = RecipeMapBuilder
        .of("gtnl.recipe.BloodDemonInjectionRecipes")
        .maxIO(4, 1, 1, 1)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.BloodSoulSacrificialArray.get(1)))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> AlchemicChemistrySetRecipes = RecipeMapBuilder
        .of("gtnl.recipe.AlchemicChemistrySetRecipes")
        .maxIO(5, 1, 1, 1)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.BloodSoulSacrificialArray.get(1)))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> RealArtificialStarRecipes = RecipeMapBuilder
        .of("gtnl.recipe.ArtificialStarGeneratingRecipes")
        .maxIO(1, 1, 0, 0)
        .neiSpecialInfoFormatter(RealArtificialStar_SpecialValueFormatter.INSTANCE)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.RealArtificialStar.get(1)))
        .disableOptimize()
        .build();
}
