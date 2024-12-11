package com.science.gtnl.Utils;

import static com.science.gtnl.Utils.TextHandler.texter;

import net.minecraft.util.EnumChatFormatting;

import gregtech.api.util.GTLanguageManager;

public class TextLocalization {

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

    public static final String textAnyCasing = texter("Any Casing", "textAnyCasing");

    public static final String CircuitAssemblerRecipeType = texter("Circuit Assembler", "CircuitAssemblerRecipeType");
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

    public static final String NameLargeSteamCircuitAssembler = texter(
        "Large Steam Circuit Assembler",
        "NameLargeSteamCircuitAssembler");
    public static final String Tooltip_LargeSteamCircuitAssembler_00 = texter(
        "25%% faster than using single block steam machines of the same pressure",
        "Tooltip_LargeSteamCircuitAssembler_00");
    public static final String Tooltip_LargeSteamCircuitAssembler_01 = texter(
        "Only consumes steam at 62.5%% of the L/s normally required",
        "Tooltip_LargeSteamCircuitAssembler_01");
    public static final String Tooltip_LargeSteamCircuitAssembler_02 = texter(
        "Processes up to 16 items at once",
        "Tooltip_LargeSteamCircuitAssembler_02");
    public static final String Tooltip_LargeSteamCircuitAssembler_03 = texter(
        "Primitive technology!",
        "Tooltip_LargeSteamCircuitAssembler_03");

    public static final String NameEdenGarden = texter("Ecological Singularity \"Edenscape\"", "NameEdenGarden");
    public static final String EdenGardenRecipeType = texter("Crop Farm", "gtnl.recipe.EdenGardenRecipeType");
    public static final String Tooltip_EdenGarden_00 = texter(
        "§e§oGod said, \"Let the land produce vegetation: seed-bearing plants and trees on the land that bear fruit with seed in it.\"",
        "Tooltip_EdenGarden_00");
    public static final String Tooltip_EdenGarden_01 = texter(
        "§e§oAnd so the earth brought forth vegetation, with a variety of fruits and vegetables in abundance.",
        "Tooltip_EdenGarden_01");
    public static final String Tooltip_EdenGarden_02 = texter(
        "§e§oThe seeds multiplied, filling the land with vibrant life.",
        "Tooltip_EdenGarden_02");
    public static final String Tooltip_EdenGarden_03 = texter(
        "100 times faster than Extreme Industrial Greenhouse!",
        "Tooltip_EdenGarden_03");
    public static final String Tooltip_EdenGarden_04 = texter(
        "No longer need fertilizers and herbicides!",
        "Tooltip_EdenGarden_04");
    public static final String Tooltip_EdenGarden_05 = texter(
        "Each crop consumes 2000L of water",
        "Tooltip_EdenGarden_05");
    public static final String Tooltip_EdenGarden_Casing = texter(
        "Any Electric Compressor Casing",
        "Tooltip_EdenGarden_Casing");

    public static final String NameGenerationEarthEngine = texter(
        "Generation Earth Engine",
        "NameGenerationEarthEngine");
    public static final String GenerationEarthEngineRecipeType = texter(
        "Recombination Fusion Reactor",
        "gtnl.recipe.GenerationEarthEngineRecipeType");
    public static final String Tooltip_GenerationEarthEngine_00 = texter(
        "Even though years have passed, it still stands firm",
        "Tooltip_GenerationEarthEngine_00");
    public static final String Tooltip_GenerationEarthEngine_01 = texter(
        "The product of the pinnacle of human technology!",
        "Tooltip_GenerationEarthEngine_01");
    public static final String Tooltip_GenerationEarthEngine_Casing = texter(
        "Any Iron Plated Bricks",
        "Tooltip_GenerationEarthEngine_Casing");

    public static final String NameLapotronChip = texter("Lapotron Chip", "NameLapotronChip");
    public static final String LapotronChipRecipeType = texter("Lapotron Chip", "gtnl.recipe.LapotronChipRecipeType");
    public static final String Tooltip_LapotronChip_00 = texter("WIP", "Tooltip_LapotronChip_00");
    public static final String Tooltip_LapotronChip_01 = texter("WIP", "Tooltip_LapotronChip_01");
    public static final String Tooltip_LapotronChip_Casing = texter(
        "Any Radiant Naquadah Alloy Casing",
        "Tooltip_LapotronChip_Casing");

