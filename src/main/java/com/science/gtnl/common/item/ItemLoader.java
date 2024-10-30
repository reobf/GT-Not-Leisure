package com.science.gtnl.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.science.gtnl.common.item.items.AdvancedCircuit;
import com.science.gtnl.common.item.items.BasicCircuit;
import com.science.gtnl.common.item.items.BiowareSMD.BiowareSMDCapacitor;
import com.science.gtnl.common.item.items.BiowareSMD.BiowareSMDDiode;
import com.science.gtnl.common.item.items.BiowareSMD.BiowareSMDInductor;
import com.science.gtnl.common.item.items.BiowareSMD.BiowareSMDResistor;
import com.science.gtnl.common.item.items.BiowareSMD.BiowareSMDTransistor;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticEV;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticHV;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticIV;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticLV;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticLuV;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticMV;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticUEV;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticUHV;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticUIV;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticULV;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticUV;
import com.science.gtnl.common.item.items.CircuitResonatic.CircuitResonaticZPM;
import com.science.gtnl.common.item.items.CosmicSMD.CosmicSMDCapacitor;
import com.science.gtnl.common.item.items.CosmicSMD.CosmicSMDDiode;
import com.science.gtnl.common.item.items.CosmicSMD.CosmicSMDInductor;
import com.science.gtnl.common.item.items.CosmicSMD.CosmicSMDResistor;
import com.science.gtnl.common.item.items.CosmicSMD.CosmicSMDTransistor;
import com.science.gtnl.common.item.items.EliteCircuit;
import com.science.gtnl.common.item.items.ExoticSMD.ExoticSMDCapacitor;
import com.science.gtnl.common.item.items.ExoticSMD.ExoticSMDDiode;
import com.science.gtnl.common.item.items.ExoticSMD.ExoticSMDInductor;
import com.science.gtnl.common.item.items.ExoticSMD.ExoticSMDResistor;
import com.science.gtnl.common.item.items.ExoticSMD.ExoticSMDTransistor;
import com.science.gtnl.common.item.items.SimpleCircuit;
import com.science.gtnl.common.item.items.StargateCompressedSingularity;
import com.science.gtnl.common.item.items.StargateSingularity;
import com.science.gtnl.common.item.items.TemporallySMD.TemporallySMDCapacitor;
import com.science.gtnl.common.item.items.TemporallySMD.TemporallySMDDiode;
import com.science.gtnl.common.item.items.TemporallySMD.TemporallySMDInductor;
import com.science.gtnl.common.item.items.TemporallySMD.TemporallySMDResistor;
import com.science.gtnl.common.item.items.TemporallySMD.TemporallySMDTransistor;
import com.science.gtnl.common.item.items.VerySimpleCircuit;
import com.science.gtnl.common.item.items.testitem;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.util.GTOreDictUnificator;

public class ItemLoader {

