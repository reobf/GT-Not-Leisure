package com.science.gtnl.common.recipe.GregTech;

import static gregtech.api.util.GTRecipeConstants.FUSION_THRESHOLD;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.common.recipe.IRecipePool;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gtPlusPlus.core.material.MaterialsElements;

public class FusionReactorRecipes implements IRecipePool {

    final RecipeMap<?> fR = RecipeMaps.fusionRecipes;

    @Override
    public void loadRecipes() {
        GTValues.RA.stdBuilder()
            .fluidInputs(FluidRegistry.getFluidStack("hydrogen", 144), FluidRegistry.getFluidStack("molten.boron", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("plasma.carbon", 144))
            .duration(10)
            .eut(7680)
            .metadata(FUSION_THRESHOLD, 20000000)
            .addTo(fR);

        GTValues.RA.stdBuilder()
            .fluidInputs(Materials.DraconiumAwakened.getMolten(432), Materials.Radon.getPlasma(144))
            .fluidOutputs(MaterialsElements.STANDALONE.DRAGON_METAL.getFluidStack(288))
            .duration(10)
            .eut(491520)
            .metadata(FUSION_THRESHOLD, 1000000000)
            .addTo(fR);
    }
}
