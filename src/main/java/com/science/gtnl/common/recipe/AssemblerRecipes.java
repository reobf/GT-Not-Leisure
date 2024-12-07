package com.science.gtnl.common.recipe;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.common.materials.MaterialPool;

import gregtech.api.enums.GTValues;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTUtility;

public class AssemblerRecipes implements IRecipePool {

    final RecipeMap As = RecipeMaps.assemblerRecipes;

    @Override
    public void loadRecipes() {
        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32499),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32716),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 4, 32014),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgem", 1, 36),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32700))
            .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticULV", 4))
            .specialValue(0)
            .noOptimize()
            .duration(50)
            .eut(30)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32715),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32718),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 32717),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgem", 1, 36),
                GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticULV", 1))
            .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticLV", 4))
            .specialValue(0)
            .noOptimize()
            .duration(90)
            .eut(120)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 32715),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 32718),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 32717),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgem", 1, 36),
                GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticLV", 1))
            .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticMV", 4))
            .specialValue(0)
            .noOptimize()
            .duration(150)
            .eut(480)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 4, 32016),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 4, 32020),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 4, 32018),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgemFlawless", 1, 36),
                GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticMV", 1))
            .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticHV", 4))
            .specialValue(0)
            .noOptimize()
            .duration(230)
            .eut(1920)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 8, 32016),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 8, 32020),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 8, 32018),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 4, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgemFlawless", 1, 36),
                GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticHV", 1))
            .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticEV", 4))
            .specialValue(0)
            .noOptimize()
            .duration(330)
            .eut(7680)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 4, 32025),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 4, 32027),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 4, 32026),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 4, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgemFlawless", 1, 36),
                GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticEV", 1))
            .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticIV", 4))
            .specialValue(0)
            .noOptimize()
            .duration(450)
            .eut(30720)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 8, 32025),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 8, 32027),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 8, 32026),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 4, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgemFlawless", 1, 36),
                GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticIV", 1))
            .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticLuV", 4))
            .specialValue(0)
            .noOptimize()
            .duration(570)
            .eut(122880)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDDiode", 16),
                GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDCapacitor", 16),
                GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDTransistor", 16),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 8, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgemExquisite", 1, 36),
                GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticLuV", 1))
            .fluidInputs(FluidRegistry.getFluidStack("molten.mutatedlivingsolder", 144))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticZPM", 4))
            .specialValue(0)
            .noOptimize()
            .duration(710)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 16, 32179),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 16, 32181),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 16, 32180),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 8, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgemExquisite", 1, 36),
                GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticZPM", 1))
            .fluidInputs(FluidRegistry.getFluidStack("molten.mutatedlivingsolder", 288))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticUV", 4))
            .specialValue(0)
            .noOptimize()
            .duration(730)
            .eut(1966080)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("ScienceNotLeisure", "ExoticSMDDiode", 16),
                GTModHandler.getModItem("ScienceNotLeisure", "ExoticSMDCapacitor", 16),
                GTModHandler.getModItem("ScienceNotLeisure", "ExoticSMDTransistor", 16),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 8, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgemExquisite", 1, 36),
                GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticUV", 1))
            .fluidInputs(FluidRegistry.getFluidStack("molten.mutatedlivingsolder", 432))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticUHV", 4))
            .specialValue(0)
            .noOptimize()
            .duration(750)
            .eut(7864320)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("ScienceNotLeisure", "CosmicSMDDiode", 16),
                GTModHandler.getModItem("ScienceNotLeisure", "CosmicSMDCapacitor", 16),
                GTModHandler.getModItem("ScienceNotLeisure", "CosmicSMDTransistor", 16),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 8, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgemExquisite", 1, 36),
                GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticUHV", 1))
            .fluidInputs(MaterialPool.SuperMutatedLivingSolder.getFluidOrGas(288))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticUEV", 4))
            .specialValue(0)
            .noOptimize()
            .duration(770)
            .eut(31457280)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("ScienceNotLeisure", "TemporallySMDDiode", 16),
                GTModHandler.getModItem("ScienceNotLeisure", "TemporallySMDCapacitor", 16),
                GTModHandler.getModItem("ScienceNotLeisure", "TemporallySMDTransistor", 16),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 8, 3),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedgemExquisite", 1, 36),
                GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticUEV", 1))
            .fluidInputs(MaterialPool.SuperMutatedLivingSolder.getFluidOrGas(432))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "CircuitResonaticUIV", 4))
            .specialValue(0)
            .noOptimize()
            .duration(790)
            .eut(125829120)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.02", 8, 19325),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 29020),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 29324))
            .fluidInputs(MaterialPool.Polyimide.getFluidOrGas(288))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDCapacitor", 16))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.02", 8, 19325),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2078),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2329))
            .fluidInputs(MaterialPool.Polyimide.getFluidOrGas(288))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDDiode", 16))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.02", 8, 19325),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 17327),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 17329))
            .fluidInputs(MaterialPool.Polyimide.getFluidOrGas(288))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDResistor", 16))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.02", 8, 19325),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGeneratedplate", 2, 20046),
                GTModHandler.getModItem("miscutils", "itemPlateSiliconCarbide", 2))
            .fluidInputs(MaterialPool.Polyimide.getFluidOrGas(288))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDTransistor", 16))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.02", 8, 19325),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 28325))
            .fluidInputs(MaterialPool.Polyimide.getFluidOrGas(288))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "BiowareSMDInductor", 16))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32700)),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 17305),
                GTModHandler.getModItem("minecraft", "redstone", 1))
            .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 20))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "VerySimpleCircuit", 2))
            .specialValue(0)
            .noOptimize()
            .duration(40)
            .eut(7)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("IC2", "itemPartCircuit", 1)),
                GTModHandler.getModItem("ScienceNotLeisure", "VerySimpleCircuit", 1),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 17032),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2308))
            .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 20))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "SimpleCircuit", 2))
            .specialValue(0)
            .noOptimize()
            .duration(80)
            .eut(16)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32702)),
                GTModHandler.getModItem("minecraft", "paper", 1),
                GTModHandler.getModItem("ScienceNotLeisure", "SimpleCircuit", 2),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 17304),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 1500))
            .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 20))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "BasicCircuit", 2))
            .specialValue(0)
            .noOptimize()
            .duration(160)
            .eut(30)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("IC2", "itemPartCircuitAdv", 1)),
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 1, 32100),
                GTModHandler.getModItem("ScienceNotLeisure", "BasicCircuit", 1),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 17305),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 1804),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 27308))
            .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 20))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "AdvancedCircuit", 1))
            .specialValue(0)
            .noOptimize()
            .duration(80)
            .eut(120)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("gregtech", "gt.metaitem.03", 1, 32101),
                GTModHandler.getModItem("ScienceNotLeisure", "AdvancedCircuit", 4),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 8, 29308))
            .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 20))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "EliteCircuit", 4))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(480)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("miscutils", "blockCompressedObsidian", 1, 6),
                GTModHandler.getModItem("gregtech", "gt.blockframes", 4, 306),
                GTModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 7))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "FortifyGlowstone", 1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(7680)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem("Botania", "pylon", 1, 2),
                GTModHandler.getModItem("Botania", "pylon", 2, 1),
                GTModHandler.getModItem("Botania", "pylon", 4, 0),
                GTModHandler.getModItem("Botania", "manaResource", 16, 7),
                GTModHandler.getModItem("Botania", "manaResource", 16, 8))
            .itemOutputs(GTModHandler.getModItem("ScienceNotLeisure", "MetaItem", 1, 5))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(7680)
            .addTo(As);
    }
}
