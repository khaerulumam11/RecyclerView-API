package com.example.khaerulumam.submissionexpert4.fragment;


import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
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
import com.example.khaerulumam.submissionexpert4.adapter.ListFilmAdapter;
import com.example.khaerulumam.submissionexpert4.adapter.ListFilmSQliteAdapter;
import com.example.khaerulumam.submissionexpert4.db.DbHelper;
import com.example.khaerulumam.submissionexpert4.model.FilmEntity;
import com.example.khaerulumam.submissionexpert4.model.FilmModel;
import com.example.khaerulumam.submissionexpert4.nav.FilmNavigator;
import com.example.khaerulumam.submissionexpert4.nav.FilmSQLiteNavigator;
import com.example.khaerulumam.submissionexpert4.utils.NetworlUtils;
import com.example.khaerulumam.submissionexpert4.viewModel.FilmSQLiteViewModel;
import com.example.khaerulumam.submissionexpert4.viewModel.FilmViewModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilmSQLiteFragment extends Fragment implements FilmSQLiteNavigator {
    View view;
    RecyclerView recyclerView;
    ListFilmSQliteAdapter adapter;
    DbHelper dbHelper;
    Context mContext;
    ContentLoadingProgressBar contentLoadingProgressBar;
    String language;
    RecyclerView.LayoutManager layoutManager;
    public FilmSQLiteViewModel filmViewModel;
    ArrayList<FilmEntity> filmEntities = new ArrayList<>();

    public boolean isNetworkConnected() {
        return NetworlUtils.isNetworkConnected(mContext.getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_film_sqlite, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        filmModels.addAll(getList());
        adapter = new ListFilmSQliteAdapter(mContext, filmEntities);

        filmViewModel = ViewModelProviders.of(this).get(FilmSQLiteViewModel.class);
        filmViewModel.getFilmModel().observe(this,getFilms);
        filmViewModel.setNavigator(this);

        mContext = getActivity();

        dbHelper = DbHelper.getInstance(mContext);
        dbHelper.open();

        contentLoadingProgressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        language =getActivity().getResources().getString(R.string.langage);
        getFilm();
    }

    private Observer<ArrayList<FilmEntity>> getFilms = new Observer<ArrayList<FilmEntity>>() {
        @Override
        public void onChanged(ArrayList<FilmEntity> filmItem) {
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
            new LoadDataAsync(dbHelper).execute();
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(mContext, "No Internet", Toast.LENGTH_SHORT).show();
        }
    }

    public class LoadDataAsync extends AsyncTask<Void, Void, ArrayList<FilmEntity>> {

        private final WeakReference<DbHelper> weakNoteHelper;

        private LoadDataAsync(DbHelper dbHelper) {
            weakNoteHelper = new WeakReference<>(dbHelper);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected ArrayList<FilmEntity> doInBackground(Void... voids) {
            Cursor dataCursor = weakNoteHelper.get().queryAll();
            return filmViewModel.entities(dataCursor);
        }

        @Override
        protected void onPostExecute(ArrayList<FilmEntity> notes) {
            super.onPostExecute(notes);
            if (notes.size() > 0){
                adapter.setData(notes);
            } else {
                Toast.makeText(mContext, "Tidak Ada Isinya", Toast.LENGTH_SHORT).show();
            }
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }

}
