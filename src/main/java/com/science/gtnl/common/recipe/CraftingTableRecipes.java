package com.science.gtnl.common.recipe;

import static com.science.gtnl.loader.IScriptLoader.missing;
import static gregtech.api.util.GTModHandler.addCraftingRecipe;
import static gregtech.api.util.GTModHandler.getModItem;

import com.science.gtnl.common.GTNLItemList;

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
            GTNLItemList.Bronze_Brick_Casing.get(1),
            new Object[] { "AAA", "ABA", "ACA", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing), 'B',
                "craftingToolWrench", 'C', getModItem("minecraft", "brick_block", 1, 0, missing) });

        addCraftingRecipe(
            GTNLItemList.Steel_Brick_Casing.get(1),
            new Object[] { "AAA", "ABA", "ACA", 'A', getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing), 'B',
                "craftingToolWrench", 'C', getModItem("minecraft", "brick_block", 1, 0, missing) });

        addCraftingRecipe(
            GTNLItemList.CheatOreProcessingFactory.get(1),
            new Object[] { "AAA", "ABA", "AAA", 'A',
                getModItem("ScienceNotLeisure", "StargateSingularity", 1, 0, missing), 'B', "craftingToolWrench", 'B',
                GTNLItemList.LargeSteamCrusher.get(1) });
    }
}
