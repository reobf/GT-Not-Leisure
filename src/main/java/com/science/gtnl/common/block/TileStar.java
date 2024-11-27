package com.science.gtnl.common.block;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileStar extends TileEntity {

    public double Rotation = 0;
    public double size = 12;

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return INFINITE_EXTENT_AABB;
    }

    @Override
    public double getMaxRenderDistanceSquared() {
        return 65536;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setDouble("renderStatus", size);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        size = nbt.getDouble("size");
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        Rotation = (Rotation + 0.1) % 360d;
    }
}
