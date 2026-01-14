package com.designpatterns.creational.factory;

public abstract class Logistics {
    
    void planDelivery() {
        System.out.println("Performing a delivery");
    }
    
    abstract Transport createTransport();
}