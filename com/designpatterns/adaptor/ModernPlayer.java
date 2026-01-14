package com.designpatterns.adaptor;

public class ModernPlayer implements Playable {
    
    @Override
    public void play(String filename) {
        System.out.println("Playing modern file: " + filename);
    }
}
