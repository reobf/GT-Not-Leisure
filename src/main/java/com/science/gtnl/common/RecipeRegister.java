package com.science.gtnl.common;

import com.science.gtnl.common.recipe.Special.RealArtificialStar_SpecialValueFormatter;

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
        .neiHandlerInfo(
            builder -> builder.setDisplayStack(GTNLItemList.BloodSoulSacrificialArray.get(1))
                .setMaxRecipesPerPage(2))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> BloodDemonInjectionRecipes = RecipeMapBuilder
        .of("gtnl.recipe.BloodDemonInjectionRecipes")
        .maxIO(4, 1, 1, 1)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(
            builder -> builder.setDisplayStack(GTNLItemList.BloodSoulSacrificialArray.get(1))
                .setMaxRecipesPerPage(2))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> AlchemicChemistrySetRecipes = RecipeMapBuilder
        .of("gtnl.recipe.AlchemicChemistrySetRecipes")
        .maxIO(5, 1, 1, 1)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(
            builder -> builder.setDisplayStack(GTNLItemList.BloodSoulSacrificialArray.get(1))
                .setMaxRecipesPerPage(2))
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

    public static final RecipeMap<GTNL_RecipeMapBackend> PortalToAlfheimRecipes = RecipeMapBuilder
        .of("gtnl.recipe.PortalToAlfheimRecipes", GTNL_RecipeMapBackend::new)
        .maxIO(4, 36, 1, 0)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .frontend(GeneralFrontend::new)
        .neiHandlerInfo(
            builder -> builder.setDisplayStack(GTNLItemList.TeleportationArrayToAlfheim.get(1))
                .setMaxRecipesPerPage(1))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> NatureSpiritArrayRecipes = RecipeMapBuilder
        .of("gtnl.recipe.NatureSpiritArrayRecipes")
        .maxIO(1, 0, 0, 1)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.TeleportationArrayToAlfheim.get(1)))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> ManaInfusionRecipes = RecipeMapBuilder
        .of("gtnl.recipe.ManaInfusionRecipes")
        .maxIO(4, 1, 1, 0)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.TeleportationArrayToAlfheim.get(1)))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> LapotronChipRecipes = RecipeMapBuilder
        .of("gtnl.recipe.LapotronChipRecipes")
        .maxIO(9, 9, 3, 3)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.LapotronChip.get(1)))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> SteamCrackerRecipes = RecipeMapBuilder
        .of("gtnl.recipe.SteamCrackerRecipes")
        .maxIO(1, 0, 1, 1)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.SteamCracking.get(1)))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> CheatOreProcessingRecipes = RecipeMapBuilder
        .of("gtnl.recipe.CheatOreProcessingRecipes")
        .maxIO(1, 9, 1, 0)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.CheatOreProcessingFactory.get(1)))
        .disableOptimize()
        .build();

    public static final RecipeMap<RecipeMapBackend> DesulfurizerRecipes = RecipeMapBuilder
        .of("gtnl.recipe.DesulfurizerRecipes")
        .maxIO(0, 1, 1, 1)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.Desulfurizer.get(1)))
        .disableOptimize()
        .build();

    public static final RecipeMap<GTNL_RecipeMapBackend> PetrochemicalPlantRecipes = RecipeMapBuilder
        .of("gtnl.recipe.PetrochemicalPlantRecipes", GTNL_RecipeMapBackend::new)
        .maxIO(4, 4, 2, 12)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .frontend(GeneralFrontend::new)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.PetrochemicalPlant.get(1)))
        .disableOptimize()
        .build();

    public static final RecipeMap<GTNL_RecipeMapBackend> SmeltingMixingFurnaceRecipes = RecipeMapBuilder
        .of("gtnl.recipe.SmeltingMixingFurnaceRecipes", GTNL_RecipeMapBackend::new)
        .maxIO(2, 3, 16, 3)
        .progressBar(GTUITextures.PROGRESSBAR_ARROW_MULTIPLE)
        .frontend(GeneralFrontend::new)
        .neiHandlerInfo(builder -> builder.setDisplayStack(GTNLItemList.SmeltingMixingFurnace.get(1)))
        .disableOptimize()
        .build();
}
