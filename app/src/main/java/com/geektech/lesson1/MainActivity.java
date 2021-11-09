package com.geektech.lesson1;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {

    private TextInputEditText Username, Password;
    private Button GO;
    private ImageView car;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.gg);
        Password = findViewById(R.id.password);
        GO = findViewById(R.id.go);
        car = findViewById(R.id.car);
        Log.d("oooo", "onCreate");

        String URI = "https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg";
        Glide.with(MainActivity.this).load(URI).into(car);
    }

}











