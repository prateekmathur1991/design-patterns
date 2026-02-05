package com.designpatterns.behavioral.strategy;

/**
 * Demo class - Demonstrates the Strategy design pattern in action.
 * Shows how different payment strategies can be selected and used interchangeably
 * without changing the Order class code.
 * 
 * The Strategy pattern defines a family of algorithms (payment methods),
 * encapsulates each one, and makes them interchangeable.
 * It lets the algorithm vary independently from clients that use it.
 */
public class Demo {
    
    public static void main(String[] args) {
        System.out.println("=== Strategy Design Pattern Demo ===");
        System.out.println("Payment Processing System\n");
        
        // Create orders
        Order order1 = new Order("ORD-001", 99.99, "Laptop, Mouse, Keyboard");
        Order order2 = new Order("ORD-002", 45.50, "Headphones, USB Cable");
        Order order3 = new Order("ORD-003", 150.00, "Monitor, HDMI Cable");
        
        // --- STRATEGY 1: CREDIT CARD ---
        System.out.println("========== PAYMENT WITH CREDIT CARD ==========");
        PaymentStrategy creditCardPayment = new CreditCardStrategy("1234567890123456", "123", "12/25");
        order1.setPaymentStrategy(creditCardPayment);
        order1.checkout();
        System.out.println();
        
        // --- STRATEGY 2: PAYPAL ---
        System.out.println("========== PAYMENT WITH PAYPAL ==========");
        PaymentStrategy paypalPayment = new PayPalStrategy("user@example.com", "secure_password");
        order2.setPaymentStrategy(paypalPayment);
        order2.checkout();
        System.out.println();
        
        // --- STRATEGY 3: CRYPTOCURRENCY ---
        System.out.println("========== PAYMENT WITH CRYPTOCURRENCY ==========");
        PaymentStrategy cryptoPayment = new CryptoStrategy("1A1z7agoat1GTtWQD5z1AGW5QJqWhRE1Y5", "privatekey123");
        order3.setPaymentStrategy(cryptoPayment);
        order3.checkout();
        System.out.println();
        
        // --- CHANGING STRATEGY AT RUNTIME ---
        System.out.println("========== CHANGING STRATEGY AT RUNTIME ==========");
        System.out.println("Order 1 customer wants to change payment method to PayPal");
        order1.setPaymentStrategy(paypalPayment);
        order1.checkout();
        System.out.println();
        
        // --- MULTIPLE ORDERS WITH SAME STRATEGY ---
        System.out.println("========== MULTIPLE ORDERS WITH DIFFERENT STRATEGIES ==========");
        Order order4 = new Order("ORD-004", 75.25, "Keyboard");
        Order order5 = new Order("ORD-005", 120.00, "Monitor");
        
        System.out.println("Order 4 and Order 5 both using Credit Card:");
        order4.setPaymentStrategy(creditCardPayment);
        order4.checkout();
        System.out.println();
        
        order5.setPaymentStrategy(creditCardPayment);
        order5.checkout();
        System.out.println();
        
        // --- ERROR HANDLING ---
        System.out.println("========== ERROR HANDLING ==========");
        Order order6 = new Order("ORD-006", 50.00, "USB Hub");
        System.out.println("Attempting to checkout without selecting payment strategy:");
        order6.checkout();
        System.out.println();
        
        System.out.println("=== Demo Complete ===");
        System.out.println("\nKey Benefits of Strategy Pattern:");
        System.out.println("1. Algorithms are encapsulated independently");
        System.out.println("2. Strategies can be selected at runtime");
        System.out.println("3. Easy to add new payment methods without modifying existing code");
        System.out.println("4. Order class is independent of payment implementation details");
    }
}
