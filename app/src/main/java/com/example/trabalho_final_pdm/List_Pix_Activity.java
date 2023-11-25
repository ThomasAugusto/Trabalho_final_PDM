package com.example.trabalho_final_pdm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho_final_pdm.model.PixList;

import java.util.ArrayList;

public class List_Pix_Activity extends AppCompatActivity {

    private PixAdapter pixAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pix);
        this.getSupportActionBar().hide();


        RecyclerView recyclerView = findViewById(R.id.recycler_pix_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pixAdapter = new PixAdapter(new ArrayList<>(PixList.fakePixs()));
        recyclerView.setAdapter(pixAdapter);
    }

}