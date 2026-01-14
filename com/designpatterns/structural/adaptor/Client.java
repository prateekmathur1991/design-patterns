package com.designpatterns.structural.adaptor;

public class Client {

    public static void main(String[] args) {
        Playable player = getPlayer("modern");
        player.play("example");
    }

    public static Playable getPlayer(String type) {
        if (type.equalsIgnoreCase("modern")) {
            return new ModernPlayer();
        } else if (type.equalsIgnoreCase("vlc")) {
            return new LegacyVlcClassAdaptor();
        }
        return null;
    }
}
