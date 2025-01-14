package com.science.gtnl.common.recipe;

import static gregtech.api.util.GTRecipeBuilder.HOURS;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.*;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.science.gtnl.Utils.enums.TierEU;
import com.science.gtnl.common.GTNLItemList;

import gregtech.api.enums.GTValues;
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
                GTNLItemList.BiowareSMDCapacitor.get(8), GTNLItemList.BiowareSMDDiode.get(8),
                GTNLItemList.BiowareSMDResistor.get(8), GTNLItemList.BiowareSMDTransistor.get(8),
                GTNLItemList.BiowareSMDInductor.get(8),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedfoil", 2, 25047),
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

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, GTModHandler.getModItem("Botania", "lexicon", 1, 0))
            .metadata(RESEARCH_TIME, 4 * HOURS)
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.blockmachines", 8, 17),
                GTModHandler.getModItem("Botania", "pylon", 4, 2),
                GTModHandler.getModItem("Botania", "pool", 16, 3),
                GTModHandler.getModItem("Botania", "spreader", 8, 3),
                GTModHandler.getModItem("gregtech", "gt.blockmachines", 64, 15465),
                GTModHandler.getModItem("Botania", "alfheimPortal", 64, 0),
                GTModHandler.getModItem("Botania", "runeAltar", 64, 0),
                GTModHandler.getModItem("Botania", "corporeaSpark", 64, 0),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 16, 32696),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 16, 32676),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 8L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 4L),
                GTModHandler.getModItem("gregtech", "gt.blockcasings8", 32, 10),
                GTModHandler.getModItem("gregtech", "gt.blockcasings4", 32, 7),
                GTModHandler.getModItem("Botania", "storage", 32, 0))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.elvenelementium", 144 * 64),
                FluidRegistry.getFluidStack("molten.terrasteel", 144 * 32),
                FluidRegistry.getFluidStack("molten.indalloy140", 256000))
            .itemOutputs(GTNLItemList.TeleportationArrayToAlfheim.get(1))
            .eut(TierEU.RECIPE_UV)
            .duration(300 * SECONDS)
            .addTo(AssemblyLine);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, GTModHandler.getModItem("GalaxySpace", "item.RocketControlComputer", 1, 4))
            .metadata(RESEARCH_TIME, 2 * HOURS)
            .itemInputs(
                GTModHandler.getModItem("dreamcraft", "item.HeavyDutyPlateTier5", 8, 0),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedplate", 32, 88),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32606),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32615),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32635),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32655),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32685),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32695),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 8L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 4L))
            .fluidInputs(
                FluidRegistry.getFluidStack("lubricant", 128000),
                FluidRegistry.getFluidStack("molten.solderingalloy", 18432),
                FluidRegistry.getFluidStack("molten.tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid", 2304))
            .itemOutputs(GTNLItemList.MeteorMinerSchematic1.get(1))
            .eut(TierEU.RECIPE_LuV)
            .duration(30 * SECONDS)
            .addTo(AssemblyLine);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, GTModHandler.getModItem("GalaxySpace", "item.RocketControlComputer", 1, 7))
            .metadata(RESEARCH_TIME, 4 * HOURS)
            .itemInputs(
                GTModHandler.getModItem("dreamcraft", "item.HeavyDutyPlateTier7", 8, 0),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 32, 17317),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 32608),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 32617),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 32637),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 32657),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 32687),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 32677),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 32697),
                GTModHandler.getModItem("gregtech", "gt.blockframes", 32, 129),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 8L))
            .fluidInputs(
                FluidRegistry.getFluidStack("lubricant", 256000),
                FluidRegistry.getFluidStack("molten.indalloy140", 128000),
                FluidRegistry.getFluidStack("molten.naquadahalloy", 144 * 128),
                FluidRegistry.getFluidStack("molten.longasssuperconductornameforuvwire", 144 * 32))
            .itemOutputs(GTNLItemList.MeteorMinerSchematic2.get(1))
            .eut(TierEU.RECIPE_UHV)
            .duration(120 * SECONDS)
            .addTo(AssemblyLine);
    }
}
