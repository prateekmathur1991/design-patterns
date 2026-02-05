package com.designpatterns.behavioral.visitor;

/**
 * Demo class - Demonstrates the Visitor design pattern in action.
 * Shows how different visitors can operate on the same document structure
 * without modifying the element classes.
 * 
 * The Visitor pattern represents an operation to be performed on the elements
 * of an object structure. It lets you define a new operation without changing
 * the classes of the elements on which it operates.
 * 
 * Key Benefits:
 * 1. Separation of Concerns - Operations are separated from the element classes
 * 2. Easy to Add Operations - New operations can be added without modifying elements
 * 3. Related Operations - All logic for an operation is in one visitor class
 * 4. Flexibility - Different visitors can produce different results on same structure
 * 
 * The "Double Dispatch" mechanism:
 * - First dispatch: visitor.visit(element)
 * - Second dispatch: element.accept(visitor) calls visitor.visit(this)
 */
public class Demo {
    
    public static void main(String[] args) {
        System.out.println("=== Visitor Design Pattern Demo ===");
        System.out.println("Document Processing System\n");
        
        // Create a document with various elements
        Document document = new Document("User Guide");
        document.addElement(new HeadingElement("Introduction", 1));
        document.addElement(new TextElement("This document explains how to use our product."));
        document.addElement(new HeadingElement("Features", 2));
        document.addElement(new ListElement("Feature 1: Easy to use", "Feature 2: Fast", "Feature 3: Reliable"));
        document.addElement(new TextElement("Our product has been tested extensively."));
        document.addElement(new ImageElement("https://example.com/image.png", "Product screenshot"));
        document.addElement(new HeadingElement("Getting Started", 2));
        document.addElement(new ListElement("Download the app", "Install it", "Launch the app"));
        
        System.out.println("Document created with " + document.getElementCount() + " elements\n");
        
        // --- VISITOR 1: HTML EXPORT ---
        System.out.println("========== HTML EXPORT VISITOR ==========");
        HTMLExportVisitor htmlVisitor = new HTMLExportVisitor();
        document.accept(htmlVisitor);
        System.out.println("Generated HTML:\n");
        System.out.println(htmlVisitor.getHTML());
        
        // --- VISITOR 2: SPELL CHECK ---
        System.out.println("========== SPELL CHECK VISITOR ==========");
        SpellCheckVisitor spellCheckVisitor = new SpellCheckVisitor();
        document.accept(spellCheckVisitor);
        System.out.println(spellCheckVisitor.getReport());
        System.out.println();
        
        // --- VISITOR 3: DOCUMENT STATISTICS ---
        System.out.println("========== DOCUMENT STATISTICS VISITOR ==========");
        DocumentStatisticsVisitor statsVisitor = new DocumentStatisticsVisitor();
        document.accept(statsVisitor);
        System.out.println(statsVisitor.getStatisticsReport());
        System.out.println();
        
        // --- DEMONSTRATE POLYMORPHISM ---
        System.out.println("========== USING VISITOR INTERFACE POLYMORPHICALLY ==========");
        Visitor[] visitors = {
            new HTMLExportVisitor(),
            new SpellCheckVisitor(),
            new DocumentStatisticsVisitor()
        };
        
        System.out.println("Processing document with multiple visitors:\n");
        for (Visitor visitor : visitors) {
            document.accept(visitor);
        }
        
        // --- MULTIPLE DOCUMENTS, SINGLE VISITOR ---
        System.out.println("========== APPLYING SAME VISITOR TO DIFFERENT DOCUMENTS ==========");
        Document doc2 = new Document("Quick Start Guide");
        doc2.addElement(new HeadingElement("Quick Start", 1));
        doc2.addElement(new TextElement("Get started in 5 minutes."));
        doc2.addElement(new ListElement("Step 1", "Step 2", "Step 3", "Step 4", "Step 5"));
        
        DocumentStatisticsVisitor statsVisitor2 = new DocumentStatisticsVisitor();
        System.out.println("Statistics for Document 2:\n");
        doc2.accept(statsVisitor2);
        System.out.println(statsVisitor2.getStatisticsReport());
        
        System.out.println("\n=== Demo Complete ===");
        System.out.println("\nKey Components of Visitor Pattern:");
        System.out.println("1. Visitor Interface (Visitor.java)");
        System.out.println("   - Declares visit methods for each element type");
        System.out.println("2. Element Interface (Element.java)");
        System.out.println("   - Defines accept() method for visitors");
        System.out.println("3. Concrete Elements (TextElement, HeadingElement, etc.)");
        System.out.println("   - Implement accept() to call visitor.visit(this)");
        System.out.println("4. Concrete Visitors (HTMLExportVisitor, SpellCheckVisitor, etc.)");
        System.out.println("   - Implement visit() methods for each element type");
        System.out.println("   - Each visitor encapsulates a specific operation");
        System.out.println("5. Object Structure (Document)");
        System.out.println("   - Contains elements and allows visitors to traverse them");
    }
}
