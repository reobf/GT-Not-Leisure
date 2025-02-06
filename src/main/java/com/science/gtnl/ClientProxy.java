package com.science.gtnl;

import com.science.gtnl.Utils.LangMerger;
import net.minecraftforge.client.MinecraftForgeClient;

import com.science.gtnl.Utils.GuiEventHandler;
import com.science.gtnl.common.block.ReAvaritia.ExtremeAnvil.RenderExtremeAnvil;
import com.science.gtnl.common.block.ReAvaritia.ExtremeAnvil.TileEntityExtremeAnvil;
import com.science.gtnl.common.block.Render.MeteorMinerRenderer;
import com.science.gtnl.common.block.Render.RealArtificialStarRender;
import com.science.gtnl.common.block.Render.StarRender;
import com.science.gtnl.common.item.ItemLoader;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fox.spiteful.avaritia.render.CosmicItemRenderer;

public class ClientProxy extends CommonProxy {

    public static int extremeAnvilRenderType;

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        new RealArtificialStarRender();
        new MeteorMinerRenderer();
        RenderingRegistry.registerBlockHandler(new StarRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityExtremeAnvil.class, new RenderExtremeAnvil());
        extremeAnvilRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderExtremeAnvil());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        new GuiEventHandler();
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        new LangMerger().processLanguageFiles();
    }

    @Override
    public void makeThingsPretty() {
        CosmicItemRenderer sparkly = new CosmicItemRenderer();
        MinecraftForgeClient.registerItemRenderer(ItemLoader.InfinitySword, sparkly);
        MinecraftForgeClient.registerItemRenderer(ItemLoader.MatterCluster, sparkly);
    }
}
