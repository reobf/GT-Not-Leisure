package com.science.gtnl.loader;

import net.minecraft.item.ItemStack;

import com.science.gtnl.Utils.item.TextLocalization;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.hatch.MTEHatchCustomFluid;
import com.science.gtnl.common.machine.multiblock.BloodSoulSacrificialArray;
import com.science.gtnl.common.machine.multiblock.BrickedBlastFurnace;
import com.science.gtnl.common.machine.multiblock.CheatOreProcessingFactory;
import com.science.gtnl.common.machine.multiblock.ComponentAssembler;
import com.science.gtnl.common.machine.multiblock.Desulfurizer;
import com.science.gtnl.common.machine.multiblock.EdenGarden;
import com.science.gtnl.common.machine.multiblock.GenerationEarthEngine;
import com.science.gtnl.common.machine.multiblock.LapotronChip;
import com.science.gtnl.common.machine.multiblock.LargeCircuitAssembler;
import com.science.gtnl.common.machine.multiblock.LargeSteamAlloySmelter;
import com.science.gtnl.common.machine.multiblock.LargeSteamChemicalBath;
import com.science.gtnl.common.machine.multiblock.LargeSteamCircuitAssembler;
import com.science.gtnl.common.machine.multiblock.LargeSteamCrusher;
import com.science.gtnl.common.machine.multiblock.LargeSteamFurnace;
import com.science.gtnl.common.machine.multiblock.LargeSteamThermalCentrifuge;
import com.science.gtnl.common.machine.multiblock.MeteorMiner;
import com.science.gtnl.common.machine.multiblock.NeutroniumWireCutting;
import com.science.gtnl.common.machine.multiblock.NineIndustrialMultiMachine;
import com.science.gtnl.common.machine.multiblock.PetrochemicalPlant;
import com.science.gtnl.common.machine.multiblock.PrimitiveDistillationTower;
import com.science.gtnl.common.machine.multiblock.ProcessingArray;
import com.science.gtnl.common.machine.multiblock.RareEarthCentrifugal;
import com.science.gtnl.common.machine.multiblock.RealArtificialStar;
import com.science.gtnl.common.machine.multiblock.SmeltingMixingFurnace;
import com.science.gtnl.common.machine.multiblock.SteamCracking;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.ColdIceFreezer;
import com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan.MegaBlastFurnace;
import com.science.gtnl.common.machine.multiblock.TeleportationArrayToAlfheim;
import com.science.gtnl.common.machine.multiblock.WhiteNightGenerator;

