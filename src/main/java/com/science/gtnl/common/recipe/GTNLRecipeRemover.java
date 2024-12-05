package com.science.gtnl.common.recipe;

import static com.dreammaster.scripts.IScriptLoader.wildcard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.main.MainRegistry;

import gregtech.api.enums.ItemList;
import gregtech.api.util.GTUtility;
import tectech.loader.recipe.AssemblyLine;

public class GTNLRecipeRemover {

    public static boolean bufferingRecipes = true;
    public static final ArrayList<IRecipe> tList = (ArrayList<IRecipe>) CraftingManager.getInstance()
        .getRecipeList();
    public static final HashMap<GTUtility.ItemId, List<Function<IRecipe, Boolean>>> bufferMap = new HashMap<>();

    public static void run() {
        final long timeStart = System.currentTimeMillis();

        // 调试信息：检查 Circuit_Chip_BioCPU
        System.out.println("Trying to remove recipes for: " + ItemList.Circuit_Chip_BioCPU.get(1));

        // 删除 AssemblyLine 中的 Circuit_Chip_BioCPU 的配方
        removeDreamcraftAssemblyLineRecipe(ItemList.Circuit_Chip_BioCPU.get(1));

        // 停止缓冲并实际删除配方
        stopBuffering();

        // 记录耗时
        final long timeToLoad = System.currentTimeMillis() - timeStart;
        MainRegistry.Logger.info("Recipes removal took " + timeToLoad + " ms.");
    }

    public static void removeDreamcraftAssemblyLineRecipe(ItemStack aOutput) {
        addToBuffer(getItemsHashed(aOutput, false), recipe -> {
            // 检查配方是否属于 dreamcraft 中 AssemblyLine 类型
            if (isDreamcraftAssemblyLineRecipe(recipe)) {
                ItemStack output = recipe.getRecipeOutput();
                return GTUtility.areStacksEqual(output, aOutput, false);
            }
            return false;
        });
    }

    public static boolean isDreamcraftAssemblyLineRecipe(IRecipe recipe) {
        // 检查配方是否是 dreamcraft 的 AssemblyLine 类型
        // 这里假设 AssemblyLineRecipe 类存在，替换为实际类名
        return recipe instanceof AssemblyLine;
    }

    public static void addToBuffer(HashSet<GTUtility.ItemId> outputs, Function<IRecipe, Boolean> whenToRemove) {
        for (GTUtility.ItemId output : outputs) {
            bufferMap.computeIfAbsent(output, o -> new ArrayList<>())
                .add(whenToRemove);
        }
        if (!bufferingRecipes) stopBuffering();
    }

    public static HashSet<GTUtility.ItemId> getItemsHashed(Object item, boolean includeWildcardVariants) {
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

    public static void stopBuffering() {
        int i = tList.size();
        tList.removeIf(r -> {
            ItemStack rCopy = r.getRecipeOutput();
            if (rCopy == null) {
                return false;
            }
            if (rCopy.getItem() == null) {
                MainRegistry.Logger.warn("Someone is adding recipes with null items!");
                for (StackTraceElement element : Thread.currentThread()
                    .getStackTrace()) {
                    MainRegistry.Logger.warn(element.toString());
                }
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
        MainRegistry.Logger.info("Removed " + (i - tList.size()) + " recipes!");
        bufferMap.clear();
    }
}
