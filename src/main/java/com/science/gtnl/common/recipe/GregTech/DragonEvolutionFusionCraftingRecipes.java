package com.science.gtnl.common.recipe.GregTech;

import static gregtech.api.util.GTRecipeConstants.DEFC_CASING_TIER;

import com.science.gtnl.common.materials.MaterialPool;
import com.science.gtnl.common.recipe.IRecipePool;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.material.MaterialMisc;
import gtPlusPlus.core.material.MaterialsElements;
import kubatech.loaders.DEFCRecipes;

public class DragonEvolutionFusionCraftingRecipes implements IRecipePool {

    final RecipeMap<?> DEFCR = DEFCRecipes.fusionCraftingRecipes;

    @Override

    public void loadRecipes() {

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.copyAmount(0, ItemList.Field_Generator_UEV.get(1)),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 64),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.TengamPurified, 64),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ichorium, 32),
                MaterialsElements.STANDALONE.DRAGON_METAL.getDust(16),
                ItemList.Tesseract.get(2L),
                ItemList.Gravistar.get(16L),
                GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Neutronium, 4),
                ItemList.Circuit_Parts_Chip_Bioware.get(64L))
            .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(10000))
            .fluidOutputs(MaterialPool.SuperMutatedLivingSolder.getFluidOrGas(10000))
            .eut(TierEU.RECIPE_UEV)
            .duration(1200)
            .metadata(DEFC_CASING_TIER, 3)
            .addTo(DEFCR);

    }
}
