package com.designpatterns.behavioral.observer;

public class ConcreteSubscriber implements Subscriber {

    @Override
    public void receive(String message) {
        System.out.println("Received the message:  " + message);
    }
}
