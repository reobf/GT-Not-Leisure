package com.science.gtnl.client;

import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader {

    public static CreativeTabs GTNotLeisure;

    public CreativeTabsLoader(FMLPreInitializationEvent event) {
        GTNotLeisure = new CreativeTabsGTNotLeisure();
    }

}
