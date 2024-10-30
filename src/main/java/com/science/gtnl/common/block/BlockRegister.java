package com.science.gtnl.common.block;

import static com.science.gtnl.common.block.BasicBlocks.MetaBlock01;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.science.gtnl.common.block.Casings.MetaItemBlockCasing;
import com.science.gtnl.common.item.GTNLItemList;

import cpw.mods.fml.common.registry.GameRegistry;
import gtPlusPlus.core.item.base.itemblock.ItemBlockMeta;

public class BlockRegister {

    public static Block Stargate_Coil = new BlockBase("Stargate_Coil", "stargate_coil");
    public static Block New_Horizons_Coil = new BlockBase("New_Horizons_Coil", "new_horizons_coil");
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

        GameRegistry.registerBlock(MetaBlock01, ItemBlockBase01.class, MetaBlock01.getUnlocalizedName());

        GameRegistry.registerBlock(
            BasicBlocks.MetaBlockCasing01,
            MetaItemBlockCasing.class,
            BasicBlocks.MetaBlockCasing01.getUnlocalizedName());

        GameRegistry.registerBlock(Stargate_Coil, "Stargate Coli");
        GTNLItemList.Stargate_Coil.set(new ItemStack(Stargate_Coil));
        GameRegistry.registerBlock(New_Horizons_Coil, "New Horizons Coil");
        GTNLItemList.New_Horizons_Coil.set(new ItemStack(New_Horizons_Coil));
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

        GTNLItemList.TestMetaBlock01_0.set(ItemBlockBase01.initMetaBlock01("TestMetaBlock01_0", 0));
        GTNLItemList.TestCasing
            .set(MetaBlockConstructors.initMetaBlockCasing("Test Casing", (byte) 0, BasicBlocks.MetaBlockCasing01));
        GTNLItemList.SteamAssemblyCasing.set(
            MetaBlockConstructors.initMetaBlockCasing("SteamAssemblyCasing", (byte) 1, BasicBlocks.MetaBlockCasing01));

    }

    public static void registry() {
        registryBlocks();
        registryBlockContainers();
    }
}
