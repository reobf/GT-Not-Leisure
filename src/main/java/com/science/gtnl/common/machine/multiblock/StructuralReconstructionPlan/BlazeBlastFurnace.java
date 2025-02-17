package com.science.gtnl.common.machine.multiblock.StructuralReconstructionPlan;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static gregtech.api.GregTechAPI.sBlockCasings2;
import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.util.GTStructureUtility.*;
import static gregtech.api.util.GTUtility.validMTEList;

import java.util.ArrayList;
import java.util.Objects;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.science.gtnl.Utils.StructureUtils;
import com.science.gtnl.Utils.item.TextLocalization;
import com.science.gtnl.common.hatch.HatchCustomFluid;
import com.science.gtnl.common.machine.multiMachineClasses.MultiMachineBase;

import bartworks.util.BWUtil;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.enums.HeatingCoilLevel;
import gregtech.api.enums.Materials;
import gregtech.api.enums.SoundResource;
import gregtech.api.enums.TAE;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.MTEHatch;
import gregtech.api.metatileentity.implementations.MTEHatchMaintenance;
import gregtech.api.metatileentity.implementations.MTEHatchOutput;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.api.util.OverclockCalculator;
import gregtech.api.util.shutdown.ShutDownReasonRegistry;
import gtPlusPlus.core.block.ModBlocks;
import gtPlusPlus.core.util.minecraft.FluidUtils;
import gtPlusPlus.xmod.gregtech.common.blocks.textures.TexturesGtBlock;

public class BlazeBlastFurnace extends MultiMachineBase<BlazeBlastFurnace> implements ISurvivalConstructable {

    public static final int CASING_INDEX = TAE.GTPP_INDEX(15);
    private int mCasing;
    public String[][] shape;
    public static final String STRUCTURE_PIECE_MAIN = "main";
    public static final String BBF_STRUCTURE_FILE_PATH = "sciencenotleisure:multiblock/blaze_blast_furnace";
    public final int horizontalOffSet = 3;
    public final int verticalOffSet = 3;
    public final int depthOffSet = 1;
    public static IStructureDefinition<BlazeBlastFurnace> STRUCTURE_DEFINITION = null;
    private int mHeatingCapacity = 0;
    private HeatingCoilLevel mCoilLevel;
    protected final FluidStack[] pollutionFluidStacks = { Materials.CarbonDioxide.getGas(1000),
        Materials.CarbonMonoxide.getGas(1000), Materials.SulfurDioxide.getGas(1000) };

    protected final ArrayList<MTEHatchOutput> mPollutionOutputHatches = new ArrayList<>();
    public final ArrayList<HatchCustomFluid> FluidBlazeInputHatch = new ArrayList<>();

    public BlazeBlastFurnace(final int aID, final String aName, final String aNameRegional) {
        super(aID, aName, aNameRegional);
        this.shape = StructureUtils.readStructureFromFile(BBF_STRUCTURE_FILE_PATH);
    }

    public BlazeBlastFurnace(final String aName) {
        super(aName);
        this.shape = StructureUtils.readStructureFromFile(BBF_STRUCTURE_FILE_PATH);
    }

    @Override
    public IMetaTileEntity newMetaEntity(final IGregTechTileEntity aTileEntity) {
        return new BlazeBlastFurnace(this.mName);
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType(TextLocalization.BlazeBlastFurnaceRecipeType)
            .addInfo(TextLocalization.Tooltip_BlazeBlastFurnace_00)
            .addInfo(TextLocalization.Tooltip_BlazeBlastFurnace_01)
            .addInfo(TextLocalization.Tooltip_BlazeBlastFurnace_02)
            .addInfo(TextLocalization.Tooltip_BlazeBlastFurnace_03)
            .beginStructureBlock(7, 6, 7, true)
            .addInputBus(TextLocalization.Tooltip_BlazeBlastFurnace_Casing_00, 1)
            .addOutputBus(TextLocalization.Tooltip_BlazeBlastFurnace_Casing_00, 1)
            .addInputHatch(TextLocalization.Tooltip_BlazeBlastFurnace_Casing_00, 1)
            .addOutputHatch(TextLocalization.Tooltip_BlazeBlastFurnace_Casing_00, 1)
            .addOutputHatch(TextLocalization.Tooltip_BlazeBlastFurnace_Casing_01, 1)
            .addEnergyHatch(TextLocalization.Tooltip_BlazeBlastFurnace_Casing_00, 1)
            .addMufflerHatch(TextLocalization.Tooltip_BlazeBlastFurnace_Casing_02, 1)
            .addMaintenanceHatch(TextLocalization.Tooltip_BlazeBlastFurnace_Casing_00, 1)
            .addOtherStructurePart(
                TextLocalization.FluidBlazeInputHatch,
                TextLocalization.Tooltip_BlazeBlastFurnace_Casing_00,
                1)
            .toolTipFinisher();
        return tt;
    }

