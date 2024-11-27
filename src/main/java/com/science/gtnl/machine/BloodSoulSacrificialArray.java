package com.science.gtnl.machine;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlockAnyMeta;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.transpose;
import static gregtech.api.enums.HatchElement.Energy;
import static gregtech.api.enums.HatchElement.ExoticEnergy;
import static gregtech.api.enums.HatchElement.InputBus;
import static gregtech.api.enums.HatchElement.InputHatch;
import static gregtech.api.enums.HatchElement.OutputBus;

import java.util.Arrays;
import java.util.Collection;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.science.gtnl.Utils.TextLocalization;
import com.science.gtnl.Utils.TextUtils;
import com.science.gtnl.common.RecipeRegister;
import com.science.gtnl.machine.multiMachineClasses.MultiMachineBase;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.objects.GTRenderedTexture;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.api.util.HatchElementBuilder;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.common.blocks.BlockCasings1;
import gregtech.common.blocks.BlockCasings8;
import vazkii.botania.common.block.ModBlocks;

public class BloodSoulSacrificialArray extends MultiMachineBase<BloodSoulSacrificialArray> {

    private byte mode = 1;

    // region Class Constructor
    public BloodSoulSacrificialArray(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public BloodSoulSacrificialArray(String aName) {
        super(aName);
    }

    // endregion
    // region Processing Logic
    protected float getSpeedBonus() {
        return 1.0F;
    }

    protected int getMaxParallelRecipes() {
        return 1;
    }

    protected boolean isEnablePerfectOverclock() {
        return false;
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        switch (mode) {
            case 1:
                return RecipeRegister.BloodSoulTradingRecipes;
            default:
                return RecipeRegister.BloodDemonInjectionRecipes;
        }
    }

    @NotNull
    @Override
    public Collection<RecipeMap<?>> getAvailableRecipeMaps() {
        return Arrays.asList(RecipeRegister.BloodSoulTradingRecipes, RecipeRegister.BloodDemonInjectionRecipes);
    }

    @Override
    public final void onScrewdriverRightClick(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ) {
        this.mode = (byte) ((this.mode + 1) % 2);
        GTUtility.sendChatToPlayer(
            aPlayer,
            StatCollector.translateToLocal("BloodSoulSacrificialArray.modeMsg." + this.mode));

    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        repairMachine();
        return checkPiece(STRUCTURE_PIECE_MAIN, horizontalOffSet, verticalOffSet, depthOffSet);
    }
    // endregion

    // region Structure
    // spotless:off
    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        this.buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, horizontalOffSet, verticalOffSet, depthOffSet);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (this.mMachine) return -1;
        return this.survivialBuildPiece(
            STRUCTURE_PIECE_MAIN,
            stackSize,
            horizontalOffSet,
            verticalOffSet,
            depthOffSet,
            elementBudget,
            env,
            false,
            true);
    }
    private static final String STRUCTURE_PIECE_MAIN = "mainBloodSoulSacrificialArray";
    private final int horizontalOffSet = 2;
    private final int verticalOffSet = 1;
    private final int depthOffSet = 2;
    private static IStructureDefinition<BloodSoulSacrificialArray> STRUCTURE_DEFINITION = null;
    @Override
    public IStructureDefinition<BloodSoulSacrificialArray> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<BloodSoulSacrificialArray>builder()
                .addShape(STRUCTURE_PIECE_MAIN, transpose(shape))
                .addElement(
                    'A',
                    HatchElementBuilder.<BloodSoulSacrificialArray>builder()
                        .atLeast(Energy.or(ExoticEnergy),InputBus, OutputBus, InputHatch)
                        .adder(BloodSoulSacrificialArray::addToMachineList)
                        .dot(1)
                        .casingIndex(((BlockCasings8) GregTechAPI.sBlockCasings8).getTextureIndex(2))
                        .buildAndChain(GregTechAPI.sBlockStones, 7))
                .addElement('B',ofBlock(ModBlocks.storage, 4))
                .addElement('C',ofBlockAnyMeta(ModBlocks.prism))
                .addElement('D',ofBlock(ModBlocks.pylon, 0))
                .addElement('E',ofBlock(ModBlocks.livingwood,5))
                .addElement('F',ofBlockAnyMeta(ModBlocks.manaGlass))
                .build();
        }
        return STRUCTURE_DEFINITION;
    }
    /*
    Blocks:
    A: Hatches/Smooth Marble
    B: Dragonstone Block
    C: Prism
    D: Mana Pylon
    E: Glimmering Livingwood
    F: Managlass
     */
    public static final String[][] shape = new String[][]{
        {"E   E","     ","     ","     ","E   E"},
        {"C   C"," D D ","  ~  "," D D ","C   C"},
        {"EAAAE","AFEFA","AEBEA","AFEFA","EAAAE"}
    };

    // spotless:on
    // endregion

    // region Overrides

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
        aNBT.setByte("mode", mode);
    }

    @Override
    public void loadNBTData(final NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        mode = aNBT.getByte("mode");
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        final MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType(TextLocalization.BloodSoulSacrificialArrayRecipeType)
            .addInfo("§4§oSacrifice your soul to accelerate its speed...")
            .addSeparator()
            .addInfo(TextLocalization.StructureTooComplex)
            .addInfo(TextLocalization.BLUE_PRINT_INFO)
            .beginStructureBlock(5, 3, 5, false)
            .addInputHatch(TextLocalization.textUseBlueprint, 1)
            .addInputBus(TextLocalization.textUseBlueprint, 1)
            .addOutputBus(TextLocalization.textUseBlueprint, 1)
            .addEnergyHatch(TextLocalization.textUseBlueprint, 1)
            .toolTipFinisher(TextUtils.SCIENCE_NOT_LEISURE);
        return tt;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new BloodSoulSacrificialArray(this.mName);
    }

    private int getCasingTextureID() {
        return ((BlockCasings1) GregTechAPI.sBlockCasings1).getTextureIndex(12);
    }

    protected GTRenderedTexture BSSAgetFrontOverlay() {
        return new GTRenderedTexture(Textures.BlockIcons.OVERLAY_DTPF_OFF);
    }

    protected GTRenderedTexture BSSAgetFrontOverlayActive() {
        return new GTRenderedTexture(Textures.BlockIcons.OVERLAY_DTPF_ON);
    }

    @Override
    public ITexture[] getTexture(final IGregTechTileEntity aBaseMetaTileEntity, final ForgeDirection side,
        final ForgeDirection facing, final int aColorIndex, final boolean aActive, final boolean aRedstone) {
        if (side == facing) {
            return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()),
                aActive ? BSSAgetFrontOverlayActive() : BSSAgetFrontOverlay() };
        }
        return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()) };
    }

    @Override
    public boolean supportsBatchMode() {
        return true;
    }
    // endregion
}
