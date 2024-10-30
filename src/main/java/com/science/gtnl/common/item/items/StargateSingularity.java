package com.science.gtnl.common.item.items;

import net.minecraft.item.Item;

import com.science.gtnl.client.CreativeTabsLoader;

public class StargateSingularity extends Item {

    public StargateSingularity() {
        super();

        this.setUnlocalizedName("StargateSingularity");
        this.setCreativeTab(CreativeTabsLoader.GTNoteLeisure);
        this.setTextureName("sciencenotleisure:StargateSingularity");
    }
}
