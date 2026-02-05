package com.designpatterns.behavioral.templatemethod;

/**
 * Abstract Template Class - Defines the skeleton of the algorithm in the template method.
 * The template method calls abstract methods that subclasses must implement.
 * This ensures that the algorithm's structure is fixed while allowing subclasses
 * to provide different implementations for specific steps.
 * 
 * The Template Method pattern defines the program skeleton of an algorithm in a method,
 * deferring some steps to subclasses.
 */
public abstract class DataProcessor {
    
    /**
     * TEMPLATE METHOD - This is the main algorithm structure that cannot be changed.
     * It defines the sequence of steps for processing data.
     * Subclasses cannot override this method, but must implement the abstract methods it calls.
     */
    public final void processData(String filePath) {
        System.out.println("\n--- Starting Data Processing ---");
        System.out.println("File: " + filePath);
        
        // Step 1: Read the data
        String data = readData(filePath);
        
        // Step 2: Validate the data
        if (!validateData(data)) {
            System.out.println("ERROR: Data validation failed!");
            return;
        }
        System.out.println("✓ Data validation successful");
        
        // Step 3: Parse the data
        Object parsedData = parseData(data);
        
        // Step 4: Process the data
        Object processedData = process(parsedData);
        
        // Step 5: Save the results
        saveResults(processedData);
        
        System.out.println("✓ Data processing completed successfully");
    }
    
    /**
     * Abstract method - Subclasses must implement this to read data from file
     * @param filePath the path to the data file
     * @return the raw data as a string
     */
    protected abstract String readData(String filePath);
    
    /**
     * Abstract method - Subclasses must implement this to validate data format
     * @param data the data to validate
     * @return true if data is valid, false otherwise
     */
    protected abstract boolean validateData(String data);
    
    /**
     * Abstract method - Subclasses must implement this to parse data into objects
     * @param data the raw data string
     * @return parsed data as an object
     */
    protected abstract Object parseData(String data);
    
    /**
     * Abstract method - Subclasses must implement this to perform business logic
     * @param parsedData the parsed data object
     * @return processed data
     */
    protected abstract Object process(Object parsedData);
    
    /**
     * Abstract method - Subclasses must implement this to save results
     * @param processedData the processed data to save
     */
    protected abstract void saveResults(Object processedData);
    
    /**
     * HOOK METHOD - Optional method that subclasses can override.
     * Provides a way to insert additional behavior without changing the algorithm structure.
     * This is called before processing begins.
     */
    protected void beforeProcessing() {
        // Default implementation does nothing, subclasses can override if needed
    }
}
