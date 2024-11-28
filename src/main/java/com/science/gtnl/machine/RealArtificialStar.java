package com.science.gtnl.machine;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static com.science.gtnl.Utils.TextHandler.texter;
import static com.science.gtnl.Utils.TextLocalization.*;
import static com.science.gtnl.Utils.Utils.copyAmount;
import static com.science.gtnl.common.GTNLItemList.StellarConstructionFrameMaterial;
import static com.science.gtnl.machine.DSP.DSP_Values.EnableRenderDefaultArtificialStar;
import static com.science.gtnl.machine.DSP.DSP_Values.secondsOfArtificialStarProgressCycleTime;
import static goodgenerator.loader.Loaders.compactFusionCoil;
import static gregtech.api.GregTechAPI.*;
import static gregtech.api.enums.HatchElement.InputBus;
import static gregtech.api.enums.HatchElement.OutputBus;
import static gregtech.api.enums.Textures.BlockIcons.*;
import static gregtech.common.misc.WirelessNetworkManager.addEUToGlobalEnergyMap;
import static tectech.thing.casing.TTCasingsContainer.*;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

import com.google.common.collect.ImmutableList;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.science.gtnl.Utils.StructureUtils;
import com.science.gtnl.Utils.TextLocalization;
import com.science.gtnl.Utils.TextUtils;
import com.science.gtnl.Utils.Utils;
import com.science.gtnl.Utils.rewrites.GTNL_ItemID;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.block.BasicBlocks;
import com.science.gtnl.config.Config;
import com.science.gtnl.machine.multiMachineClasses.MultiMachineBase;

import galaxyspace.core.register.GSBlocks;
import gregtech.api.GregTechAPI;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.interfaces.tileentity.IWirelessEnergyHatchInformation;
import gregtech.api.objects.XSTR;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GTUtility;
import gregtech.api.util.HatchElementBuilder;
import gregtech.api.util.MultiblockTooltipBuilder;
import gtnhlanth.common.register.LanthItemList;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import tectech.thing.block.BlockQuantumGlass;
import tectech.thing.casing.TTCasingsContainer;

