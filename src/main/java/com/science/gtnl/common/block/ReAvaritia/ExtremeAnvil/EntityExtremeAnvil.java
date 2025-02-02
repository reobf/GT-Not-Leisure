package com.science.gtnl.common.block.ReAvaritia.ExtremeAnvil;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityExtremeAnvil extends EntityFallingBlock {

    private boolean shouldBeRemoved = false;

    public EntityExtremeAnvil(World world, double x, double y, double z, Block block, int metadata) {
        super(world, x, y, z, block, metadata);
        this.field_145814_a = metadata;
        this.setPosition(x, y, z);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!this.worldObj.isRemote && this.onGround) {
            this.worldObj.setBlock(
                (int) Math.floor(this.posX),
                (int) Math.floor(this.posY),
                (int) Math.floor(this.posZ),
                this.func_145805_f(),
                this.getBlockMetadata(),
                3);
            AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(
                this.posX - 0.5,
                this.posY - 0.5,
                this.posZ - 0.5,
                this.posX + 0.5,
                this.posY + 0.5,
                this.posZ + 0.5);

            List<EntityLivingBase> entities = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, aabb);

            for (EntityLivingBase entity : entities) {

                entity.attackEntityFrom(DamageSource.anvil, Integer.MAX_VALUE);
                entity.setHealth(0.0F);
                entity.onDeath(DamageSource.anvil);
                entity.setDead();
            }
            this.shouldBeRemoved = true;
        }
        if (this.shouldBeRemoved) {
            this.setDead();
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
    }

    public int getBlockMetadata() {
        return this.field_145814_a;
    }
}
