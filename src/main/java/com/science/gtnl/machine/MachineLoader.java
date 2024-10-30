package com.science.gtnl.machine;

import static com.science.gtnl.common.CustomItemList.*;

import net.minecraft.item.ItemStack;

import com.science.gtnl.Utils.TextLocalization;
import com.science.gtnl.common.item.GTNLItemList;
import com.science.gtnl.common.machine.MTEHatchSterileMaintenance;

import tectech.thing.metaTileEntity.hatch.MTEHatchCapacitor;
import tectech.thing.metaTileEntity.hatch.MTEHatchRack;

/**
 * Created by danie_000 on 16.11.2016.
 */
public class MachineLoader {

    public static ItemStack LargeSteamCircuitAssembler;

    private static final int offsetID_01 = 21_000;

    public static void loadMachines() {
        hatch_AutoSterileMaintenanceHatch.set(
            new MTEHatchSterileMaintenance(
                offsetID_01 + 1,
                "gtnl.sterile.maintenance",
                "Auto-Taping Sterile Maintenance Hatch",
                14).getStackForm(1L));

        LargeSteamCircuitAssembler = new LargeSteamCircuitAssembler(
            21002,
            "NameLargeSteamCircuitAssembler",
            TextLocalization.NameLargeSteamCircuitAssembler).getStackForm(1);
        GTNLItemList.LargeSteamCircuitAssembler.set(LargeSteamCircuitAssembler);
        // ===================================================================================================
        // MetaTE init
        // ===================================================================================================
        MTEHatchRack.run();
        MTEHatchCapacitor.run();
    }
}
