package com.example.android.roomwordssample.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.android.roomwordssample.database.repos.WordRepository;
import com.example.android.roomwordssample.database.tables.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository repository;
    private LiveData<List<Word>> allWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        repository = new WordRepository(application);
        allWords = repository.getAllWords();
    }

    public void insert(Word word) {
        repository.insert(word);
    }

    public void update(Word word) {
        repository.update(word);
    }

    public void delete(Word word) {
        repository.delete(word);
    }

    public void deleteAllNotes() {
        repository.deleteAll();
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }
}
