package com.science.gtnl.common.block.Casings.Base;

import static com.science.gtnl.Utils.item.MetaItemStackUtils.initMetaItemStack;
import static com.science.gtnl.Utils.item.MetaItemStackUtils.metaItemStackTooltipsAdd;
import static com.science.gtnl.common.block.Casings.BasicBlocks.MetaBlock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.science.gtnl.client.GTNLCreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockBase extends ItemBlock {

    // region statics

    public static final Map<Integer, String[]> MetaBlockTooltipsMap = new HashMap<>();
    // public static final Map<Integer, ItemStack> MetaBlockMap01 = new HashMap<>();
    public static final Set<Integer> MetaBlockSet = new HashSet<>();

    // endregion
    // -----------------------
    // region Constructors

    public ItemBlockBase(Block aBlock) {
        super(aBlock);
        setHasSubtypes(true);
        setMaxDamage(0);
        this.setCreativeTab(GTNLCreativeTabs.GTNotLeisureBlock);
    }

    // endregion
    // -----------------------
    // region MetaBlock Generators

    public static ItemStack initMetaBlock(String i18nName, int Meta) {
        return initMetaItemStack(i18nName, Meta, MetaBlock, MetaBlockSet);
    }

    public static ItemStack initMetaBlock(String i18nName, int Meta, String[] tooltips) {
        if (tooltips != null) {
            metaItemStackTooltipsAdd(MetaBlockTooltipsMap, Meta, tooltips);
        }
        return initMetaBlock(i18nName, Meta);
    }

    // endregion
    // -----------------------
    // region Member Variables

    // endregion
    // -----------------------
    // region Overrides

    /**
     * Handle the tooltips.
     *
     * @param aItemStack
     * @param theTooltipsList
     */
    @SideOnly(Side.CLIENT)
    @Override
    @SuppressWarnings({ "unchecked" })
    public void addInformation(ItemStack aItemStack, EntityPlayer p_77624_2_, List theTooltipsList,
        boolean p_77624_4_) {
        int meta = aItemStack.getItemDamage();
        if (null != MetaBlockTooltipsMap.get(meta)) {
            String[] tooltips = MetaBlockTooltipsMap.get(meta);
            theTooltipsList.addAll(Arrays.asList(tooltips));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack aStack) {
        return this.field_150939_a.getUnlocalizedName() + "." + this.getDamage(aStack);
    }

    @Override
    public int getMetadata(int aMeta) {
        return aMeta;
    }

}
