package com.science.gtnl.common.recipe.GregTech;

import static com.science.gtnl.Mods.ScienceNotLeisure;
import static com.science.gtnl.loader.IScriptLoader.missing;
import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GTModHandler.addCraftingRecipe;
import static gregtech.api.util.GTModHandler.getModItem;

import com.dreammaster.gthandler.CustomItemList;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.recipe.IRecipePool;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialsAlloy;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class CraftingTableRecipes implements IRecipePool {

    @Override
    public void loadRecipes() {

        addCraftingRecipe(
            GTNLItemList.LargeSteamCrusher.get(1),
            new Object[] { "ABA", "CDC", "EBE", 'A',
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Bronze, 1), 'B',
                ItemList.Component_Sawblade_Diamond.get(1), 'C', GregtechItemList.Controller_SteamMaceratorMulti.get(1),
                'D', GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Bronze, 1), 'E',
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.CobaltBrass, 1) });

        addCraftingRecipe(
            GTNLItemList.BronzeBrickCasing.get(1),
            new Object[] { "AAA", "ABA", "ACA", 'A', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                'B', "craftingToolWrench", 'C', getModItem(Minecraft.ID, "brick_block", 1, 0, missing) });

        addCraftingRecipe(
            GTNLItemList.SteelBrickCasing.get(1),
            new Object[] { "AAA", "ABA", "ACA", 'A', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                'B', "craftingToolWrench", 'C', getModItem(Minecraft.ID, "brick_block", 1, 0, missing) });

        addCraftingRecipe(
            GTNLItemList.CheatOreProcessingFactory.get(1),
            new Object[] { "AAA", "ABA", "AAA", 'A', GTNLItemList.StargateSingularity.get(1), 'B',
                GTNLItemList.LargeSteamCrusher.get(1) });

        addCraftingRecipe(
            GTNLItemList.LargeSteamFurnace.get(1),
            new Object[] { "ABA", "CDC", "AEA", 'A', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                'B', ItemList.Casing_Pipe_Bronze.get(1), 'C', ItemList.Casing_Firebox_Bronze.get(1), 'D',
                getModItem(Minecraft.ID, "cauldron", 1, 0, missing), 'E',
                getModItem("gregtech", "gt.blockmachines", 1, 103, missing) });

        addCraftingRecipe(
            GTNLItemList.LargeSteamAlloySmelter.get(1),
            new Object[] { "ABA", "CDC", "AEA", 'A', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                'B', getModItem("miscutils", "itemBasicTurbine", 1, 1, missing), 'C',
                ItemList.Casing_Firebox_Bronze.get(1), 'D', getModItem(Minecraft.ID, "cauldron", 1, 0, missing), 'E',
                ItemList.Machine_Bronze_AlloySmelter.get(1) });

        addCraftingRecipe(
            GTNLItemList.LargeSteamChemicalBath.get(1),
            new Object[] { "ABA", "CDC", "FEF", 'A', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                'B', GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Wood, 1), 'C',
                ItemList.Casing_Pipe_Bronze.get(1), 'D',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Bronze, 1), 'E',
                GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1), 'F',
                GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Bronze, 1) });

        addCraftingRecipe(
            GTNLItemList.PrecisionSteamMechanism.get(1),
            new Object[] { "ABA", "CDC", "EBE", 'A', GTOreDictUnificator.get(OrePrefixes.stick, Materials.Bronze, 1),
                'B', GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Bronze, 1), 'C',
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Bronze, 1), 'D',
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Steel, 1), 'E',
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Bronze, 1) });

        addCraftingRecipe(
            GTNLItemList.PrimitiveDistillationTower.get(1),
            new Object[] { "ABA", "ABA", "CDC", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1), 'B',
                ItemList.Casing_Pipe_Steel.get(1), 'C', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                'D', GTNLItemList.PrecisionSteamMechanism.get(1) });

        addCraftingRecipe(
            GTNLItemList.LargeSteamCircuitAssembler.get(1),
            new Object[] { "ABA", "BCB", "ABA", 'A',
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Bronze, 1), 'B',
                GTNLItemList.PrecisionSteamMechanism.get(1), 'C', GTNLItemList.SteamAssemblyCasing.get(1) });

        addCraftingRecipe(
            GTNLItemList.SteamAssemblyCasing.get(1),
            new Object[] { "ABA", "ACA", "ABA", 'A', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                'B', GTNLItemList.PrecisionSteamMechanism.get(1), 'C', ItemList.Casing_Gearbox_Bronze.get(1) });

        addCraftingRecipe(
            GTNLItemList.SteamCracking.get(1),
            new Object[] { "ABA", "DCD", "ABA", 'A', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                'B', GTNLItemList.PrecisionSteamMechanism.get(1), 'C',
                GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1), 'D',
                ItemList.Casing_Firebox_Bronze.get(1) });

        addCraftingRecipe(
            GTNLItemList.LargeSteamThermalCentrifuge.get(1),
            new Object[] { "ABA", "DCD", "ABA", 'A', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                'B', GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1), 'C',
                ItemList.Casing_Pipe_Bronze.get(1), 'D', ItemList.Casing_Firebox_Bronze.get(1) });

        addCraftingRecipe(
            GTNLItemList.Desulfurizer.get(1),
            new Object[] { "ABA", "CDC", "EFE", 'A', "circuitAdvanced", 'B', CustomItemList.AdsorptionFilter.get(1),
                'C', ItemList.Electric_Pump_HV.get(1), 'D', ItemList.Hull_HV.get(1), 'E',
                GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Electrum, 1L), 'F',
                ItemList.Electric_Motor_HV.get(1) });

        addCraftingRecipe(
            GTNLItemList.LargeCircuitAssembler.get(1),
            new Object[] { "ABA", "CDC", "EBE", 'A', ItemList.Robot_Arm_EV.get(1), 'B',
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1L), 'C', "circuitData", 'D',
                ItemList.Machine_EV_CircuitAssembler.get(1), 'E', ItemList.Conveyor_Module_EV.get(1) });

        addCraftingRecipe(
            GTNLItemList.BrickedBlastFurnace.get(1),
            new Object[] { "ABA", "BCB", "ABA", 'A',
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Bronze, 1L), 'B',
                GTNLItemList.PrecisionSteamMechanism.get(1), 'C', ItemList.Machine_Bricked_BlastFurnace.get(1) });

        addCraftingRecipe(
            GTNLItemList.NeutroniumPipeCasing.get(1),
            new Object[] { "ABA", "BCB", "ABA", 'A',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1L), 'B',
                GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Neutronium, 1L), 'C',
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1L) });

        addCraftingRecipe(
            GTNLItemList.NeutroniumGearbox.get(1),
            new Object[] { "ABA", "CDC", "AEA", 'A',
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 1L), 'B',
                "craftingToolHardHammer", 'C', GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Neutronium, 1L),
                'D', GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1L), 'E',
                "craftingToolWrench" });

        addCraftingRecipe(
            GTNLItemList.EnergeticPhotovoltaicPowerStation.get(1),
            new Object[] { "ABA", "BCB", "ADA", 'A', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                'B', MaterialsAlloy.TUMBAGA.getBlock(1), 'C', GTNLItemList.EnergeticPhotovoltaicBlock.get(1), 'D',
                "circuitGood" });

        addCraftingRecipe(
            GTNLItemList.AdvancedPhotovoltaicPowerStation.get(1),
            new Object[] { "ABA", "BCB", "ADA", 'A', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1L),
                'B', GTModHandler.getModItem(EnderIO.ID, "blockIngotStorage", 1, 3), 'C',
                GTNLItemList.AdvancedPhotovoltaicBlock.get(1), 'D', "circuitAdvanced" });

        addCraftingRecipe(
            GTNLItemList.VibrantPhotovoltaicPowerStation.get(1),
            new Object[] { "ABA", "BCB", "ADA", 'A',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L), 'B',
                GTModHandler.getModItem(EnderIO.ID, "blockIngotStorage", 1, 6), 'C',
                GTNLItemList.VibrantPhotovoltaicBlock.get(1), 'D', "circuitData" });

        addCraftingRecipe(
            GTModHandler.getModItem(ScienceNotLeisure.ID, "TestItem", 1, 0),
            new Object[] { "ABA", "BCB", "ABA", 'A', GTModHandler.getModItem(Minecraft.ID, "golden_apple", 1, 1), 'B',
                GTModHandler.getModItem(Botania.ID, "manaResource", 1, 9), 'C',
                GTModHandler.getModItem(Minecraft.ID, "dragon_egg", 1) });

        addCraftingRecipe(
            GTNLItemList.CrushingWheels.get(2),
            new Object[] { "AAA", "BCB", "BDB", 'A',
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TungstenCarbide, 1L), 'B',
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Ultimet, 1L), 'C',
                ItemList.Casing_MiningOsmiridium.get(1L), 'D', ItemList.Electric_Motor_IV.get(1L) });

        addCraftingRecipe(
            GTNLItemList.SlicingBlades.get(2),
            new Object[] { "AAA", "BCB", "BDB", 'A',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenCarbide, 1L), 'B',
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Ultimet, 1L), 'C',
                GregtechItemList.Casing_CuttingFactoryFrame.get(1L), 'D', ItemList.Electric_Motor_IV.get(1L) });

        addCraftingRecipe(
            tectech.thing.CustomItemList.hatch_CreativeMaintenance.get(1),
            new Object[] { "ABA", "CDC", "ABA", 'A', "circuitAdvanced", 'B', ItemList.Hatch_Maintenance.get(1L), 'C',
                ItemList.Robot_Arm_HV.get(1L), 'D', ItemList.Hull_HV.get(1L) });

        addCraftingRecipe(
            GTNLItemList.NinefoldInputHatchEV.get(1),
            new Object[] { " A ", " B ", "   ", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.Titanium, 1L), 'B',
                ItemList.Hatch_Input_EV.get(1L) });

        addCraftingRecipe(
            GTNLItemList.NinefoldInputHatchIV.get(1),
            new Object[] { " A ", " B ", "   ", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.TungstenSteel, 1L), 'B',
                ItemList.Hatch_Input_IV.get(1L) });

        addCraftingRecipe(
            GTNLItemList.NinefoldInputHatchLuV.get(1),
            new Object[] { " A ", " B ", "   ", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.NiobiumTitanium, 1L), 'B',
                ItemList.Hatch_Input_LuV.get(1L) });

        addCraftingRecipe(
            GTNLItemList.NinefoldInputHatchZPM.get(1),
            new Object[] { " A ", " B ", "   ", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.Enderium, 1L), 'B',
                ItemList.Hatch_Input_ZPM.get(1L) });

        addCraftingRecipe(
            GTNLItemList.NinefoldInputHatchUV.get(1),
            new Object[] { " A ", " B ", "   ", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.Naquadah, 1L), 'B',
                ItemList.Hatch_Input_UV.get(1L) });

        addCraftingRecipe(
            GTNLItemList.NinefoldInputHatchUHV.get(1),
            new Object[] { " A ", " B ", "   ", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.Neutronium, 1L), 'B',
                ItemList.Hatch_Input_UHV.get(1L) });

        addCraftingRecipe(
            GTNLItemList.NinefoldInputHatchUEV.get(1),
            new Object[] { " A ", " B ", "   ", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.NetherStar, 1L), 'B',
                ItemList.Hatch_Input_UEV.get(1L) });

        addCraftingRecipe(
            GTNLItemList.NinefoldInputHatchUIV.get(1),
            new Object[] { " A ", " B ", "   ", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.MysteriousCrystal, 1L), 'B',
                ItemList.Hatch_Input_UIV.get(1L) });

        addCraftingRecipe(
            GTNLItemList.NinefoldInputHatchUMV.get(1),
            new Object[] { " A ", " B ", "   ", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.DraconiumAwakened, 1L), 'B',
                ItemList.Hatch_Input_UMV.get(1L) });

        addCraftingRecipe(
            GTNLItemList.NinefoldInputHatchUXV.get(1),
            new Object[] { " A ", " B ", "   ", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.Infinity, 1L), 'B',
                ItemList.Hatch_Input_UXV.get(1L) });

        addCraftingRecipe(
            GTNLItemList.NinefoldInputHatchMAX.get(1),
            new Object[] { " A ", " B ", "   ", 'A',
                GTOreDictUnificator.get(OrePrefixes.pipeNonuple, MaterialsUEVplus.SpaceTime, 1L), 'B',
                ItemList.Hatch_Input_MAX.get(1L) });
    }
}
