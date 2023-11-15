package com.example.trabalho_final_pdm;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.santalu.maskara.Mask;
import com.santalu.maskara.MaskChangedListener;
import com.santalu.maskara.MaskStyle;

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

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectOP = (String) parent.getItemAtPosition(position);
                afterSpinnerChange(selectOP);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void afterSpinnerChange(String selectOP){
        if (selectOP.equals("CPF")){
            MaskCPF();
        }else {
            MasknumPhone();
        }
    }

    private void MaskCPF(){
            Mask mask = new Mask(
                    "___.___.___-__",
                    '_',
                    MaskStyle.NORMAL
            );
            MaskChangedListener listener = new MaskChangedListener(mask);
            edit_text.setText("");
            edit_text.removeTextChangedListener(listener);
            edit_text.addTextChangedListener(listener);
            edit_text.setHint("Numero de CPF");
    }
    private void MasknumPhone(){
            Mask mask = new Mask(
                    "(__) _____-____",
                    '_',
                    MaskStyle.NORMAL
            );
            MaskChangedListener listener = new MaskChangedListener(mask);
            edit_text.setText("");
            edit_text.removeTextChangedListener(listener);
            edit_text.addTextChangedListener(listener);
            edit_text.setHint("Numero com DDD");
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