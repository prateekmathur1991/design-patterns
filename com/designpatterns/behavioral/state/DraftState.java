package com.designpatterns.behavioral.state;

/**
 * ConcreteState - Represents the Draft state of a document.
 * In this state, the document can be published or deleted.
 * Actions like archive and revert are not allowed.
 */
public class DraftState implements State {
    
    @Override
    public void publish(Document document) {
        // Transition from Draft to Published state
        System.out.println("Document is being published...");
        document.setState(new PublishedState());
    }
    
    @Override
    public void archive(Document document) {
        // Archive is not allowed in Draft state
        System.out.println("ERROR: Cannot archive a document in Draft state. Publish it first.");
    }
    
    @Override
    public void revert(Document document) {
        // Revert is not allowed in Draft state (already in draft)
        System.out.println("ERROR: Document is already in Draft state.");
    }
    
    @Override
    public String getStateName() {
        return "DRAFT";
    }
}
