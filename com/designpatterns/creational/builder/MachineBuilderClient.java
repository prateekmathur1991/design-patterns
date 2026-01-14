package com.designpatterns.creational.builder;

public class MachineBuilderClient {
    
    public static void main(String[] args) {

        MachineBuilderDirector director = new MachineBuilderDirector();

        RaspberryPiBuilder raspberryPiBuilder = new RaspberryPiBuilder();
        director.constructRaspberryPi(raspberryPiBuilder);
        RaspberryPi raspberryPi = raspberryPiBuilder.getResult();
        System.out.println(raspberryPi);

        LaptopBuilder laptopBuilder = new LaptopBuilder();
        director.constructLaptop(laptopBuilder);
        Laptop laptop = laptopBuilder.getResult();
        System.out.println(laptop);
    }
}