    public static Item testitem = new testitem();
    public static Item StargateCompressedSingularity = new StargateCompressedSingularity();
    public static Item StargateSingularity = new StargateSingularity();
    public static Item VerySimpleCircuit = new VerySimpleCircuit();
    public static Item SimpleCircuit = new SimpleCircuit();
    public static Item BasicCircuit = new BasicCircuit();
    public static Item AdvancedCircuit = new AdvancedCircuit();
    public static Item EliteCircuit = new EliteCircuit();
    public static Item CircuitResonaticULV = new CircuitResonaticULV();
    public static Item CircuitResonaticLV = new CircuitResonaticLV();
    public static Item CircuitResonaticMV = new CircuitResonaticMV();
    public static Item CircuitResonaticHV = new CircuitResonaticHV();
    public static Item CircuitResonaticEV = new CircuitResonaticEV();
    public static Item CircuitResonaticIV = new CircuitResonaticIV();
    public static Item CircuitResonaticLuV = new CircuitResonaticLuV();
    public static Item CircuitResonaticZPM = new CircuitResonaticZPM();
    public static Item CircuitResonaticUV = new CircuitResonaticUV();
    public static Item CircuitResonaticUHV = new CircuitResonaticUHV();
    public static Item CircuitResonaticUEV = new CircuitResonaticUEV();
    public static Item CircuitResonaticUIV = new CircuitResonaticUIV();
    public static Item BiowareSMDCapacitor = new BiowareSMDCapacitor();
    public static Item BiowareSMDDiode = new BiowareSMDDiode();
    public static Item BiowareSMDInductor = new BiowareSMDInductor();
    public static Item BiowareSMDResistor = new BiowareSMDResistor();
    public static Item BiowareSMDTransistor = new BiowareSMDTransistor();
    public static Item ExoticSMDCapacitor = new ExoticSMDCapacitor();
    public static Item ExoticSMDDiode = new ExoticSMDDiode();
    public static Item ExoticSMDInductor = new ExoticSMDInductor();
    public static Item ExoticSMDResistor = new ExoticSMDResistor();
    public static Item ExoticSMDTransistor = new ExoticSMDTransistor();
    public static Item TemporallySMDCapacitor = new TemporallySMDCapacitor();
    public static Item TemporallySMDDiode = new TemporallySMDDiode();
    public static Item TemporallySMDInductor = new TemporallySMDInductor();
    public static Item TemporallySMDResistor = new TemporallySMDResistor();
    public static Item TemporallySMDTransistor = new TemporallySMDTransistor();
    public static Item CosmicSMDCapacitor = new CosmicSMDCapacitor();
    public static Item CosmicSMDDiode = new CosmicSMDDiode();
    public static Item CosmicSMDInductor = new CosmicSMDInductor();
    public static Item CosmicSMDResistor = new CosmicSMDResistor();
    public static Item CosmicSMDTransistor = new CosmicSMDTransistor();

