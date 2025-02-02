package com.science.gtnl.common.block.ReAvaritia.ExtremeAnvil;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.AnvilUpdateEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AnvilEventHandler {

    @SubscribeEvent
    public void onAnvilUpdate(AnvilUpdateEvent event) {
        if (event.left != null && event.left.getItem() instanceof ItemBlock
            && ((ItemBlock) event.left.getItem()).field_150939_a instanceof BlockExtremeAnvil) {
            event.setCanceled(true); // 完全禁用原版逻辑
        }
    }
}
