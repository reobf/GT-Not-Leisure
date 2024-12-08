package com.science.gtnl.loader;

import static gregtech.api.util.GTModHandler.getModItem;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;

import cpw.mods.fml.common.Loader;

public interface IScriptLoader {

    String getScriptName();

    List<String> getDependencies();

    void loadRecipes();

    /**
     * Helper function to get a new ItemStack with specified damage (meta) value and NBT tags. Calls
     * {@link gregtech.api.util.GTModHandler#getModItem(String, String, long, int)} internally
     *
     * @param aModID       Mod ID of an the item
     * @param aItem        Item registry name
     * @param aAmount      Amount to get
     * @param aMeta        the meta id of the item to look at.
     * @param aNBTString   NBT data that the created stack should get, in format that {@link NBTTagCompound#toString()}
     *                     returns. Can be checked in-game with `/iih` command
     * @param aReplacement Replacement stack to return if the item is not found. NBT data is not applied to it.
     * @return Created ItemStack or replacement stack
     * @throws RuntimeException if the NBT string parsing fails
     */
    default ItemStack createItemStack(String aModID, String aItem, long aAmount, int aMeta, String aNBTString,
        ItemStack aReplacement) {
        ItemStack s = getModItem(aModID, aItem, aAmount, aMeta);
        if (s == null) return aReplacement;
        try {
            s.stackTagCompound = (NBTTagCompound) JsonToNBT.func_150315_a(aNBTString);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    /**
     * Function to know if a script is loadable: if at least one of its dependencies is missing then it won't be
     * considered as loadable.
     *
     * @return a boolean representing if the script is loadable.
     */
    default boolean isScriptLoadable() {
        for (String dep : getDependencies()) {
            if (!Loader.isModLoaded(dep)) {
                return false;
            }
        }
        return true;
    }

    ItemStack missing = new ItemStack(Blocks.fire);
}
