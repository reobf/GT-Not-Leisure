package com.science.gtnl.loader;

import com.science.gtnl.recipe.AlloyBlastSmelterRecipes;
import com.science.gtnl.recipe.AssemblerRecipes;
import com.science.gtnl.recipe.AssemblingLineRecipes;
import com.science.gtnl.recipe.ChemicalRecipes;
import com.science.gtnl.recipe.CompressorRecipes;
import com.science.gtnl.recipe.ElectrolyzerRecipes;
import com.science.gtnl.recipe.IRecipePool;
import com.science.gtnl.recipe.MixerRecipes;
import com.science.gtnl.recipe.multiDehydratorRecipes;

public class RecipeLoader {

    public static void loadRecipes() {
        IRecipePool[] recipePools = new IRecipePool[] { new ChemicalRecipes(), new ElectrolyzerRecipes(),
            new MixerRecipes(), new multiDehydratorRecipes(), new AssemblerRecipes(), new AlloyBlastSmelterRecipes(),
            new AssemblingLineRecipes(), new CompressorRecipes() };
        for (IRecipePool recipePool : recipePools) {
            recipePool.loadRecipes();
        }
    }
}
