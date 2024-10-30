package com.science.gtnl.common;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class OreDictionaryLoader {

    public OreDictionaryLoader(FMLPreInitializationEvent event) {
        List<ItemStack> testitem = GTOreDictUnificator.getOres(OrePrefixes.circuit, Materials.UMV);

        for (ItemStack itemStack : testitem) {
            OreDictionary.registerOre("testitem", itemStack);
        }
    }

}
