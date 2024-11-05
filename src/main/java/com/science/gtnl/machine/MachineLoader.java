package com.science.gtnl.machine;

import static com.science.gtnl.common.CustomItemList.*;
import static net.minecraft.util.StatCollector.translateToLocal;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.science.gtnl.Utils.TextLocalization;
import com.science.gtnl.Utils.TextUtils;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.machine.MTEHatchOutputME;
import com.science.gtnl.common.machine.MTEHatchSterileMaintenance;
import com.science.gtnl.common.machine.MTEInfinityHatchOutputBusME;
import com.science.gtnl.common.machine.MTEInfinityHatchOutputME;
import com.science.gtnl.common.machine.MTEIntegratedOutputHatch;
import com.science.gtnl.common.machine.MTEIntegratedOutputHatchME;
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

        MTEIntegratedOutputHatchME.set(
            new MTEIntegratedOutputHatchME(
                21019,
                "gtnl.ae2.IntegratedOutputHatchME",
                "Integrated Output Hatch (ME)",
                14).getStackForm(1L));

        MTEInfinityHatchOutputBusME.set(
            new MTEInfinityHatchOutputBusME(21020, "gtnl.ae2.InfinityOutputBusME", "Infinity Output Bus (ME)", 4)
                .getStackForm(1L));

        MTEInfinityHatchOutputME.set(
            new MTEInfinityHatchOutputME(21021, "gtnl.ae2.InfinityOutputME", "Infinity Output Hatch (ME)")
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

    private static void registerOutputCombined() {
        GTNLItemList.Hatch_Output_ME
            .set(new MTEHatchOutputME(21022, "hatch.output.me", "Output Hatch (ME)").getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_ULV.set(
            new MTEIntegratedOutputHatch(
                21004,
                "Combined.output.tier.00",
                "Integrated Output Hatch (ULV)",
                0,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_LV.set(
            new MTEIntegratedOutputHatch(
                21005,
                "Combined.output.tier.01",
                "Integrated Output Hatch (LV)",
                1,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_MV.set(
            new MTEIntegratedOutputHatch(
                21006,
                "Combined.output.tier.02",
                "Integrated Output Hatch (MV)",
                2,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_HV.set(
            new MTEIntegratedOutputHatch(
                21007,
                "Combined.output.tier.03",
                "Integrated Output Hatch (HV)",
                3,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_EV.set(
            new MTEIntegratedOutputHatch(
                21008,
                "Combined.output.tier.04",
                "Integrated Output Hatch (EV)",
                4,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_IV.set(
            new MTEIntegratedOutputHatch(
                21009,
                "Combined.output.tier.05",
                "Integrated Output Hatch (IV)",
                5,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_LuV.set(
            new MTEIntegratedOutputHatch(
                21010,
                "Combined.output.tier.06",
                "Integrated Output Hatch (LuV)",
                6,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_ZPM.set(
            new MTEIntegratedOutputHatch(
                21011,
                "Combined.output.tier.07",
                "Integrated Output Hatch (ZPM)",
                7,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_UV.set(
            new MTEIntegratedOutputHatch(
                21012,
                "Combined.output.tier.08",
                "Integrated Output Hatch (UV)",
                8,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_UHV.set(
            new MTEIntegratedOutputHatch(
                21013,
                "Combined.output.tier.09",
                "Integrated Output Hatch (UHV)",
                9,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_UEV.set(
            new MTEIntegratedOutputHatch(
                21014,
                "Combined.output.tier.10",
                "Integrated Output Hatch (UEV)",
                10,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_UIV.set(
            new MTEIntegratedOutputHatch(
                21015,
                "Combined.output.tier.11",
                "Integrated Output Hatch (UIV)",
                11,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_UMV.set(
            new MTEIntegratedOutputHatch(
                21016,
                "Combined.output.tier.12",
                "Integrated Output Hatch (UMV)",
                12,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_UXV.set(
            new MTEIntegratedOutputHatch(
                21017,
                "Combined.output.tier.13",
                "Integrated Output Hatch (UXV)",
                13,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
        GTNLItemList.Integrated_Output_Hatch_MAX.set(
            new MTEIntegratedOutputHatch(
                21018,
                "Combined.output.tier.14",
                "Integrated Output Hatch (MAX)",
                14,
                new String[] { TextUtils.AE, translateToLocal("gt.blockmachines.gtnl.IntegratedOutputHatchME.desc.0"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.1"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.2") + EnumChatFormatting.YELLOW
                        + translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.3"),
                    translateToLocal("gt.blockmachines.gtnl.InfinityOutputME.desc.4") }).getStackForm(1L));
    }

    public static void run() {
        registerOutputCombined();
    }

}
