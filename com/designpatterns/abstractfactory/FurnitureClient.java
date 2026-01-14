package com.designpatterns.abstractfactory;

public class FurnitureClient {

    public static void main(String[] args) {
        FurnitureFactory someFactory = getFurnitureFactory("MODERN");
        Chair modernChair = someFactory.createChair();
        Table modernTable = someFactory.createTable();

        modernChair.sitOn();
        modernTable.use();

        FurnitureFactory someOtherFactory = getFurnitureFactory("VICTORIAN");
        Chair victorianChair = someOtherFactory.createChair();
        Table victorianTable = someOtherFactory.createTable();

        victorianChair.sitOn();
        victorianTable.use();
    }

    static FurnitureFactory getFurnitureFactory(String style) {
        if ("MODERN".equals(style)) {
            return new ModernFurnitureFactory();
        } else if ("VICTORIAN".equals(style)) {
            return new VictorianFurnitureFactory();
        }
        throw new IllegalArgumentException("Unknown style: " + style);
    }
}
