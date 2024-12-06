package com.science.gtnl.common.block;

import static com.science.gtnl.ScienceNotLeisure.RESOURCE_ROOT_ID;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.science.gtnl.client.CreativeTabsLoader;

public class BlockLight extends Block {

    public BlockLight(String UnlocalizedName, String TextureName) {
        super(Material.iron);
        this.setLightLevel(150);
        this.setHardness(1.0F);
        this.setResistance(5.0F);
        this.setBlockName(UnlocalizedName);
        this.setBlockTextureName(RESOURCE_ROOT_ID + ":" + TextureName);
        this.setCreativeTab(CreativeTabsLoader.GTNoteLeisure);
    }

}
