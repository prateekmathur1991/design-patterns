package com.designpatterns.abstractfactory;

public class ModernTable implements Table {

    @Override
    public void use() {
        System.out.println("I am using a Modern table");
    }
}
