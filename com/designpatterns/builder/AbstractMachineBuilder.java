package com.designpatterns.builder;

public interface AbstractMachineBuilder {
    void withCPU();
    void withRAM();
    void withStorage();
}