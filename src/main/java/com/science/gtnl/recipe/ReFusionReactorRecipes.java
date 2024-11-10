package com.science.gtnl.recipe;

import com.science.gtnl.common.RecipeRegister;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTUtility;
import net.minecraftforge.fluids.FluidRegistry;

import static gregtech.api.util.GTModHandler.getModItem;

public class ReFusionReactorRecipes implements IRecipePool {

    final RecipeMap<?> RFP = RecipeRegister.RecombinationFusionReactorRecipes;

    @Override
    public void loadRecipes() {
        GTValues.RA.stdBuilder()
            .itemInputsUnsafe(GTUtility.copyAmountUnsafe(2147483647, getModItem("gregtech", "gt.metaitem.01", 1, 2299)))
            .itemOutputs(ItemList.Display_ITS_FREE.getWithName(1L, "可望不可及，不是么？"))
            .fluidOutputs(
                FluidRegistry.getFluidStack("molten.magmatter", 2147483647),
                FluidRegistry.getFluidStack("molten.magnetohydrodynamicallyconstrainedstarmatter", 2147483647),
                FluidRegistry.getFluidStack("molten.universium", 2147483647),
                FluidRegistry.getFluidStack("molten.whitedwarfmatter", 2147483647),
                FluidRegistry.getFluidStack("molten.blackdwarfmatter", 2147483647),
                FluidRegistry.getFluidStack("molten.spacetime", 2147483647),
                FluidRegistry.getFluidStack("molten.transcendentmetal", 2147483647),
                FluidRegistry.getFluidStack("molten.eternity", 2147483647),
                FluidRegistry.getFluidStack("primordialmatter", 2147483647),
                FluidRegistry.getFluidStack("spatialfluid", 2147483647),
                FluidRegistry.getFluidStack("temporalfluid", 2147483647),
                FluidRegistry.getFluidStack("molten.sixphasedcopper", 2147483647),
                FluidRegistry.getFluidStack("molten.infinity", 2147483647),
                FluidRegistry.getFluidStack("antimatter", 2147483647))
            .outputChances(1)
            .noOptimize()
            .duration(631139040)
            .eut(2147483647)
            .addTo(RFP);
    }
}
