package com.designpatterns.factory;

public class RoadLogistics extends Logistics {

    @Override
    Transport createTransport() {
        return new TruckTransport();
    }
}
