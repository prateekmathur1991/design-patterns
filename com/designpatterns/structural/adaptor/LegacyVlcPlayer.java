package com.designpatterns.structural.adaptor;

/**
 * This is a legacy class that implements a different interface. It does not implement the Playable interface, which is required for our modern players.
 * 
 * Also, it is assumed that either it is not possible to change the code of this class (e.g., third-party library), or doing so would be impractical.
 */
public class LegacyVlcPlayer {
    public void playVlc(String filename) {
        System.out.println("Playing vlc file: " + filename);
    }
}
