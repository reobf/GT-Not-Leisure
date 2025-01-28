package com.science.gtnl;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.science.gtnl.Utils.item.TextHandler;
import com.science.gtnl.common.effect.effects.AweEffect;
import com.science.gtnl.common.item.tools.BlazePickaxe;
import com.science.gtnl.common.item.tools.CrystalShovel;
import com.science.gtnl.common.item.tools.InfinityTotem;
import com.science.gtnl.common.machine.multiMachineClasses.EdenGardenManager.EIGBucketLoader;
import com.science.gtnl.common.recipe.GTNLRecipeRemover;
import com.science.gtnl.config.MainConfig;
import com.science.gtnl.loader.LazyStaticsInitLoader;
import com.science.gtnl.loader.MachineLoader;
import com.science.gtnl.loader.MaterialLoader;
import com.science.gtnl.loader.OreDictLoader;
import com.science.gtnl.loader.RecipeLoader;
import com.science.gtnl.loader.ScriptLoader;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

// after
@Mod(
    modid = ScienceNotLeisure.MODID,
    version = ScienceNotLeisure.VERSION,
    name = ScienceNotLeisure.MODNAME,
    dependencies = "required-after:IC2;" + "required-after:structurelib;"
        + "required-after:AWWayofTime;"
        + "required-after:BloodArsenal;"
        + "required-after:modularui;"
        + "after:GalacticraftCore;"
        + "required-after:bartworks;"
        + "after:miscutils;"
        + "required-after:dreamcraft;"
        + "after:GalacticraftMars;"
        + "required-after:gregtech;"
        + "after:TwistSpaceTechnology;"
        + "after:GalacticraftPlanets",
    acceptedMinecraftVersions = "1.7.10")

public class ScienceNotLeisure {

    public static final String MODID = "ScienceNotLeisure";

    public static final String MODNAME = "GTNotLeisure";

    public static final String VERSION = "v0.1.8";

    public static final String Arthor = "HFstudio";

    public static final String RESOURCE_ROOT_ID = "sciencenotleisure";

    public static final Logger LOG = LogManager.getLogger(MODID);

    /**
     * <li>The signal of whether in Development Mode.
     * <li>Keep care to set 'false' when dev complete.
     */
    public static final boolean isInDevMode = false;

    public static String DevResource = "";

    @SidedProxy(clientSide = "com.science.gtnl.ClientProxy", serverSide = "com.science.gtnl.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        new LazyStaticsInitLoader().initStaticsOnInit();
        MachineLoader.loadMachines();
        MachineLoader.run();

        MinecraftForge.EVENT_BUS.register(new AweEffect());
        MinecraftForge.EVENT_BUS.register(new CrystalShovel());
        MinecraftForge.EVENT_BUS.register(new InfinityTotem());
        MinecraftForge.EVENT_BUS.register(new BlazePickaxe());
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
        EIGBucketLoader.LoadEIGBuckets();
        RecipeLoader.RecipeLoad();
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void completeInit(FMLLoadCompleteEvent event) {
        ScriptLoader.run();
        OreDictLoader.loadOreDictionary();
        RecipeLoader.loadRecipes();
        RecipeLoader.loadRecipesPostInit();

        GTNLRecipeRemover.run();

        new LazyStaticsInitLoader().initStaticsOnCompleteInit();

        TextHandler.serializeLangMap(isInDevMode);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
        event.registerServerCommand(new CommandReloadConfig());

    }

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        File configDir = new File(event.getModConfigurationDirectory(), "GTNotLeisure");

        if (!configDir.exists()) {
            configDir.mkdirs();
        }

        File mainConfigFile = new File(configDir, "main.cfg");

        MainConfig.init(mainConfigFile);

        proxy.preInit(event);
        MaterialLoader.load();
    }
}
