package com.designpatterns.behavioral.memento;

/**
 * Memento - a snapshot of the Originator's internal state.
 *
 * The Memento is immutable from the outside. Only the Originator
 * should access its contents to restore state; other objects (like
 * the Caretaker) keep it but do not inspect or modify it.
 */
public final class Memento {
    private final String state;

    /**
     * Package-private or public constructor depending on access policy.
     * Keeping it public here for simplicity, but the class is final
     * and the field is private and final — preserving immutability.
     */
    public Memento(String state) {
        this.state = state;
    }

    /**
     * Returns the saved state. Originator will use this to restore.
     */
    public String getState() {
        return state;
    }
}
