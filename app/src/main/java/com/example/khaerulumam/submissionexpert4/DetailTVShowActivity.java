package com.example.khaerulumam.submissionexpert4;

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
import com.example.khaerulumam.submissionexpert4.model.DetailTVShowModel;
import com.example.khaerulumam.submissionexpert4.utils.NetworlUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

public class DetailTVShowActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView txtNama, txtJumlahEp, txtRelease, txtDeskripsi, txtStatus;
    RatingBar ratingBar;
    ImageView imageView;
    ContentLoadingProgressBar contentLoadingProgressBar;
    private String BASE_URL = "https://api.themoviedb.org/3/tv/";
    private String API_KEY ="751e653d2a3c0dc0a05836baab9126ae";
    private Gson gson;

    public boolean isNetworkConnected() {
        return NetworlUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tvshow);

        txtNama = findViewById(R.id.judulTVShow);
        txtJumlahEp = findViewById(R.id.jumlahEpisode);
        txtRelease = findViewById(R.id.episodePertama);
        txtDeskripsi = findViewById(R.id.deskripsiTVShow);
        ratingBar = findViewById(R.id.ratingTVShow);
        imageView = findViewById(R.id.coverTVShow);
        txtStatus = findViewById(R.id.statusTVShow);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle(getResources().getString(R.string.detailTVShow));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        gson = gsonBuilder.create();
        contentLoadingProgressBar =findViewById(R.id.progressBar);
        String language =getResources().getString(R.string.langage);
        getDetailTVShow(language, getIntent().getIntExtra("id",0));

    }

    private void getDetailTVShow(String language, int id) {
        if (isNetworkConnected()) {
            setIsLoading(true);
            AndroidNetworking.get(BASE_URL + id + "?api_key=" + API_KEY + "&language=" + language)
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            setIsLoading(false);
                            DetailTVShowModel tvShowModel = gson.fromJson(String.valueOf(response), DetailTVShowModel.class);
                            if (tvShowModel.getId() != 0) {
                                txtNama.setText(tvShowModel.getOriginalName());
                                txtDeskripsi.setText(tvShowModel.getOverview());
                                txtRelease.setText(tvShowModel.getFirstAirDate());
                                txtStatus.setText(tvShowModel.getStatus());
                                txtJumlahEp.setText(String.valueOf(tvShowModel.getNumberOfEpisodes()));
                                ratingBar.setRating(Float.parseFloat(String.valueOf(tvShowModel.getVoteAverage())));
                                Glide.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w185/" + tvShowModel.getPosterPath()).into(imageView);
                            } else {
                                Toast.makeText(DetailTVShowActivity.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            setIsLoading(false);
                            Toast.makeText(DetailTVShowActivity.this, anError.getErrorDetail(), Toast.LENGTH_SHORT).show();
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
