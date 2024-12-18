package com.science.gtnl.config;

import java.io.File;

public class Config {

    public static void init(File mainConfigFile) {
        MainConfig.init(mainConfigFile);
    }

    public static void reloadConfig() {
        MainConfig.reloadConfig();
    }
}
