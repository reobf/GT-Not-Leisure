package com.science.gtnl.Utils;

import static com.science.gtnl.Utils.TextHandler.texter;

import net.minecraft.util.EnumChatFormatting;

import com.science.gtnl.ScienceNotLeisure;

import gregtech.api.util.GTLanguageManager;

public class TextLocalization {

    public static final String ModName = ScienceNotLeisure.MODNAME;
    public static final String ModNameDesc = texter(
        "Added by " + EnumChatFormatting.GREEN + ModName + EnumChatFormatting.GRAY,
        "ModNameDesc");
    public static final String HeatCapacity = texter("Heat Capacity: ", "HeatCapacity");
    public static final String FluidCapacity = texter("Capacity: ", "FluidCapacity");
    public static final String HatchTier = texter("Hatch Tier: ", "HatchTier");
    public static final String Kelvin = texter(" K", "Kelvin");
    public static final String Text_SeparatingLine = EnumChatFormatting.GOLD
        + "-----------------------------------------";
    public static final String BLUE_PRINT_INFO = texter(
        "Follow the" + EnumChatFormatting.BLUE
            + " Structure"
            + EnumChatFormatting.DARK_BLUE
            + "Lib"
            + EnumChatFormatting.GRAY
            + " hologram projector to build the main structure.",
        "BLUE_PRINT_INFO");

    public static final String mNoMobsToolTip = GTLanguageManager
        .addStringLocalization("gt.nomobspawnsonthisblock", "Mobs cannot Spawn on this Block");
    public static final String mNoTileEntityToolTip = GTLanguageManager
        .addStringLocalization("gt.notileentityinthisblock", "This is NOT a TileEntity!");

    public static final String StructureTooComplex = texter("The structure is too complex!", "StructureTooComplex");
    public static final String textCasing = texter("Casing", "textCasing");
    public static final String textUseBlueprint = texter(
        "Use " + EnumChatFormatting.BLUE
            + "Blue"
            + EnumChatFormatting.AQUA
            + "print"
            + EnumChatFormatting.RESET
            + " to preview",
        "textUseBlueprint");
    public static final String textAnyCasing = texter("Any Casing", "textAnyCasing");
    public static final String textTopCenter = texter("Top center", "textTopCenter");
    public static final String textFrontCenter = texter("Front center", "textFrontCenter");
    public static final String textFrontBottom = texter("Front bottom", "textFrontBottom");
    public static final String textCenterOfLRSides = texter(
        "Center area of left and right side",
        "textCenterOfLRSides");

    public static final String[] Tooltips_Upgrades_LV = new String[] {
        texter("Extra 1%% Speed Up !", "PhotonControllerUpgradeLV.tooltips.01") };
    public static final String[] Tooltips_Upgrades_MV = new String[] {
        texter("Extra 2%% Speed Up !", "PhotonControllerUpgradeMV.tooltips.01") };
    public static final String[] Tooltips_Upgrades_HV = new String[] {
        texter("Extra 3%% Speed Up !", "PhotonControllerUpgradeHV.tooltips.01") };
    public static final String[] Tooltips_Upgrades_EV = new String[] {
        texter("Extra 4%% Speed Up !", "PhotonControllerUpgradeEV.tooltips.01") };
    public static final String[] Tooltips_Upgrades_IV = new String[] {
        texter("Extra 5%% Speed Up !", "PhotonControllerUpgradeIV.tooltips.01") };
    public static final String[] Tooltips_Upgrades_LuV = new String[] {
        texter("Extra 10%% Speed Up !", "PhotonControllerUpgradeLuV.tooltips.01") };
    public static final String[] Tooltips_Upgrades_ZPM = new String[] {
        texter("Extra 20%% Speed Up !", "PhotonControllerUpgradeZPM.tooltips.01") };
    public static final String[] Tooltips_Upgrades_UV = new String[] {
        texter("Extra 40%% Speed Up !", "PhotonControllerUpgradeUV.tooltips.01") };
    public static final String[] Tooltips_Upgrades_UHV = new String[] {
        texter("Extra 70%% Speed Up !", "PhotonControllerUpgradeUHV.tooltips.01") };
    public static final String[] Tooltips_Upgrades_UEV = new String[] {
        texter("Extra 100%% Speed Up !", "PhotonControllerUpgradeUEV.tooltips.01") };
    public static final String[] Tooltips_Upgrades_UIV = new String[] {
        texter("Extra 140%% Speed Up !", "PhotonControllerUpgradeUiV.tooltips.01") };
    public static final String[] Tooltips_Upgrades_UMV = new String[] {
        texter("Extra 190%% Speed Up !", "PhotonControllerUpgradeUMV.tooltips.01"),
        texter("Enable Perfect Overclock !", "PhotonControllerUpgradeUMV.tooltips.02") };
    public static final String[] Tooltips_Upgrades_UXV = new String[] {
        texter("Extra 250%% Speed Up !", "PhotonControllerUpgradeUXV.tooltips.01"),
        texter("Enable Perfect Overclock !", "PhotonControllerUpgradeUXV.tooltips.02") };
    public static final String[] Tooltips_Upgrades_MAX = new String[] {
        texter("Extra 320%% Speed Up !", "PhotonControllerUpgradeMAX.tooltips.01"),
        texter("Enable Perfect Overclock !", "PhotonControllerUpgradeMAX.tooltips.02") };

