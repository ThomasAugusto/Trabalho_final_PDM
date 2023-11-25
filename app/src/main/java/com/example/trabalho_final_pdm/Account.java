package com.example.trabalho_final_pdm;

public class Account{
    private double balance;
    private String type_key;
    private String pixkey;
    private String conta;
    private String saldo;


    public Account() {
    }

    public Account(double balance, String type_key, String pixkey) {
        this.balance = balance;
        this.type_key = type_key;
        this.pixkey = pixkey;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType_key() {
        return type_key;
    }

    public void setType_key(String type_key) {
        this.type_key = type_key;
    }

    public String getPixkey() {
        return pixkey;
    }

    public void setPixkey(String pixkey) {
        this.pixkey = pixkey;
    }

    public String getConta() {return conta;}

    public void setConta(String conta) {this.conta = conta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
}
