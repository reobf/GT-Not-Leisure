package com.science.gtnl.loader;

import com.science.gtnl.common.recipe.Special.PortalToAlfheimOreRecipes;
import com.science.gtnl.common.recipe.Special.WoodDistillationRecipes;

import gregtech.api.util.GTLog;

public class RecipeLoaderRunnable implements Runnable {

    @Override
    public void run() {
        GTLog.out.println("GTNL: Register Ore Dictionary Recipe.");
        new WoodDistillationRecipes();
        new PortalToAlfheimOreRecipes();
    }
}
