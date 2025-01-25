package com.science.gtnl.common.recipe;

import static com.dreammaster.scripts.IScriptLoader.wildcard;
import static com.science.gtnl.loader.IScriptLoader.missing;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.util.GTModHandler.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import eu.usrv.yamcore.auxiliary.LogHelper;
import gregtech.api.util.GTUtility;

public class GTNLRecipeRemover {

    public static LogHelper Logger = new LogHelper("ScienceNotLeisure");
    private static HashMap<GTUtility.ItemId, List<Function<IRecipe, Boolean>>> bufferMap;

    private static void addToBuffer(HashSet<GTUtility.ItemId> outputs, Function<IRecipe, Boolean> whenToRemove) {
        for (GTUtility.ItemId output : outputs) {
            bufferMap.computeIfAbsent(output, o -> new ArrayList<>())
                .add(whenToRemove);
        }
    }

    private static void flushBuffer() {
        final ArrayList<IRecipe> list = (ArrayList<IRecipe>) CraftingManager.getInstance()
            .getRecipeList();
        int i = list.size();
        list.removeIf(r -> {
            ItemStack rCopy = r.getRecipeOutput();
            if (rCopy == null) {
                return false;
            }
            if (rCopy.getItem() == null) {
                Logger.warn("Someone is adding recipes with null items!");
                return true;
            }
            if (rCopy.stackTagCompound != null) {
                rCopy = rCopy.copy();
                rCopy.stackTagCompound = null;
            }
            GTUtility.ItemId key = GTUtility.ItemId.createNoCopy(rCopy);
            rCopy = rCopy.copy();
            Items.feather.setDamage(rCopy, wildcard);
            GTUtility.ItemId keyWildcard = GTUtility.ItemId.createNoCopy(rCopy);
            List<Function<IRecipe, Boolean>> listWhenToRemove = bufferMap.get(key);
            if (listWhenToRemove == null) listWhenToRemove = bufferMap.get(keyWildcard);
            if (listWhenToRemove == null) return false;
            for (Function<IRecipe, Boolean> whenToRemove : listWhenToRemove) {
                if (whenToRemove.apply(r)) return true;
            }
            return false;
        });
        Logger.info("Removed " + (i - list.size()) + " recipes!");
    }

    private static HashSet<GTUtility.ItemId> getItemsHashed(Object item, boolean includeWildcardVariants) {
        HashSet<GTUtility.ItemId> hashedItems = new HashSet<>();
        if (item instanceof ItemStack) {
            ItemStack iCopy = ((ItemStack) item).copy();
            iCopy.stackTagCompound = null;
            hashedItems.add(GTUtility.ItemId.createNoCopy(iCopy));
            if (includeWildcardVariants) {
                iCopy = iCopy.copy();
                Items.feather.setDamage(iCopy, wildcard);
                hashedItems.add(GTUtility.ItemId.createNoCopy(iCopy));
            }
        } else if (item instanceof String) {
            for (ItemStack stack : OreDictionary.getOres((String) item)) {
                hashedItems.add(GTUtility.ItemId.createNoCopy(stack));
                if (includeWildcardVariants) {
                    stack = stack.copy();
                    Items.feather.setDamage(stack, wildcard);
                    hashedItems.add(GTUtility.ItemId.createNoCopy(stack));
                }
            }
        } else if (item instanceof ArrayList) {
            // noinspection unchecked
            for (ItemStack stack : (ArrayList<ItemStack>) item) {
                ItemStack iCopy = stack.copy();
                iCopy.stackTagCompound = null;
                hashedItems.add(GTUtility.ItemId.createNoCopy(iCopy));
                if (includeWildcardVariants) {
                    iCopy = iCopy.copy();
                    Items.feather.setDamage(iCopy, wildcard);
                    hashedItems.add(GTUtility.ItemId.createNoCopy(iCopy));
                }
            }
        } else throw new IllegalArgumentException("Invalid input");
        return hashedItems;
    }

