package com.example.trabalho_final_pdm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SingUp_form extends AppCompatActivity {

    private EditText edit_user,edit_email,edit_pass,edit_repass;
    private AppCompatButton btn_submit;
    private ProgressBar progress_bar;
    String[]mensages = {"Por favor preencher todos os campos!",
                        "Por favor digitar senhar iguais!",
                        "Cadastro realizado com sucesso!"};
    String userID;
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
                Loginsubimit(v);
            }
        });
    }


    private void Loginsubimit(View v){
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
                    Usersubimit();
                    Hidekeyboard(v);
                    Progressbar();
                    FreezeComponents();

                }else {
                    String error;
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        error = "A senha deve ter no mínimo 6 dígitos";
                    }catch (FirebaseAuthUserCollisionException e) {
                        error = "Este email já está em uso";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        error = "E-mail digitado é inválido";
                    }catch (Exception e){
                        error = "Falha ao cadastrar usuário";
                    }
                    Snackbar snackbar = Snackbar.make(v,error,Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });
    }
    private void Usersubimit(){
        String user=edit_user.getText().toString();
        int pass= Integer.parseInt(edit_pass.getText().toString());
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        userID=FirebaseAuth.getInstance().getCurrentUser().getUid();

        Users users = new Users(user,pass);
        DocumentReference documentReference = db.collection("users").document(userID);
        documentReference.set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("db","Success in data");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("db","Fail in data");
            }
        });
    }
    private void Progressbar(){
        progress_bar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SingUp_form.this, Login_form.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
    private void Hidekeyboard(View v){
        if (v != null){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
        }
    }
    private void FreezeComponents(){
        edit_user.setClickable(false);
        edit_email.setClickable(false);
        edit_pass.setClickable(false);
        edit_repass.setClickable(false);
        btn_submit.setClickable(false);
    }
    private void StartComponents(){
        edit_user=findViewById(R.id.editText_singup_user);
        edit_email=findViewById(R.id.editText_singup_email);
        edit_pass=findViewById(R.id.editText_singup_pswd);
        edit_repass=findViewById(R.id.editText_singup_repswd);
        btn_submit=findViewById(R.id.button_singup_submit);
        progress_bar=findViewById(R.id.singup_progressbar);
    }
}