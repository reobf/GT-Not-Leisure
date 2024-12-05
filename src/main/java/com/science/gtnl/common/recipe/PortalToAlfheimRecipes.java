package com.science.gtnl.common.recipe;

import static com.science.gtnl.Utils.TextHandler.texter;
import static com.science.gtnl.loader.IScriptLoader.missing;
import static gregtech.api.util.GTModHandler.getModItem;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.RecipeRegister;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class PortalToAlfheimRecipes implements IRecipePool {

    final RecipeMap<?> PTAR = RecipeRegister.PortalToAlfheimRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "bread", 1))
            .itemOutputs(
                GTUtility.copyAmountUnsafe(
                    2147483647,
                    getModItem("IC2", "blockNuke", 1)
                        .setStackDisplayName(texter("Elves don't like bread.", "PTARRecipes.1"))))
            .noOptimize()
            .duration(1200)
            .eut(0)
            .addTo(PTAR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 9, missing))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 8, missing))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(PTAR);

        RecipeBuilder.builder()
            .itemInputs(GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1L))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 8, missing))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(PTAR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("IC2", "blockAlloyGlass", 1, 0, missing))
            .itemOutputs(GTModHandler.getModItem("Botania", "elfGlass", 1, 0, missing))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(PTAR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "quartz", 1, 0, missing))
            .itemOutputs(GTModHandler.getModItem("Botania", "quartz", 1, 5, missing))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(PTAR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("gregtech", "gt.blockcasings4", 1, 1, missing))
            .itemOutputs(GTModHandler.getModItem("Botania", "dreamwood", 1, 0, missing))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(PTAR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("gregtech", "gt.metaitem.02", 1, 20316, missing))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 7, missing))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(PTAR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("IC2", "blockNuke", 64, 0, missing))
            .itemOutputs(
                GTModHandler.getModItem("Botania", "manaResource", 16, 5, missing),
                GTModHandler.getModItem("Botania", "dice", 1, 0, missing),
                GTModHandler.getModItem("Botania", "blackLotus", 1, 0, missing),
                GTModHandler.getModItem("Botania", "blackLotus", 1, 1, missing),
                GTModHandler.getModItem("Botania", "ancientWill", 1, 0, missing),
                GTModHandler.getModItem("Botania", "ancientWill", 1, 1, missing),
                GTModHandler.getModItem("Botania", "ancientWill", 1, 2, missing),
                GTModHandler.getModItem("Botania", "ancientWill", 1, 3, missing),
                GTModHandler.getModItem("Botania", "ancientWill", 1, 4, missing),
                GTModHandler.getModItem("Botania", "ancientWill", 1, 5, missing),
                GTModHandler.getModItem("Botania", "overgrowthSeed", 1, 3, missing),
                GTModHandler.getModItem("Botania", "manaResource", 16, 0, missing),
                GTModHandler.getModItem("Botania", "manaResource", 8, 1, missing),
                GTModHandler.getModItem("Botania", "manaResource", 4, 2, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 0, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 1, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 2, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 3, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 4, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 5, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 6, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 7, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 8, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 9, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 10, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 11, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 12, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 13, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 14, missing),
                GTModHandler.getModItem("Botania", "rune", 2, 15, missing),
                GTModHandler.getModItem("Botania", "pinkinator", 1, 0, missing),
                GTModHandler.getModItem("Botania", "recordGaia2", 1, 0, missing),
                GTModHandler.getModItem("minecraft", "record_13", 1, 0, missing),
                GTModHandler.getModItem("minecraft", "record_wait", 1, 0, missing),
                GTModHandler.getModItem("Botania", "gaiaHead", 1, 0, missing))
            .outputChances(
                10000,
                10000,
                650,
                560,
                930,
                1667,
                1667,
                1667,
                1667,
                1667,
                2500,
                9000,
                7000,
                5000,
                1875,
                1875,
                1875,
                1875,
                1875,
                1875,
                1875,
                1875,
                1875,
                1875,
                1875,
                1875,
                1875,
                1875,
                1875,
                1875,
                2000,
                5720,
                139,
                139,
                1)
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(PTAR);
    }
}
