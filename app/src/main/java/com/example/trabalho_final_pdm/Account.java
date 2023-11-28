package com.example.trabalho_final_pdm;

import java.util.Date;
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

    public void deposito(double valor) {
        if (valor > 0) {
            balance += valor;
            transactions.add(new Transaction("Depósito", valor, new Date()));
            System.out.println("Depósito de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void retirar(double valor) {
        if (valor > 0 && balance >= valor) {
            balance -= valor;
            Transaction withdrawTransaction = new Transaction("Retirada", -valor, new Date());
            transactions.add(withdrawTransaction);
            System.out.println("Retirada de " + valor + " realizada com sucesso.");
        } else {
            System.out.println("Valor de retirada inválido ou saldo insuficiente.");
        }
    }

    public void extrato() {
        System.out.println("Extrato de transações:");

        if (transactions.isEmpty()) {
            System.out.println("Nenhuma transação disponível.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println("Tipo: " + transaction.getType() + ", Valor: " + transaction.getValue() + ", Data: " + transaction.getDate());
            }
        }
    }
}
