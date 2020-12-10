package com.example.khaerulumam.submissionexpert4.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.khaerulumam.submissionexpert4.BaseViewModel;
import com.example.khaerulumam.submissionexpert4.model.TVShowModel;
import com.example.khaerulumam.submissionexpert4.nav.TVShowNavigator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;


public class TVShowViewModel extends BaseViewModel<TVShowNavigator> {
    private String BASE_URL = "https://api.themoviedb.org/3/discover/tv?api_key=";
    private String API_KEY ="751e653d2a3c0dc0a05836baab9126ae";
    private Gson gson;
    private MutableLiveData<ArrayList<TVShowModel.ResultsEntity>> mutableLiveData = new MutableLiveData<>();

    public void getList(String language){
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        gson = gsonBuilder.create();
        final ArrayList<TVShowModel.ResultsEntity> listItems = new ArrayList<>();
            AndroidNetworking.get(BASE_URL + API_KEY + "&language=" + language + "&page=1")
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            TVShowModel tvShowModel = gson.fromJson(String.valueOf(response), TVShowModel.class);
                            if (tvShowModel.getResults().size() != 0 && tvShowModel.getResults() != null) {
                                TVShowModel.ResultsEntity resultsEntity;
                                for (int i = 0; i < tvShowModel.getResults().size(); i++) {
                                    resultsEntity = tvShowModel.getResults().get(i);
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

    public LiveData<ArrayList<TVShowModel.ResultsEntity>> getFilmModel() {
        return mutableLiveData;
    }

}
