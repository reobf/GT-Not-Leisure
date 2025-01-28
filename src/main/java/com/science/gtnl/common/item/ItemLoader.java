package com.science.gtnl.common.item;

import net.minecraft.item.Item;

import com.science.gtnl.common.item.items.TestItem;
import com.science.gtnl.common.item.tools.CrystalHoe;
import com.science.gtnl.common.item.tools.CrystalPickaxe;
import com.science.gtnl.common.item.tools.CrystalShovel;
import com.science.gtnl.common.item.tools.InfinityTotem;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemLoader {

    public static Item TestItem = new TestItem();
    public static Item CrystalPickaxe = new CrystalPickaxe();
    public static Item CrystalHoe = new CrystalHoe();
    public static Item CrystalShovel = new CrystalShovel();
    public static Item InfinityTotem = new InfinityTotem();
    public static Item RecordSus = new ItemRecord("sus");
    public static Item RecordNewHorizons = new ItemRecord("newhorizons");

    public ItemLoader(FMLPreInitializationEvent event) {
        IRegistry(TestItem, "TestItem");
        IRegistry(CrystalPickaxe, "CrystalPickaxe");
        IRegistry(CrystalHoe, "CrystalHoe");
        IRegistry(CrystalShovel, "CrystalShovel");
        IRegistry(InfinityTotem, "InfinityTotem");
        IRegistry(RecordSus, "RecordSus");
        IRegistry(RecordNewHorizons, "RecordNewHorizons");

    }

    public static void IRegistry(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }

}