import gtPlusPlus.api.objects.Logger;
import gtPlusPlus.core.util.minecraft.FluidUtils;
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
        EdenGarden = new EdenGarden(21004, "NameEdenGarden", TextLocalization.NameEdenGarden).getStackForm(1);
        GTNLItemList.EdenGarden.set(EdenGarden);

        LargeSteamCircuitAssembler = new LargeSteamCircuitAssembler(
            21005,
            "NameLargeSteamCircuitAssembler",
            TextLocalization.NameLargeSteamCircuitAssembler).getStackForm(1);
        GTNLItemList.LargeSteamCircuitAssembler.set(LargeSteamCircuitAssembler);

        GenerationEarthEngine = new GenerationEarthEngine(
            21006,
            "NameGenerationEarthEngine",
            TextLocalization.NameGenerationEarthEngine).getStackForm(1);
        GTNLItemList.GenerationEarthEngine.set(GenerationEarthEngine);

        BloodSoulSacrificialArray = new BloodSoulSacrificialArray(
            21007,
            "NameBloodSoulSacrificialArray",
            TextLocalization.NameBloodSoulSacrificialArray).getStackForm(1);
        GTNLItemList.BloodSoulSacrificialArray.set(BloodSoulSacrificialArray);

        RealArtificialStar = new RealArtificialStar(
            21008,
            "NameRealArtificialStar",
            TextLocalization.NameRealArtificialStar).getStackForm(1);
        GTNLItemList.RealArtificialStar.set(RealArtificialStar);

        TeleportationArrayToAlfheim = new TeleportationArrayToAlfheim(
            21009,
            "NameTeleportationArrayToAlfheim",
            TextLocalization.NameTeleportationArrayToAlfheim).getStackForm(1);
        GTNLItemList.TeleportationArrayToAlfheim.set(TeleportationArrayToAlfheim);

        LapotronChip = new LapotronChip(21010, "NameLapotronChip", TextLocalization.NameLapotronChip).getStackForm(1);
        GTNLItemList.LapotronChip.set(LapotronChip);

        NeutroniumWireCutting = new NeutroniumWireCutting(
            21011,
            "NameNeutroniumWireCutting",
            TextLocalization.NameNeutroniumWireCutting).getStackForm(1);
        GTNLItemList.NeutroniumWireCutting.set(NeutroniumWireCutting);

        LargeSteamCrusher = new LargeSteamCrusher(
            21012,
            "NameLargeSteamCrusher",
            TextLocalization.NameLargeSteamCrusher).getStackForm(1);
        GTNLItemList.LargeSteamCrusher.set(LargeSteamCrusher);

        ComponentAssembler = new ComponentAssembler(
            21013,
            "NameComponentAssembler",
            TextLocalization.NameComponentAssembler).getStackForm(1);
        GTNLItemList.ComponentAssembler.set(ComponentAssembler);

        LargeSteamFurnace = new LargeSteamFurnace(
            21014,
            "NameLargeSteamFurnace",
            TextLocalization.NameLargeSteamFurnace).getStackForm(1);
        GTNLItemList.LargeSteamFurnace.set(LargeSteamFurnace);

        LargeSteamAlloySmelter = new LargeSteamAlloySmelter(
            21015,
            "NameLargeSteamAlloySmelter",
            TextLocalization.NameLargeSteamAlloySmelter).getStackForm(1);
        GTNLItemList.LargeSteamAlloySmelter.set(LargeSteamAlloySmelter);

        LargeSteamThermalCentrifuge = new LargeSteamThermalCentrifuge(
            21016,
            "NameLargeSteamThermalCentrifuge",
            TextLocalization.NameLargeSteamThermalCentrifuge).getStackForm(1);
        GTNLItemList.LargeSteamThermalCentrifuge.set(LargeSteamThermalCentrifuge);

        SteamCracking = new SteamCracking(21017, "NameSteamCracking", TextLocalization.NameSteamCracking)
            .getStackForm(1);
        GTNLItemList.SteamCracking.set(SteamCracking);

        LargeSteamChemicalBath = new LargeSteamChemicalBath(
            21018,
            "NameLargeSteamChemicalBath",
            TextLocalization.NameLargeSteamChemicalBath).getStackForm(1);
        GTNLItemList.LargeSteamChemicalBath.set(LargeSteamChemicalBath);

        PrimitiveDistillationTower = new PrimitiveDistillationTower(
            21019,
            "NamePrimitiveDistillationTower",
            TextLocalization.NamePrimitiveDistillationTower).getStackForm(1);
        GTNLItemList.PrimitiveDistillationTower.set(PrimitiveDistillationTower);

        MeteorMiner = new MeteorMiner(21020, "NameMeteorMiner", TextLocalization.NameMeteorMiner).getStackForm(1);
        GTNLItemList.MeteorMiner.set(MeteorMiner);

        Desulfurizer = new Desulfurizer(21021, "NameDesulfurizer", TextLocalization.NameDesulfurizer).getStackForm(1);
        GTNLItemList.Desulfurizer.set(Desulfurizer);

        LargeCircuitAssembler = new LargeCircuitAssembler(
            21022,
            "NameLargeCircuitAssembler",
            TextLocalization.NameLargeCircuitAssembler).getStackForm(1);
        GTNLItemList.LargeCircuitAssembler.set(LargeCircuitAssembler);

        PetrochemicalPlant = new PetrochemicalPlant(
            21023,
            "NamePetrochemicalPlant",
            TextLocalization.NamePetrochemicalPlant).getStackForm(1);
        GTNLItemList.PetrochemicalPlant.set(PetrochemicalPlant);

        SmeltingMixingFurnace = new SmeltingMixingFurnace(
            21024,
            "NameSmeltingMixingFurnace",
            TextLocalization.NameSmeltingMixingFurnace).getStackForm(1);
        GTNLItemList.SmeltingMixingFurnace.set(SmeltingMixingFurnace);

        WhiteNightGenerator = new WhiteNightGenerator(
            21025,
            "NameWhiteNightGenerator",
            TextLocalization.NameWhiteNightGenerator).getStackForm(1);
        GTNLItemList.WhiteNightGenerator.set(WhiteNightGenerator);

        ProcessingArray = new ProcessingArray(21026, "NameProcessingArray", TextLocalization.NameProcessingArray)
            .getStackForm(1);
        GTNLItemList.ProcessingArray.set(ProcessingArray);

        MegaBlastFurnace = new MegaBlastFurnace(21027, "NameMegaBlastFurnace", TextLocalization.NameMegaBlastFurnace)
            .getStackForm(1);
        GTNLItemList.MegaBlastFurnace.set(MegaBlastFurnace);

        BrickedBlastFurnace = new BrickedBlastFurnace(
            21028,
            "NameBrickedBlastFurnace",
            TextLocalization.NameBrickedBlastFurnace).getStackForm(1);
        GTNLItemList.BrickedBlastFurnace.set(BrickedBlastFurnace);

        RareEarthCentrifugal = new RareEarthCentrifugal(
            21029,
            "NameRareEarthCentrifugal",
            TextLocalization.NameRareEarthCentrifugal).getStackForm(1);
        GTNLItemList.RareEarthCentrifugal.set(RareEarthCentrifugal);

        ColdIceFreezer = new ColdIceFreezer(21030, "NameColdIceFreezer", TextLocalization.NameColdIceFreezer)
            .getStackForm(1);
        GTNLItemList.ColdIceFreezer.set(ColdIceFreezer);

        CheatOreProcessingFactory = new CheatOreProcessingFactory(
            21919,
            "NameCheatOreProcessingFactory",
            TextLocalization.NameCheatOreProcessingFactory).getStackForm(1);
        GTNLItemList.CheatOreProcessingFactory.set(CheatOreProcessingFactory);

        NineIndustrialMultiMachine = new NineIndustrialMultiMachine(
            21920,
            "NameNineIndustrialMultiMachine",
            TextLocalization.NameNineIndustrialMultiMachine).getStackForm(1);
        GTNLItemList.NineIndustrialMultiMachine.set(NineIndustrialMultiMachine);

        MTEHatchRack.run();
        MTEHatchCapacitor.run();
    }

    public static void registerMTEHatch() {

        GTNLItemList.FluidManaInputHatch.set(
            new MTEHatchCustomFluid(
                FluidUtils.getFluidStack("fluidmana", 1)
                    .getFluid(),
                512000,
                21501,
                "Fluid Mana Input Hatch",
                TextLocalization.FluidManaInputHatch,
                6).getStackForm(1L));

        GTNLItemList.FluidIceInputHatch.set(
            new MTEHatchCustomFluid(
                FluidUtils.getFluidStack("ice", 1)
                    .getFluid(),
                256000,
                21502,
                "Fluid Ice Input Hatch",
                TextLocalization.FluidIceInputHatch,
                5).getStackForm(1L));
    }

    public static void run() {
        Logger.INFO("GTNL Content | Registering Custom MTE Hatches.");
        registerMTEHatch();
    }
}
