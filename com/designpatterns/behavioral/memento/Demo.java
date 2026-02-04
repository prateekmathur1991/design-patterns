package com.designpatterns.behavioral.memento;

/**
 * Demo (client) showing how to use the Memento pattern.
 *
 * Roles:
 * - Originator: the object whose state we save/restore (`Originator`).
 * - Memento: the immutable snapshot object (`Memento`).
 * - Caretaker: stores snapshots without inspecting them (`Caretaker`).
 */
public class Demo {
    public static void main(String[] args) {
        Originator originator = new Originator("State #1");
        Caretaker caretaker = new Caretaker();

        System.out.println("Initial state: " + originator.getState());

        // Save the first state
        caretaker.addMemento(originator.saveToMemento());

        // Change state and save again
        originator.setState("State #2");
        caretaker.addMemento(originator.saveToMemento());

        // Change state without saving
        originator.setState("State #3");
        System.out.println("Current state: " + originator.getState());

        // Restore to previous state (#2)
        originator.restoreFromMemento(caretaker.getMemento(1));
        System.out.println("Restored to: " + originator.getState());

        // Restore to original state (#1)
        originator.restoreFromMemento(caretaker.getMemento(0));
        System.out.println("Restored to: " + originator.getState());

        // Output explanation:
        // - Caretaker never peeked at the state string; it only stored Mementos.
        // - Originator is responsible for creating and consuming Mementos.
    }
}
