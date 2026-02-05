package com.designpatterns.behavioral.visitor;

/**
 * ConcreteVisitor - Implements operations for spell checking elements.
 * This visitor shows how different elements can be spell-checked.
 * Demonstrates how the same element structure can be used for different purposes.
 */
public class SpellCheckVisitor implements Visitor {
    
    private StringBuilder report;
    private int errorCount = 0;
    
    /**
     * Constructor - initializes the spell check report
     */
    public SpellCheckVisitor() {
        this.report = new StringBuilder();
    }
    
    @Override
    public void visit(TextElement element) {
        System.out.println("Spell checking TextElement...");
        String content = element.getContent();
        
        // Simulate spell checking
        if (content.contains("teh") || content.contains("recieve")) {
            report.append("ERROR in text: Found spelling mistake\n");
            errorCount++;
        } else {
            report.append("✓ Text element is correct\n");
        }
    }
    
    @Override
    public void visit(HeadingElement element) {
        System.out.println("Spell checking HeadingElement...");
        String content = element.getContent();
        
        // Simulate spell checking for headings (check for common mistakes)
        if (content.length() > 50) {
            report.append("WARNING: Heading is very long\n");
        } else {
            report.append("✓ Heading element is fine\n");
        }
    }
    
    @Override
    public void visit(ImageElement element) {
        System.out.println("Checking ImageElement...");
        String altText = element.getAltText();
        
        // Check if alt text is present and reasonable
        if (altText == null || altText.isEmpty()) {
            report.append("ERROR: Image missing alt text\n");
            errorCount++;
        } else {
            report.append("✓ Image has alt text: \"").append(altText).append("\"\n");
        }
    }
    
    @Override
    public void visit(ListElement element) {
        System.out.println("Checking ListElement...");
        
        if (element.getItemCount() == 0) {
            report.append("ERROR: List is empty\n");
            errorCount++;
        } else if (element.getItemCount() > 10) {
            report.append("WARNING: List has many items (").append(element.getItemCount()).append(")\n");
        } else {
            report.append("✓ List element is fine\n");
        }
    }
    
    /**
     * Get the spell check report
     * @return the report
     */
    public String getReport() {
        return "=== Spell Check Report ===\n" + report.toString() + 
               "Total Errors: " + errorCount;
    }
    
    /**
     * Get the total error count
     * @return the number of errors found
     */
    public int getErrorCount() {
        return errorCount;
    }
}
