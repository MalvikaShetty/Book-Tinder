package com.example.booktinder;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class Dashboard extends AppCompatActivity {

    // creating variables for our list view.
    private ListView coursesLV;

    // creating a new array list.
    ArrayList<String> booksArrayList;

    // creating a variable for database reference.
    DatabaseReference reference;
    private static final String TAG = "Dashboard";
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(Color.parseColor("#F1C0A0"));
        getWindow().setNavigationBarColor(Color.parseColor("#F1C0A0"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_list);
        findViewById(R.id.openFormAct).setOnClickListener(v -> {
            startActivity(new Intent(this, FormActivity.class));
        });

        // initializing variables for listviews.
        coursesLV = findViewById(R.id.listView);

        // initializing our array list
        booksArrayList = new ArrayList<String>();

        // calling a method to get data from
        // Firebase and set data to list view
        reference = FirebaseDatabase.getInstance().getReference().child("PostData");
        initializeListView();

    }

    private void initializeListView() {
        adapter = new ArrayAdapter<>(Dashboard.this, android.R.layout.simple_dropdown_item_1line, booksArrayList);

        coursesLV.setAdapter(adapter);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> ds = snapshot.getChildren();
                booksArrayList.clear();
                for (DataSnapshot d : ds) {
                    HashMap<Object, String> hs = (HashMap<Object, String>) d.getValue();
                    booksArrayList.add(hs.get("book"));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}