    public static final String NameBloodSoulSacrificialArray = texter(
        "Blood SoulSacrificial Array",
        "NameBloodSoulSacrificialArray");
    public static final String BloodSoulSacrificialArrayRecipeType = texter(
        "Blood Soul Trading / Blood Demon Injection / Alchemic Chemistry Set",
        "BloodSoulSacrificialArrayRecipeType");
    public static final String Tooltip_BloodSoulSacrificialArray_00 = texter(
        "§4§oSaSacrifice your soul...",
        "Tooltip_BloodSoulSacrificialArray_00");
    public static final String Tooltip_BloodSoulSacrificialArray_Casing = texter(
        "Ang Mining Blck Plutonium Casing",
        "Tooltip_BloodSoulSacrificialArray_Casing");

    public static final String NameNeutroniumWireCutting = texter(
        "Neutronium Wire Cutting",
        "NameNeutroniumWireCutting");

    public static final String NameTeleportationArrayToAlfheim = texter(
        "Teleportation Array To Alfheim",
        "NameTeleportationArrayToAlfheim");
    public static final String TeleportationArrayToAlfheimRecipeType = texter(
        "Portal To Alfheim / Nature Spirit Array",
        "TeleportationArrayToAlfheimRecipeType");
    public static final String Tooltip_TeleportationArrayToAlfheim_00 = texter(
        "It is said that this Nature Spirit Array can stably transmit a large amount of materials.",
        "Tooltip_TeleportationArrayToAlfheim_00");
    public static final String Tooltip_TeleportationArrayToAlfheim_01 = texter(
        "Need Fluid Mana Input Hatch",
        "Tooltip_TeleportationArrayToAlfheim_01");
    public static final String Tooltip_TeleportationArrayToAlfheim_02 = texter(
        "Consuming 100L of Fluid Mana per second during work",
        "Tooltip_TeleportationArrayToAlfheim_02");
    public static final String Tooltip_TeleportationArrayToAlfheim_Casing = texter(
        "Any Radiant Naquadah Alloy Casing",
        "Tooltip_TeleportationArrayToAlfheim_Casing");

