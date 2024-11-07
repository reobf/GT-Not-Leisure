package com.science.gtnl.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import gregtech.api.metatileentity.implementations.MTETieredMachineBlock;

@Mixin(MTETieredMachineBlock.class)
public abstract class MTETieredMachineBlockMixin {

    @Shadow
    @Mutable
    public String[] mDescriptionArray;

}
