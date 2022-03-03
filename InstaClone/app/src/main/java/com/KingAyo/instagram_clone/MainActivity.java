package com.KingAyo.instagram_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    Button logout_btn, createPost_btn;

    public final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout_btn = findViewById(R.id.logout_btn);
        createPost_btn = findViewById(R.id.createPost_btn);

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser == null){
                    Log.i(TAG, "Successfully logged out");
                    goToLogIn();
                }
            }
        });

        createPost_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCreatePost();
            }
        });
    }

    private void goToLogIn() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    private void goToCreatePost() {
        Intent i = new Intent(this, CreatePost.class);
        startActivity(i);
    }
}