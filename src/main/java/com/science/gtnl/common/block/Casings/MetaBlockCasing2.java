package com.science.gtnl.common.block.Casings;

import static com.science.gtnl.ScienceNotLeisure.RESOURCE_ROOT_ID;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.science.gtnl.client.CreativeTabsLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MetaBlockCasing2 extends Block {

    public String[] TextureName;
    public IIcon[] Texture;

    public MetaBlockCasing2(String UnlocalizedName, String TextureName) {
        super(Material.iron);
        this.setHardness(1.0F);
        this.setResistance(6000000.0F);
        this.setBlockName(UnlocalizedName);
        this.setBlockTextureName(RESOURCE_ROOT_ID + ":" + "MetaBlockCasing2/" + TextureName);
        this.TextureName = new String[] { "Side", "Top", "Bottom" };
        this.setCreativeTab(CreativeTabsLoader.GTNotLeisure);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return side == 1 ? this.Texture[1] // 顶部纹理
            : (side == 0 ? this.Texture[2] // 底部纹理
                : this.Texture[0]); // 侧面纹理
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack) {
        int l = MathHelper.floor_double((placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg) {
        this.Texture = new IIcon[TextureName.length];
        for (int i = 0; i < this.Texture.length; ++i) {
            this.Texture[i] = reg.registerIcon(this.getTextureName() + "_" + TextureName[i]);
        }
    }
}
