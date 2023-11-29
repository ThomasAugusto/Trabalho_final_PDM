package com.example.trabalho_final_pdm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.snackbar.Snackbar;

public class Modulo_Geral_Deposito extends AppCompatActivity {

    AppCompatButton btn_deposit;
    EditText setValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_geral_deposito);
        startComponents();
        this.getSupportActionBar().hide();

        btn_deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double valor = Double.valueOf(setValue.getText().toString());
                if (valor <= 0){
                    Snackbar snackbar = Snackbar.make(v,"Por favor digite um valor válido",Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                    return;
                }

            }
        });
    }
    private void startComponents(){
        btn_deposit = findViewById(R.id.confirm_deposito);
        setValue = findViewById(R.id.input_deposito_value);
    }
}