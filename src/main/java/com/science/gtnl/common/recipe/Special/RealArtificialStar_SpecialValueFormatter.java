package com.science.gtnl.common.recipe.Special;

import static com.science.gtnl.Utils.item.TextHandler.texter;

import java.util.ArrayList;
import java.util.List;

import gregtech.nei.RecipeDisplayInfo;
import gregtech.nei.formatter.INEISpecialInfoFormatter;

public class RealArtificialStar_SpecialValueFormatter implements INEISpecialInfoFormatter {

    public static final RealArtificialStar_SpecialValueFormatter INSTANCE = new RealArtificialStar_SpecialValueFormatter();

    @Override
    public List<String> format(RecipeDisplayInfo recipeInfo) {
        List<String> msgs = new ArrayList<>();
        msgs.add(
            texter("Generate : ", "NEI.RealArtificialStarGeneratingRecipes.specialValue.pre")
                + recipeInfo.recipe.mSpecialValue
                + " × 2,147,483,647 EU");
        return msgs;
    }
}
