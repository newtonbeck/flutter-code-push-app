package com.example.code_push;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        Button currentButton = findViewById(R.id.current_button);
        currentButton.setOnClickListener(v -> {
            startActivity(new Intent(EntryActivity.this, MainActivity.class));
        });


        Button redButton = findViewById(R.id.red_button);
        redButton.setOnClickListener(v -> {
            startActivity(new Intent(EntryActivity.this, MainActivity.class));
        });

        Button greenButton = findViewById(R.id.green_button);
        Button blueButton = findViewById(R.id.blue_button);
    }

}
