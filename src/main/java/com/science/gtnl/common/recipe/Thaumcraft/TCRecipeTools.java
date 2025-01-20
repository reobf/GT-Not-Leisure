package com.science.gtnl.common.recipe.Thaumcraft;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.ShapedArcaneRecipe;

public class TCRecipeTools {

    public static ArrayList<ShapedArcaneCraftingRecipe> SAR = new ArrayList<>();

    public TCRecipeTools() {}

    public static void getShapedArcaneCraftingRecipe() {
        List<Object> craftingRecipes = ThaumcraftApi.getCraftingRecipes();
        for (Object r : craftingRecipes) {
            if (!(r instanceof ShapedArcaneRecipe recipe)) {
                continue;
            }

            if (recipe.getRecipeOutput() instanceof ItemStack && recipe.getRecipeOutput()
                .getItem() != null) {
                ShapedArcaneCraftingRecipe y = new ShapedArcaneCraftingRecipe(
                    recipe.getInput(), // getInputItems
                    recipe.getRecipeOutput()); // getOutputItem
                SAR.add(y);
            }
        }
    }

    public static class ShapedArcaneCraftingRecipe {

        private final Object[] InputItems;
        private final ItemStack OutputItem;

        public ShapedArcaneCraftingRecipe(Object[] InputItems, ItemStack OutputItem) {
            this.InputItems = InputItems;
            this.OutputItem = OutputItem;
        }

        public Object[] getInputItems() {
            return InputItems;
        }

        public ItemStack getOutput() {
            return OutputItem;
        }
    }
}
