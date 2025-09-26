package com.saveetha.pinsight;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class
LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signInButton;

    private TextView forgotPasswordText;
    private TextView signUpLink;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);
        signUpLink = findViewById(R.id.signUpLink);
        backButton = findViewById(R.id.backButton);

        // Sign In Button Click
        signInButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            } else {
                // TODO: Replace with real authentication
                if (username.equals("admin") && password.equals("1234")) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, QuizActivity.class);
                    intent.putExtra("role", "Admin");
                    startActivity(intent);
                    // Intent to Dashboard or MainActivity
                    // startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                } else {
                    Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Forgot Password Click
        forgotPasswordText.setOnClickListener(v ->{
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            intent.putExtra("role", "Admin");
            startActivity(intent);
                }


        );

        // Sign Up Click
        signUpLink.setOnClickListener(v ->
                        Toast.makeText(this, "Redirecting to Sign Up", Toast.LENGTH_SHORT).show()
                // startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        );

        // Back Button Click
        backButton.setOnClickListener(v -> finish());
    }
}