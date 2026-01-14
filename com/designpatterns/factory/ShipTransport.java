package com.designpatterns.factory;

public class ShipTransport implements Transport {
    
    @Override
    public void deliver() {
        System.out.println("I am delivering by Ship");
    }
}