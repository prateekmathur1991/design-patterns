package com.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The base class that can encapsulate the common mechanism for all publishers, which could
 * involve (or not limited to) adding / removing subscribers, and notifying subscribers
 */
public abstract class AbstractBasePublisher implements Publisher {

    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void notifyListeners(String message) {
        for (Subscriber subscriber : this.subscribers) {
            subscriber.receive(message);
        }
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }
}