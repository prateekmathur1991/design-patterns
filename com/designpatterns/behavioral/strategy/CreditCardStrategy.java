package com.designpatterns.behavioral.strategy;

/**
 * ConcreteStrategy - Implements the PaymentStrategy for credit card payments.
 * This strategy encapsulates the algorithm for processing credit card payments.
 */
public class CreditCardStrategy implements PaymentStrategy {
    
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    
    /**
     * Constructor for credit card strategy
     * @param cardNumber the credit card number
     * @param cvv the card verification value
     * @param expiryDate the card expiry date
     */
    public CreditCardStrategy(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    
    @Override
    public boolean pay(double amount) {
        // Simulate credit card payment processing
        System.out.println("Processing credit card payment...");
        System.out.println("Card Number: " + maskCardNumber(cardNumber));
        System.out.println("Amount: $" + String.format("%.2f", amount));
        
        // Simulate validation and processing
        if (validateCard()) {
            System.out.println("✓ Credit card payment of $" + String.format("%.2f", amount) + " successful!");
            return true;
        } else {
            System.out.println("✗ Credit card payment failed!");
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
    
    /**
     * Validate the credit card details
     * @return true if card is valid
     */
    private boolean validateCard() {
        // Simple validation check
        return cardNumber.length() == 16 && cvv.length() == 3;
    }
    
    /**
     * Mask the card number for security (show only last 4 digits)
     * @param cardNumber the full card number
     * @return the masked card number
     */
    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() < 4) return "****";
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }
}
