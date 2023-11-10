package com.example.trabalho_final_pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login_form extends AppCompatActivity {

    private TextView text_sing_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        this.getSupportActionBar().hide();
        StartComponents();

        text_sing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_form.this, SingUp_form.class);
                startActivity(intent);
            }
        });
    }
    private void StartComponents(){
        text_sing_up = findViewById(R.id.TextView_login_singup);
    }
}