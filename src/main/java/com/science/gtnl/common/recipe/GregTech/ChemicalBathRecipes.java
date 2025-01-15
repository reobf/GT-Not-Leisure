package com.science.gtnl.common.recipe.GregTech;

import static com.science.gtnl.loader.IScriptLoader.missing;
import static gregtech.api.util.GTModHandler.getModItem;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.recipe.IRecipePool;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;

public class ChemicalBathRecipes implements IRecipePool {

    final RecipeMap<?> cBR = RecipeMaps.chemicalBathRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(GTNLItemList.TerraGlass.get(1))
            .fluidInputs(FluidRegistry.getFluidStack("molten.gaiaspirit", 288))
            .itemOutputs(GTNLItemList.GaiaGlass.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(30720)
            .addTo(cBR);

        RecipeBuilder.builder()
            .itemInputs(getModItem("Botania", "elfGlass", 1, 0, missing))
            .fluidInputs(FluidRegistry.getFluidStack("molten.terrasteel", 576))
            .itemOutputs(GTNLItemList.TerraGlass.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(7680)
            .addTo(cBR);
    }
}
