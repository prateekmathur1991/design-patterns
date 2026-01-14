package com.designpatterns.factory;

public class LogisticsApp {
    
    public static void main(String [] args) {
        Logistics logisticsInstance = geLogistics("CLOTHS");

        Transport nearbyTransport = logisticsInstance.createTransport();
        nearbyTransport.deliver();
    }

    static Logistics geLogistics(String product) {
        if ("BALLS".equalsIgnoreCase(product)) {
            return new RoadLogistics();
        }
        return new SeaLogistics();
    }
}
