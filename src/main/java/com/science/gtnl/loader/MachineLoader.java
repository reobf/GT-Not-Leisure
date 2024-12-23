package com.science.gtnl.loader;

import net.minecraft.item.ItemStack;

import com.science.gtnl.Utils.TextLocalization;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.hatch.MTEHatchCustomFluid;
import com.science.gtnl.common.machine.BloodSoulSacrificialArray;
import com.science.gtnl.common.machine.CheatOreProcessingFactory;
import com.science.gtnl.common.machine.ComponentAssembler;
import com.science.gtnl.common.machine.Desulfurizer;
import com.science.gtnl.common.machine.EdenGarden;
import com.science.gtnl.common.machine.GenerationEarthEngine;
import com.science.gtnl.common.machine.LapotronChip;
import com.science.gtnl.common.machine.LargeCircuitAssembler;
import com.science.gtnl.common.machine.LargeSteamAlloySmelter;
import com.science.gtnl.common.machine.LargeSteamChemicalBath;
import com.science.gtnl.common.machine.LargeSteamCircuitAssembler;
import com.science.gtnl.common.machine.LargeSteamCrusher;
import com.science.gtnl.common.machine.LargeSteamFurnace;
import com.science.gtnl.common.machine.LargeSteamThermalCentrifuge;
import com.science.gtnl.common.machine.MeteorMiner;
import com.science.gtnl.common.machine.NeutroniumWireCutting;
import com.science.gtnl.common.machine.PrimitiveDistillationTower;
import com.science.gtnl.common.machine.RealArtificialStar;
import com.science.gtnl.common.machine.SteamCracking;
import com.science.gtnl.common.machine.TeleportationArrayToAlfheim;

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

        CheatOreProcessingFactory = new CheatOreProcessingFactory(
            21919,
            "NameCheatOreProcessingFactory",
            TextLocalization.NameCheatOreProcessingFactory).getStackForm(1);
        GTNLItemList.CheatOreProcessingFactory.set(CheatOreProcessingFactory);

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
                TextLocalization.FluidManaInputHatch,
                "Fluid Mana Input Hatch",
                5).getStackForm(1L));
    }

    public static void run() {
        Logger.INFO("GTNL Content | Registering Custom MTE Hatches.");
        registerMTEHatch();
    }
}
