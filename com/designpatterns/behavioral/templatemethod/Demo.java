package com.designpatterns.behavioral.templatemethod;

/**
 * Demo class - Demonstrates the Template Method design pattern in action.
 * Shows how different data processors follow the same algorithm structure
 * but implement different specific steps for processing different file formats.
 * 
 * The Template Method pattern defines the skeleton of an algorithm in a method,
 * deferring some steps to subclasses. It lets subclasses redefine certain steps
 * of an algorithm without changing the algorithm's structure.
 * 
 * Benefits demonstrated:
 * 1. Code reuse - Common algorithm structure is defined once in the base class
 * 2. Consistency - All subclasses follow the same algorithm sequence
 * 3. Open/Closed Principle - Easy to add new data processor types without modifying existing code
 * 4. Flexibility - Subclasses only need to implement the specific steps they need
 */
public class Demo {
    
    public static void main(String[] args) {
        System.out.println("=== Template Method Design Pattern Demo ===");
        System.out.println("Data Processing System with Multiple File Formats\n");
        
        // Create different data processor instances
        DataProcessor csvProcessor = new CSVDataProcessor();
        DataProcessor jsonProcessor = new JSONDataProcessor();
        DataProcessor xmlProcessor = new XMLDataProcessor();
        
        // --- PROCESS CSV FILE ---
        System.out.println("========== PROCESSING CSV FILE ==========");
        csvProcessor.processData("employees.csv");
        
        // --- PROCESS JSON FILE ---
        System.out.println("\n========== PROCESSING JSON FILE ==========");
        jsonProcessor.processData("users.json");
        
        // --- PROCESS XML FILE ---
        System.out.println("\n========== PROCESSING XML FILE ==========");
        xmlProcessor.processData("data.xml");
        
        // --- DEMONSTRATING POLYMORPHISM ---
        System.out.println("\n========== DEMONSTRATING POLYMORPHISM ==========");
        System.out.println("Using DataProcessor reference to process different formats:");
        System.out.println();
        
        DataProcessor[] processors = {
            new CSVDataProcessor(),
            new JSONDataProcessor(),
            new XMLDataProcessor()
        };
        
        String[] files = {
            "data.csv",
            "data.json",
            "data.xml"
        };
        
        for (int i = 0; i < processors.length; i++) {
            processors[i].processData(files[i]);
            if (i < processors.length - 1) {
                System.out.println();
            }
        }
        
        System.out.println("\n=== Demo Complete ===");
        System.out.println("\nKey Components of Template Method Pattern:");
        System.out.println("1. Abstract Base Class (DataProcessor)");
        System.out.println("   - Defines the template method: processData()");
        System.out.println("   - Declares abstract methods for algorithm steps");
        System.out.println("2. Concrete Subclasses (CSV, JSON, XML Processors)");
        System.out.println("   - Implement specific steps for their file format");
        System.out.println("   - Follow the algorithm structure defined in the base class");
        System.out.println("3. Algorithm Structure");
        System.out.println("   - Read Data → Validate → Parse → Process → Save");
        System.out.println("   - This structure is consistent across all processors");
    }
}
