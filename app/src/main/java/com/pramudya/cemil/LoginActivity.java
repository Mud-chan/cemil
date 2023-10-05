package com.pramudya.cemil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usertext;
    private EditText passtext;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usertext = findViewById(R.id.txt_username);
        passtext = findViewById(R.id.txt_pass);
        imageButton = findViewById(R.id.showPasswordButton);

        Button loginButton = findViewById(R.id.button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usertext.getText().toString();
                String password = passtext.getText().toString();

                if (isValidCredentials(username, password)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    displayErrorMessage();
                }
            }
        });

        final EditText passwordEditText = findViewById(R.id.txt_pass);
        ImageButton showPasswordImageButton = findViewById(R.id.showPasswordButton);

        showPasswordImageButton.setOnClickListener(new View.OnClickListener() {
            private boolean passwordVisible;

            @Override
            public void onClick(View v) {
                if (passwordVisible) {
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    showPasswordImageButton.setImageResource(R.drawable.mata);
                } else {
                    passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    showPasswordImageButton.setImageResource(R.drawable.hidenmata);
                }

                passwordVisible = !passwordVisible;

                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });


        TextView registerTextView = findViewById(R.id.btnregis);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean isValidCredentials(String username, String password) {
        String validUsername = "mi";
        String validPassword = "titiproti";
        return username.equals(validUsername) && password.equals(validPassword);
    }

    private void displayErrorMessage() {
        Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show();
    }
}
