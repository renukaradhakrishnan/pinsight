package com.saveetha.pinsight;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OtpVerificationActivity extends AppCompatActivity {

    private EditText otp1, otp2, otp3, otp4;
    private TextView timerText, resendText;
    private Button submitButton;
    private ImageButton backButton;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 120000; // 120 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        // Initialize views
        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        timerText = findViewById(R.id.timerText);
        resendText = findViewById(R.id.resendText);
        submitButton = findViewById(R.id.submitButton);
        backButton = findViewById(R.id.backButton);

        startTimer();
        setupOtpInputs();

        resendText.setOnClickListener(v -> {
            Toast.makeText(this, "Resend OTP clicked", Toast.LENGTH_SHORT).show();
            timeLeftInMillis = 120000;
            startTimer();
        });

        submitButton.setOnClickListener(v -> {
            String code = otp1.getText().toString().trim() +
                    otp2.getText().toString().trim() +
                    otp3.getText().toString().trim() +
                    otp4.getText().toString().trim();

            if (code.length() < 4) {
                Toast.makeText(this, "Enter all 4 digits", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "OTP Submitted: " + code, Toast.LENGTH_SHORT).show();
                // TODO: Verify OTP here (API call, etc.)
            }
        });

        backButton.setOnClickListener(v -> finish());
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                long seconds = millisUntilFinished / 1000;
                timerText.setText("00:" + seconds + " Sec");
            }

            public void onFinish() {
                timerText.setText("00:00 Sec");
                Toast.makeText(OtpVerificationActivity.this, "OTP expired", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    private void setupOtpInputs() {
        otp1.addTextChangedListener(new GenericTextWatcher(otp1, otp2));
        otp2.addTextChangedListener(new GenericTextWatcher(otp2, otp3));
        otp3.addTextChangedListener(new GenericTextWatcher(otp3, otp4));
        otp4.addTextChangedListener(new GenericTextWatcher(otp4, null));
    }

    // Auto move to next field
    private static class GenericTextWatcher implements TextWatcher {
        private final EditText currentView;
        private final EditText nextView;

        public GenericTextWatcher(EditText currentView, EditText nextView) {
            this.currentView = currentView;
            this.nextView = nextView;
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() == 1 && nextView != null) {
                nextView.requestFocus();
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }
    }
}
