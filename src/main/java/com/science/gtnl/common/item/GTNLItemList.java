package com.science.gtnl.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.science.gtnl.Utils.Utils;

import gregtech.api.util.GTLog;

public enum GTNLItemList {

    TestCasing,
    TestMetaBlock01_0,
    LargeSteamCircuitAssembler,
    SteamAssemblyCasing,
    // endregion
    Stargate_Coil,
    Stargate_Behind,
    New_Horizons_Coil,
    StargateTier0,
    StargateTier1,
    StargateTier2,
    StargateTier3,
    StargateTier4,
    StargateTier5,
    StargateTier6,
    StargateTier7,
    StargateTier8,
    StargateTier9,
    Stargate_Coil_Compressed;
    // region Member Variables

    private boolean mHasNotBeenSet;
    private boolean mDeprecated;
    private boolean mWarned;

    private ItemStack mStack;

    // endregion

    GTNLItemList() {
        mHasNotBeenSet = true;
    }

    GTNLItemList(boolean aDeprecated) {
        if (aDeprecated) {
            mDeprecated = true;
            mHasNotBeenSet = true;
        }
    }

    public Item getItem() {
        sanityCheck();
        if (Utils.isStackInvalid(mStack)) return null;// TODO replace a default issue item
        return mStack.getItem();
    }

    public Block getBlock() {
        sanityCheck();
        return Block.getBlockFromItem(getItem());
    }

    public ItemStack get(int aAmount, Object... aReplacements) {
        sanityCheck();
        // if invalid, return a replacements
        if (Utils.isStackInvalid(mStack)) {
            GTLog.out.println("Object in the ItemList is null at:");
            new NullPointerException().printStackTrace(GTLog.out);
            return Utils.copyAmount(aAmount, TestMetaBlock01_0.get(1));
        }
        return Utils.copyAmount(aAmount, mStack);
    }

    public int getMeta() {
        return mStack.getItemDamage();
    }

    public GTNLItemList set(Item aItem) {
        mHasNotBeenSet = false;
        if (aItem == null) return this;
        ItemStack aStack = new ItemStack(aItem, 1, 0);
        mStack = Utils.copyAmount(1, aStack);
        return this;
    }

    public GTNLItemList set(ItemStack aStack) {
        if (aStack != null) {
            mHasNotBeenSet = false;
            mStack = Utils.copyAmount(1, aStack);
        }
        return this;
    }

    public boolean hasBeenSet() {
        return !mHasNotBeenSet;
    }

    /**
     * Returns the internal stack. This method is unsafe. It's here only for quick operations. DON'T CHANGE THE RETURNED
     * VALUE!
     */
    public ItemStack getInternalStack_unsafe() {
        return mStack;
    }

    private void sanityCheck() {
        if (mHasNotBeenSet)
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        if (mDeprecated && !mWarned) {
            new Exception(this + " is now deprecated").printStackTrace(GTLog.err);
            // warn only once
            mWarned = true;
        }
    }
}
