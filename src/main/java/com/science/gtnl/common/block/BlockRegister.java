package com.science.gtnl.common.block;

import static com.science.gtnl.common.block.Casings.BasicBlocks.*;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;

import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.block.Casings.Base.ItemBlockBase;
import com.science.gtnl.common.block.Casings.BasicBlocks;
import com.science.gtnl.common.block.Casings.Casing.MetaBlockConstructors;
import com.science.gtnl.common.block.Casings.Casing.MetaItemBlockCasing;
import com.science.gtnl.common.block.Casings.Column.ItemBlockColumn;
import com.science.gtnl.common.block.Casings.Glass.ItemBlockGlass;
import com.science.gtnl.common.block.Casings.Glow.ItemBlockGlow;
import com.science.gtnl.common.block.Casings.Special.BlocksStargate;
import com.science.gtnl.common.block.Casings.Special.StargateMetaBlockBase;
import com.science.gtnl.common.block.Render.BlockLaserBeacon;
import com.science.gtnl.common.block.Render.BlockStar;
import com.science.gtnl.common.block.Render.TileEntityLaserBeacon;
import com.science.gtnl.common.block.Render.TileStar;
import com.science.gtnl.common.block.blocks.BlockSoulFarmland;

import cpw.mods.fml.common.registry.GameRegistry;
import gtPlusPlus.core.item.base.itemblock.ItemBlockMeta;

public class BlockRegister {

