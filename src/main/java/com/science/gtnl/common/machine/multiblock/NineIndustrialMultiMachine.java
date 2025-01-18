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

import net.minecraft.client.resources.I18n;
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
import com.science.gtnl.Utils.item.TextLocalization;
import com.science.gtnl.common.machine.multiMachineClasses.NineIndustrialMultiMachineManager;

import gregtech.api.enums.TAE;
import gregtech.api.gui.modularui.GTUITextures;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.util.GTLanguageManager;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.GTUtility;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.api.util.OverclockCalculator;
import gregtech.api.util.ParallelHelper;
import gtPlusPlus.core.block.ModBlocks;
import gtPlusPlus.core.util.minecraft.PlayerUtils;
import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.base.GTPPMultiBlockBase;
import gtPlusPlus.xmod.gregtech.common.blocks.textures.TexturesGtBlock;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;

public class NineIndustrialMultiMachine extends GTPPMultiBlockBase<NineIndustrialMultiMachine>
    implements ISurvivalConstructable {

    private int machineMode;
    private NineIndustrialMultiMachineManager modeManager = new NineIndustrialMultiMachineManager();
    private final int mHeatingCapacity = Integer.MAX_VALUE;
    public static final String[] aToolTipNames = new String[108];
    private int mCasing;
    private static IStructureDefinition<NineIndustrialMultiMachine> STRUCTURE_DEFINITION = null;

    static {
        for (int id = 0; id < 108; id++) {
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
        return null;
    }

    @Override
    public MultiblockTooltipBuilder createTooltip() {
        String[] aBuiltStrings = new String[36];
        for (int i = 0; i < 36; i++) {
            int baseIndex = i * 3;
            if (baseIndex + 2 < aToolTipNames.length) {
                aBuiltStrings[i] = String
                    .join(", ", aToolTipNames[baseIndex], aToolTipNames[baseIndex + 1], aToolTipNames[baseIndex + 2]);
            } else if (baseIndex + 1 < aToolTipNames.length) {
                aBuiltStrings[i] = String.join(", ", aToolTipNames[baseIndex], aToolTipNames[baseIndex + 1]);
            } else if (baseIndex < aToolTipNames.length) {
                aBuiltStrings[i] = aToolTipNames[baseIndex];
            } else {
                aBuiltStrings[i] = "";
            }
        }

        MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType(TextLocalization.NineIndustrialMultiMachineRecipeType)
            .addInfo(TextLocalization.Tooltip_NineIndustrialMultiMachine_00)
            .addInfo(TextLocalization.Tooltip_NineIndustrialMultiMachine_01)
            .addInfo(TextLocalization.Tooltip_NineIndustrialMultiMachine_02);
        for (int i = 0; i < 36; i++) {
            tt.addInfo(
                I18n.format("Tooltip_NineIndustrialMultiMachine_Mode_" + i) + " - "
                    + EnumChatFormatting.YELLOW
                    + aBuiltStrings[i]
                    + EnumChatFormatting.RESET);
        }
        tt.beginStructureBlock(3, 3, 3, true)
            .addInputBus(TextLocalization.Tooltip_NineIndustrialMultiMachine_Casing)
            .addOutputBus(TextLocalization.Tooltip_NineIndustrialMultiMachine_Casing)
            .addInputHatch(TextLocalization.Tooltip_NineIndustrialMultiMachine_Casing)
            .addOutputHatch(TextLocalization.Tooltip_NineIndustrialMultiMachine_Casing)
            .addEnergyHatch(TextLocalization.Tooltip_NineIndustrialMultiMachine_Casing)
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
                        .atLeast(InputBus, OutputBus, Energy, InputHatch, OutputHatch)
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
        if (T == -1) {
            throw new IllegalArgumentException("Invalid circuit item damage: " + H);
        }
        return NineIndustrialMultiMachineManager.MODE_MAP[machineMode][T];
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return null;
    }

    @Nonnull
    @Override
    public Collection<RecipeMap<?>> getAvailableRecipeMaps() {
        return NineIndustrialMultiMachineManager.getAvailableRecipeMaps();
    }

    private static RecipeMap<?> getRecipeMap(int mode) {
        return NineIndustrialMultiMachineManager.getRecipeMap(mode);
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
                return 1;
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
        return StatCollector.translateToLocal("NineIndustrialMultiMachine_Mode_" + machineMode);
    }

    @Override
    public String[] getInfoData() {
        String[] data = super.getInfoData();
        ArrayList<String> mInfo = new ArrayList<>(Arrays.asList(data));
        String mode = StatCollector
            .translateToLocal(NineIndustrialMultiMachineManager.getModeLocalization(machineMode));
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
                    + StatCollector.translateToLocal("NineIndustrialMultiMachine_Mode_" + tag.getInteger("mode"))
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
        machineMode = modeManager.getNextMachineMode(machineMode);
        return machineMode;
    }

    @Override
    public void setMachineModeIcons() {
        machineModeIcons.clear();
        machineModeIcons.add(GTUITextures.OVERLAY_BUTTON_MACHINEMODE_DEFAULT);
        for (int i = 0; i <= 35; i++) {
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
