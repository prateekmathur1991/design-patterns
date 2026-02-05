package com.designpatterns.behavioral.state;

/**
 * State interface - defines the contract for all concrete states.
 * Each concrete state implements the actions that can be performed
 * based on the current state of the context (Document).
 */
public interface State {
    
    /**
     * Publish the document - transitions to Published state (if allowed)
     * @param document the document whose state is being changed
     */
    void publish(Document document);
    
    /**
     * Archive the document - transitions to Archived state (if allowed)
     * @param document the document whose state is being changed
     */
    void archive(Document document);
    
    /**
     * Revert the document - transitions back to Draft state (if allowed)
     * @param document the document whose state is being changed
     */
    void revert(Document document);
    
    /**
     * Get the current state name for display purposes
     * @return the name of the current state
     */
    String getStateName();
}
