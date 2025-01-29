package com.example.therapease2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class BookingActivity extends AppCompatActivity {

    EditText etName, etPhone, etDate, etTime;
    Button btnSubmit;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etDate = findViewById(R.id.et_date);
        etTime = findViewById(R.id.et_time);
        btnSubmit = findViewById(R.id.btn_submit);

        databaseReference = FirebaseDatabase.getInstance().getReference("Bookings");

        etDate.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    BookingActivity.this,
                    (view1, year1, monthOfYear, dayOfMonth) ->
                            etDate.setText(String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year1)),
                    year, month, day
            );
            datePickerDialog.show();
        });

        etTime.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    BookingActivity.this,
                    (view1, hourOfDay, minute1) ->
                            etTime.setText(String.format("%02d:%02d", hourOfDay, minute1)),
                    hour, minute, true
            );
            timePickerDialog.show();
        });

        btnSubmit.setOnClickListener(view -> {
            String name = etName.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String date = etDate.getText().toString().trim();
            String time = etTime.getText().toString().trim();

            if (name.isEmpty() || phone.isEmpty() || date.isEmpty() || time.isEmpty()) {
                Toast.makeText(BookingActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            } else {
                String bookingId = databaseReference.push().getKey();
                Map<String, String> booking = new HashMap<>();
                booking.put("name", name);
                booking.put("phone", phone);
                booking.put("date", date);
                booking.put("time", time);

                databaseReference.child(bookingId).setValue(booking)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(BookingActivity.this, BookingDetailsActivity.class);
                                intent.putExtra("name", name);
                                intent.putExtra("phone", phone);
                                intent.putExtra("date", date);
                                intent.putExtra("time", time);
                                intent.putExtra("appointmentId", bookingId);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(BookingActivity.this, "Failed to submit booking. Try again!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
