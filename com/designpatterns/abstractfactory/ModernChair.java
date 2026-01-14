package com.designpatterns.abstractfactory;

public class ModernChair implements Chair {

    @Override
    public void sitOn() {
        System.out.println("I am sitting on a Modern chair");
    }
}
