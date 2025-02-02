package com.science.gtnl.common.block.ReAvaritia.ExtremeAnvil;

import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ExtremeAnvilGUI extends GuiContainer {

    private static final ResourceLocation ANVIL_TEXTURE = new ResourceLocation(
        "reavaritia:textures/gui/extreme_anvil.png");
    private final InventoryPlayer playerInventory;
    private final World world;
    private final int x, y, z;
    private GuiTextField nameField;
    private ContainerExtremeAnvil containerAnvil;
    private String lastRepairedName = "";

    public ExtremeAnvilGUI(InventoryPlayer playerInv, World world, int x, int y, int z) {
        super(new ContainerExtremeAnvil(playerInv, world, x, y, z, playerInv.player));
        this.playerInventory = playerInv;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.containerAnvil = (ContainerExtremeAnvil) this.inventorySlots;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.nameField = new GuiTextField(this.fontRendererObj, this.guiLeft + 62, this.guiTop + 24, 103, 12);
        this.nameField.setMaxStringLength(256);
        this.nameField.setEnableBackgroundDrawing(false);
        this.nameField.setTextColor(0xFFFFFF);
        this.nameField.setDisabledTextColour(0xFFFFFF);

        // 初始化名称字段
        ItemStack inputStack = containerAnvil.inputSlots.getStackInSlot(0);
        if (inputStack != null && inputStack.hasDisplayName()) {
            this.nameField.setText(inputStack.getDisplayName());
        } else {
            this.nameField.setText(containerAnvil.getRepairedItemName());
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        // 同步容器名称状态
        if (!lastRepairedName.equals(containerAnvil.getRepairedItemName())) {
            lastRepairedName = containerAnvil.getRepairedItemName();
            nameField.setText(lastRepairedName);
        }
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) {
        // 处理特殊按键
        if (keyCode == Keyboard.KEY_ESCAPE) {
            this.mc.thePlayer.closeScreen();
            return;
        }

        // 名称字段处理
        if (this.nameField.textboxKeyTyped(typedChar, keyCode)) {
            this.updateRepairedName();
        } else {
            super.keyTyped(typedChar, keyCode);
        }
    }

    private void updateRepairedName() {
        String newName = this.nameField.getText();
        this.containerAnvil.updateItemName(newName.trim());
        this.lastRepairedName = newName;
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        this.nameField.mouseClicked(mouseX, mouseY, mouseButton);

        // 使用自定义的点击检测方法
        if (this.isPointInRegion(134, 47, 16, 16, mouseX, mouseY)) {
            ItemStack output = containerAnvil.outputSlot.getStackInSlot(0);
            if (output != null && output.hasDisplayName()) {
                this.nameField.setText(output.getDisplayName());
                this.updateRepairedName();
            }
        }

        // 点击输入框外区域取消焦点
        if (!this.isPointInRegion(59, 23, 110, 16, mouseX, mouseY)) {
            this.nameField.setFocused(false);
        }
    }

    private boolean isPointInRegion(int x, int y, int width, int height, int mouseX, int mouseY) {
        int guiLeft = (this.width - this.xSize) / 2;
        int guiTop = (this.height - this.ySize) / 2;
        mouseX -= guiLeft;
        mouseY -= guiTop;
        return mouseX >= x - 1 && mouseX < x + width + 1 && mouseY >= y - 1 && mouseY < y + height + 1;
    }

    private String getLocalizedName() {
        return StatCollector.translateToLocal("container.ExtremeAnvil");
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        // 绘制标题
        String title = this.getLocalizedName();
        this.fontRendererObj
            .drawString(title, (this.xSize - this.fontRendererObj.getStringWidth(title)) / 2, 6, 0x404040);

        // 绘制背包标签
        this.fontRendererObj
            .drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 3, 0x404040);

        // 动态更新名称字段
        ItemStack input = containerAnvil.inputSlots.getStackInSlot(0);
        if (input != null && !nameField.isFocused()) {
            String defaultName = input.hasDisplayName() ? input.getDisplayName() : "";
            if (!defaultName.equals(nameField.getText())) {
                nameField.setText(defaultName);
            }
        }

        // 绘制名称输入框
        this.nameField.drawTextBox();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager()
            .bindTexture(ANVIL_TEXTURE);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        // 绘制输入框背景
        int textFieldState = this.nameField.isFocused() ? 1 : 0;
        this.drawTexturedModalRect(x + 59, y + 23, 0, this.ySize + textFieldState * 16, 110, 16);

        // 绘制错误图标（当无法合成时）
        ItemStack input1 = containerAnvil.inputSlots.getStackInSlot(0);
        ItemStack input2 = containerAnvil.inputSlots.getStackInSlot(1);
        ItemStack output = containerAnvil.outputSlot.getStackInSlot(0);

        boolean showError = (input1 != null && input2 == null
            && nameField.getText()
                .isEmpty())
            || (input1 != null && input2 != null && output == null);

        if (showError) {
            this.drawTexturedModalRect(x + 98, y + 45, this.xSize, 0, 28, 21);
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
    }
}
