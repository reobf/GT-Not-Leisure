package com.science.gtnl.common.machine.OreProcessing;

import static com.science.gtnl.Utils.Utils.setStackSize;
import static com.science.gtnl.common.machine.OreProcessing.OP_Values.OreProcessRecipeDuration;
import static com.science.gtnl.common.machine.OreProcessing.OP_Values.OreProcessRecipeEUt;
import static gregtech.api.enums.OrePrefixes.*;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

import com.science.gtnl.common.RecipeRegister;

import bartworks.system.material.Werkstoff;
import gregtech.api.enums.GTValues;

public class OP_Bartworks_OreHandler {

    public void processBWOreRecipes() {
        for (Werkstoff werkstoff : Werkstoff.werkstoffHashSet) {
            if (!werkstoff.hasItemType(ore)) continue;
            ArrayList<ItemStack> outputs = new ArrayList<>();
            // basic output
            outputs.add(werkstoff.get(dust, 4));

            // gem output
            if (werkstoff.hasItemType(gem)) {
                if (werkstoff.hasItemType(gemExquisite)) {
                    outputs.add(werkstoff.get(gemExquisite, 1));
                    outputs.add(werkstoff.get(gemFlawless, 2));
                    outputs.add(werkstoff.get(gem, 2));
                } else {
                    outputs.add(werkstoff.get(gem, 4));
                }
            }

            // byproducts
            if (werkstoff.getNoOfByProducts() >= 1) {
                if (werkstoff.getNoOfByProducts() == 1) {
                    outputs.add(setStackSize(werkstoff.getOreByProduct(0, dust), 3));
                } else {
                    for (int i = 0; i < werkstoff.getNoOfByProducts(); i++) {
                        outputs.add(setStackSize(werkstoff.getOreByProduct(i, dust), 2));
                    }
                }
            } else {
                outputs.add(werkstoff.get(dust, 3));
            }

            if (werkstoff.hasItemType(rawOre)) {
                ArrayList<ItemStack> rawOreOutputs = new ArrayList<>();
                rawOreOutputs.add(werkstoff.get(dust, 3));

                if (werkstoff.hasItemType(gem)) {
                    if (werkstoff.hasItemType(gemExquisite)) {
                        rawOreOutputs.add(werkstoff.get(gemExquisite, 1));
                        rawOreOutputs.add(werkstoff.get(gemFlawless, 1));
                        rawOreOutputs.add(werkstoff.get(gem, 1));
                    } else {
                        rawOreOutputs.add(werkstoff.get(gem, 2));
                    }
                }

                if (werkstoff.getNoOfByProducts() >= 1) {
                    if (werkstoff.getNoOfByProducts() == 1) {
                        rawOreOutputs.add(setStackSize(werkstoff.getOreByProduct(0, dust), 3));
                    } else {
                        for (int i = 0; i < werkstoff.getNoOfByProducts(); i++) {
                            rawOreOutputs.add(setStackSize(werkstoff.getOreByProduct(i, dust), 2));
                        }
                    }
                } else {
                    rawOreOutputs.add(werkstoff.get(dust, 2));
                }

                GTValues.RA.stdBuilder()
                    .itemInputs(werkstoff.get(rawOre, 1))
                    .itemOutputs(rawOreOutputs.toArray(new ItemStack[] {}))
                    .eut(OreProcessRecipeEUt)
                    .duration(OreProcessRecipeDuration)
                    .addTo(RecipeRegister.CheatOreProcessingRecipes);
            }

            GTValues.RA.stdBuilder()
                .itemInputs(werkstoff.get(ore, 1))
                .itemOutputs(outputs.toArray(new ItemStack[] {}))
                .eut(OreProcessRecipeEUt)
                .duration(OreProcessRecipeDuration)
                .addTo(RecipeRegister.CheatOreProcessingRecipes);
        }
    }
}
