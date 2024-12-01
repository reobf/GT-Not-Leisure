package com.science.gtnl.common.item;

import static com.science.gtnl.Utils.TextHandler.texter;
import static com.science.gtnl.common.item.items.ItemAdder01.initItem01;

import net.minecraft.item.Item;

import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.item.items.BasicItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegister {

    public static void registryItems() {
        Item[] itemsToReg = { BasicItems.MetaItem01 };

        for (Item item : itemsToReg) {
            GameRegistry.registerItem(item, item.getUnlocalizedName());
        }

    }

    public static void registryItemContainers() {
        GTNLItemList.TrollFace
            .set(initItem01("TrollFace", 0, new String[] { texter("Never Gonna Give You Up~", "tooltips.TrollFace") }));
        GTNLItemList.DepletedExcitedNaquadahFuelRod.set(
            initItem01("§bDepleted Excited Naquadah Fuel Rod", 1, new String[] { texter("§oUltimate Form of Naquadah Fuel.", "tooltips.DepletedExcitedNaquadahFuelRod") }));
        GTNLItemList.BlazeCube.set(
            initItem01(
                "§eBlaze Cube",
                2,
                new String[] { texter("§oForged from the soul fire, storing endless heat.", "tooltips.BlazeCube") }));
        GTNLItemList.StrangeAnnihilationFuelRod.set(
            initItem01(
                "Strange Annihilation Fuel Rod",
                3,
                new String[] { texter("A test item, no use.", "tooltips.TestItem0.line1") }));
        GTNLItemList.StellarConstructionFrameMaterial.set(
            initItem01(
                "Stellar Construction Frame Material",
                4,
                new String[] { texter("A test item, no use.", "tooltips.TestItem0.line1") }));
    }

    public static void registry() {
        registryItems();
        registryItemContainers();
    }
}
