package com.example.ryanromero.winewithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanActivity extends AppCompatActivity {
    public TextView code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String upcCode;

        super.onCreate(savedInstanceState);
        new IntentIntegrator(this).initiateScan(); // `this` is the current Activity
        setContentView(R.layout.activity_scan);
    }




    // Get the results:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String upcCode;
        code = (TextView) findViewById(R.id.upcCode);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                upcCode = result.getContents();
                code.setText(upcCode);
//                Intent i = getIntent();
//                String textBodyString = "some text";
//                i.putExtra("UPC Code", upcCode);
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

//        if(intent.getExtras() != null) {
//        upcCode = intent.getExtras().getString("UPC Code");
//        code.setText(upcCode);
//        //System.out.print(upcCode);
//    }
//
//
//
//    setContentView(R.layout.activity_scan);

}
