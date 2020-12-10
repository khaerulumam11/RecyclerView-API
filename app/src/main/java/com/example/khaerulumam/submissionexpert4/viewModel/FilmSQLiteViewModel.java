package com.example.khaerulumam.submissionexpert4.viewModel;

import android.database.Cursor;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.khaerulumam.submissionexpert4.BaseViewModel;
import com.example.khaerulumam.submissionexpert4.model.FilmEntity;
import com.example.khaerulumam.submissionexpert4.model.FilmModel;
import com.example.khaerulumam.submissionexpert4.nav.FilmNavigator;
import com.example.khaerulumam.submissionexpert4.nav.FilmSQLiteNavigator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

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


public class FilmSQLiteViewModel extends BaseViewModel<FilmSQLiteNavigator> {
    MutableLiveData<ArrayList<FilmEntity>> mutableLiveData = new MutableLiveData<>();

    public ArrayList<FilmEntity> entities(Cursor cursor) {
        ArrayList<FilmEntity> filmEntities = new ArrayList<>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(_ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(JUDUL));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(DESKRIPSI));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(TAHUN_TAYANG));
            String popularity = cursor.getString(cursor.getColumnIndexOrThrow(POPULARITAS));
            String cover = cursor.getString(cursor.getColumnIndexOrThrow(COVER));
            String negara = cursor.getString(cursor.getColumnIndexOrThrow(NEGARA_PRODUKSI));
            String status = cursor.getString(cursor.getColumnIndexOrThrow(STATUS_FILM));
            Double rating = cursor.getDouble(cursor.getColumnIndexOrThrow(RATING));
            String isTrue = cursor.getString(cursor.getColumnIndexOrThrow(ISTRUE));
            filmEntities.add(new FilmEntity(id, title, description, date,popularity,cover,negara,status,rating,isTrue));
            if (filmEntities.size()!=0) {
                mutableLiveData.postValue(filmEntities);
            } else {
                getNavigator().error("Data Not Found");
            }
        }


        return filmEntities;
    }


    public LiveData<ArrayList<FilmEntity>> getFilmModel() {
        return mutableLiveData;
    }

}
