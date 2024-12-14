package com.science.gtnl.Utils;

import static com.mojang.realmsclient.gui.ChatFormatting.*;

import net.minecraft.util.EnumChatFormatting;

import com.mojang.realmsclient.gui.ChatFormatting;

public class TextUtils {

    public static final String SCIENCE_NOT_LEISURE = TextUtils.full_color("Science Not Leisure");
    public static final String NewHorizonsCoil_00 = TextUtils
        .full_color("179,769,313,486,231,590,772,930,519,078,902,473,361,797,697,894,230,657,273,430,081,");
    public static final String NewHorizonsCoil_01 = TextUtils
        .full_color("157,732,675,805,500,963,132,708,477,322,407,536,021,120,113,879,871,393,357,658,789,");
    public static final String NewHorizonsCoil_02 = TextUtils
        .full_color("768,814,416,622,492,847,430,639,474,124,377,767,893,424,865,485,276,302,219,601,246,");
    public static final String NewHorizonsCoil_03 = TextUtils
        .full_color("094,119,453,082,952,085,005,768,838,150,682,342,462,881,473,913,110,540,827,237,163,");
    public static final String NewHorizonsCoil_04 = TextUtils
        .full_color("350,510,684,586,298,239,947,245,938,479,716,304,835,356,329,624,224,137,216");
    public static final String STERILE = SCIENCE_NOT_LEISURE + EnumChatFormatting.DARK_PURPLE + ": Sterile";
    public static final String AE = SCIENCE_NOT_LEISURE + EnumChatFormatting.BLUE + ": Applied Energistics 2";
    public static final String SRP = SCIENCE_NOT_LEISURE + EnumChatFormatting.BLUE + ": Structural Reconstruction Plan";
    public static final String SQY = SCIENCE_NOT_LEISURE + EnumChatFormatting.BLUE + "§r X §6§l§o犰狳重工";

    public static String formatting(String input, ChatFormatting[] colours, double delay) {
        StringBuilder sb = new StringBuilder(input.length() * 3);
        if (delay <= 0.0D) delay = 0.001D;
        int offset = (int) Math.floor((System.currentTimeMillis() & 0x3FFFL) / delay) % colours.length;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            sb.append(colours[(colours.length + i - offset) % colours.length].toString());
            sb.append(c);
        }
        return sb.toString();
    }

    public static String full_color(String input) {
        return formatting(input, new ChatFormatting[] { RED, GOLD, YELLOW, GREEN, AQUA, BLUE, LIGHT_PURPLE }, 80.0D);
    }
}
