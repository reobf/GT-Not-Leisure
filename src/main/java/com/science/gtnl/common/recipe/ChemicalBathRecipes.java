package com.science.gtnl.common.recipe;

import static com.science.gtnl.loader.IScriptLoader.missing;
import static gregtech.api.util.GTModHandler.getModItem;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.GTNLItemList;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;

public class ChemicalBathRecipes implements IRecipePool {

    final RecipeMap<?> cBR = RecipeMaps.chemicalBathRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(GTNLItemList.Terra_Glass.get(1))
            .fluidInputs(FluidRegistry.getFluidStack("molten.gaiaspirit", 144 * 9))
            .itemOutputs(GTNLItemList.Gaia_Glass.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(30720)
            .addTo(cBR);

        RecipeBuilder.builder()
            .itemInputs(getModItem("Botania", "elfGlass", 1, 0, missing))
            .fluidInputs(FluidRegistry.getFluidStack("molten.terrasteel", 144 * 4))
            .itemOutputs(GTNLItemList.Terra_Glass.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(7680)
            .addTo(cBR);
    }
}
