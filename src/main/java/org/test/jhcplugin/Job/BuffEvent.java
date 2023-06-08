package org.test.jhcplugin.Job;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BuffEvent {

    public static void giveSaturationBuff(Player player) {
        resetBuffs(player);
        PotionEffect SaturationBuff = new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 0, true, false);
        player.addPotionEffect(SaturationBuff);
    }


    public static void giveFireResistanceBuff(Player player) {
        resetBuffs(player);
        PotionEffect FireResistanceBuff = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0, true, false);
        player.addPotionEffect(FireResistanceBuff);

    }

    public static void giveDiggingBuff(Player player) {
        resetBuffs(player);
        PotionEffect DiggingBuff = new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 0, true, false);
        player.addPotionEffect(DiggingBuff);
    }

    public static void giveWaterBreathingBuff(Player player) {
        resetBuffs(player);
        PotionEffect WaterBreathingBuff = new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0, true, false);
        player.addPotionEffect(WaterBreathingBuff);

    }


    public static void giveDamageBuff(Player player) {
        resetBuffs(player);
        PotionEffect DamageBuff = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, true, false);
        player.addPotionEffect(DamageBuff);

    }

    public static void giveSpeedBuff(Player player) {
        resetBuffs(player);
        PotionEffect SpeedBuff = new PotionEffect(PotionEffectType.SPEED,  Integer.MAX_VALUE, 0, true, false);
        player.addPotionEffect(SpeedBuff);
    }

    public static void resetBuffs(Player player) {
        player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
        player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        player.removePotionEffect(PotionEffectType.SPEED);
        player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        player.removePotionEffect(PotionEffectType.WATER_BREATHING);
        player.removePotionEffect(PotionEffectType.SATURATION);
        player.removePotionEffect(PotionEffectType.LUCK);
        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
    }
}
