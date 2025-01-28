package com.science.gtnl.client;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsLoader {

    public static CreativeTabs GTNotLeisure;

    static {
        GTNotLeisure = new CreativeTabsGTNotLeisure();
    }

    public static void init() {}
}
