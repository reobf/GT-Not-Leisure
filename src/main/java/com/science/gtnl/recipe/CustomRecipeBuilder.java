package com.science.gtnl.recipe;

import static gregtech.api.util.GTRecipeMapUtil.SPECIAL_VALUE_ALIASES;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import org.jetbrains.annotations.Contract;

import com.science.gtnl.Utils.RecipeConstants;

import gregtech.api.interfaces.IRecipeMap;
import gregtech.api.recipe.RecipeMetadataKey;
import gregtech.api.recipe.metadata.IRecipeMetadataStorage;
import gregtech.api.recipe.metadata.RecipeMetadataStorage;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.GTRecipeBuilder;
import gregtech.api.util.GTRecipeConstants;

public class CustomRecipeBuilder {

    private final GTRecipeBuilder baseBuilder;

    public CustomRecipeBuilder(GTRecipeBuilder baseBuilder) {
        this.baseBuilder = baseBuilder;
    }

    public CustomRecipeBuilder requiresSterileCleaning() {
        baseBuilder.metadata(RecipeConstants.STERILE_CLEANING, true);
        return this;
    }

    public CustomRecipeBuilder itemInputs(ItemStack... inputItems) {
        baseBuilder.itemInputs(inputItems);
        return this;
    }

    public CustomRecipeBuilder itemOutputs(ItemStack... outputItems) {
        baseBuilder.itemOutputs(outputItems);
        return this;
    }

    public CustomRecipeBuilder fluidInputs(FluidStack... inputFluids) {
        baseBuilder.fluidInputs(inputFluids);
        return this;
    }

    public CustomRecipeBuilder fluidOutputs(FluidStack... outputFluids) {
        baseBuilder.fluidOutputs(outputFluids);
        return this;
    }

    public CustomRecipeBuilder specialValue(int specialValue) {
        baseBuilder.specialValue(specialValue);
        return this;
    }

    public CustomRecipeBuilder noOptimize() {
        baseBuilder.noOptimize();
        return this;
    }

    public CustomRecipeBuilder duration(int duration) {
        baseBuilder.duration(duration);
        return this;
    }

    public CustomRecipeBuilder eut(int eut) {
        baseBuilder.eut(eut);
        return this;
    }

    protected boolean skip = false;
    @Nullable
    protected IRecipeMetadataStorage metadataStorage;

    public <T> CustomRecipeBuilder metadata(RecipeMetadataKey<T> key, T value) {
        if (skip) return this;
        if (metadataStorage == null) {
            metadataStorage = new RecipeMetadataStorage();
        }
        metadataStorage.store(key, value);
        return this;
    }

    public CustomRecipeBuilder requiresCleanRoom() {
        return metadata(GTRecipeConstants.CLEANROOM, true);
    }

    public CustomRecipeBuilder addTo(IRecipeMap recipeMap) {
        baseBuilder.addTo(recipeMap);
        return this;
    }

    @Contract("_, !null -> !null")
    @Nullable
    public <T> T getMetadataOrDefault(RecipeMetadataKey<T> key, T defaultValue) {
        if (metadataStorage == null) {
            return defaultValue;
        }
        return key.cast(metadataStorage.getMetadataOrDefault(key, defaultValue));
    }

    private void applyDefaultSpecialValues(GTRecipe recipe) {
        if (recipe.mSpecialValue != 0) return;
        int specialValue = 0;
        if (getMetadataOrDefault(GTRecipeConstants.LOW_GRAVITY, false)) specialValue -= 100;
        if (getMetadataOrDefault(GTRecipeConstants.CLEANROOM, false)) specialValue -= 200;
        if (getMetadataOrDefault(RecipeConstants.STERILE_CLEANING, false)) specialValue -= 200;
        for (RecipeMetadataKey<Integer> ident : SPECIAL_VALUE_ALIASES) {
            Integer metadata = getMetadataOrDefault(ident, null);
            if (metadata != null) {
                specialValue = metadata;
                break;
            }
        }
        recipe.mSpecialValue = specialValue;
    }
}