    public static final String[][] TooltipsUpgrades = new String[][] { Tooltips_Upgrades_LV, Tooltips_Upgrades_MV,
        Tooltips_Upgrades_HV, Tooltips_Upgrades_EV, Tooltips_Upgrades_IV, Tooltips_Upgrades_LuV, Tooltips_Upgrades_ZPM,
        Tooltips_Upgrades_UV, Tooltips_Upgrades_UHV, Tooltips_Upgrades_UEV, Tooltips_Upgrades_UIV,
        Tooltips_Upgrades_UMV, Tooltips_Upgrades_UXV, Tooltips_Upgrades_MAX };

    public static final String CircuitAssembler = texter("Circuit Assembler", "CircuitAssembler");
    public static final String textSteamAssemblyCasing = texter(" Steam Assembly Casing", "textSteamAssemblyCasing");
    public static final String textSteamInputHatch = texter("Steam Input Hatch", "textSteamInputHatch");
    public static final String textTier = texter("Tier", "textTier");
    public static final String textBasic = texter("Basic ", "textBasic");
    public static final String textHighPressure = texter("High Pressure ", "textHighPressure");
    public static final String textBronzePipeCasing = texter(" Bronze Pipe Casing", "textBronzePipeCasing");
    public static final String textBronzePlatedBricks = texter(" Bronze Plated Bricks", "textBronzePlatedBricks");
    public static final String textSteelPipeCasing = texter(" Steel Pipe Casing", "textSteelPipeCasing");
    public static final String textSolidSteelMachineCasing = texter(
        " Solid Steel Machine Casing",
        "textSolidSteelMachineCasing");
    public static final String HIGH_PRESSURE_TOOLTIP_NOTICE = texter(
        "Processing Speed & Steam Consumption is doubled under High Pressure",
        "HIGH_PRESSURE_TOOLTIP_NOTICE");

    public static final String Tooltip_LargeSteamMachine_0 = texter(
        "25% faster than using single block steam machines of the same pressure",
        "Tooltip_LargeSteamMachine_0");
    public static final String Tooltip_LargeSteamMachine_1 = texter(
        "Only consumes steam at 62.5% of the L/s normally required",
        "Tooltip_LargeSteamMachine_1");
    public static final String Tooltip_LargeSteamMachine_2 = texter(
        "Processes up to 16 items at once",
        "Tooltip_LargeSteamMachine_2");

    public static final String NameLargeSteamCircuitAssembler = texter(
        "Large Steam Circuit Assembler",
        "NameLargeSteamCircuitAssembler");
    public static final String Tooltip_LargeSteamCircuitAssembler_0 = texter(
        "Primitive technology!",
        "Tooltip_LargeSteamCircuitAssembler_0");

    public static final String NameGenerationEarthEngine = texter(
        "Generation Earth Engine",
        "NameGenerationEarthEngine");
    public static final String GenerationEarthEngineRecipeType = texter(
        "Recombination Fusion Reactor",
        "GenerationEarthEngineRecipeType");

    public static final String NameBloodSoulSacrificialArray = texter(
        "Blood SoulSacrificial Array",
        "NameBloodSoulSacrificialArray");
    public static final String BloodSoulSacrificialArrayRecipeType = texter(
        "Blood Soul Trading Recipes / Blood Demon Injection",
        "BloodSoulSacrificialArrayRecipeType");
}
