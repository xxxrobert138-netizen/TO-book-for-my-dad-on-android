package com.example.tobookformydad;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class CarsActivity extends AppCompatActivity {

    private List<String> userCars = new ArrayList<>();
    private ListView listView;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        userCars.add("Тойота");

        listView = findViewById(R.id.listCars);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, userCars);
        listView.setOnItemClickListener(CarsActivity.this::openCarInformation);

        listView.setAdapter(arrayAdapter);
    }
    public void addNewCar(View view) {
        Intent intent = new Intent(this, NewCarActivity.class);
        startActivity(intent);
        userCars.add(intent.getStringExtra("name"));
        updateListView();
    }

    public void openCarInformation(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, userCars.get(position), Toast.LENGTH_SHORT).show();
    }

    private void updateListView() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, userCars);
        listView.setAdapter(arrayAdapter);
    }
}