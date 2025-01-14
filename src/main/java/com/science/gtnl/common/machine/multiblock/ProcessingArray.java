package com.science.gtnl.common.machine.multiblock;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static gregtech.api.GregTechAPI.*;
import static gregtech.api.enums.GTValues.VN;
import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.enums.Textures.BlockIcons.*;
import static gregtech.api.metatileentity.implementations.MTEBasicMachine.isValidForLowGravity;
import static gregtech.api.util.GTStructureUtility.*;
import static gregtech.api.util.GTStructureUtility.ofFrame;
import static gregtech.api.util.GTUtility.validMTEList;

import java.util.List;

import javax.annotation.Nonnull;

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
import com.science.gtnl.Utils.GTNLProcessingArrayManager;
import com.science.gtnl.Utils.StructureUtils;
import com.science.gtnl.common.machine.multiMachineClasses.MultiMachineBase;

import gregtech.GTMod;
import gregtech.api.enums.*;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.*;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.recipe.check.SimpleCheckRecipeResult;
import gregtech.api.recipe.metadata.CompressionTierKey;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.ExoticEnergyInputHelper;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.GTUtility;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.common.blocks.BlockCasings4;
import gregtech.common.blocks.ItemMachines;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;

public class ProcessingArray extends MultiMachineBase<ProcessingArray> implements ISurvivalConstructable {

    public int mCasing = 0;
    public RecipeMap<?> mLastRecipeMap;
    public ItemStack lastControllerStack;
    public int tTier = 0;
    public int horizontalOffset = 6;
    public int verticalOffset = 4;
    public int depthOffset = 0;
    private static IStructureDefinition<ProcessingArray> STRUCTURE_DEFINITION = null;
    public static final String STRUCTURE_PIECE_MAIN = "main";
    public static String[][] shape;
    public static final String PA_STRUCTURE_FILE_PATH = "sciencenotleisure:multiblock/processing_array";
    private HeatingCoilLevel mHeatingCapacity;
    protected static final int CASING_INDEX = ((BlockCasings4) sBlockCasings4).getTextureIndex(1);

    public ProcessingArray(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
        shape = StructureUtils.readStructureFromFile(PA_STRUCTURE_FILE_PATH);
    }

    public ProcessingArray(String aName) {
        super(aName);
        shape = StructureUtils.readStructureFromFile(PA_STRUCTURE_FILE_PATH);
    }

    @Override
    public boolean isEnablePerfectOverclock() {
        return true;
    }

    @Override
    public int getMaxParallelRecipes() {
        return 1;
    }

    @Override
    public float getSpeedBonus() {
        return 1;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new ProcessingArray(this.mName);
    }

    @Override
    public MultiblockTooltipBuilder createTooltip() {
        final MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType("Processing Array")
            .addInfo("Runs supplied machines as if placed in the world")
            .addInfo("Place up to 64 singleblock GT machines into the controller")
            .addInfo("Note that you still need to supply power to them all")
            .addInfo("Use a screwdriver to enable separate input busses")
            .addInfo("Use a wire cutter to disable UEV+ downtiering")
            .addInfo("Doesn't work on certain machines, deal with it")
            .addInfo("Use it if you hate GT++, or want even more speed later on")
            .beginStructureBlock(13, 6, 5, true)
            .addEnergyHatch("Any casing", 1)
            .addMaintenanceHatch("Any casing", 1)
            .addInputBus("Any casing", 1)
            .addInputHatch("Any casing", 1)
            .addOutputBus("Any casing", 1)
            .addOutputHatch("Any casing", 1)
            .toolTipFinisher();
        return tt;
    }

    @Override
    public boolean addToMachineList(IGregTechTileEntity aTileEntity, int aBaseCasingIndex) {
        return super.addToMachineList(aTileEntity, aBaseCasingIndex)
            || addExoticEnergyInputToMachineList(aTileEntity, aBaseCasingIndex);
    }

