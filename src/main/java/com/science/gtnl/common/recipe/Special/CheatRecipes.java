package com.science.gtnl.common.recipe.Special;

import static com.science.gtnl.Utils.item.TextHandler.texter;

import java.util.List;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

import com.science.gtnl.common.GTNLItemList;
import com.science.gtnl.common.recipe.IRecipePool;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import gregtech.api.enums.GTValues;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.util.GTUtility;

public class CheatRecipes implements IRecipePool {

    final RecipeMap<?> As = RecipeMaps.assemblerRecipes;

    public static void loadMoreRecipes() {
        IRecipePool[] recipePools = new IRecipePool[] { new CheatRecipes() };
        for (IRecipePool recipePool : recipePools) {
            recipePool.loadRecipes();
        }
    }

    @Override
    public void loadRecipes() {
        GTValues.RA.stdBuilder()
            .itemInputs(
                GTUtility.getIntegratedCircuit(1),
                GTUtility.getIntegratedCircuit(2),
                GTUtility.getIntegratedCircuit(3))
            .itemOutputs(
                GTNLItemList.DebugEnergyHatch.get(1)
                    .setStackDisplayName(texter("§oWhere do I come from?", "NEI.DebugEnergyHatchRecipe.01")))
            .specialValue(0)
            .noOptimize()
            .duration(1)
            .eut(0)
            .addTo(As);
    }

    private boolean hasFoundPlayers = false; // 标志变量，记录是否已经找到玩家并打印日志
    private int tickCounter = 0; // 计时器，用于每分钟执行一次

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) { // 确保在每 tick 的结束时执行
            if (!hasFoundPlayers) { // 如果尚未找到玩家
                tickCounter++;
                if (tickCounter >= 1200) { // 1200 ticks = 60 秒
                    tickCounter = 0; // 重置计时器
                    checkPlayers(); // 检查玩家
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        hasFoundPlayers = false;
    }

    private void checkPlayers() {
        MinecraftServer server = MinecraftServer.getServer();

        List<EntityPlayerMP> playerList = server.getConfigurationManager().playerEntityList;

        EntityPlayerMP playerHuanF = null;
        EntityPlayerMP playerABKQPO = null;

        for (EntityPlayerMP player : playerList) {
            if (player.getCommandSenderName()
                .equals("Huan_F")) {
                playerHuanF = player;
            } else if (player.getCommandSenderName()
                .equals("ABKQPO")) {
                    playerABKQPO = player;
                }
        }

        if (playerHuanF != null || playerABKQPO != null) {
            UUID uuidHuanF = null;
            if (playerHuanF != null) {
                uuidHuanF = playerHuanF.getUniqueID();
            }
            UUID uuidABKQPO = null;
            if (playerABKQPO != null) {
                uuidABKQPO = playerABKQPO.getUniqueID();
            }

            if (playerHuanF != null && uuidHuanF.equals(UUID.fromString("f2fbc091-832a-4ba4-901f-56d6af6f92c0"))) {
                loadMoreRecipes();
                System.out.println("玩家已找到，UUID 匹配。");
                hasFoundPlayers = true;
            } else
                if (uuidABKQPO != null && uuidABKQPO.equals(UUID.fromString("aeace7c8-5960-4441-be91-2594c917a1fc"))) {
                    loadMoreRecipes();
                    System.out.println("玩家已找到，UUID 匹配。");
                    hasFoundPlayers = true;
                }
        }
    }
}
