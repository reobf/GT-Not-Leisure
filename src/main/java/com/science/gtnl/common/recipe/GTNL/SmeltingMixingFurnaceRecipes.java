package com.science.gtnl.common.recipe.GTNL;

import static gregtech.api.util.GTModHandler.getModItem;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.recipe.IRecipePool;
import com.science.gtnl.common.recipe.RecipeRegister;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTUtility;

public class SmeltingMixingFurnaceRecipes implements IRecipePool {

    final RecipeMap<?> SMFR = RecipeRegister.SmeltingMixingFurnaceRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(2),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2010))
            .fluidInputs(FluidRegistry.getFluidStack("molten.zirconium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.zirconiumcarbide", 288))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(15)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.gold", 144 * 7),
                FluidRegistry.getFluidStack("molten.copper", 144 * 3))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.tumbaga", 1440))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(15)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(2),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2010))
            .fluidInputs(FluidRegistry.getFluidStack("molten.silicon", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.siliconcarbide", 288))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(15)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(3))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.lead", 144 * 4),
                FluidRegistry.getFluidStack("molten.copper", 144 * 3),
                FluidRegistry.getFluidStack("molten.tin", 144 * 3))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.potin", 720 * 2))
            .specialValue(0)
            .noOptimize()
            .duration(200 * 2)
            .eut(15)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(4),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 3, 2010),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 3, 2022))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 23),
                FluidRegistry.getFluidStack("molten.aluminium", 144),
                FluidRegistry.getFluidStack("molten.chrome", 144),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 5),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 12))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.eglinsteel", 2304 * 3))
            .specialValue(0)
            .noOptimize()
            .duration(900 * 3)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(4),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 14, 2010))
            .fluidInputs(
                FluidRegistry.getFluidStack("fluorine", 20000),
                FluidRegistry.getFluidStack("hydrogen", 4000),
                FluidRegistry.getFluidStack("liquid_sodium", 2000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.teflon", 2880 * 2))
            .specialValue(0)
            .noOptimize()
            .duration(200 * 2)
            .eut(15)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(8))
            .fluidInputs(
                FluidRegistry.getFluidStack("oxygen", 77000),
                FluidRegistry.getFluidStack("molten.iron", 144 * 75),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 25),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 18),
                FluidRegistry.getFluidStack("molten.potassium", 144 * 45),
                FluidRegistry.getFluidStack("molten.calcium", 144 * 30),
                FluidRegistry.getFluidStack("molten.ytterbium", 144 * 15),
                FluidRegistry.getFluidStack("liquid_sodium", 2000 * 15))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.ancientgranite", 4176 * 15))
            .specialValue(0)
            .noOptimize()
            .duration(200 * 15)
            .eut(15)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.tin", 144 * 5),
                FluidRegistry.getFluidStack("molten.lead", 144 * 36),
                FluidRegistry.getFluidStack("molten.antimony", 144 * 8),
                FluidRegistry.getFluidStack("molten.arsenic", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.babbitalloy", 7200))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(30)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(3),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 12, 2010))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.lead", 144 * 3),
                FluidRegistry.getFluidStack("molten.manganese", 144 * 5))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.blackmetal", 2880))
            .specialValue(0)
            .noOptimize()
            .duration(400)
            .eut(60)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.zinc", 144),
                FluidRegistry.getFluidStack("molten.thorium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.zn-th alloy", 288))
            .specialValue(0)
            .noOptimize()
            .duration(280)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(2),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2010))
            .fluidInputs(FluidRegistry.getFluidStack("molten.niobium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.niobiumcarbide", 288))
            .specialValue(0)
            .noOptimize()
            .duration(400)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 6),
                FluidRegistry.getFluidStack("molten.nickel", 144),
                FluidRegistry.getFluidStack("molten.manganese", 144),
                FluidRegistry.getFluidStack("molten.chrome", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 1296))
            .specialValue(0)
            .noOptimize()
            .duration(900)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("oxygen", 16000),
                FluidRegistry.getFluidStack("molten.iron", 144 * 16),
                FluidRegistry.getFluidStack("molten.molybdenum", 144),
                FluidRegistry.getFluidStack("molten.titanium", 144),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 4),
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 2))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.maragingsteel250", 3456))
            .specialValue(0)
            .noOptimize()
            .duration(400)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.nickel", 144 * 251),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 144),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 150),
                FluidRegistry.getFluidStack("molten.iron", 144 * 100))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.inconel625", 6192 * 15))
            .specialValue(0)
            .noOptimize()
            .duration(400 * 15)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("oxygen", 16000),
                FluidRegistry.getFluidStack("molten.iron", 144 * 16),
                FluidRegistry.getFluidStack("molten.aluminium", 144),
                FluidRegistry.getFluidStack("molten.titanium", 144),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 4),
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 2))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.maragingsteel300", 3456))
            .specialValue(0)
            .noOptimize()
            .duration(400)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("oxygen", 16000),
                FluidRegistry.getFluidStack("molten.iron", 144 * 16),
                FluidRegistry.getFluidStack("molten.molybdenum", 144),
                FluidRegistry.getFluidStack("molten.aluminium", 144),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 4),
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 2))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.maragingsteel350", 3456))
            .specialValue(0)
            .noOptimize()
            .duration(400)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(7),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 2, 2010),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2021),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2022))
            .fluidInputs(
                FluidRegistry.getFluidStack("oxygen", 12000),
                FluidRegistry.getFluidStack("molten.iron", 144 * 12),
                FluidRegistry.getFluidStack("molten.manganese", 144),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 2),
                FluidRegistry.getFluidStack("molten.aluminium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.watertightsteel", 2880))
            .specialValue(0)
            .noOptimize()
            .duration(400)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 2),
                FluidRegistry.getFluidStack("molten.tantalum", 144 * 23))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.tantalloy60", 3600))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(2),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2010))
            .fluidInputs(FluidRegistry.getFluidStack("molten.tantalum", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.tantalumcarbide", 288))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.titanium", 144),
                FluidRegistry.getFluidStack("molten.uranium", 144 * 9))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.staballoy", 1440))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(3))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.titanium", 144 * 150),
                FluidRegistry.getFluidStack("molten.tantalum", 144 * 23),
                FluidRegistry.getFluidStack("molten.ytterbium", 144 * 100),
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 2))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.tantalloy61", 1584 * 25))
            .specialValue(0)
            .noOptimize()
            .duration(600 * 25)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(4),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 2, 2021))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 4),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 3),
                FluidRegistry.getFluidStack("molten.molybdenum", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.talonite", 1440))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 10),
                FluidRegistry.getFluidStack("molten.copper", 144),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 5),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 9))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.incoloy020", 3600))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 23),
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 9),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 9),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 9))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.incoloyds", 7200))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.chrome", 144 * 8),
                FluidRegistry.getFluidStack("molten.niobium", 144 * 10),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 10),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 12))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.inconel690", 1152 * 5))
            .specialValue(0)
            .noOptimize()
            .duration(600 * 5)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.nickel", 144 * 14),
                FluidRegistry.getFluidStack("molten.chrome", 144),
                FluidRegistry.getFluidStack("molten.niobium", 144 * 5),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 10))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.inconel792", 864 * 5))
            .specialValue(0)
            .noOptimize()
            .duration(600 * 5)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 3),
                FluidRegistry.getFluidStack("molten.cobalt", 144),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 12),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 3),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 31))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.hastelloyw", 7200))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 9),
                FluidRegistry.getFluidStack("molten.manganese", 144),
                FluidRegistry.getFluidStack("molten.silicon", 144),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 4),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 11),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 24))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.hastelloyx", 7200))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.trinium", 144 * 5),
                FluidRegistry.getFluidStack("molten.naquadah", 144 * 9))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.triniumnaquadahalloy", 2106))
            .specialValue(0)
            .noOptimize()
            .duration(800)
            .eut(960)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.copper", 144),
                FluidRegistry.getFluidStack("molten.antimony", 144 * 2),
                FluidRegistry.getFluidStack("molten.platinum", 144 * 2),
                FluidRegistry.getFluidStack("molten.tin", 144 * 15))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.whitemetal", 2880))
            .specialValue(0)
            .noOptimize()
            .duration(800)
            .eut(960)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(2),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 7, 2010))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 7),
                FluidRegistry.getFluidStack("molten.titanium", 144 * 6))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.tungstentitaniumcarbide", 1440 * 2))
            .specialValue(0)
            .noOptimize()
            .duration(800 * 2)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 7),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 7),
                FluidRegistry.getFluidStack("molten.manganese", 144 * 4),
                FluidRegistry.getFluidStack("molten.titanium", 144 * 2))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.stellite", 2880))
            .specialValue(0)
            .noOptimize()
            .duration(800)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 16),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 3),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 5),
                FluidRegistry.getFluidStack("molten.yttrium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.incoloyma956", 3600))
            .specialValue(0)
            .noOptimize()
            .duration(800)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(4),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2540),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2541),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2542),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2543))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.energycrystal", 576))
            .specialValue(0)
            .noOptimize()
            .duration(800)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.yttrium", 144 * 2),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 4),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 2),
                FluidRegistry.getFluidStack("molten.titanium", 144 * 2),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 15))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.hastelloyn", 3600))
            .specialValue(0)
            .noOptimize()
            .duration(800)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(6))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.cobalt", 144),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 8),
                FluidRegistry.getFluidStack("molten.tungsten", 144),
                FluidRegistry.getFluidStack("molten.copper", 144),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 7),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 32))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.hastelloyc276", 7200))
            .specialValue(0)
            .noOptimize()
            .duration(800)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(6),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 9, 2022),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 9, 2010))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.titanium", 144 * 9),
                FluidRegistry.getFluidStack("molten.potassium", 144 * 9),
                FluidRegistry.getFluidStack("molten.lithium", 144 * 9),
                FluidRegistry.getFluidStack("hydrogen", 5000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.grisium", 7200))
            .specialValue(0)
            .noOptimize()
            .duration(800)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.bismuth", 144 * 47),
                FluidRegistry.getFluidStack("molten.lead", 144 * 25),
                FluidRegistry.getFluidStack("molten.tin", 144 * 13),
                FluidRegistry.getFluidStack("molten.cadmium", 144 * 10),
                FluidRegistry.getFluidStack("molten.indium", 144 * 5))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.indalloy140", 14400))
            .specialValue(0)
            .noOptimize()
            .duration(800)
            .eut(7680)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(6))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 47),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 25),
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 13),
                FluidRegistry.getFluidStack("molten.titanium", 144 * 10),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 5),
                FluidRegistry.getFluidStack("molten.aluminium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.incoloy-903", 5328))
            .specialValue(0)
            .noOptimize()
            .duration(1200)
            .eut(7680)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.titanium", 144 * 3),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 2))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.nitinol60", 720))
            .specialValue(0)
            .noOptimize()
            .duration(1500)
            .eut(7680)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(4),
                GTModHandler.getModItem("bartworks", "gt.bwMetaGenerateddust", 4, 30),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2545),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2544),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 2540),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 2541),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 2542),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 2543))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.arcanite", 1440))
            .specialValue(0)
            .noOptimize()
            .duration(6000)
            .eut(7680)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTUtility.copyAmountUnsafe(225, getModItem("gregtech", "gt.metaitem.01", 1, 2010)),
                GTUtility.copyAmountUnsafe(200, getModItem("gregtech", "gt.metaitem.01", 1, 2021)))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 600),
                FluidRegistry.getFluidStack("molten.hafnium", 144 * 500),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 344),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 116),
                FluidRegistry.getFluidStack("molten.rhenium", 144 * 500),
                FluidRegistry.getFluidStack("molten.niobium", 144 * 125),
                FluidRegistry.getFluidStack("molten.iron", 144 * 136),
                FluidRegistry.getFluidStack("molten.manganese", 144 * 4),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 4),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 96),
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 100),
                FluidRegistry.getFluidStack("oxygen", 100000),
                FluidRegistry.getFluidStack("molten.zirconium", 144 * 100))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.hs188a", 7200 * 50))
            .specialValue(0)
            .noOptimize()
            .duration(6000 * 50)
            .eut(7680)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.barium", 144 * 2),
                FluidRegistry.getFluidStack("molten.calcium", 144 * 2),
                FluidRegistry.getFluidStack("molten.copper", 144 * 3),
                FluidRegistry.getFluidStack("molten.oxygen", 8000),
                FluidRegistry.getFluidStack("mercury", 1000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.hg1223", 2304))
            .specialValue(0)
            .noOptimize()
            .duration(2400)
            .eut(30720)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(2),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 14, 2010))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.trinium", 144 * 45),
                FluidRegistry.getFluidStack("molten.naquadah", 144 * 81))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.triniumnaquadahcarbonite", 1440 * 14))
            .specialValue(0)
            .noOptimize()
            .duration(7200 * 14)
            .eut(30720)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(6))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.chrome", 144 * 13),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 3),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 2),
                FluidRegistry.getFluidStack("molten.copper", 144 * 10),
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 2),
                FluidRegistry.getFluidStack("molten.iron", 144 * 20),
                FluidRegistry.getFluidStack("oxygen", 20000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.zeron100", 7200))
            .specialValue(0)
            .noOptimize()
            .duration(7200)
            .eut(30720)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.lithium", 144),
                FluidRegistry.getFluidStack("molten.cobalt", 144),
                FluidRegistry.getFluidStack("molten.platinum", 144),
                FluidRegistry.getFluidStack("molten.erbium", 144),
                FluidRegistry.getFluidStack("helium", 1000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.helicopter", 720))
            .specialValue(0)
            .noOptimize()
            .duration(7200)
            .eut(30720)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 25, 2010))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.yttrium", 144 * 8),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 16),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 8),
                FluidRegistry.getFluidStack("molten.titanium", 144 * 8),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 160),
                FluidRegistry.getFluidStack("molten.naquadah", 144 * 50),
                FluidRegistry.getFluidStack("molten.samarium", 144 * 25),
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 50),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 75),
                FluidRegistry.getFluidStack("argon", 25000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.lafiumcompound", 2592 * 25))
            .specialValue(0)
            .noOptimize()
            .duration(7200 * 25)
            .eut(30720)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(3))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.germanium", 144 * 3),
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 3),
                FluidRegistry.getFluidStack("nitrogen", 10000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.germaniumtungstennitride", 2304))
            .specialValue(0)
            .noOptimize()
            .duration(9600)
            .eut(30720)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.trinium", 144 * 36),
                FluidRegistry.getFluidStack("molten.iron", 144 * 44),
                FluidRegistry.getFluidStack("oxygen", 44000),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 2),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 2),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 8),
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 4),
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 12),
                FluidRegistry.getFluidStack("molten.iridium", 144 * 9),
                FluidRegistry.getFluidStack("molten.osmium", 144 * 3),
                FluidRegistry.getFluidStack("molten.strontium", 144 * 12))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.arceusalloy2b", 1584 * 12))
            .specialValue(0)
            .noOptimize()
            .duration(8400 * 12)
            .eut(122880)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(5),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 3, 2010),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 3, 2022))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 23),
                FluidRegistry.getFluidStack("molten.aluminium", 144),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 25),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 5),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 12),
                FluidRegistry.getFluidStack("molten.indium", 144 * 12),
                FluidRegistry.getFluidStack("molten.dysprosium", 144 * 6),
                FluidRegistry.getFluidStack("molten.rhenium", 144 * 6))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.laurenium", 2304 * 6))
            .specialValue(0)
            .noOptimize()
            .duration(8400 * 6)
            .eut(122880)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 3, 2010),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 3, 2022))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 1055),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 409),
                FluidRegistry.getFluidStack("molten.niobium", 144 * 192),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 217),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 1227),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 300),
                FluidRegistry.getFluidStack("molten.naquadahenriched", 144 * 960),
                FluidRegistry.getFluidStack("molten.cerium", 144 * 720),
                FluidRegistry.getFluidStack("molten.antimony", 144 * 480),
                FluidRegistry.getFluidStack("molten.platinum", 144 * 480),
                FluidRegistry.getFluidStack("molten.ytterbium", 144 * 240),
                FluidRegistry.getFluidStack("oxygen", 480000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.pikyonium64b", 4176 * 240))
            .specialValue(0)
            .noOptimize()
            .duration(8400 * 240)
            .eut(122880)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(8))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.chrome", 144 * 208),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 48),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 32),
                FluidRegistry.getFluidStack("molten.copper", 144 * 160),
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 32),
                FluidRegistry.getFluidStack("molten.iron", 144 * 320),
                FluidRegistry.getFluidStack("molten.naquadria", 144 * 350),
                FluidRegistry.getFluidStack("molten.gadolinium", 144 * 250),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 150),
                FluidRegistry.getFluidStack("molten.tin", 144 * 100),
                FluidRegistry.getFluidStack("molten.titanium", 144 * 600),
                FluidRegistry.getFluidStack("molten.iridium", 144 * 225),
                FluidRegistry.getFluidStack("molten.osmium", 144 * 75),
                FluidRegistry.getFluidStack("oxygen", 320000),
                FluidRegistry.getFluidStack("mercury", 100000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.cinobitea243", 7632 * 50))
            .specialValue(0)
            .noOptimize()
            .duration(8400 * 50)
            .eut(122880)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.nickel", 144 * 2),
                FluidRegistry.getFluidStack("molten.titanium", 144 * 13),
                FluidRegistry.getFluidStack("molten.osmium", 144 * 90),
                FluidRegistry.getFluidStack("molten.ruthenium", 144 * 90),
                FluidRegistry.getFluidStack("molten.thallium", 144 * 45))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.botmium", 2304 * 15))
            .specialValue(0)
            .noOptimize()
            .duration(2400 * 15)
            .eut(491520)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(4),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 17, 2010),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 17, 2541),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 17, 2542),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 17, 2544))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 7),
                FluidRegistry.getFluidStack("molten.titanium", 144 * 3))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.titansteel", 864 * 17))
            .specialValue(0)
            .noOptimize()
            .duration(9600 * 17)
            .eut(491520)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 2021))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.titanium", 144 * 55),
                FluidRegistry.getFluidStack("molten.lanthanum", 144 * 12),
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 8),
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 6),
                FluidRegistry.getFluidStack("molten.manganese", 144 * 4),
                FluidRegistry.getFluidStack("molten.palladium", 144 * 4),
                FluidRegistry.getFluidStack("molten.niobium", 144 * 2),
                FluidRegistry.getFluidStack("argon", 5000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.blacktitanium", 14400))
            .specialValue(0)
            .noOptimize()
            .duration(9600)
            .eut(491520)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTUtility.copyAmountUnsafe(105, getModItem("gregtech", "gt.metaitem.01", 1, 2010)),
                GTUtility.copyAmountUnsafe(85, getModItem("gregtech", "gt.metaitem.01", 1, 2540)),
                GTUtility.copyAmountUnsafe(185, getModItem("gregtech", "gt.metaitem.01", 1, 2541)),
                GTUtility.copyAmountUnsafe(185, getModItem("gregtech", "gt.metaitem.01", 1, 2542)),
                GTUtility.copyAmountUnsafe(85, getModItem("gregtech", "gt.metaitem.01", 1, 2543)),
                GTUtility.copyAmountUnsafe(160, getModItem("gregtech", "gt.metaitem.01", 1, 2544)),
                GTUtility.copyAmountUnsafe(40, getModItem("gregtech", "gt.metaitem.01", 1, 2545)))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.thorium", 144 * 240),
                FluidRegistry.getFluidStack("molten.copper", 144 * 24),
                FluidRegistry.getFluidStack("molten.gold", 144 * 8),
                FluidRegistry.getFluidStack("molten.silver", 144 * 8),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 40),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 40),
                FluidRegistry.getFluidStack("molten.iron", 144 * 120),
                FluidRegistry.getFluidStack("oxygen", 120000),
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 105),
                FluidRegistry.getFluidStack("molten.titanium", 144 * 90),
                FluidRegistry.getFluidStack("molten.thaumium", 144 * 500))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.octiron", 1440 * 2000))
            .specialValue(0)
            .noOptimize()
            .duration(10800 * 2000)
            .eut(1966080)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTUtility.copyAmountUnsafe(450, getModItem("gregtech", "gt.metaitem.01", 1, 2010)))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 450),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 820),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 460),
                FluidRegistry.getFluidStack("molten.tin", 144 * 226),
                FluidRegistry.getFluidStack("molten.copper", 144 * 675),
                FluidRegistry.getFluidStack("molten.iron", 144 * 1176),
                FluidRegistry.getFluidStack("molten.manganese", 144 * 100),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 108),
                FluidRegistry.getFluidStack("molten.yttrium", 144 * 35),
                FluidRegistry.getFluidStack("iodine", 160000),
                FluidRegistry.getFluidStack("molten.germanium", 144 * 160),
                FluidRegistry.getFluidStack("radon", 160000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.abyssalalloy", 4032 * 160))
            .specialValue(0)
            .noOptimize()
            .duration(10800 * 160)
            .eut(1966080)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(6),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 4, 2010))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.vanadium", 144 * 3),
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 8),
                FluidRegistry.getFluidStack("molten.naquadria", 144 * 7),
                FluidRegistry.getFluidStack("molten.blockplutonium", 144),
                FluidRegistry.getFluidStack("molten.bedrockium", 144 * 4))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.tairitsu", 3888))
            .specialValue(0)
            .noOptimize()
            .duration(400)
            .eut(1966080)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 10, 2010),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 20, 2540),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 20, 2541),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 20, 2542),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 20, 2543))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 21),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 21),
                FluidRegistry.getFluidStack("molten.manganese", 144 * 12),
                FluidRegistry.getFluidStack("molten.titanium", 144 * 6),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 10),
                FluidRegistry.getFluidStack("molten.gallium", 144 * 20),
                FluidRegistry.getFluidStack("molten.americium", 144 * 20),
                FluidRegistry.getFluidStack("molten.palladium", 144 * 20),
                FluidRegistry.getFluidStack("molten.bismuth", 144 * 20),
                FluidRegistry.getFluidStack("molten.germanium", 144 * 20))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.quantum", 1440 * 20))
            .specialValue(0)
            .noOptimize()
            .duration(12000 * 20)
            .eut(7864320)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(6))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.ruthenium", 144),
                FluidRegistry.getFluidStack("molten.rhodium", 144),
                FluidRegistry.getFluidStack("molten.palladium", 144),
                FluidRegistry.getFluidStack("molten.platinum", 144),
                FluidRegistry.getFluidStack("molten.osmium", 144),
                FluidRegistry.getFluidStack("molten.iridium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.precious metals alloy", 864))
            .specialValue(0)
            .noOptimize()
            .duration(10800)
            .eut(7864320)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTUtility.copyAmountUnsafe(509, getModItem("gregtech", "gt.metaitem.01", 1, 2010)),
                GTUtility.copyAmountUnsafe(180, getModItem("gregtech", "gt.metaitem.01", 1, 2541)),
                GTUtility.copyAmountUnsafe(180, getModItem("gregtech", "gt.metaitem.01", 1, 2542)),
                GTUtility.copyAmountUnsafe(180, getModItem("gregtech", "gt.metaitem.01", 1, 2544)))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.vanadium", 144 * 240),
                FluidRegistry.getFluidStack("molten.tungsten", 144 * 749),
                FluidRegistry.getFluidStack("molten.naquadria", 144 * 560),
                FluidRegistry.getFluidStack("molten.blackplutonium", 144 * 80),
                FluidRegistry.getFluidStack("molten.bedrockium", 144 * 320),
                FluidRegistry.getFluidStack("molten.titanium", 144 * 162),
                FluidRegistry.getFluidStack("molten.transcendentmetal", 144 * 2160),
                FluidRegistry.getFluidStack("molten.tartarite", 144 * 2160),
                FluidRegistry.getFluidStack("molten.infinity", 144 * 1080),
                FluidRegistry.getFluidStack("dimensionallytranscendentresidue", 1080000))
            .fluidOutputs(FluidRegistry.getFluidStack("protohalkonitebase", 1152 * 1080))
            .specialValue(0)
            .noOptimize()
            .duration(1200 * 1080)
            .eut(7864320)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(8))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 2625),
                FluidRegistry.getFluidStack("oxygen", 8250000),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 1875),
                FluidRegistry.getFluidStack("molten.bismuth", 144 * 3200),
                FluidRegistry.getFluidStack("molten.tellurium", 144 * 4800),
                FluidRegistry.getFluidStack("molten.zirconium", 144 * 1125),
                FluidRegistry.getFluidStack("molten.radoxpoly", 144 * 3456),
                FluidRegistry.getFluidStack("molten.transcendentmetal", 144 * 8640),
                FluidRegistry.getFluidStack("molten.rhugnor", 144 * 5184),
                FluidRegistry.getFluidStack("molten.chromaticglass", 144 * 4320),
                FluidRegistry.getFluidStack("plasma.bismuth", 144 * 864),
                FluidRegistry.getFluidStack("molten.metastable oganesson", 144 * 3600),
                FluidRegistry.getFluidStack("molten.praseodymium", 144 * 2160),
                FluidRegistry.getFluidStack("phononcrystalsolution", 14400000))
            .fluidOutputs(FluidRegistry.getFluidStack("phononmedium", 3600000))
            .specialValue(0)
            .noOptimize()
            .duration(2400 * 3600)
            .eut(31457280)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.ruthenium", 144 * 2),
                FluidRegistry.getFluidStack("molten.iridium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.ruridit", 432))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.zirconium", 144 * 34),
                FluidRegistry.getFluidStack("molten.zinc", 144 * 5),
                FluidRegistry.getFluidStack("molten.iron", 144 * 2),
                FluidRegistry.getFluidStack("molten.chrome", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.zircaloy-4", 144 * 42))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.zirconium", 144 * 34),
                FluidRegistry.getFluidStack("molten.zinc", 144 * 4),
                FluidRegistry.getFluidStack("molten.iron", 144),
                FluidRegistry.getFluidStack("molten.chrome", 144),
                FluidRegistry.getFluidStack("molten.nickel", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.zircaloy-2", 144 * 41))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.zirconium", 144 * 34),
                FluidRegistry.getFluidStack("molten.zinc", 144 * 4),
                FluidRegistry.getFluidStack("molten.iron", 144),
                FluidRegistry.getFluidStack("molten.chrome", 144),
                FluidRegistry.getFluidStack("molten.nickel", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.zircaloy-2", 144 * 41))
            .specialValue(0)
            .noOptimize()
            .duration(600)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(3))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.adamantium", 144 * 5),
                FluidRegistry.getFluidStack("molten.naquadah", 144 * 2),
                FluidRegistry.getFluidStack("molten.lanthanum", 144 * 3))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.adamantium alloy", 1440))
            .specialValue(0)
            .noOptimize()
            .duration(885)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.titanium", 144 * 5),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 2),
                FluidRegistry.getFluidStack("molten.vanadium", 144 * 2),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 2),
                FluidRegistry.getFluidStack("molten.aluminium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.tanmolyium beta-c", 144 * 16))
            .specialValue(0)
            .noOptimize()
            .duration(145)
            .eut(7680)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(6))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.titanium", 144 * 71),
                FluidRegistry.getFluidStack("molten.molybdenum", 144 * 14),
                FluidRegistry.getFluidStack("molten.vanadium", 144 * 94),
                FluidRegistry.getFluidStack("molten.niobium", 144 * 36),
                FluidRegistry.getFluidStack("molten.palladium", 144 * 48),
                FluidRegistry.getFluidStack("molten.rhodium", 144 * 16),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 14),
                FluidRegistry.getFluidStack("molten.quantium", 144 * 56),
                FluidRegistry.getFluidStack("molten.erbium", 144 * 24),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 7))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.dalisenite", 144 * 16))
            .specialValue(0)
            .noOptimize()
            .duration(283)
            .eut(491520)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.naquadahenriched", 144 * 8),
                FluidRegistry.getFluidStack("molten.tritanium", 144 * 5),
                FluidRegistry.getFluidStack("molten.californium", 144 * 3),
                FluidRegistry.getFluidStack("molten.blackplutonium", 144 * 2))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.enriched naquadah alloy", 144 * 18))
            .specialValue(0)
            .noOptimize()
            .duration(800)
            .eut(7864320)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(4),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 20, 2022))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.copper", 144 * 15),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 6),
                FluidRegistry.getFluidStack("molten.iron", 144 * 10),
                FluidRegistry.getFluidStack("molten.chrome", 144),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 2),
                FluidRegistry.getFluidStack("molten.oxygen", 3000),
                FluidRegistry.getFluidStack("mercury", 18000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.redalloy", 144 * 15))
            .specialValue(0)
            .noOptimize()
            .duration(80 * 15)
            .eut(16)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 20, 2022))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.silver", 144 * 160),
                FluidRegistry.getFluidStack("molten.gold", 144 * 40),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 6),
                FluidRegistry.getFluidStack("molten.iron", 144 * 10),
                FluidRegistry.getFluidStack("molten.chrome", 144),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 2),
                FluidRegistry.getFluidStack("oxygen", 3000),
                FluidRegistry.getFluidStack("mercury", 18000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.bluealloy", 144 * 120))
            .specialValue(0)
            .noOptimize()
            .duration(80 * 120)
            .eut(16)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.nickel", 144 * 4),
                FluidRegistry.getFluidStack("molten.chrome", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.nichrome", 144 * 5))
            .specialValue(0)
            .noOptimize()
            .duration(360)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(3))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144),
                FluidRegistry.getFluidStack("molten.aluminium", 144),
                FluidRegistry.getFluidStack("molten.chrome", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.kanthal", 144 * 3))
            .specialValue(0)
            .noOptimize()
            .duration(900)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.magnesium", 144),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 2))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.magnalium", 144 * 3))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(4)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.lead", 144 * 4),
                FluidRegistry.getFluidStack("molten.antimony", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.batteryalloy", 144 * 5))
            .specialValue(0)
            .noOptimize()
            .duration(200)
            .eut(4)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.osmium", 144),
                FluidRegistry.getFluidStack("molten.iridium", 144 * 3))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.osmiridium", 144 * 4))
            .specialValue(0)
            .noOptimize()
            .duration(500)
            .eut(30720)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(3),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2010))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.naquadah", 144 * 2),
                FluidRegistry.getFluidStack("molten.trinium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.naquadahalloy", 144 * 4))
            .specialValue(0)
            .noOptimize()
            .duration(360)
            .eut(61440)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.cobalt", 144 * 5),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 2),
                FluidRegistry.getFluidStack("molten.nickel", 144),
                FluidRegistry.getFluidStack("molten.molybdenum", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.ultimet", 144 * 9))
            .specialValue(0)
            .noOptimize()
            .duration(2700)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.vanadium", 144 * 3),
                FluidRegistry.getFluidStack("molten.gallium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.vanadiumgallium", 144 * 4))
            .specialValue(0)
            .noOptimize()
            .duration(444)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(4))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.yttrium", 144),
                FluidRegistry.getFluidStack("molten.barium", 144 * 2),
                FluidRegistry.getFluidStack("molten.copper", 144 * 3),
                FluidRegistry.getFluidStack("oxygen", 7000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.yttriumbariumcuprate", 144 * 13))
            .specialValue(0)
            .noOptimize()
            .duration(280)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.niobium", 144),
                FluidRegistry.getFluidStack("molten.titanium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.niobiumtitanium", 144 * 2))
            .specialValue(0)
            .noOptimize()
            .duration(444)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(2))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144),
                FluidRegistry.getFluidStack("molten.tin", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.tinalloy", 144 * 2))
            .specialValue(0)
            .noOptimize()
            .duration(100)
            .eut(16)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(4),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 3, 2500))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.magnesium", 144 * 2),
                FluidRegistry.getFluidStack("molten.iron", 144 * 14),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 4),
                FluidRegistry.getFluidStack("oxygen", 28000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.reinforced", 1440))
            .specialValue(0)
            .noOptimize()
            .duration(1200)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTUtility.copyAmountUnsafe(385, getModItem("gregtech", "gt.metaitem.01", 1, 2500)),
                GTUtility.copyAmountUnsafe(80, getModItem("gregtech", "gt.metaitem.01", 1, 2022)),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 60, 2010))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.magnesium", 144 * 16),
                FluidRegistry.getFluidStack("molten.iron", 144 * 112),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 38),
                FluidRegistry.getFluidStack("molten.beryllium", 144 * 12),
                FluidRegistry.getFluidStack("molten.potassium", 144 * 48),
                FluidRegistry.getFluidStack("molten.chrome", 144),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 2),
                FluidRegistry.getFluidStack("molten.gold", 144 * 60),
                FluidRegistry.getFluidStack("nitrogen", 60000),
                FluidRegistry.getFluidStack("oxygen", 227000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.galgadorian", 144 * 80))
            .specialValue(0)
            .noOptimize()
            .duration(2000)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(9),
                GTUtility.copyAmountUnsafe(770, getModItem("gregtech", "gt.metaitem.01", 1, 2500)),
                GTUtility.copyAmountUnsafe(160, getModItem("gregtech", "gt.metaitem.01", 1, 2022)),
                GTUtility.copyAmountUnsafe(120, getModItem("gregtech", "gt.metaitem.01", 1, 2010)))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.magnesium", 144 * 32),
                FluidRegistry.getFluidStack("molten.iron", 144 * 224),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 76),
                FluidRegistry.getFluidStack("molten.beryllium", 144 * 24),
                FluidRegistry.getFluidStack("molten.potassium", 144 * 96),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 2),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 4),
                FluidRegistry.getFluidStack("molten.gold", 144 * 120),
                FluidRegistry.getFluidStack("nitrogen", 120000),
                FluidRegistry.getFluidStack("oxygen", 454000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.galgadorian", 144 * 160))
            .specialValue(0)
            .noOptimize()
            .duration(3000)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(3))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.nickel", 144),
                FluidRegistry.getFluidStack("molten.zinc", 144),
                FluidRegistry.getFluidStack("molten.iron", 144 * 4))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.nickelzincferrite", 144 * 6))
            .specialValue(0)
            .noOptimize()
            .duration(480)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(3))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.titanium", 144 * 3),
                FluidRegistry.getFluidStack("molten.platinum", 144 * 3),
                FluidRegistry.getFluidStack("molten.vanadium", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.tpvalloy", 144 * 7))
            .specialValue(0)
            .noOptimize()
            .duration(750)
            .eut(1920)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(4),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 15, 2010),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 20, 2022))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.silicon", 144 * 21),
                FluidRegistry.getFluidStack("molten.iron", 144 * 10),
                FluidRegistry.getFluidStack("molten.chrome", 144),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 2),
                FluidRegistry.getFluidStack("molten.oxygen", 3000),
                FluidRegistry.getFluidStack("mercury", 18000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.redstonealloy", 144 * 45))
            .specialValue(0)
            .noOptimize()
            .duration(800 * 15)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(5))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.copper", 144 * 3),
                FluidRegistry.getFluidStack("molten.gold", 144),
                FluidRegistry.getFluidStack("molten.silver", 144),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 5),
                FluidRegistry.getFluidStack("molten.iron", 144 * 15),
                FluidRegistry.getFluidStack("oxygen", 15000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.blacksteel", 144 * 25))
            .specialValue(0)
            .noOptimize()
            .duration(1000)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(3))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.copper", 144 * 3),
                FluidRegistry.getFluidStack("molten.gold", 144),
                FluidRegistry.getFluidStack("molten.silver", 144))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.blackbronze", 144 * 5))
            .specialValue(0)
            .noOptimize()
            .duration(4000)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(4),
                GTModHandler.getModItem("gregtech", "gt.metaitem.01", 16, 2010))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.iron", 144 * 5),
                FluidRegistry.getFluidStack("molten.silicon", 144 * 6),
                FluidRegistry.getFluidStack("molten.magnesium", 144),
                FluidRegistry.getFluidStack("oxygen", 33000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.darksteel", 144 * 36))
            .specialValue(0)
            .noOptimize()
            .duration(1000 * 4)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTUtility.copyAmountUnsafe(300, getModItem("gregtech", "gt.metaitem.01", 1, 2010)),
                GTUtility.copyAmountUnsafe(200, getModItem("gregtech", "gt.metaitem.01", 1, 2022)))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.silicon", 144 * 330),
                FluidRegistry.getFluidStack("molten.iron", 144 * 1970),
                FluidRegistry.getFluidStack("molten.sulfur", 144 * 100),
                FluidRegistry.getFluidStack("molten.chrome", 144 * 5),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 10),
                FluidRegistry.getFluidStack("oxygen", 1000 * 1635),
                FluidRegistry.getFluidStack("mercury", 1000 * 90),
                FluidRegistry.getFluidStack("molten.carbon", 144 * 300),
                FluidRegistry.getFluidStack("molten.silver", 144 * 408),
                FluidRegistry.getFluidStack("molten.gold", 144 * 408),
                FluidRegistry.getFluidStack("molten.copper", 144 * 324),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 540))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.energeticalloy", 144 * 8100))
            .specialValue(0)
            .noOptimize()
            .duration(1600 * 300)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(8),
                GTUtility.copyAmountUnsafe(480, getModItem("gregtech", "gt.metaitem.01", 1, 2010)), // 碳
                GTUtility.copyAmountUnsafe(440, getModItem("gregtech", "gt.metaitem.01", 1, 2022)) // 硫
            )
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.silicon", 144 * 66),
                FluidRegistry.getFluidStack("molten.iron", 144 * 460),
                FluidRegistry.getFluidStack("molten.chromium", 144 * 1621),
                FluidRegistry.getFluidStack("molten.aluminium", 144 * 2),
                FluidRegistry.getFluidStack("oxygen", 1000 * 273),
                FluidRegistry.getFluidStack("mercury", 1000 * 18),
                FluidRegistry.getFluidStack("molten.silver", 144 * 198),
                FluidRegistry.getFluidStack("molten.copper", 144 * 54),
                FluidRegistry.getFluidStack("molten.gold", 144 * 558),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 90),
                FluidRegistry.getFluidStack("molten.beryllium", 144 * 81),
                FluidRegistry.getFluidStack("molten.potassium", 144 * 324),
                FluidRegistry.getFluidStack("molten.nitrogen", 144 * 405))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.vibrantalloy", 144 * 4860))
            .specialValue(0)
            .noOptimize()
            .duration(3000 * 60)
            .eut(120)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(6))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.copper", 144 * 143),
                FluidRegistry.getFluidStack("molten.gold", 144 * 96),
                FluidRegistry.getFluidStack("molten.zinc", 144 * 80),
                FluidRegistry.getFluidStack("molten.silver", 144 * 16),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 80),
                FluidRegistry.getFluidStack("molten.iron", 144 * 440),
                FluidRegistry.getFluidStack("oxygen", 440000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.bluesteel", 144 * 800))
            .specialValue(0)
            .noOptimize()
            .duration(3600 * 5)
            .eut(480)
            .addTo(SMFR);

        RecipeBuilder.builder()
            .itemInputs(GTUtility.getIntegratedCircuit(7))
            .fluidInputs(
                FluidRegistry.getFluidStack("molten.copper", 144 * 32),
                FluidRegistry.getFluidStack("molten.gold", 144 * 4),
                FluidRegistry.getFluidStack("molten.silver", 144 * 24),
                FluidRegistry.getFluidStack("molten.bismuth", 144 * 5),
                FluidRegistry.getFluidStack("molten.zinc", 144 * 5),
                FluidRegistry.getFluidStack("molten.nickel", 144 * 20),
                FluidRegistry.getFluidStack("molten.iron", 144 * 110),
                FluidRegistry.getFluidStack("oxygen", 110000))
            .fluidOutputs(FluidRegistry.getFluidStack("molten.redsteel", 144 * 200))
            .specialValue(0)
            .noOptimize()
            .duration(1200 * 5)
            .eut(480)
            .addTo(SMFR);
    }
}
