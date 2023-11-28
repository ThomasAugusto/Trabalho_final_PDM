package com.example.trabalho_final_pdm;

import java.util.List;

public class Account{
    private String userId;
    private String typeKey;
    private String pixKey;
    private double balance;
    private List<Transaction> transactions;

    public Account(String userId, String typeKey, String pixKey, double balance, List<Transaction> transactions) {
        this.userId = userId;
        this.typeKey = typeKey;
        this.pixKey = pixKey;
        this.balance = balance;
        this.transactions = transactions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public String getPixKey() {
        return pixKey;
    }

    public void setPixKey(String pixKey) {
        this.pixKey = pixKey;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
