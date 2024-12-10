package com.science.gtnl.mixin;

import com.gtnewhorizon.structurelib.alignment.IAlignment;
import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import gregtech.api.interfaces.modularui.IAddUIWidgets;
import gregtech.api.interfaces.modularui.IGetTitleColor;
import gregtech.api.interfaces.tileentity.RecipeMapWorkable;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.common.tileentities.machines.multi.MTEPrimitiveBlastFurnace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = MTEPrimitiveBlastFurnace.class,remap = false)
public abstract class MixinsPrimitiveBlastFurnace extends MetaTileEntity
    implements IAlignment, ISurvivalConstructable, RecipeMapWorkable, IAddUIWidgets, IGetTitleColor {

    public MixinsPrimitiveBlastFurnace(int aID, String aBasicName, String aRegionalName, int aInvSlotCount) {
        super(aID, aBasicName, aRegionalName, aInvSlotCount);
    }

    @Inject(method = "checkRecipe", at = @At("RETURN"), cancellable = true)
    private void modifyRecipeDuration(CallbackInfoReturnable<Boolean> cir) {
        MTEPrimitiveBlastFurnace self = (MTEPrimitiveBlastFurnace) (Object) this;

        if (self.mMaxProgresstime > 0) {
            self.mMaxProgresstime = 20; // 确保最小值为 1
        }
    }
}
