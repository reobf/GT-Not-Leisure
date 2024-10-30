package com.science.gtnl.recipe;

import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.science.gtnl.Utils.enums.TierEU;

import gregtech.api.util.GTModHandler;
import tectech.recipe.TTRecipeAdder;

public class AssemblingLineRecipes implements IRecipePool {

    @Override
    public void loadRecipes() {
        TTRecipeAdder.addResearchableAssemblylineRecipe(
            GTModHandler.getModItem("gregtech", "gt.metaitem.03", 1, 32189),
            10000000,
            2500,
            (int) TierEU.RECIPE_UV,
            1,
            new ItemStack[] { GTModHandler.getModItem("gregtech", "gt.metaitem.03", 1, 32107),
                GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDCapacitor", 8),
                GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDDiode", 8),
                GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDResistor", 8),
                GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDTransistor", 8),
                GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDInductor", 8),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedfoil", 2, 20047),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 8, 32076),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 8, 32189),
                GTModHandler.getModItem("gregtech", "gt.metaitem.02", 16, 19324),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 17360) },
            new FluidStack[] { FluidRegistry.getFluidStack("biohmediumsterilized", 1000),
                FluidRegistry.getFluidStack("molten.plastic", 1296),
                FluidRegistry.getFluidStack("molten.polyvinylchloride", 864),
                FluidRegistry.getFluidStack("molten.solderingalloy", 1296) },
            GTModHandler.getModItem("gregtech", "gt.metaitem.03", 8, 32077),
            16 * SECONDS,
            (int) TierEU.RECIPE_UV);
    }
}
