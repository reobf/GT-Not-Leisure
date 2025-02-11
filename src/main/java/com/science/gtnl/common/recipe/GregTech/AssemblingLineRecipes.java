package com.science.gtnl.common.recipe.GregTech;

import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GTRecipeBuilder.*;
import static gregtech.api.util.GTRecipeConstants.*;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.block.BlockList;
import com.science.gtnl.Utils.enums.TierEU;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.block.Casings.BasicBlocks;
import com.science.gtnl.common.materials.MaterialPool;
import com.science.gtnl.common.recipe.IRecipePool;

import bartworks.common.loaders.ItemRegistry;
import bartworks.system.material.WerkstoffLoader;
import goodgenerator.util.ItemRefer;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsBotania;
import gregtech.api.enums.MaterialsKevlar;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.material.MaterialMisc;
import gtPlusPlus.core.material.MaterialsAlloy;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.core.recipe.common.CI;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import tectech.recipe.TTRecipeAdder;
import tectech.thing.CustomItemList;

public class AssemblingLineRecipes implements IRecipePool {

    @Override
    public void loadRecipes() {

        ItemStack CrystalStuddedCosmicNeutroniumWand = GTModHandler.getModItem(Thaumcraft.ID, "WandCasting", 1, 9000);
        NBTTagCompound CrystalStuddedCosmicNeutroniumWandType = CrystalStuddedCosmicNeutroniumWand.getTagCompound();
        if (CrystalStuddedCosmicNeutroniumWandType != null) {
            CrystalStuddedCosmicNeutroniumWandType.setString("cap", "matrix");
            CrystalStuddedCosmicNeutroniumWandType.setString("rod", "infinity");
            CrystalStuddedCosmicNeutroniumWandType.setInteger("aer", 999999900);
            CrystalStuddedCosmicNeutroniumWandType.setInteger("aqua", 999999900);
            CrystalStuddedCosmicNeutroniumWandType.setInteger("ignis", 999999900);
            CrystalStuddedCosmicNeutroniumWandType.setInteger("ordo", 999999900);
            CrystalStuddedCosmicNeutroniumWandType.setInteger("perditio", 999999900);
            CrystalStuddedCosmicNeutroniumWandType.setInteger("terra", 999999900);
        } else {
            CrystalStuddedCosmicNeutroniumWandType = new NBTTagCompound();
            CrystalStuddedCosmicNeutroniumWandType.setString("cap", "matrix");
            CrystalStuddedCosmicNeutroniumWandType.setString("rod", "infinity");
            CrystalStuddedCosmicNeutroniumWandType.setInteger("aer", 999999900);
            CrystalStuddedCosmicNeutroniumWandType.setInteger("aqua", 999999900);
            CrystalStuddedCosmicNeutroniumWandType.setInteger("ignis", 999999900);
            CrystalStuddedCosmicNeutroniumWandType.setInteger("ordo", 999999900);
            CrystalStuddedCosmicNeutroniumWandType.setInteger("perditio", 999999900);
            CrystalStuddedCosmicNeutroniumWandType.setInteger("terra", 999999900);
            CrystalStuddedCosmicNeutroniumWand.setTagCompound(CrystalStuddedCosmicNeutroniumWandType);
        }

        TTRecipeAdder.addResearchableAssemblylineRecipe(
            ItemList.Circuit_Parts_Chip_Bioware.get(1),
            10000000,
            2500,
            (int) TierEU.RECIPE_UV,
            1,
            new ItemStack[] { ItemList.Circuit_Board_Bio_Ultra.get(1), GTNLItemList.BiowareSMDCapacitor.get(8),
                GTNLItemList.BiowareSMDDiode.get(8), GTNLItemList.BiowareSMDResistor.get(8),
                GTNLItemList.BiowareSMDTransistor.get(8), GTNLItemList.BiowareSMDInductor.get(8),
                MaterialPool.Polyetheretherketone.get(OrePrefixes.foil, 2), ItemList.Circuit_Chip_Biocell.get(8),
                ItemList.Circuit_Parts_Chip_Bioware.get(8),
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Naquadah, 16),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NiobiumTitanium, 4) },
            new FluidStack[] { Materials.BioMediumSterilized.getFluid(1000), Materials.Plastic.getMolten(1296),
                Materials.PolyvinylChloride.getMolten(864), Materials.SolderingAlloy.getMolten(1296) },
            ItemList.Circuit_Chip_BioCPU.get(8),
            16 * SECONDS,
            (int) TierEU.RECIPE_UV);

        TTRecipeAdder.addResearchableAssemblylineRecipe(
            kubatech.api.enums.ItemList.ExtremeIndustrialGreenhouse.get(1),
            256000,
            1024,
            (int) TierEU.RECIPE_UHV,
            1,
            new ItemStack[] { ItemList.Hull_UV.get(16), kubatech.api.enums.ItemList.ExtremeIndustrialGreenhouse.get(64),
                GTModHandler.getModItem(EnderIO.ID, "blockFarmStation", 64),
                GTModHandler.getModItem(RandomThings.ID, "fertilizedDirt", 64), ItemList.Field_Generator_UV.get(16),
                ItemList.Emitter_UV.get(16), ItemList.Sensor_UV.get(16),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 8L),
                GTModHandler.getModItem(Botania.ID, "overgrowthSeed", 8),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 16L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.CosmicNeutronium, 64L),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Neutronium, 64L),
                GregtechItemList.Laser_Lens_Special.get(1), ItemList.Compressor_Casing.get(16),
                ItemList.Compressor_Pipe_Casing.get(16) },
            new FluidStack[] { Materials.BioMediumSterilized.getFluid(320000),
                MaterialsAlloy.INDALLOY_140.getFluidStack(128000), Materials.Lubricant.getFluid(256000),
                Materials.Naquadria.getMolten(36864) },
            GTNLItemList.EdenGarden.get(1),
            30 * SECONDS,
            (int) TierEU.RECIPE_UHV);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, GTModHandler.getModItem(Botania.ID, "lexicon", 1, 0))
            .metadata(RESEARCH_TIME, 4 * HOURS)
            .itemInputs(
                ItemList.Hull_ZPM.get(8),
                GTModHandler.getModItem(Botania.ID, "pylon", 4, 2),
                GTModHandler.getModItem(Botania.ID, "pool", 16, 3),
                GTModHandler.getModItem(Botania.ID, "spreader", 8, 3),
                CustomItemList.LASERpipe.get(64),
                GTModHandler.getModItem(Botania.ID, "alfheimPortal", 64, 0),
                GTModHandler.getModItem(Botania.ID, "runeAltar", 64, 0),
                GTModHandler.getModItem(Botania.ID, "corporeaSpark", 64, 0),
                ItemList.Sensor_ZPM.get(16),
                ItemList.Field_Generator_ZPM.get(16),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 8L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 4L),
                ItemList.RadiantNaquadahAlloyCasing.get(16),
                ItemList.Casing_Fusion_Coil.get(16),
                GTModHandler.getModItem(Botania.ID, "storage", 32, 0))
            .fluidInputs(
                MaterialsBotania.ElvenElementium.getMolten(144 * 64),
                MaterialsBotania.Terrasteel.getMolten(144 * 32),
                MaterialsAlloy.INDALLOY_140.getFluidStack(256000))
            .itemOutputs(GTNLItemList.TeleportationArrayToAlfheim.get(1))
            .eut(TierEU.RECIPE_UV)
            .duration(300 * SECONDS)
            .addTo(AssemblyLine);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, GTModHandler.getModItem(GalaxySpace.ID, "item.RocketControlComputer", 1, 4))
            .metadata(RESEARCH_TIME, 2 * HOURS)
            .itemInputs(
                com.dreammaster.gthandler.CustomItemList.HeavyDutyPlateTier5.get(8),
                WerkstoffLoader.LuVTierMaterial.get(OrePrefixes.plate, 32),
                ItemList.Electric_Motor_LuV.get(4),
                ItemList.Electric_Pump_LuV.get(4),
                ItemList.Conveyor_Module_LuV.get(4),
                ItemList.Robot_Arm_LuV.get(4),
                ItemList.Emitter_LuV.get(4),
                ItemList.Sensor_LuV.get(4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 8L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 4L))
            .fluidInputs(
                Materials.Lubricant.getFluid(128000),
                Materials.SolderingAlloy.getMolten(18432),
                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid.getMolten(2304))
            .itemOutputs(GTNLItemList.MeteorMinerSchematic1.get(1))
            .eut(TierEU.RECIPE_LuV)
            .duration(30 * SECONDS)
            .addTo(AssemblyLine);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, GTModHandler.getModItem(GalaxySpace.ID, "item.RocketControlComputer", 1, 7))
            .metadata(RESEARCH_TIME, 4 * HOURS)
            .itemInputs(
                com.dreammaster.gthandler.CustomItemList.HeavyDutyPlateTier7.get(8),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 32),
                ItemList.Electric_Motor_UV.get(4),
                ItemList.Electric_Pump_UV.get(4),
                ItemList.Conveyor_Module_UV.get(4),
                ItemList.Robot_Arm_UV.get(4),
                ItemList.Emitter_UV.get(4),
                ItemList.Sensor_UV.get(4),
                ItemList.Field_Generator_UV.get(4),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 32),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 8L))
            .fluidInputs(
                Materials.Lubricant.getFluid(256000),
                MaterialsAlloy.INDALLOY_140.getFluidStack(128000),
                Materials.NaquadahAlloy.getMolten(144 * 128),
                Materials.Longasssuperconductornameforuvwire.getMolten(144 * 32))
            .itemOutputs(GTNLItemList.MeteorMinerSchematic2.get(1))
            .eut(TierEU.RECIPE_UHV)
            .duration(120 * SECONDS)
            .addTo(AssemblyLine);

        TTRecipeAdder.addResearchableAssemblylineRecipe(
            ItemList.MixerUIV.get(1),
            102400000,
            25565,
            (int) TierEU.RECIPE_UXV,
            1,
            new ItemStack[] { GregtechItemList.Mega_AlloyBlastSmelter.get(64),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Infinity, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Infinity, 32),
                GTModHandler.getModItem(EternalSingularity.ID, "eternal_singularity", 4, 0),
                ItemList.Electric_Motor_UEV.get(32), ItemList.Electric_Pump_UEV.get(32),
                ItemList.Field_Generator_UEV.get(16),
                GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Neutronium, 32),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 32L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UEV, 8L),
                kubatech.api.enums.ItemList.DEFCCasingBase.get(64), kubatech.api.enums.ItemList.DEFCCasingT3.get(32),
                ItemList.Casing_Dim_Injector.get(16),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Neutronium, 16) },
            new FluidStack[] { MaterialsUEVplus.TranscendentMetal.getMolten(73728),
                MaterialsElements.STANDALONE.HYPOGEN.getFluidStack(73728), Materials.Neutronium.getMolten(294912),
                MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(540000) },
            GTNLItemList.SmeltingMixingFurnace.get(1),
            120 * SECONDS,
            (int) TierEU.RECIPE_UMV);

        GTValues.RA.stdBuilder()
            .metadata(
                RESEARCH_ITEM,
                GTModHandler.getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.arcane.assembler", 1))
            .metadata(RESEARCH_TIME, 114514 * SECONDS)
            .itemInputs(
                GTModHandler.getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.arcane.assembler", 64),
                GTModHandler.getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.arcane.assembler", 64),
                GTModHandler.getModItem(Thaumcraft.ID, "blockStoneDevice", 64, 2),
                GTModHandler.getModItem(Thaumcraft.ID, "blockStoneDevice", 64, 2),
                CrystalStuddedCosmicNeutroniumWand,
                GTModHandler.getModItem(Avaritia.ID, "Akashic_Record", 1),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UIV, 16L),
                ItemList.Robot_Arm_UEV.get(32),
                ItemList.Field_Generator_UEV.get(16),
                MaterialsElements.STANDALONE.HYPOGEN.getPlateDense(32),
                GTModHandler.getModItem(EternalSingularity.ID, "eternal_singularity", 8),
                ItemList.EnergisedTesseract.get(8),
                GTModHandler.getModItem(WitchingGadgets.ID, "item.WG_Material", 1, 7),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 64, 56))
            .fluidInputs(
                MaterialsUEVplus.ExcitedDTEC.getFluid(64000),
                Materials.StableBaryonicMatter.getFluid(64000),
                MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(64000))
            .itemOutputs(GTNLItemList.IndustrialArcaneAssembler.get(1))
            .eut(TierEU.RECIPE_UIV)
            .duration(300 * SECONDS)
            .addTo(AssemblyLine);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, new ItemStack(Item.getItemFromBlock(BasicBlocks.NeutronCollector), 1))
            .metadata(RESEARCH_TIME, 114514 * SECONDS)
            .itemInputs(
                new ItemStack(Item.getItemFromBlock(BasicBlocks.NeutronCollector), 1),
                new ItemStack(Item.getItemFromBlock(BasicBlocks.NeutronCollector), 1),
                new ItemStack(Item.getItemFromBlock(BasicBlocks.NeutronCollector), 1),
                new ItemStack(Item.getItemFromBlock(BasicBlocks.NeutronCollector), 1),
                ItemList.Electric_Motor_UHV.get(4L),
                ItemList.Field_Generator_UHV.get(4L),
                ItemList.Emitter_UHV.get(4L),
                ItemList.Sensor_UHV.get(4L),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 5L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 4L),
                GTModHandler.getModItem(Avaritia.ID, "Resource", 16, 5),
                GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUHV, 16L))
            .fluidInputs(Materials.CosmicNeutronium.getMolten(2304), Materials.Grade7PurifiedWater.getFluid(16000))
            .itemOutputs(new ItemStack(Item.getItemFromBlock(BasicBlocks.DenseNeutronCollector), 1))
            .eut(TierEU.RECIPE_UHV)
            .duration(60 * SECONDS)
            .addTo(AssemblyLine);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, new ItemStack(Item.getItemFromBlock(BasicBlocks.DenseNeutronCollector), 1))
            .metadata(RESEARCH_TIME, 114514 * SECONDS)
            .itemInputs(
                new ItemStack(Item.getItemFromBlock(BasicBlocks.DenseNeutronCollector), 1),
                new ItemStack(Item.getItemFromBlock(BasicBlocks.DenseNeutronCollector), 1),
                new ItemStack(Item.getItemFromBlock(BasicBlocks.DenseNeutronCollector), 1),
                new ItemStack(Item.getItemFromBlock(BasicBlocks.DenseNeutronCollector), 1),
                ItemList.Electric_Motor_UHV.get(8L),
                ItemList.Field_Generator_UHV.get(8L),
                ItemList.Emitter_UHV.get(8L),
                ItemList.Sensor_UHV.get(8L),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 10L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 8L),
                GTModHandler.getModItem(Avaritia.ID, "Resource", 32, 5),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUHV, 16L))
            .fluidInputs(Materials.CosmicNeutronium.getMolten(4608), Materials.Grade7PurifiedWater.getFluid(32000))
            .itemOutputs(new ItemStack(Item.getItemFromBlock(BasicBlocks.DenserNeutronCollector), 1))
            .eut(TierEU.RECIPE_UHV)
            .duration(120 * SECONDS)
            .addTo(AssemblyLine);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, new ItemStack(Item.getItemFromBlock(BasicBlocks.DenserNeutronCollector), 1))
            .metadata(RESEARCH_TIME, 114514 * SECONDS)
            .itemInputs(
                new ItemStack(Item.getItemFromBlock(BasicBlocks.DenserNeutronCollector), 1),
                new ItemStack(Item.getItemFromBlock(BasicBlocks.DenserNeutronCollector), 1),
                new ItemStack(Item.getItemFromBlock(BasicBlocks.DenserNeutronCollector), 1),
                new ItemStack(Item.getItemFromBlock(BasicBlocks.DenserNeutronCollector), 1),
                ItemList.Electric_Motor_UEV.get(8L),
                ItemList.Field_Generator_UEV.get(8L),
                ItemList.Emitter_UEV.get(8L),
                ItemList.Sensor_UEV.get(8L),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 32L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UEV, 16L),
                GTModHandler.getModItem(Avaritia.ID, "Resource", 64, 5),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUHV, 32L),
                GregtechItemList.Laser_Lens_Special.get(1))
            .fluidInputs(Materials.CosmicNeutronium.getMolten(9216), Materials.Grade8PurifiedWater.getFluid(64000))
            .itemOutputs(new ItemStack(Item.getItemFromBlock(BasicBlocks.DensestNeutronCollector), 1))
            .eut(TierEU.RECIPE_UEV)
            .duration(60 * SECONDS)
            .addTo(AssemblyLine);

        TTRecipeAdder.addResearchableAssemblylineRecipe(
            ItemRegistry.eic.copy(),
            51200000,
            51200,
            (int) TierEU.RECIPE_UEV,
            1,
            new ItemStack[] { GTUtility.copyAmount(4, ItemRegistry.eic.copy()),
                GTUtility.copyAmount(16, BlockList.NaquadahPlatedReinforcedStone.getIS()),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Osmiridium, 16),
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Osmiridium, 32),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.NaquadahAlloy, 64),
                ItemList.Electric_Motor_UV.get(64), ItemList.Electric_Piston_UV.get(32),
                ItemList.Conveyor_Module_UV.get(32), ItemList.Field_Generator_UV.get(16), ItemList.Robot_Arm_UV.get(16),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 8L),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 4L) },
            new FluidStack[] { Materials.Grade6PurifiedWater.getFluid(128000),
                MaterialsAlloy.BOTMIUM.getFluidStack(4608), WerkstoffLoader.Oganesson.getFluidOrGas(16000) },
            GTNLItemList.ElectricImplosionCompressor.get(1),
            120 * SECONDS,
            (int) TierEU.RECIPE_UMV);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, ItemList.Machine_Multi_BlastFurnace.get(1))
            .metadata(RESEARCH_TIME, 3600 * SECONDS)
            .itemInputs(
                GTUtility.copyAmount(4, ItemRegistry.megaMachines[0]),
                GTUtility.copyAmount(4, ItemRegistry.megaMachines[0]),
                GTUtility.copyAmount(4, ItemRegistry.megaMachines[0]),
                GTUtility.copyAmount(4, ItemRegistry.megaMachines[0]),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 8L),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.NaquadahAlloy, 32L),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Tritanium, 32L),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Americium, 32L),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BlackPlutonium, 32L),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorZPM, 16L),
                ItemList.Field_Generator_ZPM.get(4L),
                ItemList.Energy_Module.get(1L))
            .fluidInputs(
                Materials.Grade4PurifiedWater.getFluid(64000),
                MaterialsAlloy.INDALLOY_140.getFluidStack(14400),
                MaterialsAlloy.ZERON_100.getFluidStack(18432),
                Materials.SolderingAlloy.getMolten(36864))
            .itemOutputs(GTNLItemList.MegaBlastFurnace.get(1))
            .eut(TierEU.RECIPE_ZPM)
            .duration(30 * SECONDS)
            .addTo(AssemblyLine);

        TTRecipeAdder.addResearchableAssemblylineRecipe(
            GregtechItemList.ChemicalPlant_Controller.get(1),
            51200000,
            25600,
            (int) TierEU.RECIPE_UEV,
            1,
            new ItemStack[] { GregtechItemList.ChemicalPlant_Controller.get(8),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Osmiridium, 16),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.CosmicNeutronium, 8),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Neutronium, 32),
                ItemList.Electric_Motor_UV.get(16), ItemList.Electric_Pump_UV.get(16),
                ItemList.Field_Generator_ZPM.get(8), GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Osmium, 32),
                CI.getEmptyCatalyst(16), GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 24L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 20L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 16L),
                GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.ElectrumFlux, 32L) },
            new FluidStack[] { MaterialsKevlar.Kevlar.getMolten(23040), Materials.CosmicNeutronium.getMolten(4608),
                Materials.Grade6PurifiedWater.getFluid(32000), MaterialsAlloy.INDALLOY_140.getFluidStack(256000) },
            GTNLItemList.HandOfJohnDavisonRockefeller.get(1),
            60 * SECONDS,
            (int) TierEU.RECIPE_UHV);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, ItemList.Hatch_CraftingInput_Bus_ME_ItemOnly.get(1))
            .metadata(RESEARCH_TIME, 6 * HOURS)
            .itemInputs(
                ItemList.Hatch_CraftingInput_Bus_ME_ItemOnly.get(1),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 60),
                ItemList.Hatch_Input_Bus_ME_Advanced.get(2),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 16, 54),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 5, 440),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 480))
            .fluidInputs(Materials.SolderingAlloy.getMolten(4608), MaterialsAlloy.INDALLOY_140.getFluidStack(2304))
            .itemOutputs(GTNLItemList.SuperCraftingInputBusME.get(1))
            .eut(TierEU.RECIPE_LuV)
            .duration(30 * SECONDS)
            .addTo(AssemblyLine);

        TTRecipeAdder.addResearchableAssemblylineRecipe(
            ItemList.Hatch_CraftingInput_Bus_ME.get(1),
            1920000,
            4000,
            (int) TierEU.RECIPE_UEV,
            1,
            new ItemStack[] { ItemList.Hatch_CraftingInput_Bus_ME.get(1), ItemRefer.Fluid_Storage_Core_T7.get(4),
                GTModHandler.getModItem(AvaritiaAddons.ID, "InfinityChest", 4),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockCreativeEnergyCell", 1),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 16, 60),
                GTModHandler.getModItem(AE2FluidCraft.ID, "fluid_part", 16, 7),
                ItemList.Hatch_Input_Bus_ME_Advanced.get(4), ItemList.Hatch_Input_ME_Advanced.get(4),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 64, 54) },
            new FluidStack[] { MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(73728),
                Materials.Infinity.getMolten(18432), Materials.RadoxPolymer.getMolten(18432),
                MaterialsAlloy.INDALLOY_140.getFluidStack(512000) },
            GTNLItemList.SuperCraftingInputHatchME.get(1),
            60 * SECONDS,
            (int) TierEU.RECIPE_UHV);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, GTNLItemList.DualInputHatchLuV.get(1))
            .metadata(RESEARCH_TIME, 32 * MINUTES)
            .itemInputs(
                GTNLItemList.DualInputHatchLuV.get(1),
                ItemList.Emitter_LuV.get(1),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 4L),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 3),
                GTModHandler.getModItem(AE2FluidCraft.ID, "fluid_interface", 3),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 30),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 27),
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 32L),
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 32L),
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 32L))
            .fluidInputs(Materials.SolderingAlloy.getMolten(576), Materials.Lubricant.getFluid(500))
            .itemOutputs(ItemList.Hatch_CraftingInput_Bus_ME.get(1))
            .eut(TierEU.RECIPE_LuV)
            .duration(30 * SECONDS)
            .addTo(AssemblyLine);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, ItemList.Hatch_CraftingInput_Bus_ME.get(1))
            .metadata(RESEARCH_TIME, 4 * HOURS)
            .itemInputs(
                ItemList.Hull_LuV.get(1),
                ItemList.Sensor_LuV.get(2),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 1L),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumLinkChamber", 1),
                GTModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumRing", 2),
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 32L),
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 32L))
            .fluidInputs(Materials.SolderingAlloy.getMolten(576), Materials.Lubricant.getFluid(500))
            .itemOutputs(ItemList.Hatch_CraftingInput_Bus_Slave.get(1))
            .eut(TierEU.RECIPE_ZPM)
            .duration(30 * SECONDS)
            .addTo(AssemblyLine);
    }
}
