package com.science.gtnl.mixin.Accessor;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import com.gtnewhorizon.structurelib.structure.IStructureDefinition;

import gregtech.common.tileentities.machines.multi.MTEPrimitiveBlastFurnace;

@Mixin(value = MTEPrimitiveBlastFurnace.class, remap = false)
public interface PrimitiveBlastFurnaceAccessor {

    @Accessor("STRUCTURE_DEFINITION")
    static ClassValue<IStructureDefinition<MTEPrimitiveBlastFurnace>> getStructureDefinition() {
        throw new AssertionError();
    }

    @Accessor("mMachine")
    boolean getMMachine();

    @Accessor("mMachine")
    void setMMachine(boolean value);
}
