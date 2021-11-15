package com.geektech.lesson1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Activity2 extends AppCompatActivity {

    private static final int GALLERY = 123;
    private static final int PHOTO = 731;
    private EditText name;
    private EditText password;
    private ImageView IV_Photo;
    private TextView open_galery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        initView();
        getInformation();

        open_galery.setOnClickListener(v ->{
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_PICK);
            startActivityForResult(intent, PHOTO);
        });

        IV_Photo.setOnClickListener(v ->{
            Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,GALLERY);
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY && resultCode == RESULT_OK && data != null) {
            Glide.with(this).load(data.getData().toString()).circleCrop().into(IV_Photo);
        }
        if (requestCode == PHOTO && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Glide.with(this).load(imageBitmap).circleCrop().into(IV_Photo);

        }
    }
    private void getInformation() {
        String name = getIntent().getStringExtra("key1");
        this.name.setText(name);
        String password = getIntent().getStringExtra("key2");
        this.password.setText(password);
    }

    private void initView() {
        name = findViewById(R.id.gmail_com);
        password = findViewById(R.id.parol);
        IV_Photo = findViewById(R.id.edit_foto);
        open_galery = findViewById((R.id.edit));
    }
}