package com.science.gtnl.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.science.gtnl.common.item.ItemLoader;

public class CreativeTabsLoader {

    public static CreativeTabs GTNotLeisure;
    public static CreativeTabs ReAvaritia;

    static {
        GTNotLeisure = new CreativeTabs("GTNotLeisure") {

            @Override
            public Item getTabIconItem() {
                return ItemLoader.TestItem;
            }
        };
    }

    static {
        ReAvaritia = new CreativeTabs("ReAvaritia") {

            @Override
            public Item getTabIconItem() {
                return ItemLoader.InfinityPickaxe;
            }
        };
    }

    public static void init() {
        // 可以在这里添加其他初始化逻辑
    }
}
