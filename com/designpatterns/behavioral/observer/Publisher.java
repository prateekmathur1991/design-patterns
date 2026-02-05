package com.designpatterns.behavioral.observer;

/** 
 * The base interface that every publisher should implement, should present methods that allow 
 * tracking the list of subscribers, and notifying subscribers
 */
public interface Publisher {

    void notifyListeners(String message);

    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);
}
