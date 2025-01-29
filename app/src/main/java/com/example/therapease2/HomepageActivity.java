package com.example.therapease2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        CardView cardBookingApp = findViewById(R.id.cardBookingApp);
        CardView cardSetNoti = findViewById(R.id.cardSetNoti);
        CardView cardViewProfileCard = findViewById(R.id.cardViewProfileCard);
        CardView cardArticles = findViewById(R.id.cardArticles);
        CardView cardExit = findViewById(R.id.cardExit);
        CardView cardAboutUs = findViewById(R.id.cardAboutUs);

        cardBookingApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });

        cardSetNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, Reminder.class);
                startActivity(intent);
            }
        });

        cardViewProfileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        cardArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, ArticleActivity.class);
                startActivity(intent);
            }
        });

        cardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(HomepageActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cardAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });
    }
}
