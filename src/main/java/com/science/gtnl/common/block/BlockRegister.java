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
        GTNLItemList.TungstenSteelGearbox.set(
            MetaBlockConstructors.initMetaBlockCasing("Tungsten Steel Gearbox", (byte) 8, BasicBlocks.MetaBlockCasing));

    }

    public static void registry() {
        registryBlocks();
        registryBlockContainers();
    }

    public static void registryOreDictionary() {
        ItemStack GaiaGlass = new ItemStack(MetaBlockGlass, 1, 0);
        ItemStack TerraGlass = new ItemStack(MetaBlockGlass, 1, 1);
        ItemStack FusionGlass = new ItemStack(MetaBlockGlass, 1, 2);

        OreDictionary.registerOre("blockGlassUEV", GaiaGlass);
        OreDictionary.registerOre("blockGlassUV", TerraGlass);
        OreDictionary.registerOre("blockGlassLuV", FusionGlass);
    }
}
