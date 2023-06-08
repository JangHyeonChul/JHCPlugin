package org.test.jhcplugin.Job.Beginner;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.test.jhcplugin.JHCPlugin;
import org.test.jhcplugin.Job.LuckPermPermission;

import java.util.Iterator;
import java.util.List;


public class BeginnerEvent implements Listener {

    private Plugin plugin = JHCPlugin.getPlugin(JHCPlugin.class);

    @EventHandler
    public void onPlayerDeath(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerJobCode = plugin.getConfig().getString("players." + player.getUniqueId() + ".job");

        LuckPerms luckPerms = LuckPermsProvider.get();
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());

        if (playerJobCode.equals("100")) { // 초보자 일경우 인벤세이브
            LuckPermPermission.setBeginnerPemissionShop(luckPerms, user);

        }
    }
}
