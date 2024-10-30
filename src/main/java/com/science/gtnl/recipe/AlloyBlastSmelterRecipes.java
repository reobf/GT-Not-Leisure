package com.science.gtnl.recipe;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.materials.MaterialPool;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTUtility;
import gtPlusPlus.api.recipe.GTPPRecipeMaps;

public class AlloyBlastSmelterRecipes implements IRecipePool {

    final RecipeMap<?> aBS = GTPPRecipeMaps.alloyBlastSmelterRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(3),
                GTModHandler.getModItem("miscutils", "itemDustGermanium", 3),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 3, 2081))
            .fluidInputs(FluidRegistry.getFluidStack("nitrogen", 10000))
            .fluidOutputs(MaterialPool.Germaniumtungstennitride.getMolten(2304))
            .specialValue(0)
            .noOptimize()
            .duration(9600)
            .eut(30720)
            .addTo(aBS);
    }
}