    @Override
    public IStructureDefinition<BlazeBlastFurnace> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<BlazeBlastFurnace>builder()
                .addShape(STRUCTURE_PIECE_MAIN, transpose(shape))
                .addElement('A', ofBlock(sBlockCasings2, 15))
                .addElement('B', ofCoil(BlazeBlastFurnace::setCoilLevel, BlazeBlastFurnace::getCoilLevel))
                .addElement(
                    'C',
                    buildHatchAdder(BlazeBlastFurnace.class)
                        .atLeast(
                            OutputHatch.withAdder(BlazeBlastFurnace::addOutputHatchToTopList)
                                .withCount(t -> t.mPollutionOutputHatches.size()))
                        .casingIndex(TAE.getIndexFromPage(2, 11))
                        .dot(1)
                        .buildAndChain(ModBlocks.blockCasings3Misc, 11))
                .addElement('D', ofBlock(ModBlocks.blockCasingsMisc, 14))
                .addElement(
                    'E',
                    ofChain(
                        buildHatchAdder(BlazeBlastFurnace.class)
                            .atLeast(InputBus, OutputBus, InputHatch, OutputHatch, Energy, Maintenance)
                            .dot(1)
                            .casingIndex(CASING_INDEX)
                            .build(),
                        onElementPass(x -> ++x.mCasing, ofBlock(ModBlocks.blockCasingsMisc, 15)),
                        buildHatchAdder(BlazeBlastFurnace.class).adder(BlazeBlastFurnace::addFluidBlazeInputHatch)
                            .hatchId(21503)
                            .shouldReject(x -> !x.FluidBlazeInputHatch.isEmpty())
                            .casingIndex(CASING_INDEX)
                            .dot(1)
                            .build()))
                .addElement('F', Muffler.newAny(TAE.getIndexFromPage(2, 11), 1))
                .build();
        }
        return STRUCTURE_DEFINITION;
    }

    public void setCoilLevel(HeatingCoilLevel aCoilLevel) {
        this.mCoilLevel = aCoilLevel;
    }

    public HeatingCoilLevel getCoilLevel() {
        return this.mCoilLevel;
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, horizontalOffSet, verticalOffSet, depthOffSet);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        this.setCoilLevel(HeatingCoilLevel.None);
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
        this.mHeatingCapacity = 0;
        mCasing = 0;
        this.setCoilLevel(HeatingCoilLevel.None);
        this.mPollutionOutputHatches.clear();
        FluidBlazeInputHatch.clear();

        if (!checkPiece(STRUCTURE_PIECE_MAIN, horizontalOffSet, verticalOffSet, depthOffSet)) return false;

        if (getCoilLevel() == HeatingCoilLevel.None) return false;

        if (mMaintenanceHatches.size() != 1 && mMufflerHatches.size() != 1) return false;

        this.mHeatingCapacity = (int) getCoilLevel().getHeat() + 100 * (BWUtil.getTier(getMaxInputVoltage()) - 2);

        return mCasing >= 50 && checkHatch();
    }

    public boolean addOutputHatchToTopList(IGregTechTileEntity aTileEntity, int aBaseCasingIndex) {
        if (aTileEntity == null) return false;
        IMetaTileEntity aMetaTileEntity = aTileEntity.getMetaTileEntity();
        if (aMetaTileEntity == null) return false;
        if (aMetaTileEntity instanceof MTEHatchOutput) {
            ((MTEHatch) aMetaTileEntity).updateTexture(aBaseCasingIndex);
            return this.mPollutionOutputHatches.add((MTEHatchOutput) aMetaTileEntity);
        }
        return false;
    }

    @Override
    public boolean addOutput(FluidStack aLiquid) {
        if (aLiquid == null) return false;
        FluidStack tLiquid = aLiquid.copy();
        boolean isOutputPollution = false;
        for (FluidStack pollutionFluidStack : this.pollutionFluidStacks) {
            if (!tLiquid.isFluidEqual(pollutionFluidStack)) continue;

            isOutputPollution = true;
            break;
        }
        ArrayList<MTEHatchOutput> tOutputHatches;
        if (isOutputPollution) {
            tOutputHatches = this.mPollutionOutputHatches;
            tLiquid.amount = tLiquid.amount * Math.min(100 - getAveragePollutionPercentage(), 100) / 100;
        } else {
            tOutputHatches = this.mOutputHatches;
        }
        return dumpFluid(tOutputHatches, tLiquid, true) || dumpFluid(tOutputHatches, tLiquid, false);
    }

    @Override
    public boolean checkHatch() {
        return super.checkHatch() && !FluidBlazeInputHatch.isEmpty();
    }

    private boolean addFluidBlazeInputHatch(IGregTechTileEntity aTileEntity, int aBaseCasingIndex) {
        if (aTileEntity == null) {
            return false;
        } else {
            IMetaTileEntity aMetaTileEntity = aTileEntity.getMetaTileEntity();
            if (aMetaTileEntity instanceof HatchCustomFluid && aMetaTileEntity.getBaseMetaTileEntity()
                .getMetaTileID() == 21503) {
                return addToMachineListInternal(FluidBlazeInputHatch, aTileEntity, aBaseCasingIndex);
            }
        }
        return false;
    }

    @Override
    public void updateSlots() {
        for (HatchCustomFluid tHatch : validMTEList(FluidBlazeInputHatch)) tHatch.updateSlots();
        super.updateSlots();
    }

    protected float getSpeedBonus() {
        return 1F;
    }

    protected boolean isEnablePerfectOverclock() {
        return false;
    }

    protected int getCasingTextureID() {
        return TAE.getIndexFromPage(2, 11);
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, ForgeDirection side, ForgeDirection aFacing,
        int colorIndex, boolean aActive, boolean redstoneLevel) {
        if (side == aFacing) {
            if (aActive) return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()),
                TextureFactory.builder()
                    .addIcon(TexturesGtBlock.oMCAAdvancedEBFActive)
                    .extFacing()
                    .build() };
            return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()),
                TextureFactory.builder()
                    .addIcon(TexturesGtBlock.oMCAAdvancedEBF)
                    .extFacing()
                    .build() };
        }
        return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()) };
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return RecipeMaps.blastFurnaceRecipes;
    }

    @Override
    protected ProcessingLogic createProcessingLogic() {
        return new ProcessingLogic() {

            @Nonnull
            @Override
            protected OverclockCalculator createOverclockCalculator(@Nonnull GTRecipe recipe) {
                return super.createOverclockCalculator(recipe).setRecipeHeat(recipe.mSpecialValue)
                    .setMachineHeat(BlazeBlastFurnace.this.mHeatingCapacity)
                    .setHeatOC(true)
                    .setHeatDiscount(true)
                    .setSpeedBoost(0.5);
            }

            @Override
            protected @Nonnull CheckRecipeResult validateRecipe(@Nonnull GTRecipe recipe) {
                return recipe.mSpecialValue <= BlazeBlastFurnace.this.mHeatingCapacity
                    ? CheckRecipeResultRegistry.SUCCESSFUL
                    : CheckRecipeResultRegistry.insufficientHeat(recipe.mSpecialValue);
            }
        }.setMaxParallelSupplier(this::getMaxParallelRecipes);
    }

    @Override
    public int getMaxParallelRecipes() {
        return 64;
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);

        if (this.mStartUpCheck < 0) {
            if (this.mMaxProgresstime > 0 && this.mProgresstime != 0 || this.getBaseMetaTileEntity()
                .hasWorkJustBeenEnabled()) {
                if (aTick % 20 == 0 || this.getBaseMetaTileEntity()
                    .hasWorkJustBeenEnabled()) {
                    if (!this.depleteInputFromRestrictedHatches(
                        this.FluidBlazeInputHatch,
                        (int) (10 * getInputVoltageTier() * getInputVoltageTier()))) {
                        this.causeMaintenanceIssue();
                        this.stopMachine(
                            ShutDownReasonRegistry.outOfFluid(
                                Objects.requireNonNull(
                                    FluidUtils.getFluidStack(
                                        "molten.blaze",
                                        (int) (10 * getInputVoltageTier() * getInputVoltageTier())))));
                    }
                }
            }
        }
    }

    @Override
    public boolean getDefaultHasMaintenanceChecks() {
        return true;
    }

    @Override
    public boolean shouldCheckMaintenance() {
        return true;
    }

    @Override
    public void checkMaintenance() {
        if (!shouldCheckMaintenance()) return;

        if (getRepairStatus() != getIdealStatus()) {
            for (MTEHatchMaintenance tHatch : validMTEList(mMaintenanceHatches)) {
                if (tHatch.mAuto) tHatch.autoMaintainance();
                if (tHatch.mWrench) mWrench = true;
                if (tHatch.mScrewdriver) mScrewdriver = true;
                if (tHatch.mSoftHammer) mSoftHammer = true;
                if (tHatch.mHardHammer) mHardHammer = true;
                if (tHatch.mSolderingTool) mSolderingTool = true;
                if (tHatch.mCrowbar) mCrowbar = true;

                tHatch.mWrench = false;
                tHatch.mScrewdriver = false;
                tHatch.mSoftHammer = false;
                tHatch.mHardHammer = false;
                tHatch.mSolderingTool = false;
                tHatch.mCrowbar = false;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    protected SoundResource getActivitySoundLoop() {
        return SoundResource.GT_MACHINES_ADV_FREEZER_LOOP;
    }
}
