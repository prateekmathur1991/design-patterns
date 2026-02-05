package com.designpatterns.behavioral.observer;

public class Demo {

    public static void main(String[] args) {
        Subscriber subscriber = new ConcreteSubscriber();
        Publisher publisher = new ConcretePublisher();

        publisher.addSubscriber(subscriber);

        publisher.notifyListeners("That Message");
    }
}
