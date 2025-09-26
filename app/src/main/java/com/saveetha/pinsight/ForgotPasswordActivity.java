package com.saveetha.pinsight;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText phoneInput;
    private Button continueBtn;
    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password); // Make sure the layout file name is correct

        phoneInput = findViewById(R.id.phoneInput);
        continueBtn = findViewById(R.id.continueBtn);
        backBtn = findViewById(R.id.backButton);

        // Handle Continue button click
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumber = phoneInput.getText().toString().trim();

                if (phoneNumber.isEmpty()) {
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
                } else if (phoneNumber.length() < 10) {
                    Toast.makeText(ForgotPasswordActivity.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
                } else {
                    // Simulate sending OTP
                    Toast.makeText(ForgotPasswordActivity.this, "OTP sent to " + phoneNumber, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ForgotPasswordActivity.this, OtpVerificationActivity.class);
                    intent.putExtra("role", "Admin");
                    startActivity(intent);
                    // Optionally go to another activity (e.g., OTP verification screen)
                    // Intent intent = new Intent(ForgotPasswordActivity.this, OtpVerificationActivity.class);
                    // intent.putExtra("phone", phoneNumber);
                    // startActivity(intent);
                }
            }
        });

        // Handle Back button click
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Go back to the previous screen
            }
        });
    }
}


