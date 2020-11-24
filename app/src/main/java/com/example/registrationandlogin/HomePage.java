package com.example.registrationandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    Button logout;
    private GridView gridView;
    private int [] food = new int[] {
            R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4, R.drawable.food5,
            R.drawable.food6
    };

    private String [] names = new String[] {"Doughnut", "Steak", "Cookie", "Pizza", "Salmon", "Ramen"};
    private String [] prices = new String[] {"RM 15", "RM 60", "RM10", "RM25", "RM 35", "RM 19"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        gridView = findViewById(R.id.mygrid);
        MyAdapter gridArrayAdapter = new MyAdapter(this, R.layout.griditem, food, names, prices);
        gridView.setAdapter(gridArrayAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(HomePage.this, names[position] + " " + prices[position] +
                        " Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        logout = (Button) findViewById(R.id.buttonLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, LoginPage.class);
                startActivity(intent);
            }
        });
    }
}