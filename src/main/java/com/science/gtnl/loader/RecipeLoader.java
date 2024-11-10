package com.science.gtnl.loader;

import com.science.gtnl.recipe.*;

public class RecipeLoader {

    public static void loadRecipes() {
        IRecipePool[] recipePools = new IRecipePool[] { new ChemicalRecipes(), new ElectrolyzerRecipes(),
            new MixerRecipes(), new multiDehydratorRecipes(), new AssemblerRecipes(), new AlloyBlastSmelterRecipes(),
            new AssemblingLineRecipes(), new CompressorRecipes(), new ReFusionReactorRecipes()};
        for (IRecipePool recipePool : recipePools) {
            recipePool.loadRecipes();
        }
    }
}
