package com.example.trabalho_final_pdm;

public class Account extends Users{
    private double balance;
    private String pixkey;

    public Account(double balance, String pixkey) {
        this.balance = balance;
        this.pixkey = pixkey;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPixkey() {
        return pixkey;
    }

    public void setPixkey(String pixkey) {
        this.pixkey = pixkey;
    }
}
