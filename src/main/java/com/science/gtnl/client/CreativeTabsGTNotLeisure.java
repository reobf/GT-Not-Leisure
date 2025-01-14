package com.science.gtnl.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.science.gtnl.common.item.ItemLoader;

public class CreativeTabsGTNotLeisure extends CreativeTabs {

    public CreativeTabsGTNotLeisure() {
        super("GTNotLeisure");
    }

    @Override
    public Item getTabIconItem() {
        return ItemLoader.testitem;
    }
}
