package com.designpatterns.structural.decorator;

/**
 * The behaviour of this component can be dynamically augmented by decorators.
 */
public class EmailNotifier {

    public void send() {
        System.out.println("Sending those emails");
    }

}
