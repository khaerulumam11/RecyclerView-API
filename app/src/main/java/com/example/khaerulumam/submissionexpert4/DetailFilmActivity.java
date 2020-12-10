package com.example.khaerulumam.submissionexpert4;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.bumptech.glide.Glide;
import com.example.khaerulumam.submissionexpert4.db.DbHelper;
import com.example.khaerulumam.submissionexpert4.model.DetailFilmModel;
import com.example.khaerulumam.submissionexpert4.utils.NetworlUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.example.khaerulumam.submissionexpert4.db.DbHelper.COVER;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.DESKRIPSI;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.ISTRUE;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.JUDUL;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.NEGARA_PRODUKSI;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.POPULARITAS;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.RATING;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.STATUS_FILM;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.TAHUN_TAYANG;
import static com.example.khaerulumam.submissionexpert4.db.DbHelper.TIMESTAMP;

public class DetailFilmActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView txtNama, txtStatus, txtRilis, txtPopularitas, txtDeskripsi,txtNegaraProduk;
    RatingBar ratingBar;
    ImageView imageView,btnfavorite;
    ContentLoadingProgressBar contentLoadingProgressBar;
    private String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private String API_KEY ="751e653d2a3c0dc0a05836baab9126ae";
    private Gson gson;
    String urlGambar;
    Double hasilRating;
    DbHelper dbHelper;

    public boolean isNetworkConnected() {
        return NetworlUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.detail_film));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dbHelper = DbHelper.getInstance(getApplicationContext());
        dbHelper.open();

//        FilmModel filmModel = getIntent().getParcelableExtra(EXTRA_FILM);
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        gson = gsonBuilder.create();
        txtNama = findViewById(R.id.judulFilm);
        txtDeskripsi = findViewById(R.id.deskripsiFilm);
        txtStatus = findViewById(R.id.statusFilm);
        txtPopularitas = findViewById(R.id.popularityFilm);
        txtRilis = findViewById(R.id.tahunTayang);
        txtNegaraProduk = findViewById(R.id.negaraProduksi);
        ratingBar = findViewById(R.id.ratingFilm);
        imageView = findViewById(R.id.coverFilm);
        btnfavorite = findViewById(R.id.btnFavorite);
        contentLoadingProgressBar =findViewById(R.id.progressBar);
        String language =getResources().getString(R.string.langage);
        getDetailFilm(language, getIntent().getIntExtra("id",0));

        btnfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFavorite();
            }
        });

    }

    private void submitFavorite() {
        ContentValues values = new ContentValues();
        values.put(JUDUL,txtNama.getText().toString());
        values.put(DESKRIPSI,txtDeskripsi.getText().toString());
        values.put(NEGARA_PRODUKSI,txtNegaraProduk.getText().toString());
        values.put(POPULARITAS,txtPopularitas.getText().toString());
        values.put(TAHUN_TAYANG,txtRilis.getText().toString());
        values.put(STATUS_FILM,txtStatus.getText().toString());
        values.put(COVER,urlGambar.toString());
        values.put(TIMESTAMP,getCurrentDate());
        values.put(RATING,hasilRating);
        values.put(ISTRUE,"True");

        dbHelper.insert(values);

//        if (result > 0){
//            Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Gagal Menambahkan Data", Toast.LENGTH_SHORT).show();
//        }
    }

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();

        return dateFormat.format(date);
    }

    private void getDetailFilm(String language, int id) {
        if (isNetworkConnected()) {
            setIsLoading(true);
            AndroidNetworking.get(BASE_URL + id + "?api_key=" + API_KEY + "&language=" + language)
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            setIsLoading(false);
                            DetailFilmModel detailFilmModel = gson.fromJson(String.valueOf(response), DetailFilmModel.class);
                            if (detailFilmModel.getId() != 0) {
                                urlGambar = "https://image.tmdb.org/t/p/w185/"+detailFilmModel.getPosterPath();
                                hasilRating = detailFilmModel.getVoteAverage();
                                txtNama.setText(detailFilmModel.getOriginalTitle());
                                txtDeskripsi.setText(detailFilmModel.getOverview());
                                txtNegaraProduk.setText(detailFilmModel.getProductionCountries().get(0).getName());
                                txtRilis.setText(detailFilmModel.getReleaseDate());
                                txtStatus.setText(detailFilmModel.getStatus());
                                txtPopularitas.setText(String.valueOf(detailFilmModel.getPopularity()));
                                ratingBar.setRating(Float.parseFloat(String.valueOf(detailFilmModel.getVoteAverage())));
                                Glide.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w185/" + detailFilmModel.getPosterPath()).into(imageView);
                            } else {
                                Toast.makeText(DetailFilmActivity.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            setIsLoading(false);
                            Toast.makeText(DetailFilmActivity.this, anError.getErrorDetail(), Toast.LENGTH_SHORT).show();
                            System.out.println(anError.getErrorDetail().toString());
                        }
                    });
        } else {
            Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void setIsLoading(boolean b) {
        if (b){
            contentLoadingProgressBar.show();
        } else {
            contentLoadingProgressBar.hide();
        }
    }
}
