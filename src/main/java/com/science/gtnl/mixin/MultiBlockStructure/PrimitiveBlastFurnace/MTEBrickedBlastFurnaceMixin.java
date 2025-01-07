package com.science.gtnl.mixin.MultiBlockStructure.PrimitiveBlastFurnace;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import com.science.gtnl.Utils.TextLocalization;
import com.science.gtnl.Utils.TextUtils;

import gregtech.GTMod;
import gregtech.api.interfaces.ISecondaryDescribable;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.common.tileentities.machines.multi.MTEBrickedBlastFurnace;
import gregtech.common.tileentities.machines.multi.MTEPrimitiveBlastFurnace;

@Mixin(value = MTEBrickedBlastFurnace.class, remap = false)
public abstract class MTEBrickedBlastFurnaceMixin extends MTEPrimitiveBlastFurnace implements ISecondaryDescribable {

    public MTEBrickedBlastFurnaceMixin(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    @Shadow
    private MultiblockTooltipBuilder tooltipBuilder;

    /**
     * @author GT-NOT-Leisure
     * @reason 修改土高炉机器描述
     */
    @Overwrite
    protected MultiblockTooltipBuilder getTooltip() {
        if (tooltipBuilder == null) {
            tooltipBuilder = new MultiblockTooltipBuilder();
            tooltipBuilder.addMachineType(TextLocalization.BrickBlastFurnaceRecipeType)
                .addInfo(TextLocalization.Tooltip_BrickBlastFurnace_00)
                .addInfo(TextLocalization.Tooltip_BrickBlastFurnace_01)
                .addInfo(TextLocalization.Tooltip_BrickBlastFurnace_02)
                .addInfo(TextLocalization.Tooltip_BrickBlastFurnace_03)
                .addInfo(TextLocalization.Tooltip_BrickBlastFurnace_04)
                .addPollutionAmount(GTMod.gregtechproxy.mPollutionPrimitveBlastFurnacePerSecond)
                .addSeparator()
                .addInfo(TextLocalization.StructureTooComplex)
                .addInfo(TextLocalization.BLUE_PRINT_INFO)
                .beginStructureBlock(15, 14, 15, true)
                .addStructureInfo(TextLocalization.Tooltip_BrickBlastFurnace_Casing_00)
                .addStructureInfo(TextLocalization.Tooltip_BrickBlastFurnace_Casing_01)
                .addStructureInfo(TextLocalization.Tooltip_BrickBlastFurnace_Casing_02)
                .addStructureInfo(TextLocalization.Tooltip_BrickBlastFurnace_Casing_03)
                .addStructureInfo(TextLocalization.Tooltip_BrickBlastFurnace_Casing_04)
                .toolTipFinisher(TextUtils.SCIENCE_NOT_LEISURE + TextUtils.SQY + " §rX " + TextUtils.SRP);
        }
        return tooltipBuilder;
    }
}
