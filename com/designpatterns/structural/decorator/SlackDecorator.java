package com.designpatterns.structural.decorator;

public class SlackDecorator extends BaseDecorator {

    public SlackDecorator(EmailNotifier wrapee) {
        super(wrapee);
    }

    @Override
    public void send() {
        System.out.println("Sending those Slack messages");
        super.send();
    }
}
