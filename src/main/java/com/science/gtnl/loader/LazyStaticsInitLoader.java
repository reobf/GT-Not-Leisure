package com.science.gtnl.loader;

import com.science.gtnl.machine.RealArtificialStar;
import com.science.gtnl.machine.TeleportationArrayToAlfheim;
import com.science.gtnl.misc.CheckRecipeResults.CheckRecipeResults;

public class LazyStaticsInitLoader {

    public void initStaticsOnInit() {
        CheckRecipeResults.initStatics();
    }

    public void initStaticsOnCompleteInit() {
        RealArtificialStar.initStatics();
        TeleportationArrayToAlfheim.initStatics();
    }
}
