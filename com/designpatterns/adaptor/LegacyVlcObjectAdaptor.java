package com.designpatterns.adaptor;

public class LegacyVlcObjectAdaptor implements Playable {
    
    private LegacyVlcPlayer vlcPlayer;
    
    public LegacyVlcObjectAdaptor() {
        this.vlcPlayer = new LegacyVlcPlayer();
    }
    
    @Override
    public void play(String filename) {
        vlcPlayer.playVlc(filename);
    }
}
