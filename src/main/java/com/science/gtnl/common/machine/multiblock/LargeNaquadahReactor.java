package com.science.gtnl.common.machine.multiblock;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static com.science.gtnl.common.block.Casings.BasicBlocks.MetaCasing;
import static gregtech.api.GregTechAPI.sBlockCasings8;
import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.enums.Textures.BlockIcons.NAQUADAH_REACTOR_SOLID_FRONT;
import static gregtech.api.enums.Textures.BlockIcons.NAQUADAH_REACTOR_SOLID_FRONT_ACTIVE;
import static gregtech.api.util.GTStructureUtility.buildHatchAdder;
import static gregtech.api.util.GTStructureUtility.ofFrame;
import static gtPlusPlus.core.block.ModBlocks.blockCasings4Misc;
import static tectech.thing.casing.TTCasingsContainer.sBlockCasingsTT;
import static tectech.thing.metaTileEntity.multi.base.TTMultiblockBase.HatchElement.DynamoMulti;

import java.math.BigInteger;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.alignment.constructable.IConstructable;
import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.science.gtnl.Utils.StructureUtils;
import com.science.gtnl.Utils.item.TextLocalization;
import com.science.gtnl.Utils.item.TextUtils;

import gregtech.api.enums.Materials;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.MTEHatchDynamo;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.api.util.shutdown.ShutDownReasonRegistry;
import gregtech.common.blocks.BlockCasings8;
import tectech.thing.metaTileEntity.hatch.MTEHatchDynamoMulti;
import tectech.thing.metaTileEntity.multi.base.TTMultiblockBase;

public class LargeNaquadahReactor extends TTMultiblockBase implements IConstructable, ISurvivalConstructable {

    private int mCasing;
    private boolean Oxygen = false;
    private long SetEUt = 0;
    private static IStructureDefinition<LargeNaquadahReactor> STRUCTURE_DEFINITION = null;
    public static final String STRUCTURE_PIECE_MAIN = "main";
    public static String[][] shape;
    public static final String LNR_STRUCTURE_FILE_PATH = "sciencenotleisure:multiblock/large_naquadah_reactor";
    public final int horizontalOffSet = 12;
    public final int verticalOffSet = 12;
    public final int depthOffSet = 0;
    protected static final int CASING_INDEX = ((BlockCasings8) sBlockCasings8).getTextureIndex(10);

    public LargeNaquadahReactor(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
        shape = StructureUtils.readStructureFromFile(LNR_STRUCTURE_FILE_PATH);
    }

    public LargeNaquadahReactor(String aName) {
        super(aName);
        shape = StructureUtils.readStructureFromFile(LNR_STRUCTURE_FILE_PATH);
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        final MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType(TextLocalization.LargeNaquadahReactorRecipeType)
            .addInfo(TextLocalization.Tooltip_LargeNaquadahReactor_00)
            .addInfo(TextLocalization.Tooltip_LargeNaquadahReactor_01)
            .addInfo(TextLocalization.Tooltip_LargeNaquadahReactor_02)
            .addInfo(TextLocalization.Tooltip_LargeNaquadahReactor_03)
            .addSeparator()
            .addInfo(TextLocalization.StructureTooComplex)
            .addInfo(TextLocalization.BLUE_PRINT_INFO)
            .beginStructureBlock(25, 25, 9, true)
            .addInputHatch(TextLocalization.Tooltip_LargeNaquadahReactor_Casing)
            .addDynamoHatch(TextLocalization.Tooltip_LargeNaquadahReactor_Casing)
            .addMaintenanceHatch(TextLocalization.Tooltip_LargeNaquadahReactor_Casing)
            .toolTipFinisher(TextUtils.SNL + TextUtils.SQY);
        return tt;
    }

