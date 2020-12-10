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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.error.ANError;
import com.example.khaerulumam.submissionexpert4.R;
import com.example.khaerulumam.submissionexpert4.adapter.ListTVShowAdapter;
import com.example.khaerulumam.submissionexpert4.model.TVShowModel;
import com.example.khaerulumam.submissionexpert4.nav.TVShowNavigator;
import com.example.khaerulumam.submissionexpert4.utils.NetworlUtils;
import com.example.khaerulumam.submissionexpert4.viewModel.TVShowViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowSqliteFragment extends Fragment implements TVShowNavigator {

    View view;
    RecyclerView recyclerView;
    ListTVShowAdapter adapter;
    Context mContext;
    ArrayList<TVShowModel.ResultsEntity> showModels;
    ContentLoadingProgressBar contentLoadingProgressBar;
    String language;
    private TVShowViewModel tvShowViewModel;

    public boolean isNetworkConnected() {
        return NetworlUtils.isNetworkConnected(mContext.getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tvshow_sqlite, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getActivity();
        tvShowViewModel = ViewModelProviders.of(this).get(TVShowViewModel.class);
        tvShowViewModel.getFilmModel().observe(this,getTVShows);
        tvShowViewModel.setNavigator(this);

        contentLoadingProgressBar = view.findViewById(R.id.progressBar);
        showModels = new ArrayList<>();
        recyclerView = view.findViewById(R.id.rvList);
        adapter = new ListTVShowAdapter(showModels);
        adapter.notifyDataSetChanged();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
         language=getActivity().getResources().getString(R.string.langage);
         getTVShow();
    }

    private Observer<ArrayList<TVShowModel.ResultsEntity>> getTVShows = new Observer<ArrayList<TVShowModel.ResultsEntity>>() {
        @Override
        public void onChanged(ArrayList<TVShowModel.ResultsEntity> tvshowItem) {
            if (tvshowItem != null) {
                adapter.setData(tvshowItem);
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

    private void getTVShow() {
        if (isNetworkConnected()){
            tvShowViewModel.getList(language);
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

}
