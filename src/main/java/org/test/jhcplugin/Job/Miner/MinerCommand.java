package org.test.jhcplugin.Job.Miner;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.test.jhcplugin.JHCPlugin;

public class MinerCommand implements CommandExecutor {

    private Plugin plugin = JHCPlugin.getPlugin(JHCPlugin.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        String playerJobCode = plugin.getConfig().getString("players." + player.getUniqueId() + ".job");


        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "플레이어만 이 명령어를 사용할수 있습니다.");
            return true;
        }

        if (userMinerValid(playerJobCode)) {
            switch (args[0]) {
                case "켜기":
                    PotionEffect nightVisionEffect = new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false);
                    player.addPotionEffect(nightVisionEffect);
                    sender.sendMessage(ChatColor.GREEN + "야간 투시효과를 활성화 하였습니다.");
                    break;
                case "끄기":
                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    player.sendMessage(ChatColor.RED + "야간투시 효과가 꺼졌습니다.");
                    break;
            }
        }  else {
        sender.sendMessage(ChatColor.RED + "야간 투시능력은 광부만 사용가능합니다");
    }
        return false;

    }

    private boolean userMinerValid(String playerJobNumber) {
        if (playerJobNumber.equals("150")) return true;
        if (playerJobNumber.equals("151")) return true;
        if (playerJobNumber.equals("152")) return true;
        return false;
    }
}
