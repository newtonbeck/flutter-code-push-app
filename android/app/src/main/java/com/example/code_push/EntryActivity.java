package com.example.code_push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.code_push.http.InputStreamVolleyRequest;

import java.io.FileOutputStream;
import java.io.IOException;

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
        redButton.setOnClickListener(v -> downloadAot("red"));

        Button greenButton = findViewById(R.id.green_button);
        greenButton.setOnClickListener(v -> downloadAot("green"));

        Button blueButton = findViewById(R.id.blue_button);
        blueButton.setOnClickListener(v -> downloadAot("blue"));
    }

    private void downloadAot(String color) {
        RequestQueue queue = Volley.newRequestQueue(EntryActivity.this);
        InputStreamVolleyRequest request = new InputStreamVolleyRequest(Request.Method.GET,
                "http://192.168.15.17:3000/" + color + "/libapp.so",
                response -> {
                    try {
                        FileOutputStream fileOutputStream = openFileOutput("libapp.so", Context.MODE_PRIVATE);
                        fileOutputStream.write(response);
                        fileOutputStream.close();
                        Toast.makeText(EntryActivity.this, "Download " + color + " completed", Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Toast.makeText(EntryActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                },
                null);

        queue.add(request);
    }

}
