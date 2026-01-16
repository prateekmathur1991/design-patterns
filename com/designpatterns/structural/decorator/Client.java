package com.designpatterns.structural.decorator;

public class Client {

    public static void main (String [] args) {

        EmailNotifier emailNotifier = new EmailNotifier();
        emailNotifier.send();

        System.out.println("-----");

        EmailNotifier smsAndEmailNotifier = new SMSDecorator(emailNotifier);
        smsAndEmailNotifier.send();

        System.out.println("-----");

        EmailNotifier slackAndEmailNotifier = new SlackDecorator(emailNotifier);
        slackAndEmailNotifier.send();

        System.out.println("-----");

        EmailNotifier slackAndSmsNotifier = new SlackDecorator(new SMSDecorator(emailNotifier));
        slackAndSmsNotifier.send();
    }
}
