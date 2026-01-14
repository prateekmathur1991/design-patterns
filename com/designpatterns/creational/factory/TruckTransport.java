package com.designpatterns.creational.factory;

public class TruckTransport implements Transport {
    
    @Override
    public void deliver() {
       System.out.println("I am delivering by truck");
    }
}
