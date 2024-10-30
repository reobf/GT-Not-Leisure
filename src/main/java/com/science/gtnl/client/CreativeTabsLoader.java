package com.science.gtnl.client;

import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader {

    public static CreativeTabs GTNoteLeisure;

    public CreativeTabsLoader(FMLPreInitializationEvent event) {
        GTNoteLeisure = new CreativeTabsGTNoteLeisure();
    }

}
