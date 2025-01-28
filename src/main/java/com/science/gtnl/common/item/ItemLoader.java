package com.science.gtnl.common.item;

import net.minecraft.item.Item;

import com.science.gtnl.common.item.items.TestItem;
import com.science.gtnl.common.item.tools.BlazeAxe;
import com.science.gtnl.common.item.tools.BlazePickaxe;
import com.science.gtnl.common.item.tools.CrystalAxe;
import com.science.gtnl.common.item.tools.CrystalHoe;
import com.science.gtnl.common.item.tools.CrystalPickaxe;
import com.science.gtnl.common.item.tools.CrystalShovel;
import com.science.gtnl.common.item.tools.CrystalSword;
import com.science.gtnl.common.item.tools.InfinityTotem;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemLoader {

    private ItemLoader() {}

    public static Item TestItem = new TestItem();
    public static Item CrystalPickaxe = new CrystalPickaxe();
    public static Item CrystalHoe = new CrystalHoe();
    public static Item CrystalShovel = new CrystalShovel();
    public static Item CrystalAxe = new CrystalAxe();
    public static Item CrystalSword = new CrystalSword();
    public static Item BlazePickaxe = new BlazePickaxe();
    public static Item BlazeAxe = new BlazeAxe();
    public static Item InfinityTotem = new InfinityTotem();
    public static Item RecordSus = new ItemRecord("sus");
    public static Item RecordNewHorizons = new ItemRecord("newhorizons");

    public static void registerItems() {
        IRegistry(TestItem, "TestItem");
        IRegistry(CrystalPickaxe, "CrystalPickaxe");
        IRegistry(CrystalHoe, "CrystalHoe");
        IRegistry(CrystalShovel, "CrystalShovel");
        IRegistry(CrystalAxe, "CrystalAxe");
        IRegistry(CrystalSword, "CrystalSword");
        IRegistry(BlazePickaxe, "BlazePickaxe");
        IRegistry(BlazeAxe, "BlazeAxe");
        IRegistry(InfinityTotem, "InfinityTotem");
        IRegistry(RecordSus, "RecordSus");
        IRegistry(RecordNewHorizons, "RecordNewHorizons");

    }

    public static void IRegistry(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }

}
