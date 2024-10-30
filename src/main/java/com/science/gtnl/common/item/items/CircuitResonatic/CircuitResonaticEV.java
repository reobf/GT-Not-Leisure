package com.science.gtnl.common.item.items.CircuitResonatic;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.science.gtnl.client.CreativeTabsLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CircuitResonaticEV extends Item {

    public CircuitResonaticEV() {
        super();

        this.setUnlocalizedName("CircuitResonaticEV");
        this.setCreativeTab(CreativeTabsLoader.GTNoteLeisure);
        this.setTextureName("sciencenotleisure:CircuitResonatic/CircuitResonaticEV");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemStack, final EntityPlayer player, final List toolTip,
        final boolean advancedToolTips) {

        toolTip.add("An Data Circuit");
        toolTip.add("§8EV-Tier");

    }

}
