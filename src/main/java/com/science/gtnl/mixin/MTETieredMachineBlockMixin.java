package com.science.gtnl.mixin;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static gregtech.api.GregTechAPI.*;
import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.util.GTStructureUtility.*;

import bartworks.util.BWUtil;
import com.gtnewhorizon.structurelib.structure.IItemSource;
import com.science.gtnl.Utils.FilpStructure;
import com.science.gtnl.Utils.OffsetUtil;
import gregtech.api.enums.HeatingCoilLevel;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.render.TextureFactory;
import gregtech.common.blocks.BlockCasings2;
import gregtech.common.blocks.BlockCasings8;
import net.minecraft.entity.player.EntityPlayerMP;
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

    private static final int OFFSET_X = 11;
    private static final int OFFSET_Y = 41;
    private static final int OFFSET_Z = 0;

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

        final int offsetX = 0;
        final int offsetY = 0;
        final int offsetZ = 0;

        STRUCTURE_DEFINITION = StructureDefinition.<MTEMegaBlastFurnace>builder()
            .addShape("main", createShape())
            .addElement(
                'A',
                OffsetUtil.withOffset(
                    buildHatchAdder(MTEMegaBlastFurnace.class)
                        .atLeast(InputHatch, OutputHatch, InputBus, OutputBus, Maintenance, Energy.or(ExoticEnergy))
                        .casingIndex(179)
                        .dot(1)
                        .buildAndChain(Loaders.FRF_Casings, 0),
                    offsetX, offsetY, offsetZ
                )
            )
            .addElement(
                'B',
                OffsetUtil.withOffset(
                    buildHatchAdder(MTEMegaBlastFurnace.class)
                        .atLeast(
                            OutputHatch.withAdder(MTEMegaBlastFurnace::addOutputHatchToTopList)
                                .withCount(t -> {
                                    if (t instanceof MTEMegaBlastFurnaceAccessor accessor) {
                                        return accessor.getPollutionOutputHatches().size();
                                    }
                                    return 0;
                                })
                        )
                        .casingIndex(((BlockCasings2) sBlockCasings2).getTextureIndex(0))
                        .dot(1)
                        .buildAndChain(sBlockCasings2, 0),
                    offsetX, offsetY, offsetZ
                )
            )
            .addElement(
                'S',
                OffsetUtil.withOffset(
                    Muffler.newAny(
                        ((BlockCasings8) sBlockCasings8).getTextureIndex(10),
                        2
                    ),
                    offsetX, offsetY, offsetZ
                )
            )
            .addElement('C', OffsetUtil.withOffset(ofBlock(sBlockCasings2, 12), offsetX, offsetY, offsetZ))
            .addElement('D', OffsetUtil.withOffset(ofBlock(sBlockCasings2, 13), offsetX, offsetY, offsetZ))
            .addElement('E', OffsetUtil.withOffset(ofBlock(sBlockCasings2, 14), offsetX, offsetY, offsetZ))
            .addElement('F', OffsetUtil.withOffset(ofBlock(sBlockCasings2, 15), offsetX, offsetY, offsetZ))
            .addElement('G', OffsetUtil.withOffset(ofBlock(sBlockCasings3, 13), offsetX, offsetY, offsetZ))
            .addElement('H', OffsetUtil.withOffset(ofBlock(sBlockCasings3, 14), offsetX, offsetY, offsetZ))
            .addElement('I', OffsetUtil.withOffset(ofBlock(sBlockCasings3, 15), offsetX, offsetY, offsetZ))
            .addElement('J', OffsetUtil.withOffset(ofBlock(sBlockCasings4, 3), offsetX, offsetY, offsetZ))
            .addElement('K', OffsetUtil.withOffset(ofBlock(sBlockCasings4, 13), offsetX, offsetY, offsetZ))
            .addElement('L', OffsetUtil.withOffset(ofCoil(MTEMegaBlastFurnace::setCoilLevel, MTEMegaBlastFurnace::getCoilLevel), offsetX, offsetY, offsetZ))
            .addElement('M', OffsetUtil.withOffset(ofBlock(sBlockCasings8, 1), offsetX, offsetY, offsetZ))
            .addElement('N', OffsetUtil.withOffset(ofBlock(sBlockCasings8, 2), offsetX, offsetY, offsetZ))
            .addElement('O', OffsetUtil.withOffset(ofBlock(sBlockCasings8, 3), offsetX, offsetY, offsetZ))
            .addElement('P', OffsetUtil.withOffset(ofBlock(sBlockCasings8, 4), offsetX, offsetY, offsetZ))
            .addElement('Q', OffsetUtil.withOffset(ofBlock(sBlockCasings8, 10), offsetX, offsetY, offsetZ))
            .addElement('R', OffsetUtil.withOffset(ofFrame(Materials.Naquadah), offsetX, offsetY, offsetZ))
            .build();

        ci.cancel();
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        this.buildPiece("main", stackSize, hintsOnly, OFFSET_X, OFFSET_Y, OFFSET_Z);
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity iGregTechTileEntity, ItemStack itemStack) {
        boolean structureValid = this.checkPiece("main", OFFSET_X, OFFSET_Y, OFFSET_Z);
        HeatingCoilLevel coilLevel = ((MTEMegaBlastFurnaceAccessor) this).getCoilLevel();
        if (!structureValid || coilLevel == HeatingCoilLevel.None || this.mMaintenanceHatches.size() != 1) {
            return false;
        }

        ((MTEMegaBlastFurnaceAccessor) this).setMHeatingCapacity((int) coilLevel.getHeat()
            + 100 * (BWUtil.getTier(this.getMaxInputEu()) - 2));
        return true;
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, IItemSource source, EntityPlayerMP actor) {
        return this.survivialBuildPiece("main", stackSize, OFFSET_X, OFFSET_Y, OFFSET_Z, elementBudget, source, actor, false, true);
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
