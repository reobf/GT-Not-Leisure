package com.science.gtnl.loader;

import net.minecraft.item.ItemStack;

import com.science.gtnl.Utils.item.TextLocalization;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.hatch.DebugEnergyHatch;
import com.science.gtnl.common.hatch.HatchCustomFluid;
import com.science.gtnl.common.hatch.SuperCraftingInputHatchME;
import com.science.gtnl.common.machine.multiblock.AdvancedPhotovoltaicPowerStation;
import com.science.gtnl.common.machine.multiblock.BloodSoulSacrificialArray;
import com.science.gtnl.common.machine.multiblock.BrickedBlastFurnace;
import com.science.gtnl.common.machine.multiblock.CheatOreProcessingFactory;
import com.science.gtnl.common.machine.multiblock.ComponentAssembler;
import com.science.gtnl.common.machine.multiblock.Desulfurizer;
import com.science.gtnl.common.machine.multiblock.EdenGarden;
import com.science.gtnl.common.machine.multiblock.EnergeticPhotovoltaicPowerStation;
import com.science.gtnl.common.machine.multiblock.GenerationEarthEngine;
import com.science.gtnl.common.machine.multiblock.HandOfJohnDavisonRockefeller;
import com.science.gtnl.common.machine.multiblock.IndustrialArcaneAssembler;
import com.science.gtnl.common.machine.multiblock.LapotronChip;
import com.science.gtnl.common.machine.multiblock.LargeBrewer;
import com.science.gtnl.common.machine.multiblock.LargeCircuitAssembler;
import com.science.gtnl.common.machine.multiblock.LargeIncubator;
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
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeSiftingFunnel;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeSolidifier;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeSteamOreWasher;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.LargeWiremill;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.MegaBlastFurnace;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.VacuumDryingFurnace;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.VacuumFreezer;
import com.science.gtnl.common.machine.multiblock.TeleportationArrayToAlfheim;
import com.science.gtnl.common.machine.multiblock.VibrantPhotovoltaicPowerStation;
import com.science.gtnl.common.machine.multiblock.WhiteNightGenerator;

import gtPlusPlus.api.objects.Logger;
import gtPlusPlus.core.util.minecraft.FluidUtils;
import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.MTEHatchSolidifier;
import tectech.thing.metaTileEntity.hatch.MTEHatchCapacitor;
import tectech.thing.metaTileEntity.hatch.MTEHatchRack;

public class MachineLoader {

