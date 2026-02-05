package com.designpatterns.behavioral.templatemethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ConcreteClass - JSON Data Processor
 * Implements the template method's abstract steps for processing JSON files.
 * This class defines the specific algorithm for reading, validating, parsing,
 * and processing JSON (JavaScript Object Notation) data.
 */
public class JSONDataProcessor extends DataProcessor {
    
    @Override
    protected String readData(String filePath) {
        System.out.println("Reading JSON file: " + filePath);
        // Simulate reading JSON file
        Map<String, Object> jsonMap = new HashMap<>();
        List<Map<String, Object>> users = new ArrayList<>();
        
        Map<String, Object> user1 = new HashMap<>();
        user1.put("name", "Alice");
        user1.put("age", 28);
        users.add(user1);
        
        Map<String, Object> user2 = new HashMap<>();
        user2.put("name", "Bob");
        user2.put("age", 35);
        users.add(user2);
        
        jsonMap.put("users", users);
        return jsonMap.toString();
    }
    
    @Override
    protected boolean validateData(String data) {
        System.out.println("Validating JSON format...");
        // JSON validation: check if data contains opening and closing braces
        if (data == null || data.isEmpty()) {
            return false;
        }
        // Simple validation: check for JSON structure
        return data.trim().startsWith("{") && data.trim().endsWith("}");
    }
    
    @Override
    protected Object parseData(String data) {
        System.out.println("Parsing JSON data...");
        List<Map<String, Object>> users = new ArrayList<>();
        
        // Simple JSON parsing simulation
        // In real scenarios, you would use a JSON library like Gson or Jackson
        String[] lines = data.split("\\{");
        for (int i = 1; i < lines.length; i++) {
            if (lines[i].contains("\"name\"")) {
                Map<String, Object> user = new HashMap<>();
                // Extract name
                int nameStart = lines[i].indexOf("\"name\":");
                int nameValueStart = lines[i].indexOf("\"", nameStart + 9) + 1;
                int nameValueEnd = lines[i].indexOf("\"", nameValueStart);
                user.put("name", lines[i].substring(nameValueStart, nameValueEnd));
                
                // Extract age
                int ageStart = lines[i].indexOf("\"age\":");
                int ageValueStart = ageStart + 7;
                int ageValueEnd = lines[i].indexOf(",", ageValueStart);
                if (ageValueEnd == -1) {
                    ageValueEnd = lines[i].indexOf("}", ageValueStart);
                }
                user.put("age", Integer.parseInt(lines[i].substring(ageValueStart, ageValueEnd).trim()));
                users.add(user);
            }
        }
        
        System.out.println("Parsed " + users.size() + " JSON objects");
        return users;
    }
    
    @Override
    protected Object process(Object parsedData) {
        System.out.println("Processing JSON objects...");
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> users = (List<Map<String, Object>>) parsedData;
        
        List<JSONRecord> processedRecords = new ArrayList<>();
        for (Map<String, Object> user : users) {
            JSONRecord jsonRecord = new JSONRecord((String) user.get("name"), (Integer) user.get("age"));
            processedRecords.add(jsonRecord);
        }
        
        System.out.println("Processed " + processedRecords.size() + " JSON records");
        return processedRecords;
    }
    
    @Override
    protected void saveResults(Object processedData) {
        System.out.println("Saving JSON results...");
        @SuppressWarnings("unchecked")
        List<JSONRecord> records = (List<JSONRecord>) processedData;
        
        for (JSONRecord record : records) {
            System.out.println("  Saved: " + record);
        }
    }
    
    /**
     * Inner class to represent a JSON record
     */
    private static class JSONRecord {
        String name;
        int age;
        
        JSONRecord(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return "JSONRecord{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }
}
