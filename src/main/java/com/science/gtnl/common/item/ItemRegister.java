package com.science.gtnl.common.item;

import static com.science.gtnl.Utils.TextHandler.texter;
import static com.science.gtnl.common.item.items.BasicItems.MetaItem;
import static com.science.gtnl.common.item.items.ItemAdder.initItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.science.gtnl.common.GTNLItemList;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.util.GTOreDictUnificator;

public class ItemRegister {

    public static void registryItems() {
        Item[] itemsToReg = { MetaItem };

        for (Item item : itemsToReg) {
            GameRegistry.registerItem(item, item.getUnlocalizedName());
        }

    }

    public static void registryItemContainers() {
        GTNLItemList.TrollFace
            .set(initItem("TrollFace", 0, new String[] { texter("Never Gonna Give You Up~", "tooltips.TrollFace") }));
        GTNLItemList.DepletedExcitedNaquadahFuelRod.set(
            initItem(
                "§bDepleted Excited Naquadah Fuel Rod",
                1,
                new String[] {
                    texter("§oUltimate Form of Naquadah Fuel.", "tooltips.DepletedExcitedNaquadahFuelRod") }));
        GTNLItemList.BlazeCube.set(
            initItem(
                "§eBlaze Cube",
                2,
                new String[] { texter("§oForged from the soul fire, storing endless heat.", "tooltips.BlazeCube") }));
        GTNLItemList.StrangeAnnihilationFuelRod.set(
            initItem(
                "Strange Annihilation Fuel Rod",
                3,
                new String[] { texter("A test item, no use.", "tooltips.TestItem0.line1") }));
        GTNLItemList.StellarConstructionFrameMaterial.set(
            initItem(
                "Stellar Construction Frame Material",
                4,
                new String[] { texter("A test item, no use.", "tooltips.TestItem0.line1") }));
        GTNLItemList.ActivatedGaiaPylon.set(initItem("Activated Gaia Pylon", 5));
        GTNLItemList.PrecisionSteamMechanism.set(initItem("Precision Steam Mechanism", 6));
        GTNLItemList.MeteorMinerSchematic1.set(
            initItem(
                "Meteor Miner Tier 1 Schematic",
                7,
                new String[] {
                    texter("Schematic needed to enable the Tier 1 Meteor Miner", "tooltips.MeteorMinerSchematic1") }));
        GTNLItemList.MeteorMinerSchematic2.set(
            initItem(
                "Meteor Miner Tier 2 Schematic",
                8,
                new String[] {
                    texter("Schematic needed to enable the Tier 2 Meteor Miner", "tooltips.MeteorMinerSchematic2") }));
        GTNLItemList.CircuitResonaticULV.set(
            initItem(
                "Circuit Resonatic ULV",
                9,
                new String[] { texter("An Original Circuit", "tooltips.CircuitResonaticULV_00"),
                    texter("§fULV-Tier", "tooltips.CircuitResonaticULV_01") }));
        GTNLItemList.CircuitResonaticLV.set(
            initItem(
                "Circuit Resonatic LV",
                10,
                new String[] { texter("An Basic Circuit", "tooltips.CircuitResonaticLV_00"),
                    texter("LV-Tier", "tooltips.CircuitResonaticLV_01") }));
        GTNLItemList.CircuitResonaticMV.set(
            initItem(
                "Circuit Resonatic MV",
                11,
                new String[] { texter("An Good Circuit", "tooltips.CircuitResonaticMV_00"),
                    texter("§6MV-Tier", "tooltips.CircuitResonaticMV_01") }));
        GTNLItemList.CircuitResonaticHV.set(
            initItem(
                "Circuit Resonatic HV",
                12,
                new String[] { texter("An Adavanced Circuit", "tooltips.CircuitResonaticHV_00"),
                    texter("§eHV-Tier", "tooltips.CircuitResonaticHV_01") }));
        GTNLItemList.CircuitResonaticEV.set(
            initItem(
                "Circuit Resonatic EV",
                13,
                new String[] { texter("An Data Circuit", "tooltips.CircuitResonaticEV_00"),
                    texter("§8EV-Tier", "tooltips.CircuitResonaticEV_01") }));
        GTNLItemList.CircuitResonaticIV.set(
            initItem(
                "Circuit Resonatic IV",
                14,
                new String[] { texter("An Elite Circuit", "tooltips.CircuitResonaticIV_00"),
                    texter("§aIV-Tier", "tooltips.CircuitResonaticIV_01") }));
        GTNLItemList.CircuitResonaticLuV.set(
            initItem(
                "Circuit Resonatic LuV",
                15,
                new String[] { texter("An Master Circuit", "tooltips.CircuitResonaticLuV_00"),
                    texter("§dLuV-Tier", "tooltips.CircuitResonaticLuV_01") }));
        GTNLItemList.CircuitResonaticZPM.set(
            initItem(
                "Circuit Resonatic ZPM",
                16,
                new String[] { texter("An Ultimate Circuit", "tooltips.CircuitResonaticZPM_00"),
                    texter("§bZPM-Tier", "tooltips.CircuitResonaticZPM_01") }));
        GTNLItemList.CircuitResonaticUV.set(
            initItem(
                "Circuit Resonatic UV",
                17,
                new String[] { texter("An Superconductor Circuit", "tooltips.CircuitResonaticUV_00"),
                    texter("§2UV-Tier", "tooltips.CircuitResonaticUV_01") }));
        GTNLItemList.CircuitResonaticUHV.set(
            initItem(
                "Circuit Resonatic UHV",
                18,
                new String[] { texter("An Infinite Circuit", "tooltips.CircuitResonaticUHV_00"),
                    texter("§4UHV-Tier", "tooltips.CircuitResonaticUHV_01") }));
        GTNLItemList.CircuitResonaticUEV.set(
            initItem(
                "Circuit Resonatic UEV",
                19,
                new String[] { texter("An Bio Circuit", "tooltips.CircuitResonaticUEV_00"),
                    texter("§5UEV-Tier", "tooltips.CircuitResonaticUEV_01") }));
        GTNLItemList.CircuitResonaticUIV.set(
            initItem(
                "Circuit Resonatic UIV",
                20,
                new String[] { texter("An Optical Circuit", "tooltips.CircuitResonaticUIV_00"),
                    texter("§l§1UIV-Tier", "tooltips.CircuitResonaticUIV_01") }));
        GTNLItemList.VerySimpleCircuit.set(
            initItem(
                "Very Simple Circuit",
                21,
                new String[] { texter("An Very Simple Circuit", "tooltips.VerySimpleCircuit_00"),
                    texter("§fULV-Tier", "tooltips.VerySimpleCircuit_01") }));
        GTNLItemList.SimpleCircuit.set(
            initItem(
                "Simple Circuit",
                22,
                new String[] { texter("An Simple Circuit", "tooltips.SimpleCircuit_00"),
                    texter("LV-Tier", "tooltips.SimpleCircuit_01") }));
        GTNLItemList.BasicCircuit.set(
            initItem(
                "Basic Circuit",
                23,
                new String[] { texter("An Basic Circuit", "tooltips.BasicCircuit_00"),
                    texter("§6MV-Tier", "tooltips.BasicCircuit_01") }));
        GTNLItemList.AdvancedCircuit.set(
            initItem(
                "Advanced Circuit",
                24,
                new String[] { texter("An Advanced Circuit", "tooltips.AdvancedCircuit_00"),
                    texter("§eHV-Tier", "tooltips.AdvancedCircuit_01") }));
        GTNLItemList.EliteCircuit.set(
            initItem(
                "Elite Circuit",
                25,
                new String[] { texter("An Elite Circuit", "tooltips.EliteCircuit_00"),
                    texter("§8EV-Tier", "tooltips.EliteCircuit_01") }));
        GTNLItemList.StargateSingularity.set(initItem("Stargate Singularity", 26));
        GTNLItemList.StargateCompressedSingularity.set(initItem("Stargate Compressed Singularity", 27));
        GTNLItemList.BiowareSMDCapacitor.set(initItem("Bioware SMD Capacitor", 28));
        GTNLItemList.BiowareSMDDiode.set(initItem("Bioware SMD Diode", 29));
        GTNLItemList.BiowareSMDInductor.set(initItem("Bioware SMD Inductor", 30));
        GTNLItemList.BiowareSMDResistor.set(initItem("Bioware SMD Resistor", 31));
        GTNLItemList.BiowareSMDTransistor.set(initItem("Bioware SMD Transistor", 32));
        GTNLItemList.ExoticSMDCapacitor.set(initItem("Exotic SMD Capacitor", 33));
        GTNLItemList.ExoticSMDDiode.set(initItem("Exotic SMD Diode", 34));
        GTNLItemList.ExoticSMDInductor.set(initItem("Exotic SMD Inductor", 35));
        GTNLItemList.ExoticSMDResistor.set(initItem("Exotic SMD Resistor", 36));
        GTNLItemList.ExoticSMDTransistor.set(initItem("Exotic SMD Transistor", 37));
        GTNLItemList.TemporallySMDCapacitor.set(initItem("Temporally SMD Capacitor", 38));
        GTNLItemList.TemporallySMDDiode.set(initItem("Temporally SMD Diode", 39));
        GTNLItemList.TemporallySMDInductor.set(initItem("Temporally SMD Inductor", 40));
        GTNLItemList.TemporallySMDResistor.set(initItem("Temporally SMD Resistor", 41));
        GTNLItemList.TemporallySMDTransistor.set(initItem("Temporally SMD Transistor", 42));
        GTNLItemList.CosmicSMDCapacitor.set(initItem("Cosmic SMD Capacitor", 43));
        GTNLItemList.CosmicSMDDiode.set(initItem("Cosmic SMD Diode", 44));
        GTNLItemList.CosmicSMDInductor.set(initItem("Cosmic SMD Inductor", 45));
        GTNLItemList.CosmicSMDResistor.set(initItem("Cosmic SMD Resistor", 46));
        GTNLItemList.CosmicSMDTransistor.set(initItem("Cosmic SMD Transistor", 47));
    }

