package com.science.gtnl.common.item.items.TemporallySMD;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.science.gtnl.client.CreativeTabsLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TemporallySMDTransistor extends Item {

    public TemporallySMDTransistor() {
        super();

        this.setUnlocalizedName("TemporallySMDTransistor");
        this.setCreativeTab(CreativeTabsLoader.GTNoteLeisure);
        this.setTextureName("sciencenotleisure:TemporallySMD/TemporallySMDTransistor");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemStack, final EntityPlayer player, final List toolTip,
        final boolean advancedToolTips) {

    }

}
