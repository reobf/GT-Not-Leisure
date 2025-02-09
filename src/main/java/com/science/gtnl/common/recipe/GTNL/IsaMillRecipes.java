package com.science.gtnl.common.recipe.GTNL;

import static com.science.gtnl.Utils.Utils.setStackSize;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.common.recipe.IRecipePool;
import com.science.gtnl.common.recipe.IsaMillTierKey;
import com.science.gtnl.common.recipe.RecipeRegister;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.item.chemistry.MilledOreProcessing;

public class IsaMillRecipes implements IRecipePool {

    final IsaMillTierKey ISAMILL_TIER = IsaMillTierKey.INSTANCE;
    final RecipeMap<?> IsaMR = RecipeRegister.IsaMillRecipes;

    @Override
    public void loadRecipes() {
        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(10),
                GTOreDictUnificator.get(OrePrefixes.ore, Materials.Almandine, 1L))
            .itemOutputs(setStackSize(new ItemStack(MilledOreProcessing.milledAlmandine, 1), 72))
            .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100))
            .metadata(ISAMILL_TIER, 1)
            .noOptimize()
            .duration(2400)
            .eut(1920)
            .addTo(IsaMR);
    }
}
