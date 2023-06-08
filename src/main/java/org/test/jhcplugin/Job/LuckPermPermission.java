package org.test.jhcplugin.Job;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;

public class LuckPermPermission {

    public static void setHunterPemissionShop(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().add(Node.builder("starly.shop.open.사냥꾼상점").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void setBeginnerPemissionShop(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().add(Node.builder("starly.shop.open.초보자상점").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void removeBeginnerPemissionShop(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().remove(Node.builder("starly.shop.open.사냥꾼상점").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void removeHunterPemissionShop(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().remove(Node.builder("starly.shop.open.사냥꾼상점").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void setFisherPemissionShop(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().add(Node.builder("starly.shop.open.어부상점").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void removeFisherPemissionShop(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().remove(Node.builder("starly.shop.open.어부상점").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void setFisherPemissionShop_2(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().add(Node.builder("starly.shop.open.어부상점2").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void removeFisherPemissionShop_2(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().remove(Node.builder("starly.shop.open.어부상점2").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void setFarmerPemissionShop(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().add(Node.builder("starly.shop.open.농부상점").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void removeFarmerPemissionShop(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().remove(Node.builder("starly.shop.open.농부상점").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void setFarmerPemissionShop_2(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().add(Node.builder("starly.shop.open.농부상점2").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void removeFarmerPemissionShop_2(LuckPerms luckPerms, User user) {
        if (user != null) {
            user.data().remove(Node.builder("starly.shop.open.농부상점2").build());
            luckPerms.getUserManager().saveUser(user);
        }
    }

    public static void resetPermissionShop(LuckPerms luckPerms, User user) {
        removeHunterPemissionShop(luckPerms, user);
        removeFarmerPemissionShop(luckPerms, user);
        removeFarmerPemissionShop_2(luckPerms, user);
        removeFisherPemissionShop(luckPerms, user);
        removeFisherPemissionShop_2(luckPerms, user);
    }
}
