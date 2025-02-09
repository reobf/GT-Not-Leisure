package com.science.gtnl.common.recipe.GregTech;

import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GTBlockMap.WILDCARD;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.gtnewhorizons.gtnhintergalactic.recipe.IGRecipeMaps;
import com.science.gtnl.common.recipe.IRecipePool;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.TierEU;

public class SpaceAssemblerRecipes implements IRecipePool {

    // 下面均为 280 配方

    @Override
    public void loadRecipes() {
        if (GTNHIntergalactic.isModLoaded()) {

            Fluid solderUEV = FluidRegistry.getFluid("molten.mutatedlivingsolder") != null
                ? FluidRegistry.getFluid("molten.mutatedlivingsolder")
                : FluidRegistry.getFluid("molten.solderingalloy");

            Fluid solderIndalloy = FluidRegistry.getFluid("molten.indalloy140") != null
                ? FluidRegistry.getFluid("molten.indalloy140")
                : FluidRegistry.getFluid("molten.solderingalloy");

            // Advanced Stocking Input Hatch (ME)
            GTValues.RA.stdBuilder()
                .itemInputs(
                    ItemList.Hatch_Input_Multi_2x2_UHV.get(4L),
                    getModItem(AE2FluidCraft.ID, "fluid_interface", 1L),
                    ItemList.Circuit_Chip_BioCPU.get(1),
                    ItemList.Electric_Pump_UHV.get(1L),
                    // 16384k Me Fluid Storage Component
                    getModItem(AE2FluidCraft.ID, "fluid_part", 4, 7),
                    // Hyper-Acceleration Card
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 56))
                .fluidInputs(new FluidStack(solderUEV, 2304))
                .itemOutputs(ItemList.Hatch_Input_ME_Advanced.get(1))
                .specialValue(1)
                .duration(15 * SECONDS)
                .eut(TierEU.RECIPE_UHV)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

            // Crafting Input Buffer (ME)
            GTValues.RA.stdBuilder()
                .itemInputs(
                    ItemList.Hatch_CraftingInput_Bus_ME_ItemOnly.get(1),
                    ItemList.Hatch_Input_Multi_2x2_UEV.get(1),
                    // 16384k storage component
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 8, 60),
                    // 16384k Me Fluid Storage Component
                    getModItem(AE2FluidCraft.ID, "fluid_part", 8, 7),
                    // ME Controller
                    getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, WILDCARD),
                    // Dual Interface
                    getModItem(AE2FluidCraft.ID, "part_fluid_interface", 1, WILDCARD),
                    // Pattern capacity card
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 54))
                .fluidInputs(new FluidStack(solderUEV, 2304), Materials.Grade7PurifiedWater.getFluid(4000))
                .itemOutputs(ItemList.Hatch_CraftingInput_Bus_ME.get(1))
                .specialValue(1)
                .duration(15 * SECONDS)
                .eut(TierEU.RECIPE_UHV)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

            if (AE2Stuff.isModLoaded()) {
                // Crafting Input Proxy
                GTValues.RA.stdBuilder()
                    .itemInputs(
                        ItemList.Hatch_CraftingInput_Bus_ME.get(1),
                        // 64 Core Co-Processing Unit
                        getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingUnit", 1, 0),
                        // 16384k storage component
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 8, 60),
                        // 16384k Me Fluid Storage Component
                        getModItem(AE2FluidCraft.ID, "fluid_part", 8, 7),
                        // Wireless Connector
                        getModItem(AE2Stuff.ID, "Wireless", 2, 0),
                        ItemList.Sensor_UEV.get(1),
                        ItemList.EnergisedTesseract.get(1))
                    .fluidInputs(
                        new FluidStack(solderUEV, 2304),
                        MaterialsUEVplus.DimensionallyShiftedSuperfluid.getFluid(4000))
                    .itemOutputs(ItemList.Hatch_CraftingInput_Bus_Slave.get(1))
                    .specialValue(2)
                    .duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UIV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);
            }

        }
    }
}
