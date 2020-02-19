package com.example.android.roomwordssample.activities;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android.roomwordssample.R;
import com.example.android.roomwordssample.adapters.WordAdapter;
import com.example.android.roomwordssample.database.tables.Word;
import com.example.android.roomwordssample.viewmodels.WordViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WordViewModel wordViewModel;
    private RecyclerView recyclerView;
    private WordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        databaseStart();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new WordAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void databaseStart() {
        wordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        wordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {
                adapter.setWords(words);
            }
        });
    }
}
