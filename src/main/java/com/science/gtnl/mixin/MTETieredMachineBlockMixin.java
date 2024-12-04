package com.science.gtnl.mixin;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static gregtech.api.GregTechAPI.*;
import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.util.GTStructureUtility.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.science.gtnl.mixin.Accessor.MTEMegaBlastFurnaceAccessor;

import bartworks.common.tileentities.multis.mega.MTEMegaBlastFurnace;
import bartworks.common.tileentities.multis.mega.MegaMultiBlockBase;
import goodgenerator.loader.Loaders;
import gregtech.api.enums.Materials;

@Mixin(value = MTEMegaBlastFurnace.class, remap = false)
public abstract class MTETieredMachineBlockMixin extends MegaMultiBlockBase<MTEMegaBlastFurnace>
    implements ISurvivalConstructable {

    protected MTETieredMachineBlockMixin(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    /**
     * @author GT-NOT-Leisure
     * @reason 修改巨高炉结构
     */
    @Overwrite
    private static String[][] createShape() {
        String resourcePath = "assets/sciencenotleisure/multiblock/mega_blast_furnace.mb";
        List<String[]> structure = new ArrayList<>();

        try (InputStream is = MTEMegaBlastFurnace.class.getClassLoader()
            .getResourceAsStream(resourcePath); BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = reader.readLine()) != null) {
                structure.add(line.split(""));
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to load multiblock structure: " + resourcePath, e);
        }

        return structure.toArray(new String[0][0]);
    }

    @Override
    public IStructureDefinition<MTEMegaBlastFurnace> getStructureDefinition() {
        return StructureDefinition.<MTEMegaBlastFurnace>builder()
            .addShape("main", createShape())
            .addElement(
                'A',
                buildHatchAdder(MTEMegaBlastFurnace.class)
                    .atLeast(InputHatch, OutputHatch, InputBus, OutputBus, Maintenance, Energy.or(ExoticEnergy))
                    .casingIndex(MTEMegaBlastFurnaceAccessor.getCasingIndex())
                    .dot(1)
                    .buildAndChain(Loaders.FRF_Casings, 0))
            .addElement(
                'B',
                buildHatchAdder(MTEMegaBlastFurnace.class).atLeast(
                    OutputHatch.withAdder(MTEMegaBlastFurnace::addOutputHatchToTopList)
                        .withCount(t -> {
                            if (t instanceof MTEMegaBlastFurnaceAccessor accessor) {
                                return accessor.getPollutionOutputHatches()
                                    .size();
                            }
                            return 0;
                        }))
                    .casingIndex(MTEMegaBlastFurnaceAccessor.getCasingIndex())
                    .dot(1)
                    .buildAndChain(sBlockCasings2, 0))
            .addElement('C', ofBlock(sBlockCasings2, 12))
            .addElement('D', ofBlock(sBlockCasings2, 13))
            .addElement('E', ofBlock(sBlockCasings2, 14))
            .addElement('F', ofBlock(sBlockCasings2, 15))
            .addElement('G', ofBlock(sBlockCasings3, 13))
            .addElement('H', ofBlock(sBlockCasings3, 14))
            .addElement('I', ofBlock(sBlockCasings3, 15))
            .addElement('J', ofBlock(sBlockCasings4, 3))
            .addElement('K', ofBlock(sBlockCasings4, 13))
            .addElement('L', ofCoil(MTEMegaBlastFurnace::setCoilLevel, MTEMegaBlastFurnace::getCoilLevel))
            .addElement('M', ofBlock(sBlockCasings8, 1))
            .addElement('N', ofBlock(sBlockCasings8, 2))
            .addElement('O', ofBlock(sBlockCasings8, 3))
            .addElement('P', ofBlock(sBlockCasings8, 4))
            .addElement('Q', ofBlock(sBlockCasings8, 10))
            .addElement('R', ofFrame(Materials.Naquadah))
            .addElement('S', Muffler.newAny(MTEMegaBlastFurnaceAccessor.getCasingIndex(), 2))
            .build();
    }
}
