package com.designpatterns.creational.builder;

public class MachineBuilderDirector {

    // The building steps to construct a raspberry pi does not involve invoking the storage building step
    public void constructRaspberryPi(AbstractMachineBuilder raspeberryPiBuilder) {
        raspeberryPiBuilder.withCPU();
        raspeberryPiBuilder.withRAM();
    }

    public void constructLaptop(AbstractMachineBuilder laptopBuilder) {
        laptopBuilder.withCPU();
        laptopBuilder.withRAM();
        laptopBuilder.withStorage();
    }
}