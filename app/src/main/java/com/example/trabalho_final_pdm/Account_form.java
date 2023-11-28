package com.example.trabalho_final_pdm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho_final_pdm.databinding.ActivityAccountFormBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Account_form extends AppCompatActivity {

    private ActivityAccountFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_form);
        this.getSupportActionBar().hide();
        binding = ActivityAccountFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        StartComponents();

        binding.accountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectOP = (String) parent.getItemAtPosition(position);
                afterSpinnerChange(selectOP);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.buttonAccountRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type_key = (String) binding.accountSpinner.getSelectedItem();
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

                if (type_key.equals("CPF")){
                    get_value_CPF(v,type_key,userId);
                }else {
                    get_value_numPhone(v,type_key,userId);
                }
            }
        });
    }

    private void get_value_CPF(View v, String type_key,String userId){
        boolean isDone = binding.editTextAccountCPF.isDone();
        String pix_key = binding.editTextAccountCPF.getMasked();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        double balance = 0;
        List<Transaction> transactions = new ArrayList<>();
        if (isDone){
            Account account = new Account(userId, type_key, pix_key, balance, transactions);
            DocumentReference documentReference = db.collection("accounts").document(userId);
            documentReference.set(account).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Log.d("db","Success in data");
                    Log.d("db","Success in data");
                    Snackbar snackbar = Snackbar.make(v,"Chave PIX cadastrada com sucesso",Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    Hidekeyboard(v);
                    snackbar.show();
                    Intent intent = new Intent(Account_form.this, DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("db","Fail in data");
                }
            });
        }else {
            Snackbar snackbar = Snackbar.make(v,"Por favor digite um CPF válido",Snackbar.LENGTH_SHORT);
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            Hidekeyboard(v);
            snackbar.show();
        }
    }
    private void get_value_numPhone(View v, String type_key,String userId){
        boolean isDone = binding.editTextAccountNumPhone.isDone();
        String pix_key = binding.editTextAccountNumPhone.getMasked();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        double balance = 0;
        List<Transaction> transactions = new ArrayList<>();
        if (isDone){
            Account account = new Account(userId, type_key, pix_key, balance, transactions);
            DocumentReference documentReference = db.collection("accounts").document(userId);
            documentReference.set(account).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Log.d("db","Success in data");
                    Snackbar snackbar = Snackbar.make(v,"Chave PIX cadastrada com sucesso",Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    Hidekeyboard(v);
                    snackbar.show();
                    Intent intent = new Intent(Account_form.this, DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("db","Fail in data");
                }
            });
        }else {
            Snackbar snackbar = Snackbar.make(v,"Por favor digite um telefone válido",Snackbar.LENGTH_SHORT);
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            Hidekeyboard(v);
            snackbar.show();
        }
    }
    private void afterSpinnerChange(String selectOP){
        if (selectOP.equals("CPF")){
            MaskCPF();
        }else {
            MasknumPhone();
        }
    }

    private void MaskCPF(){
        binding.editTextAccountNumPhone.setClickable(false);
        binding.editTextAccountNumPhone.setVisibility(View.INVISIBLE);
        binding.editTextAccountCPF.setText("");
        binding.editTextAccountCPF.setClickable(true);
        binding.editTextAccountCPF.setVisibility(View.VISIBLE);
    }
    private void MasknumPhone(){
        binding.editTextAccountCPF.setClickable(false);
        binding.editTextAccountCPF.setVisibility(View.INVISIBLE);
        binding.editTextAccountNumPhone.setText("");
        binding.editTextAccountNumPhone.setClickable(true);
        binding.editTextAccountNumPhone.setVisibility(View.VISIBLE);
    }
    private void Hidekeyboard(View v) {
        if (v != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    private void StartComponents(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Account_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.accountSpinner.setAdapter(adapter);
    }
}
