package com.science.gtnl.common.block;

import static com.science.gtnl.ScienceNotLeisure.RESOURCE_ROOT_ID;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;

import com.science.gtnl.client.CreativeTabsLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGlass extends Block {

    public BlockGlass(String UnlocalizedName, String TextureName) {
        super(Material.glass);
        this.setHardness(1.0F);
        this.setLightOpacity(0);
        this.setResistance(5.0F);
        this.setBlockName(UnlocalizedName);
        this.setBlockTextureName(RESOURCE_ROOT_ID + ":" + TextureName);
        this.setCreativeTab(CreativeTabsLoader.GTNoteLeisure);
    }

    @Override
    public boolean isNormalCube(IBlockAccess aWorld, int aX, int aY, int aZ) {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, int x, int y, int z, int side) {
        Block block = worldIn.getBlock(x, y, z);

        if (worldIn.getBlockMetadata(x, y, z) != worldIn.getBlockMetadata(
            x - Facing.offsetsXForSide[side],
            y - Facing.offsetsYForSide[side],
            z - Facing.offsetsZForSide[side])) {
            return true;
        }

        if (block == this) {
            return false;
        }

        return super.shouldSideBeRendered(worldIn, x, y, z, side);
    }
}
