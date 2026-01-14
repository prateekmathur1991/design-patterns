package com.designpatterns.builder;

public class LaptopBuilder implements AbstractMachineBuilder {
    private Laptop laptop;

    public LaptopBuilder() {
        this.laptop = new Laptop();
    }

    @Override
    public void withCPU() {
        this.laptop.setCPU("Intel Core i7");
    }

    @Override
    public void withRAM() {
        this.laptop.setRAM("16GB");
    }

    @Override
    public void withStorage() {
        this.laptop.setStorage("512GB SSD");
    }

    public Laptop getResult() {
        return this.laptop;
    }
}
