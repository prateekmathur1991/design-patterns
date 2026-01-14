package com.designpatterns.creational.abstractfactory;

public class VictorianChair implements Chair {

    @Override
    public void sitOn() {
        System.out.println("I am sitting on a Victorian chair");
    }
}
