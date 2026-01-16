package com.designpatterns.structural.decorator;

/** 
 * A concrete decorator that adds SMS notification behaviour to the wrapped component.
 */
public class SMSDecorator extends BaseDecorator {

    public SMSDecorator(EmailNotifier wrapee) {
        super(wrapee);
    }

    @Override
    public void send() {
        System.out.println("Sending those SMS");
        super.send();
    }
}
