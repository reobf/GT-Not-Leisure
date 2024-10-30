package com.science.gtnl.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.science.gtnl.common.item.ItemLoader;

public class CreativeTabsGTNoteLeisure extends CreativeTabs {

    public CreativeTabsGTNoteLeisure() {
        super("GTNoteLeisure");
    }

    @Override
    public Item getTabIconItem() {
        return ItemLoader.testitem;
    }
}
