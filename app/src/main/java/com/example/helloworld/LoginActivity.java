package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private static final String HARDCODED_USERNAME = "jencalada";
    private static final String HARDCODED_PASSWORD = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button loginBtn = findViewById(R.id.loginBtn);
        EditText user = findViewById(R.id.user);
        EditText password = findViewById(R.id.password);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userString = user.getText().toString();
                String passwordString = password.getText().toString();
                if(userString.trim().equalsIgnoreCase(HARDCODED_USERNAME) &&
                        passwordString.trim().equalsIgnoreCase(HARDCODED_PASSWORD)) {
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra(MainActivity.USERNAME, userString);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "INVALID CREDENTIALS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}