package com.saveetha.pinsight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private Button getStartedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getStartedBtn = findViewById(R.id.get_started_btn);

        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to SelectionActivity
                Intent intent = new Intent(WelcomeActivity.this, SelectionActivity.class);
                startActivity(intent);
                finish(); // Optional: closes WelcomeActivity so user can’t go back
            }
        });
    }
}
