package org.test.jhcplugin.Job.Fisher;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.test.jhcplugin.JHCPlugin;
import org.test.jhcplugin.Job.BuffEvent;


public class FisherEvent implements Listener {

    private Plugin plugin = JHCPlugin.getPlugin(JHCPlugin.class);

    @EventHandler
    public void minerPassiveHandler(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String playerJob = plugin.getConfig().getString("players." + player.getUniqueId() + ".job");

        switch (playerJob) {
                case "200": // 1차
                    BuffEvent.giveWaterBreathingBuff(player);
                    break;

                case "201": // 2차
                    BuffEvent.giveWaterBreathingBuff(player);
                    //어부상점
                    break;

                case "202": // 3차

                    BuffEvent.giveWaterBreathingBuff(player);
                    //어부상점
                    break;

            }
        }
}
