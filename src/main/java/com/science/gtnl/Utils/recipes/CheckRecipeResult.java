package com.science.gtnl.Utils.recipes;

public class CheckRecipeResult {

    private boolean cleanRoomRequired;
    private boolean sterileEnvironmentRequired;

    public boolean isCleanRoomRequired() {
        return cleanRoomRequired;
    }

    public void setCleanRoomRequired(boolean cleanRoomRequired) {
        this.cleanRoomRequired = cleanRoomRequired;
    }

    public boolean isSterileEnvironmentRequired() {
        return sterileEnvironmentRequired;
    }

    public void setSterileEnvironmentRequired(boolean sterileEnvironmentRequired) {
        this.sterileEnvironmentRequired = sterileEnvironmentRequired;
    }
}
