package com.science.gtnl.loader;

import com.science.gtnl.Utils.item.TextLocalization;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.hatch.DebugEnergyHatch;
import com.science.gtnl.common.hatch.DualInputHatch;
import com.science.gtnl.common.hatch.DualOutputHatch;
import com.science.gtnl.common.hatch.HatchCustomFluid;
import com.science.gtnl.common.hatch.HumongousNinefoldInputHatch;
import com.science.gtnl.common.hatch.HumongousSolidifierHatch;
import com.science.gtnl.common.hatch.NinefoldInputHatch;
import com.science.gtnl.common.hatch.SuperCraftingInputHatchME;
import com.science.gtnl.common.machine.multiblock.AdvancedPhotovoltaicPowerStation;
import com.science.gtnl.common.machine.multiblock.BloodSoulSacrificialArray;
import com.science.gtnl.common.machine.multiblock.BrickedBlastFurnace;
import com.science.gtnl.common.machine.multiblock.CheatOreProcessingFactory;
import com.science.gtnl.common.machine.multiblock.ComponentAssembler;
import com.science.gtnl.common.machine.multiblock.Desulfurizer;
import com.science.gtnl.common.machine.multiblock.EdenGarden;
import com.science.gtnl.common.machine.multiblock.ElementCopying;
import com.science.gtnl.common.machine.multiblock.EnergeticPhotovoltaicPowerStation;
import com.science.gtnl.common.machine.multiblock.GenerationEarthEngine;
import com.science.gtnl.common.machine.multiblock.HandOfJohnDavisonRockefeller;
import com.science.gtnl.common.machine.multiblock.IndustrialArcaneAssembler;
import com.science.gtnl.common.machine.multiblock.LapotronChip;
import com.science.gtnl.common.machine.multiblock.LargeBrewer;
import com.science.gtnl.common.machine.multiblock.LargeCircuitAssembler;
import com.science.gtnl.common.machine.multiblock.LargeIncubator;
import com.science.gtnl.common.machine.multiblock.LargeNaquadahReactor;
import com.science.gtnl.common.machine.multiblock.LargeSteamAlloySmelter;
import com.science.gtnl.common.machine.multiblock.LargeSteamChemicalBath;
import com.science.gtnl.common.machine.multiblock.LargeSteamCircuitAssembler;
import com.science.gtnl.common.machine.multiblock.LargeSteamCrusher;
import com.science.gtnl.common.machine.multiblock.LargeSteamExtractor;
import com.science.gtnl.common.machine.multiblock.LargeSteamFurnace;
import com.science.gtnl.common.machine.multiblock.LargeSteamThermalCentrifuge;
import com.science.gtnl.common.machine.multiblock.LibraryOfRuina;
import com.science.gtnl.common.machine.multiblock.MatterFabricator;
import com.science.gtnl.common.machine.multiblock.MeteorMiner;
import com.science.gtnl.common.machine.multiblock.NeutroniumWireCutting;
import com.science.gtnl.common.machine.multiblock.NineIndustrialMultiMachine;
import com.science.gtnl.common.machine.multiblock.PetrochemicalPlant;
import com.science.gtnl.common.machine.multiblock.PrimitiveDistillationTower;
import com.science.gtnl.common.machine.multiblock.ProcessingArray;
import com.science.gtnl.common.machine.multiblock.RareEarthCentrifugal;
import com.science.gtnl.common.machine.multiblock.ReactionFurnace;
import com.science.gtnl.common.machine.multiblock.RealArtificialStar;
import com.science.gtnl.common.machine.multiblock.SmeltingMixingFurnace;
import com.science.gtnl.common.machine.multiblock.SteamCracking;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.AlloyBlastSmelter;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.BlazeBlastFurnace;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.ChemicalPlant;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.ColdIceFreezer;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.Digester;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.ElectricImplosionCompressor;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.EnergyInfuser;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.FishingGround;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.FlotationCellRegulator;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.Incubator;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.IsaMill;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeAlloySmelter;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeArcSmelter;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeAssembler;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeAutoclave;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeBender;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeCanning;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeCentrifuge;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeChemicalBath;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeCutter;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeDistillery;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeElectrolyzer;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeElectromagnet;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeEngravingLaser;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeExtractor;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeExtruder;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeForming;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeHammer;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeIndustrialLathe;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeMacerationTower;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeMaterialPress;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeMixer;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargePacker;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargePyrolyseOven;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeSiftingFunnel;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeSolidifier;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeSteamOreWasher;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeWiremill;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.MegaBlastFurnace;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.MolecularTransformer;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.VacuumDryingFurnace;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.VacuumFreezer;
import com.science.gtnl.common.machine.multiblock.TeleportationArrayToAlfheim;
import com.science.gtnl.common.machine.multiblock.VibrantPhotovoltaicPowerStation;
import com.science.gtnl.common.machine.multiblock.WhiteNightGenerator;
import com.science.gtnl.common.machine.multiblock.WoodDistillation;