    public ItemLoader(FMLPreInitializationEvent event) {
        IRegistry(testitem, "testitem");
        IRegistry(StargateCompressedSingularity, "StargateCompressedSingularity");
        IRegistry(StargateSingularity, "StargateSingularity");
        IRegistry(VerySimpleCircuit, "VerySimpleCircuit");
        IRegistry(BasicCircuit, "BasicCircuit");
        IRegistry(SimpleCircuit, "SimpleCircuit");
        IRegistry(AdvancedCircuit, "AdvancedCircuit");
        IRegistry(EliteCircuit, "EliteCircuit");
        IRegistry(BiowareSMDCapacitor, "BiowareSMDCapacitor");
        IRegistry(BiowareSMDDiode, "BiowareSMDDiode");
        IRegistry(BiowareSMDInductor, "BiowareSMDInductor");
        IRegistry(BiowareSMDResistor, "BiowareSMDResistor");
        IRegistry(BiowareSMDTransistor, "BiowareSMDTransistor");
        IRegistry(ExoticSMDCapacitor, "ExoticSMDCapacitor");
        IRegistry(ExoticSMDDiode, "ExoticSMDDiode");
        IRegistry(ExoticSMDInductor, "ExoticSMDInductor");
        IRegistry(ExoticSMDResistor, "ExoticSMDResistor");
        IRegistry(ExoticSMDTransistor, "ExoticSMDTransistor");
        IRegistry(TemporallySMDCapacitor, "TemporallySMDCapacitor");
        IRegistry(TemporallySMDDiode, "TemporallySMDDiode");
        IRegistry(TemporallySMDInductor, "TemporallySMDInductor");
        IRegistry(TemporallySMDResistor, "TemporallySMDResistor");
        IRegistry(TemporallySMDTransistor, "TemporallySMDTransistor");
        IRegistry(CosmicSMDCapacitor, "CosmicSMDCapacitor");
        IRegistry(CosmicSMDDiode, "CosmicSMDDiode");
        IRegistry(CosmicSMDInductor, "CosmicSMDInductor");
        IRegistry(CosmicSMDResistor, "CosmicSMDResistor");
        IRegistry(CosmicSMDTransistor, "CosmicSMDTransistor");
        IRegistry(CircuitResonaticULV, "CircuitResonaticULV");
        IRegistry(CircuitResonaticLV, "CircuitResonaticLV");
        IRegistry(CircuitResonaticMV, "CircuitResonaticMV");
        IRegistry(CircuitResonaticHV, "CircuitResonaticHV");
        IRegistry(CircuitResonaticEV, "CircuitResonaticEV");
        IRegistry(CircuitResonaticIV, "CircuitResonaticIV");
        IRegistry(CircuitResonaticLuV, "CircuitResonaticLuV");
        IRegistry(CircuitResonaticZPM, "CircuitResonaticZPM");
        IRegistry(CircuitResonaticUV, "CircuitResonaticUV");
        IRegistry(CircuitResonaticUHV, "CircuitResonaticUHV");
        IRegistry(CircuitResonaticUEV, "CircuitResonaticUEV");
        IRegistry(CircuitResonaticUIV, "CircuitResonaticUIV");

        // 添加矿辞
        OreDictionary.registerOre("circuitPrimitive", VerySimpleCircuit);
        OreDictionary.registerOre("circuitBasic", SimpleCircuit);
        OreDictionary.registerOre("circuitGood", BasicCircuit);
        OreDictionary.registerOre("circuitAdavanced", AdvancedCircuit);
        OreDictionary.registerOre("circuitData", EliteCircuit);
        OreDictionary.registerOre("circuitPrimitive", CircuitResonaticULV);
        OreDictionary.registerOre("circuitBasic", CircuitResonaticLV);
        OreDictionary.registerOre("circuitGood", CircuitResonaticMV);
        OreDictionary.registerOre("circuitAdavanced", CircuitResonaticHV);
        OreDictionary.registerOre("circuitData", CircuitResonaticEV);
        OreDictionary.registerOre("circuitElite", CircuitResonaticIV);
        OreDictionary.registerOre("circuitMaster", CircuitResonaticLuV);
        OreDictionary.registerOre("circuitUltimate", CircuitResonaticZPM);
        OreDictionary.registerOre("circuitSuperconductor", CircuitResonaticUV);
        OreDictionary.registerOre("circuitInfinite", CircuitResonaticUHV);
        OreDictionary.registerOre("circuitBio", CircuitResonaticUEV);
        OreDictionary.registerOre("circuitOptical", CircuitResonaticUIV);

        // 创建ItemStack并添加SubTag逻辑
        ItemStack VerySimpleCircuitStack = new ItemStack(VerySimpleCircuit);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(VerySimpleCircuitStack);
        }
        ItemStack SimpleCircuitStack = new ItemStack(SimpleCircuit);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(SimpleCircuitStack);
        }
        ItemStack BasicCircuitStack = new ItemStack(BasicCircuit);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(BasicCircuitStack);
        }
        ItemStack AdvancedCircuitStack = new ItemStack(AdvancedCircuit);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(AdvancedCircuitStack);
        }
        ItemStack EliteCircuitStack = new ItemStack(EliteCircuit);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(EliteCircuitStack);
        }
        ItemStack CircuitResonaticULVStack = new ItemStack(CircuitResonaticULV);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticULVStack);
        }
        ItemStack CircuitResonaticLVStack = new ItemStack(CircuitResonaticLV);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticLVStack);
        }
        ItemStack CircuitResonaticMVStack = new ItemStack(CircuitResonaticMV);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticMVStack);
        }
        ItemStack CircuitResonaticHVStack = new ItemStack(CircuitResonaticHV);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticHVStack);
        }
        ItemStack CircuitResonaticEVStack = new ItemStack(CircuitResonaticEV);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticEVStack);
        }
        ItemStack CircuitResonaticIVStack = new ItemStack(CircuitResonaticIV);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticIVStack);
        }
        ItemStack CircuitResonaticLuVStack = new ItemStack(CircuitResonaticLuV);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticLuVStack);
        }
        ItemStack CircuitResonaticZPMStack = new ItemStack(CircuitResonaticZPM);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticZPMStack);
        }
        ItemStack CircuitResonaticUVStack = new ItemStack(CircuitResonaticUV);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticUVStack);
        }
        ItemStack CircuitResonaticUHVStack = new ItemStack(CircuitResonaticUHV);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticUHVStack);
        }
        ItemStack CircuitResonaticUEVStack = new ItemStack(CircuitResonaticUEV);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticUEVStack);
        }
        ItemStack CircuitResonaticUIVStack = new ItemStack(CircuitResonaticUIV);
        if (shouldNotUnify()) {
            GTOreDictUnificator.addToBlacklist(CircuitResonaticUIVStack);
        }
    }

    private static void IRegistry(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }

    private boolean shouldNotUnify() {
        // 根据你的逻辑确定是否不进行统一
        return true; // 这里简单返回true作为示例
    }
}
