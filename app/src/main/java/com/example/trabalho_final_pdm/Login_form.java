package com.example.trabalho_final_pdm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login_form extends AppCompatActivity {

    private TextView text_sing_up;
    private EditText text_email,text_password;
    private AppCompatButton btn_sing_in;
    private ProgressBar progress_bar;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String userID;
    String[]mensages = {"Por favor preencher todos os campos!",
                        "Login realizado com sucesso!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        this.getSupportActionBar().hide();
        StartComponents();

        btn_sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = text_email.getText().toString();
                String pass = text_password.getText().toString();

                if (email.isEmpty() || pass.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensages[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                    return;
                }
                AuthUser(v);
            }
        });

        text_sing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_form.this, SingUp_form.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void AuthUser(View v){
        String email = text_email.getText().toString();
        String pass = text_password.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Snackbar snackbar = Snackbar.make(v,mensages[1],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                    Hidekeyboard(v);
                    Progressbar();
                    FreezeComponents();
                }else {
                    String error;
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        error = "Por favor digite um E-mail válido";

                    }catch (Exception e){
                        error = "Usuário ou senha inválidos";
                    }
                    Snackbar snackbar = Snackbar.make(v,error,Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });

    }
    private void Progressbar(){
        progress_bar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                CheckPixKey();
            }
        },3000);
    }
    private void CheckPixKey(){
        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference useraccount = db.collection("accounts").document(userID);
        useraccount.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()){
                        Intent intent = new Intent(Login_form.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Intent intent = new Intent(Login_form.this, Account_form.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }
    private void Hidekeyboard(View v){
        if (v != null){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
        }
    }
    private void FreezeComponents(){
        text_sing_up.setClickable(false);
        text_email.setClickable(false);
        text_password.setClickable(false);
        btn_sing_in.setClickable(false);
    }
    private void StartComponents(){
        text_sing_up = findViewById(R.id.TextView_login_singup);
        text_email = findViewById(R.id.editText_login_user);
        text_password = findViewById(R.id.editText_login_pswd);
        btn_sing_in = findViewById(R.id.button_login_singin);
        progress_bar = findViewById(R.id.login_progressbar);
    }
}