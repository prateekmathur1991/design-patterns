package com.designpatterns.creational.factory;

public class SeaLogistics extends Logistics {

    @Override
    Transport createTransport() {
        return new ShipTransport();
    }
}