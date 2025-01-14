package com.science.gtnl.common.item;

import net.minecraft.item.Item;

import com.science.gtnl.common.item.items.testitem;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemLoader {

    public static Item testitem = new testitem();
    public static Item RecordSus = new ItemRecord("sus");
    public static Item RecordNewHorizons = new ItemRecord("newhorizons");

    public ItemLoader(FMLPreInitializationEvent event) {
        IRegistry(testitem, "testitem");
        IRegistry(RecordSus, "RecordSus");
        IRegistry(RecordNewHorizons, "RecordNewHorizons");

    }

    public static void IRegistry(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }

}
