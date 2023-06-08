package org.test.jhcplugin.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.test.jhcplugin.JHCPlugin;
import org.test.jhcplugin.ServerConfig;


public class JobInfoCommand implements CommandExecutor {

    private Plugin plugin = JHCPlugin.getPlugin(JHCPlugin.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;
        String playerJobCode = plugin.getConfig().getString("players." + player.getUniqueId() + ".job");
        String jobCode = ServerConfig.getPlayerJobCodeName(playerJobCode);

        sender.sendMessage(ChatColor.GREEN + jobCode);




        return false;
    }
}
