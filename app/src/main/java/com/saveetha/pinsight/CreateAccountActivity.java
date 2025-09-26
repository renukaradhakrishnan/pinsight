package com.saveetha.pinsight;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    EditText username, password, email, mobile;
    Button createAccountButton;
    ImageButton facebookButton, twitterButton, googleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);  // Make sure the XML file is named this way

        // Initialize views
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.mobile);
        createAccountButton = findViewById(R.id.create_account_button);
        facebookButton = findViewById(R.id.facebook_button);
        twitterButton = findViewById(R.id.twitter_button);
        googleButton = findViewById(R.id.google_button);

        // Create button click listener
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String mail = email.getText().toString().trim();
                String phone = mobile.getText().toString().trim();

                if (user.isEmpty() || pass.isEmpty() || mail.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform account creation logic here
                    Toast.makeText(CreateAccountActivity.this, "Account Created!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                    intent.putExtra("role", "Admin");
                    startActivity(intent);
                }
            }
        });

        // Social media buttons
        facebookButton.setOnClickListener(v ->
                Toast.makeText(this, "Facebook Login Clicked", Toast.LENGTH_SHORT).show());

        twitterButton.setOnClickListener(v ->
                Toast.makeText(this, "Twitter Login Clicked", Toast.LENGTH_SHORT).show());

        googleButton.setOnClickListener(v ->
                Toast.makeText(this, "Google Login Clicked", Toast.LENGTH_SHORT).show());
    }
}