package com.science.gtnl.common.hatch;

import com.science.gtnl.Utils.item.TextLocalization;
import com.science.gtnl.Utils.item.TextUtils;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.MTEHatchSolidifier;

public class HumongousSolidifierHatch extends MTEHatchSolidifier {

    public HumongousSolidifierHatch(int aID, String aName, String aNameRegional, int aTier) {
        super(aID, aName, aNameRegional, 14);
    }

    public HumongousSolidifierHatch(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, 14, aDescription, aTextures);
    }

    @Override
    public int getCapacityPerTank(int aTier, int aSlot) {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new HumongousSolidifierHatch(mName, 14, mDescriptionArray, mTextures);
    }

    @Override
    public String[] getDescription() {
        return new String[] { TextLocalization.Tooltip_HumongousSolidifierHatch_00,
            TextLocalization.Tooltip_HumongousSolidifierHatch_01,
            TextLocalization.Adder + TextUtils.SCIENCE_NOT_LEISURE };
    }
}