import gtPlusPlus.api.objects.Logger;
import gtPlusPlus.core.util.minecraft.FluidUtils;

public class MachineLoader {

    public static void loadMachines() {

        GTNLItemList.EdenGarden.set(new EdenGarden(21004, "EdenGarden", TextLocalization.NameEdenGarden));

        GTNLItemList.LargeSteamCircuitAssembler.set(
            new LargeSteamCircuitAssembler(
                21005,
                "LargeSteamCircuitAssembler",
                TextLocalization.NameLargeSteamCircuitAssembler));

        GTNLItemList.GenerationEarthEngine
            .set(new GenerationEarthEngine(21006, "GenerationEarthEngine", TextLocalization.NameGenerationEarthEngine));

        GTNLItemList.BloodSoulSacrificialArray.set(
            new BloodSoulSacrificialArray(
                21007,
                "BloodSoulSacrificialArray",
                TextLocalization.NameBloodSoulSacrificialArray));

        GTNLItemList.RealArtificialStar
            .set(new RealArtificialStar(21008, "RealArtificialStar", TextLocalization.NameRealArtificialStar));

        GTNLItemList.TeleportationArrayToAlfheim.set(
            new TeleportationArrayToAlfheim(
                21009,
                "TeleportationArrayToAlfheim",
                TextLocalization.NameTeleportationArrayToAlfheim));

        GTNLItemList.LapotronChip.set(new LapotronChip(21010, "LapotronChip", TextLocalization.NameLapotronChip));

        GTNLItemList.NeutroniumWireCutting
            .set(new NeutroniumWireCutting(21011, "NeutroniumWireCutting", TextLocalization.NameNeutroniumWireCutting));

        GTNLItemList.LargeSteamCrusher
            .set(new LargeSteamCrusher(21012, "LargeSteamCrusher", TextLocalization.NameLargeSteamCrusher));

        GTNLItemList.ComponentAssembler
            .set(new ComponentAssembler(21013, "ComponentAssembler", TextLocalization.NameComponentAssembler));

        GTNLItemList.LargeSteamFurnace
            .set(new LargeSteamFurnace(21014, "LargeSteamFurnace", TextLocalization.NameLargeSteamFurnace));

        GTNLItemList.LargeSteamAlloySmelter.set(
            new LargeSteamAlloySmelter(21015, "LargeSteamAlloySmelter", TextLocalization.NameLargeSteamAlloySmelter));

        GTNLItemList.LargeSteamThermalCentrifuge.set(
            new LargeSteamThermalCentrifuge(
                21016,
                "LargeSteamThermalCentrifuge",
                TextLocalization.NameLargeSteamThermalCentrifuge));

        GTNLItemList.SteamCracking.set(new SteamCracking(21017, "SteamCracking", TextLocalization.NameSteamCracking));

        GTNLItemList.LargeSteamChemicalBath.set(
            new LargeSteamChemicalBath(21018, "LargeSteamChemicalBath", TextLocalization.NameLargeSteamChemicalBath));

        GTNLItemList.PrimitiveDistillationTower.set(
            new PrimitiveDistillationTower(
                21019,
                "PrimitiveDistillationTower",
                TextLocalization.NamePrimitiveDistillationTower));

        GTNLItemList.MeteorMiner.set(new MeteorMiner(21020, "MeteorMiner", TextLocalization.NameMeteorMiner));

        GTNLItemList.Desulfurizer.set(new Desulfurizer(21021, "Desulfurizer", TextLocalization.NameDesulfurizer));

        GTNLItemList.LargeCircuitAssembler
            .set(new LargeCircuitAssembler(21022, "LargeCircuitAssembler", TextLocalization.NameLargeCircuitAssembler));

        GTNLItemList.PetrochemicalPlant
            .set(new PetrochemicalPlant(21023, "PetrochemicalPlant", TextLocalization.NamePetrochemicalPlant));

        GTNLItemList.SmeltingMixingFurnace
            .set(new SmeltingMixingFurnace(21024, "SmeltingMixingFurnace", TextLocalization.NameSmeltingMixingFurnace));

        GTNLItemList.WhiteNightGenerator
            .set(new WhiteNightGenerator(21025, "WhiteNightGenerator", TextLocalization.NameWhiteNightGenerator));

        GTNLItemList.ProcessingArray
            .set(new ProcessingArray(21026, "ProcessingArray", TextLocalization.NameProcessingArray));

        GTNLItemList.MegaBlastFurnace
            .set(new MegaBlastFurnace(21027, "MegaBlastFurnace", TextLocalization.NameMegaBlastFurnace));

        GTNLItemList.BrickedBlastFurnace
            .set(new BrickedBlastFurnace(21028, "BrickedBlastFurnace", TextLocalization.NameBrickedBlastFurnace));

        GTNLItemList.RareEarthCentrifugal
            .set(new RareEarthCentrifugal(21029, "RareEarthCentrifugal", TextLocalization.NameRareEarthCentrifugal));

        GTNLItemList.ColdIceFreezer
            .set(new ColdIceFreezer(21030, "ColdIceFreezer", TextLocalization.NameColdIceFreezer));

        GTNLItemList.BlazeBlastFurnace
            .set(new BlazeBlastFurnace(21031, "BlazeBlastFurnace", TextLocalization.NameBlazeBlastFurnace));

        GTNLItemList.ChemicalPlant.set(new ChemicalPlant(21032, "ChemicalPlant", TextLocalization.NameChemicalPlant));

        GTNLItemList.VacuumFreezer.set(new VacuumFreezer(21033, "VacuumFreezer", TextLocalization.NameVacuumFreezer));

        GTNLItemList.IndustrialArcaneAssembler.set(
            new IndustrialArcaneAssembler(
                21034,
                "IndustrialArcaneAssembler",
                TextLocalization.NameIndustrialArcaneAssembler));

        GTNLItemList.EnergeticPhotovoltaicPowerStation.set(
            new EnergeticPhotovoltaicPowerStation(
                21035,
                "EnergeticPhotovoltaicPowerStation",
                TextLocalization.NameEnergeticPhotovoltaicPowerStation));

        GTNLItemList.AdvancedPhotovoltaicPowerStation.set(
            new AdvancedPhotovoltaicPowerStation(
                21036,
                "AdvancedPhotovoltaicPowerStation",
                TextLocalization.NameAdvancedPhotovoltaicPowerStation));

        GTNLItemList.VibrantPhotovoltaicPowerStation.set(
            new VibrantPhotovoltaicPowerStation(
                21037,
                "VibrantPhotovoltaicPowerStation",
                TextLocalization.NameVibrantPhotovoltaicPowerStation));

        GTNLItemList.LargeMacerationTower
            .set(new LargeMacerationTower(21038, "LargeMacerationTower", TextLocalization.NameLargeMacerationTower));

        GTNLItemList.HandOfJohnDavisonRockefeller.set(
            new HandOfJohnDavisonRockefeller(
                21039,
                "HandOfJohnDavisonRockefeller",
                TextLocalization.NameHandOfJohnDavisonRockefeller));

        GTNLItemList.LargeSiftingFunnel
            .set(new LargeSiftingFunnel(21040, "LargeSiftingFunnel", TextLocalization.NameLargeSiftingFunnel));

        GTNLItemList.LargeCutter.set(new LargeCutter(21041, "LargeCutter", TextLocalization.NameLargeCutter));

        GTNLItemList.LargeBrewer.set(new LargeBrewer(21042, "LargeBrewer", TextLocalization.NameLargeBrewer));

        GTNLItemList.LargeIndustrialLathe
            .set(new LargeIndustrialLathe(21043, "LargeIndustrialLathe", TextLocalization.NameLargeIndustrialLathe));

        GTNLItemList.LargeMaterialPress
            .set(new LargeMaterialPress(21044, "LargeMaterialPress", TextLocalization.NameLargeMaterialPress));

        GTNLItemList.LargeWiremill.set(new LargeWiremill(21045, "LargeWiremill", TextLocalization.NameLargeWiremill));

        GTNLItemList.LargeBender.set(new LargeBender(21046, "LargeBender", TextLocalization.NameLargeBender));

        GTNLItemList.ElectricImplosionCompressor.set(
            new ElectricImplosionCompressor(
                21047,
                "ElectricImplosionCompressor",
                TextLocalization.NameElectricImplosionCompressor));

        GTNLItemList.LargeExtruder.set(new LargeExtruder(21048, "LargeExtruder", TextLocalization.NameLargeExtruder));

        GTNLItemList.LargeArcSmelter
            .set(new LargeArcSmelter(21049, "LargeArcSmelter", TextLocalization.NameLargeArcSmelter));

        GTNLItemList.LargeForming.set(new LargeForming(21050, "LargeForming", TextLocalization.NameLargeForming));

        GTNLItemList.MatterFabricator
            .set(new MatterFabricator(21051, "MatterFabricator", TextLocalization.NameMatterFabricator));

        GTNLItemList.LargeElectrolyzer
            .set(new LargeElectrolyzer(21052, "LargeElectrolyzer", TextLocalization.NameLargeElectrolyzer));

        GTNLItemList.LargeElectromagnet
            .set(new LargeElectromagnet(21053, "LargeElectromagnet", TextLocalization.NameLargeElectromagnet));

        GTNLItemList.LargeAssembler
            .set(new LargeAssembler(21054, "LargeAssembler", TextLocalization.NameLargeAssembler));

        GTNLItemList.LargeMixer.set(new LargeMixer(21055, "LargeMixer", TextLocalization.NameLargeMixer));

        GTNLItemList.LargeCentrifuge
            .set(new LargeCentrifuge(21056, "LargeCentrifuge", TextLocalization.NameLargeCentrifuge));

        GTNLItemList.LibraryOfRuina
            .set(new LibraryOfRuina(21057, "LibraryOfRuina", TextLocalization.NameLibraryOfRuina));

        GTNLItemList.LargeChemicalBath
            .set(new LargeChemicalBath(21058, "LargeChemicalBath", TextLocalization.NameLargeChemicalBath));

        GTNLItemList.LargeAutoclave
            .set(new LargeAutoclave(21059, "LargeAutoclave", TextLocalization.NameLargeAutoclave));

        GTNLItemList.LargeSolidifier
            .set(new LargeSolidifier(21060, "LargeSolidifier", TextLocalization.NameLargeSolidifier));

        GTNLItemList.LargeExtractor
            .set(new LargeExtractor(21061, "LargeExtractor", TextLocalization.NameLargeExtractor));

        GTNLItemList.ReactionFurnace
            .set(new ReactionFurnace(21062, "ReactionFurnace", TextLocalization.NameReactionFurnace));

        GTNLItemList.EnergyInfuser.set(new EnergyInfuser(21063, "EnergyInfuser", TextLocalization.NameEnergyInfuser));

        GTNLItemList.LargeCanning.set(new LargeCanning(21064, "LargeCanning", TextLocalization.NameLargeCanning));

        GTNLItemList.Digester.set(new Digester(21065, "Digester", TextLocalization.NameDigester));

        GTNLItemList.AlloyBlastSmelter
            .set(new AlloyBlastSmelter(21066, "AlloyBlastSmelter", TextLocalization.NameAlloyBlastSmelter));

        GTNLItemList.LargeSteamExtractor
            .set(new LargeSteamExtractor(21067, "LargeSteamExtractor", TextLocalization.NameLargeSteamExtractor));

        GTNLItemList.LargeSteamOreWasher
            .set(new LargeSteamOreWasher(21068, "LargeSteamOreWasher", TextLocalization.NameLargeSteamOreWasher));

        GTNLItemList.LargeHammer.set(new LargeHammer(21069, "LargeHammer", TextLocalization.NameLargeHammer));

        GTNLItemList.IsaMill.set(new IsaMill(21070, "IsaMill", TextLocalization.NameIsaMill));

        GTNLItemList.FlotationCellRegulator.set(
            new FlotationCellRegulator(21071, "FlotationCellRegulator", TextLocalization.NameFlotationCellRegulator));

        GTNLItemList.VacuumDryingFurnace
            .set(new VacuumDryingFurnace(21072, "VacuumDryingFurnace", TextLocalization.NameVacuumDryingFurnace));

        GTNLItemList.LargeDistillery
            .set(new LargeDistillery(21073, "LargeDistillery", TextLocalization.NameLargeDistillery));

        GTNLItemList.Incubator.set(new Incubator(21074, "Incubator", TextLocalization.NameIncubator));

        GTNLItemList.LargeIncubator
            .set(new LargeIncubator(21075, "LargeIncubator", TextLocalization.NameLargeIncubator));

        GTNLItemList.LargeEngravingLaser
            .set(new LargeEngravingLaser(21076, "LargeEngravingLaser", TextLocalization.NameLargeEngravingLaser));

        GTNLItemList.FishingGround.set(new FishingGround(21077, "FishingGround", TextLocalization.NameFishingGround));

        GTNLItemList.ElementCopying
            .set(new ElementCopying(21078, "ElementCopying", TextLocalization.NameElementCopying));

        GTNLItemList.WoodDistillation
            .set(new WoodDistillation(21079, "WoodDistillation", TextLocalization.NameWoodDistillation));

        GTNLItemList.LargePacker.set(new LargePacker(21080, "LargePacker", TextLocalization.NameLargePacker));

        GTNLItemList.LargeAlloySmelter
            .set(new LargeAlloySmelter(21081, "LargeAlloySmelter", TextLocalization.NameLargeAlloySmelter));

        GTNLItemList.MolecularTransformer
            .set(new MolecularTransformer(21082, "MolecularTransformer", TextLocalization.NameMolecularTransformer));

        GTNLItemList.LargePyrolyseOven
            .set(new LargePyrolyseOven(21083, "LargePyrolyseOven", TextLocalization.NameLargePyrolyseOven));

        GTNLItemList.LargeNaquadahReactor
            .set(new LargeNaquadahReactor(21084, "LargeNaquadahReactor", TextLocalization.NameLargeNaquadahReactor));

        GTNLItemList.CheatOreProcessingFactory.set(
            new CheatOreProcessingFactory(
                21919,
                "CheatOreProcessingFactory",
                TextLocalization.NameCheatOreProcessingFactory));

        GTNLItemList.NineIndustrialMultiMachine.set(
            new NineIndustrialMultiMachine(
                21920,
                "NineIndustrialMultiMachine",
                TextLocalization.NameNineIndustrialMultiMachine));

        // 为什么再这重复调用tt那边的用于注册的方法
        // MTEHatchRack.run();
        // MTEHatchCapacitor.run();
    }

