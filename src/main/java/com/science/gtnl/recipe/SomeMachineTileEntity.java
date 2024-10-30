package com.science.gtnl.recipe;

import net.minecraft.tileentity.TileEntity;

public class SomeMachineTileEntity extends TileEntity {

    private boolean cleanRoom;
    private boolean sterileCleaning;

    public SomeMachineTileEntity() {
        this.cleanRoom = false; // 初始值，可以根据实际逻辑设置
        this.sterileCleaning = false; // 初始值，可以根据实际逻辑设置
    }

    // 检查是否有洁净室环境
    public boolean hasCleanRoom() {
        // 这里是实际的检查逻辑
        return this.cleanRoom;
    }

    // 检查是否有无菌清洁环境
    public boolean hasSterileCleaning() {
        // 这里是实际的检查逻辑
        return this.sterileCleaning;
    }

    // 示例方法来设置环境（可根据实际需求修改）
    public void setCleanRoom(boolean value) {
        this.cleanRoom = value;
    }

    public void setSterileCleaning(boolean value) {
        this.sterileCleaning = value;
    }
}
