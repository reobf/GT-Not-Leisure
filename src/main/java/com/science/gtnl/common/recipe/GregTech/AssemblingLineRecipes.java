package com.science.gtnl.common.recipe.GregTech;

import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GTRecipeBuilder.HOURS;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.*;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.science.gtnl.Utils.enums.TierEU;
import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.materials.MaterialPool;
import com.science.gtnl.common.recipe.IRecipePool;

import bartworks.system.material.WerkstoffLoader;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsBotania;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialMisc;
import gtPlusPlus.core.material.MaterialsAlloy;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import tectech.recipe.TTRecipeAdder;
import tectech.thing.CustomItemList;

public class AssemblingLineRecipes implements IRecipePool {

    @Override
    public void loadRecipes() {
        TTRecipeAdder.addResearchableAssemblylineRecipe(
            ItemList.Circuit_Parts_Chip_Bioware.get(1),
            10000000,
            2500,
            (int) TierEU.RECIPE_UV,
            1,
            new ItemStack[] { ItemList.Circuit_Board_Bio_Ultra.get(1), GTNLItemList.BiowareSMDCapacitor.get(8),
                GTNLItemList.BiowareSMDDiode.get(8), GTNLItemList.BiowareSMDResistor.get(8),
                GTNLItemList.BiowareSMDTransistor.get(8), GTNLItemList.BiowareSMDInductor.get(8),
                MaterialPool.Polyetheretherketone.get(OrePrefixes.foil, 2), ItemList.Circuit_Chip_Biocell.get(8),
                ItemList.Circuit_Parts_Chip_Bioware.get(8),
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Naquadah, 16),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NiobiumTitanium, 4) },
            new FluidStack[] { Materials.BioMediumSterilized.getFluid(1000), Materials.Plastic.getMolten(1296),
                Materials.PolyvinylChloride.getMolten(864), Materials.SolderingAlloy.getMolten(1296) },
            ItemList.Circuit_Chip_BioCPU.get(8),
            16 * SECONDS,
            (int) TierEU.RECIPE_UV);

        TTRecipeAdder.addResearchableAssemblylineRecipe(
            kubatech.api.enums.ItemList.ExtremeIndustrialGreenhouse.get(1),
            256000,
            1024,
            (int) TierEU.RECIPE_UHV,
            1,
            new ItemStack[] { ItemList.Hull_UV.get(16), kubatech.api.enums.ItemList.ExtremeIndustrialGreenhouse.get(64),
                GTModHandler.getModItem(EnderIO.ID, "blockFarmStation", 64),
                GTModHandler.getModItem(RandomThings.ID, "fertilizedDirt", 64), ItemList.Field_Generator_UV.get(16),
                ItemList.Emitter_UV.get(16), ItemList.Sensor_UV.get(16),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 8L),
                GTModHandler.getModItem(Botania.ID, "overgrowthSeed", 8),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 16L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.CosmicNeutronium, 64L),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Neutronium, 64L),
                GregtechItemList.Laser_Lens_Special.get(1), ItemList.Compressor_Casing.get(16),
                ItemList.Compressor_Pipe_Casing.get(16) },
            new FluidStack[] { Materials.BioMediumSterilized.getFluid(320000),
                MaterialsAlloy.INDALLOY_140.getFluidStack(128000), Materials.Lubricant.getFluid(256000),
                Materials.Naquadria.getMolten(36864) },
            GTNLItemList.EdenGarden.get(1),
            30 * SECONDS,
            (int) TierEU.RECIPE_UHV);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, GTModHandler.getModItem(Botania.ID, "lexicon", 1, 0))
            .metadata(RESEARCH_TIME, 4 * HOURS)
            .itemInputs(
                ItemList.Hull_ZPM.get(8),
                GTModHandler.getModItem(Botania.ID, "pylon", 4, 2),
                GTModHandler.getModItem(Botania.ID, "pool", 16, 3),
                GTModHandler.getModItem(Botania.ID, "spreader", 8, 3),
                CustomItemList.LASERpipe.get(64),
                GTModHandler.getModItem(Botania.ID, "alfheimPortal", 64, 0),
                GTModHandler.getModItem(Botania.ID, "runeAltar", 64, 0),
                GTModHandler.getModItem(Botania.ID, "corporeaSpark", 64, 0),
                ItemList.Sensor_ZPM.get(16),
                ItemList.Field_Generator_ZPM.get(16),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 8L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 4L),
                ItemList.RadiantNaquadahAlloyCasing.get(16),
                ItemList.Casing_Fusion_Coil.get(16),
                GTModHandler.getModItem(Botania.ID, "storage", 32, 0))
            .fluidInputs(
                MaterialsBotania.ElvenElementium.getMolten(144 * 64),
                MaterialsBotania.Terrasteel.getMolten(144 * 32),
                MaterialsAlloy.INDALLOY_140.getFluidStack(256000))
            .itemOutputs(GTNLItemList.TeleportationArrayToAlfheim.get(1))
            .eut(TierEU.RECIPE_UV)
            .duration(300 * SECONDS)
            .addTo(AssemblyLine);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, GTModHandler.getModItem(GalaxySpace.ID, "item.RocketControlComputer", 1, 4))
            .metadata(RESEARCH_TIME, 2 * HOURS)
            .itemInputs(
                com.dreammaster.gthandler.CustomItemList.HeavyDutyPlateTier5.get(8),
                WerkstoffLoader.LuVTierMaterial.get(OrePrefixes.plate, 32),
                ItemList.Electric_Motor_LuV.get(4),
                ItemList.Electric_Pump_LuV.get(4),
                ItemList.Conveyor_Module_LuV.get(4),
                ItemList.Robot_Arm_LuV.get(4),
                ItemList.Emitter_LuV.get(4),
                ItemList.Sensor_LuV.get(4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 8L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 4L))
            .fluidInputs(
                Materials.Lubricant.getFluid(128000),
                Materials.SolderingAlloy.getMolten(18432),
                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid.getMolten(2304))
            .itemOutputs(GTNLItemList.MeteorMinerSchematic1.get(1))
            .eut(TierEU.RECIPE_LuV)
            .duration(30 * SECONDS)
            .addTo(AssemblyLine);

        GTValues.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, GTModHandler.getModItem(GalaxySpace.ID, "item.RocketControlComputer", 1, 7))
            .metadata(RESEARCH_TIME, 4 * HOURS)
            .itemInputs(
                com.dreammaster.gthandler.CustomItemList.HeavyDutyPlateTier7.get(8),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 32),
                ItemList.Electric_Motor_UV.get(4),
                ItemList.Electric_Pump_UV.get(4),
                ItemList.Conveyor_Module_UV.get(4),
                ItemList.Robot_Arm_UV.get(4),
                ItemList.Emitter_UV.get(4),
                ItemList.Sensor_UV.get(4),
                ItemList.Field_Generator_UV.get(4),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 32),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 8L))
            .fluidInputs(
                Materials.Lubricant.getFluid(256000),
                MaterialsAlloy.INDALLOY_140.getFluidStack(128000),
                Materials.NaquadahAlloy.getMolten(144 * 128),
                Materials.Longasssuperconductornameforuvwire.getMolten(144 * 32))
            .itemOutputs(GTNLItemList.MeteorMinerSchematic2.get(1))
            .eut(TierEU.RECIPE_UHV)
            .duration(120 * SECONDS)
            .addTo(AssemblyLine);

        TTRecipeAdder.addResearchableAssemblylineRecipe(
            ItemList.MixerUIV.get(1),
            102400000,
            25565,
            (int) TierEU.RECIPE_UXV,
            1,
            new ItemStack[] { GregtechItemList.Mega_AlloyBlastSmelter.get(64),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Infinity, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Infinity, 32),
                GTModHandler.getModItem(EternalSingularity.ID, "eternal_singularity", 4, 0),
                ItemList.Electric_Motor_UEV.get(32), ItemList.Electric_Pump_UEV.get(32),
                ItemList.Field_Generator_UEV.get(16),
                GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Neutronium, 32),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 32L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 16L),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UEV, 8L),
                kubatech.api.enums.ItemList.DEFCCasingBase.get(64), kubatech.api.enums.ItemList.DEFCCasingT3.get(32),
                ItemList.Casing_Dim_Injector.get(16),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Neutronium, 16) },
            new FluidStack[] { MaterialsUEVplus.TranscendentMetal.getMolten(73728),
                MaterialsElements.STANDALONE.HYPOGEN.getFluidStack(73728), Materials.Neutronium.getMolten(294912),
                MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(540000) },
            GTNLItemList.SmeltingMixingFurnace.get(1),
            120 * SECONDS,
            (int) TierEU.RECIPE_UMV);
    }
}
