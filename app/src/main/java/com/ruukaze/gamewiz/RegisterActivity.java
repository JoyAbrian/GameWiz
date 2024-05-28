package com.ruukaze.gamewiz;

import static com.ruukaze.gamewiz.databaseUtils.DatabaseHelper.TABLE_USERS;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.User;

public class RegisterActivity extends AppCompatActivity {
    private ImageView toggle_back;
    private Button btnRegister;
    private EditText inputFirstName, inputLastName, inputUsername, inputEmail, inputPassword;
    private CheckBox checkboxTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toggle_back = findViewById(R.id.toggle_back);
        btnRegister = findViewById(R.id.btnRegister);
        inputFirstName = findViewById(R.id.inputFirstName);
        inputLastName = findViewById(R.id.inputLastName);
        inputUsername = findViewById(R.id.inputUsername);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        checkboxTerms = findViewById(R.id.checkboxTerms);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        toggle_back.setOnClickListener(v -> {
            finish();
        });

        btnRegister.setOnClickListener(v -> {
            if (inputFirstName.getText().toString().isEmpty()) {
                inputFirstName.setError("First name is required");
            }
            if (inputLastName.getText().toString().isEmpty()) {
                inputLastName.setError("Last name is required");
            }
            if (inputUsername.getText().toString().isEmpty()) {
                inputUsername.setError("Username is required");
            }
            if (inputEmail.getText().toString().isEmpty()) {
                inputEmail.setError("Email is required");
            }
            if (inputPassword.getText().toString().isEmpty()) {
                inputPassword.setError("Password is required");
            }
            if (!checkboxTerms.isChecked()) {
                checkboxTerms.setError("You must agree to the terms and conditions");
            }
            if (!inputEmail.getText().toString().contains("@") && !inputEmail.getText().toString().contains(".com")) {
                inputEmail.setError("Invalid email address");
            }

            if (!inputFirstName.getText().toString().isEmpty() && !inputLastName.getText().toString().isEmpty() && !inputUsername.getText().toString().isEmpty() && !inputEmail.getText().toString().isEmpty() && !inputPassword.getText().toString().isEmpty() && checkboxTerms.isChecked() && inputEmail.getText().toString().contains("@") && inputEmail.getText().toString().contains(".com")) {
                String name = inputFirstName.getText().toString() + " " + inputLastName.getText().toString();
                String username = inputUsername.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                Cursor cursor = databaseHelper.getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE username=?", new String[]{username});
                if (cursor.getCount() > 0) {
                    inputUsername.setError("Username already exists");
                } else {
                    cursor = databaseHelper.getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE email=?", new String[]{email});
                    if (cursor.getCount() > 0) {
                        inputEmail.setError("Email already exists");
                    } else {
                        databaseHelper.insertUser(name, username, email, password);
                        Toast.makeText(this, "Registration successful, please Login", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
                cursor.close();
            }
        });
    }
}