package com.example.trabalho_final_pdm;

public class Account extends Users{
    private double balance;
    private int pixkey;

    public Account(double balance, int pixkey) {
        this.balance = balance;
        this.pixkey = pixkey;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPixkey() {
        return pixkey;
    }

    public void setPixkey(int pixkey) {
        this.pixkey = pixkey;
    }
}
