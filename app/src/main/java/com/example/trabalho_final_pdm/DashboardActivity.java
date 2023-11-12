package com.example.trabalho_final_pdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {
TextView text_welcome;
AppCompatButton btn_account,btn_pix,btn_logof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.getSupportActionBar().hide();
        StartComponents();

        btn_logof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(DashboardActivity.this, Login_form.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void StartComponents(){
        text_welcome = findViewById(R.id.TextView_dashboard_hello);
        btn_account = findViewById(R.id.Button_dashboard_account);
        btn_pix = findViewById(R.id.Button_dashboard_pix);
        btn_logof = findViewById(R.id.Button_dashboar_singout);
    }
}