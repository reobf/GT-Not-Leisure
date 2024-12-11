package com.science.gtnl.misc.CheckRecipeResults;

import gregtech.api.recipe.check.CheckRecipeResultRegistry;

public final class CheckRecipeResults {

    public static void initStatics() {
        CheckRecipeResultRegistry.register(new GTNLSimpleResultWithText(false, "", false));
    }
}
