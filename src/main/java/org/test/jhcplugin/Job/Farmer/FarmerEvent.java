package org.test.jhcplugin.Job.Farmer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.test.jhcplugin.JHCPlugin;
import org.test.jhcplugin.Job.BuffEvent;


public class FarmerEvent implements Listener {

    private Plugin plugin = JHCPlugin.getPlugin(JHCPlugin.class);

    @EventHandler
    public void minerPassiveHandler(PlayerJoinEvent event) {
        Player player = event.getPlayer();


        String playerJob = plugin.getConfig().getString("players." + player.getUniqueId() + ".job");

        switch (playerJob) {
                case "250": // 1차
                    BuffEvent.giveSaturationBuff(player);
                    break;

                case "251": // 2차
                    BuffEvent.giveSaturationBuff(player);
                    // 농부상점1
                    break;

                case "252": // 3차
                    BuffEvent.giveSaturationBuff(player);
                    // 농부상점1
                    // 농부상점2
                    break;

        }
    }
}
