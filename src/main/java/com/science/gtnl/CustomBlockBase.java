package com.science.gtnl;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.science.gtnl.common.block.BlockBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomBlockBase extends BlockBase {

    private final long ordinalValue;

    public CustomBlockBase(String name, String textureName, long ordinalValue) {
        super(name, textureName);
        this.ordinalValue = ordinalValue;
    }

    public long getHeat() {
        return this.ordinalValue == 0 ? 0 : 1L + (900L * this.ordinalValue);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(final ItemStack itemStack, final EntityPlayer player, final List<String> toolTip,
        final boolean advancedToolTips) {
        toolTip.add(StatCollector.translateToLocal("gt.nomobspawnsonthisblock"));
        toolTip.add(StatCollector.translateToLocal("gt.notileentityinthisblock"));
        toolTip.add(
            StatCollector.translateToLocal("gt.coilheattooltip") + getHeat()
                + StatCollector.translateToLocal("gt.coilunittooltip"));
    }
}
