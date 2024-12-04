package com.science.gtnl.mixin.Accessor;

import java.util.ArrayList;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import bartworks.common.tileentities.multis.mega.MTEMegaBlastFurnace;
import gregtech.api.metatileentity.implementations.MTEHatchOutput;

@Mixin(value = MTEMegaBlastFurnace.class, remap = false)
public interface MTEMegaBlastFurnaceAccessor {

    @Accessor("mPollutionOutputHatches")
    ArrayList<MTEHatchOutput> getPollutionOutputHatches();

    @Accessor("CASING_INDEX")
    static int getCasingIndex() {
        throw new AssertionError();
    }

    /**
     * 暴露 `glassTier` 字段的 getter。
     */
    @Accessor("glassTier")
    byte getGlassTier();

    @Accessor("glassTier")
    void setGlassTier(byte value);
}
