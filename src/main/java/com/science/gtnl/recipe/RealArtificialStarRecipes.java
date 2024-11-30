package com.science.gtnl.recipe;

import static com.science.gtnl.Utils.TextHandler.texter;
import static com.science.gtnl.common.GTNLItemList.*;
import static com.science.gtnl.config.Config.*;

import com.science.gtnl.common.RecipeRegister;

import gregtech.api.enums.GTValues;
import gregtech.api.recipe.RecipeMap;

public class RealArtificialStarRecipes implements IRecipePool {

    final RecipeMap<?> RAS = RecipeRegister.RealArtificialStarRecipes;

    @Override
    public void loadRecipes() {
        GTValues.RA.stdBuilder()
            .itemInputs(AntimatterFuelRod.get(1))
            .itemOutputs(
                StellarConstructionFrameMaterial.get(1)
                    .setStackDisplayName(
                        texter(
                            "Chance to recover some raw materials. Probability is affected by module tier.",
                            "NEI.RealAntimatterFuelRodGeneratingRecipe.01")))
            .specialValue((int) (EUEveryAntimatterFuelRod / Integer.MAX_VALUE))
            .eut(0)
            .duration(0)
            .addTo(RAS);

        GTValues.RA.stdBuilder()
            .itemInputs(StrangeAnnihilationFuelRod.get(1))
            .itemOutputs(
                StellarConstructionFrameMaterial.get(1)
                    .setStackDisplayName(
                        texter(
                            "Chance to recover some raw materials. Probability is affected by module tier.",
                            "NEI.RealAntimatterFuelRodGeneratingRecipe.01")))
            .specialValue((int) (EUEveryStrangeAnnihilationFuelRod / Integer.MAX_VALUE))
            .eut(0)
            .duration(0)
            .addTo(RAS);

        GTValues.RA.stdBuilder()
            .itemInputs(DepletedExcitedNaquadahFuelRod.get(1))
            .specialValue((int) (EUEveryDepletedExcitedNaquadahFuelRod / Integer.MAX_VALUE))
            .eut(0)
            .duration(0)
            .addTo(RAS);
    }
}
