package com.science.gtnl.loader;

import com.science.gtnl.common.machine.OreProcessing.OP_NormalProcessing;
import com.science.gtnl.common.machine.multiMachineClasses.GTNLProcessingArrayRecipeLoader;
import com.science.gtnl.common.materials.MaterialPool;
import com.science.gtnl.common.recipe.GTNL.CellRegulatorRecipes;
import com.science.gtnl.common.recipe.GTNL.DesulfurizerRecipes;
import com.science.gtnl.common.recipe.GTNL.IsaMillRecipes;
import com.science.gtnl.common.recipe.GTNL.ManaInfusionRecipes;
import com.science.gtnl.common.recipe.GTNL.MatterFabricatorRecipes;
import com.science.gtnl.common.recipe.GTNL.NatureSpiritArrayRecipes;
import com.science.gtnl.common.recipe.GTNL.PetrochemicalPlantRecipes;
import com.science.gtnl.common.recipe.GTNL.PortalToAlfheimRecipes;
import com.science.gtnl.common.recipe.GTNL.RareEarthCentrifugalRecipes;
import com.science.gtnl.common.recipe.GTNL.ReFusionReactorRecipes;
import com.science.gtnl.common.recipe.GTNL.RealArtificialStarRecipes;
import com.science.gtnl.common.recipe.GTNL.SmeltingMixingFurnaceRecipes;
import com.science.gtnl.common.recipe.GTNL.SteamCrackerRecipes;
import com.science.gtnl.common.recipe.GTNL.TheTwilightForestRecipes;
import com.science.gtnl.common.recipe.GregTech.AlloyBlastSmelterRecipes;
import com.science.gtnl.common.recipe.GregTech.AssemblerRecipes;
import com.science.gtnl.common.recipe.GregTech.AssemblingLineRecipes;
import com.science.gtnl.common.recipe.GregTech.CentrifugeRecipes;
import com.science.gtnl.common.recipe.GregTech.ChemicalBathRecipes;
import com.science.gtnl.common.recipe.GregTech.ChemicalDehydratorRecipes;
import com.science.gtnl.common.recipe.GregTech.ChemicalRecipes;
import com.science.gtnl.common.recipe.GregTech.CompressorRecipes;
import com.science.gtnl.common.recipe.GregTech.CraftingTableRecipes;
import com.science.gtnl.common.recipe.GregTech.DigesterRecipes;
import com.science.gtnl.common.recipe.GregTech.DissolutionTankRecipes;
import com.science.gtnl.common.recipe.GregTech.ElectrolyzerRecipes;
import com.science.gtnl.common.recipe.GregTech.FluidExtraction;
import com.science.gtnl.common.recipe.GregTech.FusionReactorRecipes;
import com.science.gtnl.common.recipe.GregTech.MixerRecipes;
import com.science.gtnl.common.recipe.GregTech.PlasmaForgeRecipes;
import com.science.gtnl.common.recipe.GregTech.SpaceAssemblerRecipes;
import com.science.gtnl.common.recipe.GregTech.TranscendentPlasmaMixerRecipes;
import com.science.gtnl.common.recipe.GregTech.multiDehydratorRecipes;
import com.science.gtnl.common.recipe.IRecipePool;
import com.science.gtnl.common.recipe.Thaumcraft.InfusionCraftingRecipesPool;
import com.science.gtnl.common.recipe.Thaumcraft.ShapedArcaneCraftingRecipesPool;

import goodgenerator.util.CrackRecipeAdder;

public class RecipeLoader {

    public static void loadRecipes() {
        IRecipePool[] recipePools = new IRecipePool[] { new ChemicalRecipes(), new ElectrolyzerRecipes(),
            new MixerRecipes(), new multiDehydratorRecipes(), new AssemblerRecipes(), new AlloyBlastSmelterRecipes(),
            new AssemblingLineRecipes(), new CompressorRecipes(), new ReFusionReactorRecipes(),
            new RealArtificialStarRecipes(), new PortalToAlfheimRecipes(), new NatureSpiritArrayRecipes(),
            new ManaInfusionRecipes(), new TranscendentPlasmaMixerRecipes(), new PlasmaForgeRecipes(),
            new CraftingTableRecipes(), new ChemicalBathRecipes(), new SteamCrackerRecipes(), new DesulfurizerRecipes(),
            new PetrochemicalPlantRecipes(), new FusionReactorRecipes(), new SmeltingMixingFurnaceRecipes(),
            new FluidExtraction(), new DigesterRecipes(), new DissolutionTankRecipes(), new CentrifugeRecipes(),
            new ChemicalDehydratorRecipes(), new RareEarthCentrifugalRecipes(), new MatterFabricatorRecipes(),
            new TheTwilightForestRecipes(), new IsaMillRecipes(), new SpaceAssemblerRecipes(),
            new CellRegulatorRecipes() };
        for (IRecipePool recipePool : recipePools) {
            recipePool.loadRecipes();
        }
        new OP_NormalProcessing().enumOreProcessingRecipes();
        GTNLProcessingArrayRecipeLoader.registerDefaultGregtechMaps();
    }

    public static void loadRecipesPostInit() {
        new ShapedArcaneCraftingRecipesPool().loadRecipes();
        new InfusionCraftingRecipesPool().loadRecipes();
    }

    public static void RecipeLoad() {
        CrackRecipeAdder.reAddBlastRecipe(MaterialPool.MolybdenumDisilicide, 800, 1920, 2300, true);
        CrackRecipeAdder.reAddBlastRecipe(MaterialPool.HSLASteel, 1000, 480, 1711, true);
        CrackRecipeAdder.reAddBlastRecipe(MaterialPool.Germaniumtungstennitride, 800, 30720, 8200, true);
    }
}
