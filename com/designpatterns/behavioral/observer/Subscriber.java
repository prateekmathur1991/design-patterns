package com.designpatterns.behavioral.observer;

/**
 * The base interface every subsriber should implement. Should have at-least 1 method that allows
 * for receiving a message
 */
public interface Subscriber {

    void receive(String message);
}
