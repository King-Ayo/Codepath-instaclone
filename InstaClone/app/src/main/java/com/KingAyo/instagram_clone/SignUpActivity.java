package com.KingAyo.instagram_clone;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    EditText username_input, password_input, email_input, phone_input;
    Button signup_btn;

    public static String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username_input = findViewById(R.id.username_input);
        password_input = findViewById(R.id.password_input);
        email_input = findViewById(R.id.email_input);
        phone_input = findViewById(R.id.phone_input);
        signup_btn = findViewById(R.id.signup_btn);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Login button clicked");
                String username = username_input.getText().toString();
                String password = password_input.getText().toString();
                String email = email_input.getText().toString();
                String phone = phone_input.getText().toString();

                Log.i(TAG, "User: " + username + ", Pass: " + password);
                signup_user(username, password, email, phone);
            }
        });

    }

    private void signup_user(String username, String password, String email, String phone) {
        ParseUser user = new ParseUser(); // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email); // Set custom properties
        user.put("phone", phone); // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e != null){
                    Log.i(TAG, "Sign Up Failed " + e.toString());
                    return;
                }
                goToMainActivity();
            }
        });
    }

    private void goToMainActivity() {
        Intent i = new Intent(this, com.KingAyo.instagram_clone.MainActivity.class);
        startActivity(i);
    }
}