package org.test.jhcplugin;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class ServerConfig implements Listener {

    private Plugin plugin = JHCPlugin.getPlugin(JHCPlugin.class);
    private static Map<String, String> jobCodeMap = new HashMap<>();


    public ServerConfig() {
        // 직업목록 업데이트
        jobProperties();

    }

    public static String getPlayerJobCodeName(String playerJobCode) {

        return jobCodeMap.get(playerJobCode);
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        FileConfiguration config = plugin.getConfig();

        if (!config.contains("players." + player.getUniqueId())) { // 처음접속시 직업초기화
            plugin.getConfig().set("players." + player.getUniqueId() + ".name", player.getName());
            plugin.getConfig().set("players." + player.getUniqueId() + ".job", "100");
            plugin.saveConfig();
        }
    }

    private static void jobProperties() {

        //직업 목록
        jobCodeMap.put("100", "초보자");
        jobCodeMap.put("150", "광부1차");
        jobCodeMap.put("151", "광부2차");
        jobCodeMap.put("152", "광부3차");

        jobCodeMap.put("200", "어부1차");
        jobCodeMap.put("201", "어부2차");
        jobCodeMap.put("202", "어부3차");

        jobCodeMap.put("250", "농부1차");
        jobCodeMap.put("251", "농부2차");
        jobCodeMap.put("252", "농부3차");

        jobCodeMap.put("300", "사냥꾼1차");
        jobCodeMap.put("301", "사냥꾼2차");
        jobCodeMap.put("302", "사냥꾼3차");


    }
}
