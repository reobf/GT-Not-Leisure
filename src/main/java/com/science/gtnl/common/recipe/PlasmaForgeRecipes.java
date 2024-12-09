package com.science.gtnl.common.recipe;

import static gregtech.api.util.GTRecipeConstants.COIL_HEAT;

import com.science.gtnl.common.materials.MaterialPool;

import gregtech.api.enums.GTValues;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.util.GTModHandler;

public class PlasmaForgeRecipes implements IRecipePool {

    final RecipeMap<?> PFR = RecipeMaps.plasmaForgeRecipes;

    @Override
    public void loadRecipes() {
        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.blockmachines", 4, 124),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32415),
                GTModHandler.getModItem("miscutils", "itemPlateDenseDragonblood", 16, 0),
                GTModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 16, 34),
                GTModHandler.getModItem("Avaritia", "Singularity", 2, 0),
                GTModHandler.getModItem("GoodGenerator", "fluidCore", 2, 7))
            .fluidInputs(MaterialPool.DepletedExcitedNaquadah.getFluidOrGas(1000))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "MetaItem", 1, 1))
            .noOptimize()
            .duration(20)
            .metadata(COIL_HEAT, 13501)
            .eut(31457280)
            .addTo(PFR);
    }
}
