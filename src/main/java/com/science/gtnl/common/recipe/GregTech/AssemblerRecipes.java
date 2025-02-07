package com.science.gtnl.common.recipe.GregTech;

import static com.science.gtnl.Mods.ScienceNotLeisure;
import static gregtech.api.enums.Mods.*;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.materials.MaterialPool;
import com.science.gtnl.common.recipe.IRecipePool;

import bartworks.system.material.WerkstoffLoader;
import goodgenerator.util.ItemRefer;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsBotania;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.item.ModItems;
import gtPlusPlus.core.material.MaterialMisc;
import gtPlusPlus.core.material.MaterialsAlloy;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class AssemblerRecipes implements IRecipePool {

    final RecipeMap<?> As = RecipeMaps.assemblerRecipes;

    @Override
    public void loadRecipes() {

        ItemStack MEoutputBus = ItemList.Hatch_Output_Bus_ME.get(1L);
        NBTTagCompound MEoutputBusType = MEoutputBus.getTagCompound();
        if (MEoutputBusType != null) {
            MEoutputBusType.setLong("baseCapacity", 9223372036854775807L);
        } else {
            MEoutputBusType = new NBTTagCompound();
            MEoutputBusType.setLong("baseCapacity", 9223372036854775807L);
            MEoutputBus.setTagCompound(MEoutputBusType);
        }

        ItemStack MEoutputHatch = ItemList.Hatch_Output_ME.get(1L);
        NBTTagCompound MEoutputHatchType = MEoutputHatch.getTagCompound();
        if (MEoutputHatchType != null) {
            MEoutputHatchType.setLong("baseCapacity", 9223372036854775807L);
        } else {
            MEoutputHatchType = new NBTTagCompound();
            MEoutputHatchType.setLong("baseCapacity", 9223372036854775807L);
            MEoutputHatch.setTagCompound(MEoutputHatchType);
        }

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Battery_RE_ULV_Tantalum.get(4L),
                ItemList.Circuit_Parts_Wiring_Basic.get(4L),
                ItemList.Circuit_Parts_Coil.get(4L),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gem, 1),
                ItemList.Circuit_Primitive.get(1L))
            .fluidInputs(Materials.Tin.getMolten(144))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 9))
            .specialValue(0)
            .noOptimize()
            .duration(50)
            .eut(30)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_Advanced.get(4L),
                ItemList.Circuit_Parts_Wiring_Elite.get(4L),
                ItemList.Circuit_Parts_Wiring_Advanced.get(4L),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gem, 1),
                GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 1, 9))
            .fluidInputs(Materials.Tin.getMolten(144))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 10))
            .specialValue(0)
            .noOptimize()
            .duration(90)
            .eut(120)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_Advanced.get(8L),
                ItemList.Circuit_Parts_Wiring_Elite.get(8L),
                ItemList.Circuit_Parts_Wiring_Advanced.get(8L),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gem, 1),
                GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 1, 10))
            .fluidInputs(Materials.Tin.getMolten(144))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 11))
            .specialValue(0)
            .noOptimize()
            .duration(150)
            .eut(480)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_DiodeSMD.get(4L),
                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                ItemList.Circuit_Parts_CapacitorSMD.get(4L),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gemFlawless, 1),
                GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 1, 11))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 12))
            .specialValue(0)
            .noOptimize()
            .duration(230)
            .eut(1920)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_DiodeSMD.get(8L),
                ItemList.Circuit_Parts_TransistorSMD.get(8L),
                ItemList.Circuit_Parts_CapacitorSMD.get(8L),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 4, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gemFlawless, 1),
                GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 1, 12))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 13))
            .specialValue(0)
            .noOptimize()
            .duration(330)
            .eut(7680)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_DiodeASMD.get(4L),
                ItemList.Circuit_Parts_TransistorASMD.get(4L),
                ItemList.Circuit_Parts_CapacitorASMD.get(4L),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 4, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gemFlawless, 1),
                GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 1, 13))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 14))
            .specialValue(0)
            .noOptimize()
            .duration(450)
            .eut(30720)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_DiodeASMD.get(8L),
                ItemList.Circuit_Parts_TransistorASMD.get(8L),
                ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 4, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gemFlawless, 1),
                GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 1, 14))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 15))
            .specialValue(0)
            .noOptimize()
            .duration(570)
            .eut(122880)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTNLItemList.BiowareSMDDiode.get(16),
                GTNLItemList.BiowareSMDCapacitor.get(16),
                GTNLItemList.BiowareSMDTransistor.get(16),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 8, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gemExquisite, 1),
                GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 1, 15))
            .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(144))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 16))
            .specialValue(0)
            .noOptimize()
            .duration(710)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_DiodeXSMD.get(16L),
                ItemList.Circuit_Parts_TransistorXSMD.get(16L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(16L),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 8, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gemExquisite, 1),
                GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 1, 16))
            .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(288))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 17))
            .specialValue(0)
            .noOptimize()
            .duration(730)
            .eut(1966080)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTNLItemList.ExoticSMDDiode.get(16),
                GTNLItemList.ExoticSMDCapacitor.get(16),
                GTNLItemList.ExoticSMDTransistor.get(16),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 8, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gemExquisite, 1),
                GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 1, 17))
            .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(432))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 18))
            .specialValue(0)
            .noOptimize()
            .duration(750)
            .eut(7864320)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTNLItemList.CosmicSMDDiode.get(16),
                GTNLItemList.CosmicSMDCapacitor.get(16),
                GTNLItemList.CosmicSMDTransistor.get(16),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 8, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gemExquisite, 1),
                GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 1, 18))
            .fluidInputs(MaterialPool.SuperMutatedLivingSolder.getFluidOrGas(288))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 19))
            .specialValue(0)
            .noOptimize()
            .duration(770)
            .eut(31457280)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTNLItemList.TemporallySMDDiode.get(16),
                GTNLItemList.TemporallySMDCapacitor.get(16),
                GTNLItemList.TemporallySMDTransistor.get(16),
                GTModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 8, 3),
                WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.gemExquisite, 1),
                GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 1, 19))
            .fluidInputs(MaterialPool.SuperMutatedLivingSolder.getFluidOrGas(432))
            .itemOutputs(GTModHandler.getModItem(ScienceNotLeisure.ID, "MetaItem", 4, 20))
            .specialValue(0)
            .noOptimize()
            .duration(790)
            .eut(125829120)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NaquadahAlloy, 8),
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Silicon, 8),
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Naquadah, 4))
            .fluidInputs(MaterialPool.Polyimide.getFluidOrGas(288))
            .itemOutputs(GTNLItemList.BiowareSMDCapacitor.get(16))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NaquadahAlloy, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lutetium, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 1))
            .fluidInputs(MaterialPool.Polyimide.getFluidOrGas(288))
            .itemOutputs(GTNLItemList.BiowareSMDDiode.get(16))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NaquadahAlloy, 8),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Naquadria, 1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Tritanium, 1))
            .fluidInputs(MaterialPool.Polyimide.getFluidOrGas(288))
            .itemOutputs(GTNLItemList.BiowareSMDResistor.get(16))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NaquadahAlloy, 8),
                MaterialPool.Germaniumtungstennitride.get(OrePrefixes.plate, 2),
                MaterialsAlloy.SILICON_CARBIDE.getPlate(2))
            .fluidInputs(MaterialPool.Polyimide.getFluidOrGas(288))
            .itemOutputs(GTNLItemList.BiowareSMDTransistor.get(16))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NaquadahAlloy, 8),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.NaquadahAlloy, 1))
            .fluidInputs(MaterialPool.Polyimide.getFluidOrGas(288))
            .itemOutputs(GTNLItemList.BiowareSMDInductor.get(16))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(491520)
            .requiresCleanRoom()
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.copyAmount(0, ItemList.Circuit_Primitive.get(1L)),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GTModHandler.getModItem(Minecraft.ID, "redstone", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 20))
            .itemOutputs(GTNLItemList.VerySimpleCircuit.get(2))
            .specialValue(0)
            .noOptimize()
            .duration(40)
            .eut(7)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1)),
                GTNLItemList.VerySimpleCircuit.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.RedAlloy, 1))
            .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 20))
            .itemOutputs(GTNLItemList.SimpleCircuit.get(2))
            .specialValue(0)
            .noOptimize()
            .duration(80)
            .eut(16)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.copyAmount(0, ItemList.Circuit_Good.get(1L)),
                GTModHandler.getModItem(Minecraft.ID, "paper", 1, 0),
                GTNLItemList.SimpleCircuit.get(2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 1),
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Diamond, 1))
            .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 20))
            .itemOutputs(GTNLItemList.BasicCircuit.get(2))
            .specialValue(0)
            .noOptimize()
            .duration(160)
            .eut(30)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1)),
                ItemList.Circuit_Board_Coated_Basic.get(1L),
                GTNLItemList.BasicCircuit.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Obsidian, 1),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 1))
            .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 20))
            .itemOutputs(GTNLItemList.AdvancedCircuit.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(80)
            .eut(120)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Board_Phenolic_Good.get(1L),
                GTNLItemList.AdvancedCircuit.get(1),
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.RedAlloy, 8))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(GTNLItemList.EliteCircuit.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(480)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem(GTPlusPlus.ID, "blockCompressedObsidian", 1, 6),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 4),
                GTModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 7))
            .itemOutputs(GTNLItemList.FortifyGlowstone.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(7680)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem(Botania.ID, "pylon", 1, 2),
                GTModHandler.getModItem(Botania.ID, "pylon", 2, 1),
                GTModHandler.getModItem(Botania.ID, "pylon", 4, 0),
                GTModHandler.getModItem(Botania.ID, "manaResource", 16, 7),
                GTModHandler.getModItem(Botania.ID, "manaResource", 16, 8))
            .itemOutputs(GTNLItemList.ActivatedGaiaPylon.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(7680)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(1),
                ItemList.Hatch_Input_LuV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, MaterialsBotania.Terrasteel, 8),
                GTModHandler.getModItem(Botania.ID, "pylon", 4, 1),
                GTModHandler.getModItem(Botania.ID, "pool", 1, 3),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 2L))
            .itemOutputs(GTNLItemList.FluidManaInputHatch.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(30720)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(2),
                ItemList.OreDrill2.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8),
                new ItemStack(GregTechAPI.sLaserRender, 4, 0),
                ItemList.Emitter_EV.get(2L),
                ItemList.Sensor_EV.get(2L),
                GTOreDictUnificator.get(OrePrefixes.gear, Materials.TungstenSteel, 4),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 2L))
            .fluidInputs(Materials.SolderingAlloy.getMolten(9216))
            .itemOutputs(GTNLItemList.MeteorMiner.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(1200)
            .eut(30720)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Casing_Coil_Superconductor.get(1L),
                com.dreammaster.item.ItemList.LaserEmitter.getIS(4),
                GTOreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4),
                new ItemStack(ModItems.itemDehydratorCoilWire, 8, 2),
                ItemList.LuV_Coil.get(4L),
                ItemList.Emitter_IV.get(2L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 16))
            .fluidInputs(Materials.SolderingAlloy.getMolten(9216))
            .itemOutputs(GTNLItemList.LaserBeacon.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(400)
            .eut(30720)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Machine_IV_Assembler.get(4L),
                ItemRefer.Precise_Assembler.get(2),
                ItemList.Machine_Multi_Assemblyline.get(1L),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 16),
                ItemList.Robot_Arm_IV.get(8L),
                ItemList.Casing_Gearbox_TungstenSteel.get(8L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 8L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 10L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 12L))
            .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(256000))
            .itemOutputs(GTNLItemList.ComponentAssembler.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(7680)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Hull_IV.get(4L),
                ItemList.Casing_Autoclave.get(16L),
                GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Desh, 32),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 8L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 4L),
                ItemList.Super_Tank_EV.get(4L),
                ItemList.Electric_Motor_IV.get(4L),
                ItemList.Electric_Pump_IV.get(8L),
                ItemList.Steam_Valve_IV.get(16L))
            .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(64000))
            .itemOutputs(GTNLItemList.PetrochemicalPlant.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(1200)
            .eut(7680)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Hull_EV.get(1L),
                ItemList.Robot_Arm_EV.get(16L),
                ItemList.Conveyor_Module_EV.get(4L),
                ItemList.Electric_Motor_EV.get(4L),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 32),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 8L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 4L),
                ItemList.Casing_CleanStainlessSteel.get(32L),
                GregtechItemList.GTPP_Casing_EV.get(8L))
            .fluidInputs(Materials.SolderingAlloy.getMolten(18432))
            .itemOutputs(GTNLItemList.ProcessingArray.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(1920)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(16), ItemList.Machine_Multi_BlastFurnace.get(1L))
            .itemOutputs(GTNLItemList.MegaBlastFurnace.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(50)
            .eut(16)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Neutronium, 4L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 4L),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1L),
                GTUtility.getIntegratedCircuit(12))
            .itemOutputs(GTNLItemList.NeutroniumPipeCasing.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(30)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1L),
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Neutronium, 2L),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 4L),
                GTUtility.getIntegratedCircuit(3))
            .itemOutputs(GTNLItemList.NeutroniumGearbox.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(122880)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Europium, 8L),
                ItemList.Electric_Motor_UHV.get(16L),
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.HSSS, 16L),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Infinity, 8L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 16L),
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Naquadria, 64L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 4L),
                MaterialsAlloy.STELLITE.getPlate(32))
            .fluidInputs(Materials.SolderingAlloy.getMolten(1296))
            .itemOutputs(GTNLItemList.RareEarthCentrifugal.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(1000)
            .eut(7864320)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(16), GregtechItemList.Machine_Adv_BlastFurnace.get(1L))
            .itemOutputs(GTNLItemList.BlazeBlastFurnace.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(50)
            .eut(16)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(16), GregtechItemList.Industrial_Cryogenic_Freezer.get(1L))
            .itemOutputs(GTNLItemList.ColdIceFreezer.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(50)
            .eut(16)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(16), ItemList.Machine_Multi_LargeChemicalReactor.get(1L))
            .itemOutputs(GTNLItemList.ChemicalPlant.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(50)
            .eut(16)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(6),
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.StainlessSteel, 2L),
                ItemList.Casing_SolidSteel.get(1L),
                GTOreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1L),
                ItemList.Electric_Motor_HV.get(2L))
            .fluidInputs(Materials.Polytetrafluoroethylene.getMolten(576))
            .itemOutputs(GTNLItemList.HeatVent.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(480)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(16), ItemList.Machine_Multi_VacuumFreezer.get(1L))
            .itemOutputs(GTNLItemList.VacuumFreezer.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(50)
            .eut(16)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Casing_ZPM.get(1L),
                MaterialsAlloy.ABYSSAL.getPlateDouble(16),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 4),
                ItemList.Field_Generator_UV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.NaquadahAlloy, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.BlackPlutonium, 32),
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Infinity, 2))
            .fluidInputs(new FluidStack(MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getPlasma(), 16000))
            .itemOutputs(GTNLItemList.Antifreeze_Heatproof_Machine_Casing.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(1966080)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                MaterialPool.MolybdenumDisilicide.get(OrePrefixes.ring, 32),
                CustomItemList.MicaInsulatorFoil.get(16L))
            .fluidInputs(MaterialPool.HSLASteel.getMolten(144))
            .itemOutputs(GTNLItemList.MolybdenumDisilicideCoil.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(500)
            .eut(1920)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem(EnderIO.ID, "blockSolarPanel", 1, 0),
                GTModHandler.getModItem(EnderIO.ID, "itemPowerConduit", 4, 0),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 4L),
                GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.RedAlloy, 4L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L))
            .itemOutputs(GTNLItemList.EnergeticPhotovoltaicBlock.get(2))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(30)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem(EnderIO.ID, "blockSolarPanel", 1, 1),
                GTModHandler.getModItem(EnderIO.ID, "itemPowerConduit", 8, 0),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 8L),
                GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.ElectricalSteel, 4L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2L))
            .itemOutputs(GTNLItemList.AdvancedPhotovoltaicBlock.get(2))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(120)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTModHandler.getModItem(EnderIO.ID, "blockSolarPanel", 1, 2),
                GTModHandler.getModItem(EnderIO.ID, "itemPowerConduit", 16, 0),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 16L),
                GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.VibrantAlloy, 4L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2L))
            .itemOutputs(GTNLItemList.VibrantPhotovoltaicBlock.get(2))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(480)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TungstenCarbide, 3L),
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Ultimet, 4L),
                ItemList.Casing_MiningOsmiridium.get(1L),
                ItemList.Electric_Motor_IV.get(1L))
            .itemOutputs(GTNLItemList.CrushingWheels.get(2))
            .specialValue(0)
            .noOptimize()
            .duration(50)
            .eut(16)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(GTUtility.getIntegratedCircuit(16), GregtechItemList.Industrial_MacerationStack.get(1L))
            .itemOutputs(GTNLItemList.LargeMacerationTower.get(1))
            .specialValue(0)
            .noOptimize()
            .duration(50)
            .eut(16)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Hatch_Output_Bus_EV.get(1L),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 30))
            .itemOutputs(MEoutputBus)
            .specialValue(0)
            .noOptimize()
            .duration(300)
            .eut(480)
            .addTo(As);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Hatch_Output_EV.get(1L),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 30))
            .itemOutputs(MEoutputHatch)
            .specialValue(0)
            .noOptimize()
            .duration(300)
            .eut(480)
            .addTo(As);
    }
}
