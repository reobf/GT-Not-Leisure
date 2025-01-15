package com.science.gtnl.Utils.item;

import static net.minecraft.util.StatCollector.translateToLocalFormatted;

/**
 *
 */
public enum TextEnums {

    StructureTooComplex("StructureTooComplex");

    public static String tr(String key) {
        return translateToLocalFormatted(key);
    }

    public final String text;
    public final String key;

    TextEnums(String key) {
        this.key = key;
        this.text = tr(key);
    }

    @Override
    public String toString() {
        return text;
    }

    public String getKey() {
        return key;
    }

    public String getText() {
        return text;
    }

}
