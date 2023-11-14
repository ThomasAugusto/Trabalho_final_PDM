package com.example.trabalho_final_pdm;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Account_form extends AppCompatActivity {

Spinner spinner;
EditText edit_text;
AppCompatButton btn_submib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_form);
        this.getSupportActionBar().hide();
        StartComponents();


    }

    private void StartComponents(){
        spinner=findViewById(R.id.account_spinner);
        edit_text=findViewById(R.id.editText_account);
        btn_submib=findViewById(R.id.button_account_register);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Account_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}