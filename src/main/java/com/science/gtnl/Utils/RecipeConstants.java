package com.science.gtnl.Utils;

import static gregtech.api.util.GTRecipeConstants.CLEANROOM;
import static gregtech.api.util.GTRecipeMapUtil.convertCellToFluid;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.item.ItemStack;

import gregtech.api.interfaces.IRecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.recipe.RecipeMetadataKey;
import gregtech.api.util.GTUtility;
import gregtech.nei.RecipeDisplayInfo;

@ParametersAreNonnullByDefault
public final class RecipeConstants {

    // 添加 SterileCleaningKey
    public static final RecipeMetadataKey<Boolean> STERILE_CLEANING = new RecipeMetadataKey<Boolean>(
        Boolean.class,
        "sterile_cleaning") {

        @Override
        public void drawInfo(RecipeDisplayInfo recipeInfo, @Nullable Object value) {
            Boolean sterileCleaning = cast(value, true);
            if (sterileCleaning) {
                recipeInfo.drawText(GTUtility.trans("730", "Needs Sterile Cleaning"));
            }
        }
    };

    public static final IRecipeMap CleanChemical = IRecipeMap.newRecipeMap(builder -> {
        for (ItemStack input : builder.getItemInputsBasic()) {
            // config >= 10 -> this is a special chemical recipe that outputs fluid/canned fluid variant.
            // it doesn't belong to multiblocks
            if (GTUtility.isAnyIntegratedCircuit(input) && input.getItemDamage() >= 10) {
                return builder.addTo(RecipeMaps.chemicalReactorRecipes);
            }
        }
        return GTUtility.concat(
            builder.copy()
                .addTo(RecipeMaps.chemicalReactorRecipes),
            convertCellToFluid(builder, false)
                // LCR does not need cleanroom.
                .metadata(CLEANROOM, false)
                .metadata(STERILE_CLEANING, true)
                .addTo(RecipeMaps.multiblockChemicalReactorRecipes));
    });
}
