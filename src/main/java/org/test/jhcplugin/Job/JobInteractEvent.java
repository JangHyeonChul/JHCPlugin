package org.test.jhcplugin.Job;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.test.jhcplugin.ErrorMessage;
import org.test.jhcplugin.JHCPlugin;
import org.test.jhcplugin.Valid.Validator;

public class JobInteractEvent implements Listener {

    private Plugin plugin = JHCPlugin.getPlugin(JHCPlugin.class);
    private Validator validator = new Validator();

    @EventHandler
    public void jobPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        try {
        ItemStack itemInHand = player.getItemInHand(); // 손에 아무것도 안들경우 예외처리
        ItemMeta meta = itemInHand.getItemMeta();

        Component component = itemInHand.getItemMeta().displayName();
        String serialize = LegacyComponentSerializer.legacySection().serialize(component);

            if (action == Action.RIGHT_CLICK_AIR
                    && itemInHand.getType() == Material.PAPER
                    && meta.getDisplayName().contains(ChatColor.GREEN.toString())) {
                jobPaperActiveHandler(player, serialize);

        }
        } catch (NullPointerException e) {
            // 손에안들고있을경우 예외
        }
    }

    private void jobPaperActiveHandler(Player player, String displayName) {
        String stripDisplayName = ChatColor.stripColor(displayName);
        String playerJobCode = plugin.getConfig().getString("players." + player.getUniqueId() + ".job");

        LuckPerms luckPerms = LuckPermsProvider.get();
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());

        switch (stripDisplayName) {
            case "직업초기화":
                if (!validator.haveYourJobCheck(playerJobCode, "100")) {
                    BuffEvent.resetBuffs(player);
                    LuckPermPermission.resetPermissionShop(luckPerms, user);
                    LuckPermPermission.setBeginnerPemissionShop(luckPerms, user);
                    setUserConfig(player, "100", "현재 직업을 초기화 하였습니다");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(2));
                }
                break;

            case "광부 1차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "100")) {
                    setUserConfig(player, "150", "광부 1차 전직서 사용");
                    LuckPermPermission.removeBeginnerPemissionShop(luckPerms, user);
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;

            case "광부 2차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "150")) {
                    BuffEvent.giveFireResistanceBuff(player);
                    setUserConfig(player, "151", "광부 2차 전직서 사용");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;

            case "광부 3차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "151")) {
                    BuffEvent.giveFireResistanceBuff(player);
                    BuffEvent.giveDiggingBuff(player);
                    setUserConfig(player, "152", "광부 3차 전직서 사용");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;

            case "어부 1차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "100")) {
                    BuffEvent.giveWaterBreathingBuff(player);
                    LuckPermPermission.removeBeginnerPemissionShop(luckPerms, user);
                    setUserConfig(player, "200", "어부 1차 전직서 사용");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;

            case "어부 2차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "200")) {
                    BuffEvent.giveWaterBreathingBuff(player);
                    LuckPermPermission.setFisherPemissionShop(luckPerms, user);
                    setUserConfig(player, "201", "어부 2차 전직서 사용");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;

            case "어부 3차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "201")) {
                    BuffEvent.giveWaterBreathingBuff(player);
                    LuckPermPermission.setFisherPemissionShop_2(luckPerms, user);
                    setUserConfig(player, "202", "어부 3차 전직서 사용");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;

            case "농부 1차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "100")) {
                    BuffEvent.giveSaturationBuff(player);
                    LuckPermPermission.removeBeginnerPemissionShop(luckPerms, user);
                    setUserConfig(player, "250", "농부 1차 전직서 사용");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;

            case "농부 2차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "250")) {
                    BuffEvent.giveSaturationBuff(player);
                    LuckPermPermission.setFarmerPemissionShop(luckPerms, user);
                    setUserConfig(player, "251", "농부 2차 전직서 사용");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;

            case "농부 3차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "251")) {
                    BuffEvent.giveSaturationBuff(player);
                    LuckPermPermission.setFarmerPemissionShop_2(luckPerms, user);
                    setUserConfig(player, "252", "농부 3차 전직서 사용");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;

            case "사냥꾼 1차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "100")) {
                    LuckPermPermission.setHunterPemissionShop(luckPerms, user);
                    LuckPermPermission.removeBeginnerPemissionShop(luckPerms, user);
                    setUserConfig(player, "300", "사냥꾼 1차 전직서");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;


            case "사냥꾼 2차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "300")) {
                    BuffEvent.giveDamageBuff(player);
                    BuffEvent.giveSpeedBuff(player);
                    setUserConfig(player, "301", "사냥꾼 2차 전직서");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;

            case "사냥꾼 3차 전직서":
                if (validator.haveYourJobCheck(playerJobCode, "301")) {
                    BuffEvent.giveDamageBuff(player);
                    BuffEvent.giveSpeedBuff(player);
                    setUserConfig(player, "302", "사냥꾼 3차 전직서 사용");
                } else {
                    player.sendMessage(ErrorMessage.getJobErrorMessage(1));
                }
                break;

        }

    }

    private void setUserConfig(Player player, String setUserJobCode, String content) {
        player.sendMessage(ChatColor.GREEN + content);
        plugin.getConfig().set("players." + player.getUniqueId() + ".job", setUserJobCode);
        plugin.saveConfig();
        removeHandItem(player);
    }

    private void removeHandItem(Player player) {
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        itemInMainHand.setAmount(itemInMainHand.getAmount() - 1);
    }

}
