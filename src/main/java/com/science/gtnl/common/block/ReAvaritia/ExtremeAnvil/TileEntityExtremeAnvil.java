package com.science.gtnl.common.block.ReAvaritia.ExtremeAnvil;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.oredict.OreDictionary;

public class TileEntityExtremeAnvil extends TileEntity {

    private static final int CHECK_INTERVAL = 20;
    private int checkTimer = 0;
    private boolean isBeingRemoved = false;

    @Override
    public void updateEntity() {
        if (worldObj.isRemote) return;

        if (++checkTimer >= CHECK_INTERVAL) {
            checkTimer = 0;
            checkFoundation();
        }
    }

    private void checkFoundation() {
        if (isBeingRemoved) return;

        Block foundation = worldObj.getBlock(xCoord, yCoord - 1, zCoord);
        ItemStack stack = new ItemStack(foundation, 1, worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord));

        if (!hasOreTag(stack, "neutronUnbreak")) {
            isBeingRemoved = true;
            worldObj.func_147480_a(xCoord, yCoord, zCoord, true);
        }
    }

    @Override
    public void invalidate() {
        isBeingRemoved = true;
        super.invalidate();
    }

    // 必须实现的 NBT 方法
    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.checkTimer = tag.getInteger("CheckTimer");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("CheckTimer", this.checkTimer);
    }

    public static boolean hasOreTag(ItemStack stack, String tag) {
        if (stack == null || stack.getItem() == null) return false;
        int[] oreIDs = OreDictionary.getOreIDs(stack);
        for (int id : oreIDs) {
            if (OreDictionary.getOreName(id)
                .equalsIgnoreCase(tag)) {
                return true;
            }
        }
        return false;
    }
}