    public int getCasingTextureID() {
        return CASING_INDEX;
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, ForgeDirection side, ForgeDirection aFacing,
        int colorIndex, boolean aActive, boolean redstoneLevel) {
        if (side == aFacing) {
            if (aActive) return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_PROCESSING_ARRAY_ACTIVE)
                    .extFacing()
                    .build(),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_PROCESSING_ARRAY_ACTIVE_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
            return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_PROCESSING_ARRAY)
                    .extFacing()
                    .build(),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_PROCESSING_ARRAY_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
        }
        return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()) };
    }

    public RecipeMap<?> fetchRecipeMap() {
        if (isCorrectMachinePart(getControllerSlot())) {
            // 先尝试通过 getMachineName 获取配方映射
            RecipeMap<?> recipeMap = GTNLProcessingArrayManager
                .giveRecipeMap(GTNLProcessingArrayManager.getMachineName(getControllerSlot()));

            // 如果未找到配方映射，再尝试通过 getFullMachineName 获取
            if (recipeMap == null) {
                recipeMap = GTNLProcessingArrayManager
                    .giveRecipeMap(GTNLProcessingArrayManager.getFullMachineName(getControllerSlot()));
            }

            return recipeMap;
        }
        return null;
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return mLastRecipeMap;
    }

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return aStack != null && aStack.getUnlocalizedName()
            .startsWith("gt.blockmachines.");
    }

    @Override
    public void sendStartMultiBlockSoundLoop() {
        // 先尝试通过 getMachineName 获取声音资源
        SoundResource sound = GTNLProcessingArrayManager
            .getSoundResource(GTNLProcessingArrayManager.getMachineName(getControllerSlot()));

        // 如果未找到声音资源，再尝试通过 getFullMachineName 获取
        if (sound == null) {
            sound = GTNLProcessingArrayManager
                .getSoundResource(GTNLProcessingArrayManager.getFullMachineName(getControllerSlot()));
        }

        if (sound != null) {
            sendLoopStart((byte) sound.id);
        }
    }

    @Override
    public void startSoundLoop(byte aIndex, double aX, double aY, double aZ) {
        super.startSoundLoop(aIndex, aX, aY, aZ);
        SoundResource sound = SoundResource.get(aIndex < 0 ? aIndex + 256 : 0);
        if (sound != null) {
            GTUtility.doSoundAtClient(sound, getTimeBetweenProcessSounds(), 1.0F, aX, aY, aZ);
        }
    }

    @Override
    @NotNull
    public CheckRecipeResult checkProcessing() {
        if (!GTUtility.areStacksEqual(lastControllerStack, getControllerSlot())) {
            // controller slot has changed
            lastControllerStack = getControllerSlot();
            mLastRecipeMap = fetchRecipeMap();
            setTierAndMult();
        }
        if (mLastRecipeMap == null) return SimpleCheckRecipeResult.ofFailure("no_machine");
        if (mLockedToSingleRecipe && mSingleRecipeCheck != null) {
            if (mSingleRecipeCheck.getRecipeMap() != mLastRecipeMap) {
                return SimpleCheckRecipeResult.ofFailure("machine_mismatch");
            }
        }

        return super.checkProcessing();
    }

    @Override
    public ProcessingLogic createProcessingLogic() {
        return new ProcessingLogic() {

            @Nonnull
            @Override
            public CheckRecipeResult validateRecipe(@Nonnull GTRecipe recipe) {
                if (recipe.getMetadataOrDefault(CompressionTierKey.INSTANCE, 0) > 0)
                    return CheckRecipeResultRegistry.NO_RECIPE;
                if (GTMod.gregtechproxy.mLowGravProcessing && recipe.mSpecialValue == -100
                    && !isValidForLowGravity(recipe, getBaseMetaTileEntity().getWorld().provider.dimensionId)) {
                    return SimpleCheckRecipeResult.ofFailure("high_gravity");
                }
                if (recipe.mEUt > availableVoltage) return CheckRecipeResultRegistry.insufficientPower(recipe.mEUt);
                return CheckRecipeResultRegistry.SUCCESSFUL;
            }

            @NotNull
            @Override
            public CheckRecipeResult process() {
                setEuModifier(0.9);
                setSpeedBonus(1 - (double) (3 * getCoilLevel().getTier()) / 100);
                return super.process();
            }

        }.setMaxParallelSupplier(this::getMaxParallel);
    }

    @Override
    public boolean canUseControllerSlotForRecipe() {
        return false;
    }

    @Override
    public void setProcessingLogicPower(ProcessingLogic logic) {
        logic.setAvailableVoltage(GTValues.V[tTier] * (mLastRecipeMap != null ? mLastRecipeMap.getAmperage() : 1));
        logic.setAvailableAmperage(getMaxParallel());
        logic.setAmperageOC(false);
    }

    public void setTierAndMult() {
        IMetaTileEntity aMachine = ItemMachines.getMetaTileEntity(getControllerSlot());
        if (aMachine instanceof MTETieredMachineBlock) {
            tTier = ((MTETieredMachineBlock) aMachine).mTier;
        } else {
            tTier = 0;
        }
    }

    public int getMaxParallel() {
        if (getControllerSlot() == null) {
            return 0;
        }
        return getControllerSlot().stackSize + GTUtility.getTier(this.getMaxInputVoltage()) * 4;
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);
        if (mMachine && aTick % 20 == 0) {
            for (MTEHatchInputBus tInputBus : mInputBusses) {
                tInputBus.mRecipeMap = mLastRecipeMap;
            }
            for (MTEHatchInput tInputHatch : mInputHatches) {
                tInputHatch.mRecipeMap = mLastRecipeMap;
            }
        }
    }

    public HeatingCoilLevel getCoilLevel() {
        return mHeatingCapacity;
    }

    public void setCoilLevel(HeatingCoilLevel aCoilLevel) {
        mHeatingCapacity = aCoilLevel;
    }

    @Override
    public IStructureDefinition<ProcessingArray> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<ProcessingArray>builder()
                .addShape(STRUCTURE_PIECE_MAIN, transpose(shape))
                .addElement('A', ofBlock(sBlockCasings1, 11))
                .addElement(
                    'B',
                    buildHatchAdder(ProcessingArray.class)
                        .atLeast(InputHatch, OutputHatch, InputBus, OutputBus, Maintenance, Energy.or(ExoticEnergy))
                        .casingIndex(CASING_INDEX)
                        .dot(1)
                        .buildAndChain(onElementPass(x -> ++x.mCasing, ofBlock(sBlockCasings4, 1))))
                .addElement('C', ofCoil(ProcessingArray::setCoilLevel, ProcessingArray::getCoilLevel))
                .addElement('D', ofFrame(Materials.StainlessSteel))
                .addElement('E', ofFrame(Materials.PulsatingIron))
                .addElement('F', Muffler.newAny(CASING_INDEX, 2))
                .build();
        }
        return STRUCTURE_DEFINITION;
    }

    @Override
    public void construct(ItemStack aStack, boolean aHintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, aStack, aHintsOnly, horizontalOffset, verticalOffset, depthOffset);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        return survivialBuildPiece(
            STRUCTURE_PIECE_MAIN,
            stackSize,
            horizontalOffset,
            verticalOffset,
            depthOffset,
            elementBudget,
            env,
            false,
            true);
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
    }

    @Override
    public void loadNBTData(final NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        if (aNBT.hasKey("mSeparate")) {
            // backward compatibility
            inputSeparation = aNBT.getBoolean("mSeparate");
        }
        if (aNBT.hasKey("mUseMultiparallelMode")) {
            // backward compatibility
            batchMode = aNBT.getBoolean("mUseMultiparallelMode");
        }
    }

    @Override
    public final void onScrewdriverRightClick(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ) {
        if (aPlayer.isSneaking()) {
            // Lock to single recipe
            super.onScrewdriverRightClick(side, aPlayer, aX, aY, aZ);
        } else {
            inputSeparation = !inputSeparation;
            GTUtility.sendChatToPlayer(
                aPlayer,
                StatCollector.translateToLocal("GT5U.machines.separatebus") + " " + inputSeparation);
        }
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        mCasing = 0;
        if (GTUtility.getTier(this.getMaxInputVoltage()) > tTier + 4) {
            return false;
        }
        setCoilLevel(HeatingCoilLevel.None);
        return checkPiece(STRUCTURE_PIECE_MAIN, horizontalOffset, verticalOffset, depthOffset) && mCasing >= 120
            && mMaintenanceHatches.size() == 1
            && getCoilLevel() != HeatingCoilLevel.None
            && this.mMufflerHatches.size() == 2;
    }

    @Override
    public String[] getInfoData() {
        long storedEnergy = 0;
        long maxEnergy = 0;
        for (MTEHatch tHatch : validMTEList(mExoticEnergyHatches)) {
            storedEnergy += tHatch.getBaseMetaTileEntity()
                .getStoredEU();
            maxEnergy += tHatch.getBaseMetaTileEntity()
                .getEUCapacity();
        }

        return new String[] {
            StatCollector.translateToLocal("GT5U.multiblock.Progress") + ": "
                + EnumChatFormatting.GREEN
                + GTUtility.formatNumbers(mProgresstime / 20)
                + EnumChatFormatting.RESET
                + " s / "
                + EnumChatFormatting.YELLOW
                + GTUtility.formatNumbers(mMaxProgresstime / 20)
                + EnumChatFormatting.RESET
                + " s",
            StatCollector.translateToLocal("GT5U.multiblock.energy") + ": "
                + EnumChatFormatting.GREEN
                + GTUtility.formatNumbers(storedEnergy)
                + EnumChatFormatting.RESET
                + " EU / "
                + EnumChatFormatting.YELLOW
                + GTUtility.formatNumbers(maxEnergy)
                + EnumChatFormatting.RESET
                + " EU",
            StatCollector.translateToLocal("GT5U.multiblock.usage") + ": "
                + EnumChatFormatting.RED
                + GTUtility.formatNumbers(-lEUt)
                + EnumChatFormatting.RESET
                + " EU/t",
            StatCollector.translateToLocal("GT5U.multiblock.mei") + ": "
                + EnumChatFormatting.YELLOW
                + GTUtility
                    .formatNumbers(ExoticEnergyInputHelper.getMaxInputVoltageMulti(getExoticAndNormalEnergyHatchList()))
                + EnumChatFormatting.RESET
                + " EU/t(*"
                + GTUtility
                    .formatNumbers(ExoticEnergyInputHelper.getMaxInputAmpsMulti(getExoticAndNormalEnergyHatchList()))
                + "A) "
                + StatCollector.translateToLocal("GT5U.machines.tier")
                + ": "
                + EnumChatFormatting.YELLOW
                + VN[GTUtility
                    .getTier(ExoticEnergyInputHelper.getMaxInputVoltageMulti(getExoticAndNormalEnergyHatchList()))]
                + EnumChatFormatting.RESET,
            StatCollector.translateToLocal("GT5U.multiblock.problems") + ": "
                + EnumChatFormatting.RED
                + (getIdealStatus() - getRepairStatus())
                + EnumChatFormatting.RESET
                + " "
                + StatCollector.translateToLocal("GT5U.multiblock.efficiency")
                + ": "
                + EnumChatFormatting.YELLOW
                + mEfficiency / 100.0F
                + EnumChatFormatting.RESET
                + " %",
            StatCollector.translateToLocal("GT5U.PA.machinetier") + ": "
                + EnumChatFormatting.GREEN
                + tTier
                + EnumChatFormatting.RESET
                + " "
                + StatCollector.translateToLocal("GT5U.PA.discount")
                + ": "
                + EnumChatFormatting.GREEN
                + 1
                + EnumChatFormatting.RESET
                + " x",
            StatCollector.translateToLocal("GT5U.PA.parallel") + ": "
                + EnumChatFormatting.GREEN
                + GTUtility.formatNumbers(getMaxParallel())
                + EnumChatFormatting.RESET };
    }

    @Override
    public boolean supportsSlotAutomation(int aSlot) {
        return aSlot == getControllerSlotIndex();
    }

    @Override
    public void getWailaNBTData(EntityPlayerMP player, TileEntity tile, NBTTagCompound tag, World world, int x, int y,
        int z) {
        super.getWailaNBTData(player, tile, tag, world, x, y, z);
        if (mLastRecipeMap != null && getControllerSlot() != null) {
            tag.setString("type", getControllerSlot().getDisplayName());
        }
    }

    @Override
    public void getWailaBody(ItemStack itemStack, List<String> currentTip, IWailaDataAccessor accessor,
        IWailaConfigHandler config) {
        super.getWailaBody(itemStack, currentTip, accessor, config);
        final NBTTagCompound tag = accessor.getNBTData();
        if (tag.hasKey("type")) {
            currentTip.add("Machine: " + EnumChatFormatting.YELLOW + tag.getString("type"));
        } else {
            currentTip.add("Machine: " + EnumChatFormatting.YELLOW + "None");
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
}
