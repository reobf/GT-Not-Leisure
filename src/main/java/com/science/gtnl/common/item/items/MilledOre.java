package com.science.gtnl.common.item.items;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gtPlusPlus.api.objects.minecraft.ItemPackage;
import gtPlusPlus.core.item.base.ore.BaseItemMilledOre;
import gtPlusPlus.core.util.minecraft.FluidUtils;

public class MilledOre extends ItemPackage {

    public static Fluid NaquadahEnrichedFlotationFroth;
    public static Item milledNaquadahEnriched;

    @Override
    public void items() {
        milledNaquadahEnriched = BaseItemMilledOre.generate(Materials.NaquadahEnriched, (int) TierEU.RECIPE_ZPM);
    }

    @Override
    public void blocks() {
        // None yet
    }

    @Override
    public void fluids() {

        short[] aNaquadahEnrichedFrothRGB = Materials.NaquadahEnriched.mRGBa;
        NaquadahEnrichedFlotationFroth = FluidUtils.generateFluidNoPrefix(
            "froth.naquadahenrichedflotation",
            "Nquadah Enriched Froth",
            32 + 175,
            new short[] { aNaquadahEnrichedFrothRGB[0], aNaquadahEnrichedFrothRGB[1], aNaquadahEnrichedFrothRGB[2],
                100 },
            true);
    }

    @Override
    public String errorMessage() {
        return "GTNL:Failed to generate recipes for OreMillingProc.";
    }

    @Override
    public boolean generateRecipes() {
        return true;
    }
}
