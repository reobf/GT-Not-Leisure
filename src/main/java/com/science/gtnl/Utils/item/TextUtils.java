package com.science.gtnl.Utils.item;

import static gregtech.api.enums.Mods.GregTech;
import static net.minecraft.util.EnumChatFormatting.*;
import static net.minecraft.util.EnumChatFormatting.GRAY;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class TextUtils {

    public static final String SCIENCE_NOT_LEISURE = "Science Not Leisure";
    public static final String AE = EnumChatFormatting.BLUE + TextLocalization.AppliedEnergistics2;
    public static final String SRP = EnumChatFormatting.BLUE + TextLocalization.StructuralReconstructionPlan;
    public static final String SQY = "§r§6§l§o犰狳重工";
    public static final String NLC = "§r X §l§o§f年§6轮§f新§6城§f计§6划 §r§fby 咸到老时变成鱼";

    private static final EnumChatFormatting[] colors = new EnumChatFormatting[] { EnumChatFormatting.RED,
        EnumChatFormatting.GOLD, EnumChatFormatting.YELLOW, EnumChatFormatting.GREEN, EnumChatFormatting.AQUA,
        EnumChatFormatting.BLUE, EnumChatFormatting.LIGHT_PURPLE };

    public static String makeFabulous(String input) {
        return ludicrousFormatting(input, colors, 80.0, 1, 1);
    }

    public static String makeColor(String input) {
        return ludicrousFormatting(input, colors, 100.0, 1, 1);
    }

    private static final EnumChatFormatting[] sanic = new EnumChatFormatting[] { BLUE, BLUE, BLUE, BLUE, WHITE, BLUE,
        WHITE, WHITE, BLUE, WHITE, WHITE, BLUE, RED, WHITE, GRAY, GRAY, GRAY, GRAY, GRAY, GRAY, GRAY, GRAY, GRAY, GRAY,
        GRAY, GRAY, GRAY, GRAY, GRAY, GRAY };

    public static String makeSANIC(String input) {
        return ludicrousFormatting(input, sanic, 50.0, 2, 1);
    }

    public static String ludicrousFormatting(String input, EnumChatFormatting[] colours, double delay, int step,
        int posstep) {
        if (Minecraft.getMinecraft() == null) {
            return input;
        }

        StringBuilder sb = new StringBuilder(input.length() * 3);
        if (delay <= 0) {
            delay = 0.001;
        }

        int offset = (int) Math.floor(
            Minecraft.getMinecraft()
                .getSystemTime() / delay)
            % colours.length;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            int col = ((i * posstep) + colours.length - offset) % colours.length;

            sb.append(colours[col].toString());
            sb.append(c);
        }

        return sb.toString();
    }

    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event) {
        if (event.itemStack.getItem() == GameRegistry.findItem(GregTech.ID, "gt.blockmachines")) {
            int meta = event.itemStack.getItemDamage();
            if (meta >= 21000 && meta <= 23000) {
                for (int x = 0; x < event.toolTip.size(); x++) {
                    if (event.toolTip.get(x)
                        .contains(StatCollector.translateToLocal("GT5U.MBTT.Mod"))
                        || event.toolTip.get(x)
                            .contains("Science Not Leisure")) {
                        if (event.toolTip.get(x)
                            .contains(StatCollector.translateToLocal("StructuralReconstructionPlan"))) {
                            if (event.toolTip.get(x)
                                .contains("犰狳重工")) {
                                event.toolTip.set(
                                    x,
                                    TextLocalization.Adder + TextUtils.makeFabulous("Science Not Leisure: ")
                                        + "§r§6§l§o犰狳重工"
                                        + EnumChatFormatting.BLUE
                                        + " X "
                                        + TextUtils.makeSANIC(TextLocalization.StructuralReconstructionPlan));
                                return;
                            } else {
                                event.toolTip.set(
                                    x,
                                    TextLocalization.Adder + TextUtils.makeFabulous("Science Not Leisure: ")
                                        + TextUtils.makeSANIC(TextLocalization.StructuralReconstructionPlan));
                                return;
                            }
                        } else if (event.toolTip.get(x)
                            .contains("犰狳重工")) {
                                event.toolTip.set(
                                    x,
                                    TextLocalization.Adder + TextUtils.makeFabulous("Science Not Leisure: ")
                                        + "§r§6§l§o犰狳重工");
                                return;
                            } else if (event.toolTip.get(x)
                                .contains("Totto")) {
                                    event.toolTip.set(
                                        x,
                                        TextLocalization.Adder + TextUtils.makeFabulous("Science Not Leisure")
                                            + EnumChatFormatting.BLUE
                                            + " X Author: "
                                            + TextUtils.makeColor("Totto"));
                                    return;
                                } else if (event.toolTip.get(x)
                                    .contains("咸到老时变成鱼")) {
                                        event.toolTip.set(
                                            x,
                                            TextLocalization.Adder + TextUtils.makeFabulous("Science Not Leisure")
                                                + EnumChatFormatting.BLUE
                                                + " X "
                                                + TextUtils.makeColor("年轮新城计划 by 咸到老时变成鱼"));
                                        return;
                                    } else {
                                        event.toolTip.set(
                                            x,
                                            TextLocalization.Adder + TextUtils.makeFabulous("Science Not Leisure"));
                                        return;
                                    }
                    }
                }
            }
        }
    }
}
