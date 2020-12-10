package com.example.khaerulumam.submissionexpert4.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.error.ANError;
import com.example.khaerulumam.submissionexpert4.R;
import com.example.khaerulumam.submissionexpert4.adapter.ListFilmAdapter;
import com.example.khaerulumam.submissionexpert4.model.FilmModel;
import com.example.khaerulumam.submissionexpert4.nav.FilmNavigator;
import com.example.khaerulumam.submissionexpert4.utils.NetworlUtils;
import com.example.khaerulumam.submissionexpert4.viewModel.FilmViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilmFragment extends Fragment implements FilmNavigator {
    View view;
    RecyclerView recyclerView;
    ListFilmAdapter adapter;
    Context mContext;
    ArrayList<FilmModel.ResultsEntity> filmModels = new ArrayList<>();
    ContentLoadingProgressBar contentLoadingProgressBar;
    String language;
    RecyclerView.LayoutManager layoutManager;
    private FilmViewModel filmViewModel;

    public boolean isNetworkConnected() {
        return NetworlUtils.isNetworkConnected(mContext.getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_film, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        filmModels = new ArrayList<>();
//        filmModels.addAll(getList());
        adapter = new ListFilmAdapter(filmModels);

        filmViewModel = ViewModelProviders.of(this).get(FilmViewModel.class);
        filmViewModel.getFilmModel().observe(this,getFilms);
        filmViewModel.setNavigator(this);

        mContext = getActivity();

        contentLoadingProgressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(getContext());

        //jika mau 2 kesamping
        //layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        language =getActivity().getResources().getString(R.string.langage);
        getFilm();
    }

    private Observer<ArrayList<FilmModel.ResultsEntity>> getFilms = new Observer<ArrayList<FilmModel.ResultsEntity>>() {
        @Override
        public void onChanged(ArrayList<FilmModel.ResultsEntity> filmItem) {
            if (filmItem != null) {
                adapter.setData(filmItem);
                showLoading(false);
            }
        }
    };

    private void showLoading(boolean b) {
        if (b){
            contentLoadingProgressBar.show();
        } else {
            contentLoadingProgressBar.hide();
        }
    }

    private void getFilm() {
        if (isNetworkConnected()){
            filmViewModel.getList(language);
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(mContext, "No Internet", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void handleError(Throwable throwable) {
        Toast.makeText(mContext, throwable.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleErrorNetwork(ANError error) {
        Toast.makeText(mContext, error.getErrorDetail(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error(String eror) {
        Toast.makeText(mContext, eror, Toast.LENGTH_SHORT).show();
    }

//


}
