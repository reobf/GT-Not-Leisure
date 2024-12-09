package com.science.gtnl.mixin.Accessor;

import java.util.ArrayList;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import bartworks.common.tileentities.multis.mega.MTEMegaBlastFurnace;
import gregtech.api.enums.HeatingCoilLevel;
import gregtech.api.metatileentity.implementations.MTEHatchOutput;

@Mixin(value = MTEMegaBlastFurnace.class, remap = false)
public interface MTEMegaBlastFurnaceAccessor {

    @Accessor("mPollutionOutputHatches")
    ArrayList<MTEHatchOutput> getPollutionOutputHatches();

    @Accessor("CASING_INDEX")
    static int getCasingIndex() {
        throw new AssertionError();
    }

    @Accessor("mCoilLevel") // 如果字段是私有的
    HeatingCoilLevel getCoilLevel();

    @Accessor
    void setMHeatingCapacity(int capacity);

}
