package com.designpatterns.behavioral.state;

/**
 * Demo class - Demonstrates the State design pattern in action.
 * Shows how a document transitions between different states (Draft, Published, Archived)
 * and how the behavior changes based on the current state.
 * 
 * The State pattern allows an object to alter its behavior when its internal state changes.
 * It appears as if the object changed its class.
 */
public class Demo {
    
    public static void main(String[] args) {
        System.out.println("=== State Design Pattern Demo ===\n");
        
        // Create a new document - starts in Draft state
        Document document = new Document("Design Patterns Guide", "Content about design patterns...");
        
        System.out.println("Document: \"" + document.getTitle() + "\"");
        System.out.println("Initial State: " + document.getCurrentState());
        System.out.println();
        
        // --- DRAFT STATE OPERATIONS ---
        System.out.println("--- DRAFT STATE ---");
        System.out.println("Attempting to archive (should fail):");
        document.archive();
        System.out.println();
        
        System.out.println("Attempting to revert (should fail):");
        document.revert();
        System.out.println();
        
        System.out.println("Editing document:");
        document.edit("Updated content with important information...");
        System.out.println();
        
        System.out.println("Publishing document:");
        document.publish();
        System.out.println("Current State: " + document.getCurrentState());
        System.out.println();
        
        // --- PUBLISHED STATE OPERATIONS ---
        System.out.println("--- PUBLISHED STATE ---");
        System.out.println("Attempting to publish again (should fail):");
        document.publish();
        System.out.println();
        
        System.out.println("Editing document (should be allowed):");
        document.edit("Updated published content...");
        System.out.println();
        
        System.out.println("Reverting to Draft:");
        document.revert();
        System.out.println("Current State: " + document.getCurrentState());
        System.out.println();
        
        // --- BACK TO DRAFT ---
        System.out.println("--- BACK TO DRAFT STATE ---");
        System.out.println("Publishing again:");
        document.publish();
        System.out.println("Current State: " + document.getCurrentState());
        System.out.println();
        
        // --- ARCHIVED STATE OPERATIONS ---
        System.out.println("--- ARCHIVED STATE ---");
        System.out.println("Archiving document:");
        document.archive();
        System.out.println("Current State: " + document.getCurrentState());
        System.out.println();
        
        System.out.println("Attempting to publish from Archived (should fail):");
        document.publish();
        System.out.println();
        
        System.out.println("Attempting to archive again (should fail):");
        document.archive();
        System.out.println();
        
        System.out.println("Reverting from Archived to Published:");
        document.revert();
        System.out.println("Current State: " + document.getCurrentState());
        System.out.println();
        
        System.out.println("=== Demo Complete ===");
    }
}
