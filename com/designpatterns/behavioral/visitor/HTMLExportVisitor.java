package com.designpatterns.behavioral.visitor;

/**
 * ConcreteVisitor - Implements operations to save/export elements to HTML format.
 * This visitor shows how different elements are handled for HTML export.
 * The visitor pattern allows adding new operations without modifying element classes.
 */
public class HTMLExportVisitor implements Visitor {
    
    private StringBuilder html;
    
    /**
     * Constructor - initializes the HTML builder
     */
    public HTMLExportVisitor() {
        this.html = new StringBuilder();
    }
    
    @Override
    public void visit(TextElement element) {
        System.out.println("Exporting TextElement to HTML...");
        html.append("<p>").append(element.getContent()).append("</p>\n");
    }
    
    @Override
    public void visit(HeadingElement element) {
        System.out.println("Exporting HeadingElement to HTML...");
        int level = element.getLevel();
        html.append("<h").append(level).append(">")
            .append(element.getContent())
            .append("</h").append(level).append(">\n");
    }
    
    @Override
    public void visit(ImageElement element) {
        System.out.println("Exporting ImageElement to HTML...");
        html.append("<img src=\"").append(element.getUrl())
            .append("\" alt=\"").append(element.getAltText())
            .append("\" />\n");
    }
    
    @Override
    public void visit(ListElement element) {
        System.out.println("Exporting ListElement to HTML...");
        html.append("<ul>\n");
        for (String item : element.getItems()) {
            html.append("  <li>").append(item).append("</li>\n");
        }
        html.append("</ul>\n");
    }
    
    /**
     * Get the generated HTML
     * @return the HTML string
     */
    public String getHTML() {
        return html.toString();
    }
}