public class RealArtificialStar extends MultiMachineBase<RealArtificialStar>
    implements IWirelessEnergyHatchInformation {

    public static final String STRUCTURE_PIECE_MAIN = "main";
    public IStructureDefinition<RealArtificialStar> STRUCTURE_DEFINITION = null;
    public static final String RAS_STRUCTURE_FILE_PATH = "sciencenotleisure:multiblock/real_artificial_star";
    public String[][] shape;

    // region Class Constructor
    public RealArtificialStar(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
        this.shape = StructureUtils.readStructureFromFile(RAS_STRUCTURE_FILE_PATH);
    }

    public RealArtificialStar(String aName) {
        super(aName);
        this.shape = StructureUtils.readStructureFromFile(RAS_STRUCTURE_FILE_PATH);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new RealArtificialStar(this.mName);
    }

    // endregion

    // region Statics
    protected static GTNL_ItemID Antimatter;
    protected static GTNL_ItemID AntimatterFuelRod;
    protected static GTNL_ItemID StrangeAnnihilationFuelRod;
    protected static long MaxOfAntimatter;
    protected static long MaxOfAntimatterFuelRod;
    protected static long MaxOfStrangeAnnihilationFuelRod;

    public static void initStatics() {
        Antimatter = GTNL_ItemID.createNoNBT(GTNLItemList.Antimatter.get(1));
        AntimatterFuelRod = GTNL_ItemID.createNoNBT(GTNLItemList.AntimatterFuelRod.get(1));
        StrangeAnnihilationFuelRod = GTNL_ItemID.createNoNBT(GTNLItemList.StrangeAnnihilationFuelRod.get(1));
        MaxOfAntimatter = Config.EUEveryAntimatter / Integer.MAX_VALUE;
        MaxOfAntimatterFuelRod = Config.EUEveryAntimatterFuelRod / Integer.MAX_VALUE;
        MaxOfStrangeAnnihilationFuelRod = Config.EUEveryStrangeAnnihilationFuelRod / Integer.MAX_VALUE;
    }

    // endregion

    // region Processing Logic
    public String ownerName;
    public UUID ownerUUID;
    public long storageEU = 0;
    public int tierDimensionField = -1;
    public int tierTimeField = -1;
    public int tierStabilisationField = -1;
    public double outputMultiplier = 1;
    public short recoveryChance = 0;
    public byte rewardContinuous = 0;
    public long currentOutputEU = 0;
    public final DecimalFormat decimalFormat = new DecimalFormat("#.0");
    public boolean isRendering = false;
    public byte enableRender = EnableRenderDefaultArtificialStar;

    @Override
    public void getWailaBody(ItemStack itemStack, List<String> currentTip, IWailaDataAccessor accessor,
        IWailaConfigHandler config) {
        super.getWailaBody(itemStack, currentTip, accessor, config);
        final NBTTagCompound tag = accessor.getNBTData();
        if (tag.getBoolean("isActive")) {
            currentTip.add(
                EnumChatFormatting.AQUA + texter("Current Generating : ", "Waila.RealArtificialStar.1")
                    + EnumChatFormatting.GOLD
                    + tag.getLong("currentOutputEU")
                    + EnumChatFormatting.RED
                    + " * "
                    + decimalFormat.format(tag.getDouble("outputMultiplier"))
                    + EnumChatFormatting.GREEN
                    + " * 2147483647"
                    + EnumChatFormatting.RESET
                    + " EU / "
                    + secondsOfArtificialStarProgressCycleTime
                    + " s");
        }
    }

    @Override
    public void getWailaNBTData(EntityPlayerMP player, TileEntity tile, NBTTagCompound tag, World world, int x, int y,
        int z) {
        super.getWailaNBTData(player, tile, tag, world, x, y, z);
        final IGregTechTileEntity tileEntity = getBaseMetaTileEntity();
        if (tileEntity != null) {
            if (tileEntity.isActive()) {
                tag.setLong("currentOutputEU", currentOutputEU);
                tag.setDouble("outputMultiplier", (outputMultiplier * (rewardContinuous + 100) / 100));
            }
        }
    }

    @Override
    public String[] getInfoData() {
        // spotless:off
        String[] origin = super.getInfoData();
        String[] ret = new String[origin.length + 6];
        System.arraycopy(origin, 0, ret, 0, origin.length);
        ret[origin.length] = EnumChatFormatting.GOLD+texter("Reward for continuous operation","RealArtificialStar.getInfoData.00")+EnumChatFormatting.RESET+": "+EnumChatFormatting.GREEN+(rewardContinuous+100)+"%";
        ret[origin.length + 1] = EnumChatFormatting.GOLD+texter("Generating Multiplier","RealArtificialStar.getInfoData.01")+EnumChatFormatting.RESET+": "+EnumChatFormatting.GREEN+outputMultiplier;
        ret[origin.length + 2] = EnumChatFormatting.GOLD+texter("Dimension Field Tier","RealArtificialStar.getInfoData.02")+EnumChatFormatting.RESET+": "+EnumChatFormatting.YELLOW+tierDimensionField;
        ret[origin.length + 3] = EnumChatFormatting.GOLD+texter("Time Field Tier","RealArtificialStar.getInfoData.03")+EnumChatFormatting.RESET+": "+EnumChatFormatting.YELLOW+tierTimeField;
        ret[origin.length + 4] = EnumChatFormatting.GOLD+texter("Stabilisation Field Tier","RealArtificialStar.getInfoData.04")+EnumChatFormatting.RESET+": "+EnumChatFormatting.YELLOW+tierStabilisationField;
        ret[origin.length + 5] = EnumChatFormatting.GOLD+texter("Recover material chance","RealArtificialStar.getInfoData.05")+EnumChatFormatting.RESET+": "+EnumChatFormatting.AQUA+recoveryChance+EnumChatFormatting.RESET+"/"+EnumChatFormatting.AQUA+"1000";
        return ret;
       // spotless:on
    }

    @Override
    public final void onScrewdriverRightClick(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ) {
        if (getBaseMetaTileEntity().isServerSide()) {
            this.enableRender = (byte) ((this.enableRender + 1) % 2);
            GTUtility.sendChatToPlayer(
                aPlayer,
                StatCollector.translateToLocal("ArtificialStar.enableRender." + this.enableRender));
            if (enableRender == 0 && isRendering) {
                destroyRenderBlock();
                isRendering = false;
            }
        }
    }

    @NotNull
    @Override
    public CheckRecipeResult checkProcessing() {
        // iterate input bus slot
        // consume fuel and generate EU
        boolean flag = false;
        long recoveryAmount = 0;
        // * Integer.MAX_VALUE
        currentOutputEU = 0;
        for (ItemStack items : getStoredInputs()) {
            if (Antimatter.equalItemStack(items)) {
                currentOutputEU += MaxOfAntimatter * items.stackSize;
                flag = true;
            } else if (AntimatterFuelRod.equalItemStack(items)) {
                currentOutputEU += MaxOfAntimatterFuelRod * items.stackSize;
                recoveryAmount += items.stackSize;
                flag = true;
            } else if (StrangeAnnihilationFuelRod.equalItemStack(items)) {
                currentOutputEU += MaxOfStrangeAnnihilationFuelRod * items.stackSize;
                recoveryAmount += items.stackSize;
                flag = true;
            }
            // whether the item is fuel
            // void it
            items.stackSize = 0;
        }

        // flush input slots
        updateSlots();

        // if no antimatter or fuel rod input
        if (!flag) {
            // set 0 to multiplier of rewarding continuous operation
            rewardContinuous = 0;
            // stop render
            if (isRendering) {
                destroyRenderBlock();
                isRendering = false;
            }
            return CheckRecipeResultRegistry.NO_RECIPE;
        }

        // add EU to the wireless EU net
        BigInteger eu = BigInteger
            .valueOf((long) (currentOutputEU * outputMultiplier * ((rewardContinuous + 100d) / 100d)))
            .multiply(Utils.INTEGER_MAX_VALUE);
        if (!addEUToGlobalEnergyMap(ownerUUID, eu)) {
            return CheckRecipeResultRegistry.INTERNAL_ERROR;
        }

        // set progress time with cfg
        mMaxProgresstime = (int) (20 * secondsOfArtificialStarProgressCycleTime);
        // chance to recover FrameMaterial
        if (recoveryChance == 1000) {
            if (recoveryAmount > 0) {
                mOutputItems = getRecovers(recoveryAmount);
            }
        } else if (XSTR.XSTR_INSTANCE.nextInt(1000) < recoveryChance) {
            if (recoveryAmount > 0) {
                mOutputItems = getRecovers(recoveryAmount);
            }
        }

        // increase multiplier of rewarding continuous operation
        if (rewardContinuous < 50) rewardContinuous++;

        // start render
        if (enableRender != 0 && !isRendering) {
            createRenderBlock();
            isRendering = true;
        }
        return CheckRecipeResultRegistry.GENERATING;
    }

    protected ItemStack[] getRecovers(long amount) {
        if (amount <= Integer.MAX_VALUE) {
            return new ItemStack[] { StellarConstructionFrameMaterial.get((int) amount) };
        } else {
            int stack = (int) (amount / Integer.MAX_VALUE);
            int remainder = (int) (amount % Integer.MAX_VALUE);
            ItemStack[] r = new ItemStack[remainder > 0 ? stack + 1 : stack];
            ItemStack t = StellarConstructionFrameMaterial.get(Integer.MAX_VALUE);
            for (int i = 0; i < stack; i++) {
                r[i] = t.copy();
            }
            if (remainder > 0) r[stack] = copyAmount(remainder, t);
            return r;
        }
    }

    // Artificial Star Output multiplier
    public void calculateOutputMultiplier() {
        // tTime^0.25 * tDim^0.25 * 1.588186^(tStabilisation-2)
        // (100^0.25)*(1.588186^(10-2))) = 128.000
        // 1.588186^(-1) = 0.629
        this.outputMultiplier = Math.pow(1d * tierTimeField * tierDimensionField, 0.25d)
            * Math.pow(1.588186d, tierStabilisationField - 2);
    }

    @Override
    public void onFirstTick(IGregTechTileEntity aBaseMetaTileEntity) {
        super.onFirstTick(aBaseMetaTileEntity);
        if (aBaseMetaTileEntity.isServerSide()) {
            this.ownerName = aBaseMetaTileEntity.getOwnerName();
            this.ownerUUID = aBaseMetaTileEntity.getOwnerUuid();
        }
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);
        if (isRendering && mMaxProgresstime == 0 && rewardContinuous == 0) {
            isRendering = false;
            destroyRenderBlock();
        }
        if (rewardContinuous != 0 && mMaxProgresstime == 0) rewardContinuous = 0;
    }

    @Override
    public void onBlockDestroyed() {
        if (isRendering) {
            isRendering = false;
            destroyRenderBlock();
        }
        super.onBlockDestroyed();
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
        aNBT.setLong("storageEU", storageEU);
        aNBT.setInteger("tierDimensionField", tierDimensionField);
        aNBT.setInteger("tierTimeField", tierTimeField);
        aNBT.setInteger("tierStabilisationField", tierStabilisationField);
        aNBT.setDouble("outputMultiplier", outputMultiplier);
        aNBT.setByte("rewardContinuous", rewardContinuous);
        aNBT.setLong("currentOutputEU", currentOutputEU);
        aNBT.setBoolean("isRendering", isRendering);
        aNBT.setByte("enableRender", enableRender);
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        storageEU = aNBT.getLong("storageEU");
        tierDimensionField = aNBT.getInteger("tierDimensionField");
        tierTimeField = aNBT.getInteger("tierTimeField");
        tierStabilisationField = aNBT.getInteger("tierStabilisationField");
        outputMultiplier = aNBT.getDouble("outputMultiplier");
        rewardContinuous = aNBT.getByte("rewardContinuous");
        currentOutputEU = aNBT.getLong("currentOutputEU");
        isRendering = aNBT.getBoolean("isRendering");
        enableRender = aNBT.getByte("enableRender");
    }

    // endregion

    // region Structure
    // spotless:off
    // disable crafting input bus/buffer
    @Override
    protected boolean supportsCraftingMEBuffer() {
        return false;
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        repairMachine();
        mInputBusses.clear();
        tierDimensionField = -1;
        tierTimeField = -1;
        tierStabilisationField = -1;
        if (!checkPiece(STRUCTURE_PIECE_MAIN, horizontalOffSet, verticalOffSet, depthOffSet)) return false;
        if (tierDimensionField < 0 || tierTimeField < 0 || tierStabilisationField < 0) return false;
        // Only allow and must be 1 input bus
        if (this.mInputBusses.size() != 1) return false;
        calculateOutputMultiplier();
        recoveryChance = (short) (tierDimensionField * tierTimeField * tierStabilisationField);
        return true;
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, horizontalOffSet, verticalOffSet, depthOffSet);
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

    public final int horizontalOffSet = 62;
    public final int verticalOffSet = 88;
    public final int depthOffSet = 15;

    @Override
    public IStructureDefinition<RealArtificialStar> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<RealArtificialStar>builder()
                .addShape(STRUCTURE_PIECE_MAIN, transpose(shape))
                .addElement(
                    'A',
                    withChannel(
                        "tiertimefield",
                        ofBlocksTiered(
                            RealArtificialStar::getTierTimeFieldBlockFromBlock,
                            ImmutableList.of(
                                Pair.of(sBlockCasingsTT, 14),
                                Pair.of(TTCasingsContainer.TimeAccelerationFieldGenerator, 0),
                                Pair.of(TTCasingsContainer.TimeAccelerationFieldGenerator, 1),
                                Pair.of(TTCasingsContainer.TimeAccelerationFieldGenerator, 2),
                                Pair.of(TTCasingsContainer.TimeAccelerationFieldGenerator, 3),
                                Pair.of(TTCasingsContainer.TimeAccelerationFieldGenerator, 4),
                                Pair.of(TTCasingsContainer.TimeAccelerationFieldGenerator, 5),
                                Pair.of(TTCasingsContainer.TimeAccelerationFieldGenerator, 6),
                                Pair.of(TTCasingsContainer.TimeAccelerationFieldGenerator, 7),
                                Pair.of(TTCasingsContainer.TimeAccelerationFieldGenerator, 8)),
                            -1,
                            (t, m) -> t.tierTimeField = m,
                            t -> t.tierTimeField)))
                .addElement('B', ofBlock(LanthItemList.SHIELDED_ACCELERATOR_CASING, 0))
                .addElement('C', ofBlock(compactFusionCoil, 4))
                .addElement(
                    'D',
                    HatchElementBuilder.<RealArtificialStar>builder()
                        .atLeast(InputBus, OutputBus)
                        .adder(RealArtificialStar::addInputBusOrOutputBusToMachineList)
                        .dot(1)
                        .casingIndex(13)
                        .buildAndChain(sBlockCasings1, 13))
                .addElement(
                    'E',
                    withChannel(
                        "tierdimensionfield",
                        ofBlocksTiered(
                            RealArtificialStar::getTierDimensionFieldBlockFromBlock,
                            ImmutableList.of(
                                Pair.of(GregTechAPI.sBlockCasings1, 14),
                                Pair.of(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 0),
                                Pair.of(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 1),
                                Pair.of(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 2),
                                Pair.of(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 3),
                                Pair.of(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 4),
                                Pair.of(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 5),
                                Pair.of(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 6),
                                Pair.of(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 7),
                                Pair.of(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 8)),
                            -1,
                            (t, m) -> t.tierDimensionField = m,
                            t -> t.tierDimensionField)))
                .addElement('F', ofBlock(sBlockCasings10, 11))
                .addElement('G', ofBlock(sBlockCasings8, 10))
                .addElement(
                    'H',
                    withChannel(
                        "tierstabilisationfield",
                        ofBlocksTiered(
                            RealArtificialStar::getTierStabilisationFieldBlockFromBlock,
                            ImmutableList.of(
                                Pair.of(sBlockCasingsTT, 9),
                                Pair.of(StabilisationFieldGenerators, 0),
                                Pair.of(StabilisationFieldGenerators, 1),
                                Pair.of(StabilisationFieldGenerators, 2),
                                Pair.of(StabilisationFieldGenerators, 3),
                                Pair.of(StabilisationFieldGenerators, 4),
                                Pair.of(StabilisationFieldGenerators, 5),
                                Pair.of(StabilisationFieldGenerators, 6),
                                Pair.of(StabilisationFieldGenerators, 7),
                                Pair.of(StabilisationFieldGenerators, 8)),
                            -1,
                            (t, m) -> t.tierStabilisationField = m,
                            t -> t.tierStabilisationField)))
                .addElement('I', ofBlock(GSBlocks.DysonSwarmBlocks, 0))
                .addElement('J', ofBlock(GSBlocks.DysonSwarmBlocks, 5))
                .addElement('K', ofBlock(GSBlocks.DysonSwarmBlocks, 8))
                .addElement('L', ofBlock(BlockQuantumGlass.INSTANCE, 0))
                .build();
        }
        return STRUCTURE_DEFINITION;
    }

    public static int getTierDimensionFieldBlockFromBlock(Block block, int meta) {
        if (block == GregTechAPI.sBlockCasings1 && 14 == meta) return 1;
        if (block == SpacetimeCompressionFieldGenerators) return meta + 2;
        return -1;
    }

    public static int getTierTimeFieldBlockFromBlock(Block block, int meta) {
        if (block == sBlockCasingsTT && 14 == meta) return 1;
        if (block == TimeAccelerationFieldGenerator) return meta + 2;
        return -1;
    }

    public static int getTierStabilisationFieldBlockFromBlock(Block block, int meta) {
        if (block == sBlockCasingsTT && 9 == meta) return 1;
        if (block == StabilisationFieldGenerators) return meta + 2;
        return -1;
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        final MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType(Tooltip_RealArtificialStar_MachineType)
            .addInfo(Tooltip_RealArtificialStar_Controller)
            .addInfo(Tooltip_RealArtificialStar_00)
            .addInfo(Tooltip_RealArtificialStar_01)
            .addInfo(Tooltip_RealArtificialStar_02)
            .addInfo(Tooltip_RealArtificialStar_03)
            .addInfo(Tooltip_RealArtificialStar_04)
            .addInfo(Tooltip_RealArtificialStar_05)
            .addInfo(Tooltip_RealArtificialStar_06)
            .addInfo(Tooltip_RealArtificialStar_07)
            .addInfo(Tooltip_RealArtificialStar_08)
            .addInfo(Tooltip_RealArtificialStar_09)
            .addSeparator()
            .addInfo(TextLocalization.StructureTooComplex)
            .addInfo(TextLocalization.BLUE_PRINT_INFO)
            .beginStructureBlock(121, 112, 109, false)
            .addStructureInfo(Tooltip_RealArtificialStar_02_01)
            .addStructureInfo(Tooltip_RealArtificialStar_02_02)
            .addStructureInfo(Tooltip_RealArtificialStar_02_03)
            .addStructureInfo(Tooltip_RealArtificialStar_02_04)
            .addStructureInfo(Tooltip_RealArtificialStar_02_05)
            .addStructureInfo(Tooltip_RealArtificialStar_02_06)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_01)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_02)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_03)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_04)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_05)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_06)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_07)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_08)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_09)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_10)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_11)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_12)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_13)
            .addStructureInfo(Tooltip_RealArtificialStarInfo_14)
            .toolTipFinisher(TextUtils.SRP);
        return tt;
    }

    @Override
    protected boolean isEnablePerfectOverclock() {
        return false;
    }

    @Override
    protected float getSpeedBonus() {
        return 1;
    }

    @Override
    protected int getMaxParallelRecipes() {
        return 1;
    }

    @Override
    public boolean supportsVoidProtection() {
        return false;
    }

    @Override
    public boolean supportsInputSeparation() {
        return false;
    }

    @Override
    public boolean supportsSingleRecipeLocking() {
        return false;
    }

    @Override
    public boolean supportsBatchMode() {
        return false;
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, ForgeDirection side, ForgeDirection aFacing,
        int colorIndex, boolean aActive, boolean redstoneLevel) {
        if (side == aFacing) {
            if (aActive) {
                return new ITexture[] { casingTexturePages[0][12], TextureFactory.builder()
                    .addIcon(OVERLAY_DTPF_ON)
                    .extFacing()
                    .build(),
                    TextureFactory.builder()
                        .addIcon(OVERLAY_FUSION1_GLOW)
                        .extFacing()
                        .glow()
                        .build() };
            }

            return new ITexture[] { casingTexturePages[0][12], TextureFactory.builder()
                .addIcon(OVERLAY_DTPF_OFF)
                .extFacing()
                .build() };
        }

        return new ITexture[] { casingTexturePages[0][12] };
    }

    public void createRenderBlock() {
        int x = getBaseMetaTileEntity().getXCoord();
        int y = getBaseMetaTileEntity().getYCoord();
        int z = getBaseMetaTileEntity().getZCoord();

        double xOffset = 40 * getExtendedFacing().getRelativeBackInWorld().offsetX
            + 36 * getExtendedFacing().getRelativeUpInWorld().offsetX;
        double zOffset = 40 * getExtendedFacing().getRelativeBackInWorld().offsetZ
            + 36 * getExtendedFacing().getRelativeUpInWorld().offsetZ;
        double yOffset = 40 * getExtendedFacing().getRelativeBackInWorld().offsetY
            + 36 * getExtendedFacing().getRelativeUpInWorld().offsetY;

        this.getBaseMetaTileEntity()
            .getWorld()
            .setBlock((int) (x + xOffset), (int) (y + yOffset), (int) (z + zOffset), Blocks.air);
        this.getBaseMetaTileEntity()
            .getWorld()
            .setBlock((int) (x + xOffset), (int) (y + yOffset), (int) (z + zOffset), BasicBlocks.BlockStar);
    }

    public void destroyRenderBlock() {
        int x = getBaseMetaTileEntity().getXCoord();
        int y = getBaseMetaTileEntity().getYCoord();
        int z = getBaseMetaTileEntity().getZCoord();

        double xOffset = 40 * getExtendedFacing().getRelativeBackInWorld().offsetX
            + 36 * getExtendedFacing().getRelativeUpInWorld().offsetX;
        double zOffset = 40 * getExtendedFacing().getRelativeBackInWorld().offsetZ
            + 36 * getExtendedFacing().getRelativeUpInWorld().offsetZ;
        double yOffset = 40 * getExtendedFacing().getRelativeBackInWorld().offsetY
            + 36 * getExtendedFacing().getRelativeUpInWorld().offsetY;

        this.getBaseMetaTileEntity()
            .getWorld()
            .setBlock((int) (x + xOffset), (int) (y + yOffset), (int) (z + zOffset), Blocks.air);
    }
}
