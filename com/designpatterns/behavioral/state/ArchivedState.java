package com.designpatterns.behavioral.state;

/**
 * ConcreteState - Represents the Archived state of a document.
 * In this state, the document can only be restored to Published state.
 * Actions like publish and archive are not allowed.
 */
public class ArchivedState implements State {
    
    @Override
    public void publish(Document document) {
        // Publish is not allowed in Archived state
        System.out.println("ERROR: Cannot publish an archived document. Restore it first.");
    }
    
    @Override
    public void archive(Document document) {
        // Archive is not allowed in Archived state (already archived)
        System.out.println("ERROR: Document is already archived.");
    }
    
    @Override
    public void revert(Document document) {
        // Transition from Archived back to Published state
        System.out.println("Document is being restored to Published state...");
        
        // A key aspect of the state pattern is that concrete state objects are aware of other concrete state objects and can transition to other states as needed. In this case, the ArchivedState knows that it can transition back to PublishedState when the revert action is invoked.
        document.setState(new PublishedState());
    }
    
    @Override
    public String getStateName() {
        return "ARCHIVED";
    }
}
