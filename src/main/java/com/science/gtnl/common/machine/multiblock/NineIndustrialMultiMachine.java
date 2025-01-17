package com.science.gtnl.common.machine.multiblock;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.util.GTStructureUtility.buildHatchAdder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import bartworks.API.recipe.BartWorksRecipeMaps;
import goodgenerator.api.recipe.GoodGeneratorRecipeMaps;
import gregtech.api.enums.TAE;
import gregtech.api.gui.modularui.GTUITextures;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.*;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.util.*;
import gtPlusPlus.api.recipe.GTPPRecipeMaps;
import gtPlusPlus.core.block.ModBlocks;
import gtPlusPlus.core.util.minecraft.PlayerUtils;
import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.base.GTPPMultiBlockBase;
import gtPlusPlus.xmod.gregtech.common.blocks.textures.TexturesGtBlock;
import kubatech.loaders.DEFCRecipes;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import tectech.recipe.TecTechRecipeMaps;

public class NineIndustrialMultiMachine extends GTPPMultiBlockBase<NineIndustrialMultiMachine>
    implements ISurvivalConstructable {

    private int mHeatingCapacity = Integer.MAX_VALUE;

    private final static int MACHINEMODE_METAL = 0;
    private final static int MACHINEMODE_FLUID = 1;
    private final static int MACHINEMODE_MISC = 2;
    private final static int MACHINEMODE_MISC1 = 3;
    private final static int MACHINEMODE_MISC2 = 4;
    private final static int MACHINEMODE_MISC3 = 5;
    private final static int MACHINEMODE_MISC4 = 6;
    private final static int MACHINEMODE_MISC5 = 7;
    private final static int MACHINEMODE_MISC6 = 8;
    private final static int MACHINEMODE_MISC7 = 9;
    private final static int MACHINEMODE_MISC8 = 10;
    private final static int MACHINEMODE_MISC9 = 11;
    private final static int MACHINEMODE_MISC10 = 12;
    private final static int MACHINEMODE_MISC11 = 13;
    private final static int MACHINEMODE_MISC12 = 14;
    private final static int MACHINEMODE_MISC13 = 15;
    private final static int MACHINEMODE_MISC14 = 16;
    private final static int MACHINEMODE_MISC15 = 17;
    private final static int MACHINEMODE_MISC16 = 18;
    private final static int MACHINEMODE_MISC17 = 19;
    private final static int MACHINEMODE_MISC18 = 20;
    private final static int MACHINEMODE_MISC19 = 21;
    private final static int MACHINEMODE_MISC20 = 22;
    private final static int MACHINEMODE_MISC21 = 23;
    private final static int MACHINEMODE_MISC22 = 24;
    private final static int MACHINEMODE_MISC23 = 25;
    private final static int MACHINEMODE_MISC24 = 26;
    private final static int MACHINEMODE_MISC25 = 27;
    private final static int MACHINEMODE_MISC26 = 28;
    private final static int MACHINEMODE_MISC27 = 29;
    private final static int MACHINEMODE_MISC28 = 30;
    private final static int MACHINEMODE_MISC29 = 31;
    private final static int MACHINEMODE_MISC30 = 32;
    private final static int MACHINEMODE_MISC31 = 33;

    private static final int MODE_COMPRESSOR = 0;
    private static final int MODE_LATHE = 1;
    private static final int MODE_MAGNETIC = 2;
    private static final int MODE_FERMENTER = 3;
    private static final int MODE_FLUIDEXTRACT = 4;
    private static final int MODE_EXTRACTOR = 5;
    private static final int MODE_LASER = 6;
    private static final int MODE_AUTOCLAVE = 7;
    private static final int MODE_FLUIDSOLIDIFY = 8;
    private static final int MODE_OREWASHER = 9;
    private static final int MODE_THERMALCENTRIFUGE = 10;
    private static final int MODE_NEUTRONIUMCOMPRESSOR = 11;
    private static final int MODE_RECYCLER = 12;
    private static final int MODE_FURNACE = 13;
    private static final int MODE_MICROWAVE = 14;
    private static final int MODE_REPLICATOR = 15;
    private static final int MODE_PLASMAARCFURNACE = 16;
    private static final int MODE_ARCFURNACE = 17;
    private static final int MODE_PRINTER = 18;
    private static final int MODE_SIFTER = 19;
    private static final int MODE_FORMINGPRESS = 20;
    private static final int MODE_MACERATOR = 21;
    private static final int MODE_CHEMICALBATH = 22;
    private static final int MODE_FLUIDCANNER = 23;
    private static final int MODE_BREWING = 24;
    private static final int MODE_FLUIDHEATER = 25;
    private static final int MODE_DISTILLERY = 26;
    private static final int MODE_PACKAGER = 27;
    private static final int MODE_UNPACKAGER = 28;
    private static final int MODE_FUSION = 29;
    private static final int MODE_BLASTFURNACE = 30;
    private static final int MODE_PLASMAFORGE = 31;
    private static final int MODE_TRANSCENDENTPLASMAMIXER = 32;
    private static final int MODE_PRIMITIVEBLAST = 33;
    private static final int MODE_IMPLOSION = 34;
    private static final int MODE_VACUUMFREEZER = 35;
    private static final int MODE_MULTIBLOCKCHEMICALREACTOR = 36;
    private static final int MODE_DISTILLATIONTOWER = 37;
    private static final int MODE_CRACKING = 38;
    private static final int MODE_PYROLYSE = 39;
    private static final int MODE_WIREMILL = 40;
    private static final int MODE_BENDER = 41;
    private static final int MODE_ALLOYSMELTER = 42;
    private static final int MODE_ASSEMBLER = 43;
    private static final int MODE_CIRCUITASSEMBLER = 44;
    private static final int MODE_CUTTER = 45;
    private static final int MODE_SLICER = 46;
    private static final int MODE_EXTRUDER = 47;
    private static final int MODE_HAMMER = 48;
    private static final int MODE_AMPLIFIER = 49;
    private static final int MODE_EXTREMEDIESELFUELS = 50;
    private static final int MODE_HOTFUELS = 51;
    private static final int MODE_DENSELIQUIDFUELS = 52;
    private static final int MODE_PLASMAFUELS = 53;
    private static final int MODE_MAGICFUELS = 54;
    private static final int MODE_SMALLNAQUADAHREACTORFUELS = 55;
    private static final int MODE_LARGENAQUADAHREACTORFUELS = 56;
    private static final int MODE_HUGENAQUADAHREACTORFUELS = 57;
    private static final int MODE_EXTREMENAQUADAHREACTORFUELS = 58;
    private static final int MODE_ULTRAHUGENAQUADAHREACTORFUELS = 59;
    private static final int MODE_NANOFORGE = 60;
    private static final int MODE_PCBFACTORY = 61;
    private static final int MODE_COKEOVEN = 62;
    private static final int MODE_ROCKETFUELS = 63;
    private static final int MODE_QUANTUMFORCETRANSFORMER = 64;
    private static final int MODE_VACUUMFURNACE = 65;
    private static final int MODE_ALLOYBLASTSMELTER = 66;
    private static final int MODE_LIQUIDFLUORINETHORIUMREACTOR = 67;
    private static final int MODE_NUCLEARSALTPROCESSINGPLANT = 68;
    private static final int MODE_MILLING = 69;
    private static final int MODE_FISSIONFUELPROCESSING = 70;
    private static final int MODE_COLDTRAP = 71;
    private static final int MODE_REACTORPROCESSINGUNIT = 72;
    private static final int MODE_SIMPLEWASHER = 73;
    private static final int MODE_MOLECULARTRANSFORMER = 74;
    private static final int MODE_CHEMICALPLANT = 75;
    private static final int MODE_RTG = 76;
    private static final int MODE_THERMALBOILER = 77;
    private static final int MODE_SOLARTOWER = 78;
    private static final int MODE_CYCLOTRON = 79;
    private static final int MODE_FISHPOND = 80;
    private static final int MODE_CENTRIFUGENONCELL = 81;
    private static final int MODE_ELECTROLYZERNONCELL = 82;
    private static final int MODE_MIXERNONCELL = 83;
    private static final int MODE_CHEMICALDEHYDRATORNONCELL = 84;
    private static final int MODE_SEMIFLUIDFUELS = 85;
    private static final int MODE_FLOTATIONCELL = 86;
    private static final int MODE_EYEOFHARMONY = 87;
    private static final int MODE_GODFORGEPLASMA = 88;
    private static final int MODE_GODFORGEEXOTICMATTER = 89;
    private static final int MODE_GODFORGEMOLTEN = 90;
    private static final int MODE_GODFORGEFAKEUPGRADECOST = 91;
    private static final int MODE_FUSIONCRAFTING = 92;
    private static final int MODE_BIOLAB = 93;
    private static final int MODE_BACTERIALVAT = 94;
    private static final int MODE_ACIDGENFUELS = 95;
    private static final int MODE_CIRCUITASSEMBLYLINE = 96;
    private static final int MODE_ELECTRICIMPLOSIONCOMPRESSOR = 97;
    private static final int MODE_COMPONENTASSEMBLYLINERECIPES = 98;

    private static final int[][] MODE_MAP = new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 9, 10, 11 },
        { 12, 13, 14 }, { 15, 16, 17 }, { 18, 19, 20 }, { 21, 22, 23 }, { 24, 25, 26 }, { 27, 28, 29 }, { 30, 31, 32 },
        { 33, 34, 35 }, { 36, 37, 38 }, { 39, 40, 41 }, { 42, 43, 44 }, { 45, 46, 47 }, { 48, 49, 50 }, { 51, 52, 53 },
        { 54, 55, 56 }, { 57, 58, 59 }, { 60, 61, 62 }, { 63, 64, 65 }, { 66, 67, 68 }, { 69, 70, 71 }, { 72, 73, 74 },
        { 75, 76, 77 }, { 78, 79, 80 }, { 81, 82, 83 }, { 84, 85, 86 }, { 87, 88, 89 }, { 90, 91, 92 }, { 93, 94, 95 },
        { 96, 97, 98 } };

    public static final String[] aToolTipNames = new String[98];
    private int mCasing;
    private static IStructureDefinition<NineIndustrialMultiMachine> STRUCTURE_DEFINITION = null;

    static {
        for (int id = 0; id < 98; id++) {
            RecipeMap<?> recipeMap = getRecipeMap(id);
            if (recipeMap != null) {
                String aNEI = GTLanguageManager.getTranslation(getRecipeMap(id).unlocalizedName);
                aToolTipNames[id] = aNEI != null ? aNEI : "BAD NEI NAME (Report to Github)";
            }
        }
    }

    public NineIndustrialMultiMachine(final int aID, final String aName, final String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public NineIndustrialMultiMachine(final String aName) {
        super(aName);
    }

    @Override
    public IMetaTileEntity newMetaEntity(final IGregTechTileEntity aTileEntity) {
        return new NineIndustrialMultiMachine(this.mName);
    }

    @Override
    public String getMachineType() {
        return "Mine in One";
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        String[] aBuiltStrings = new String[33];
        for (int i = 0; i < 33; i++) {
            // 检查数组是否越界
            if (i * 3 + 2 < aToolTipNames.length) {
                aBuiltStrings[i] = aToolTipNames[i * 3] + ", "
                    + aToolTipNames[i * 3 + 1]
                    + ", "
                    + aToolTipNames[i * 3 + 2];
            } else {
                aBuiltStrings[i] = "Invalid tooltip names configuration";
            }
        }

        MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType(getMachineType())
            .addInfo("250% faster than using single block machines of the same voltage")
            .addInfo("Only uses 80% of the EU/t normally required")
            .addInfo("Processes two items per voltage tier")
            .addInfo(
                "Machine Type: Metal - " + EnumChatFormatting.YELLOW
                    + aToolTipNames[0]
                    + ", "
                    + aToolTipNames[1]
                    + ", "
                    + aToolTipNames[2]
                    + EnumChatFormatting.RESET)
            .addInfo(
                "Machine Type: Fluid - " + EnumChatFormatting.YELLOW
                    + aToolTipNames[3]
                    + ", "
                    + aToolTipNames[4]
                    + ", "
                    + aToolTipNames[5]
                    + EnumChatFormatting.RESET);

        for (int i = 2; i < 33; i++) {
            tt.addInfo(
                "Machine Type: Misc" + (i - 2)
                    + " - "
                    + EnumChatFormatting.YELLOW
                    + aBuiltStrings[i]
                    + EnumChatFormatting.RESET);
        }

        tt.addInfo("Read Multi-Machine Manual for extra information")
            .addInfo(
                EnumChatFormatting.AQUA + "You can use Solidifier Hatch to solidify multiple liquids."
                    + EnumChatFormatting.RESET)
            .addPollutionAmount(getPollutionPerSecond(null))
            .beginStructureBlock(3, 3, 3, true)
            .addController("Front Center")
            .addCasingInfoMin("Multi-Use Casings", 6, false)
            .addInputBus("Any Casing", 1)
            .addOutputBus("Any Casing", 1)
            .addInputHatch("Any Casing", 1)
            .addOutputHatch("Any Casing", 1)
            .addEnergyHatch("Any Casing", 1)
            .addMaintenanceHatch("Any Casing", 1)
            .addMufflerHatch("Any Casing", 1)
            .toolTipFinisher();
        return tt;
    }

    @Override
    public IStructureDefinition<NineIndustrialMultiMachine> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<NineIndustrialMultiMachine>builder()
                .addShape(
                    mName,
                    transpose(
                        new String[][] { { "CCC", "CCC", "CCC" }, { "C~C", "C-C", "CCC" }, { "CCC", "CCC", "CCC" }, }))
                .addElement(
                    'C',
                    buildHatchAdder(NineIndustrialMultiMachine.class)
                        .atLeast(InputBus, OutputBus, Maintenance, Energy, Muffler, InputHatch, OutputHatch)
                        .casingIndex(getTextureIndex())
                        .dot(1)
                        .buildAndChain(onElementPass(x -> ++x.mCasing, ofBlock(ModBlocks.blockCasings3Misc, 2))))
                .build();
        }
        return STRUCTURE_DEFINITION;
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(mName, stackSize, hintsOnly, 1, 1, 0);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        return survivialBuildPiece(mName, stackSize, 1, 1, 0, elementBudget, env, false, true);
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        mCasing = 0;
        mHardHammer = true;
        mSoftHammer = true;
        mScrewdriver = true;
        mCrowbar = true;
        mSolderingTool = true;
        mWrench = true;

        this.mHeatingCapacity = Integer.MAX_VALUE;
        return checkPiece(mName, 1, 1, 0) && mCasing >= 6 && checkHatch();
    }

    @Override
    protected IIconContainer getActiveOverlay() {
        return TexturesGtBlock.oMCAIndustrialMultiMachineActive;
    }

    @Override
    protected IIconContainer getInactiveOverlay() {
        return TexturesGtBlock.oMCAIndustrialMultiMachine;
    }

    @Override
    protected int getCasingTextureId() {
        return getTextureIndex();
    }

    @Override
    public int getMaxParallelRecipes() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getMaxEfficiency(final ItemStack aStack) {
        return 10000;
    }

    public int getTextureIndex() {
        return TAE.getIndexFromPage(2, 2);
    }

    private ItemStack getCircuit(ItemStack[] t) {
        for (ItemStack j : t) {
            if (j.getItem() == GTUtility.getIntegratedCircuit(0)
                .getItem()) {
                if (j.getItemDamage() >= 20 && j.getItemDamage() <= 22) {
                    return j;
                }
            }
        }
        return null;
    }

    private int getCircuitID(ItemStack circuit) {
        int H = circuit.getItemDamage();
        int T = (H == 20 ? 0 : (H == 21 ? 1 : (H == 22 ? 2 : -1)));
        return MODE_MAP[machineMode][T];
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return null;
    }

    @Nonnull
    @Override
    public Collection<RecipeMap<?>> getAvailableRecipeMaps() {
        return Arrays.asList(
            RecipeMaps.compressorRecipes,
            RecipeMaps.latheRecipes,
            RecipeMaps.polarizerRecipes,
            RecipeMaps.fermentingRecipes,
            RecipeMaps.fluidExtractionRecipes,
            RecipeMaps.extractorRecipes,
            RecipeMaps.laserEngraverRecipes,
            RecipeMaps.autoclaveRecipes,
            RecipeMaps.fluidSolidifierRecipes,
            RecipeMaps.oreWasherRecipes,
            RecipeMaps.thermalCentrifugeRecipes,
            RecipeMaps.neutroniumCompressorRecipes,
            RecipeMaps.recyclerRecipes,
            RecipeMaps.furnaceRecipes,
            RecipeMaps.microwaveRecipes,
            RecipeMaps.replicatorRecipes,
            RecipeMaps.plasmaArcFurnaceRecipes,
            RecipeMaps.arcFurnaceRecipes,
            RecipeMaps.printerRecipes,
            RecipeMaps.sifterRecipes,
            RecipeMaps.formingPressRecipes,
            RecipeMaps.maceratorRecipes,
            RecipeMaps.chemicalBathRecipes,
            RecipeMaps.fluidCannerRecipes,
            RecipeMaps.brewingRecipes,
            RecipeMaps.fluidHeaterRecipes,
            RecipeMaps.distilleryRecipes,
            RecipeMaps.packagerRecipes,
            RecipeMaps.unpackagerRecipes,
            RecipeMaps.fusionRecipes,
            RecipeMaps.blastFurnaceRecipes,
            RecipeMaps.plasmaForgeRecipes,
            RecipeMaps.transcendentPlasmaMixerRecipes,
            RecipeMaps.primitiveBlastRecipes,
            RecipeMaps.implosionRecipes,
            RecipeMaps.vacuumFreezerRecipes,
            RecipeMaps.multiblockChemicalReactorRecipes,
            RecipeMaps.distillationTowerRecipes,
            RecipeMaps.crackingRecipes,
            RecipeMaps.pyrolyseRecipes,
            RecipeMaps.wiremillRecipes,
            RecipeMaps.benderRecipes,
            RecipeMaps.alloySmelterRecipes,
            RecipeMaps.assemblerRecipes,
            RecipeMaps.circuitAssemblerRecipes,
            RecipeMaps.cutterRecipes,
            RecipeMaps.slicerRecipes,
            RecipeMaps.extruderRecipes,
            RecipeMaps.hammerRecipes,
            RecipeMaps.amplifierRecipes,
            RecipeMaps.extremeDieselFuels,
            RecipeMaps.hotFuels,
            RecipeMaps.denseLiquidFuels,
            RecipeMaps.plasmaFuels,
            RecipeMaps.magicFuels,
            RecipeMaps.smallNaquadahReactorFuels,
            RecipeMaps.largeNaquadahReactorFuels,
            RecipeMaps.hugeNaquadahReactorFuels,
            RecipeMaps.extremeNaquadahReactorFuels,
            RecipeMaps.ultraHugeNaquadahReactorFuels,
            RecipeMaps.nanoForgeRecipes,
            RecipeMaps.pcbFactoryRecipes,
            GTPPRecipeMaps.cokeOvenRecipes,
            GTPPRecipeMaps.rocketFuels,
            GTPPRecipeMaps.quantumForceTransformerRecipes,
            GTPPRecipeMaps.vacuumFurnaceRecipes,
            GTPPRecipeMaps.alloyBlastSmelterRecipes,
            GTPPRecipeMaps.liquidFluorineThoriumReactorRecipes,
            GTPPRecipeMaps.nuclearSaltProcessingPlantRecipes,
            GTPPRecipeMaps.millingRecipes,
            GTPPRecipeMaps.fissionFuelProcessingRecipes,
            GTPPRecipeMaps.coldTrapRecipes,
            GTPPRecipeMaps.reactorProcessingUnitRecipes,
            GTPPRecipeMaps.simpleWasherRecipes,
            GTPPRecipeMaps.molecularTransformerRecipes,
            GTPPRecipeMaps.chemicalPlantRecipes,
            GTPPRecipeMaps.rtgFuels,
            GTPPRecipeMaps.thermalBoilerRecipes,
            GTPPRecipeMaps.solarTowerRecipes,
            GTPPRecipeMaps.cyclotronRecipes,
            GTPPRecipeMaps.fishPondRecipes,
            GTPPRecipeMaps.centrifugeNonCellRecipes,
            GTPPRecipeMaps.electrolyzerNonCellRecipes,
            GTPPRecipeMaps.mixerNonCellRecipes,
            GTPPRecipeMaps.chemicalDehydratorNonCellRecipes,
            GTPPRecipeMaps.semiFluidFuels,
            GTPPRecipeMaps.flotationCellRecipes,
            TecTechRecipeMaps.eyeOfHarmonyRecipes,
            TecTechRecipeMaps.godforgePlasmaRecipes,
            TecTechRecipeMaps.godforgeExoticMatterRecipes,
            TecTechRecipeMaps.godforgeMoltenRecipes,
            TecTechRecipeMaps.godforgeFakeUpgradeCostRecipes,
            DEFCRecipes.fusionCraftingRecipes,
            BartWorksRecipeMaps.bioLabRecipes,
            BartWorksRecipeMaps.bacterialVatRecipes,
            BartWorksRecipeMaps.acidGenFuels,
            BartWorksRecipeMaps.circuitAssemblyLineRecipes,
            BartWorksRecipeMaps.electricImplosionCompressorRecipes,
            GoodGeneratorRecipeMaps.componentAssemblyLineRecipes);
    }

    private static RecipeMap<?> getRecipeMap(int aMode) {
        return switch (aMode) {
            case MODE_COMPRESSOR -> RecipeMaps.compressorRecipes;
            case MODE_LATHE -> RecipeMaps.latheRecipes;
            case MODE_MAGNETIC -> RecipeMaps.polarizerRecipes;
            case MODE_FERMENTER -> RecipeMaps.fermentingRecipes;
            case MODE_FLUIDEXTRACT -> RecipeMaps.fluidExtractionRecipes;
            case MODE_EXTRACTOR -> RecipeMaps.extractorRecipes;
            case MODE_LASER -> RecipeMaps.laserEngraverRecipes;
            case MODE_AUTOCLAVE -> RecipeMaps.autoclaveRecipes;
            case MODE_FLUIDSOLIDIFY -> RecipeMaps.fluidSolidifierRecipes;
            case MODE_OREWASHER -> RecipeMaps.oreWasherRecipes;
            case MODE_THERMALCENTRIFUGE -> RecipeMaps.thermalCentrifugeRecipes;
            case MODE_NEUTRONIUMCOMPRESSOR -> RecipeMaps.neutroniumCompressorRecipes;
            case MODE_RECYCLER -> RecipeMaps.recyclerRecipes;
            case MODE_FURNACE -> RecipeMaps.furnaceRecipes;
            case MODE_MICROWAVE -> RecipeMaps.microwaveRecipes;
            case MODE_REPLICATOR -> RecipeMaps.replicatorRecipes;
            case MODE_PLASMAARCFURNACE -> RecipeMaps.plasmaArcFurnaceRecipes;
            case MODE_ARCFURNACE -> RecipeMaps.arcFurnaceRecipes;
            case MODE_PRINTER -> RecipeMaps.printerRecipes;
            case MODE_SIFTER -> RecipeMaps.sifterRecipes;
            case MODE_FORMINGPRESS -> RecipeMaps.formingPressRecipes;
            case MODE_MACERATOR -> RecipeMaps.maceratorRecipes;
            case MODE_CHEMICALBATH -> RecipeMaps.chemicalBathRecipes;
            case MODE_FLUIDCANNER -> RecipeMaps.fluidCannerRecipes;
            case MODE_BREWING -> RecipeMaps.brewingRecipes;
            case MODE_FLUIDHEATER -> RecipeMaps.fluidHeaterRecipes;
            case MODE_DISTILLERY -> RecipeMaps.distilleryRecipes;
            case MODE_PACKAGER -> RecipeMaps.packagerRecipes;
            case MODE_UNPACKAGER -> RecipeMaps.unpackagerRecipes;
            case MODE_FUSION -> RecipeMaps.fusionRecipes;
            case MODE_BLASTFURNACE -> RecipeMaps.blastFurnaceRecipes;
            case MODE_PLASMAFORGE -> RecipeMaps.plasmaForgeRecipes;
            case MODE_TRANSCENDENTPLASMAMIXER -> RecipeMaps.transcendentPlasmaMixerRecipes;
            case MODE_PRIMITIVEBLAST -> RecipeMaps.primitiveBlastRecipes;
            case MODE_IMPLOSION -> RecipeMaps.implosionRecipes;
            case MODE_VACUUMFREEZER -> RecipeMaps.vacuumFreezerRecipes;
            case MODE_MULTIBLOCKCHEMICALREACTOR -> RecipeMaps.multiblockChemicalReactorRecipes;
            case MODE_DISTILLATIONTOWER -> RecipeMaps.distillationTowerRecipes;
            case MODE_CRACKING -> RecipeMaps.crackingRecipes;
            case MODE_PYROLYSE -> RecipeMaps.pyrolyseRecipes;
            case MODE_WIREMILL -> RecipeMaps.wiremillRecipes;
            case MODE_BENDER -> RecipeMaps.benderRecipes;
            case MODE_ALLOYSMELTER -> RecipeMaps.alloySmelterRecipes;
            case MODE_ASSEMBLER -> RecipeMaps.assemblerRecipes;
            case MODE_CIRCUITASSEMBLER -> RecipeMaps.circuitAssemblerRecipes;
            case MODE_CUTTER -> RecipeMaps.cutterRecipes;
            case MODE_SLICER -> RecipeMaps.slicerRecipes;
            case MODE_EXTRUDER -> RecipeMaps.extruderRecipes;
            case MODE_HAMMER -> RecipeMaps.hammerRecipes;
            case MODE_AMPLIFIER -> RecipeMaps.amplifierRecipes;
            case MODE_EXTREMEDIESELFUELS -> RecipeMaps.extremeDieselFuels;
            case MODE_HOTFUELS -> RecipeMaps.hotFuels;
            case MODE_DENSELIQUIDFUELS -> RecipeMaps.denseLiquidFuels;
            case MODE_PLASMAFUELS -> RecipeMaps.plasmaFuels;
            case MODE_MAGICFUELS -> RecipeMaps.magicFuels;
            case MODE_SMALLNAQUADAHREACTORFUELS -> RecipeMaps.smallNaquadahReactorFuels;
            case MODE_LARGENAQUADAHREACTORFUELS -> RecipeMaps.largeNaquadahReactorFuels;
            case MODE_HUGENAQUADAHREACTORFUELS -> RecipeMaps.hugeNaquadahReactorFuels;
            case MODE_EXTREMENAQUADAHREACTORFUELS -> RecipeMaps.extremeNaquadahReactorFuels;
            case MODE_ULTRAHUGENAQUADAHREACTORFUELS -> RecipeMaps.ultraHugeNaquadahReactorFuels;
            case MODE_NANOFORGE -> RecipeMaps.nanoForgeRecipes;
            case MODE_PCBFACTORY -> RecipeMaps.pcbFactoryRecipes;
            case MODE_COKEOVEN -> GTPPRecipeMaps.cokeOvenRecipes;
            case MODE_ROCKETFUELS -> GTPPRecipeMaps.rocketFuels;
            case MODE_QUANTUMFORCETRANSFORMER -> GTPPRecipeMaps.quantumForceTransformerRecipes;
            case MODE_VACUUMFURNACE -> GTPPRecipeMaps.vacuumFurnaceRecipes;
            case MODE_ALLOYBLASTSMELTER -> GTPPRecipeMaps.alloyBlastSmelterRecipes;
            case MODE_LIQUIDFLUORINETHORIUMREACTOR -> GTPPRecipeMaps.liquidFluorineThoriumReactorRecipes;
            case MODE_NUCLEARSALTPROCESSINGPLANT -> GTPPRecipeMaps.nuclearSaltProcessingPlantRecipes;
            case MODE_MILLING -> GTPPRecipeMaps.millingRecipes;
            case MODE_FISSIONFUELPROCESSING -> GTPPRecipeMaps.fissionFuelProcessingRecipes;
            case MODE_COLDTRAP -> GTPPRecipeMaps.coldTrapRecipes;
            case MODE_REACTORPROCESSINGUNIT -> GTPPRecipeMaps.reactorProcessingUnitRecipes;
            case MODE_SIMPLEWASHER -> GTPPRecipeMaps.simpleWasherRecipes;
            case MODE_MOLECULARTRANSFORMER -> GTPPRecipeMaps.molecularTransformerRecipes;
            case MODE_CHEMICALPLANT -> GTPPRecipeMaps.chemicalPlantRecipes;
            case MODE_RTG -> GTPPRecipeMaps.rtgFuels;
            case MODE_THERMALBOILER -> GTPPRecipeMaps.thermalBoilerRecipes;
            case MODE_SOLARTOWER -> GTPPRecipeMaps.solarTowerRecipes;
            case MODE_CYCLOTRON -> GTPPRecipeMaps.cyclotronRecipes;
            case MODE_FISHPOND -> GTPPRecipeMaps.fishPondRecipes;
            case MODE_CENTRIFUGENONCELL -> GTPPRecipeMaps.centrifugeNonCellRecipes;
            case MODE_ELECTROLYZERNONCELL -> GTPPRecipeMaps.electrolyzerNonCellRecipes;
            case MODE_MIXERNONCELL -> GTPPRecipeMaps.mixerNonCellRecipes;
            case MODE_CHEMICALDEHYDRATORNONCELL -> GTPPRecipeMaps.chemicalDehydratorNonCellRecipes;
            case MODE_SEMIFLUIDFUELS -> GTPPRecipeMaps.semiFluidFuels;
            case MODE_FLOTATIONCELL -> GTPPRecipeMaps.flotationCellRecipes;
            case MODE_EYEOFHARMONY -> TecTechRecipeMaps.eyeOfHarmonyRecipes;
            case MODE_GODFORGEPLASMA -> TecTechRecipeMaps.godforgePlasmaRecipes;
            case MODE_GODFORGEEXOTICMATTER -> TecTechRecipeMaps.godforgeExoticMatterRecipes;
            case MODE_GODFORGEMOLTEN -> TecTechRecipeMaps.godforgeMoltenRecipes;
            case MODE_GODFORGEFAKEUPGRADECOST -> TecTechRecipeMaps.godforgeFakeUpgradeCostRecipes;
            case MODE_FUSIONCRAFTING -> DEFCRecipes.fusionCraftingRecipes;
            case MODE_BIOLAB -> BartWorksRecipeMaps.bioLabRecipes;
            case MODE_BACTERIALVAT -> BartWorksRecipeMaps.bacterialVatRecipes;
            case MODE_ACIDGENFUELS -> BartWorksRecipeMaps.acidGenFuels;
            case MODE_CIRCUITASSEMBLYLINE -> BartWorksRecipeMaps.circuitAssemblyLineRecipes;
            case MODE_ELECTRICIMPLOSIONCOMPRESSOR -> BartWorksRecipeMaps.electricImplosionCompressorRecipes;
            case MODE_COMPONENTASSEMBLYLINERECIPES -> GoodGeneratorRecipeMaps.componentAssemblyLineRecipes;
            default -> null;
        };
    }

    @Override
    protected ProcessingLogic createProcessingLogic() {
        return new ProcessingLogic() {

            private ItemStack lastCircuit = null;
            private int lastMode = -1;

            @Nonnull
            @Override
            protected Stream<GTRecipe> findRecipeMatches(@Nullable RecipeMap<?> map) {
                ItemStack circuit = getCircuit(inputItems);
                if (circuit == null) {
                    return Stream.empty();
                }
                if (!GTUtility.areStacksEqual(circuit, lastCircuit)) {
                    lastRecipe = null;
                    lastCircuit = circuit;
                }
                if (machineMode != lastMode) {
                    lastRecipe = null;
                    lastMode = machineMode;
                }
                RecipeMap<?> foundMap = getRecipeMap(getCircuitID(circuit));
                if (foundMap == null) {
                    return Stream.empty();
                }
                return super.findRecipeMatches(foundMap);
            }

            @Nonnull
            @Override
            protected ParallelHelper createParallelHelper(@Nonnull GTRecipe recipe) {
                return new ParallelHelper().setRecipe(recipe)
                    .setItemInputs(inputItems)
                    .setFluidInputs(inputFluids)
                    .setAvailableEUt(Integer.MAX_VALUE)
                    .setMachine(machine, protectItems, protectFluids)
                    .setRecipeLocked(recipeLockableMachine, isRecipeLocked)
                    .setMaxParallel(Integer.MAX_VALUE)
                    .setEUtModifier(0)
                    .enableBatchMode(batchSize)
                    .setConsumption(true)
                    .setOutputCalculation(true);
            }

            @Nonnull
            @Override
            protected OverclockCalculator createOverclockCalculator(@Nonnull GTRecipe recipe) {
                return super.createOverclockCalculator(recipe).setRecipeHeat(recipe.mSpecialValue)
                    .setMachineHeat(mHeatingCapacity)
                    .setHeatDiscount(true);
            }

            @Override
            protected double calculateDuration(@Nonnull GTRecipe recipe, @Nonnull ParallelHelper helper,
                @Nonnull OverclockCalculator calculator) {
                return 10;
            }

            @NotNull
            @Override
            protected CheckRecipeResult validateRecipe(@NotNull GTRecipe recipe) {
                return CheckRecipeResultRegistry.SUCCESSFUL;
            }

        };
    }

    @Override
    public boolean drainEnergyInput(long aEUt) {
        return true;
    }

    @Override
    public long maxEUStore() {
        return Integer.MAX_VALUE;
    }

    @Override
    public String getMachineModeName() {
        return StatCollector.translateToLocal("GT5U.GTPP_MULTI_INDUSTRIAL_MULTI_MACHINE.mode." + machineMode);
    }

    @Override
    public String[] getInfoData() {
        String[] data = super.getInfoData();
        ArrayList<String> mInfo = new ArrayList<>(Arrays.asList(data));
        String mode;
        switch (machineMode) {
            case MACHINEMODE_METAL -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.metal");
            case MACHINEMODE_FLUID -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.fluid");
            case MACHINEMODE_MISC -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc");
            case MACHINEMODE_MISC1 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc1");
            case MACHINEMODE_MISC2 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc2");
            case MACHINEMODE_MISC3 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc3");
            case MACHINEMODE_MISC4 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc4");
            case MACHINEMODE_MISC5 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc5");
            case MACHINEMODE_MISC6 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc6");
            case MACHINEMODE_MISC7 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc7");
            case MACHINEMODE_MISC8 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc8");
            case MACHINEMODE_MISC9 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc9");
            case MACHINEMODE_MISC10 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc10");
            case MACHINEMODE_MISC11 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc11");
            case MACHINEMODE_MISC12 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc12");
            case MACHINEMODE_MISC13 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc13");
            case MACHINEMODE_MISC14 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc14");
            case MACHINEMODE_MISC15 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc15");
            case MACHINEMODE_MISC16 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc16");
            case MACHINEMODE_MISC17 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc17");
            case MACHINEMODE_MISC18 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc18");
            case MACHINEMODE_MISC19 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc19");
            case MACHINEMODE_MISC20 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc20");
            case MACHINEMODE_MISC21 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc21");
            case MACHINEMODE_MISC22 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc22");
            case MACHINEMODE_MISC23 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc23");
            case MACHINEMODE_MISC24 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc24");
            case MACHINEMODE_MISC25 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc25");
            case MACHINEMODE_MISC26 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc26");
            case MACHINEMODE_MISC27 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc27");
            case MACHINEMODE_MISC28 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc28");
            case MACHINEMODE_MISC29 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc29");
            case MACHINEMODE_MISC30 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc30");
            case MACHINEMODE_MISC31 -> mode = StatCollector.translateToLocal("GTPP.multiblock.multimachine.misc31");
            default -> mode = "";
        }
        mInfo.add(mode);
        return mInfo.toArray(new String[0]);
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        if (aNBT.hasKey("mInternalMode")) {
            machineMode = aNBT.getInteger("mInternalMode");
        }
        super.loadNBTData(aNBT);
    }

    @Override
    public void getWailaNBTData(EntityPlayerMP player, TileEntity tile, NBTTagCompound tag, World world, int x, int y,
        int z) {
        super.getWailaNBTData(player, tile, tag, world, x, y, z);
        tag.setInteger("mode", machineMode);
    }

    @Override
    public void getWailaBody(ItemStack itemStack, List<String> currentTip, IWailaDataAccessor accessor,
        IWailaConfigHandler config) {
        super.getWailaBody(itemStack, currentTip, accessor, config);
        final NBTTagCompound tag = accessor.getNBTData();
        if (tag.hasKey("mode")) {
            currentTip.add(
                StatCollector.translateToLocal("GT5U.machines.oreprocessor1") + " "
                    + EnumChatFormatting.WHITE
                    + StatCollector
                        .translateToLocal("GT5U.GTPP_MULTI_INDUSTRIAL_MULTI_MACHINE.mode." + tag.getInteger("mode"))
                    + EnumChatFormatting.RESET);
        }
    }

    @Override
    public boolean supportsMachineModeSwitch() {
        return true;
    }

    @Override
    public void onModeChangeByScrewdriver(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ) {
        setMachineMode(nextMachineMode());
        PlayerUtils.messagePlayer(
            aPlayer,
            String.format(StatCollector.translateToLocal("GT5U.MULTI_MACHINE_CHANGE"), getMachineModeName()));
    }

    @Override
    public int nextMachineMode() {
        mLastRecipe = null;
        if (machineMode == MACHINEMODE_METAL) return MACHINEMODE_FLUID;
        else if (machineMode == MACHINEMODE_FLUID) return MACHINEMODE_MISC;
        else if (machineMode == MACHINEMODE_MISC) return MACHINEMODE_MISC1;
        else if (machineMode == MACHINEMODE_MISC1) return MACHINEMODE_MISC2;
        else if (machineMode == MACHINEMODE_MISC2) return MACHINEMODE_MISC3;
        else if (machineMode == MACHINEMODE_MISC3) return MACHINEMODE_MISC4;
        else if (machineMode == MACHINEMODE_MISC4) return MACHINEMODE_MISC5;
        else if (machineMode == MACHINEMODE_MISC5) return MACHINEMODE_MISC6;
        else if (machineMode == MACHINEMODE_MISC6) return MACHINEMODE_MISC7;
        else if (machineMode == MACHINEMODE_MISC7) return MACHINEMODE_MISC8;
        else if (machineMode == MACHINEMODE_MISC8) return MACHINEMODE_MISC9;
        else if (machineMode == MACHINEMODE_MISC9) return MACHINEMODE_MISC10;
        else if (machineMode == MACHINEMODE_MISC10) return MACHINEMODE_MISC11;
        else if (machineMode == MACHINEMODE_MISC11) return MACHINEMODE_MISC12;
        else if (machineMode == MACHINEMODE_MISC12) return MACHINEMODE_MISC13;
        else if (machineMode == MACHINEMODE_MISC13) return MACHINEMODE_MISC14;
        else if (machineMode == MACHINEMODE_MISC14) return MACHINEMODE_MISC15;
        else if (machineMode == MACHINEMODE_MISC15) return MACHINEMODE_MISC16;
        else if (machineMode == MACHINEMODE_MISC16) return MACHINEMODE_MISC17;
        else if (machineMode == MACHINEMODE_MISC17) return MACHINEMODE_MISC18;
        else if (machineMode == MACHINEMODE_MISC18) return MACHINEMODE_MISC19;
        else if (machineMode == MACHINEMODE_MISC19) return MACHINEMODE_MISC20;
        else if (machineMode == MACHINEMODE_MISC20) return MACHINEMODE_MISC21;
        else if (machineMode == MACHINEMODE_MISC21) return MACHINEMODE_MISC22;
        else if (machineMode == MACHINEMODE_MISC22) return MACHINEMODE_MISC23;
        else if (machineMode == MACHINEMODE_MISC23) return MACHINEMODE_MISC24;
        else if (machineMode == MACHINEMODE_MISC24) return MACHINEMODE_MISC25;
        else if (machineMode == MACHINEMODE_MISC25) return MACHINEMODE_MISC26;
        else if (machineMode == MACHINEMODE_MISC26) return MACHINEMODE_MISC27;
        else if (machineMode == MACHINEMODE_MISC27) return MACHINEMODE_MISC28;
        else if (machineMode == MACHINEMODE_MISC28) return MACHINEMODE_MISC29;
        else if (machineMode == MACHINEMODE_MISC29) return MACHINEMODE_MISC30;
        else if (machineMode == MACHINEMODE_MISC30) return MACHINEMODE_MISC31;
        else return MACHINEMODE_METAL;
    }

    @Override
    public void setMachineModeIcons() {
        machineModeIcons.clear();
        machineModeIcons.add(GTUITextures.OVERLAY_BUTTON_MACHINEMODE_LPF_METAL);
        machineModeIcons.add(GTUITextures.OVERLAY_BUTTON_MACHINEMODE_LPF_FLUID);
        machineModeIcons.add(GTUITextures.OVERLAY_BUTTON_MACHINEMODE_DEFAULT);
        // 添加更多的图标
        for (int i = 0; i <= 31; i++) {
            machineModeIcons.add(GTUITextures.OVERLAY_BUTTON_MACHINEMODE_DEFAULT);
        }
    }

    @Override
    public boolean getDefaultHasMaintenanceChecks() {
        return false;
    }

    @Override
    public boolean shouldCheckMaintenance() {
        return false;
    }

    @Override
    public boolean doRandomMaintenanceDamage() {
        return false;
    }
    /*
     * @Override
     * protected void addFluidOutputs(FluidStack[] outputFluids) {
     * List<MTEHatchOutput> singleHatchList = new ArrayList<>(mOutputHatches);
     * for (FluidStack fluidStack : outputFluids) {
     * if (fluidStack == null) continue;
     * fluidStack.amount *= Integer.MAX_VALUE;
     * FluidStack tStack = fluidStack.copy();
     * if (!dumpFluid(singleHatchList, tStack, true)) {
     * dumpFluid(singleHatchList, tStack, false);
     * }
     * }
     * }
     * @Override
     * public void addItemOutputs(ItemStack[] outputItems) {
     * List<MTEHatchOutputBus> singleHatchList = new ArrayList<>(mOutputBusses);
     * for (ItemStack outputItemStack : outputItems) {
     * if (outputItemStack == null) continue;
     * outputItemStack.stackSize *= Integer.MAX_VALUE;
     * dumpItem(singleHatchList, outputItemStack);
     * }
     * }
     * private void dumpItem(List<MTEHatchOutputBus> outputBuses, ItemStack itemStack) {
     * for (MTEHatchOutputBus outputBus : outputBuses) {
     * if (outputBus.storeAll(itemStack)) {
     * break; // Stop once the item stack has been stored
     * }
     * }
     * }
     */
}
