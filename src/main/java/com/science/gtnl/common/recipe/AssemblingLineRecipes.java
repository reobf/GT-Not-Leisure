package com.science.gtnl.common.recipe;

import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.science.gtnl.Utils.enums.TierEU;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
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

        TTRecipeAdder.addResearchableAssemblylineRecipe(
            GTModHandler.getModItem("gregtech", "gt.blockmachines", 1, 12792),
            256000,
            1024,
            (int) TierEU.RECIPE_UHV,
            1,
            new ItemStack[] { GTModHandler.getModItem("gregtech", "gt.blockmachines", 64, 18),
                GTModHandler.getModItem("gregtech", "gt.blockmachines", 64, 12792),
                GTModHandler.getModItem("EnderIO", "blockFarmStation", 64),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 16, 32677),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 16, 32687),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 16, 32697),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 8L),
                GTModHandler.getModItem("Botania", "overgrowthSeed", 8),
                GTModHandler.getModItem("gregtech", "gt.blockmachines", 16, 2445),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 64, 27982),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 4, 6129),
                GTModHandler.getModItem("miscutils", "MU-metaitem.01", 1, 32105),
                GTModHandler.getModItem("RandomThings", "fertilizedDirt", 64),
                GTModHandler.getModItem("gregtech", "gt.blockcasings10", 16, 4),
                GTModHandler.getModItem("gregtech", "gt.blockcasings10", 16, 5) },
            new FluidStack[] { FluidRegistry.getFluidStack("biohmediumsterilized", 320000),
                FluidRegistry.getFluidStack("molten.indalloy140", 128000),
                FluidRegistry.getFluidStack("lubricant", 256000),
                FluidRegistry.getFluidStack("molten.naquadria", 36864) },
            GTModHandler.getModItem("gregtech", "gt.blockmachines", 1, 21004),
            30 * SECONDS,
            (int) TierEU.RECIPE_UHV);
    }
}
