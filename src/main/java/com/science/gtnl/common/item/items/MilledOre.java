package com.science.gtnl.common.item.items;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gtPlusPlus.api.objects.minecraft.ItemPackage;
import gtPlusPlus.core.item.base.ore.BaseItemMilledOre;
import gtPlusPlus.core.util.minecraft.FluidUtils;

public class MilledOre extends ItemPackage {

    public static Fluid NaquadahFlotationFroth;
    public static Item milledNaquadah;

    @Override
    public void items() {
        milledNaquadah = BaseItemMilledOre.generate(Materials.Naquadah, (int) TierEU.RECIPE_ZPM);
    }

    @Override
    public void blocks() {
        // None yet
    }

    @Override
    public void fluids() {

        short[] aNaquadahFrothRGB = Materials.Naquadah.mRGBa;
        NaquadahFlotationFroth = FluidUtils.generateFluidNoPrefix(
            "froth.naquadahflotation",
            "Nquadah Froth",
            32 + 175,
            new short[] { aNaquadahFrothRGB[0], aNaquadahFrothRGB[1], aNaquadahFrothRGB[2], 100 },
            true);
    }

    @Override
    public String errorMessage() {
        return "Failed to generate recipes for OreMillingProc.";
    }

    @Override
    public boolean generateRecipes() {
        return true;
    }
}
