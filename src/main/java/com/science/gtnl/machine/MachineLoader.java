package com.science.gtnl.machine;

import static com.science.gtnl.common.CustomItemList.*;
import static gregtech.api.enums.MetaTileEntityIDs.QUADRUPLE_INPUT_HATCHES_EV;

import com.science.gtnl.common.machine.*;
import gregtech.api.enums.ItemList;
import gregtech.api.metatileentity.implementations.MTEHatchMultiInput;
import net.minecraft.item.ItemStack;

import com.science.gtnl.Utils.TextLocalization;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.machine.SteamMulti.LargeSteamCircuitAssembler;

import tectech.thing.metaTileEntity.hatch.MTEHatchCapacitor;
import tectech.thing.metaTileEntity.hatch.MTEHatchRack;

public class MachineLoader {

    public static ItemStack LargeSteamCircuitAssembler;
    public static ItemStack GenerationEarthEngine;

    public static void loadMachines() {
        hatch_AutoSterileMaintenanceHatch.set(
            new MTEHatchSterileMaintenance(
                21001,
                "gtnl.sterile.maintenance",
                "Auto-Taping Sterile Maintenance Hatch",
                14).getStackForm(1L));

        MTEInfinityHatchOutputBusME.set(
            new MTEInfinityHatchOutputBusME(21004, "gtnl.ae2.InfinityOutputBusME", "Infinity Output Bus (ME)", 4)
                .getStackForm(1L));

        MTEInfinityHatchOutputME.set(
            new MTEInfinityHatchOutputME(21005, "gtnl.ae2.InfinityOutputME", "Infinity Output Hatch (ME)", 3)
                .getStackForm(1L));

        MTEIntegratedOutputHatchME.set(
            new MTEIntegratedOutputHatchME(21006, "gtnl.ae2.IntegratedOutputHatchME", "Integrated Output Hatch (ME)")
                .getStackForm(1L));

        LargeSteamCircuitAssembler = new LargeSteamCircuitAssembler(
            21002,
            "NameLargeSteamCircuitAssembler",
            TextLocalization.NameLargeSteamCircuitAssembler).getStackForm(1);
        GTNLItemList.LargeSteamCircuitAssembler.set(LargeSteamCircuitAssembler);

        GenerationEarthEngine = new GenerationEarthEngine(
            21003,
            "NameGenerationEarthEngine",
            TextLocalization.NameGenerationEarthEngine).getStackForm(1);
        GTNLItemList.GenerationEarthEngine.set(GenerationEarthEngine);

        // ===================================================================================================
        // MetaTE init
        // ===================================================================================================
        MTEHatchRack.run();
        MTEHatchCapacitor.run();
    }

    private static void registerOutputCombined() {}

    private static void registerQuadrupleOutputHatch() {
        GTNLItemList.QuadrupleOutputHatchEV.set(
            new MTEQuadrupleOutputHatch(21007, "gtnl.Hatch.QuadrupleOutputHatchEV", "Quadruple Output Hatch (EV)", 4).getStackForm(1L));
    }

    public static void run() {
        registerQuadrupleOutputHatch();
        registerOutputCombined();
    }
}
