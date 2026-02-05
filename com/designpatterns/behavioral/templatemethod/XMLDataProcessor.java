package com.designpatterns.behavioral.templatemethod;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteClass - XML Data Processor
 * Implements the template method's abstract steps for processing XML files.
 * This class defines the specific algorithm for reading, validating, parsing,
 * and processing XML (Extensible Markup Language) data.
 */
public class XMLDataProcessor extends DataProcessor {
    
    @Override
    protected String readData(String filePath) {
        System.out.println("Reading XML file: " + filePath);
        // Simulate reading XML file
        return "<data><person><name>Charlie</name><age>32</age></person><person><name>Diana</name><age>29</age></person></data>";
    }
    
    @Override
    protected boolean validateData(String data) {
        System.out.println("Validating XML format...");
        // XML validation: check if data contains opening and closing tags
        if (data == null || data.isEmpty()) {
            return false;
        }
        // Simple validation: check for XML structure with tags
        return data.contains("<") && data.contains(">") && data.trim().startsWith("<") && data.trim().endsWith(">");
    }
    
    @Override
    protected Object parseData(String data) {
        System.out.println("Parsing XML data...");
        List<XMLRecord> records = new ArrayList<>();
        
        // Simple XML parsing simulation
        // In real scenarios, you would use an XML library like DOM or SAX
        String[] personBlocks = data.split("<person>");
        for (int i = 1; i < personBlocks.length; i++) {
            String block = personBlocks[i];
            
            // Extract name
            int nameStart = block.indexOf("<name>") + 6;
            int nameEnd = block.indexOf("</name>");
            String name = block.substring(nameStart, nameEnd);
            
            // Extract age
            int ageStart = block.indexOf("<age>") + 5;
            int ageEnd = block.indexOf("</age>");
            int age = Integer.parseInt(block.substring(ageStart, ageEnd));
            
            records.add(new XMLRecord(name, age));
        }
        
        System.out.println("Parsed " + records.size() + " XML elements");
        return records;
    }
    
    @Override
    protected Object process(Object parsedData) {
        System.out.println("Processing XML records...");
        @SuppressWarnings("unchecked")
        List<XMLRecord> records = (List<XMLRecord>) parsedData;
        
        // Perform processing on XML records
        for (XMLRecord record : records) {
            // Example: Convert names to uppercase
            record.name = record.name.toUpperCase();
        }
        
        System.out.println("Processed " + records.size() + " XML records");
        return records;
    }
    
    @Override
    protected void saveResults(Object processedData) {
        System.out.println("Saving XML results...");
        @SuppressWarnings("unchecked")
        List<XMLRecord> records = (List<XMLRecord>) processedData;
        
        for (XMLRecord record : records) {
            System.out.println("  Saved: " + record);
        }
    }
    
    /**
     * Inner class to represent an XML record
     */
    private static class XMLRecord {
        String name;
        int age;
        
        XMLRecord(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return "XMLRecord{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }
}
