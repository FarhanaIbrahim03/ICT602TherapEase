package com.example.therapease2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookingDetailsActivity extends AppCompatActivity {

    TextView tvBookingDetails;
    Button btnBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        tvBookingDetails = findViewById(R.id.tv_booking_details);
        btnBackToHome = findViewById(R.id.btn_back_to_home);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");

        String details = "Booking Details:\n\n" +
                "Name: " + name + "\n" +
                "Phone: " + phone + "\n" +
                "Date: " + date + "\n" +
                "Time: " + time;

        tvBookingDetails.setText(details);

        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingDetailsActivity.this, HomepageActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("phone", phone);
                intent.putExtra("date", date);
                intent.putExtra("time", time);
                startActivity(intent);
                finish();
            }
        });
    }
}
