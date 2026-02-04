package com.designpatterns.behavioral.memento;

/**
 * Originator - the object whose state we want to save and restore.
 *
 * It knows how to create a Memento capturing its current internal
 * state and how to restore its state from a given Memento.
 */
public class Originator {
    private String state;

    public Originator(String state) {
        this.state = state;
    }

    /**
     * Change internal state of the Originator.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Accessor for current state (for demonstration/logging only).
     */
    public String getState() {
        return state;
    }

    /**
     * Saves the current state inside a new Memento.
     */
    public Memento saveToMemento() {
        return new Memento(state);
    }

    /**
     * Restores the Originator's state from the provided Memento.
     */
    public void restoreFromMemento(Memento memento) {
        if (memento == null) {
            return;
        }
        this.state = memento.getState();
    }
}
