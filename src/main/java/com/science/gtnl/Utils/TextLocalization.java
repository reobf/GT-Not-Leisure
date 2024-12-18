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

    public static final String NameLargeSteamCrusher = texter("Large Steam Crusher", "NameLargeSteamCrusher");
    public static final String LargeSteamCrusherRecipeType = texter("Macerator", "LargeSteamCrusherRecipeType");
    public static final String Tooltip_LargeSteamCrusher_00 = texter(
        "50%% faster than using single block steam machines of the same macerator",
        "Tooltip_LargeSteamCrusher_00");
    public static final String Tooltip_LargeSteamCrusher_01 = texter(
        "Only consumes steam at 125%% of the L/s normally required",
        "Tooltip_LargeSteamCrusher_01");
    public static final String Tooltip_LargeSteamCrusher_02 = texter(
        "Processes up to 32 items at once",
        "Tooltip_LargeSteamCrusher_02");
    public static final String Tooltip_LargeSteamCrusher_Casing = texter(
        "Ang Bronze Plated Bricks or Solid Steel Machine Casing",
        "Tooltip_LargeSteamCrusher_Casing");

    public static final String NameLargeSteamAlloySmelter = texter(
        "Large Steam Alloy Smelter",
        "NameLargeSteamAlloySmelter");
    public static final String LargeSteamAlloySmelterRecipeType = texter(
        "Alloy Smelter",
        "LargeSteamAlloySmelterRecipeType");
    public static final String Tooltip_LargeSteamAlloySmelter_00 = texter(
        "30%% faster than using single block steam machines of the same alloy smelter",
        "Tooltip_LargeSteamAlloySmelter_00");
    public static final String Tooltip_LargeSteamAlloySmelter_01 = texter(
        "Only consumes steam at 80%% of the L/s normally required",
        "Tooltip_LargeSteamAlloySmelter_01");
    public static final String Tooltip_LargeSteamAlloySmelter_02 = texter(
        "Processes up to 16 items at once",
        "Tooltip_LargeSteamAlloySmelter_02");
    public static final String Tooltip_LargeSteamAlloySmelter_Casing = texter(
        "Ang Bronze Plated Bricks or Solid Steel Machine Casing",
        "Tooltip_LargeSteamAlloySmelter_Casing");

    public static final String NameLargeSteamThermalCentrifuge = texter(
        "Large Steam Thermal Centrifuge",
        "NameLargeSteamThermalCentrifuge");
    public static final String LargeSteamThermalCentrifugeRecipeType = texter(
        "Thermal Centrifuge",
        "LargeSteamThermalCentrifugeRecipeType");
    public static final String Tooltip_LargeSteamThermalCentrifuge_00 = texter(
        "75%% faster than using single block steam machines of the same alloy smelter",
        "Tooltip_LargeSteamThermalCentrifuge_00");
    public static final String Tooltip_LargeSteamThermalCentrifuge_01 = texter(
        "Only consumes steam at 80%% of the L/s normally required",
        "Tooltip_LargeSteamThermalCentrifuge_01");
    public static final String Tooltip_LargeSteamThermalCentrifuge_02 = texter(
        "Processes up to 32 items at once",
        "Tooltip_LargeSteamThermalCentrifuge_02");
    public static final String Tooltip_LargeSteamThermalCentrifuge_Casing = texter(
        "Ang Bronze Plated Bricks or Solid Steel Machine Casing",
        "Tooltip_LargeSteamThermalCentrifuge_Casing");

    public static final String NameSteamCracking = texter("Steam Cracking", "NameSteamCracking");
    public static final String SteamCrackingRecipeType = texter("Steam Cracker", "SteamCrackingRecipeType");
    public static final String Tooltip_SteamCracking_00 = texter(
        "Thermally cracks sulfuric hydrocarbons into steam hydrocarbons",
        "Tooltip_SteamCracking_00");
    public static final String Tooltip_SteamCracking_01 = texter(
        "More efficient than the chemical Reactor",
        "Tooltip_SteamCracking_01");
    public static final String Tooltip_SteamCracking_Casing = texter(
        "Ang Bronze Plated Bricks or Solid Steel Machine Casing",
        "Tooltip_SteamCracking_Casing");

    public static final String NameLargeSteamChemicalBath = texter(
        "Large Steam Thermal Centrifuge",
        "NameLargeSteamChemicalBath");
    public static final String LargeSteamChemicalBathRecipeType = texter(
        "Thermal Centrifuge",
        "LargeSteamChemicalBathRecipeType");
    public static final String Tooltip_LargeSteamChemicalBath_00 = texter(
        "80%% faster than using single block steam machines of the same chemical bath",
        "Tooltip_LargeSteamChemicalBath_00");
    public static final String Tooltip_LargeSteamChemicalBath_01 = texter(
        "Only consumes steam at 80%% of the L/s normally required",
        "Tooltip_LargeSteamChemicalBath_01");
    public static final String Tooltip_LargeSteamChemicalBath_02 = texter(
        "Processes up to 16 items at once",
        "Tooltip_LargeSteamChemicalBath_02");
    public static final String Tooltip_LargeSteamChemicalBath_Casing = texter(
        "Ang Bronze Plated Bricks or Solid Steel Machine Casing",
        "Tooltip_LargeSteamChemicalBath_Casing");

    public static final String NamePrimitiveDistillationTower = texter(
        "Primitive Distillation Tower",
        "NamePrimitiveDistillationTower");
    public static final String PrimitiveDistillationTowerRecipeType = texter(
        "Distillation Tower",
        "PrimitiveDistillationTowerRecipeType");
    public static final String Tooltip_PrimitiveDistillationTower_00 = texter(
        "Can only output 6 types of fluids!",
        "Tooltip_PrimitiveDistillationTower_00");
    public static final String Tooltip_PrimitiveDistillationTower_01 = texter(
        "Only consumes steam at 75%% of the L/s normally required",
        "Tooltip_PrimitiveDistillationTower_01");
    public static final String Tooltip_PrimitiveDistillationTower_Casing_01 = texter(
        "Ang Solid Steel Firebox Casing",
        "Tooltip_PrimitiveDistillationTower_Casing_01");
    public static final String Tooltip_PrimitiveDistillationTower_Casing_02 = texter(
        "Ang Solid Steel Machine Casing",
        "Tooltip_PrimitiveDistillationTower_Casing_02");

    public static final String NameCheatOreProcessingFactory = texter(
        "Cheat Ore Processing Factory",
        "NameCheatOreProcessingFactory");
    public static final String CheatOreProcessingFactoryRecipeType = texter(
        "Quick mineral processing for cheaters",
        "CheatOreProcessingFactoryRecipeType");

    public static final String NameMeteorMiner = texter("Meteor Miner", "NameMeteorMiner");
    public static final String MeteorMinerRecipeType = texter("Meteor Miner", "MeteorMinerRecipeType");
    public static final String Tooltip_MeteorMiner_00 = texter(
        "To work properly the center of the meteor has to be 32 blocks above the highest block of the multi.",
        "Tooltip_MeteorMiner_00");
    public static final String Tooltip_MeteorMiner_01 = texter(
        "The laser will mine in a radius of up to 30 blocks in each direction from the center of the meteor.",
        "Tooltip_MeteorMiner_01");
    public static final String Tooltip_MeteorMiner_02 = texter(
        "All the chunks involved must be chunkloaded.",
        "Tooltip_MeteorMiner_02");
    public static final String Tooltip_MeteorMiner_03 = texter(
        "The laser will automatically set its radius based on the meteorite,",
        "Tooltip_MeteorMiner_03");
    public static final String Tooltip_MeteorMiner_04 = texter(
        "if it doesn't find any it will wait for a meteor to spawn, considering the block",
        "Tooltip_MeteorMiner_04");
    public static final String Tooltip_MeteorMiner_05 = texter(
        "right above the center of the meteor (like Warded Glass).",
        "Tooltip_MeteorMiner_05");
    public static final String Tooltip_MeteorMiner_06 = texter(
        "The reset button will restart the machine without optimizing the radius.",
        "Tooltip_MeteorMiner_06");
    public static final String Tooltip_MeteorMiner_07 = texter("§c§lTIER I", "Tooltip_MeteorMiner_07");
    public static final String Tooltip_MeteorMiner_08 = texter(
        "Mines one block every cycle.",
        "Tooltip_MeteorMiner_08");
    public static final String Tooltip_MeteorMiner_09 = texter(
        "Default Fortune is 0, it can be increased by putting in the input bus special pickaxes:",
        "Tooltip_MeteorMiner_09");
    public static final String Tooltip_MeteorMiner_10 = texter(
        "Fortune I: Pickaxe of the Core",
        "Tooltip_MeteorMiner_10");
    public static final String Tooltip_MeteorMiner_11 = texter("Fortune II: Bound Pickaxe", "Tooltip_MeteorMiner_11");
    public static final String Tooltip_MeteorMiner_12 = texter(
        "Fortune III: Terra Shatterer",
        "Tooltip_MeteorMiner_12");
    public static final String Tooltip_MeteorMiner_13 = texter("§c§lTIER II", "Tooltip_MeteorMiner_13");
    public static final String Tooltip_MeteorMiner_14 = texter("Always has Fortune III", "Tooltip_MeteorMiner_14");
    public static final String Tooltip_MeteorMiner_15 = texter("Mines one row every cycle", "Tooltip_MeteorMiner_15");
    public static final String Tooltip_MeteorMiner_16 = texter(
        "§9§lFinally some good Meteors!",
        "Tooltip_MeteorMiner_16");
    public static final String Tooltip_MeteorMiner_Casing_01_01 = texter(
        "Center of the second layer above the ritual",
        "Tooltip_MeteorMiner_Casing_01_01");
    public static final String Tooltip_MeteorMiner_Casing_01_02 = texter(
        "Any Structural Solar Casing around the controller",
        "Tooltip_MeteorMiner_Casing_01_02");
    public static final String Tooltip_MeteorMiner_Casing_01_03 = texter(
        "Below the controller",
        "Tooltip_MeteorMiner_Casing_01_03");
    public static final String Tooltip_MeteorMiner_Casing_02_01 = texter(
        "Highest layer of the ritual",
        "Tooltip_MeteorMiner_Casing_02_01");
    public static final String Tooltip_MeteorMiner_Casing_02_02 = texter(
        "Any Neutronium Casing below the controller",
        "Tooltip_MeteorMiner_Casing_02_02");

    public static final String NameComponentAssembler = texter("Component Assembler", "NameComponentAssembler");
    public static final String ComponentAssemblerRecipeType = texter(
        "High-Capacity Component Assembler",
        "ComponentAssemblerRecipeType");
    public static final String Tooltip_ComponentAssembler_00 = texter(
        "Assembles basic components (motors, pumps, etc.) in large batches",
        "Tooltip_ComponentAssembler_00");
    public static final String Tooltip_ComponentAssembler_01 = texter(
        "§eComponent Assembly Line Casing §rmax tier is UV",
        "Tooltip_ComponentAssembler_01");
    public static final String Tooltip_ComponentAssembler_02 = texter(
        "Overclocking is not supported",
        "Tooltip_ComponentAssembler_02");
    public static final String Tooltip_ComponentAssembler_03 = texter(
        "Up to 2 energy hatches at most!",
        "Tooltip_ComponentAssembler_03");
    public static final String Tooltip_ComponentAssembler_04 = texter(
        "Energy hatch limited by glass tier, UMV Glass unlocks all",
        "Tooltip_ComponentAssembler_04");
    public static final String Tooltip_ComponentAssembler_05 = texter(
        "§oMuch more efficient than other competing brands!",
        "Tooltip_ComponentAssembler_05");
    public static final String Tooltip_ComponentAssembler_Casing = texter(
        "Ang Solid Steel Machine Casing",
        "Tooltip_ComponentAssembler_Casing");

    public static final String NameLargeSteamFurnace = texter("Large Steam Furnace", "NameLargeSteamFurnace");
    public static final String LargeSteamFurnaceRecipeType = texter("Furnace", "LargeSteamFurnaceRecipeType");
    public static final String Tooltip_LargeSteamFurnace_00 = texter(
        "50%% faster than using single block steam machines of the same furnace",
        "Tooltip_LargeSteamFurnace_00");
    public static final String Tooltip_LargeSteamFurnace_01 = texter(
        "Only consumes steam at 50%% of the L/s normally required",
        "Tooltip_LargeSteamFurnace_01");
    public static final String Tooltip_LargeSteamFurnace_02 = texter(
        "Processes up to 32 items at once",
        "Tooltip_LargeSteamFurnace_02");
    public static final String Tooltip_LargeSteamFurnace_Casing = texter(
        "Ang Bronze Plated Bricks or Solid Steel Machine Casing",
        "Tooltip_LargeSteamFurnace_Casing");

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
