package com.designpatterns.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Caretaker - keeps track of Memento objects. It never examines
 * the contents of a Memento, preserving encapsulation of the
 * Originator's internal state.
 */
public class Caretaker {
    private final List<Memento> mementos = new ArrayList<>();

    /**
     * Stores a Memento for later retrieval.
     */
    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    /**
     * Returns a previously stored Memento by index.
     */
    public Memento getMemento(int index) {
        return mementos.get(index);
    }

    /**
     * Convenience: how many snapshots are stored.
     */
    public int size() {
        return mementos.size();
    }
}
