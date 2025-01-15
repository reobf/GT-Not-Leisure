package com.science.gtnl.common.recipe.GregTech;

import static com.science.gtnl.loader.IScriptLoader.missing;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GTModHandler.addCraftingRecipe;
import static gregtech.api.util.GTModHandler.getModItem;

import com.dreammaster.gthandler.CustomItemList;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.recipe.IRecipePool;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
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
            new Object[] { "ABA", "CDC", "EFE", 'A', GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                'B', CustomItemList.AdsorptionFilter.get(1), 'C', ItemList.Electric_Pump_HV.get(1), 'D',
                ItemList.Hull_HV.get(1), 'E', GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Electrum, 1L),
                'F', ItemList.Electric_Motor_HV.get(1) });

        addCraftingRecipe(
            GTNLItemList.LargeCircuitAssembler.get(1),
            new Object[] { "ABA", "CDC", "EBE", 'A', ItemList.Robot_Arm_EV.get(1), 'B',
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1L), 'C', "circuitData", 'D',
                ItemList.Machine_EV_CircuitAssembler.get(1), 'E', ItemList.Conveyor_Module_EV.get(1) });
        addCraftingRecipe(
            GTNLItemList.BrickedBlastFurnace.get(1),
            new Object[] { "A  ", "   ", "   ", 'A', ItemList.Machine_Bricked_BlastFurnace.get(1) });
    }
}
