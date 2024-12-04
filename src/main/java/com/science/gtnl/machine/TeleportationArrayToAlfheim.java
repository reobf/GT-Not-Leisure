package com.science.gtnl.machine;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static com.science.gtnl.Utils.TextLocalization.Tooltip_TeleportationArrayToAlfheim_00;
import static com.science.gtnl.common.block.BlockRegister.Gaia_Glass;
import static com.science.gtnl.common.block.BlockRegister.Terra_Glass;
import static gregtech.api.GregTechAPI.*;
import static gregtech.api.enums.HatchElement.*;

import java.util.Arrays;
import java.util.Collection;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.NotNull;

import com.brandon3055.brandonscore.common.handlers.ProcessHandler;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.science.gtnl.Config;
import com.science.gtnl.Utils.StructureUtils;
import com.science.gtnl.Utils.TextLocalization;
import com.science.gtnl.Utils.TextUtils;
import com.science.gtnl.Utils.rewrites.GTNL_ItemID;
import com.science.gtnl.common.RecipeRegister;
import com.science.gtnl.machine.Explosion.PortalToAlfheimExplosion;
import com.science.gtnl.machine.multiMachineClasses.MultiMachineBase;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.objects.GTRenderedTexture;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.util.GTUtility;
import gregtech.api.util.HatchElementBuilder;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.common.blocks.BlockCasings8;
import gtnhlanth.common.register.LanthItemList;
import tectech.thing.casing.TTCasingsContainer;

public class TeleportationArrayToAlfheim extends MultiMachineBase<TeleportationArrayToAlfheim> {

    public byte mode = 1;
    public String[][] shape;
    protected static GTNL_ItemID Bread;

    public static void initStatics() {
        Bread = GTNL_ItemID.createNoNBT(new ItemStack(Items.bread));
    }

    public TeleportationArrayToAlfheim(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
        this.shape = StructureUtils.readStructureFromFile(TATA_STRUCTURE_FILE_PATH);
    }

    public TeleportationArrayToAlfheim(String aName) {
        super(aName);
        this.shape = StructureUtils.readStructureFromFile(TATA_STRUCTURE_FILE_PATH);
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        repairMachine();
        return checkPiece(STRUCTURE_PIECE_MAIN, horizontalOffSet, verticalOffSet, depthOffSet);
    }

    protected float getSpeedBonus() {
        return 1F;
    }

    protected int getMaxParallelRecipes() {
        return 2147483647;
    }

    protected boolean isEnablePerfectOverclock() {
        return false;
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        switch (mode) {
            case 1:
                return RecipeRegister.NatureSpiritArrayRecipes;
            default:
                return RecipeRegister.PortalToAlfheimRecipes;
        }
    }

    @NotNull
    @Override
    public Collection<RecipeMap<?>> getAvailableRecipeMaps() {
        return Arrays.asList(RecipeRegister.NatureSpiritArrayRecipes, RecipeRegister.PortalToAlfheimRecipes);
    }

    @Override
    public final void onScrewdriverRightClick(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ) {
        this.mode = (byte) ((this.mode + 1) % 2);
        GTUtility.sendChatToPlayer(
            aPlayer,
            StatCollector.translateToLocal("TeleportationArrayToAlfheim.modeMsg." + this.mode));
    }

    @NotNull
    @Override
    public CheckRecipeResult checkProcessing() {
        boolean shouldExplode = false;
        long Strength = 0;
        IGregTechTileEntity aBaseMetaTileEntity = getBaseMetaTileEntity();

        for (ItemStack items : getStoredInputs()) {
            if (Bread.equalItemStack(items)) {
                Strength += 50L * items.stackSize;
                shouldExplode = true;
            }
            items.stackSize = 0;
        }

        updateSlots();

        if (Strength > 500) {
            Strength = 500;
        }

        if (shouldExplode) {
            triggerExplosion(aBaseMetaTileEntity, Strength);
        }

        return CheckRecipeResultRegistry.NO_RECIPE;
    }

