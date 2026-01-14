package com.designpatterns.creational.builder;

public class RaspberryPiBuilder implements AbstractMachineBuilder {
    private RaspberryPi raspberryPi;

    public RaspberryPiBuilder() {
        this.raspberryPi = new RaspberryPi();
    }

    @Override
    public void withCPU() {
        this.raspberryPi.setCPU("ARM Cortex-A72");
    }

    @Override
    public void withRAM() {
        this.raspberryPi.setRAM("1GB");
    }

    @Override
    public void withStorage() {
        this.raspberryPi.setStorage("16GB SD Card");
    }

    public RaspberryPi getResult() {
        return this.raspberryPi;
    }
}