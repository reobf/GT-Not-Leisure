package com.science.gtnl.mixin;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static gregtech.api.GregTechAPI.*;
import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.util.GTStructureUtility.*;

import com.science.gtnl.Utils.FilpStructure;
import com.science.gtnl.Utils.StructureUtils;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.render.TextureFactory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
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
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = MTEMegaBlastFurnace.class, remap = false)
public abstract class MTETieredMachineBlockMixin extends MegaMultiBlockBase<MTEMegaBlastFurnace>
    implements ISurvivalConstructable {

    protected MTETieredMachineBlockMixin(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    @Shadow
    private static IStructureDefinition<MTEMegaBlastFurnace> STRUCTURE_DEFINITION;

    @Shadow
    private byte glassTier;

    /**
     * @author GT-NOT-Leisure
     * @reason 修改巨高炉结构
     */
    @Overwrite
    private static String[][] createShape() {
        return FilpStructure.loadAndTransposeStructure("sciencenotleisure:multiblock/mega_blast_furnace");
    }

    @Inject(method = "<clinit>", at = @At("HEAD"), cancellable = true)
    private static void injectStructureDefinition(CallbackInfo ci) {
        STRUCTURE_DEFINITION = StructureDefinition.<MTEMegaBlastFurnace>builder()
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
        ci.cancel();
    }

    @Inject(
        method = "construct",
        at = @At("HEAD"),
        cancellable = true
    )
    private void modifyConstruct(ItemStack stackSize, boolean hintsOnly, CallbackInfo ci) {
        this.buildPiece("main", stackSize, hintsOnly, 11, 41, 0);
        ci.cancel();
    }

    @Inject(method = "getTexture", at = @At("HEAD"), cancellable = true)
    private void injectGetTexture(
        IGregTechTileEntity aBaseMetaTileEntity,
        ForgeDirection side,
        ForgeDirection facing,
        int aColorIndex,
        boolean aActive,
        boolean aRedstone,
        CallbackInfoReturnable<ITexture[]> cir
    ) {
        if (side == facing) {
            if (aActive) {
                // 激活状态材质
                cir.setReturnValue(new ITexture[]{
                    Textures.BlockIcons.getCasingTextureForId(179),
                    TextureFactory.builder()
                        .addIcon(Textures.BlockIcons.OVERLAY_FRONT_ASSEMBLY_LINE_ACTIVE)
                        .build(),
                    TextureFactory.builder()
                        .addIcon(Textures.BlockIcons.OVERLAY_FRONT_ASSEMBLY_LINE_ACTIVE_GLOW)
                        .glow()
                        .build()
                });
            } else {
                // 未激活状态材质
                cir.setReturnValue(new ITexture[]{
                    Textures.BlockIcons.getCasingTextureForId(179),
                    TextureFactory.builder()
                        .addIcon(Textures.BlockIcons.OVERLAY_FRONT_ASSEMBLY_LINE)
                        .build(),
                    TextureFactory.builder()
                        .addIcon(Textures.BlockIcons.OVERLAY_FRONT_ASSEMBLY_LINE_GLOW)
                        .glow()
                        .build()
                });
            }
        } else {
            cir.setReturnValue(new ITexture[]{
                Textures.BlockIcons.getCasingTextureForId(179)
            });
        }
    }

    @Inject(method = "checkMachine", at = @At("HEAD"))
    private void skipGlassTierCheck(IGregTechTileEntity iGregTechTileEntity, ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        this.glassTier = 8;
    }
}
