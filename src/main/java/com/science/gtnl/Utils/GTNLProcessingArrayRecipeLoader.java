package com.science.gtnl.Utils;

import gregtech.api.enums.SoundResource;
import gregtech.api.recipe.RecipeMaps;
import gtPlusPlus.api.recipe.GTPPRecipeMaps;

public class GTNLProcessingArrayRecipeLoader {

    public static void registerDefaultGregtechMaps() {

        // Alloy Smelter
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.alloysmelter", RecipeMaps.alloySmelterRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.alloysmelter", SoundResource.IC2_MACHINES_INDUCTION_LOOP);
        // Arc Furnace
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.arcfurnace", RecipeMaps.arcFurnaceRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.arcfurnace", SoundResource.IC2_MACHINES_INDUCTION_LOOP);
        // Assembler
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.assembler", RecipeMaps.assemblerRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.assembler", SoundResource.NONE);
        // Autoclave
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.autoclave", RecipeMaps.autoclaveRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.autoclave", SoundResource.NONE);
        // Bender
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.bender", RecipeMaps.benderRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.bender", SoundResource.IC2_MACHINES_COMPRESSOR_OP);
        // Boxinator
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.boxinator", RecipeMaps.packagerRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.boxinator", SoundResource.NONE);
        // Brewery
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.brewery", RecipeMaps.brewingRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.brewery", SoundResource.NONE);
        // Canner
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.canner", RecipeMaps.cannerRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.canner", SoundResource.IC2_MACHINES_EXTRACTOR_OP);
        // Centrifuge
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.centrifuge", GTPPRecipeMaps.centrifugeNonCellRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.centrifuge", SoundResource.NONE);
        // Chemical Bath
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.chemicalbath", RecipeMaps.chemicalBathRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.chemicalbath", SoundResource.NONE);
        // Chemical Reactor
        GTNLProcessingArrayManager
            .addRecipeMapToPA("basicmachine.chemicalreactor", RecipeMaps.multiblockChemicalReactorRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.chemicalreactor", SoundResource.IC2_MACHINES_EXTRACTOR_OP);
        // Circuit Assembler
        GTNLProcessingArrayManager
            .addRecipeMapToPA("basicmachine.circuitassembler", RecipeMaps.circuitAssemblerRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.circuitassembler", SoundResource.NONE);
        // Compressor
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.compressor", RecipeMaps.compressorRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.compressor", SoundResource.IC2_MACHINES_COMPRESSOR_OP);
        // Cutting Machine
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.cutter", RecipeMaps.cutterRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.cutter", SoundResource.NONE);
        // Distillery
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.distillery", RecipeMaps.distilleryRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.distillery", SoundResource.GT_MACHINES_DISTILLERY_LOOP);
        // Electrolyzer
        GTNLProcessingArrayManager
            .addRecipeMapToPA("basicmachine.electrolyzer", GTPPRecipeMaps.electrolyzerNonCellRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.electrolyzer", SoundResource.IC2_MACHINES_MAGNETIZER_LOOP);
        // Extractor
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.extractor", RecipeMaps.extractorRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.extractor", SoundResource.IC2_MACHINES_EXTRACTOR_OP);
        // Extruder
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.extruder", RecipeMaps.extruderRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.extruder", SoundResource.IC2_MACHINES_INDUCTION_LOOP);
        // Fermenter
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.fermenter", RecipeMaps.fermentingRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.fermenter", SoundResource.NONE);
        // Fluid Canner
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.fluidcanner", RecipeMaps.fluidCannerRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.fluidcanner", SoundResource.IC2_MACHINES_EXTRACTOR_OP);
        // Fluid Extractor
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.fluidextractor", RecipeMaps.fluidExtractionRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.fluidextractor", SoundResource.IC2_MACHINES_EXTRACTOR_OP);
        // Fluid Heater
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.fluidheater", RecipeMaps.fluidHeaterRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.fluidheater", SoundResource.NONE);
        // Fluid Solidifier
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.fluidsolidifier", RecipeMaps.fluidSolidifierRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.fluidsolidifier", SoundResource.NONE);
        // Forge Hammer
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.hammer", RecipeMaps.hammerRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.hammer", SoundResource.RANDOM_ANVIL_USE);
        // Forming Press
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.press", RecipeMaps.formingPressRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.press", SoundResource.IC2_MACHINES_COMPRESSOR_OP);
        // Laser Engraver
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.laserengraver", RecipeMaps.laserEngraverRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.laserengraver", SoundResource.IC2_MACHINES_MAGNETIZER_LOOP);
        // Lathe
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.lathe", RecipeMaps.latheRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.lathe", SoundResource.NONE);
        // Macerator
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.macerator", RecipeMaps.maceratorRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.macerator", SoundResource.IC2_MACHINES_MACERATOR_OP);
        // Magnetic Separator
        GTNLProcessingArrayManager
            .addRecipeMapToPA("basicmachine.electromagneticseparator", RecipeMaps.electroMagneticSeparatorRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.electromagneticseparator", SoundResource.IC2_MACHINES_MAGNETIZER_LOOP);
        // Matter Amplifier
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.amplifab", RecipeMaps.amplifierRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.amplifab", SoundResource.IC2_MACHINES_EXTRACTOR_OP);
        // Microwave
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.microwave", RecipeMaps.microwaveRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.microwave", SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP);
        // Mixer
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.mixer", GTPPRecipeMaps.mixerNonCellRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.mixer", SoundResource.NONE);
        // Ore Washer
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.orewasher", RecipeMaps.oreWasherRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.orewasher", SoundResource.NONE);
        // Plasma Arc Furnace
        GTNLProcessingArrayManager
            .addRecipeMapToPA("basicmachine.plasmaarcfurnace", RecipeMaps.plasmaArcFurnaceRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.plasmaarcfurnace", SoundResource.IC2_MACHINES_INDUCTION_LOOP);
        // Polarizer
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.polarizer", RecipeMaps.polarizerRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.polarizer", SoundResource.IC2_MACHINES_MAGNETIZER_LOOP);
        // Printer
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.printer", RecipeMaps.printerRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.printer", SoundResource.IC2_MACHINES_COMPRESSOR_OP);
        // Recycler
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.recycler", RecipeMaps.recyclerRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.recycler", SoundResource.IC2_MACHINES_RECYCLER_OP);
        // Scanner
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.scanner", RecipeMaps.scannerFakeRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.scanner", SoundResource.IC2_MACHINES_MAGNETIZER_LOOP);
        // Sifter
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.sifter", RecipeMaps.sifterRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.sifter", SoundResource.NONE);
        // Slicer
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.slicer", RecipeMaps.slicerRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.slicer", SoundResource.NONE);
        // Thermal Centrifuge
        GTNLProcessingArrayManager
            .addRecipeMapToPA("basicmachine.thermalcentrifuge", RecipeMaps.thermalCentrifugeRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.thermalcentrifuge", SoundResource.NONE);
        // Unboxinator
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.unboxinator", RecipeMaps.unpackagerRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.unboxinator", SoundResource.NONE);
        // Wiremill
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.wiremill", RecipeMaps.wiremillRecipes);
        GTNLProcessingArrayManager
            .addSoundResourceToPA("basicmachine.wiremill", SoundResource.IC2_MACHINES_RECYCLER_OP);
        // SimpleWasher
        GTNLProcessingArrayManager.addRecipeMapToPA("simplewasher.01", GTPPRecipeMaps.simpleWasherRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("simplewasher.01", SoundResource.NONE);
        // Mass Fabricator
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.massfab", RecipeMaps.massFabFakeRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.massfab", SoundResource.NONE);
        // Replicator
        GTNLProcessingArrayManager.addRecipeMapToPA("basicmachine.replicator", RecipeMaps.replicatorRecipes);
        GTNLProcessingArrayManager.addSoundResourceToPA("basicmachine.replicator", SoundResource.NONE);

    }
}
