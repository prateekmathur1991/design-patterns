package com.designpatterns.behavioral.mediator;

public class Client {
    
    public static void main(String[] args) {
        
        // Notice that no 2 aircrafts are talking directly to each other. They talk to the mediator, which provides instructions
        // based on runway status.
        AirTrafficMediator mediator = new AirTrafficMediator();

        mediator.registerAircarft("Boeing 747");
        mediator.registerAircarft("Cessna");
        mediator.registerAircarft("Glider");

        AirTrafficMediator.LANDING_INSTRUCTION instruction = mediator.requestLanding("Boeing 747");
        System.out.println(instruction);

        AirTrafficMediator.LANDING_INSTRUCTION cessenaInstruction = mediator.requestLanding("Cessna");
        System.out.println(cessenaInstruction);

        mediator.finishLanding("Boeing 747");

        cessenaInstruction = mediator.requestLanding("Cessna");
        System.out.println(cessenaInstruction);
    }
}
