package com.science.gtnl.loader;

import static com.science.gtnl.common.CustomItemList.MTEInfinityHatchOutputBusME;
import static com.science.gtnl.common.CustomItemList.MTEInfinityHatchOutputME;
import static com.science.gtnl.common.CustomItemList.MTEIntegratedOutputHatchME;
import static com.science.gtnl.common.CustomItemList.hatch_AutoSterileMaintenanceHatch;

import net.minecraft.item.ItemStack;

import com.science.gtnl.Utils.TextLocalization;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.machine.MTEHatchSterileMaintenance;
import com.science.gtnl.common.machine.MTEInfinityHatchOutputBusME;
import com.science.gtnl.common.machine.MTEInfinityHatchOutputME;
import com.science.gtnl.common.machine.MTEIntegratedOutputHatchME;
import com.science.gtnl.common.machine.MTEQuadrupleOutputHatch;
import com.science.gtnl.machine.BloodSoulSacrificialArray;
import com.science.gtnl.machine.GenerationEarthEngine;
import com.science.gtnl.machine.RealArtificialStar;
import com.science.gtnl.machine.SteamMulti.LargeSteamCircuitAssembler;

import tectech.thing.metaTileEntity.hatch.MTEHatchCapacitor;
import tectech.thing.metaTileEntity.hatch.MTEHatchRack;

public class MachineLoader {

    public static ItemStack LargeSteamCircuitAssembler;
    public static ItemStack GenerationEarthEngine;
    public static ItemStack BloodSoulSacrificialArray;
    public static ItemStack RealArtificialStar;

    public static void loadMachines() {
        hatch_AutoSterileMaintenanceHatch.set(
            new MTEHatchSterileMaintenance(
                21001,
                "gtnl.sterile.maintenance",
                "Auto-Taping Sterile Maintenance Hatch",
                14).getStackForm(1L));

        MTEInfinityHatchOutputBusME.set(
            new MTEInfinityHatchOutputBusME(21002, "gtnl.ae2.InfinityOutputBusME", "Infinity Output Bus (ME)", 4)
                .getStackForm(1L));

        MTEInfinityHatchOutputME.set(
            new MTEInfinityHatchOutputME(21003, "gtnl.ae2.InfinityOutputME", "Infinity Output Hatch (ME)", 3)
                .getStackForm(1L));

        MTEIntegratedOutputHatchME.set(
            new MTEIntegratedOutputHatchME(21004, "gtnl.ae2.IntegratedOutputHatchME", "Integrated Output Hatch (ME)")
                .getStackForm(1L));

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

        MTEHatchRack.run();
        MTEHatchCapacitor.run();
    }

    public static void registerOutputCombined() {}

    public static void registerQuadrupleOutputHatch() {
        GTNLItemList.QuadrupleOutputHatchEV.set(
            new MTEQuadrupleOutputHatch(21009, "gtnl.Hatch.QuadrupleOutputHatchEV", "Quadruple Output Hatch (EV)", 4)
                .getStackForm(1L));
    }

    public static void run() {
        registerQuadrupleOutputHatch();
        registerOutputCombined();
    }
}
