package com.example.khaerulumam.submissionexpert4.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.khaerulumam.submissionexpert4.BaseViewModel;
import com.example.khaerulumam.submissionexpert4.model.FilmModel;
import com.example.khaerulumam.submissionexpert4.nav.FilmNavigator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;


public class FilmViewModel extends BaseViewModel<FilmNavigator> {
    private String BASE_URL = "https://api.themoviedb.org/3/discover/movie?api_key=";
    private String API_KEY ="751e653d2a3c0dc0a05836baab9126ae";
    private Gson gson;
    private MutableLiveData<ArrayList<FilmModel.ResultsEntity>> mutableLiveData = new MutableLiveData<>();

    public void getList(String language){
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        gson = gsonBuilder.create();
        final ArrayList<FilmModel.ResultsEntity> listItems = new ArrayList<>();
            AndroidNetworking.get(BASE_URL + API_KEY + "&language=" + language + "&page=1")
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            FilmModel filmModel = gson.fromJson(String.valueOf(response), FilmModel.class);
                            if (filmModel.getResults().size() != 0 && filmModel.getResults() != null) {
                                FilmModel.ResultsEntity resultsEntity;
                                for (int i = 0; i < filmModel.getResults().size(); i++) {
                                    resultsEntity = filmModel.getResults().get(i);
                                    if (resultsEntity != null) {
                                        listItems.add(resultsEntity);
                                    }
                                }
                                mutableLiveData.postValue(listItems);
                            } else {
                                getNavigator().error("Data Not Found");
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            System.out.println(anError.getErrorDetail().toString());
                        }
                    });
    }

    public LiveData<ArrayList<FilmModel.ResultsEntity>> getFilmModel() {
        return mutableLiveData;
    }

}
