package com.science.gtnl.client;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.item.ItemLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabsLoader {

    public static CreativeTabs GTNotLeisureItem = new CreativeTabs("GTNotLeisureItem") {

        @Override
        public Item getTabIconItem() {
            return ItemLoader.TestItem;
        }
    };

    public static CreativeTabs GTNotLeisureBlock = new CreativeTabs("GTNotLeisureBlock") {

        @Override
        public Item getTabIconItem() {
            return GTNLItemList.NewHorizonsCoil.getItem();
        }

        @SideOnly(Side.CLIENT)
        public int func_151243_f() {
            return 1;
        }
    };

    public static CreativeTabs ReAvaritia = new CreativeTabs("ReAvaritia") {

        @Override
        public Item getTabIconItem() {
            return ItemLoader.InfinityPickaxe;
        }
    };

    public static CreativeTabs GTNotLeisureMachine = new CreativeTabs("GTNotLeisureMachine") {

        @Override
        public Item getTabIconItem() {
            return GTNLItemList.GenerationEarthEngine.getItem();
        }

        @SideOnly(Side.CLIENT)
        public int func_151243_f() {
            return 21006;
        }

        @SuppressWarnings({ "unchecked", "rawtypes" })
        @Override
        public void displayAllReleventItems(List p_78018_1_) {
            super.displayAllReleventItems(p_78018_1_);
            p_78018_1_.add(GTNLItemList.FluidManaInputHatch.get(1));
            p_78018_1_.add(GTNLItemList.FluidIceInputHatch.get(1));
            p_78018_1_.add(GTNLItemList.FluidBlazeInputHatch.get(1));
            p_78018_1_.add(GTNLItemList.SuperCraftingInputHatchME.get(1));
            p_78018_1_.add(GTNLItemList.SuperCraftingInputBusME.get(1));
            p_78018_1_.add(GTNLItemList.HumongousSolidifierHatch.get(1));
            p_78018_1_.add(GTNLItemList.DebugEnergyHatch.get(1));

            p_78018_1_.add(GTNLItemList.NinefoldInputHatchEV.get(1));
            p_78018_1_.add(GTNLItemList.NinefoldInputHatchIV.get(1));
            p_78018_1_.add(GTNLItemList.NinefoldInputHatchLuV.get(1));
            p_78018_1_.add(GTNLItemList.NinefoldInputHatchZPM.get(1));
            p_78018_1_.add(GTNLItemList.NinefoldInputHatchUV.get(1));
            p_78018_1_.add(GTNLItemList.NinefoldInputHatchUHV.get(1));
            p_78018_1_.add(GTNLItemList.NinefoldInputHatchUEV.get(1));
            p_78018_1_.add(GTNLItemList.NinefoldInputHatchUIV.get(1));
            p_78018_1_.add(GTNLItemList.NinefoldInputHatchUMV.get(1));
            p_78018_1_.add(GTNLItemList.NinefoldInputHatchUXV.get(1));
            p_78018_1_.add(GTNLItemList.HumongousNinefoldInputHatch.get(1));

            p_78018_1_.add(GTNLItemList.DualInputHatchLV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchMV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchHV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchEV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchIV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchLuV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchZPM.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchUV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchUHV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchUEV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchUIV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchUMV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchUXV.get(1));
            p_78018_1_.add(GTNLItemList.DualInputHatchMAX.get(1));

            p_78018_1_.add(GTNLItemList.MegaBlastFurnace.get(1));
            p_78018_1_.add(GTNLItemList.BrickedBlastFurnace.get(1));
            p_78018_1_.add(GTNLItemList.ColdIceFreezer.get(1));
            p_78018_1_.add(GTNLItemList.BlazeBlastFurnace.get(1));
            p_78018_1_.add(GTNLItemList.ChemicalPlant.get(1));
            p_78018_1_.add(GTNLItemList.VacuumFreezer.get(1));
            p_78018_1_.add(GTNLItemList.LargeMacerationTower.get(1));
            p_78018_1_.add(GTNLItemList.LargeCutter.get(1));
            p_78018_1_.add(GTNLItemList.LargeSiftingFunnel.get(1));
            p_78018_1_.add(GTNLItemList.LargeIndustrialLathe.get(1));
            p_78018_1_.add(GTNLItemList.LargeMaterialPress.get(1));
            p_78018_1_.add(GTNLItemList.LargeWiremill.get(1));
            p_78018_1_.add(GTNLItemList.LargeBender.get(1));
            p_78018_1_.add(GTNLItemList.ElectricImplosionCompressor.get(1));
            p_78018_1_.add(GTNLItemList.LargeExtruder.get(1));
            p_78018_1_.add(GTNLItemList.LargeArcSmelter.get(1));
            p_78018_1_.add(GTNLItemList.LargeForming.get(1));
            p_78018_1_.add(GTNLItemList.LargeElectrolyzer.get(1));
            p_78018_1_.add(GTNLItemList.LargeElectromagnet.get(1));
            p_78018_1_.add(GTNLItemList.LargeAssembler.get(1));
            p_78018_1_.add(GTNLItemList.LargeMixer.get(1));
            p_78018_1_.add(GTNLItemList.LargeCentrifuge.get(1));
            p_78018_1_.add(GTNLItemList.LargeChemicalBath.get(1));
            p_78018_1_.add(GTNLItemList.LargeAutoclave.get(1));
            p_78018_1_.add(GTNLItemList.LargeSolidifier.get(1));
            p_78018_1_.add(GTNLItemList.LargeExtractor.get(1));
            p_78018_1_.add(GTNLItemList.EnergyInfuser.get(1));
            p_78018_1_.add(GTNLItemList.LargeCanning.get(1));
            p_78018_1_.add(GTNLItemList.Digester.get(1));
            p_78018_1_.add(GTNLItemList.AlloyBlastSmelter.get(1));
            p_78018_1_.add(GTNLItemList.LargeSteamOreWasher.get(1));
            p_78018_1_.add(GTNLItemList.LargeHammer.get(1));
            p_78018_1_.add(GTNLItemList.IsaMill.get(1));
            p_78018_1_.add(GTNLItemList.FlotationCellRegulator.get(1));
            p_78018_1_.add(GTNLItemList.VacuumDryingFurnace.get(1));
            p_78018_1_.add(GTNLItemList.LargeDistillery.get(1));
            p_78018_1_.add(GTNLItemList.Incubator.get(1));
            p_78018_1_.add(GTNLItemList.LargeEngravingLaser.get(1));
            p_78018_1_.add(GTNLItemList.FishingGround.get(1));
            p_78018_1_.add(GTNLItemList.LargePacker.get(1));
            p_78018_1_.add(GTNLItemList.LargeAlloySmelter.get(1));
            p_78018_1_.add(GTNLItemList.LargePyrolyseOven.get(1));

            p_78018_1_.add(GTNLItemList.LargeNaquadahReactor.get(1));
            p_78018_1_.add(GTNLItemList.MolecularTransformer.get(1));
            p_78018_1_.add(GTNLItemList.WoodDistillation.get(1));
            p_78018_1_.add(GTNLItemList.ElementCopying.get(1));
            p_78018_1_.add(GTNLItemList.LargeIncubator.get(1));
            p_78018_1_.add(GTNLItemList.LargeSteamExtractor.get(1));
            p_78018_1_.add(GTNLItemList.ReactionFurnace.get(1));
            p_78018_1_.add(GTNLItemList.LibraryOfRuina.get(1));
            p_78018_1_.add(GTNLItemList.MatterFabricator.get(1));
            p_78018_1_.add(GTNLItemList.LargeBrewer.get(1));
            p_78018_1_.add(GTNLItemList.HandOfJohnDavisonRockefeller.get(1));
            p_78018_1_.add(GTNLItemList.EnergeticPhotovoltaicPowerStation.get(1));
            p_78018_1_.add(GTNLItemList.AdvancedPhotovoltaicPowerStation.get(1));
            p_78018_1_.add(GTNLItemList.VibrantPhotovoltaicPowerStation.get(1));
            p_78018_1_.add(GTNLItemList.IndustrialArcaneAssembler.get(1));
            p_78018_1_.add(GTNLItemList.NineIndustrialMultiMachine.get(1));
            p_78018_1_.add(GTNLItemList.RareEarthCentrifugal.get(1));
            p_78018_1_.add(GTNLItemList.ProcessingArray.get(1));
            p_78018_1_.add(GTNLItemList.MeteorMiner.get(1));
            p_78018_1_.add(GTNLItemList.LargeSteamCrusher.get(1));
            p_78018_1_.add(GTNLItemList.NeutroniumWireCutting.get(1));
            p_78018_1_.add(GTNLItemList.EdenGarden.get(1));
            p_78018_1_.add(GTNLItemList.BloodSoulSacrificialArray.get(1));
            p_78018_1_.add(GTNLItemList.TeleportationArrayToAlfheim.get(1));
            p_78018_1_.add(GTNLItemList.LapotronChip.get(1));
            p_78018_1_.add(GTNLItemList.LargeSteamFurnace.get(1));
            p_78018_1_.add(GTNLItemList.LargeSteamThermalCentrifuge.get(1));
            p_78018_1_.add(GTNLItemList.SteamCracking.get(1));
            p_78018_1_.add(GTNLItemList.LargeSteamChemicalBath.get(1));
            p_78018_1_.add(GTNLItemList.PrimitiveDistillationTower.get(1));
            p_78018_1_.add(GTNLItemList.LargeSteamAlloySmelter.get(1));
            p_78018_1_.add(GTNLItemList.ComponentAssembler.get(1));
            p_78018_1_.add(GTNLItemList.RealArtificialStar.get(1));
            p_78018_1_.add(GTNLItemList.CheatOreProcessingFactory.get(1));
            p_78018_1_.add(GTNLItemList.Desulfurizer.get(1));
            p_78018_1_.add(GTNLItemList.LargeCircuitAssembler.get(1));
            p_78018_1_.add(GTNLItemList.PetrochemicalPlant.get(1));
            p_78018_1_.add(GTNLItemList.SmeltingMixingFurnace.get(1));
            p_78018_1_.add(GTNLItemList.WhiteNightGenerator.get(1));
            p_78018_1_.add(GTNLItemList.LargeSteamCircuitAssembler.get(1));
            p_78018_1_.add(GTNLItemList.GenerationEarthEngine.get(1));
        }
    };

    public static void init() {
        // 可以在这里添加其他初始化逻辑
    }
}
