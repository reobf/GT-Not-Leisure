package com.science.gtnl.mixin.MultiBlockStructure.PrimitiveBlastFurnace;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlockAnyMeta;
import static gregtech.api.GregTechAPI.*;
import static gregtech.api.util.GTStructureUtility.ofFrame;

import net.minecraft.init.Blocks;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.science.gtnl.Utils.StructureUtils;

import gregtech.api.enums.Materials;
import gregtech.common.tileentities.machines.multi.MTEPrimitiveBlastFurnace;

@Mixin(targets = "gregtech.common.tileentities.machines.multi.MTEPrimitiveBlastFurnace$1", remap = false)
public class MTEPrimitiveBlastFurnaceMixin {

    /**
     * @author GT-NOT-Leisure
     * @reason 修改土高炉结构
     */

    @Inject(method = "computeValue", at = @At("HEAD"), cancellable = true)
    private void modifyStructureDefinition(Class<?> type,
        CallbackInfoReturnable<IStructureDefinition<MTEPrimitiveBlastFurnace>> cir) {
        String[][] structure = StructureUtils.transposeStructure(
            StructureUtils.readStructureFromFile("sciencenotleisure:multiblock/bricked_blast_furnace"));

        IStructureDefinition<MTEPrimitiveBlastFurnace> customStructure = IStructureDefinition
            .<MTEPrimitiveBlastFurnace>builder()
            .addShape("main", structure)
            .addElement('A', ofBlock(sBlockCasings3, 13))
            .addElement('B', ofBlock(sBlockCasings4, 15))
            .addElement('C', ofFrame(Materials.Bronze))
            .addElement('D', ofBlock(sBlockCasings1, 10))
            .addElement('E', ofBlockAnyMeta(Blocks.stonebrick))
            .build();

        cir.setReturnValue(customStructure);
    }
}
