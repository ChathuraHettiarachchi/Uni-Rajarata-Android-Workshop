package com.example.android.roomwordssample.database.repos;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.android.roomwordssample.database.WordRoomDatabase;
import com.example.android.roomwordssample.database.daos.WordDao;
import com.example.android.roomwordssample.database.tables.Word;

import java.util.List;

public class WordRepository {
    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    public WordRepository(Application application){
        WordRoomDatabase wordRoomDatabase = WordRoomDatabase.getInstance(application);
        wordDao = wordRoomDatabase.wordDao();

        allWords = wordDao.getAlphabetizedWords();
    }

    public void insert(Word word){
        new InsertWordAsyncTask(wordDao).execute(word);
    }

    public void update(Word word){
        new UpdateWordAsyncTask(wordDao).execute(word);
    }

    public void delete(Word word){
        new DeleteWordAsyncTask(wordDao).execute(word);
    }

    public void deleteAll(){
        new DeleteAllWordAsyncTask(wordDao).execute();
    }

    public LiveData<List<Word>> getAllWords(){
        return allWords;
    }

    private static class InsertWordAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        private InsertWordAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insert(words[0]);
            return null;
        }
    }

    private static class UpdateWordAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        private UpdateWordAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.update(words[0]);
            return null;
        }
    }

    private static class DeleteWordAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        private DeleteWordAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.delete(words[0]);
            return null;
        }
    }

    private static class DeleteAllWordAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        private DeleteAllWordAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteAll();
            return null;
        }
    }
}