    /**
     * Removes only shapeless recipes by output and inputs, supports OreDictionary tags
     *
     */
    private static void removeRecipeShapelessDelayed(Object aOutput, Object... aRecipe) {
        ArrayList<Object> aRecipeList = new ArrayList<>(Arrays.asList(aRecipe));
        addToBuffer(getItemsHashed(aOutput, false), r -> {
            if (!(r instanceof ShapelessOreRecipe) && !(r instanceof ShapelessRecipes)) return false;
            if (aRecipeList.isEmpty()) return true;
            @SuppressWarnings("unchecked")
            ArrayList<Object> recipe = (ArrayList<Object>) aRecipeList.clone();
            List<?> rInputs = (r instanceof ShapelessOreRecipe ? ((ShapelessOreRecipe) r).getInput()
                : ((ShapelessRecipes) r).recipeItems);
            for (Object rInput : rInputs) {
                HashSet<GTUtility.ItemId> rInputHashed;
                HashSet<GTUtility.ItemId> rInputHashedNoWildcard;
                try {
                    rInputHashed = getItemsHashed(rInput, true);
                    rInputHashedNoWildcard = getItemsHashed(rInput, false);
                } catch (Exception ex) {
                    return false;
                }
                boolean found = false;
                for (Iterator<Object> iterator = recipe.iterator(); iterator.hasNext();) {
                    Object o = iterator.next();
                    for (GTUtility.ItemId id : getItemsHashed(o, false)) {
                        if (rInputHashed.contains(id)) {
                            found = true;
                            iterator.remove();
                            break;
                        }
                    }
                    if (!found) {
                        for (GTUtility.ItemId id : getItemsHashed(o, true)) {
                            if (rInputHashedNoWildcard.contains(id)) {
                                found = true;
                                iterator.remove();
                                break;
                            }
                        }
                    }
                    if (found) break;
                }
                if (!found) return false;
            }
            return recipe.isEmpty();
        });
    }

    private static Field recipeWidthField = null;

    /**
     * Removes only shaped recipes by output and inputs, supports OreDictionary tags
     *
     */
    private static void removeRecipeShapedDelayed(Object aOutput, Object[] row1, Object[] row2, Object[] row3) {
        if (recipeWidthField == null) {
            try {
                recipeWidthField = ShapedOreRecipe.class.getDeclaredField("width");
                recipeWidthField.setAccessible(true);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        Object[][] recipe = new Object[][] { row1, row2, row3 };
        addToBuffer(getItemsHashed(aOutput, false), r -> {
            if (!(r instanceof ShapedOreRecipe) && !(r instanceof ShapedRecipes)) return false;
            Object[] inputs = (r instanceof ShapedOreRecipe ? ((ShapedOreRecipe) r).getInput()
                : ((ShapedRecipes) r).recipeItems);
            int width;
            try {
                width = (r instanceof ShapedOreRecipe ? (int) recipeWidthField.get(r)
                    : ((ShapedRecipes) r).recipeWidth);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            int height = (r instanceof ShapedOreRecipe ? r.getRecipeSize() / width : ((ShapedRecipes) r).recipeHeight);

            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    Object rStack = (y >= height || x >= width ? null : inputs[x + y * width]);
                    Object rRecipe = (x >= recipe[y].length ? null : recipe[y][x]);
                    if (rStack == null ^ rRecipe == null) return false;
                    if (rStack == null) continue;
                    HashSet<GTUtility.ItemId> rInputHashed;
                    try {
                        rInputHashed = getItemsHashed(rStack, true);
                    } catch (Exception ex) {
                        return false;
                    }
                    boolean found = false;
                    for (GTUtility.ItemId id : getItemsHashed(rRecipe, false)) {
                        if (rInputHashed.contains(id)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        rInputHashed = getItemsHashed(rStack, false);
                        for (GTUtility.ItemId id : getItemsHashed(rRecipe, true)) {
                            if (rInputHashed.contains(id)) {
                                found = true;
                                break;
                            }
                        }
                    }
                    if (!found) return false;
                }
            }

            return true;
        });
    }

    /**
     * Removes only shaped recipes by output, supports OreDictionary tag
     *
     */
    private static void removeRecipeShapedDelayed(Object aOutput) {
        addToBuffer(getItemsHashed(aOutput, false), r -> r instanceof ShapedOreRecipe || r instanceof ShapedRecipes);
    }

    /**
     * Removes recipes by output, supports OreDictionary tags
     *
     */
    private static void removeRecipeByOutputDelayed(Object aOutput) {
        addToBuffer(getItemsHashed(aOutput, false), r -> true);
    }

    public static void run() {
        bufferMap = new HashMap<>();
        final long timeStart = System.currentTimeMillis();

        removeRecipeByOutputDelayed(getModItem(GregTech.ID, "gt.metaitem.03", 1, 32077, missing));
        removeRecipeShapelessDelayed(getModItem(GregTech.ID, "gt.metaitem.03", 1, 32077, missing));
        removeRecipeShapedDelayed(getModItem(GregTech.ID, "gt.metaitem.03", 1, 32077, missing));
        removeRecipeByOutput(getModItem(GregTech.ID, "gt.metaitem.03", 1, 32077, missing));
        removeRecipe(getModItem(GregTech.ID, "gt.metaitem.03", 1, 32077, missing));

        flushBuffer();
        bufferMap = null;
        final long timeToLoad = System.currentTimeMillis() - timeStart;
        Logger.info("GTNL:Recipes removal took " + timeToLoad + " ms.");
    }
}
