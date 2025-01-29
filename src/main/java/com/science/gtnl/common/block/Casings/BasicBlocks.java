package com.science.gtnl.common.block.Casings;

import net.minecraft.block.Block;

import com.science.gtnl.common.block.Casings.Base.MetaBlockBase;
import com.science.gtnl.common.block.Casings.Casing.MetaBlockCasing;
import com.science.gtnl.common.block.Casings.Column.MetaBlockColumn;
import com.science.gtnl.common.block.Casings.Glass.MetaBlockGlass;
import com.science.gtnl.common.block.Casings.Glow.MetaBlockGlow;

public class BasicBlocks {

    public static Block BlockStar;
    public static Block BlockLaserBeacon;
    public static Block BlockSoulFarmland;
    public static final Block MetaBlock = new MetaBlockBase("MetaBlock", "MetaBlock");
    public static final Block MetaBlockGlow = new MetaBlockGlow("MetaBlockGlow", "MetaBlockGlow");
    public static final Block MetaBlockGlass = new MetaBlockGlass("MetaBlockGlass", "MetaBlockGlass");
    public static final Block MetaBlockColumn = new MetaBlockColumn("MetaBlockColumn", "MetaBlockColumn");
    public static final MetaBlockCasing MetaBlockCasing = new MetaBlockCasing("MetaBlockCasing", (byte) 0);
}