    public static final String NameRealArtificialStar = texter("Real Artificial Star", "NameRealArtificialStar");
    public static final String Tooltip_RealArtificialStar_MachineType = texter(
        "Dyson Sphere Program: Annihilation Generator",
        "gtnl.recipe.ArtificialStarGeneratingRecipes");
    public static final String Tooltip_RealArtificialStar_Controller = texter(
        "Controller block for the Real Artificial Star",
        "Tooltip_RealArtificialStar_Controller");
    public static final String Tooltip_RealArtificialStar_00 = texter(
        EnumChatFormatting.LIGHT_PURPLE + ""
            + EnumChatFormatting.BOLD
            + "Just replaced the structure of TST, the rest of the functions are the same",
        "Tooltip_RealArtificialStar_00");
    public static final String Tooltip_RealArtificialStar_01 = texter(
        EnumChatFormatting.LIGHT_PURPLE + ""
            + EnumChatFormatting.BOLD
            + "All you need to do is to let the proton and antiproton beams",
        "Tooltip_RealArtificialStar_01");
    public static final String Tooltip_RealArtificialStar_02 = texter(
        EnumChatFormatting.LIGHT_PURPLE + ""
            + EnumChatFormatting.BOLD
            + " pass silently from both ends into the annihilation constrainer. Easy peasy!",
        "Tooltip_RealArtificialStar_02");
    public static final String Tooltip_RealArtificialStar_03 = texter(
        "It owes its simple shape to the elegance of the theory.",
        "Tooltip_RealArtificialStar_03");
    public static final String Tooltip_RealArtificialStar_04 = texter(
        "Actual output power is affected by 3 types tiered block.",
        "Tooltip_RealArtificialStar_04");
    public static final String Tooltip_RealArtificialStar_05 = texter(
        "At the same time, higher tier increase the probability of recovering materials.",
        "Tooltip_RealArtificialStar_05");
    public static final String Tooltip_RealArtificialStar_06 = texter(
        "Continuous operation improves power generation.",
        "Tooltip_RealArtificialStar_06");
    public static final String Tooltip_RealArtificialStar_07 = texter(
        "Only and must install 1 input bus.",
        "Tooltip_RealArtificialStar_07");
    public static final String Tooltip_RealArtificialStar_08 = texter(
        "Energy will output to Wireless EU Net directly.",
        "Tooltip_RealArtificialStar_08");
    public static final String Tooltip_RealArtificialStar_09 = texter(
        "Use screwdriver to enable/disable animations.",
        "Tooltip_RealArtificialStar_09");
    public static final String Tooltip_RealArtificialStar_02_01 = texter(
        "Output multiplier = tTime^0.25 * tDim^0.25 * 1.588186^(tStabilisation - 2)",
        "Tooltip_RealArtificialStar_02_01");
    public static final String Tooltip_RealArtificialStar_02_02 = texter(
        "Actual Generating EU = recipe value * output multiplier * Rewards for continuous operation",
        "Tooltip_RealArtificialStar_02_02");
    public static final String Tooltip_RealArtificialStar_02_03 = texter(
        "Recovering probability = tTime * tDim * tStabilisation / 1000",
        "Tooltip_RealArtificialStar_02_03");
    public static final String Tooltip_RealArtificialStar_02_04 = texter(
        "Input fuels will be consumed at once, process 6.4s (default), and output the corresponding EU.",
        "Tooltip_RealArtificialStar_02_04");
    public static final String Tooltip_RealArtificialStar_02_05 = texter(
        "Rewards multiplier 1%% increase per run when continuous operation.",
        "Tooltip_RealArtificialStar_02_05");
    public static final String Tooltip_RealArtificialStar_02_06 = texter(
        "Maximum is 150%% , Minimum is 100%% when uncontinuous.",
        "Tooltip_RealArtificialStar_02_06");
    public static final String Tooltip_RealArtificialStarInfo_01 = texter(
        "17604x Radiant Naquadah Alloy Casing",
        "Tooltip_RealArtificialStarInfo_01");
    public static final String Tooltip_RealArtificialStarInfo_02 = texter(
        "11539x Extreme Density Space-Bending Casing",
        "Tooltip_RealArtificialStarInfo_02");
    public static final String Tooltip_RealArtificialStarInfo_03 = texter(
        "2839x Shielded Accelerator Casing",
        "Tooltip_RealArtificialStarInfo_03");
    public static final String Tooltip_RealArtificialStarInfo_04 = texter(
        "1336x Dyson Swarm Energy Receiver Base Casing",
        "Tooltip_RealArtificialStarInfo_04");
    public static final String Tooltip_RealArtificialStarInfo_05 = texter(
        "1021x Compact Fusion Coil Coil MK-II Finaltype",
        "Tooltip_RealArtificialStarInfo_05");
    public static final String Tooltip_RealArtificialStarInfo_06 = texter(
        "977x Dimensional Bridge or Spacetime Compression Field Generator",
        "Tooltip_RealArtificialStarInfo_06");
    public static final String Tooltip_RealArtificialStarInfo_07 = texter(
        "628x Dyson Swarm Control Center Base Casing",
        "Tooltip_RealArtificialStarInfo_07");
    public static final String Tooltip_RealArtificialStarInfo_08 = texter(
        "555x Stabilisation Field Generator",
        "Tooltip_RealArtificialStarInfo_08");
    public static final String Tooltip_RealArtificialStarInfo_09 = texter(
        "253x Quantum Glass",
        "Tooltip_RealArtificialStarInfo_09");
    public static final String Tooltip_RealArtificialStarInfo_10 = texter(
        "213x Dyson Swarm Control Center Toroid Casing",
        "Tooltip_RealArtificialStarInfo_10");
    public static final String Tooltip_RealArtificialStarInfo_11 = texter(
        "152x Time Acceleration Field Generator",
        "Tooltip_RealArtificialStarInfo_11");
    public static final String Tooltip_RealArtificialStarInfo_12 = texter(
        "26x Dimensional Injection Casing",
        "Tooltip_RealArtificialStarInfo_12");
    public static final String Tooltip_RealArtificialStarInfo_13 = texter(
        "Input Bus: Any Dimensional Injection Casing",
        "Tooltip_RealArtificialStarInfo_13");
    public static final String Tooltip_RealArtificialStarInfo_14 = texter(
        "Output Bus: Any Dimensional Injection Casing",
        "Tooltip_RealArtificialStarInfo_14");
}
