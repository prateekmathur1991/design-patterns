package com.designpatterns.behavioral.strategy;

/**
 * Strategy interface - defines the contract for all concrete payment strategies.
 * The Strategy pattern uses composition instead of inheritance to vary behavior.
 * Each concrete strategy implements a different payment method.
 */
public interface PaymentStrategy {
    
    /**
     * Process a payment with the specific payment method
     * @param amount the amount to pay
     * @return true if payment was successful, false otherwise
     */
    boolean pay(double amount);
    
    /**
     * Get a description of the payment method
     * @return the payment method name
     */
    String getPaymentMethod();
}
