package com.designpatterns.creational.builder;

public interface AbstractMachineBuilder {
    void withCPU();
    void withRAM();
    void withStorage();
}