    public static void registry() {
        registryItems();
        registryItemContainers();
    }

    public static void registryOreDictionary() {
        ItemStack CircuitResonaticULV = new ItemStack(MetaItem, 1, 9);
        ItemStack CircuitResonaticLV = new ItemStack(MetaItem, 1, 10);
        ItemStack CircuitResonaticMV = new ItemStack(MetaItem, 1, 11);
        ItemStack CircuitResonaticHV = new ItemStack(MetaItem, 1, 12);
        ItemStack CircuitResonaticEV = new ItemStack(MetaItem, 1, 13);
        ItemStack CircuitResonaticIV = new ItemStack(MetaItem, 1, 14);
        ItemStack CircuitResonaticLuV = new ItemStack(MetaItem, 1, 15);
        ItemStack CircuitResonaticZPM = new ItemStack(MetaItem, 1, 16);
        ItemStack CircuitResonaticUV = new ItemStack(MetaItem, 1, 17);
        ItemStack CircuitResonaticUHV = new ItemStack(MetaItem, 1, 18);
        ItemStack CircuitResonaticUEV = new ItemStack(MetaItem, 1, 19);
        ItemStack CircuitResonaticUIV = new ItemStack(MetaItem, 1, 20);
        ItemStack VerySimpleCircuit = new ItemStack(MetaItem, 1, 21);
        ItemStack SimpleCircuit = new ItemStack(MetaItem, 1, 22);
        ItemStack BasicCircuit = new ItemStack(MetaItem, 1, 23);
        ItemStack AdvancedCircuit = new ItemStack(MetaItem, 1, 24);
        ItemStack EliteCircuit = new ItemStack(MetaItem, 1, 25);

        OreDictionary.registerOre("circuitPrimitive", CircuitResonaticULV);
        OreDictionary.registerOre("circuitBasic", CircuitResonaticLV);
        OreDictionary.registerOre("circuitGood", CircuitResonaticMV);
        OreDictionary.registerOre("circuitAdvanced", CircuitResonaticHV);
        OreDictionary.registerOre("circuitData", CircuitResonaticEV);
        OreDictionary.registerOre("circuitElite", CircuitResonaticIV);
        OreDictionary.registerOre("circuitMaster", CircuitResonaticLuV);
        OreDictionary.registerOre("circuitUltimate", CircuitResonaticZPM);
        OreDictionary.registerOre("circuitSuperconductor", CircuitResonaticUV);
        OreDictionary.registerOre("circuitInfinite", CircuitResonaticUHV);
        OreDictionary.registerOre("circuitBio", CircuitResonaticUEV);
        OreDictionary.registerOre("circuitOptical", CircuitResonaticUIV);
        OreDictionary.registerOre("circuitPrimitive", VerySimpleCircuit);
        OreDictionary.registerOre("circuitBasic", SimpleCircuit);
        OreDictionary.registerOre("circuitGood", BasicCircuit);
        OreDictionary.registerOre("circuitAdvanced", AdvancedCircuit);
        OreDictionary.registerOre("circuitData", EliteCircuit);

        GTOreDictUnificator.addToBlacklist(CircuitResonaticULV);
        GTOreDictUnificator.addToBlacklist(CircuitResonaticLV);
        GTOreDictUnificator.addToBlacklist(CircuitResonaticMV);
        GTOreDictUnificator.addToBlacklist(CircuitResonaticHV);
        GTOreDictUnificator.addToBlacklist(CircuitResonaticEV);
        GTOreDictUnificator.addToBlacklist(CircuitResonaticIV);
        GTOreDictUnificator.addToBlacklist(CircuitResonaticLuV);
        GTOreDictUnificator.addToBlacklist(CircuitResonaticZPM);
        GTOreDictUnificator.addToBlacklist(CircuitResonaticUV);
        GTOreDictUnificator.addToBlacklist(CircuitResonaticUHV);
        GTOreDictUnificator.addToBlacklist(CircuitResonaticUEV);
        GTOreDictUnificator.addToBlacklist(CircuitResonaticUIV);
        GTOreDictUnificator.addToBlacklist(VerySimpleCircuit);
        GTOreDictUnificator.addToBlacklist(SimpleCircuit);
        GTOreDictUnificator.addToBlacklist(BasicCircuit);
        GTOreDictUnificator.addToBlacklist(AdvancedCircuit);
        GTOreDictUnificator.addToBlacklist(EliteCircuit);
    }
}