    public static ItemStack LargeSteamCircuitAssembler;
    public static ItemStack GenerationEarthEngine;
    public static ItemStack BloodSoulSacrificialArray;
    public static ItemStack TeleportationArrayToAlfheim;
    public static ItemStack LapotronChip;
    public static ItemStack RealArtificialStar;
    public static ItemStack EdenGarden;
    public static ItemStack NeutroniumWireCutting;
    public static ItemStack LargeSteamCrusher;
    public static ItemStack ComponentAssembler;
    public static ItemStack LargeSteamFurnace;
    public static ItemStack LargeSteamAlloySmelter;
    public static ItemStack LargeSteamThermalCentrifuge;
    public static ItemStack LargeSteamChemicalBath;
    public static ItemStack SteamCracking;
    public static ItemStack PrimitiveDistillationTower;
    public static ItemStack CheatOreProcessingFactory;
    public static ItemStack MeteorMiner;
    public static ItemStack Desulfurizer;
    public static ItemStack LargeCircuitAssembler;
    public static ItemStack PetrochemicalPlant;
    public static ItemStack SmeltingMixingFurnace;
    public static ItemStack WhiteNightGenerator;
    public static ItemStack ProcessingArray;
    public static ItemStack MegaBlastFurnace;
    public static ItemStack BrickedBlastFurnace;
    public static ItemStack RareEarthCentrifugal;
    public static ItemStack NineIndustrialMultiMachine;
    public static ItemStack ColdIceFreezer;
    public static ItemStack BlazeBlastFurnace;
    public static ItemStack ChemicalPlant;
    public static ItemStack VacuumFreezer;
    public static ItemStack IndustrialArcaneAssembler;
    public static ItemStack EnergeticPhotovoltaicPowerStation;
    public static ItemStack AdvancedPhotovoltaicPowerStation;
    public static ItemStack VibrantPhotovoltaicPowerStation;
    public static ItemStack LargeMacerationTower;
    public static ItemStack HandOfJohnDavisonRockefeller;
    public static ItemStack LargeSiftingFunnel;
    public static ItemStack LargeCutter;
    public static ItemStack LargeBrewer;
    public static ItemStack LargeIndustrialLathe;
    public static ItemStack LargeMaterialPress;
    public static ItemStack LargeWiremill;
    public static ItemStack LargeBender;
    public static ItemStack ElectricImplosionCompressor;
    public static ItemStack LargeExtruder;
    public static ItemStack LargeArcSmelter;
    public static ItemStack LargeForming;
    public static ItemStack MatterFabricator;
    public static ItemStack LargeElectrolyzer;
    public static ItemStack LargeElectromagnet;
    public static ItemStack LargeAssembler;
    public static ItemStack LargeMixer;
    public static ItemStack LargeCentrifuge;
    public static ItemStack LibraryOfRuina;
    public static ItemStack LargeChemicalBath;
    public static ItemStack LargeAutoclave;
    public static ItemStack LargeSolidifier;
    public static ItemStack LargeExtractor;
    public static ItemStack ReactionFurnace;
    public static ItemStack EnergyInfuser;
    public static ItemStack LargeCanning;
    public static ItemStack Digester;
    public static ItemStack AlloyBlastSmelter;
    public static ItemStack LargeSteamExtractor;
    public static ItemStack LargeSteamOreWasher;
    public static ItemStack LargeHammer;
    public static ItemStack IsaMill;
    public static ItemStack FlotationCellRegulator;
    public static ItemStack VacuumDryingFurnace;
    public static ItemStack LargeDistillery;
    public static ItemStack Incubator;
    public static ItemStack LargeIncubator;
    public static ItemStack LargeEngravingLaser;
    public static ItemStack FishingGround;

