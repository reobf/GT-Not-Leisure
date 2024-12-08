package com.science.gtnl.common.recipe;

import net.minecraftforge.fluids.FluidRegistry;

import com.science.gtnl.Utils.recipes.RecipeBuilder;
import com.science.gtnl.common.RecipeRegister;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTUtility;

public class ManaInfusionRecipes implements IRecipePool {

    final RecipeMap<?> MIR = RecipeRegister.ManaInfusionRecipes;

    @Override
    public void loadRecipes() {
        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "tallgrass", 1, 1))
            .itemOutputs(GTModHandler.getModItem("minecraft", "tallgrass", 2, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 2000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "leaves", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "leaves", 2, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 2000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "leaves", 1, 1))
            .itemOutputs(GTModHandler.getModItem("minecraft", "leaves", 2, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 2000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "leaves", 1, 2))
            .itemOutputs(GTModHandler.getModItem("minecraft", "leaves", 2, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 2000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "leaves", 1, 3))
            .itemOutputs(GTModHandler.getModItem("minecraft", "leaves", 2, 3))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 2000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "leaves2", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "leaves2", 2, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 2000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "leaves2", 1, 1))
            .itemOutputs(GTModHandler.getModItem("minecraft", "leaves2", 2, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 2000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "gravel", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "gravel", 2, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 720))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "soul_sand", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "soul_sand", 2, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 4500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "netherrack", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "netherrack", 2, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "snowball", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "snowball", 2, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "coal", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "coal", 2, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 7500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "quartz", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "quartz", 2, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 7500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "glowstone_dust", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "glowstone_dust", 2, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 5000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "conjurationCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "redstone", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "redstone", 2, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 5000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "double_plant", 1, 5))
            .itemOutputs(GTModHandler.getModItem("minecraft", "yellow_flower", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "yellow_flower", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "red_flower", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "red_flower", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "red_flower", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "red_flower", 1, 1))
            .itemOutputs(GTModHandler.getModItem("minecraft", "red_flower", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "red_flower", 1, 2))
            .itemOutputs(GTModHandler.getModItem("minecraft", "red_flower", 1, 3))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "red_flower", 1, 3))
            .itemOutputs(GTModHandler.getModItem("minecraft", "red_flower", 1, 4))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "red_flower", 1, 4))
            .itemOutputs(GTModHandler.getModItem("minecraft", "red_flower", 1, 5))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "red_flower", 1, 5))
            .itemOutputs(GTModHandler.getModItem("minecraft", "red_flower", 1, 6))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "red_flower", 1, 6))
            .itemOutputs(GTModHandler.getModItem("minecraft", "red_flower", 1, 7))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "red_flower", 1, 7))
            .itemOutputs(GTModHandler.getModItem("minecraft", "red_flower", 1, 8))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "red_flower", 1, 8))
            .itemOutputs(GTModHandler.getModItem("minecraft", "double_plant", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "double_plant", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "double_plant", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "double_plant", 1, 1))
            .itemOutputs(GTModHandler.getModItem("minecraft", "double_plant", 1, 4))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "double_plant", 1, 4))
            .itemOutputs(GTModHandler.getModItem("minecraft", "double_plant", 1, 5))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 400))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "tallgrass", 1, 1))
            .itemOutputs(GTModHandler.getModItem("minecraft", "tallgrass", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "deadbush", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "tallgrass", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "tallgrass", 1, 2))
            .itemOutputs(GTModHandler.getModItem("minecraft", "deadbush", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("Botania", "stone", 1, 2))
            .itemOutputs(GTModHandler.getModItem("Botania", "stone", 1, 3))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("Botania", "stone", 1, 1))
            .itemOutputs(GTModHandler.getModItem("Botania", "stone", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("Botania", "stone", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "stone", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("Botania", "stone", 1, 3))
            .itemOutputs(GTModHandler.getModItem("Botania", "stone", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "stone", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "stone", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "quartz", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 10))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "dirt", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "dirt", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 120))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "brick_block", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "brick", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 25))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "clay", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "clay_ball", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 25))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "hardened_clay", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "sand", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 50))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "cobblestone", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "sand", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 50))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "redstone", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "glowstone_dust", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 300))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "glowstone_dust", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "redstone", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 300))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "glowstone_dust", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "redstone", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 300))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "ghast_tear", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "ender_pearl", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 8000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "slime_ball", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "cactus", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "cactus", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "slime_ball", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 15))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 14))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 13))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 12))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 11))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 10))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 9))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 8))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 7))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 6))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 5))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 4))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 3))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 2))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 1))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wool", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "string", 3, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 100))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "writable_book", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "name_tag", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 4000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "flint", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "gunpowder", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 16000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "flint", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "gunpowder", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 4000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "gunpowder", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "flint", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 4000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "gunpowder", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "flint", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "blaze_rod", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "nether_wart", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 4000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "poisonous_potato", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "potato", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "pumpkin_seeds", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "dye", 1, 3))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 16000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "melon_seeds", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "pumpkin_seeds", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 16000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "carrot", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "melon_seeds", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 16000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "potato", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "carrot", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 16000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "wheat", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "potato", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 16000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "dye", 1, 3))
            .itemOutputs(GTModHandler.getModItem("minecraft", "wheat_seed", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 16000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "fish", 1, 3))
            .itemOutputs(GTModHandler.getModItem("minecraft", "fish", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "fish", 1, 2))
            .itemOutputs(GTModHandler.getModItem("minecraft", "fish", 1, 3))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "fish", 1, 1))
            .itemOutputs(GTModHandler.getModItem("minecraft", "fish", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "fish", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "fish", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "vine", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "waterlily", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 320))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "waterlily", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "vine", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 120))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "waterlily", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "vine", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 200))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "snow", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "ice", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 2250))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "stonebrick", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "stonebrick", 1, 3))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 150))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("Botania", "quartzTypeElf", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "quartz", 4, 5))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 25))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("Botania", "quartzTypeRed", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "quartz", 4, 4))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 25))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("Botania", "quartzTypeLavender", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "quartz", 4, 3))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 25))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("Botania", "quartzTypeBlaze", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "quartz", 4, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 25))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("Botania", "quartzTypeMana", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "quartz", 4, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 25))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("Botania", "quartzTypeDark", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "quartz", 4, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 25))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "quartz_block", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "quartz", 4, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 25))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "glowstone", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "glowstone_dust", 4, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 25))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "sapling", 1, 5))
            .itemOutputs(GTModHandler.getModItem("minecraft", "sapling", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 120))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "sapling", 1, 4))
            .itemOutputs(GTModHandler.getModItem("minecraft", "sapling", 1, 5))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 120))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "sapling", 1, 3))
            .itemOutputs(GTModHandler.getModItem("minecraft", "sapling", 1, 4))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 120))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "sapling", 1, 2))
            .itemOutputs(GTModHandler.getModItem("minecraft", "sapling", 1, 3))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 120))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "sapling", 1, 1))
            .itemOutputs(GTModHandler.getModItem("minecraft", "sapling", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 120))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "sapling", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "sapling", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 120))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "log2", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "log2", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 40))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "log", 1, 3))
            .itemOutputs(GTModHandler.getModItem("minecraft", "log2", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 40))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "log", 1, 2))
            .itemOutputs(GTModHandler.getModItem("minecraft", "log", 1, 3))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 40))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "log", 1, 1))
            .itemOutputs(GTModHandler.getModItem("minecraft", "log", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 40))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "log", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "log", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 40))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "log2", 1, 1))
            .itemOutputs(GTModHandler.getModItem("minecraft", "log", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 40))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(
                GTUtility.copyAmount(0, GTModHandler.getModItem("Botania", "alchemyCatalyst", 1)),
                GTModHandler.getModItem("minecraft", "rotten_flesh", 1, 0))
            .itemOutputs(GTModHandler.getModItem("minecraft", "leather", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 600))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 11305))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 3000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Thaumcraft", "ItemResource", 1, 2))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 3000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("gregtech", "gt.blockmetal6", 1, 13))
            .itemOutputs(GTModHandler.getModItem("Botania", "storage", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 27000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("gregtech", "gt.blockmetal7", 1, 4))
            .itemOutputs(GTModHandler.getModItem("Botania", "storage", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 27000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "gunpowder", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "redstone", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "sugar", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 2000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "glowstone_dust", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 750))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2330))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 250))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2330))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 250))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 2529))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 150))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("DraconicEvolution", "draconiumDust", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 50))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 1))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 2))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 3))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 4))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 5))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 6))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 7))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 8))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 9))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 10))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 11))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 12))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 13))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 14))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("Botania", "dye", 1, 15))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 23))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("gregtech", "gt.metaitem.02", 1, 30500))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 10000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("gregtech", "gt.metaitem.02", 1, 29500))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 20000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "diamond", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 40000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "diamond_block", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 360000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "tallgrass", 1, 1))
            .itemOutputs(GTModHandler.getModItem("Botania", "grassSeeds", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 2500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "deadbush", 1, 1))
            .itemOutputs(GTModHandler.getModItem("Botania", "grassSeeds", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 2500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "red_mushroom", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "grassSeeds", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 6500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "brown_mushroom", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "grassSeeds", 1, 2))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 6500))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "quartz", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "quartz", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "glass", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaGlass", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 250))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "string", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 16))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 5000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "glass_bottle", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaBottle", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 10000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "ender_pearl", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 1))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 5000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "piston", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "pistonRelay", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 15000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "cookie", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaCookie", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 20000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("minecraft", "potato", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "tinyPotato", 1, 0))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 31337))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("harvestcraft", "wovencottonItem", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 22))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 15000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("harvestcraft", "wovencottonItem", 1, 0))
            .itemOutputs(GTModHandler.getModItem("Botania", "manaResource", 1, 22))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 15000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("ForbiddenMagic", "Cores", 1, 8))
            .itemOutputs(GTModHandler.getModItem("ForbiddenMagic", "Cores", 1, 7))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 10000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("ForbiddenMagic", "WandCaps", 1, 4))
            .itemOutputs(GTModHandler.getModItem("ForbiddenMagic", "WandCaps", 1, 3))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 1000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);

        RecipeBuilder.builder()
            .itemInputs(GTModHandler.getModItem("ForbiddenMagic", "WandCores", 1, 12))
            .itemOutputs(GTModHandler.getModItem("ForbiddenMagic", "WandCores", 1, 11))
            .fluidInputs(FluidRegistry.getFluidStack("fluidmana", 10000))
            .noOptimize()
            .duration(20)
            .eut(2048)
            .addTo(MIR);
    }
}
