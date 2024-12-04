package com.science.gtnl;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static Configuration config;
    public static boolean enablePortalToAlfheimBigBoom;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        enablePortalToAlfheimBigBoom = configuration
            .get(
                "enablePortalToAlfheimBigBoom",
                "EnableBigExplosion",
                true,
                "Setting this to false will reduce the Portal To Alfheim explosion to little more then a tnt blast")
            .getBoolean(true);

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    public static boolean DEFAULT_BATCH_MODE = false;
}
