package com.example.trabalho_final_pdm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Account_form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_form);
        this.getSupportActionBar().hide();
    }
}