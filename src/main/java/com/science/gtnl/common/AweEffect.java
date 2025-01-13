package com.science.gtnl.common;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;

import com.science.gtnl.Utils.TextLocalization;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AweEffect extends Potion {

    public static final AweEffect instance = new AweEffect();

    public static final DamageSource awe_damage = new DamageSource("damage.gtnl.AweDamage").setExplosion()
        .setDamageBypassesArmor()
        .setDamageIsAbsolute()
        .setDamageAllowedInCreativeMode()
        .setMagicDamage();

    private static final ResourceLocation potionIcons = new ResourceLocation(
        "sciencenotleisure",
        "textures/gui/potions.png");
    private static final Set<EntityPlayer> affectedPlayers = new HashSet<>();
    private static final Random random = new Random();

    public AweEffect() {
        super(186, true, 0xFF00FF);
        setPotionName("effect.awe_effect");
        setIconIndex(0, 0);
        MinecraftForge.EVENT_BUS.register(this); // 注册事件处理程序
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
        mc.getTextureManager()
            .bindTexture(potionIcons);
        mc.currentScreen.drawTexturedModalRect(
            x + 6,
            y + 7,
            getStatusIconIndex() % 8 * 144,
            198 + getStatusIconIndex() / 8 * 144,
            18,
            18);
    }

    @SubscribeEvent
    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.entity instanceof EntityPlayer player) {
            PotionEffect effect = player.getActivePotionEffect(this);

            if (effect != null) {
                int level = effect.getAmplifier();
                double pullSpeed = level * 0.02;

                if (!affectedPlayers.contains(player)) {
                    float damage = 50.0F + random.nextFloat() * 10.0F;
                    player.attackEntityFrom(awe_damage, damage);
                    affectedPlayers.add(player);

                    player.worldObj.playSoundAtEntity(player, "sciencenotleisure:awe.warning2", 1.0F, 1.0F);
                }

                player.capabilities.isFlying = false;
                player.capabilities.allowFlying = false;

                player.motionY = -pullSpeed;
                player.setSneaking(true);

                if (player.rotationPitch < 45) {
                    player.rotationPitch += (float) (0.2 * level);
                }
                if (player.rotationPitch > 45) {
                    player.rotationPitch -= (float) (0.2 * level);
                }

            } else {

                affectedPlayers.remove(player);
                if (player.capabilities.isCreativeMode && !player.capabilities.allowFlying) {
                    player.capabilities.allowFlying = true;
                    player.sendPlayerAbilities();
                }
            }
        }
    }

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.thePlayer;

        if (player != null) {
            PotionEffect effect = player.getActivePotionEffect(this);

            if (effect != null && event.gui instanceof GuiIngameMenu) {
                event.setCanceled(true);

                if (!player.capabilities.isCreativeMode) {
                    IChatComponent chatComponent = new ChatComponentText(TextLocalization.Awe_Cancel_01);
                    player.addChatMessage(chatComponent);
                }
            }
        }
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entityLiving, BaseAttributeMap attributeMap,
        int amplifier) {
        super.removeAttributesModifiersFromEntity(entityLiving, attributeMap, amplifier);

        if (entityLiving instanceof EntityPlayerMP player) {
            if (!player.capabilities.isCreativeMode) {
                player.playerNetServerHandler.kickPlayerFromServer(TextLocalization.Awe_Kick);
            } else {
                if (!player.capabilities.allowFlying) {
                    player.capabilities.allowFlying = true;
                    player.sendPlayerAbilities();
                }
            }
        }
    }
}
