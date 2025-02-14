package com.science.gtnl.common.item;

import net.minecraft.item.Item;

import com.science.gtnl.client.CreativeTabsLoader;

public final class BasicItems {

    public static final Item MetaItem = new ItemAdder("MetaItemBase", "MetaItem", CreativeTabsLoader.GTNotLeisureItem)
        .setTextureName("sciencenotleisure:MetaItem/0");
}
