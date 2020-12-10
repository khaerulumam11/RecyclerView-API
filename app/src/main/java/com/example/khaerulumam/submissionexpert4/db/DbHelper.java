package com.example.khaerulumam.submissionexpert4.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import static android.provider.BaseColumns._ID;

public class DbHelper {
    public static final String TABLE_NAME = "film_favorite";
    public static final String JUDUL = "judul";
    public static final String DESKRIPSI = "deskripsi";
    public static final String TAHUN_TAYANG = "tahun_tayang";
    public static final String POPULARITAS = "popularity";
    public static final String COVER = "cover";
    public static final String TIMESTAMP = "timestamp";
    public static final String NEGARA_PRODUKSI = "negara_produksi";
    public static final String STATUS_FILM = "status_film";
    public static final String RATING = "rating_film";
    public static final String ISTRUE = "isTrue";

    private static final String DATABASE_TABLE = TABLE_NAME;
    private static DatabaseHelper dataBaseHelper;
    private static DbHelper INSTANCE;

    private static SQLiteDatabase database;

    private DbHelper(Context context) {
        dataBaseHelper = new DatabaseHelper(context);
    }

    public static DbHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DbHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database = dataBaseHelper.getWritableDatabase();
    }

    public void close() {
        dataBaseHelper.close();

        if (database.isOpen())
            database.close();
    }

    public Cursor queryAll() {
        return database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                _ID + " ASC");
    }

    public Cursor queryById(String id) {
        return database.query(DATABASE_TABLE, null
                , _ID + " = ?"
                , new String[]{id}
                , null
                , null
                , null
                , null);
    }

    public long insert(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }

    public int deleteById(String id) {
        return database.delete(DATABASE_TABLE, _ID + " = ?", new String[]{id});
    }

}