    @Override
    public IStructureDefinition<LargeNaquadahReactor> getStructure_EM() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<LargeNaquadahReactor>builder()
                .addShape(STRUCTURE_PIECE_MAIN, transpose(shape))
                .addElement('A', ofBlock(MetaCasing, 4))
                .addElement('B', ofBlock(MetaCasing, 5))
                .addElement(
                    'C',
                    buildHatchAdder(LargeNaquadahReactor.class).casingIndex(CASING_INDEX)
                        .dot(1)
                        .atLeast(InputHatch, Dynamo.or(DynamoMulti), Maintenance)
                        .buildAndChain(onElementPass(x -> ++x.mCasing, ofBlock(sBlockCasings8, 10))))
                .addElement('D', ofBlock(sBlockCasingsTT, 0))
                .addElement('E', ofFrame(Materials.Naquadria))
                .addElement('F', ofFrame(Materials.Trinium))
                .addElement('G', ofBlock(blockCasings4Misc, 10))
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
                    .addIcon(NAQUADAH_REACTOR_SOLID_FRONT_ACTIVE)
                    .extFacing()
                    .build() };
            return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()),
                TextureFactory.builder()
                    .addIcon(NAQUADAH_REACTOR_SOLID_FRONT)
                    .extFacing()
                    .build() };
        }
        return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingTextureID()) };
    }

    public int getCasingTextureID() {
        return CASING_INDEX;
    }

    @Override
    @NotNull
    public CheckRecipeResult checkProcessing_EM() {
        boolean fuelTierI = false;
        boolean fuelTierII = false;
        boolean hydrogen = false;
        boolean oxygenPlasma = false;
        boolean nitrogenPlasma = false;
        Oxygen = false;
        SetEUt = 524288;
        int multiplier = 1;

        List<FluidStack> tFluids = getStoredFluids();
        if (tFluids.isEmpty()) return CheckRecipeResultRegistry.NO_RECIPE;

        int count = 0;
        for (FluidStack fs : tFluids) {
            if (count >= 6) {
                break;
            }
            Fluid fluid = fs.getFluid();
            switch (fluid.getName()) {
                case "naquadah based liquid fuel mki" -> fuelTierI = true;
                case "naquadah based liquid fuel mkii" -> fuelTierII = true;
                case "hydrogen" -> hydrogen = true;
                case "plasma.oxygen" -> oxygenPlasma = true;
                case "plasma.nitrogen" -> nitrogenPlasma = true;
                case "oxygen" -> Oxygen = true;
            }
            count++;
        }

        if (!fuelTierI && !fuelTierII) {
            return CheckRecipeResultRegistry.NO_RECIPE;
        }

        if (!(oxygenPlasma ^ nitrogenPlasma ^ hydrogen)) {
            return CheckRecipeResultRegistry.NO_RECIPE;
        }

        try {
            if (fuelTierI) {
                if (hydrogen) {
                    int fuelAvailable = getFluidAmount("naquadah based liquid fuel mki");
                    int hydroAvailable = getFluidAmount("hydrogen");
                    int maxFuelMulti = Math.min(fuelAvailable / 16, 4);
                    int maxHydroMulti = Math.min(hydroAvailable / 80, 4);
                    multiplier = Math.min(maxFuelMulti, maxHydroMulti);

                    if (multiplier < 1) return CheckRecipeResultRegistry.NO_RECIPE;
                    if (!drainFluid("naquadah based liquid fuel mki", 16 * multiplier)
                        || !drainFluid("hydrogen", 80 * multiplier)) {
                        return CheckRecipeResultRegistry.NO_RECIPE;
                    }
                } else if (oxygenPlasma) {
                    int fuelAvailable = getFluidAmount("naquadah based liquid fuel mki");
                    int oxyPlasmaAvailable = getFluidAmount("plasma.oxygen");
                    int maxFuelMulti = Math.min(fuelAvailable / 160, 4);
                    int maxOxyMulti = Math.min(oxyPlasmaAvailable / 40, 4);
                    multiplier = Math.min(maxFuelMulti, maxOxyMulti);

                    if (multiplier < 1) return CheckRecipeResultRegistry.NO_RECIPE;
                    if (!drainFluid("naquadah based liquid fuel mki", 160 * multiplier)
                        || !drainFluid("plasma.oxygen", 40 * multiplier)) {
                        return CheckRecipeResultRegistry.NO_RECIPE;
                    }
                }
            } else if (fuelTierII) {
                if (hydrogen) {
                    int fuelAvailable = getFluidAmount("naquadah based liquid fuel mkii");
                    int hydroAvailable = getFluidAmount("hydrogen");
                    int maxFuelMulti = Math.min(fuelAvailable / 16, 4);
                    int maxHydroMulti = Math.min(hydroAvailable / 80, 4);
                    multiplier = Math.min(maxFuelMulti, maxHydroMulti);

                    if (multiplier < 1) return CheckRecipeResultRegistry.NO_RECIPE;
                    if (!drainFluid("naquadah based liquid fuel mkii", 16 * multiplier)
                        || !drainFluid("hydrogen", 80 * multiplier)) {
                        return CheckRecipeResultRegistry.NO_RECIPE;
                    }
                } else if (nitrogenPlasma) {
                    int fuelAvailable = getFluidAmount("naquadah based liquid fuel mkii");
                    int nitroPlasmaAvailable = getFluidAmount("plasma.nitrogen");
                    int maxFuelMulti = Math.min(fuelAvailable / 160, 4);
                    int maxNitroMulti = Math.min(nitroPlasmaAvailable / 40, 4);
                    multiplier = Math.min(maxFuelMulti, maxNitroMulti);

                    if (multiplier < 1) return CheckRecipeResultRegistry.NO_RECIPE;
                    if (!drainFluid("naquadah based liquid fuel mkii", 160 * multiplier)
                        || !drainFluid("plasma.nitrogen", 40 * multiplier)) {
                        return CheckRecipeResultRegistry.NO_RECIPE;
                    }
                }
            }
        } catch (Exception e) {
            return CheckRecipeResultRegistry.NO_RECIPE;
        }

        int baseTime = 0;
        if (fuelTierI) {
            if (hydrogen) baseTime = 875;
            else if (oxygenPlasma) baseTime = 14000;
        } else if (fuelTierII) {
            if (hydrogen) baseTime = 1250;
            else if (nitrogenPlasma) baseTime = 20000;
        }
        this.mMaxProgresstime = baseTime;

        SetEUt *= multiplier;
        if (Oxygen) {
            this.mMaxProgresstime /= 2;
            SetEUt *= 2;
        }

        this.mEfficiency = 10000;
        this.mProgresstime = 0;

        return CheckRecipeResultRegistry.GENERATING;
    }

    private int getFluidAmount(String fluidName) {
        int total = 0;
        for (FluidStack fs : getStoredFluids()) {
            if (fs.getFluid()
                .getName()
                .equals(fluidName)) {
                total += fs.amount;
            }
        }
        return total;
    }

    private boolean drainFluid(String fluidName, int amount) {
        int remaining = amount;
        for (FluidStack fs : getStoredFluids()) {
            if (fs.getFluid()
                .getName()
                .equals(fluidName)) {
                int drained = Math.min(fs.amount, remaining);
                fs.amount -= drained;
                remaining -= drained;
                if (remaining <= 0) break;
            }
        }
        return remaining <= 0;
    }

    @Override
    public boolean onRunningTick(ItemStack stack) {
        if ((this.mProgresstime + 1) % 20 == 0) {
            if (Oxygen) {
                if (!drainFluid("oxygen", 2000)) {
                    stopMachine(ShutDownReasonRegistry.NO_REPAIR);
                    return false;
                }
            }

            BigInteger euPerSecond = BigInteger.valueOf(SetEUt)
                .multiply(BigInteger.valueOf(20));

            for (MTEHatchDynamo eDynamo : super.mDynamoHatches) {
                if (eDynamo == null || !eDynamo.isValid()) continue;

                BigInteger canAccept = BigInteger.valueOf(eDynamo.maxEUStore())
                    .subtract(BigInteger.valueOf(eDynamo.getEUVar()));

                BigInteger actualTransfer = euPerSecond.min(canAccept);

                if (actualTransfer.compareTo(BigInteger.ZERO) > 0) {
                    if (actualTransfer.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
                        stopMachine(ShutDownReasonRegistry.POWER_LOSS);
                        return false;
                    }
                    long transfer = actualTransfer.longValueExact();

                    eDynamo.setEUVar(eDynamo.getEUVar() + transfer);
                    euPerSecond = euPerSecond.subtract(actualTransfer);
                    if (euPerSecond.compareTo(BigInteger.ZERO) <= 0) break;
                }
            }

            if (euPerSecond.compareTo(BigInteger.ZERO) > 0) {
                for (MTEHatchDynamoMulti eDynamo : eDynamoMulti) {
                    if (eDynamo == null || !eDynamo.isValid()) continue;

                    BigInteger canAccept = BigInteger.valueOf(eDynamo.maxEUStore())
                        .subtract(BigInteger.valueOf(eDynamo.getEUVar()));

                    BigInteger actualTransfer = euPerSecond.min(canAccept);

                    if (actualTransfer.compareTo(BigInteger.ZERO) > 0) {
                        if (actualTransfer.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
                            stopMachine(ShutDownReasonRegistry.POWER_LOSS);
                            return false;
                        }
                        long transfer = actualTransfer.longValueExact();

                        eDynamo.setEUVar(eDynamo.getEUVar() + transfer);
                        euPerSecond = euPerSecond.subtract(actualTransfer);
                        if (euPerSecond.compareTo(BigInteger.ZERO) <= 0) break;
                    }
                }
            }
            if (euPerSecond.compareTo(BigInteger.ZERO) > 0) {
                stopMachine(ShutDownReasonRegistry.POWER_LOSS);
                return false;
            }
        }
        return super.onRunningTick(stack);
    }

    @Override
    public boolean checkMachine_EM(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        return checkPiece(STRUCTURE_PIECE_MAIN, horizontalOffSet, verticalOffSet, depthOffSet)
            && mMaintenanceHatches.size() == 1
            && mCasing >= 110;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new LargeNaquadahReactor(this.mName);
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
