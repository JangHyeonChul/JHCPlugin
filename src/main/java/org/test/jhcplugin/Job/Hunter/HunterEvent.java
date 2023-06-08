package org.test.jhcplugin.Job.Hunter;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.test.jhcplugin.JHCPlugin;
import org.test.jhcplugin.Job.BuffEvent;

public class HunterEvent implements Listener {

    private Plugin plugin = JHCPlugin.getPlugin(JHCPlugin.class);

    @EventHandler
    public void hunterEventHandler(PlayerJoinEvent event) {
        Player player = event.getPlayer();

            String playerJobCode = plugin.getConfig().getString("players." + player.getUniqueId() + ".job");

            switch (playerJobCode) {
                case "300":
                    //사냥꾼상점1
                    break;

                case "301":
                    BuffEvent.giveDamageBuff(player);
                    BuffEvent.giveSpeedBuff(player);
                    break;

                case "302":
                    BuffEvent.giveDamageBuff(player);
                    BuffEvent.giveSpeedBuff(player);
                    break;
            }
        }



    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity damagedEntity = event.getEntity();
        LivingEntity livingEntity = (LivingEntity) damagedEntity;

        String playerJobCode = plugin.getConfig().getString("players." + livingEntity.getUniqueId() + ".job");

        if (playerJobCode.equals("302")) {
            randomDamageResistenceBuff(livingEntity, 5);
        }
    }



    private void giveDamageResistenceBuff(LivingEntity player) {
        PotionEffect DamageResistenceBuff = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,  15, 0, true, false);
        player.addPotionEffect(DamageResistenceBuff);
    }

    private void randomDamageResistenceBuff(LivingEntity player, int percentage) {
        int random = (int)(Math.random() * 100 + 1);

        if (random > 0 && random < percentage) {
            giveDamageResistenceBuff(player);
        }
    }



}
