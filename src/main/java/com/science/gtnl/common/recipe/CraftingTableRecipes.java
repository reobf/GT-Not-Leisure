package com.science.gtnl.common.recipe;

import static com.science.gtnl.loader.IScriptLoader.missing;
import static gregtech.api.util.GTModHandler.addCraftingRecipe;
import static gregtech.api.util.GTModHandler.getModItem;

import com.science.gtnl.common.GTNLItemList;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class CraftingTableRecipes implements IRecipePool {

    @Override
    public void loadRecipes() {

        addCraftingRecipe(
            getModItem("gregtech", "gt.blockmachines", 1, 21012, missing),
            new Object[] { "ABA", "CDC", "EBE", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 18300, missing), 'B',
                getModItem("gregtech", "gt.metaitem.01", 1, 32721, missing), 'C',
                getModItem("gregtech", "gt.blockmachines", 1, 5124, missing), 'D',
                getModItem("gregtech", "gt.blockmachines", 1, 31041, missing), 'E',
                getModItem("gregtech", "gt.metaitem.02", 1, 31343, missing) });

        addCraftingRecipe(
            GTNLItemList.BronzeBrickCasing.get(1),
            new Object[] { "AAA", "ABA", "ACA", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing), 'B',
                "craftingToolWrench", 'C', getModItem("minecraft", "brick_block", 1, 0, missing) });

        addCraftingRecipe(
            GTNLItemList.SteelBrickCasing.get(1),
            new Object[] { "AAA", "ABA", "ACA", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing), 'B',
                "craftingToolWrench", 'C', getModItem("minecraft", "brick_block", 1, 0, missing) });

        addCraftingRecipe(
            GTNLItemList.CheatOreProcessingFactory.get(1),
            new Object[] { "AAA", "ABA", "AAA", 'A', GTNLItemList.StargateSingularity.get(1), 'B',
                GTNLItemList.LargeSteamCrusher.get(1) });

        addCraftingRecipe(
            GTNLItemList.LargeSteamFurnace.get(1),
            new Object[] { "ABA", "CDC", "AEA", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing), 'B',
                getModItem("gregtech", "gt.blockcasings2", 1, 12, missing), 'C',
                getModItem("gregtech", "gt.blockcasings3", 1, 13, missing), 'D',
                getModItem("minecraft", "cauldron", 1, 0, missing), 'E',
                getModItem("gregtech", "gt.blockmachines", 1, 103, missing) });

        addCraftingRecipe(
            GTNLItemList.LargeSteamAlloySmelter.get(1),
            new Object[] { "ABA", "CDC", "AEA", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing), 'B',
                getModItem("miscutils", "itemBasicTurbine", 1, 1, missing), 'C',
                getModItem("gregtech", "gt.blockcasings3", 1, 13, missing), 'D',
                getModItem("minecraft", "cauldron", 1, 0, missing), 'E',
                getModItem("gregtech", "gt.blockmachines", 1, 118, missing) });

        addCraftingRecipe(
            GTNLItemList.LargeSteamChemicalBath.get(1),
            new Object[] { "ABA", "CDC", "FEF", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing), 'B',
                getModItem("gregtech", "gt.blockmachines", 1, 5103, missing), 'C',
                getModItem("gregtech", "gt.blockcasings2", 1, 12, missing), 'D',
                getModItem("gregtech", "gt.metaitem.02", 1, 22300, missing), 'E',
                getModItem("gregtech", "gt.metaitem.02", 1, 21300, missing), 'F',
                getModItem("gregtech", "gt.blockmachines", 1, 5123, missing) });

        addCraftingRecipe(
            GTNLItemList.PrecisionSteamMechanism.get(1),
            new Object[] { "ABA", "CDC", "EBE", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 23300, missing), 'B',
                getModItem("gregtech", "gt.metaitem.02", 1, 20300, missing), 'C',
                getModItem("gregtech", "gt.metaitem.02", 1, 23035, missing), 'D',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing), 'E',
                getModItem("gregtech", "gt.metaitem.02", 1, 31300, missing) });

        addCraftingRecipe(
            GTNLItemList.PrimitiveDistillationTower.get(1),
            new Object[] { "ABA", "ABA", "CDC", 'A', getModItem("gregtech", "gt.blockmachines", 1, 5132, missing), 'B',
                getModItem("gregtech", "gt.blockcasings2", 1, 13, missing), 'C',
                getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing), 'D',
                GTNLItemList.PrecisionSteamMechanism.get(1) });

        addCraftingRecipe(
            GTNLItemList.LargeSteamCircuitAssembler.get(1),
            new Object[] { "ABA", "BCB", "ABA", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 18300, missing), 'B',
                GTNLItemList.PrecisionSteamMechanism.get(1), 'C', GTNLItemList.SteamAssemblyCasing.get(1) });

        addCraftingRecipe(
            GTNLItemList.SteamAssemblyCasing.get(1),
            new Object[] { "ABA", "ACA", "ABA", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing), 'B',
                GTNLItemList.PrecisionSteamMechanism.get(1), 'C',
                getModItem("gregtech", "gt.blockcasings2", 1, 2, missing) });

        addCraftingRecipe(
            GTNLItemList.SteamCracking.get(1),
            new Object[] { "ABA", "DCD", "ABA", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing), 'B',
                GTNLItemList.PrecisionSteamMechanism.get(1), 'C',
                getModItem("gregtech", "gt.metaitem.02", 1, 21300, missing), 'D',
                getModItem("gregtech", "gt.blockcasings3", 1, 13, missing) });

        addCraftingRecipe(
            GTNLItemList.LargeSteamThermalCentrifuge.get(1),
            new Object[] { "ABA", "DCD", "ABA", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing), 'B',
                getModItem("gregtech", "gt.metaitem.02", 1, 21300, missing), 'C',
                getModItem("gregtech", "gt.blockcasings2", 1, 12, missing), 'D',
                getModItem("gregtech", "gt.blockcasings3", 1, 13, missing) });

        addCraftingRecipe(
            GTNLItemList.Desulfurizer.get(1),
            new Object[] { "ABA", "CDC", "EFE", 'A', GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                'B', getModItem("dreamcraft", "item.AdsorptionFilter", 1, 0, missing), 'C',
                getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing), 'D',
                getModItem("gregtech", "gt.blockmachines", 1, 13, missing), 'E',
                getModItem("gregtech", "gt.blockmachines", 1, 1443, missing), 'F',
                getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing) });
    }
}
