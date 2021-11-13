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
    private TextInputEditText username, password;
    private Button go;
    private ImageView car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClick();
        initView();
        initGlide();

    }

    private void onClick() {
        go.setOnClickListener(v -> {
           if (password.getText().toString().length()>=6 &&username.getText().toString().length()>=1){

           } else if (password.getText().toString().isEmpty() && username.getText().toString().isEmpty()) {
               username.setError(getString(R.string.erro_login));
               password.setError(getString(R.string.error_password));
           }else if(password.getText().toString().length()<6){
               password.setError(getString(R.string.error_password6));
           }else if(username.getText().toString().length()<1){
               username.setError(getString(R.string.error_user));

           }

        });
    }

    private void initGlide() {
        String URI = "https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg";
        Glide.with(MainActivity.this).load(URI).into(car);
    }

    private void initView() {
        username = findViewById(R.id.gg);
        password = findViewById(R.id.password);
        go = findViewById(R.id.go);
        car = findViewById(R.id.car);
    }

}











