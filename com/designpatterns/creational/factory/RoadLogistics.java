package com.designpatterns.creational.factory;

public class RoadLogistics extends Logistics {

    @Override
    Transport createTransport() {
        return new TruckTransport();
    }
}
