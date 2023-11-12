package com.example.trabalho_final_pdm;

public class Users {
    protected String name;
    protected int password;

    public Users() {
    }

    public Users(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
