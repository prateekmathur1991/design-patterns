package com.designpatterns.behavioral.strategy;

/**
 * ConcreteStrategy - Implements the PaymentStrategy for cryptocurrency payments.
 * This strategy encapsulates the algorithm for processing cryptocurrency transactions.
 */
public class CryptoStrategy implements PaymentStrategy {
    
    private String walletAddress;
    private String privateKey;
    
    /**
     * Constructor for cryptocurrency strategy
     * @param walletAddress the cryptocurrency wallet address
     * @param privateKey the wallet private key (simplified for demo)
     */
    public CryptoStrategy(String walletAddress, String privateKey) {
        this.walletAddress = walletAddress;
        this.privateKey = privateKey;
    }
    
    @Override
    public boolean pay(double amount) {
        // Simulate cryptocurrency payment processing
        System.out.println("Processing cryptocurrency payment...");
        System.out.println("Wallet Address: " + maskWalletAddress(walletAddress));
        System.out.println("Amount: $" + String.format("%.2f", amount));
        System.out.println("Converting to BTC at current exchange rate...");
        
        // Simulate blockchain transaction
        if (validateWallet()) {
            double btcAmount = amount / 43000; // Simplified conversion rate
            System.out.println("Transaction: " + String.format("%.6f", btcAmount) + " BTC");
            System.out.println("✓ Cryptocurrency payment of $" + String.format("%.2f", amount) + " successful!");
            return true;
        } else {
            System.out.println("✗ Cryptocurrency payment failed!");
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "Cryptocurrency (BTC)";
    }
    
    /**
     * Validate the cryptocurrency wallet
     * @return true if wallet is valid
     */
    private boolean validateWallet() {
        // Simple wallet validation check
        return walletAddress != null && walletAddress.length() > 20 && 
               privateKey != null && !privateKey.isEmpty();
    }
    
    /**
     * Mask the wallet address for security
     * @param address the full wallet address
     * @return the masked wallet address
     */
    private String maskWalletAddress(String address) {
        if (address == null || address.length() < 8) return "****";
        return address.substring(0, 4) + "..." + address.substring(address.length() - 4);
    }
}
