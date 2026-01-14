package com.designpatterns.structural.adaptor;

public class LegacyVlcClassAdaptor extends LegacyVlcPlayer implements Playable {
    
    @Override
    public void play(String filename) {
        super.playVlc(filename);
    }
}