    public static void loadMachines() {

        /*
         * hatch_AutoSterileMaintenanceHatch.set(
         * new MTEHatchSterileMaintenance(
         * 21001,
         * "gtnl.sterile.maintenance",
         * "Auto-Taping Sterile Maintenance Hatch",
         * 14).getStackForm(1L));
         * MTEInfinityHatchOutputBusME.set(
         * new MTEInfinityHatchOutputBusME(21002, "gtnl.ae2.InfinityOutputBusME", "Infinity Output Bus (ME)", 4)
         * .getStackForm(1L));
         * MTEInfinityHatchOutputME.set(
         * new MTEInfinityHatchOutputME(21003, "gtnl.ae2.InfinityOutputME", "Infinity Output Hatch (ME)", 3)
         * .getStackForm(1L));
         */
        EdenGarden = new EdenGarden(21004, "EdenGarden", TextLocalization.NameEdenGarden).getStackForm(1);
        GTNLItemList.EdenGarden.set(EdenGarden);

        LargeSteamCircuitAssembler = new LargeSteamCircuitAssembler(
            21005,
            "LargeSteamCircuitAssembler",
            TextLocalization.NameLargeSteamCircuitAssembler).getStackForm(1);
        GTNLItemList.LargeSteamCircuitAssembler.set(LargeSteamCircuitAssembler);

        GenerationEarthEngine = new GenerationEarthEngine(
            21006,
            "GenerationEarthEngine",
            TextLocalization.NameGenerationEarthEngine).getStackForm(1);
        GTNLItemList.GenerationEarthEngine.set(GenerationEarthEngine);

        BloodSoulSacrificialArray = new BloodSoulSacrificialArray(
            21007,
            "BloodSoulSacrificialArray",
            TextLocalization.NameBloodSoulSacrificialArray).getStackForm(1);
        GTNLItemList.BloodSoulSacrificialArray.set(BloodSoulSacrificialArray);

        RealArtificialStar = new RealArtificialStar(
            21008,
            "RealArtificialStar",
            TextLocalization.NameRealArtificialStar).getStackForm(1);
        GTNLItemList.RealArtificialStar.set(RealArtificialStar);

        TeleportationArrayToAlfheim = new TeleportationArrayToAlfheim(
            21009,
            "TeleportationArrayToAlfheim",
            TextLocalization.NameTeleportationArrayToAlfheim).getStackForm(1);
        GTNLItemList.TeleportationArrayToAlfheim.set(TeleportationArrayToAlfheim);

        LapotronChip = new LapotronChip(21010, "LapotronChip", TextLocalization.NameLapotronChip).getStackForm(1);
        GTNLItemList.LapotronChip.set(LapotronChip);

        NeutroniumWireCutting = new NeutroniumWireCutting(
            21011,
            "NeutroniumWireCutting",
            TextLocalization.NameNeutroniumWireCutting).getStackForm(1);
        GTNLItemList.NeutroniumWireCutting.set(NeutroniumWireCutting);

        LargeSteamCrusher = new LargeSteamCrusher(21012, "LargeSteamCrusher", TextLocalization.NameLargeSteamCrusher)
            .getStackForm(1);
        GTNLItemList.LargeSteamCrusher.set(LargeSteamCrusher);

        ComponentAssembler = new ComponentAssembler(
            21013,
            "ComponentAssembler",
            TextLocalization.NameComponentAssembler).getStackForm(1);
        GTNLItemList.ComponentAssembler.set(ComponentAssembler);

        LargeSteamFurnace = new LargeSteamFurnace(21014, "LargeSteamFurnace", TextLocalization.NameLargeSteamFurnace)
            .getStackForm(1);
        GTNLItemList.LargeSteamFurnace.set(LargeSteamFurnace);

        LargeSteamAlloySmelter = new LargeSteamAlloySmelter(
            21015,
            "LargeSteamAlloySmelter",
            TextLocalization.NameLargeSteamAlloySmelter).getStackForm(1);
        GTNLItemList.LargeSteamAlloySmelter.set(LargeSteamAlloySmelter);

        LargeSteamThermalCentrifuge = new LargeSteamThermalCentrifuge(
            21016,
            "LargeSteamThermalCentrifuge",
            TextLocalization.NameLargeSteamThermalCentrifuge).getStackForm(1);
        GTNLItemList.LargeSteamThermalCentrifuge.set(LargeSteamThermalCentrifuge);

        SteamCracking = new SteamCracking(21017, "SteamCracking", TextLocalization.NameSteamCracking).getStackForm(1);
        GTNLItemList.SteamCracking.set(SteamCracking);

        LargeSteamChemicalBath = new LargeSteamChemicalBath(
            21018,
            "LargeSteamChemicalBath",
            TextLocalization.NameLargeSteamChemicalBath).getStackForm(1);
        GTNLItemList.LargeSteamChemicalBath.set(LargeSteamChemicalBath);

        PrimitiveDistillationTower = new PrimitiveDistillationTower(
            21019,
            "PrimitiveDistillationTower",
            TextLocalization.NamePrimitiveDistillationTower).getStackForm(1);
        GTNLItemList.PrimitiveDistillationTower.set(PrimitiveDistillationTower);

        MeteorMiner = new MeteorMiner(21020, "MeteorMiner", TextLocalization.NameMeteorMiner).getStackForm(1);
        GTNLItemList.MeteorMiner.set(MeteorMiner);

        Desulfurizer = new Desulfurizer(21021, "Desulfurizer", TextLocalization.NameDesulfurizer).getStackForm(1);
        GTNLItemList.Desulfurizer.set(Desulfurizer);

        LargeCircuitAssembler = new LargeCircuitAssembler(
            21022,
            "LargeCircuitAssembler",
            TextLocalization.NameLargeCircuitAssembler).getStackForm(1);
        GTNLItemList.LargeCircuitAssembler.set(LargeCircuitAssembler);

        PetrochemicalPlant = new PetrochemicalPlant(
            21023,
            "PetrochemicalPlant",
            TextLocalization.NamePetrochemicalPlant).getStackForm(1);
        GTNLItemList.PetrochemicalPlant.set(PetrochemicalPlant);

        SmeltingMixingFurnace = new SmeltingMixingFurnace(
            21024,
            "SmeltingMixingFurnace",
            TextLocalization.NameSmeltingMixingFurnace).getStackForm(1);
        GTNLItemList.SmeltingMixingFurnace.set(SmeltingMixingFurnace);

        WhiteNightGenerator = new WhiteNightGenerator(
            21025,
            "WhiteNightGenerator",
            TextLocalization.NameWhiteNightGenerator).getStackForm(1);
        GTNLItemList.WhiteNightGenerator.set(WhiteNightGenerator);

        ProcessingArray = new ProcessingArray(21026, "ProcessingArray", TextLocalization.NameProcessingArray)
            .getStackForm(1);
        GTNLItemList.ProcessingArray.set(ProcessingArray);

        MegaBlastFurnace = new MegaBlastFurnace(21027, "MegaBlastFurnace", TextLocalization.NameMegaBlastFurnace)
            .getStackForm(1);
        GTNLItemList.MegaBlastFurnace.set(MegaBlastFurnace);

        BrickedBlastFurnace = new BrickedBlastFurnace(
            21028,
            "BrickedBlastFurnace",
            TextLocalization.NameBrickedBlastFurnace).getStackForm(1);
        GTNLItemList.BrickedBlastFurnace.set(BrickedBlastFurnace);

        RareEarthCentrifugal = new RareEarthCentrifugal(
            21029,
            "RareEarthCentrifugal",
            TextLocalization.NameRareEarthCentrifugal).getStackForm(1);
        GTNLItemList.RareEarthCentrifugal.set(RareEarthCentrifugal);

        ColdIceFreezer = new ColdIceFreezer(21030, "ColdIceFreezer", TextLocalization.NameColdIceFreezer)
            .getStackForm(1);
        GTNLItemList.ColdIceFreezer.set(ColdIceFreezer);

        BlazeBlastFurnace = new BlazeBlastFurnace(21031, "BlazeBlastFurnace", TextLocalization.NameBlazeBlastFurnace)
            .getStackForm(1);
        GTNLItemList.BlazeBlastFurnace.set(BlazeBlastFurnace);

        ChemicalPlant = new ChemicalPlant(21032, "ChemicalPlant", TextLocalization.NameChemicalPlant).getStackForm(1);
        GTNLItemList.ChemicalPlant.set(ChemicalPlant);

        VacuumFreezer = new VacuumFreezer(21033, "VacuumFreezer", TextLocalization.NameVacuumFreezer).getStackForm(1);
        GTNLItemList.VacuumFreezer.set(VacuumFreezer);

        IndustrialArcaneAssembler = new IndustrialArcaneAssembler(
            21034,
            "IndustrialArcaneAssembler",
            TextLocalization.NameIndustrialArcaneAssembler).getStackForm(1);
        GTNLItemList.IndustrialArcaneAssembler.set(IndustrialArcaneAssembler);

        EnergeticPhotovoltaicPowerStation = new EnergeticPhotovoltaicPowerStation(
            21035,
            "EnergeticPhotovoltaicPowerStation",
            TextLocalization.NameEnergeticPhotovoltaicPowerStation).getStackForm(1);
        GTNLItemList.EnergeticPhotovoltaicPowerStation.set(EnergeticPhotovoltaicPowerStation);

        AdvancedPhotovoltaicPowerStation = new AdvancedPhotovoltaicPowerStation(
            21036,
            "AdvancedPhotovoltaicPowerStation",
            TextLocalization.NameAdvancedPhotovoltaicPowerStation).getStackForm(1);
        GTNLItemList.AdvancedPhotovoltaicPowerStation.set(AdvancedPhotovoltaicPowerStation);

        VibrantPhotovoltaicPowerStation = new VibrantPhotovoltaicPowerStation(
            21037,
            "VibrantPhotovoltaicPowerStation",
            TextLocalization.NameVibrantPhotovoltaicPowerStation).getStackForm(1);
        GTNLItemList.VibrantPhotovoltaicPowerStation.set(VibrantPhotovoltaicPowerStation);

        LargeMacerationTower = new LargeMacerationTower(
            21038,
            "LargeMacerationTower",
            TextLocalization.NameLargeMacerationTower).getStackForm(1);
        GTNLItemList.LargeMacerationTower.set(LargeMacerationTower);

        HandOfJohnDavisonRockefeller = new HandOfJohnDavisonRockefeller(
            21039,
            "HandOfJohnDavisonRockefeller",
            TextLocalization.NameHandOfJohnDavisonRockefeller).getStackForm(1);
        GTNLItemList.HandOfJohnDavisonRockefeller.set(HandOfJohnDavisonRockefeller);

        LargeSiftingFunnel = new LargeSiftingFunnel(
            21040,
            "LargeSiftingFunnel",
            TextLocalization.NameLargeSiftingFunnel).getStackForm(1);
        GTNLItemList.LargeSiftingFunnel.set(LargeSiftingFunnel);

        LargeCutter = new LargeCutter(21041, "LargeCutter", TextLocalization.NameLargeCutter).getStackForm(1);
        GTNLItemList.LargeCutter.set(LargeCutter);

        LargeBrewer = new LargeBrewer(21042, "LargeBrewer", TextLocalization.NameLargeBrewer).getStackForm(1);
        GTNLItemList.LargeBrewer.set(LargeBrewer);

        LargeIndustrialLathe = new LargeIndustrialLathe(
            21043,
            "LargeIndustrialLathe",
            TextLocalization.NameLargeIndustrialLathe).getStackForm(1);
        GTNLItemList.LargeIndustrialLathe.set(LargeIndustrialLathe);

        LargeMaterialPress = new LargeMaterialPress(
            21044,
            "LargeMaterialPress",
            TextLocalization.NameLargeMaterialPress).getStackForm(1);
        GTNLItemList.LargeMaterialPress.set(LargeMaterialPress);

        LargeWiremill = new LargeWiremill(21045, "LargeWiremill", TextLocalization.NameLargeWiremill).getStackForm(1);
        GTNLItemList.LargeWiremill.set(LargeWiremill);

        LargeBender = new LargeBender(21046, "LargeBender", TextLocalization.NameLargeBender).getStackForm(1);
        GTNLItemList.LargeBender.set(LargeBender);

        ElectricImplosionCompressor = new ElectricImplosionCompressor(
            21047,
            "ElectricImplosionCompressor",
            TextLocalization.NameElectricImplosionCompressor).getStackForm(1);
        GTNLItemList.ElectricImplosionCompressor.set(ElectricImplosionCompressor);

        LargeExtruder = new LargeExtruder(21048, "LargeExtruder", TextLocalization.NameLargeExtruder).getStackForm(1);
        GTNLItemList.LargeExtruder.set(LargeExtruder);

        LargeArcSmelter = new LargeArcSmelter(21049, "LargeArcSmelter", TextLocalization.NameLargeArcSmelter)
            .getStackForm(1);
        GTNLItemList.LargeArcSmelter.set(LargeArcSmelter);

        LargeForming = new LargeForming(21050, "LargeForming", TextLocalization.NameLargeForming).getStackForm(1);
        GTNLItemList.LargeForming.set(LargeForming);

        MatterFabricator = new MatterFabricator(21051, "MatterFabricator", TextLocalization.NameMatterFabricator)
            .getStackForm(1);
        GTNLItemList.MatterFabricator.set(MatterFabricator);

        LargeElectrolyzer = new LargeElectrolyzer(21052, "LargeElectrolyzer", TextLocalization.NameLargeElectrolyzer)
            .getStackForm(1);
        GTNLItemList.LargeElectrolyzer.set(LargeElectrolyzer);

        LargeElectromagnet = new LargeElectromagnet(
            21053,
            "LargeElectromagnet",
            TextLocalization.NameLargeElectromagnet).getStackForm(1);
        GTNLItemList.LargeElectromagnet.set(LargeElectromagnet);

        LargeAssembler = new LargeAssembler(21054, "LargeAssembler", TextLocalization.NameLargeAssembler)
            .getStackForm(1);
        GTNLItemList.LargeAssembler.set(LargeAssembler);

        LargeMixer = new LargeMixer(21055, "LargeMixer", TextLocalization.NameLargeMixer).getStackForm(1);
        GTNLItemList.LargeMixer.set(LargeMixer);

        LargeCentrifuge = new LargeCentrifuge(21056, "LargeCentrifuge", TextLocalization.NameLargeCentrifuge)
            .getStackForm(1);
        GTNLItemList.LargeCentrifuge.set(LargeCentrifuge);

        LibraryOfRuina = new LibraryOfRuina(21057, "LibraryOfRuina", TextLocalization.NameLibraryOfRuina)
            .getStackForm(1);
        GTNLItemList.LibraryOfRuina.set(LibraryOfRuina);

        LargeChemicalBath = new LargeChemicalBath(21058, "LargeChemicalBath", TextLocalization.NameLargeChemicalBath)
            .getStackForm(1);
        GTNLItemList.LargeChemicalBath.set(LargeChemicalBath);

        LargeAutoclave = new LargeAutoclave(21059, "LargeAutoclave", TextLocalization.NameLargeAutoclave)
            .getStackForm(1);
        GTNLItemList.LargeAutoclave.set(LargeAutoclave);

        LargeSolidifier = new LargeSolidifier(21060, "LargeSolidifier", TextLocalization.NameLargeSolidifier)
            .getStackForm(1);
        GTNLItemList.LargeSolidifier.set(LargeSolidifier);

        LargeExtractor = new LargeExtractor(21061, "LargeExtractor", TextLocalization.NameLargeExtractor)
            .getStackForm(1);
        GTNLItemList.LargeExtractor.set(LargeExtractor);

        ReactionFurnace = new ReactionFurnace(21062, "ReactionFurnace", TextLocalization.NameReactionFurnace)
            .getStackForm(1);
        GTNLItemList.ReactionFurnace.set(ReactionFurnace);

        EnergyInfuser = new EnergyInfuser(21063, "EnergyInfuser", TextLocalization.NameEnergyInfuser).getStackForm(1);
        GTNLItemList.EnergyInfuser.set(EnergyInfuser);

        LargeCanning = new LargeCanning(21064, "LargeCanning", TextLocalization.NameLargeCanning).getStackForm(1);
        GTNLItemList.LargeCanning.set(LargeCanning);

        Digester = new Digester(21065, "Digester", TextLocalization.NameDigester).getStackForm(1);
        GTNLItemList.Digester.set(Digester);

        AlloyBlastSmelter = new AlloyBlastSmelter(21066, "AlloyBlastSmelter", TextLocalization.NameAlloyBlastSmelter)
            .getStackForm(1);
        GTNLItemList.AlloyBlastSmelter.set(AlloyBlastSmelter);

        LargeSteamExtractor = new LargeSteamExtractor(
            21067,
            "LargeSteamExtractor",
            TextLocalization.NameLargeSteamExtractor).getStackForm(1);
        GTNLItemList.LargeSteamExtractor.set(LargeSteamExtractor);

        LargeSteamOreWasher = new LargeSteamOreWasher(
            21068,
            "LargeSteamOreWasher",
            TextLocalization.NameLargeSteamOreWasher).getStackForm(1);
        GTNLItemList.LargeSteamOreWasher.set(LargeSteamOreWasher);

        LargeHammer = new LargeHammer(21069, "LargeHammer", TextLocalization.NameLargeHammer).getStackForm(1);
        GTNLItemList.LargeHammer.set(LargeHammer);

        IsaMill = new IsaMill(21070, "IsaMill", TextLocalization.NameIsaMill).getStackForm(1);
        GTNLItemList.IsaMill.set(IsaMill);

        FlotationCellRegulator = new FlotationCellRegulator(
            21071,
            "FlotationCellRegulator",
            TextLocalization.NameFlotationCellRegulator).getStackForm(1);
        GTNLItemList.FlotationCellRegulator.set(FlotationCellRegulator);

        VacuumDryingFurnace = new VacuumDryingFurnace(
            21072,
            "VacuumDryingFurnace",
            TextLocalization.NameVacuumDryingFurnace).getStackForm(1);
        GTNLItemList.VacuumDryingFurnace.set(VacuumDryingFurnace);

        LargeDistillery = new LargeDistillery(21073, "LargeDistillery", TextLocalization.NameLargeDistillery)
            .getStackForm(1);
        GTNLItemList.LargeDistillery.set(LargeDistillery);

        Incubator = new Incubator(21074, "Incubator", TextLocalization.NameIncubator).getStackForm(1);
        GTNLItemList.Incubator.set(Incubator);

        LargeIncubator = new LargeIncubator(21075, "LargeIncubator", TextLocalization.NameLargeIncubator)
            .getStackForm(1);
        GTNLItemList.LargeIncubator.set(LargeIncubator);

        LargeEngravingLaser = new LargeEngravingLaser(
            21076,
            "LargeEngravingLaser",
            TextLocalization.NameLargeEngravingLaser).getStackForm(1);
        GTNLItemList.LargeEngravingLaser.set(LargeEngravingLaser);

        FishingGround = new FishingGround(21077, "FishingGround", TextLocalization.NameFishingGround).getStackForm(1);
        GTNLItemList.FishingGround.set(FishingGround);

        CheatOreProcessingFactory = new CheatOreProcessingFactory(
            21919,
            "CheatOreProcessingFactory",
            TextLocalization.NameCheatOreProcessingFactory).getStackForm(1);
        GTNLItemList.CheatOreProcessingFactory.set(CheatOreProcessingFactory);

        NineIndustrialMultiMachine = new NineIndustrialMultiMachine(
            21920,
            "NineIndustrialMultiMachine",
            TextLocalization.NameNineIndustrialMultiMachine).getStackForm(1);
        GTNLItemList.NineIndustrialMultiMachine.set(NineIndustrialMultiMachine);

        MTEHatchRack.run();
        MTEHatchCapacitor.run();
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
                6).getStackForm(1L));

        GTNLItemList.FluidIceInputHatch.set(
            new HatchCustomFluid(
                FluidUtils.getFluidStack("ice", 1)
                    .getFluid(),
                256000,
                21502,
                "Fluid Ice Input Hatch",
                TextLocalization.FluidIceInputHatch,
                5).getStackForm(1L));

        GTNLItemList.FluidBlazeInputHatch.set(
            new HatchCustomFluid(
                FluidUtils.getFluidStack("molten.blaze", 1)
                    .getFluid(),
                256000,
                21503,
                "Fluid Blaze Input Hatch",
                TextLocalization.FluidBlazeInputHatch,
                5).getStackForm(1L));

        GTNLItemList.SuperCraftingInputHatchME.set(
            new SuperCraftingInputHatchME(
                21504,
                "Super Crafting Input Buffer (ME)",
                TextLocalization.SuperCraftingInputHatchME,
                true).getStackForm(1L));

        GTNLItemList.SuperCraftingInputBusME.set(
            new SuperCraftingInputHatchME(
                21505,
                "Super Crafting Input Bus (ME)",
                TextLocalization.SuperCraftingInputBusME,
                false).getStackForm(1L));

        GTNLItemList.SolidifierHatchMAX.set(
            new MTEHatchSolidifier(21506, "Solidifier Hatch MAX", TextLocalization.SolidifierHatchMAX, 14)
                .getStackForm(1L));

        GTNLItemList.DebugEnergyHatch.set(
            new DebugEnergyHatch(21507, "Debug Energy Hatch", TextLocalization.DebugEnergyHatch, 14).getStackForm(1L));
    }

    public static void run() {
        Logger.INFO("GTNL Content | Registering Custom MTE Hatches.");
        registerMTEHatch();
    }
}
