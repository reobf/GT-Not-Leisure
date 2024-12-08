package com.science.gtnl.common.recipe;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.materials.MaterialPool;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.util.GTModHandler;

public class PlasmaForgeRecipes implements IRecipePool {

    final RecipeMap<?> PFR = RecipeMaps.plasmaForgeRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.blockmachines", 4, 124),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32415),
                GTModHandler.getModItem("miscutils", "itemPlateDenseDragonblood", 16, 0),
                GTModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 16, 34),
                GTModHandler.getModItem("Avaritia", "Singularity", 2, 0),
                GTModHandler.getModItem("GoodGenerator", "fluidCore", 2, 7)
            )
            .fluidInputs(MaterialPool.DepletedExcitedNaquadah.getFluidOrGas(1000))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "MetaItem", 1, 1))
            .noOptimize()
            .duration(20)
            .eut(31457280)
            .addTo(PFR);
    }
}
