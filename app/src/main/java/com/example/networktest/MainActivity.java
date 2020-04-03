package com.example.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToServerView(View view)
    {
        Intent myIntent = new Intent(this, ServerActivity.class);

        startActivity(myIntent);
    }

    public void  goToClientView(View view)
    {
        Intent myIntent = new Intent(this, ClientActivity.class);

        startActivity(myIntent);
    }
}
