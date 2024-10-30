package com.science.gtnl.machine;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static com.science.gtnl.Utils.TextLocalization.*;
import static com.science.gtnl.common.block.BasicBlocks.MetaBlockCasing01;
import static gregtech.api.GregTechAPI.*;
import static gregtech.api.enums.HatchElement.InputHatch;
import static gregtech.api.util.GTStructureUtility.buildHatchAdder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
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
import com.gtnewhorizon.structurelib.alignment.IAlignmentLimits;
import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.science.gtnl.Utils.TextLocalization;
import com.science.gtnl.Utils.TextUtils;
import com.science.gtnl.machine.multiMachineClasses.SteamMultiMachineBase;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.MTEHatch;
import gregtech.api.objects.GTRenderedTexture;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.api.util.OverclockCalculator;
import gregtech.common.blocks.BlockCasings1;
import gregtech.common.blocks.BlockCasings2;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;

public class LargeSteamCircuitAssembler extends SteamMultiMachineBase<LargeSteamCircuitAssembler>
    implements ISurvivalConstructable {

    public LargeSteamCircuitAssembler(String aName) {
        super(aName);
    }

    public LargeSteamCircuitAssembler(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new LargeSteamCircuitAssembler(this.mName);
    }

    @Override
    public String getMachineType() {
        return TextLocalization.CircuitAssembler;
    }

    private static final String STRUCTUR_PIECE_MAIN = "main";

    private IStructureDefinition<LargeSteamCircuitAssembler> STRUCTURE_DEFINITION = null;

    private final String[][] shape = new String[][] {
        { " C ", " C ", " C ", " C ", " C ", " C ", " C ", " C ", " C ", " C " },
        { "CBC", "CAC", "CAC", "CAC", "CAC", "CAC", "CAC", "CAC", "CAC", "CBC" },
        { "B~B", "BDB", "BDB", "BDB", "BDB", "BDB", "BDB", "BDB", "BDB", "BBB" },
        { "BBB", "BBB", "BBB", "BBB", "BBB", "BBB", "BBB", "BBB", "BBB", "BBB" } };

    private static final int HORIZONTAL_OFF_SET = 1;
    private static final int VERTICAL_OFF_SET = 2;
    private static final int DEPTH_OFF_SET = 0;

    private boolean isBroken = true;

    private int tierPipeCasing = -1;
    private int tierMachineCasing = -1;
    private int tierMachine = 1;

    private int tCountCasing = 0;

    public int getTierMachineCasing(Block block, int meta) {
        if (block == sBlockCasings1 && 10 == meta) {
            tCountCasing++;
            return 1;
        }
        if (block == sBlockCasings2 && 0 == meta) {
            tCountCasing++;
            return 2;
        }
        return 0;
    }

    public static int getTierPipeCasing(Block block, int meta) {
        if (block == sBlockCasings2 && 12 == meta) return 1;
        if (block == sBlockCasings2 && 13 == meta) return 2;
        return 0;
    }

    protected void updateHatchTexture() {
        for (MTEHatch h : mSteamInputs) h.updateTexture(getCasingTextureID());
        for (MTEHatch h : mSteamOutputs) h.updateTexture(getCasingTextureID());
        for (MTEHatch h : mSteamInputFluids) h.updateTexture(getCasingTextureID());
        for (MTEHatch h : mInputHatches) h.updateTexture(getCasingTextureID());
    }

    private int getCasingTextureID() {
        if (tierPipeCasing == 2 || tierMachineCasing == 2)
            return ((BlockCasings2) GregTechAPI.sBlockCasings2).getTextureIndex(0);
        return ((BlockCasings1) GregTechAPI.sBlockCasings1).getTextureIndex(10);
    }

    @Override
    public void onValueUpdate(byte aValue) {
        tierMachineCasing = aValue;
    }

    @Override
    public byte getUpdateData() {
        return (byte) tierMachineCasing;
    }

    @Override
    protected GTRenderedTexture getFrontOverlay() {
        return new GTRenderedTexture(Textures.BlockIcons.OVERLAY_FRONT_ASSEMBLY_LINE);
    }

    @Override
    protected GTRenderedTexture getFrontOverlayActive() {
        return new GTRenderedTexture(Textures.BlockIcons.OVERLAY_FRONT_ASSEMBLY_LINE_ACTIVE);
    }

    @Override
    public ITexture[] getTexture(final IGregTechTileEntity aBaseMetaTileEntity, final ForgeDirection side,
        final ForgeDirection facing, final int aColorIndex, final boolean aActive, final boolean aRedstone) {
        if (side == facing) {
            return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()),
                aActive ? getFrontOverlayActive() : getFrontOverlay() };
        }
        return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()) };
    }

    @Override
    public IStructureDefinition<LargeSteamCircuitAssembler> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {

            STRUCTURE_DEFINITION = StructureDefinition.<LargeSteamCircuitAssembler>builder()

                .addShape(STRUCTUR_PIECE_MAIN, transpose(shape))
                .addElement('A', ofBlock(MetaBlockCasing01, 1))
                .addElement(
                    'B',
                    ofChain(
                        buildSteamInput(LargeSteamCircuitAssembler.class).casingIndex(10)
                            .dot(1)
                            .allowOnly(ForgeDirection.NORTH)
                            .build(),
                        ofBlocksTiered(
                            this::getTierMachineCasing,
                            ImmutableList.of(Pair.of(sBlockCasings1, 10), Pair.of(sBlockCasings2, 0)),
                            -1,
                            (t, m) -> t.tierMachineCasing = m,
                            t -> t.tierMachineCasing)))
                .addElement(
                    'C',
                    ofChain(
                        buildHatchAdder(LargeSteamCircuitAssembler.class)
                            .atLeast(SteamHatchElement.InputBus_Steam, SteamHatchElement.OutputBus_Steam, InputHatch)
                            .casingIndex(10)
                            .dot(1)
                            .allowOnly(ForgeDirection.NORTH)
                            .buildAndChain(),
                        ofBlocksTiered(
                            this::getTierMachineCasing,
                            ImmutableList.of(Pair.of(sBlockCasings1, 10), Pair.of(sBlockCasings2, 0)),
                            -1,
                            (t, m) -> t.tierMachineCasing = m,
                            t -> t.tierMachineCasing)))
                .addElement(
                    'D',
                    ofBlocksTiered(
                        LargeSteamCircuitAssembler::getTierPipeCasing,
                        ImmutableList.of(Pair.of(sBlockCasings2, 12), Pair.of(sBlockCasings2, 13)),
                        -1,
                        (t, m) -> t.tierPipeCasing = m,
                        t -> t.tierPipeCasing))
                .build();

        }
        return STRUCTURE_DEFINITION;
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        this.buildPiece(STRUCTUR_PIECE_MAIN, stackSize, hintsOnly, HORIZONTAL_OFF_SET, VERTICAL_OFF_SET, DEPTH_OFF_SET);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (this.mMachine) return -1;
        return this.survivialBuildPiece(
            STRUCTUR_PIECE_MAIN,
            stackSize,
            HORIZONTAL_OFF_SET,
            VERTICAL_OFF_SET,
            DEPTH_OFF_SET,
            elementBudget,
            env,
            false,
            true);
    }

    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        tierPipeCasing = -1;
        tierMachineCasing = -1;
        tCountCasing = 0;
        if (!checkPiece(STRUCTUR_PIECE_MAIN, HORIZONTAL_OFF_SET, VERTICAL_OFF_SET, DEPTH_OFF_SET)) return false;
        if (tierPipeCasing < 0 && tierMachineCasing < 0) return false;
        if (tierPipeCasing == 1 && tierMachineCasing == 1 && tCountCasing >= 75 && checkHatches()) {
            updateHatchTexture();
            tierMachine = 1;
            return true;
        }
        if (tierPipeCasing == 2 && tierMachineCasing == 2 && tCountCasing >= 75 && checkHatches()) {
            updateHatchTexture();
            tierMachine = 2;
            return true;
        }
        return false;
    }

    private boolean checkHatches() {
        return !mSteamInputFluids.isEmpty() && !mSteamInputs.isEmpty()
            && !mSteamOutputs.isEmpty()
            && mOutputHatches.isEmpty()
            && !mInputHatches.isEmpty();
    }

    @Override
    public int getMaxParallelRecipes() {
        return 16;
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return RecipeMaps.circuitAssemblerRecipes;
    }

    @NotNull
    @Override
    public Collection<RecipeMap<?>> getAvailableRecipeMaps() {
        return Arrays.asList(RecipeMaps.circuitAssemblerRecipes);
    }

    @Override
    protected ProcessingLogic createProcessingLogic() {

        return new ProcessingLogic() {

            @NotNull
            @Override
            protected CheckRecipeResult validateRecipe(@Nonnull GTRecipe recipe) {
                if (availableVoltage < recipe.mEUt) {
                    return CheckRecipeResultRegistry.insufficientPower(recipe.mEUt);
                } else return CheckRecipeResultRegistry.SUCCESSFUL;
            }

            @Override
            @Nonnull
            protected OverclockCalculator createOverclockCalculator(@NotNull GTRecipe recipe) {
                return OverclockCalculator.ofNoOverclock(recipe)
                    .setEUtDiscount(1.25 * tierMachine)
                    .setSpeedBoost(1.6 / tierMachine);
            }
        }.setMaxParallelSupplier(this::getMaxParallelRecipes);
    }

    @Override
    public int getTierRecipes() {
        return 3;
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType(getMachineType())
            .addInfo("25% faster than using single block steam machines of the same pressure")
            .addInfo("Only consumes steam at 62.5% of the L/s normally required")
            .addInfo("Processes up to 16 items at once")
            .addInfo(TextLocalization.HIGH_PRESSURE_TOOLTIP_NOTICE)
            .addInfo(TextLocalization.Tooltip_LargeSteamCircuitAssembler_0)
            .beginStructureBlock(3, 4, 10, false)
            .addInputBus(EnumChatFormatting.GOLD + "1" + EnumChatFormatting.GRAY + TextLocalization.textAnyCasing, 1)
            .addInputHatch(EnumChatFormatting.GOLD + "1" + EnumChatFormatting.GRAY + TextLocalization.textAnyCasing, 1)
            .addOutputBus(EnumChatFormatting.GOLD + "1" + EnumChatFormatting.GRAY + TextLocalization.textAnyCasing, 1)
            .addStructureInfo(
                EnumChatFormatting.WHITE + TextLocalization.textSteamInputHatch
                    + EnumChatFormatting.GOLD
                    + "1"
                    + EnumChatFormatting.GRAY
                    + TextLocalization.textAnyCasing)
            .addStructureInfo("")
            .addStructureInfo(
                EnumChatFormatting.BLUE + TextLocalization.textBasic
                    + EnumChatFormatting.DARK_PURPLE
                    + TextLocalization.textTier)
            .addStructureInfo(
                EnumChatFormatting.GOLD + "75-83x" + EnumChatFormatting.GRAY + TextLocalization.textBronzePlatedBricks)
            .addStructureInfo(
                EnumChatFormatting.GOLD + "8x" + EnumChatFormatting.GRAY + TextLocalization.textBronzePipeCasing)
            .addStructureInfo(
                EnumChatFormatting.GOLD + "8x" + EnumChatFormatting.GRAY + TextLocalization.textSteamAssemblyCasing)
            .addStructureInfo("")
            .addStructureInfo(
                EnumChatFormatting.BLUE + TextLocalization.textHighPressure
                    + EnumChatFormatting.DARK_PURPLE
                    + TextLocalization.textTier)
            .addStructureInfo(
                EnumChatFormatting.GOLD + "75-83x"
                    + EnumChatFormatting.GRAY
                    + TextLocalization.textSolidSteelMachineCasing)
            .addStructureInfo(
                EnumChatFormatting.GOLD + "8x" + EnumChatFormatting.GRAY + TextLocalization.textSteelPipeCasing)
            .addStructureInfo(
                EnumChatFormatting.GOLD + "8x" + EnumChatFormatting.GRAY + TextLocalization.textSteamAssemblyCasing)
            .toolTipFinisher(TextUtils.SCIENCE_NOT_LEISURE);
        return tt;
    }

    @Override
    public String[] getInfoData() {
        ArrayList<String> info = new ArrayList<>(Arrays.asList(super.getInfoData()));
        info.add("Machine Tier: " + EnumChatFormatting.YELLOW + tierMachine);
        info.add("Parallel: " + EnumChatFormatting.YELLOW + getMaxParallelRecipes());
        return info.toArray(new String[0]);
    }

    @Override
    public void getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
        IWailaConfigHandler config) {
        super.getWailaBody(itemStack, currenttip, accessor, config);
        NBTTagCompound tag = accessor.getNBTData();
        currenttip.add(
            StatCollector.translateToLocal("GTPP.machines.tier") + ": "
                + EnumChatFormatting.YELLOW
                + getSteamTierTextForWaila(tag)
                + EnumChatFormatting.RESET);
        currenttip.add(
            StatCollector.translateToLocal("GT5U.multiblock.curparallelism") + ": "
                + EnumChatFormatting.BLUE
                + tag.getInteger("parallel")
                + EnumChatFormatting.RESET);
    }

    @Override
    public void getWailaNBTData(EntityPlayerMP player, TileEntity tile, NBTTagCompound tag, World world, int x, int y,
        int z) {
        super.getWailaNBTData(player, tile, tag, world, x, y, z);
        tag.setInteger("tierMachine", tierMachine);
        tag.setInteger("parallel", getMaxParallelRecipes());
        tag.setInteger("mode", machineMode);
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
        aNBT.setInteger("tierMachine", tierMachine);
        aNBT.setInteger("mMode", machineMode);
    }

    @Override
    public void loadNBTData(final NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        tierMachine = aNBT.getInteger("tierMachine");
    }

    @Override
    protected IAlignmentLimits getInitialAlignmentLimits() {
        return (d, r, f) -> d.offsetY == 0 && r.isNotRotated();
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);
        if (aBaseMetaTileEntity.isServerSide()) {
            if (mUpdate < -250) mUpdate = 50;
            if ((aTick % 1200) == 0) {
                isBroken = true;
            }
        }
    }
}