    public static Block StargateTier0 = new BlocksStargate(0);
    public static Block StargateTier1 = new BlocksStargate(1);
    public static Block StargateTier2 = new BlocksStargate(2);
    public static Block StargateTier3 = new BlocksStargate(3);
    public static Block StargateTier4 = new BlocksStargate(4);
    public static Block StargateTier5 = new BlocksStargate(5);
    public static Block StargateTier6 = new BlocksStargate(6);
    public static Block StargateTier7 = new BlocksStargate(7);
    public static Block StargateTier8 = new BlocksStargate(8);
    public static Block StargateTier9 = new BlocksStargate(9);
    public static Block Stargate_Coil_Compressed = new StargateMetaBlockBase(
        "Stargate_Coil_Compressed",
        new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });

    public static void registryBlocks() {

        BlockSoulFarmland = new BlockSoulFarmland();
        GameRegistry.registerBlock(BlockSoulFarmland, "BlockSoulFarmland");

        BlockStar = new BlockStar();
        GameRegistry.registerTileEntity(TileStar.class, "RealArtificialStarRender");

        BlockLaserBeacon = new BlockLaserBeacon();
        GameRegistry.registerTileEntity(TileEntityLaserBeacon.class, "BlockLaserBeacon");

        GameRegistry.registerBlock(MetaBlock, ItemBlockBase.class, MetaBlock.getUnlocalizedName());
        GameRegistry.registerBlock(MetaBlockGlow, ItemBlockGlow.class, MetaBlockGlow.getUnlocalizedName());
        GameRegistry.registerBlock(MetaBlockGlass, ItemBlockGlass.class, MetaBlockGlass.getUnlocalizedName());
        GameRegistry.registerBlock(MetaBlockColumn, ItemBlockColumn.class, MetaBlockColumn.getUnlocalizedName());

        GameRegistry.registerBlock(
            BasicBlocks.MetaBlockCasing,
            MetaItemBlockCasing.class,
            BasicBlocks.MetaBlockCasing.getUnlocalizedName());

        GameRegistry.registerBlock(StargateTier0, "StargateTier0");
        GTNLItemList.StargateTier0.set(new ItemStack(StargateTier0));
        GameRegistry.registerBlock(StargateTier1, "StargateTier1");
        GTNLItemList.StargateTier1.set(new ItemStack(StargateTier1));
        GameRegistry.registerBlock(StargateTier2, "StargateTier2");
        GTNLItemList.StargateTier2.set(new ItemStack(StargateTier2));
        GameRegistry.registerBlock(StargateTier3, "StargateTier3");
        GTNLItemList.StargateTier3.set(new ItemStack(StargateTier3));
        GameRegistry.registerBlock(StargateTier4, "StargateTier4");
        GTNLItemList.StargateTier4.set(new ItemStack(StargateTier4));
        GameRegistry.registerBlock(StargateTier5, "StargateTier5");
        GTNLItemList.StargateTier5.set(new ItemStack(StargateTier5));
        GameRegistry.registerBlock(StargateTier6, "StargateTier6");
        GTNLItemList.StargateTier6.set(new ItemStack(StargateTier6));
        GameRegistry.registerBlock(StargateTier7, "StargateTier7");
        GTNLItemList.StargateTier7.set(new ItemStack(StargateTier7));
        GameRegistry.registerBlock(StargateTier8, "StargateTier8");
        GTNLItemList.StargateTier8.set(new ItemStack(StargateTier8));
        GameRegistry.registerBlock(StargateTier9, "StargateTier9");
        GTNLItemList.StargateTier9.set(new ItemStack(StargateTier9));
        GameRegistry.registerBlock(Stargate_Coil_Compressed, ItemBlockMeta.class, "Stargate Coil Compressed");
        GTNLItemList.Stargate_Coil_Compressed.set(new ItemStack(Stargate_Coil_Compressed));
    }

    public static void registryBlockContainers() {

        GTNLItemList.TestMetaBlock01_0.set(ItemBlockBase.initMetaBlock("TestMetaBlock01_0", 0));
        GTNLItemList.NewHorizonsCoil.set(
            ItemBlockBase.initMetaBlock(
                "NewHorizonsCoil",
                1,
                new String[] { StatCollector.translateToLocal("gt.coilheattooltip"),
                    "179,769,313,486,231,590,772,930,519,078,902,473,361,797,697,894,230,657,273,430,081.",
                    "157,732,675,805,500,963,132,708,477,322,407,536,021,120,113,879,871,393,357,658,789,",
                    "768,814,416,622,492,847,430,639,474,124,377,767,893,424,865,485,276,302,219,601,246,",
                    "094,119,453,082,952,085,005,768,838,150,682,342,462,881,473,913,110,540,827,237,163,",
                    "350,510,684,586,298,239,947,245,938,479,716,304,835,356,329,624,224,137,216"
                        + StatCollector.translateToLocal("gt.coilunittooltip") }));
        GTNLItemList.StargateCoil.set(ItemBlockBase.initMetaBlock("StargateCoil", 2));
        GTNLItemList.BlackLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Black_Lamp_Off",
                3,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.BlackLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Black_Lamp_Off_Borderless",
                4,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.PinkLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Pink_Lamp_Off",
                5,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.PinkLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Pink_Lamp_Off_Borderless",
                6,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.RedLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Red_Lamp_Off",
                7,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.RedLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Red_Lamp_Off_Borderless",
                8,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.OrangeLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Orange_Lamp_Off",
                9,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.OrangeLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Orange_Lamp_Off_Borderless",
                10,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.YellowLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Yellow_Lamp_Off",
                11,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.YellowLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Yellow_Lamp_Off_Borderless",
                12,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.GreenLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Green_Lamp_Off",
                13,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.GreenLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Green_Lamp_Off_Borderless",
                14,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.LimeLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Lime_Lamp_Off",
                15,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.LimeLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Lime_Lamp_Off_Borderless",
                16,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.BlueLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Blue_Lamp_Off",
                17,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.BlueLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Blue_Lamp_Off_Borderless",
                18,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.LightBlueLampOff.set(
            ItemBlockBase.initMetaBlock(
                "LightBlue_Lamp_Off",
                19,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.LightBlueLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "LightBlue_Lamp_Off_Borderless",
                20,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.CyanLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Cyan_Lamp_Off",
                21,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.CyanLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Cyan_Lamp_Off_Borderless",
                22,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.BrownLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Brown_Lamp_Off",
                23,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.BrownLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Brown_Lamp_Off_Borderless",
                24,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.MagentaLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Magenta_Lamp_Off",
                25,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.MagentaLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Magenta_Lamp_Off_Borderless",
                26,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.PurpleLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Purple_Lamp_Off",
                27,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.PurpleLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Purple_Lamp_Off_Borderless",
                28,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.GrayLampOff.set(
            ItemBlockBase.initMetaBlock(
                "Gray_Lamp_Off",
                29,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.GrayLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "Gray_Lamp_Off_Borderless",
                30,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.LightGrayLampOff.set(
            ItemBlockBase.initMetaBlock(
                "LightGray_Lamp_Off",
                31,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.LightGrayLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "LightGray_Lamp_Off_Borderless",
                32,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.WhiteLampOff.set(
            ItemBlockBase.initMetaBlock(
                "White_Lamp_Off",
                33,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow") }));
        GTNLItemList.WhiteLampOffBorderless.set(
            ItemBlockBase.initMetaBlock(
                "White_Lamp_Off_Borderless",
                34,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.noglow"),
                    StatCollector.translateToLocal("tooltip.lamp.borderless") }));

        GTNLItemList.FortifyGlowstone.set(ItemBlockGlow.initMetaBlockGlow("Fortify_Glowstone", 0));
        GTNLItemList.BlackLamp.set(ItemBlockGlow.initMetaBlockGlow("Black_Lamp", 1));
        GTNLItemList.BlackLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Black_Lamp_Borderless",
                2,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.PinkLamp.set(ItemBlockGlow.initMetaBlockGlow("Pink_Lamp", 3));
        GTNLItemList.PinkLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Pink_Lamp_Borderless",
                4,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.RedLamp.set(ItemBlockGlow.initMetaBlockGlow("Red_Lamp", 5));
        GTNLItemList.RedLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Red_Lamp_Borderless",
                6,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.OrangeLamp.set(ItemBlockGlow.initMetaBlockGlow("Orange_Lamp", 7));
        GTNLItemList.OrangeLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Orange_Lamp_Borderless",
                8,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.YellowLamp.set(ItemBlockGlow.initMetaBlockGlow("Yellow_Lamp", 9));
        GTNLItemList.YellowLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Yellow_Lamp_Borderless",
                10,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.GreenLamp.set(ItemBlockGlow.initMetaBlockGlow("Green_Lamp", 11));
        GTNLItemList.GreenLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Green_Lamp_Borderless",
                12,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.LimeLamp.set(ItemBlockGlow.initMetaBlockGlow("Lime_Lamp", 13));
        GTNLItemList.LimeLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Lime_Lamp_Borderless",
                14,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.BlueLamp.set(ItemBlockGlow.initMetaBlockGlow("Blue_Lamp", 15));
        GTNLItemList.BlueLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Blue_Lamp_Borderless",
                16,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.LightBlueLamp.set(ItemBlockGlow.initMetaBlockGlow("LightBlue_Lamp", 17));
        GTNLItemList.LightBlueLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "LightBlue_Lamp_Borderless",
                18,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.CyanLamp.set(ItemBlockGlow.initMetaBlockGlow("Cyan_Lamp", 19));
        GTNLItemList.CyanLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Cyan_Lamp_Borderless",
                20,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.BrownLamp.set(ItemBlockGlow.initMetaBlockGlow("Brown_Lamp", 21));
        GTNLItemList.BrownLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Brown_Lamp_Borderless",
                22,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.MagentaLamp.set(ItemBlockGlow.initMetaBlockGlow("Magenta_Lamp", 23));
        GTNLItemList.MagentaLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Magenta_Lamp_Borderless",
                24,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.PurpleLamp.set(ItemBlockGlow.initMetaBlockGlow("Purple_Lamp", 25));
        GTNLItemList.PurpleLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Purple_Lamp_Borderless",
                26,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.GrayLamp.set(ItemBlockGlow.initMetaBlockGlow("Gray_Lamp", 27));
        GTNLItemList.GrayLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "Gray_Lamp_Borderless",
                28,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.LightGrayLamp.set(ItemBlockGlow.initMetaBlockGlow("LightGray_Lamp", 29));
        GTNLItemList.LightGrayLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "LightGray_Lamp_Borderless",
                30,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));
        GTNLItemList.WhiteLamp.set(ItemBlockGlow.initMetaBlockGlow("White_Lamp", 31));
        GTNLItemList.WhiteLampBorderless.set(
            ItemBlockGlow.initMetaBlockGlow(
                "White_Lamp_Borderless",
                32,
                new String[] { StatCollector.translateToLocal("tooltip.lamp.borderless") }));

        GTNLItemList.GaiaGlass.set(ItemBlockGlass.initMetaBlockGlass("GaiaGlass", 0));
        GTNLItemList.TerraGlass.set(ItemBlockGlass.initMetaBlockGlass("TerraGlass", 1));
        GTNLItemList.FusionGlass.set(ItemBlockGlass.initMetaBlockGlass("FusionGlass", 2));

        GTNLItemList.BronzeBrickCasing.set(ItemBlockColumn.initMetaBlock("BronzeBrickCasing", 0));
        GTNLItemList.SteelBrickCasing.set(ItemBlockColumn.initMetaBlock("SteelBrickCasing", 1));

        GTNLItemList.TestCasing
            .set(MetaBlockConstructors.initMetaBlockCasing("Test Casing", (byte) 0, BasicBlocks.MetaBlockCasing));
        GTNLItemList.SteamAssemblyCasing.set(
            MetaBlockConstructors.initMetaBlockCasing("Steam Assembly Casing", (byte) 1, BasicBlocks.MetaBlockCasing));
        GTNLItemList.HeatVent
            .set(MetaBlockConstructors.initMetaBlockCasing("Heat Vent", (byte) 2, BasicBlocks.MetaBlockCasing));
        GTNLItemList.SlicingBlades
            .set(MetaBlockConstructors.initMetaBlockCasing("Slicing Blades", (byte) 3, BasicBlocks.MetaBlockCasing));
        GTNLItemList.NeutroniumPipeCasing.set(
            MetaBlockConstructors.initMetaBlockCasing("Neutronium Pipe Casing", (byte) 4, BasicBlocks.MetaBlockCasing));
        GTNLItemList.NeutroniumGearbox.set(
            MetaBlockConstructors.initMetaBlockCasing("Neutronium Gearbox", (byte) 5, BasicBlocks.MetaBlockCasing));
        GTNLItemList.Laser_Cooling_Casing.set(
            MetaBlockConstructors.initMetaBlockCasing("Laser Cooling Casing", (byte) 6, BasicBlocks.MetaBlockCasing));
        GTNLItemList.Antifreeze_Heatproof_Machine_Casing.set(
            MetaBlockConstructors
                .initMetaBlockCasing("Antifreeze Heatproof Machine Casing", (byte) 7, BasicBlocks.MetaBlockCasing));
        GTNLItemList.MolybdenumDisilicideCoil.set(
            MetaBlockConstructors
                .initMetaBlockCasing("Molybdenum Disilicide Coil", (byte) 8, BasicBlocks.MetaBlockCasing));
        GTNLItemList.EnergeticPhotovoltaicBlock.set(
            MetaBlockConstructors
                .initMetaBlockCasing("Energetic Photovoltaic Block", (byte) 9, BasicBlocks.MetaBlockCasing));
        GTNLItemList.AdvancedPhotovoltaicBlock.set(
            MetaBlockConstructors
                .initMetaBlockCasing("Advanced Photovoltaic Block", (byte) 10, BasicBlocks.MetaBlockCasing));
        GTNLItemList.VibrantPhotovoltaicBlock.set(
            MetaBlockConstructors
                .initMetaBlockCasing("Vibrant Photovoltaic Block", (byte) 11, BasicBlocks.MetaBlockCasing));
    }

    public static void registry() {
        registryBlocks();
        registryBlockContainers();
    }

    public static void registryOreDictionary() {
        ItemStack GaiaGlass = new ItemStack(MetaBlockGlass, 1, 0);
        ItemStack TerraGlass = new ItemStack(MetaBlockGlass, 1, 1);
        ItemStack FusionGlass = new ItemStack(MetaBlockGlass, 1, 2);

        for (int LampMeta = 1; LampMeta <= 32; LampMeta++) {
            ItemStack LampTier = new ItemStack(MetaBlockGlow, 1, LampMeta);
            OreDictionary.registerOre("blockGlassHV", LampTier);
            OreDictionary.registerOre("blockGlass", LampTier);
        }

        for (int LampOffMeta = 3; LampOffMeta <= 34; LampOffMeta++) {
            ItemStack LampOffTier = new ItemStack(MetaBlock, 1, LampOffMeta);
            OreDictionary.registerOre("blockGlassHV", LampOffTier);
            OreDictionary.registerOre("blockGlass", LampOffTier);
        }

        OreDictionary.registerOre("blockGlassUEV", GaiaGlass);
        OreDictionary.registerOre("blockGlassUV", TerraGlass);
        OreDictionary.registerOre("blockGlassLuV", FusionGlass);
    }
}
