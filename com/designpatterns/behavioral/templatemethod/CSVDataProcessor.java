package com.designpatterns.behavioral.templatemethod;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteClass - CSV Data Processor
 * Implements the template method's abstract steps for processing CSV files.
 * This class defines the specific algorithm for reading, validating, parsing,
 * and processing CSV (Comma-Separated Values) data.
 */
public class CSVDataProcessor extends DataProcessor {
    
    @Override
    protected String readData(String filePath) {
        System.out.println("Reading CSV file: " + filePath);
        // Simulate reading CSV file
        return "John,25,Engineer\nJane,30,Manager\nBob,28,Developer";
    }
    
    @Override
    protected boolean validateData(String data) {
        System.out.println("Validating CSV format...");
        // CSV validation: check if data contains commas and newlines
        if (data == null || data.isEmpty()) {
            return false;
        }
        // Simple validation: check if each line has at least 2 commas (3 fields)
        String[] lines = data.split("\n");
        for (String line : lines) {
            if (line.split(",").length < 3) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    protected Object parseData(String data) {
        System.out.println("Parsing CSV data...");
        List<String[]> records = new ArrayList<>();
        
        String[] lines = data.split("\n");
        for (String line : lines) {
            records.add(line.split(","));
        }
        
        System.out.println("Parsed " + records.size() + " CSV records");
        return records;
    }
    
    @Override
    protected Object process(Object parsedData) {
        System.out.println("Processing CSV records...");
        @SuppressWarnings("unchecked")
        List<String[]> records = (List<String[]>) parsedData;
        
        List<CSVRecord> processedRecords = new ArrayList<>();
        for (String[] record : records) {
            CSVRecord csvRecord = new CSVRecord(record[0], Integer.parseInt(record[1]), record[2]);
            processedRecords.add(csvRecord);
        }
        
        System.out.println("Processed " + processedRecords.size() + " records");
        return processedRecords;
    }
    
    @Override
    protected void saveResults(Object processedData) {
        System.out.println("Saving CSV results...");
        @SuppressWarnings("unchecked")
        List<CSVRecord> records = (List<CSVRecord>) processedData;
        
        for (CSVRecord record : records) {
            System.out.println("  Saved: " + record);
        }
    }
    
    /**
     * Inner class to represent a CSV record
     */
    private static class CSVRecord {
        String name;
        int age;
        String position;
        
        CSVRecord(String name, int age, String position) {
            this.name = name;
            this.age = age;
            this.position = position;
        }
        
        @Override
        public String toString() {
            return "CSVRecord{" + "name='" + name + '\'' + ", age=" + age + ", position='" + position + '\'' + '}';
        }
    }
}
