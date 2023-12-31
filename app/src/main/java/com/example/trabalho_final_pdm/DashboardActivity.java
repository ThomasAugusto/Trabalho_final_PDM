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

public class DashboardActivity extends AppCompatActivity {
TextView text_welcome;
AppCompatButton btn_account,btn_pix,btn_logof;
FirebaseFirestore db = FirebaseFirestore.getInstance();
String userID;
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
        btn_pix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, List_Pix_Activity.class);
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
    private void StartComponents(){
        text_welcome = findViewById(R.id.TextView_dashboard_hello);
        btn_account = findViewById(R.id.button_dashboard_account);
        btn_pix = findViewById(R.id.button_dashboard_pix);
        btn_logof = findViewById(R.id.button_dashboar_singout);
    }
}