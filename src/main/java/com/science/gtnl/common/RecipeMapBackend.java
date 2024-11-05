package com.science.gtnl.common;

import gregtech.api.recipe.RecipeMapBackendPropertiesBuilder;

/**
 * If recipe input items include GT Material meta item and stack size is larger than 64, use this class to replace
 * RecipeMapBackend .
 */
public class RecipeMapBackend extends gregtech.api.recipe.RecipeMapBackend {

    public RecipeMapBackend(RecipeMapBackendPropertiesBuilder propertiesBuilder) {
        super(propertiesBuilder);
    }

    /**
     * Do nothing.
     */
    @Override
    public void reInit() {}
}
