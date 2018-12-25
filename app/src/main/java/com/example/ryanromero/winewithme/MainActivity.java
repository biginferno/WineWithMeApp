package com.example.ryanromero.winewithme;

import android.Manifest;
import android.arch.persistence.room.Room;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Database.WineWithMeDao;
import Database.WineWithMeDatabase;

public class MainActivity extends AppCompatActivity {
    //Room Persistence Database
    private static final String DATABASE_NAME ="wineWithMe_db";
    public WineWithMeDatabase winedatabase;

    //Camera Permissions
    private final String TAG = "Debug_MainActivity";
    private final int MY_PERMISSIONS_REQUEST_USE_CAMERA = 0x00AF;


    private  Button addNewBarCodesButton, showType, mostRecentAdded, lastUsed, randomOne, randomTwo;
    public static final int REQUEST_CODE = 1;
    protected void checkPermissions(){
        checkCameraPermission();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winedatabase = Room.databaseBuilder(getApplicationContext(),
                WineWithMeDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        checkPermissions();
        addNewBarCodesButton = (Button) findViewById(R.id.barCodeBtn);
        showType = (Button) findViewById(R.id.showTypeBtn);
        mostRecentAdded = (Button) findViewById(R.id.mostRecentAdded);
        lastUsed = (Button) findViewById(R.id.lastUsed);
        randomOne = (Button) findViewById(R.id.randomOne);
        randomTwo = (Button) findViewById(R.id.randomTwo);

        addNewBarCodesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String upcCode;
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
//
//                upcCode = intent.getDataString();
            }
        });

        showType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String upcCode;
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
//
//                upcCode = intent.getDataString();
            }
        });

        mostRecentAdded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String upcCode;
                Intent intent = new Intent(MainActivity.this, showWine.class);
                startActivityForResult(intent,REQUEST_CODE);
//
//                upcCode = intent.getDataString();
            }
        });

        randomOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String upcCode;
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
//
//                upcCode = intent.getDataString();
            }
        });

        randomTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String upcCode;
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
//
//                upcCode = intent.getDataString();
            }
        });

        lastUsed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String upcCode;
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
//
//                upcCode = intent.getDataString();
            }
        });
        }



        private void checkCameraPermission(){
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA ) != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG,"Permission not available requesting permission");
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_USE_CAMERA);
            } else {
                Log.d(TAG,"Permission has already granted");
            }
        }
        @Override
        public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
            switch (requestCode) {
                case MY_PERMISSIONS_REQUEST_USE_CAMERA: {
                    // If request is cancelled, the result arrays are empty.
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Log.d(TAG,"permission was granted! Do your stuff");
                    } else {
                        Log.d(TAG,"permission denied! Disable the function related with permission.");
                    }
                    return;
                }
            }
        }


}