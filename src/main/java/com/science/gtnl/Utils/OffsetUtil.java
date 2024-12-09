package com.science.gtnl.Utils;

import com.gtnewhorizon.structurelib.structure.IStructureElement;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OffsetUtil {

    /**
     * 包装结构元素，应用偏移量
     *
     * @param element 原始的结构元素
     * @param offsetX 偏移的 X 坐标
     * @param offsetY 偏移的 Y 坐标
     * @param offsetZ 偏移的 Z 坐标
     * @param <T>     结构的类型
     * @return 应用偏移量的结构元素
     */
    public static <T> IStructureElement<T> withOffset(IStructureElement<T> element, int offsetX, int offsetY, int offsetZ) {
        return new IStructureElement<T>() {

            @Override
            public boolean check(T t, World world, int x, int y, int z) {
                return element.check(t, world, x - offsetX, y - offsetY, z - offsetZ);
            }

            @Override
            public boolean spawnHint(T t, World world, int x, int y, int z, ItemStack trigger) {
                return element.spawnHint(t, world, x - offsetX, y - offsetY, z - offsetZ, trigger);
            }

            @Override
            public boolean placeBlock(T t, World world, int x, int y, int z, ItemStack trigger) {
                return element.placeBlock(t, world, x - offsetX, y - offsetY, z - offsetZ, trigger);
            }
        };
    }
}

