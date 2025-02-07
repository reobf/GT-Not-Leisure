package com.science.gtnl.Utils.item;

import static net.minecraft.util.EnumChatFormatting.AQUA;
import static net.minecraft.util.EnumChatFormatting.BLUE;
import static net.minecraft.util.EnumChatFormatting.GOLD;
import static net.minecraft.util.EnumChatFormatting.GRAY;
import static net.minecraft.util.EnumChatFormatting.GREEN;
import static net.minecraft.util.EnumChatFormatting.LIGHT_PURPLE;
import static net.minecraft.util.EnumChatFormatting.RED;
import static net.minecraft.util.EnumChatFormatting.WHITE;
import static net.minecraft.util.EnumChatFormatting.YELLOW;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

public class TextUtils {

    public static final String SCIENCE_NOT_LEISURE = TextUtils.full_color("Science Not Leisure");
    public static final String SNL = SCIENCE_NOT_LEISURE + ": ";
    public static final String STERILE = EnumChatFormatting.DARK_PURPLE + "Sterile";
    public static final String AE = EnumChatFormatting.BLUE + TextLocalization.AppliedEnergistics2;
    public static final String SRP = EnumChatFormatting.BLUE + TextLocalization.StructuralReconstructionPlan;
    public static final String SQY = EnumChatFormatting.BLUE + "§r§6§l§o犰狳重工";

    private static final EnumChatFormatting[] fabulousness = new EnumChatFormatting[] { RED, GOLD, YELLOW, GREEN, AQUA,
        BLUE, LIGHT_PURPLE };

    public static String makeFabulous(String input) {
        return ludicrousFormatting(input, fabulousness, 80.0, 1, 1);
    }

    private static final EnumChatFormatting[] sanic = new EnumChatFormatting[] { BLUE, BLUE, BLUE, BLUE, WHITE, BLUE,
        WHITE, WHITE, BLUE, WHITE, WHITE, BLUE, RED, WHITE, GRAY, GRAY, GRAY, GRAY, GRAY, GRAY, GRAY, GRAY, GRAY, GRAY,
        GRAY, GRAY, GRAY, GRAY, GRAY };

    public static String makeSANIC(String input) {
        return ludicrousFormatting(input, sanic, 50.0, 2, 1);
    }

    public static String ludicrousFormatting(String input, EnumChatFormatting[] colours, double delay, int step,
        int posstep) {
        StringBuilder sb = new StringBuilder(input.length() * 3);
        if (delay <= 0) {
            delay = 0.001;
        }

        long systemTime = Minecraft.getSystemTime();
        if (systemTime == 0) {
            return input;
        }

        int offset = (int) Math.floor(systemTime / delay) % colours.length;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int col = ((i * posstep) + colours.length - offset) % colours.length;
            sb.append(colours[col].toString());
            sb.append(c);
        }

        return sb.toString();
    }

    public static String formatting(String input, EnumChatFormatting[] colours, double delay) {
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
        return formatting(
            input,
            new EnumChatFormatting[] { EnumChatFormatting.RED, EnumChatFormatting.GOLD, EnumChatFormatting.YELLOW,
                EnumChatFormatting.GREEN, EnumChatFormatting.AQUA, EnumChatFormatting.BLUE,
                EnumChatFormatting.LIGHT_PURPLE },
            80.0D);
    }
}
