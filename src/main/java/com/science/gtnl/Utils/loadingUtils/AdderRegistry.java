package com.science.gtnl.Utils.loadingUtils;

import java.util.HashSet;

public class AdderRegistry {

    public static final HashSet<Runnable> toRun = new HashSet<>();

    public AdderRegistry() {}

    public static void addAdder(Runnable adder) {
        toRun.add(adder);
    }

    public static void run() {
        for (Runnable r : toRun) r.run();
    }
}
