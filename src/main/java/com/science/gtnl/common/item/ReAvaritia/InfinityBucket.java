package com.science.gtnl.common.item.ReAvaritia;

import java.lang.reflect.Method;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fluids.IFluidHandler;

import com.science.gtnl.Utils.item.TextLocalization;
import com.science.gtnl.client.CreativeTabsLoader;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class InfinityBucket extends Item {

    protected boolean Stop = false;
    private static final int BASE_MAX_TYPES = 128;
    private static final int MAX_FLUID_AMOUNT = Integer.MAX_VALUE;
    private static final int INFINITE_FLUID_AMOUNT = -1;
    private long lastUpdateTime = 0; // 用于记录上次更新的时间

    public InfinityBucket() {
        setMaxStackSize(1);
        setUnlocalizedName("InfinityBucket");
        setTextureName("reavaritia:InfinityBucket");
        setCreativeTab(CreativeTabs.tabTools);
        setCreativeTab(CreativeTabsLoader.ReAvaritia);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (player.isSneaking()) {
            cycleSelectedFluid(stack);
            return stack;
        }

        MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, true);
        if (mop != null && mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            Stop = false;
            int x = mop.blockX, y = mop.blockY, z = mop.blockZ;
            boolean collected = tryCollectFluid(stack, world, x, y, z, player);
            if (!collected && !Stop) {
                tryPlaceFluid(stack, world, x, y, z, mop.sideHit, player);
            }
        }
        return stack;
    }

    private boolean tryCollectFluid(ItemStack stack, World world, int x, int y, int z, EntityPlayer player) {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof IFluidHandler) {
            IFluidHandler tank = (IFluidHandler) te;
            return handleTankWithdraw(stack, tank, world, x, y, z);
        }

        Block block = world.getBlock(x, y, z);
        Fluid fluid = FluidRegistry.lookupFluidForBlock(block);
        NBTTagCompound nbt = stack.getTagCompound();

        if (fluid != null && nbt != null) {
            NBTTagList fluids = nbt.getTagList("Fluids", 10);
            int maxTypes = BASE_MAX_TYPES + fluids.tagCount();

            int existingIndex = -1;
            for (int i = 0; i < fluids.tagCount(); i++) {
                if (fluids.getCompoundTagAt(i)
                    .getString("FluidName")
                    .equals(fluid.getName())) {
                    existingIndex = i;
                    break;
                }
            }

            if (existingIndex == -1 && fluids.tagCount() >= maxTypes) {
                player.addChatMessage(new ChatComponentText("已达到最大流体类型限制!"));
                return false;
            }

            NBTTagList newFluids = new NBTTagList();
            boolean isNewFluid = existingIndex == -1;

            if (isNewFluid) {
                NBTTagCompound newTag = new NBTTagCompound();
                newTag.setString("FluidName", fluid.getName());
                newTag.setInteger("Amount", 1000);
                newFluids.appendTag(newTag);
            } else {
                NBTTagCompound existingTag = (NBTTagCompound) fluids.getCompoundTagAt(existingIndex)
                    .copy();
                int currentAmount = existingTag.getInteger("Amount");

                if ((long) currentAmount + 1000 > MAX_FLUID_AMOUNT) {
                    Stop = true;
                    return false;
                }

                int addAmountMax = MAX_FLUID_AMOUNT - currentAmount;
                int addAmount = Math.min(1000, addAmountMax);
                existingTag.setInteger("Amount", currentAmount + addAmount);
                newFluids.appendTag(existingTag);

                if (addAmount < 1000) {
                    FluidStack remaining = new FluidStack(fluid, 1000 - addAmount);
                    Block fluidBlock = fluid.getBlock();
                    if (fluidBlock != null) {
                        world.setBlock(x, y, z, fluidBlock);
                        TileEntity tileEntity = world.getTileEntity(x, y, z);
                        if (tileEntity instanceof IFluidHandler) {
                            IFluidHandler handler = (IFluidHandler) tileEntity;
                            handler.fill(ForgeDirection.UNKNOWN, remaining, true);
                        }
                    }
                }
            }

            for (int i = 0; i < fluids.tagCount(); i++) {
                if (i != existingIndex) {
                    newFluids.appendTag(
                        fluids.getCompoundTagAt(i)
                            .copy());
                }
            }

            if (isNewFluid) {
                world.setBlockToAir(x, y, z);
            }
            nbt.setTag("Fluids", newFluids);
            nbt.setInteger("Selected", 0);
            return true;
        }
        return false;
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
        float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntity te = world.getTileEntity(x, y, z);
            if (te instanceof IFluidHandler) {
                IFluidHandler tank = (IFluidHandler) te;

                if (player.isSneaking()) {
                    return handleTankDeposit(stack, tank);
                } else {
                    return handleTankWithdraw(stack, tank, world, x, y, z);
                }
            }
        }
        return false;
    }

    private int getMaxTypes(int currentTypes) {
        return BASE_MAX_TYPES + currentTypes;
    }

    private boolean handleTankDeposit(ItemStack stack, IFluidHandler tank) {
        NBTTagList fluids = getFluidList(stack);
        if (fluids.tagCount() == 0) return false;

        NBTTagCompound fluidTag = fluids.getCompoundTagAt(0);
        String fluidName = fluidTag.getString("FluidName");
        int storedAmount = fluidTag.getInteger("Amount");

        FluidStack fs = new FluidStack(
            FluidRegistry.getFluid(fluidName),
            storedAmount == INFINITE_FLUID_AMOUNT ? 1000 : Math.min(storedAmount, 1000));

        int transferred = tank.fill(ForgeDirection.UNKNOWN, fs, true);
        if (transferred > 0) {
            if (storedAmount != INFINITE_FLUID_AMOUNT) {
                int newStoredAmount = storedAmount - transferred;
                if (newStoredAmount < 0) {
                    int excessAmount = transferred - storedAmount;
                    fluidTag.setInteger("Amount", MAX_FLUID_AMOUNT);
                    tank.drain(ForgeDirection.UNKNOWN, excessAmount, true);
                } else {
                    fluidTag.setInteger("Amount", newStoredAmount);
                    if (fluidTag.getInteger("Amount") == 0) {
                        fluids.removeTag(0);
                        if (fluids.tagCount() == 0) {
                            clearFluids(stack);
                        }
                    }
                }
            }
            ensureNonEmptyFluids(fluids);
            showFluidInfo(fluidName, fluidTag.getInteger("Amount"));
            return true;
        }
        return false;
    }

    private boolean handleTankWithdraw(ItemStack stack, IFluidHandler tank, World world, int x, int y, int z) {
        FluidStack tankFluid = tank.drain(ForgeDirection.UNKNOWN, 1000, true);
        if (tankFluid == null) return false;

        NBTTagList fluids = getFluidList(stack);
        int maxTypes = getMaxTypes(fluids.tagCount());

        boolean exists = fluids.tagCount() > 0 && fluids.getCompoundTagAt(0)
            .getString("FluidName")
            .equals(
                tankFluid.getFluid()
                    .getName());

        if (!exists) {
            if (fluids.tagCount() >= maxTypes) return false;
            addNewFluidType(stack, tankFluid.getFluid(), tankFluid.amount);
            return true;
        }

        return mergeFluid(stack, tankFluid.getFluid(), tankFluid.amount, tank, x, y, z);
    }

    private void addNewFluidType(ItemStack stack, Fluid fluid, int amount) {
        NBTTagCompound nbt = stack.getTagCompound();
        NBTTagList fluids = nbt.getTagList("Fluids", 10);

        NBTTagCompound newTag = new NBTTagCompound();
        newTag.setString("FluidName", fluid.getName());
        newTag.setInteger("Amount", Math.min(amount, Integer.MAX_VALUE));
        fluids.appendTag(newTag);

        nbt.setInteger("Selected", fluids.tagCount() - 1);
        ensureNonEmptyFluids(fluids);
    }

    private boolean mergeFluid(ItemStack stack, Fluid fluid, int amount, IFluidHandler tank, int x, int y, int z) {
        NBTTagList fluids = getFluidList(stack);
        for (int i = 0; i < fluids.tagCount(); i++) {
            NBTTagCompound tag = fluids.getCompoundTagAt(i);
            if (tag.getString("FluidName")
                .equals(fluid.getName())) {
                int current = tag.getInteger("Amount");
                if (current != INFINITE_FLUID_AMOUNT) {
                    if ((long) current + amount > MAX_FLUID_AMOUNT) {
                        int addAmount = MAX_FLUID_AMOUNT - current;
                        tag.setInteger("Amount", MAX_FLUID_AMOUNT);
                        int excessAmount = amount - addAmount;
                        FluidStack remaining = new FluidStack(fluid, excessAmount);
                        if (tank != null) {
                            tank.fill(ForgeDirection.UNKNOWN, remaining, true);
                        }
                        return false;
                    } else {
                        tag.setInteger("Amount", current + amount);
                    }
                    ensureNonEmptyFluids(fluids);
                    return true;
                }
            }
        }
        return false;
    }

    private void tryPlaceFluid(ItemStack stack, World world, int x, int y, int z, int side, EntityPlayer player) {
        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt == null) return;

        NBTTagList fluids = nbt.getTagList("Fluids", 10);
        int selected = nbt.getInteger("Selected");
        if (fluids.tagCount() == 0 || selected >= fluids.tagCount()) return;

        NBTTagCompound fluidTag = fluids.getCompoundTagAt(selected);
        String fluidName = fluidTag.getString("FluidName");
        int amount = fluidTag.getInteger("Amount");
        Fluid fluid = FluidRegistry.getFluid(fluidName);
        if (fluid == null) return;

        if (amount < 1000 && amount != INFINITE_FLUID_AMOUNT) {
            return;
        }

        ForgeDirection dir = ForgeDirection.getOrientation(side);
        int placeX = x + dir.offsetX;
        int placeY = y + dir.offsetY;
        int placeZ = z + dir.offsetZ;

        Block targetBlock = world.getBlock(placeX, placeY, placeZ);
        Fluid targetFluid = FluidRegistry.lookupFluidForBlock(targetBlock);
        boolean isFlowing = false;

        if (targetBlock.getMaterial()
            .isLiquid()) {
            try {
                Method isSource = targetBlock.getClass()
                    .getMethod("isSourceBlock", World.class, int.class, int.class, int.class);
                isFlowing = !(Boolean) isSource.invoke(targetBlock, world, placeX, placeY, placeZ);
            } catch (Exception e) {
                isFlowing = world.getBlockMetadata(placeX, placeY, placeZ) != 0;
            }
        }

        boolean canReplace = targetBlock.isAir(world, placeX, placeY, placeZ)
            || (targetFluid != null && !isSourceBlock(targetBlock, world, placeX, placeY, placeZ) && isFlowing);
        if (canReplace) {
            Block fluidBlock = fluid.getBlock();
            if (fluidBlock != null && fluidBlock.canPlaceBlockAt(world, placeX, placeY, placeZ)) {
                world.setBlock(placeX, placeY, placeZ, fluidBlock, 0, 3);

                if (amount != INFINITE_FLUID_AMOUNT) {
                    int newAmount = amount - 1000;
                    if (newAmount < 0) {
                        newAmount = 0;
                    }
                    fluidTag.setInteger("Amount", newAmount);
                    if (newAmount == 0) {
                        fluids.removeTag(selected);
                        if (fluids.tagCount() == 0) {
                            nbt.setTag("Fluids", new NBTTagList());
                            nbt.setInteger("Selected", 0);
                            stack.setTagCompound(nbt);
                            clearFluids(stack);
                        } else {
                            int newSelected = Math.max(0, selected - 1);
                            nbt.setInteger("Selected", newSelected);
                        }
                    }
                    stack.setTagCompound(nbt);
                }
                ensureNonEmptyFluids(fluids);
                showFluidInfo(fluidName, amount - 1000);
            }
        }
    }

    private boolean isSourceBlock(Block block, World world, int x, int y, int z) {
        try {
            if (block instanceof IFluidBlock) {
                return ((IFluidBlock) block).canDrain(world, x, y, z);
            }
            return world.getBlockMetadata(x, y, z) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    private void clearFluids(ItemStack stack) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("Fluids", new NBTTagList());
        nbt.setInteger("Selected", 0);
        stack.setTagCompound(nbt);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List toolTip, boolean advanced) {
        toolTip.add(TextLocalization.Tooltip_InfinityBucket_00);

        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt != null) {
            NBTTagList fluids = nbt.getTagList("Fluids", 10);
            if (fluids.tagCount() > 0) {
                NBTTagCompound fluidTag = fluids.getCompoundTagAt(0);
                String fluidName = fluidTag.getString("FluidName");
                int remainingAmount = fluidTag.getInteger("Amount");

                showFluidInfo(fluidName, remainingAmount);
            }
        }

        if (nbt == null) return;

        NBTTagList fluids = nbt.getTagList("Fluids", 10);

        if (fluids.tagCount() > 0) {
            NBTTagCompound first = fluids.getCompoundTagAt(0);
            addFluidToTooltip(first, toolTip, true);
        }

        for (int i = 1; i < fluids.tagCount(); i++) {
            addFluidToTooltip(fluids.getCompoundTagAt(i), toolTip, false);
        }
    }

    private void addFluidToTooltip(NBTTagCompound tag, List<String> tooltip, boolean isSelected) {
        String fluidName = tag.getString("FluidName");
        int amount = tag.getInteger("Amount");
        Fluid fluid = FluidRegistry.getFluid(fluidName);

        String displayName = (fluid != null) ? fluid.getLocalizedName() : fluidName;
        String amountText = (amount == INFINITE_FLUID_AMOUNT) ? "∞" : amount + "L";
        String prefix = isSelected ? "§a▶ " : "  ";

        tooltip.add(prefix + displayName + " §7: " + amountText);
    }

    @SideOnly(Side.CLIENT)
    private void showFluidInfo(String displayName, int remainingAmount) {
        String message = String.format(
            TextLocalization.Tooltip_InfinityBucket_01,
            displayName,
            remainingAmount == INFINITE_FLUID_AMOUNT ? "∞" : remainingAmount + "L");
        ChatComponentText text = new ChatComponentText(EnumChatFormatting.WHITE + message);

        Minecraft.getMinecraft().ingameGUI.func_110326_a(text.getFormattedText(), true);
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) {
            EntityPlayer player = event.entityPlayer;
            ItemStack stack = player.getHeldItem();

            if (stack != null && stack.getItem() == this && player.isSneaking()) {

                clearFluids(stack);
                player.addChatMessage(new ChatComponentText(TextLocalization.Tooltip_InfinityBucket_02));
                event.setCanceled(true);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.entity instanceof EntityPlayer) {
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayer player = mc.thePlayer;
            if (player.getHeldItem() != null && player.getHeldItem()
                .getItem() == this) {
                ItemStack heldItem = player.getHeldItem();
                if (heldItem != null && heldItem.getItem() instanceof InfinityBucket) {
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastUpdateTime >= 500) {
                        NBTTagCompound nbt = heldItem.getTagCompound();
                        if (nbt != null) {
                            NBTTagList fluids = nbt.getTagList("Fluids", 10);
                            if (fluids.tagCount() > 0) {
                                NBTTagCompound fluidTag = fluids.getCompoundTagAt(0);
                                String fluidName = fluidTag.getString("FluidName");
                                int remainingAmount = fluidTag.getInteger("Amount");

                                showFluidInfo(fluidName, remainingAmount);
                            }
                        }
                        lastUpdateTime = currentTime;
                    }
                }
            }
        }
    }

    private void cycleSelectedFluid(ItemStack stack) {
        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt == null) {
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }

        NBTTagList fluids = nbt.getTagList("Fluids", 10);
        int fluidCount = fluids.tagCount();
        if (fluidCount == 0) return;

        NBTTagList newFluids = new NBTTagList();
        int currentIndex = nbt.getInteger("Selected");

        for (int i = currentIndex + 1; i < fluidCount; i++) {
            newFluids.appendTag(fluids.getCompoundTagAt(i));
        }

        for (int i = 0; i <= currentIndex; i++) {
            newFluids.appendTag(fluids.getCompoundTagAt(i));
        }

        nbt.setTag("Fluids", newFluids);
        nbt.setInteger("Selected", 0);
    }

    private NBTTagList getFluidList(ItemStack stack) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound()
                .setTag("Fluids", new NBTTagList());
        }
        return stack.getTagCompound()
            .getTagList("Fluids", 10);
    }

    private void ensureNonEmptyFluids(NBTTagList fluids) {
        if (fluids.tagCount() == 0) {
            fluids.appendTag(new NBTTagCompound());
        }
    }
}
