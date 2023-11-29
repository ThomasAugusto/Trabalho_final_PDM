package com.example.trabalho_final_pdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Modulo_Geral extends AppCompatActivity {

    TextView text_welcome;
    AppCompatButton deposito_btn_account, retirada_btn_account, extrato_btn_account, btnVoltar;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_geral);
        this.getSupportActionBar().hide();
        StartComponents();

        deposito_btn_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Modulo_Geral.this, Modulo_Geral_Deposito.class);
                startActivity(intent);
                finish();
            }
        });

        retirada_btn_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Modulo_Geral.this, Modulo_Geral_Retirada.class);
                startActivity(intent);
                finish();
            }
        });

        extrato_btn_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Modulo_Geral.this, Modulo_Geral_Extrato.class);
                startActivity(intent);
                finish();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Modulo_Geral.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference username = db.collection("users").document(userID);
        username.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (value != null){
                    String name = value.getString("name");
                    text_welcome.setText("Olá, " + name);
                }
            }
        });
    }


    private void StartComponents() {
        text_welcome = findViewById(R.id.TextView_dashboard_hello);
        deposito_btn_account = findViewById(R.id.deposito_btn_account);
        retirada_btn_account = findViewById(R.id.retirada_btn_account);
        extrato_btn_account = findViewById(R.id.extrato_btn_account);
        btnVoltar = findViewById(R.id.btn_voltar1);
    }


}