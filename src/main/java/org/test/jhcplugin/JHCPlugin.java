package org.test.jhcplugin;


import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.test.jhcplugin.Job.Beginner.BeginnerEvent;
import org.test.jhcplugin.Job.Farmer.FarmerEvent;
import org.test.jhcplugin.Job.Fisher.FisherEvent;
import org.test.jhcplugin.Job.Hunter.HunterEvent;
import org.test.jhcplugin.Job.JobInteractEvent;
import org.test.jhcplugin.Job.Miner.MinerCommand;
import org.test.jhcplugin.Job.Miner.MinerEvent;
import org.test.jhcplugin.command.JobInfoCommand;


public final class JHCPlugin extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);

        if (provider != null) {
            LuckPerms api = provider.getProvider();
        }

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            Bukkit.getPluginManager().disablePlugin(this);
        }

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new placeholderExpansion(this).register();
        }



        
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new MinerEvent(), this);
        getServer().getPluginManager().registerEvents(new FisherEvent(), this);
        getServer().getPluginManager().registerEvents(new HunterEvent(), this);
        getServer().getPluginManager().registerEvents(new FarmerEvent(), this);
        getServer().getPluginManager().registerEvents(new BeginnerEvent(), this);

        getServer().getPluginManager().registerEvents(new ServerConfig(), this);
        getServer().getPluginManager().registerEvents(new JobInteractEvent(), this);

        getCommand("야간투시").setExecutor(new MinerCommand());
        getCommand("직업확인").setExecutor(new JobInfoCommand());
    }


}




