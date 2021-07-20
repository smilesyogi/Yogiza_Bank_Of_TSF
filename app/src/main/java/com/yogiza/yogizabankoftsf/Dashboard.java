package com.yogiza.yogizabankoftsf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
    }

    public void showcustomers(View view) {
        Intent intent = new Intent(Dashboard.this, Customer_List.class);
        startActivity(intent);
    }

    public void showtrans(View view) {
        Intent intent = new Intent(Dashboard.this, Trans_History.class);
        startActivity(intent);
    }
}