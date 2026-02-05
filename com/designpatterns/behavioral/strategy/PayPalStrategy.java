package com.designpatterns.behavioral.strategy;

/**
 * ConcreteStrategy - Implements the PaymentStrategy for PayPal payments.
 * This strategy encapsulates the algorithm for processing PayPal payments.
 */
public class PayPalStrategy implements PaymentStrategy {
    
    private String email;
    private String password;
    
    /**
     * Constructor for PayPal strategy
     * @param email the PayPal account email
     * @param password the PayPal account password
     */
    public PayPalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean pay(double amount) {
        // Simulate PayPal payment processing
        System.out.println("Processing PayPal payment...");
        System.out.println("PayPal Account: " + maskEmail(email));
        System.out.println("Amount: $" + String.format("%.2f", amount));
        
        // Simulate authentication and payment
        if (authenticatePayPal()) {
            System.out.println("✓ PayPal payment of $" + String.format("%.2f", amount) + " successful!");
            return true;
        } else {
            System.out.println("✗ PayPal payment failed!");
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
    
    /**
     * Authenticate with PayPal servers
     * @return true if authentication is successful
     */
    private boolean authenticatePayPal() {
        // Simulate PayPal authentication
        return email != null && !email.isEmpty() && password != null && !password.isEmpty();
    }
    
    /**
     * Mask the email for security
     * @param email the full email address
     * @return the masked email
     */
    private String maskEmail(String email) {
        if (email == null || !email.contains("@")) return "***@***";
        String[] parts = email.split("@");
        String local = parts[0].length() > 2 ? parts[0].charAt(0) + "***" : "***";
        return local + "@" + parts[1];
    }
}
