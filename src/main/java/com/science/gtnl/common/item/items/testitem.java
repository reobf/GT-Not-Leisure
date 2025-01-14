package com.science.gtnl.common.item.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.science.gtnl.client.CreativeTabsLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class testitem extends Item {

    public testitem() {
        super();

        this.setUnlocalizedName("testitem");
        this.setCreativeTab(CreativeTabsLoader.GTNotLeisure);
        this.setTextureName("sciencenotleisure:testitem");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemStack, final EntityPlayer player, final List toolTip,
        final boolean advancedToolTips) {

        toolTip.add("So cute, not use.");

    }

    public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        if (!worldIn.isRemote) {
            playerIn.addPotionEffect(new PotionEffect(186, 6000, 1));
        }

        stack.splitStack(1);
        return stack;
    }

}
