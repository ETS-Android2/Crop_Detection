package com.example.cropdetection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean CAMERA_PERMISSION = false;
    private boolean READ_PERMISSION = false;
    private boolean WRITE_PERMISSION = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askCameraPermission();
        askStorageReadPermission();
        askStorageWritePermission();
    }

    public void captureImage(View view){
        Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, Prediction.class));
    }

    public void askCameraPermission(){
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){

        }else{
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 101);

            if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
                CAMERA_PERMISSION = true;
            else
                CAMERA_PERMISSION = false;
        }
    }

    public void askStorageWritePermission(){
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){

        }else{
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 102);
            if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                WRITE_PERMISSION = true;
            else
                WRITE_PERMISSION = false;
        }
    }

    public void askStorageReadPermission(){
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){

        }else{
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 103);

            if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                READ_PERMISSION = true;
            else
                READ_PERMISSION = false;
        }
    }

}