package com.science.gtnl;

import java.util.Locale;

import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.common.Loader;

public enum Mods {

    ScienceNotLeisure(Names.SCIENCENOTLEISURE);

    public static class Names {

        public static final String SCIENCENOTLEISURE = "ScienceNotLeisure";
    }

    public final String ID;
    public final String resourceDomain;
    public Boolean modLoaded;

    Mods(String ID) {
        this.ID = ID;
        this.resourceDomain = ID.toLowerCase(Locale.ENGLISH);
    }

    public boolean isModLoaded() {
        if (this.modLoaded == null) {
            this.modLoaded = Loader.isModLoaded(ID);
        }
        return this.modLoaded;
    }

    public String getResourcePath(String... path) {
        return this.getResourceLocation(path)
            .toString();
    }

    public ResourceLocation getResourceLocation(String... path) {
        return new ResourceLocation(this.resourceDomain, String.join("/", path));
    }
}
