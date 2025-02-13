package com.science.gtnl.common.recipe.GTNL;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.recipe.IRecipePool;
import com.science.gtnl.common.recipe.RecipeRegister;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTOreDictUnificator;

public class WoodDistillationRecipes implements IRecipePool {

    final RecipeMap<?> WDR = RecipeRegister.WoodDistillationRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(GTOreDictUnificator.get(OrePrefixes.log, Materials.Wood, 16L))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 4L))
            .fluidInputs(Materials.Nitrogen.getGas(1000))
            .fluidOutputs(
                Materials.Water.getFluid(400),
                Materials.Methanol.getFluid(240),
                Materials.Benzene.getFluid(175),
                Materials.CarbonMonoxide.getGas(170),
                Materials.Creosote.getFluid(150),
                Materials.Dimethylbenzene.getFluid(120),
                Materials.AceticAcid.getFluid(80),
                Materials.Methane.getGas(60),
                Materials.Acetone.getFluid(40),
                Materials.Phenol.getFluid(35),
                Materials.Toluene.getFluid(35),
                Materials.Ethylene.getGas(10),
                Materials.Hydrogen.getGas(10),
                Materials.MethylAcetate.getFluid(8),
                Materials.Methanol.getFluid(8))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(120)
            .addTo(WDR);

    }
}
