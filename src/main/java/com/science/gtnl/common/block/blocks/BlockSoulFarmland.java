package com.science.gtnl.common.block.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.science.gtnl.client.CreativeTabsLoader;

public class BlockSoulFarmland extends BlockFarmland {

    private IIcon topIcon;
    private IIcon sideIcon;

    public BlockSoulFarmland() {
        super();
        this.setBlockName("BlockSoulFarmland");
        this.setCreativeTab(CreativeTabsLoader.GTNotLeisure);
        this.setHardness(0.6F);
        this.setStepSound(soundTypeSand);
        this.setBlockTextureName("sciencenotleisure:BlockSoulFarmland");
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        this.topIcon = reg.registerIcon("sciencenotleisure:BlockSoulFarmland_Top");
        this.sideIcon = reg.registerIcon("sciencenotleisure:BlockSoulFarmland_Side");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return side == 1 ? topIcon : sideIcon;
    }

    @Override
    public void onFallenUpon(World world, int x, int y, int z, Entity entity, float fallDistance) {}

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        world.scheduleBlockUpdate(x, y, z, this, 200);

        Block aboveBlock = world.getBlock(x, y + 1, z);
        if (aboveBlock instanceof IGrowable && aboveBlock != Blocks.cactus && aboveBlock != Blocks.reeds) {
            IGrowable growable = (IGrowable) aboveBlock;
            if (growable.func_149851_a(world, x, y + 1, z, world.isRemote)) {
                growable.func_149853_b(world, rand, x, y + 1, z);
            }
        } else if (aboveBlock == Blocks.cactus || aboveBlock == Blocks.reeds) {
            growTallCrop(world, x, y + 1, z, aboveBlock);
        } else if (aboveBlock == Blocks.nether_wart) {
            growNetherWart(world, x, y + 1, z, rand);
        }
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
        IPlantable plantable) {
        return true;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return Blocks.soul_sand.getItemDropped(0, random, fortune);
    }

    @Override
    public void onNeighborBlockChange(World worldIn, int x, int y, int z, Block neighbor) {}

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {}

    private void growTallCrop(World world, int x, int y, int z, Block crop) {
        int height = 1;
        while (world.getBlock(x, y + height, z) == crop) {
            height++;
        }
        if (height < 3) {
            world.setBlock(x, y + height, z, crop);
        }
    }

    private void growNetherWart(World world, int x, int y, int z, Random rand) {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta < 3) {
            world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
        }
    }
}
