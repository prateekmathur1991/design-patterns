package com.designpatterns.abstractfactory;

public class VictorianTable implements Table {

    @Override
    public void use() {
        System.out.println("I am using a Victorian table");
    }
}
