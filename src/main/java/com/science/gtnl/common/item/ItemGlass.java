package com.science.gtnl.common.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import gregtech.api.util.GTLanguageManager;
import gregtech.common.blocks.ItemCasingsAbstract;

/**
 * The glass types are split into separate files because they are registered as regular blocks, and a regular block can
 * have
 * 16 subtypes at most.
 */
public class ItemGlass extends ItemCasingsAbstract {

    protected final String GaiaGlassTooltip = GTLanguageManager
        .addStringLocalization(getUnlocalizedName() + ".100.tooltip", "Provide a stable source of mana");

    public ItemGlass(Block block) {
        super(block);
    }

    @Override
    public void addInformation(ItemStack aStack, EntityPlayer aPlayer, List<String> aList, boolean aF3_H) {
        switch (getDamage(aStack)) {
            case 100 -> aList.add(GaiaGlassTooltip);
        }
    }
}
