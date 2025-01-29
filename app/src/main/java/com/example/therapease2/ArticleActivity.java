package com.example.therapease2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArticleActivity.this, HomepageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(ArticleActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("Anxiety", R.string.camera, "View", R.drawable.article1);
        dataList.add(androidData);
        androidData = new DataClass("Bipolar Disorder", R.string.recyclerview, "View", R.drawable.article2);
        dataList.add(androidData);
        androidData = new DataClass("Schizophrenia", R.string.date, "View", R.drawable.article3);
        dataList.add(androidData);
        androidData = new DataClass("PTSD", R.string.edit, "View", R.drawable.article4);
        dataList.add(androidData);
        androidData = new DataClass("Autism", R.string.rating, "View", R.drawable.article5);
        dataList.add(androidData);

        adapter = new MyAdapter(ArticleActivity.this, dataList);
        recyclerView.setAdapter(adapter);
    }

    private void searchList(String text) {
        List<DataClass> dataSearchList = new ArrayList<>();
        for (DataClass data : dataList) {
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()) {
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList(dataSearchList);
        }
    }
}
