package com.saveetha.pinsight;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SelectionActivity extends AppCompatActivity {

    Button btnAdmin, btnUser;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        btnAdmin = findViewById(R.id.btnAdmin);
        btnUser = findViewById(R.id.btnUser);
        btnBack = findViewById(R.id.btnBack);

        // Back button
        btnBack.setOnClickListener(v -> finish());

        // Admin button → Dummy Dashboard
        btnAdmin.setOnClickListener(v -> {
            Intent intent = new Intent(SelectionActivity.this, CreateAccountActivity.class);
            intent.putExtra("role", "Admin");
            startActivity(intent);
        });

        // User button → Dummy Dashboard
        btnUser.setOnClickListener(v -> {
            Intent intent = new Intent(SelectionActivity.this, CreateAccountActivity.class);
            intent.putExtra("role", "User");
            startActivity(intent);
        });
    }
}
