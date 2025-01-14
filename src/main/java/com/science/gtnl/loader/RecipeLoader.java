package com.science.gtnl.loader;

import com.science.gtnl.Utils.GTNLProcessingArrayRecipeLoader;
import com.science.gtnl.common.machine.OreProcessing.OP_NormalProcessing;
import com.science.gtnl.common.recipe.AlloyBlastSmelterRecipes;
import com.science.gtnl.common.recipe.AssemblerRecipes;
import com.science.gtnl.common.recipe.AssemblingLineRecipes;
import com.science.gtnl.common.recipe.ChemicalBathRecipes;
import com.science.gtnl.common.recipe.ChemicalRecipes;
import com.science.gtnl.common.recipe.CompressorRecipes;
import com.science.gtnl.common.recipe.CraftingTableRecipes;
import com.science.gtnl.common.recipe.DesulfurizerRecipes;
import com.science.gtnl.common.recipe.ElectrolyzerRecipes;
import com.science.gtnl.common.recipe.FluidExtraction;
import com.science.gtnl.common.recipe.FusionReactorRecipes;
import com.science.gtnl.common.recipe.IRecipePool;
import com.science.gtnl.common.recipe.ManaInfusionRecipes;
import com.science.gtnl.common.recipe.MixerRecipes;
import com.science.gtnl.common.recipe.NatureSpiritArrayRecipes;
import com.science.gtnl.common.recipe.PetrochemicalPlantRecipes;
import com.science.gtnl.common.recipe.PlasmaForgeRecipes;
import com.science.gtnl.common.recipe.PortalToAlfheimRecipes;
import com.science.gtnl.common.recipe.ReFusionReactorRecipes;
import com.science.gtnl.common.recipe.RealArtificialStarRecipes;
import com.science.gtnl.common.recipe.SmeltingMixingFurnaceRecipes;
import com.science.gtnl.common.recipe.SteamCrackerRecipes;
import com.science.gtnl.common.recipe.TranscendentPlasmaMixerRecipes;
import com.science.gtnl.common.recipe.multiDehydratorRecipes;

public class RecipeLoader {

    public static void loadRecipes() {
        IRecipePool[] recipePools = new IRecipePool[] { new ChemicalRecipes(), new ElectrolyzerRecipes(),
            new MixerRecipes(), new multiDehydratorRecipes(), new AssemblerRecipes(), new AlloyBlastSmelterRecipes(),
            new AssemblingLineRecipes(), new CompressorRecipes(), new ReFusionReactorRecipes(),
            new RealArtificialStarRecipes(), new PortalToAlfheimRecipes(), new NatureSpiritArrayRecipes(),
            new ManaInfusionRecipes(), new TranscendentPlasmaMixerRecipes(), new PlasmaForgeRecipes(),
            new CraftingTableRecipes(), new ChemicalBathRecipes(), new SteamCrackerRecipes(), new DesulfurizerRecipes(),
            new PetrochemicalPlantRecipes(), new FusionReactorRecipes(), new SmeltingMixingFurnaceRecipes(),
            new FluidExtraction() };
        for (IRecipePool recipePool : recipePools) {
            recipePool.loadRecipes();
        }
        new OP_NormalProcessing().enumOreProcessingRecipes();
        GTNLProcessingArrayRecipeLoader.registerDefaultGregtechMaps();
    }
}