    public void triggerExplosion(IGregTechTileEntity aBaseMetaTileEntity, float strength) {
        if (Config.enablePortalToAlfheimBigBoom) {
            float power = strength;
            ProcessHandler.addProcess(
                new PortalToAlfheimExplosion(
                    aBaseMetaTileEntity.getWorld(),
                    aBaseMetaTileEntity.getXCoord(),
                    aBaseMetaTileEntity.getYCoord(),
                    aBaseMetaTileEntity.getZCoord(),
                    power));
        } else {
            triggerExplosion(aBaseMetaTileEntity, 5);
        }
        aBaseMetaTileEntity.getWorld()
            .setBlockToAir(
                aBaseMetaTileEntity.getXCoord(),
                aBaseMetaTileEntity.getYCoord(),
                aBaseMetaTileEntity.getZCoord());
        World world = aBaseMetaTileEntity.getWorld();
        int x = aBaseMetaTileEntity.getXCoord();
        int y = aBaseMetaTileEntity.getYCoord();
        int z = aBaseMetaTileEntity.getZCoord();
        world.createExplosion(null, x, y, z, strength * 20, true);
    }

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

    public static final String STRUCTURE_PIECE_MAIN = "main";
    public static final String TATA_STRUCTURE_FILE_PATH = "sciencenotleisure:multiblock/teleportation_array_to_alfheim"; // 文件路径
    public final int horizontalOffSet = 11;
    public final int verticalOffSet = 15;
    public final int depthOffSet = 2;
    public static IStructureDefinition<TeleportationArrayToAlfheim> STRUCTURE_DEFINITION = null;

    @Override
    public IStructureDefinition<TeleportationArrayToAlfheim> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<TeleportationArrayToAlfheim>builder()
                .addShape(STRUCTURE_PIECE_MAIN, transpose(shape))
                .addElement('A', ofBlock(LanthItemList.SHIELDED_ACCELERATOR_CASING, 0))
                .addElement('B', ofBlock(sBlockCasings10, 3))
                .addElement('C', ofBlock(sBlockCasings4, 7))
                .addElement('D', ofBlock(sBlockCasings8, 7))
                .addElement(
                    'E',
                    HatchElementBuilder.<TeleportationArrayToAlfheim>builder()
                        .atLeast(InputBus, OutputBus, InputHatch, Energy.or(ExoticEnergy))
                        .adder(TeleportationArrayToAlfheim::addToMachineList)
                        .dot(1)
                        .casingIndex(((BlockCasings8) GregTechAPI.sBlockCasings8).getTextureIndex(10))
                        .buildAndChain(GregTechAPI.sBlockCasings8, 10))
                .addElement('F', ofBlock(TTCasingsContainer.sBlockCasingsTT, 0))
                .addElement('G', ofBlock(Gaia_Glass, 0))
                .addElement('H', ofBlock(Terra_Glass, 0))
                .build();
        }
        return STRUCTURE_DEFINITION;
    }

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
        tt.addMachineType(TextLocalization.TeleportationArrayToAlfheimRecipeType)
            .addInfo(Tooltip_TeleportationArrayToAlfheim_00)
            .addSeparator()
            .addInfo(TextLocalization.StructureTooComplex)
            .addInfo(TextLocalization.BLUE_PRINT_INFO)
            .beginStructureBlock(23, 18, 23, false)
            .addInputHatch(TextLocalization.textUseBlueprint, 1)
            .addInputBus(TextLocalization.textUseBlueprint, 1)
            .addOutputBus(TextLocalization.textUseBlueprint, 1)
            .toolTipFinisher(TextUtils.SCIENCE_NOT_LEISURE);
        return tt;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new TeleportationArrayToAlfheim(this.mName);
    }

    public int getCasingTextureID() {
        return ((BlockCasings8) GregTechAPI.sBlockCasings8).getTextureIndex(10);
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
}
