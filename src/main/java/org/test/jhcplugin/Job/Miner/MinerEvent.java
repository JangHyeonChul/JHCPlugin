package org.test.jhcplugin.Job.Miner;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.test.jhcplugin.JHCPlugin;
import org.test.jhcplugin.Job.BuffEvent;


public class MinerEvent implements Listener {

    private Plugin plugin = JHCPlugin.getPlugin(JHCPlugin.class);

    @EventHandler
    public void minerPassiveHandler(PlayerJoinEvent event) {
        Player player = event.getPlayer();


        String playerJob = plugin.getConfig().getString("players." + player.getUniqueId() + ".job");

            BuffEvent.resetBuffs(player);
            switch (playerJob) {
                case "150": // 1차
                    // 야간 투시 효과
                    break;

                case "151": // 2차
                    BuffEvent.giveFireResistanceBuff(player);
                    break;

                case "152": // 3차
                    BuffEvent.giveFireResistanceBuff(player);
                    BuffEvent.giveDiggingBuff(player);
                    break;

            }
    }
}
