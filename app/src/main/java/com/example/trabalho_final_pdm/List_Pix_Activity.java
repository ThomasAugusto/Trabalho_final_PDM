package com.example.trabalho_final_pdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho_final_pdm.model.PixList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class List_Pix_Activity extends AppCompatActivity {

    private PixAdapter pixAdapter;
    Button recycler_btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pix);
        this.getSupportActionBar().hide();


        RecyclerView recyclerView = findViewById(R.id.recycler_pix_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pixAdapter = new PixAdapter(new ArrayList<>(PixList.fakePixs()));
        recyclerView.setAdapter(pixAdapter);

        FloatingActionButton recycler_btn_add = findViewById(R.id.recycler_btn_add);
        recycler_btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List_Pix_Activity.this, Account_form.class);
                startActivity(intent);
                //finish();
            }
        });
    }
}
