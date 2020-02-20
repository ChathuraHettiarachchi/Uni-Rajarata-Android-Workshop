package com.example.android.roomwordssample.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.roomwordssample.R;
import com.example.android.roomwordssample.adapters.WordAdapter;
import com.example.android.roomwordssample.database.tables.Word;
import com.example.android.roomwordssample.dialog.NewWordDialog;
import com.example.android.roomwordssample.viewmodels.WordViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NewWordDialog.NewWordDialogCallback {

    private WordViewModel wordViewModel;
    private RecyclerView recyclerView;
    private WordAdapter adapter;

    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        databaseStart();
    }

    private void initUI() {
        fabAdd = findViewById(R.id.fabAdd);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new WordAdapter();
        recyclerView.setAdapter(adapter);

        NewWordDialog dialog = new NewWordDialog(MainActivity.this, this);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
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

    @Override
    public void onNewWord(Word word) {
        wordViewModel.insert(word);
    }
}
