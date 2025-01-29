package com.example.therapease2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AboutUsActivity extends AppCompatActivity {
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        backButton = findViewById(R.id.backButton);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Aboutus> teamList = new ArrayList<>();
        teamList.add(new Aboutus("Nur Ain Wirdani Binti Norsyawaldizahar", "CDCS2405C", "2022812712", "CDCS240", R.drawable.ain));
        teamList.add(new Aboutus("Nur Farhana Binti Ibrahim", "CDCS2405C", "2022455012", "CDCS240", R.drawable.farhana));
        teamList.add(new Aboutus("Nurul Darwisyah Binti Muda", "CS2405C", "2022484778", "CDCS240", R.drawable.darwisyah));

        AboutusAdapter adapter = new AboutusAdapter(teamList);
        recyclerView.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUsActivity.this, HomepageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
