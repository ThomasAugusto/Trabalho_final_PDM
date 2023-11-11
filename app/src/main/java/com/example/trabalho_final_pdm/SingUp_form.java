package com.example.trabalho_final_pdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import kotlinx.coroutines.selects.TrySelectDetailedResult;

public class SingUp_form extends AppCompatActivity {

    private EditText edit_user,edit_email,edit_pass,edit_repass;
    private AppCompatButton btn_submit;
    String[]mensages = {"Por favor preencher todos os campos!",
                        "Por favor digitar senhar iguais!",
                        "Cadastro realizado com sucesso!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_form);
        this.getSupportActionBar().hide();
        StartComponents();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=edit_user.getText().toString();
                String email=edit_email.getText().toString();
                String pass=edit_pass.getText().toString();
                String repass=edit_repass.getText().toString();

                if (user.isEmpty() || email.isEmpty() || pass.isEmpty() || repass.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensages[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                    return;
                }
                if (!pass.equals(repass)){
                    Snackbar snackbar = Snackbar.make(v,mensages[1],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                    return;
                }
                Usersubimit(v);
            }
        });
    }

    private void Usersubimit(View v){
        String user=edit_user.getText().toString();
        String email=edit_email.getText().toString();
        String pass=edit_pass.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Snackbar snackbar = Snackbar.make(v,mensages[2],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                    Intent intent=new Intent(SingUp_form.this, Login_form.class);
                    startActivity(intent);
                }else {
                    String error;
                    try {

                    }
                }
            }
        })
    }
    private void StartComponents(){
        edit_user=findViewById(R.id.editText_singup_user);
        edit_email=findViewById(R.id.editText_singup_email);
        edit_pass=findViewById(R.id.editText_singup_pswd);
        edit_repass=findViewById(R.id.editText_singup_repswd);
        btn_submit=findViewById(R.id.Button_singup_submit);
    }
}