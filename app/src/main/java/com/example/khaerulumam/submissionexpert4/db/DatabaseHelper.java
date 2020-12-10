package com.example.khaerulumam.submissionexpert4.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.COVER;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.DESKRIPSI;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.ISTRUE;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.JUDUL;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.NEGARA_PRODUKSI;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.POPULARITAS;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.RATING;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.STATUS_FILM;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.TABLE_NAME;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.TAHUN_TAYANG;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.TIMESTAMP;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbfavorite";

    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_FILM_FAVORITE = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            TABLE_NAME,
            _ID,
            JUDUL,
            DESKRIPSI,
            TAHUN_TAYANG,
            POPULARITAS,
            COVER,
            NEGARA_PRODUKSI,
            STATUS_FILM,
            RATING,
            ISTRUE,
            TIMESTAMP

    );

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_FILM_FAVORITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
