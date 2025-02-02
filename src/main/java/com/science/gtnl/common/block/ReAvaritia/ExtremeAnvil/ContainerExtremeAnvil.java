package com.science.gtnl.common.block.ReAvaritia.ExtremeAnvil;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class ContainerExtremeAnvil extends Container {

    public final IInventory inputSlots = new InventoryBasic("Repair", true, 2) {

        @Override
        public void markDirty() {
            super.markDirty();
            ContainerExtremeAnvil.this.onCraftMatrixChanged(this);
        }
    };

    public final IInventory outputSlot = new InventoryCraftResult();
    private final World world;
    private final int x, y, z;
    private final EntityPlayer player;
    private String repairedItemName = "";

    public ContainerExtremeAnvil(InventoryPlayer playerInventory, World world, int x, int y, int z,
        EntityPlayer player) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.player = player;

        // 输入槽
        this.addSlotToContainer(new Slot(this.inputSlots, 0, 27, 47) {

            @Override
            public boolean isItemValid(ItemStack stack) {
                return true;
            }
        });
        this.addSlotToContainer(new Slot(this.inputSlots, 1, 76, 47) {

            @Override
            public boolean isItemValid(ItemStack stack) {
                return true;
            }
        });

        // 输出槽
        this.addSlotToContainer(new Slot(this.outputSlot, 2, 134, 47) {

            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }

            @Override
            public boolean canTakeStack(EntityPlayer player) {
                return true;
            }

            @Override
            public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
                onTakeOutput(player, stack);
            }
        });

        // 玩家背包
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // 玩家快捷栏
        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    // 新增：名称更新方法供GUI调用
    public void updateItemName(String newName) {
        this.repairedItemName = newName != null ? newName : "";
        this.updateRepairOutput();
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        Block block = world.getBlock(x, y, z);
        double distance = player.getDistanceSq(x + 0.5D, y + 0.5D, z + 0.5D);
        return block instanceof BlockExtremeAnvil && distance <= 64.0D;
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventory) {
        // 自动读取输入物品名称
        ItemStack inputStack = inputSlots.getStackInSlot(0);
        if (inventory == inputSlots && inputStack != null) {
            if (inputStack.hasDisplayName()) {
                this.repairedItemName = inputStack.getDisplayName();
            } else {
                this.repairedItemName = "";
            }
        }
        this.updateRepairOutput();
    }

    public void updateRepairOutput() {
        ItemStack input = inputSlots.getStackInSlot(0);
        ItemStack material = inputSlots.getStackInSlot(1);
        ItemStack output = input != null ? input.copy() : null;

        if (output != null) {
            // 处理物品名称
            if (!this.repairedItemName.isEmpty()) {
                output.setStackDisplayName(this.repairedItemName);
            } else if (input.hasDisplayName()) {
                output.func_135074_t(); // 1.7.10清除名称的方法
            }

            // 处理附魔合并
            if (material != null) {
                Map<Integer, Integer> enchantments = new HashMap<>();
                this.mergeEnchantments(enchantments, input);
                this.mergeEnchantments(enchantments, material);

                NBTTagList enchList = new NBTTagList();
                for (Map.Entry<Integer, Integer> entry : enchantments.entrySet()) {
                    NBTTagCompound tag = new NBTTagCompound();
                    tag.setShort(
                        "id",
                        (short) entry.getKey()
                            .intValue());
                    tag.setShort(
                        "lvl",
                        (short) entry.getValue()
                            .intValue());
                    enchList.appendTag(tag);
                }

                if (enchList.tagCount() > 0) {
                    if (!output.hasTagCompound()) {
                        output.setTagCompound(new NBTTagCompound());
                    }
                    output.getTagCompound()
                        .setTag("ench", enchList);
                }
            }
        }

        outputSlot.setInventorySlotContents(0, output);
        detectAndSendChanges();
    }

    private void mergeEnchantments(Map<Integer, Integer> map, ItemStack stack) {
        if (stack == null || !stack.isItemEnchanted()) return;

        NBTTagList list = stack.getEnchantmentTagList();
        for (int i = 0; i < list.tagCount(); ++i) {
            NBTTagCompound tag = list.getCompoundTagAt(i);
            int id = tag.getShort("id");
            int lvl = tag.getShort("lvl");

            Enchantment ench = Enchantment.enchantmentsList[id];
            if (ench != null) {
                int max = ench.getMaxLevel();
                map.put(id, Math.min(map.getOrDefault(id, 0) + lvl, max));
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (index >= 3 && index < 39) {
                if (!this.mergeItemStack(itemstack1, 0, 2, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }

    public void onTakeOutput(EntityPlayer player, ItemStack stack) {
        // 重置名称状态
        this.repairedItemName = "";
        inputSlots.setInventorySlotContents(0, null);
        inputSlots.decrStackSize(1, 1);
        updateRepairOutput();
    }

    public String getRepairedItemName() {
        return this.repairedItemName;
    }

    // 新增：设置名称（用于服务端同步）
    public void setRepairedItemName(String name) {
        this.repairedItemName = name != null ? name : "";
        this.updateRepairOutput();
    }
}
