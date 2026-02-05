package com.designpatterns.behavioral.state;

/**
 * ConcreteState - Represents the Published state of a document.
 * In this state, the document can be archived or reverted to draft.
 * Action like publish is not allowed (already published).
 */
public class PublishedState implements State {
    
    @Override
    public void publish(Document document) {
        // Publish is not allowed in Published state (already published)
        System.out.println("ERROR: Document is already published.");
    }
    
    @Override
    public void archive(Document document) {
        // Transition from Published to Archived state
        System.out.println("Document is being archived...");
        document.setState(new ArchivedState());
    }
    
    @Override
    public void revert(Document document) {
        // Transition from Published back to Draft state
        System.out.println("Document is being reverted to Draft...");
        document.setState(new DraftState());
    }
    
    @Override
    public String getStateName() {
        return "PUBLISHED";
    }
}
