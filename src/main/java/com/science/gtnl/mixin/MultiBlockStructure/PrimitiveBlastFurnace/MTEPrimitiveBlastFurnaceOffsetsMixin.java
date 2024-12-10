package com.science.gtnl.mixin.MultiBlockStructure.PrimitiveBlastFurnace;

import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.gtnewhorizon.structurelib.alignment.IAlignment;
import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.science.gtnl.mixin.Accessor.PrimitiveBlastFurnaceAccessor;

import gregtech.api.interfaces.modularui.IAddUIWidgets;
import gregtech.api.interfaces.modularui.IGetTitleColor;
import gregtech.api.interfaces.tileentity.RecipeMapWorkable;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.common.tileentities.machines.multi.MTEPrimitiveBlastFurnace;

@Mixin(value = MTEPrimitiveBlastFurnace.class, remap = false)
public abstract class MTEPrimitiveBlastFurnaceOffsetsMixin extends MetaTileEntity
    implements IAlignment, ISurvivalConstructable, RecipeMapWorkable, IAddUIWidgets, IGetTitleColor {

    public MTEPrimitiveBlastFurnaceOffsetsMixin(int aID, String aBasicName, String aRegionalName, int aInvSlotCount) {
        super(aID, aBasicName, aRegionalName, aInvSlotCount);
    }

    /**
     * 修改 checkMachine 方法，调整结构偏移量
     */
    @Inject(method = "checkMachine", at = @At("HEAD"), cancellable = true)
    private void injectCheckMachine(CallbackInfoReturnable<Boolean> cir) {

        boolean mMachine = ((PrimitiveBlastFurnaceAccessor) this).getMMachine();

        ClassValue<IStructureDefinition<MTEPrimitiveBlastFurnace>> structureDefinition = PrimitiveBlastFurnaceAccessor
            .getStructureDefinition();

        boolean result = structureDefinition.get(this.getClass())
            .check(
                (MTEPrimitiveBlastFurnace) (Object) this,
                "main",
                getBaseMetaTileEntity().getWorld(),
                getExtendedFacing(),
                getBaseMetaTileEntity().getXCoord(),
                getBaseMetaTileEntity().getYCoord(),
                getBaseMetaTileEntity().getZCoord(),
                7,
                12,
                0,
                !mMachine);

        cir.setReturnValue(result);
    }

    /**
     * 修改 construct 方法，调整建造提示偏移量
     */
    @Inject(method = "construct", at = @At("HEAD"), cancellable = true)
    private void injectConstruct(ItemStack stackSize, boolean hintsOnly, CallbackInfo ci) {

        ClassValue<IStructureDefinition<MTEPrimitiveBlastFurnace>> structureDefinition = PrimitiveBlastFurnaceAccessor
            .getStructureDefinition();

        structureDefinition.get(this.getClass())
            .buildOrHints(
                (MTEPrimitiveBlastFurnace) (Object) this,
                stackSize,
                "main",
                getBaseMetaTileEntity().getWorld(),
                getExtendedFacing(),
                getBaseMetaTileEntity().getXCoord(),
                getBaseMetaTileEntity().getYCoord(),
                getBaseMetaTileEntity().getZCoord(),
                7,
                12,
                0,
                hintsOnly);

        ci.cancel();
    }

    /**
     * 修改 survivalConstruct 方法，调整生存模式建造逻辑
     */
    @Inject(method = "survivalConstruct", at = @At("HEAD"), cancellable = true)
    private void injectSurvivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env,
        CallbackInfoReturnable<Integer> cir) {

        ClassValue<IStructureDefinition<MTEPrimitiveBlastFurnace>> structureDefinition = PrimitiveBlastFurnaceAccessor
            .getStructureDefinition();

        int result = structureDefinition.get(this.getClass())
            .survivalBuild(
                (MTEPrimitiveBlastFurnace) (Object) this,
                stackSize,
                "main",
                getBaseMetaTileEntity().getWorld(),
                getExtendedFacing(),
                getBaseMetaTileEntity().getXCoord(),
                getBaseMetaTileEntity().getYCoord(),
                getBaseMetaTileEntity().getZCoord(),
                7,
                12,
                0,
                elementBudget,
                env,
                false);

        cir.setReturnValue(result);
    }
}
