package com.ruukaze.gamewiz;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.User;

public class LoginActivity extends AppCompatActivity {
    private ImageView toggle_back;
    private Button btnLogin, btnRegister;
    private EditText inputEmail, inputPassword;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toggle_back = findViewById(R.id.toggle_back);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);

        databaseHelper = new DatabaseHelper(this);

        toggle_back.setOnClickListener(v -> {
            finish();
        });

        btnLogin.setOnClickListener(v -> {
            if (inputEmail.getText().toString().isEmpty()) {
                inputEmail.setError("Email is required");
            }
            if (inputPassword.getText().toString().isEmpty()) {
                inputPassword.setError("Password is required");
            }
            if (!inputEmail.getText().toString().isEmpty() && !inputPassword.getText().toString().isEmpty()) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                Cursor cursor = databaseHelper.getReadableDatabase().rawQuery("SELECT * FROM users WHERE email = ? AND password = ?", new String[]{email, password});
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    inputEmail.setError("Invalid email or password");
                    inputPassword.setError("Invalid email or password");
                }
                cursor.close();
            }
        });

        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

}