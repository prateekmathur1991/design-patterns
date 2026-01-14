package com.designpatterns.adaptor;

public class LegacyVlcClassAdaptor extends LegacyVlcPlayer implements Playable {
    
    @Override
    public void play(String filename) {
        super.playVlc(filename);
    }
}
