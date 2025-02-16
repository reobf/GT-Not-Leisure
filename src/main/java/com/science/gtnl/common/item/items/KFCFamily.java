package com.science.gtnl.common.item.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import com.science.gtnl.Utils.item.TextLocalization;
import com.science.gtnl.client.GTNLCreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class KFCFamily extends ItemFood {

    public KFCFamily(int hunger, float saturation, boolean isWolfFood) {
        super(hunger, saturation, isWolfFood);
        this.setUnlocalizedName("KFCFamily");
        this.setTextureName("sciencenotleisure:KFCFamily");
        this.setCreativeTab(GTNLCreativeTabs.GTNotLeisureItem);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemStack, final EntityPlayer player, final List toolTip,
        final boolean advancedToolTips) {
        toolTip.add(TextLocalization.Tooltip_KFCFamily_00);
    }
}
