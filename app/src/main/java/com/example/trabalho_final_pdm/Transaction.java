package com.example.trabalho_final_pdm;

import java.util.Date;

public class Transaction {
    private String type;
    private double value;
    private Date date;

    public Transaction(String type, double value, Date date) {
        this.type = type;
        this.value = value;
        this.date = this.date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
