package com.science.gtnl.common.machine.DSP;

import com.science.gtnl.config.Config;

public final class DSP_Values {

    public static final double secondsOfArtificialStarProgressCycleTime = Config.secondsOfArtificialStarProgressCycleTime;// default
                                                                                                                          // 6.4
    public static final byte EnableRenderDefaultArtificialStar = (byte) (Config.EnableRenderDefaultArtificialStar ? 1
        : 0);
}
