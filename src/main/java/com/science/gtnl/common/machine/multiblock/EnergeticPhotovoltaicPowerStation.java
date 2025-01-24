package com.science.gtnl.common.machine.multiblock;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static gregtech.api.GregTechAPI.*;
import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.enums.Mods.*;
import static gregtech.api.enums.Textures.BlockIcons.*;
import static gregtech.api.util.GTStructureUtility.buildHatchAdder;
import static gregtech.api.util.GTStructureUtility.ofFrame;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.science.gtnl.Utils.StructureUtils;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.MTEEnhancedMultiBlockBase;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GTUtility;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.common.blocks.BlockCasings2;

public class EnergeticPhotovoltaicPowerStation extends MTEEnhancedMultiBlockBase<EnergeticPhotovoltaicPowerStation>
    implements ISurvivalConstructable {

    private int mCasing;
    protected int fuelConsumption;

    private static IStructureDefinition<EnergeticPhotovoltaicPowerStation> STRUCTURE_DEFINITION = null;
    public static final String STRUCTURE_PIECE_MAIN = "main";
    public static String[][] shape;
    public static final String EPPS_STRUCTURE_FILE_PATH = "sciencenotleisure:multiblock/energetic_photovoltaic_power_station";
    public final int horizontalOffSet = 4;
    public final int verticalOffSet = 4;
    public final int depthOffSet = 2;
    protected static final int CASING_INDEX = ((BlockCasings2) sBlockCasings2).getTextureIndex(0);

    public EnergeticPhotovoltaicPowerStation(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
        shape = StructureUtils.readStructureFromFile(EPPS_STRUCTURE_FILE_PATH);
    }

    public EnergeticPhotovoltaicPowerStation(String aName) {
        super(aName);
        shape = StructureUtils.readStructureFromFile(EPPS_STRUCTURE_FILE_PATH);
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        final MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType("test")
            .toolTipFinisher();
        return tt;
    }

    @Override
    public IStructureDefinition<EnergeticPhotovoltaicPowerStation> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<EnergeticPhotovoltaicPowerStation>builder()
                .addShape(STRUCTURE_PIECE_MAIN, transpose(shape))
                .addElement(
                    'A',
                    buildHatchAdder(EnergeticPhotovoltaicPowerStation.class).casingIndex(CASING_INDEX)
                        .dot(1)
                        .atLeast(InputHatch, Dynamo, Maintenance)
                        .buildAndChain(onElementPass(x -> ++x.mCasing, ofBlock(sBlockCasings2, 0))))
                .addElement('B', ofFrame(Materials.StainlessSteel))
                .addElement(
                    'D',
                    ofBlock(
                        AdvancedSolarPanel.isModLoaded()
                            ? GameRegistry.findBlock(AdvancedSolarPanel.ID, "BlockAdvSolarPanel")
                            : GameRegistry.findBlock(IndustrialCraft2.ID, "blockAlloyGlass"),
                        0))
                .build();
        }
        return STRUCTURE_DEFINITION;
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, ForgeDirection side, ForgeDirection aFacing,
        int colorIndex, boolean aActive, boolean redstoneLevel) {
        if (side == aFacing) {
            if (aActive) return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_DIESEL_ENGINE_ACTIVE)
                    .extFacing()
                    .build(),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_DIESEL_ENGINE_ACTIVE_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
            return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_DIESEL_ENGINE)
                    .extFacing()
                    .build(),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_DIESEL_ENGINE_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
        }
        return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()) };
    }

    public int getCasingTextureID() {
        return CASING_INDEX;
    }

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return getMaxEfficiency(aStack) > 0;
    }

    @Override
    @NotNull
    public CheckRecipeResult checkProcessing() {
        ArrayList<FluidStack> tFluids = getStoredFluids();

        if (!tFluids.isEmpty()) {
            for (FluidStack tFluid : tFluids) {

                if (tFluid.getFluid()
                    .getName()
                    .equals("ic2distilledwater")) {

                    boolean notAirBlocks = false;
                    IGregTechTileEntity baseTileEntity = this.getBaseMetaTileEntity();
                    int xCoord = baseTileEntity.getXCoord();
                    int yCoord = baseTileEntity.getYCoord();
                    int zCoord = baseTileEntity.getZCoord();

                    ForgeDirection front = baseTileEntity.getFrontFacing();

                    int xStart = xCoord - (front.offsetX * 2) + 4;
                    int xEnd = xCoord - 4;
                    int yStart = yCoord + 5;
                    int yEnd = yCoord + 55;
                    int zStart = zCoord + 4 - (front.offsetZ * 6);
                    int zEnd = zCoord - 4 + (front.offsetZ * 8);

                    for (int x = xStart; x >= xEnd; x--) {
                        for (int y = yStart; y <= yEnd; y++) {
                            for (int z = zStart; z >= zEnd; z--) {
                                if (!this.getBaseMetaTileEntity()
                                    .getWorld()
                                    .isAirBlock(x, y, z)) {
                                    notAirBlocks = true;
                                    break;
                                }
                            }
                            if (notAirBlocks) break;
                        }
                        if (notAirBlocks) break;
                    }

                    boolean isRaining = this.getBaseMetaTileEntity()
                        .getWorld()
                        .isRaining();

                    int output = 896;
                    if (notAirBlocks) {
                        output = 498;
                    }
                    if (isRaining) {
                        output = 0;
                    }

                    int waterConsumption = output / 4;
                    fuelConsumption = waterConsumption;

                    FluidStack consumedWater = tFluid.copy();
                    consumedWater.amount = waterConsumption;

                    if (!depleteInput(consumedWater)) {
                        return CheckRecipeResultRegistry.NO_FUEL_FOUND;
                    }

                    tFluid.amount -= waterConsumption;
                    if (tFluid.amount < 0) tFluid.amount = 0;

                    this.mEUt = output;
                    this.mEfficiency = 10000;
                    this.mProgresstime = 0;
                    this.mMaxProgresstime = 128;
                    return CheckRecipeResultRegistry.GENERATING;
                }
            }
        }
        this.mEUt = 0;
        this.mEfficiency = 0;
        return CheckRecipeResultRegistry.NO_FUEL_FOUND;
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        return checkPiece(STRUCTURE_PIECE_MAIN, horizontalOffSet, verticalOffSet, depthOffSet)
            && mMaintenanceHatches.size() == 1
            && mCasing >= 8;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new EnergeticPhotovoltaicPowerStation(this.mName);
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
    }

    @Override
    public int getDamageToComponent(ItemStack aStack) {
        return 1;
    }

    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }

    @Override
    public boolean explodesOnComponentBreak(ItemStack aStack) {
        return false;
    }

    @Override
    public String[] getInfoData() {
        return new String[] {
            StatCollector.translateToLocal("GT5U.engine.output") + ": "
                + EnumChatFormatting.RED
                + GTUtility.formatNumbers(mEUt)
                + EnumChatFormatting.RESET
                + " EU/t",
            StatCollector.translateToLocal("GT5U.engine.consumption") + ": "
                + EnumChatFormatting.YELLOW
                + GTUtility.formatNumbers(fuelConsumption)
                + EnumChatFormatting.RESET
                + " L/t" };
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
}
