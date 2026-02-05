package com.designpatterns.behavioral.strategy;

/**
 * Context class - Maintains a reference to a strategy object and uses it
 * to perform the payment operation. The Order class is decoupled from the
 * specific payment implementations and can work with any strategy.
 */
public class Order {
    
    // The current payment strategy
    private PaymentStrategy paymentStrategy;
    
    // Order details
    private String orderId;
    private double totalAmount;
    private String items;
    
    /**
     * Constructor for creating an order
     * @param orderId unique identifier for the order
     * @param totalAmount the total amount to be paid
     * @param items description of items in the order
     */
    public Order(String orderId, double totalAmount, String items) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.items = items;
    }
    
    /**
     * Set the payment strategy to be used for this order.
     * This method allows the payment method to be changed at runtime.
     * @param strategy the payment strategy to use
     */
    public void setPaymentStrategy(PaymentStrategy strategy) {
        System.out.println("Selected payment method: " + strategy.getPaymentMethod());
        this.paymentStrategy = strategy;
    }
    
    /**
     * Process the payment using the current strategy.
     * The Order doesn't need to know HOW to pay, just delegates to the strategy.
     * @return true if payment was successful
     */
    public boolean checkout() {
        if (paymentStrategy == null) {
            System.out.println("ERROR: No payment strategy selected!");
            return false;
        }
        
        System.out.println("\n--- Processing Order: " + orderId + " ---");
        System.out.println("Items: " + items);
        System.out.println("Total: $" + String.format("%.2f", totalAmount));
        System.out.println();
        
        // Delegate payment processing to the current strategy
        return paymentStrategy.pay(totalAmount);
    }
    
    /**
     * Get the order ID
     * @return the order ID
     */
    public String getOrderId() {
        return orderId;
    }
    
    /**
     * Get the total amount for this order
     * @return the total amount
     */
    public double getTotalAmount() {
        return totalAmount;
    }
}
