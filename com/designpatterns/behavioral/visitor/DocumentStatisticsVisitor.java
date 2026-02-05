package com.designpatterns.behavioral.visitor;

/**
 * ConcreteVisitor - Implements operations for calculating document statistics.
 * This visitor shows how to gather information about all elements.
 * Demonstrates how visitors can accumulate data during traversal.
 */
public class DocumentStatisticsVisitor implements Visitor {
    
    private int textElementCount = 0;
    private int headingCount = 0;
    private int imageCount = 0;
    private int listCount = 0;
    private int totalCharacters = 0;
    
    @Override
    public void visit(TextElement element) {
        System.out.println("Analyzing TextElement...");
        textElementCount++;
        totalCharacters += element.getContent().length();
    }
    
    @Override
    public void visit(HeadingElement element) {
        System.out.println("Analyzing HeadingElement...");
        headingCount++;
        totalCharacters += element.getContent().length();
    }
    
    @Override
    public void visit(ImageElement element) {
        System.out.println("Analyzing ImageElement...");
        imageCount++;
        totalCharacters += element.getAltText().length();
    }
    
    @Override
    public void visit(ListElement element) {
        System.out.println("Analyzing ListElement...");
        listCount++;
        for (String item : element.getItems()) {
            totalCharacters += item.length();
        }
    }
    
    /**
     * Get the statistics report
     * @return formatted statistics
     */
    public String getStatisticsReport() {
        int totalElements = textElementCount + headingCount + imageCount + listCount;
        
        StringBuilder report = new StringBuilder();
        report.append("=== Document Statistics ===\n");
        report.append("Total Elements: ").append(totalElements).append("\n");
        report.append("  - Text Elements: ").append(textElementCount).append("\n");
        report.append("  - Headings: ").append(headingCount).append("\n");
        report.append("  - Images: ").append(imageCount).append("\n");
        report.append("  - Lists: ").append(listCount).append("\n");
        report.append("Total Characters: ").append(totalCharacters).append("\n");
        report.append("Average Element Size: ").append(
            totalElements > 0 ? totalCharacters / totalElements : 0
        ).append(" characters");
        
        return report.toString();
    }
}