    public static void registerMTEHatch() {

        GTNLItemList.FluidManaInputHatch.set(
            new HatchCustomFluid(
                FluidUtils.getFluidStack("fluidmana", 1)
                    .getFluid(),
                512000,
                21501,
                "Fluid Mana Input Hatch",
                TextLocalization.FluidManaInputHatch,
                6));

        GTNLItemList.FluidIceInputHatch.set(
            new HatchCustomFluid(
                FluidUtils.getFluidStack("ice", 1)
                    .getFluid(),
                256000,
                21502,
                "Fluid Ice Input Hatch",
                TextLocalization.FluidIceInputHatch,
                5));

        GTNLItemList.FluidBlazeInputHatch.set(
            new HatchCustomFluid(
                FluidUtils.getFluidStack("molten.blaze", 1)
                    .getFluid(),
                256000,
                21503,
                "Fluid Blaze Input Hatch",
                TextLocalization.FluidBlazeInputHatch,
                5));

        GTNLItemList.SuperCraftingInputHatchME.set(
            new SuperCraftingInputHatchME(
                21504,
                "Super Crafting Input Buffer (ME)",
                TextLocalization.SuperCraftingInputHatchME,
                true));

        GTNLItemList.SuperCraftingInputBusME.set(
            new SuperCraftingInputHatchME(
                21505,
                "Super Crafting Input Bus (ME)",
                TextLocalization.SuperCraftingInputBusME,
                false));

        GTNLItemList.HumongousSolidifierHatch.set(
            new HumongousSolidifierHatch(
                21506,
                "Humongous Solidifier Hatch",
                TextLocalization.HumongousSolidifierHatch,
                14));

        GTNLItemList.DebugEnergyHatch
            .set(new DebugEnergyHatch(21507, "Debug Energy Hatch", TextLocalization.DebugEnergyHatch, 14));

        GTNLItemList.NinefoldInputHatchEV
            .set(new NinefoldInputHatch(21508, 9, "Ninefold Input Hatch EV", TextLocalization.NinefoldInputHatchEV, 4));

        GTNLItemList.NinefoldInputHatchIV
            .set(new NinefoldInputHatch(21509, 9, "Ninefold Input Hatch IV", TextLocalization.NinefoldInputHatchIV, 5));

        GTNLItemList.NinefoldInputHatchLuV.set(
            new NinefoldInputHatch(21510, 9, "Ninefold Input Hatch LuV", TextLocalization.NinefoldInputHatchLuV, 6));

        GTNLItemList.NinefoldInputHatchZPM.set(
            new NinefoldInputHatch(21511, 9, "Ninefold Input Hatch ZPM", TextLocalization.NinefoldInputHatchZPM, 7));

        GTNLItemList.NinefoldInputHatchUV
            .set(new NinefoldInputHatch(21512, 9, "Ninefold Input Hatch UV", TextLocalization.NinefoldInputHatchUV, 8));

        GTNLItemList.NinefoldInputHatchUHV.set(
            new NinefoldInputHatch(21513, 9, "Ninefold Input Hatch UHV", TextLocalization.NinefoldInputHatchUHV, 9));

        GTNLItemList.NinefoldInputHatchUEV.set(
            new NinefoldInputHatch(21514, 9, "Ninefold Input Hatch UEV", TextLocalization.NinefoldInputHatchUEV, 10));

        GTNLItemList.NinefoldInputHatchUIV.set(
            new NinefoldInputHatch(21515, 9, "Ninefold Input Hatch UIV", TextLocalization.NinefoldInputHatchUIV, 11));

        GTNLItemList.NinefoldInputHatchUMV.set(
            new NinefoldInputHatch(21516, 9, "Ninefold Input Hatch UMV", TextLocalization.NinefoldInputHatchUMV, 12));

        GTNLItemList.NinefoldInputHatchUXV.set(
            new NinefoldInputHatch(21517, 9, "Ninefold Input Hatch UXV", TextLocalization.NinefoldInputHatchUXV, 13));

        GTNLItemList.NinefoldInputHatchMAX.set(
            new NinefoldInputHatch(21518, 9, "Ninefold Input Hatch MAX", TextLocalization.NinefoldInputHatchMAX, 14));

        GTNLItemList.HumongousNinefoldInputHatch.set(
            new HumongousNinefoldInputHatch(
                21519,
                9,
                "Humongous Ninefold Input Hatch",
                TextLocalization.HumongousNinefoldInputHatch));

        GTNLItemList.DualInputHatchLV
            .set(new DualInputHatch(21520, "Dual Input Hatch LV", TextLocalization.DualInputHatchLV, 1));

        GTNLItemList.DualInputHatchMV
            .set(new DualInputHatch(21521, "Dual Input Hatch MV", TextLocalization.DualInputHatchMV, 2));

        GTNLItemList.DualInputHatchHV
            .set(new DualInputHatch(21522, "Dual Input Hatch HV", TextLocalization.DualInputHatchHV, 3));

        GTNLItemList.DualInputHatchEV
            .set(new DualInputHatch(21523, "Dual Input Hatch EV", TextLocalization.DualInputHatchEV, 4));

        GTNLItemList.DualInputHatchIV
            .set(new DualInputHatch(21524, "Dual Input Hatch IV", TextLocalization.DualInputHatchIV, 5));

        GTNLItemList.DualInputHatchLuV
            .set(new DualInputHatch(21525, "Dual Input Hatch LuV", TextLocalization.DualInputHatchLuV, 6));

        GTNLItemList.DualInputHatchZPM
            .set(new DualInputHatch(21526, "Dual Input Hatch ZPM", TextLocalization.DualInputHatchZPM, 7));

        GTNLItemList.DualInputHatchUV
            .set(new DualInputHatch(21527, "Dual Input Hatch UV", TextLocalization.DualInputHatchUV, 8));

        GTNLItemList.DualInputHatchUHV
            .set(new DualInputHatch(21528, "Dual Input Hatch UHV", TextLocalization.DualInputHatchUHV, 9));

        GTNLItemList.DualInputHatchUEV
            .set(new DualInputHatch(21529, "Dual Input Hatch UEV", TextLocalization.DualInputHatchUEV, 10));

        GTNLItemList.DualInputHatchUIV
            .set(new DualInputHatch(21530, "Dual Input Hatch UIV", TextLocalization.DualInputHatchUIV, 11));

        GTNLItemList.DualInputHatchUMV
            .set(new DualInputHatch(21531, "Dual Input Hatch UMV", TextLocalization.DualInputHatchUMV, 12));

        GTNLItemList.DualInputHatchUXV
            .set(new DualInputHatch(21532, "Dual Input Hatch UXV", TextLocalization.DualInputHatchUXV, 13));

        GTNLItemList.DualInputHatchMAX
            .set(new DualInputHatch(21533, "Dual Input Hatch MAX", TextLocalization.DualInputHatchMAX, 14));

        GTNLItemList.QuadrupleOutputHatchEV.set(
            new DualOutputHatch(22500, 4, "Quadruple Output Hatch EV", TextLocalization.QuadrupleOutputHatchEV, 4));

        GTNLItemList.NinefoldOutputHatchEV
            .set(new DualOutputHatch(22501, 9, "Ninefold Output Hatch EV", TextLocalization.NinefoldOutputHatchEV, 4));
    }

    public static void run() {
        Logger.INFO("GTNL Content | Registering Custom MTE Hatches.");
        registerMTEHatch();
    }
}
