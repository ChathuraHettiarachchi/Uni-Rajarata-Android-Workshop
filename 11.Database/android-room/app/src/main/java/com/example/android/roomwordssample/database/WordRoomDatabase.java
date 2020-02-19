package com.example.android.roomwordssample.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.android.roomwordssample.database.daos.WordDao;
import com.example.android.roomwordssample.database.tables.Word;

// add tables we need in the db
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    // instance to get the db
    private static WordRoomDatabase instance;

    public abstract WordDao wordDao();

    // singleton to access db
    public static synchronized WordRoomDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), WordRoomDatabase.class, "WordDatabase")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // call async method if need to pre populate data
        }
    };
}
