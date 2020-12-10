package com.example.khaerulumam.submissionexpert4.helper;

import android.database.Cursor;

import com.example.khaerulumam.submissionexpert4.model.FilmEntity;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.COVER;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.DESKRIPSI;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.ISTRUE;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.JUDUL;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.NEGARA_PRODUKSI;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.POPULARITAS;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.RATING;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.STATUS_FILM;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.TAHUN_TAYANG;

public class MappingHelper {
    public static ArrayList<FilmEntity> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<FilmEntity> notesList = new ArrayList<>();

        while (notesCursor.moveToNext()) {
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(_ID));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(JUDUL));
            String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DESKRIPSI));
            String tahun = notesCursor.getString(notesCursor.getColumnIndexOrThrow(TAHUN_TAYANG));
            String cover = notesCursor.getString(notesCursor.getColumnIndexOrThrow(COVER));
            String popularitas = notesCursor.getString(notesCursor.getColumnIndexOrThrow(POPULARITAS));
            String negara = notesCursor.getString(notesCursor.getColumnIndexOrThrow(NEGARA_PRODUKSI));
            String status = notesCursor.getString(notesCursor.getColumnIndexOrThrow(STATUS_FILM));
            String isTrue = notesCursor.getString(notesCursor.getColumnIndexOrThrow(ISTRUE));
            Double rating = notesCursor.getDouble(notesCursor.getColumnIndexOrThrow(String.valueOf(RATING)));
            notesList.add(new FilmEntity(id, title, description,tahun, popularitas,cover,negara,status,rating,isTrue));
        }

        return notesList;
    }
}
