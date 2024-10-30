package com.science.gtnl.common.item.items.CircuitResonatic;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.science.gtnl.client.CreativeTabsLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CircuitResonaticLV extends Item {

    public CircuitResonaticLV() {
        super();

        this.setUnlocalizedName("CircuitResonaticLV");
        this.setCreativeTab(CreativeTabsLoader.GTNoteLeisure);
        this.setTextureName("sciencenotleisure:CircuitResonatic/CircuitResonaticLV");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemStack, final EntityPlayer player, final List toolTip,
        final boolean advancedToolTips) {

        toolTip.add("An Basic Circuit");
        toolTip.add("LV-Tier");

    }

}
