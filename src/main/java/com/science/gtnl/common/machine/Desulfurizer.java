package com.science.gtnl.common.machine;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static gregtech.api.GregTechAPI.*;
import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.util.GTStructureUtility.buildHatchAdder;
import static gregtech.api.util.GTStructureUtility.ofCoil;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.science.gtnl.Utils.StructureUtils;
import com.science.gtnl.Utils.TextLocalization;
import com.science.gtnl.Utils.TextUtils;
import com.science.gtnl.common.RecipeRegister;
import com.science.gtnl.common.machine.multiMachineClasses.MultiMachineBase;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.HeatingCoilLevel;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.objects.GTRenderedTexture;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.api.util.OverclockCalculator;
import gregtech.common.blocks.BlockCasings4;

public class Desulfurizer extends MultiMachineBase<Desulfurizer> implements ISurvivalConstructable {

    private HeatingCoilLevel mHeatingCapacity;
    private int mLevel = 0;
    private int mCasing;
    private static IStructureDefinition<Desulfurizer> STRUCTURE_DEFINITION = null;
    public static final String STRUCTURE_PIECE_MAIN = "main";
    public static String[][] shape;
    public static final String Desu_STRUCTURE_FILE_PATH = "sciencenotleisure:multiblock/desulfurizer";
    public final int horizontalOffSet = 3;
    public final int verticalOffSet = 4;
    public final int depthOffSet = 0;

    public Desulfurizer(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
        shape = StructureUtils.readStructureFromFile(Desu_STRUCTURE_FILE_PATH);
    }

    public Desulfurizer(String aName) {
        super(aName);
        shape = StructureUtils.readStructureFromFile(Desu_STRUCTURE_FILE_PATH);
    }

    @Override
    protected boolean isEnablePerfectOverclock() {
        return true;
    }

    @Override
    protected float getSpeedBonus() {
        return 1;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new Desulfurizer(this.mName);
    }

    @Override
    public ITexture[] getTexture(final IGregTechTileEntity aBaseMetaTileEntity, final ForgeDirection side,
        final ForgeDirection facing, final int aColorIndex, final boolean aActive, final boolean aRedstone) {
        if (side == facing) {
            return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()),
                aActive ? DgetFrontOverlayActive() : DgetFrontOverlay() };
        }
        return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()) };
    }

    protected GTRenderedTexture DgetFrontOverlay() {
        return new GTRenderedTexture(Textures.BlockIcons.OVERLAY_FRONT_OIL_CRACKER);
    }

    protected GTRenderedTexture DgetFrontOverlayActive() {
        return new GTRenderedTexture(Textures.BlockIcons.OVERLAY_FRONT_OIL_CRACKER_ACTIVE);
    }

    public int getCasingTextureID() {
        return ((BlockCasings4) GregTechAPI.sBlockCasings4).getTextureIndex(1);
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return RecipeRegister.DesulfurizerRecipes;
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType(TextLocalization.DesulfurizerRecipeType)
            .addInfo(TextLocalization.Tooltip_Desulfurizer_00)
            .addInfo(TextLocalization.Tooltip_Desulfurizer_01)
            .addInfo(TextLocalization.Tooltip_Desulfurizer_02)
            .addSeparator()
            .addInfo(TextLocalization.StructureTooComplex)
            .addInfo(TextLocalization.BLUE_PRINT_INFO)
            .beginStructureBlock(12, 6, 6, true)
            .addInputHatch(TextLocalization.Tooltip_Desulfurizer_Casing)
            .addOutputHatch(TextLocalization.Tooltip_Desulfurizer_Casing)
            .addOutputBus(TextLocalization.Tooltip_Desulfurizer_Casing)
            .addEnergyHatch(TextLocalization.Tooltip_Desulfurizer_Casing)
            .addMaintenanceHatch(TextLocalization.Tooltip_Desulfurizer_Casing)
            .toolTipFinisher(TextUtils.SQY);
        return tt;
    }

    @Override
    public IStructureDefinition<Desulfurizer> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<Desulfurizer>builder()
                .addShape(STRUCTURE_PIECE_MAIN, transpose(shape))
                .addElement('A', ofBlock(sBlockCasings1, 11))
                .addElement('B', ofBlock(sBlockCasings2, 0))
                .addElement('C', ofBlock(sBlockCasings2, 12))
                .addElement('D', ofBlock(sBlockCasings2, 13))
                .addElement(
                    'E',
                    buildHatchAdder(Desulfurizer.class).atLeast(InputHatch, OutputHatch, OutputBus, Maintenance, Energy)
                        .casingIndex(((BlockCasings4) sBlockCasings4).getTextureIndex(1))
                        .dot(1)
                        .buildAndChain(onElementPass(x -> ++x.mCasing, ofBlock(sBlockCasings4, 1))))
                .addElement('F', ofCoil(Desulfurizer::setCoilLevel, Desulfurizer::getCoilLevel))
                .addElement('G', ofBlock(sBlockCasings6, 2))
                .build();
        }
        return STRUCTURE_DEFINITION;
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, horizontalOffSet, verticalOffSet, depthOffSet);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        return survivialBuildPiece(
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

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        mCasing = 0;
        mLevel = 0;
        setCoilLevel(HeatingCoilLevel.None);
        return checkPiece(STRUCTURE_PIECE_MAIN, horizontalOffSet, verticalOffSet, depthOffSet) && mCasing >= 20
            && getCoilLevel() != HeatingCoilLevel.None
            && (mLevel = getCoilLevel().getTier() + 1) > 0
            && checkHatch();
    }

    @Override
    public int getMaxParallelRecipes() {
        return (this.mLevel * 8);
    }

    @Override
    protected ProcessingLogic createProcessingLogic() {
        return new ProcessingLogic() {

            @NotNull
            @Override
            protected OverclockCalculator createOverclockCalculator(@NotNull GTRecipe recipe) {
                return super.createOverclockCalculator(recipe).setSpeedBoost(100.0 / (100 + 10 * mLevel))
                    .setHeatOC(true)
                    .setRecipeHeat(0)
                    .setMachineHeat((int) (getCoilLevel().getHeat() * 2));
            }
        }.setMaxParallelSupplier(this::getMaxParallelRecipes);
    }

    public HeatingCoilLevel getCoilLevel() {
        return mHeatingCapacity;
    }

    public void setCoilLevel(HeatingCoilLevel aCoilLevel) {
        mHeatingCapacity = aCoilLevel;
    }

    @Override
    public boolean getDefaultHasMaintenanceChecks() {
        return true;
    }

    @Override
    public boolean shouldCheckMaintenance() {
        return true;
    }
}
