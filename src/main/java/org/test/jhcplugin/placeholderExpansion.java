package org.test.jhcplugin;


import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.clip.placeholderapi.expansion.Relational;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class placeholderExpansion extends PlaceholderExpansion {

    private Plugin plugin;

    public placeholderExpansion(JHCPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "jhc"; // 플레이스홀더의 식별자를 정의합니다.
    }

    @Override
    public String getAuthor() {
        return "JHC";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null) {
            return "";
        }

        if (identifier.equals("job")) {
            String code = plugin.getConfig().getString("players." + player.getUniqueId() + ".job");;
            return ServerConfig.getPlayerJobCodeName(code);
        }

        return null; // 다른 플레이스홀더 요청은 처리하지 않습니다.
    }
}

