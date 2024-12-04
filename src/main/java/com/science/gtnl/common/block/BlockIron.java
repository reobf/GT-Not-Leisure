package com.science.gtnl.common.block;

import static com.science.gtnl.ScienceNotLeisure.RESOURCE_ROOT_ID;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.science.gtnl.client.CreativeTabsLoader;

public class BlockIron extends Block {

    public BlockIron(String UnlocalizedName, String TextureName) {
        super(Material.iron);
        this.setHardness(1.0F);
        this.setResistance(5.0F);
        this.setBlockName(UnlocalizedName);
        this.setBlockTextureName(RESOURCE_ROOT_ID + ":" + TextureName);
        this.setCreativeTab(CreativeTabsLoader.GTNoteLeisure);
    }

}
