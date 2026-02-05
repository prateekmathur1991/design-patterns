package com.designpatterns.behavioral.state;

/**
 * Context class - Maintains the current state of a document and delegates
 * state-specific operations to the current state object.
 * The Document class is responsible for changing its state based on the
 * operations performed.
 */
public class Document {
    
    // The current state of the document
    private State state;
    
    // Document metadata
    private String title;
    private String content;
    
    /**
     * Constructor - initializes a new document in Draft state
     * @param title the title of the document
     * @param content the content of the document
     */
    public Document(String title, String content) {
        this.title = title;
        this.content = content;
        // All documents start in Draft state
        this.state = new DraftState();
    }
    
    /**
     * Set the current state of the document
     * This method is called by state objects to transition to a new state
     * @param state the new state
     */
    public void setState(State state) {
        this.state = state;
        // this.state = new ArchivedState(); // Both the context and the concrete states can perform the state transition.
        System.out.println("State changed to: " + state.getStateName());
    }
    
    /**
     * Publish the document - delegates to the current state
     */
    public void publish() {
        state.publish(this);
    }
    
    /**
     * Archive the document - delegates to the current state
     */
    public void archive() {
        state.archive(this);
    }
    
    /**
     * Revert the document - delegates to the current state
     */
    public void revert() {
        state.revert(this);
    }
    
    /**
     * Get the current state of the document
     * @return the current state name
     */
    public String getCurrentState() {
        return state.getStateName();
    }
    
    /**
     * Get the document title
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Get the document content
     * @return the content
     */
    public String getContent() {
        return content;
    }
    
    /**
     * Edit the document content - can be done in any state
     * @param newContent the new content
     */
    public void edit(String newContent) {
        this.content = newContent;
        System.out.println("Document content updated.");
    }
}
