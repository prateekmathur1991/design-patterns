package com.designpatterns.factory;

public class TruckTransport implements Transport {
    
    @Override
    public void deliver() {
       System.out.println("I am delivering by truck");
    }
}
