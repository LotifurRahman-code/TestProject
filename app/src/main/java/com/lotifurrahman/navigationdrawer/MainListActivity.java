package com.lotifurrahman.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainListActivity extends AppCompatActivity{
    RecyclerView recyclerView;

    MyDBHelper myDBHelper;
    ArrayList<MainList> arrayList;
    MainAdapter adapterSurahList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        myDBHelper = new MyDBHelper(this);

        arrayList = new ArrayList<>();
        LoadSuahList();
    }

    private void LoadSuahList()
    {
        recyclerView = findViewById(R.id.recyclerView_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList = myDBHelper.getAllSuraList();

        adapterSurahList = new MainAdapter(this, arrayList);
        recyclerView.setAdapter(adapterSurahList);
    }


}
