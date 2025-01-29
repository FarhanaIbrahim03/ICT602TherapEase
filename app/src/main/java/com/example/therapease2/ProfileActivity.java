package com.example.therapease2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    TextView emailTextView, uidTextView;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();

        emailTextView = findViewById(R.id.profile_email);
        uidTextView = findViewById(R.id.profile_uid);
        backButton = findViewById(R.id.backButton);

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            emailTextView.setText("Email: " + user.getEmail());
            uidTextView.setText("User ID: " + user.getUid());
        } else {
            Toast.makeText(this, "No user logged in", Toast.LENGTH_SHORT).show();
            finish();
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HomepageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
