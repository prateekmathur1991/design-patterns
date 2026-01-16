package com.designpatterns.structural.decorator;

/**
 * All concrete decorators can extend this base decorator, and call super.send() to
 * execute the wrapped component's behaviour, in addition to the new behaviour added by the decorator.
 * 
 * Also important to note that the decorator implements the same interface as the component it wraps,
 * which is what makes the decorator different from a simple wrapper.
 */
public abstract class BaseDecorator extends EmailNotifier {

    private EmailNotifier wrapee;

    public BaseDecorator(EmailNotifier wrapee) {
        this.wrapee = wrapee;
    }

    @Override
    public void send() {
        this.wrapee.send();
    }
}
