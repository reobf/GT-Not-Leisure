package com.science.gtnl.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

// spotless:off
public class MainConfig {

    public static long EUEveryBlazeCube = 1L * Integer.MAX_VALUE;// default 1024L * Integer.MAX_VALUE;
    public static long EUEveryDepletedExcitedNaquadahFuelRod = 2750000L * Integer.MAX_VALUE;
    public static double secondsOfArtificialStarProgressCycleTime = 6.4;
    public static boolean EnableRenderDefaultArtificialStar = true;
    public static long EUEveryStrangeAnnihilationFuelRod = 32768L * Integer.MAX_VALUE;
    public static boolean MultiBlockStructureEnable = true;
    public static boolean enablePortalToAlfheimBigBoom = true;
    public static boolean DEFAULT_BATCH_MODE = false;

    private static Configuration config;

    public static void init(File configFile) {
        if (config == null) {
            config = new Configuration(configFile);
            loadConfig();
        }
    }

    public static void reloadConfig() {
        if (config != null) {
            config.load();
            loadConfig();
        }
    }

    public static void loadConfig() {

        MultiBlockStructureEnable = config
            .get(
                "Modify multiblock structure",
                "enable",
                MultiBlockStructureEnable,
                "Setting this to enable change multiblock structure.")
            .getBoolean(MultiBlockStructureEnable);

        enablePortalToAlfheimBigBoom = config
            .get(
                "enable Portal To Alfheim Big Boom",
                "enable",
                enablePortalToAlfheimBigBoom,
                "Setting this to false will reduce the Portal To Alfheim explosion to little more then a tnt blast")
            .getBoolean(enablePortalToAlfheimBigBoom);

        if (config.hasChanged()) {
            config.save();
        }
    }
}
