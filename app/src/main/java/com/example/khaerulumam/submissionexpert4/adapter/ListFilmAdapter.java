package com.example.khaerulumam.submissionexpert4.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.khaerulumam.submissionexpert4.DetailFilmActivity;
import com.example.khaerulumam.submissionexpert4.R;
import com.example.khaerulumam.submissionexpert4.model.FilmModel;

import java.util.ArrayList;

public class ListFilmAdapter extends RecyclerView.Adapter<ListFilmAdapter.ListViewHolder> {
    private ArrayList<FilmModel.ResultsEntity> list;
//
    public ListFilmAdapter(ArrayList<FilmModel.ResultsEntity> list) {
        this.list = list;
    }

    public void setData(ArrayList<FilmModel.ResultsEntity> data){
        if (data.size() > 0) {
            list.clear();
        }
        list.addAll(data);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_rv, parent, false);
        return new ListViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {

        final FilmModel.ResultsEntity filmModel = list.get(position);
        holder.txtJudul.setText(filmModel.getOriginalTitle());
        holder.txtPopularitas.setText(holder.itemView.getResources().getString(R.string.popularitasFilm)+filmModel.getPopularity());
        holder.txtTahun.setText(holder.itemView.getResources().getString(R.string.episodePertama)+filmModel.getReleaseDate());
        holder.ratingBar.setRating(Float.parseFloat(String.valueOf(filmModel.getVoteAverage())));
        Glide.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w185/"+filmModel.getPosterPath()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(holder.itemView.getContext(), DetailFilmActivity.class);
                pindah.putExtra("id",filmModel.getId());
                holder.itemView.getContext().startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
//        return 0;
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
         TextView txtJudul, txtPopularitas, txtTahun;
         RatingBar ratingBar;
         ImageView imageView;
        ListViewHolder(@NonNull View view) {
            super(view);

            txtJudul = view.findViewById(R.id.judulFilm);
            txtPopularitas = view.findViewById(R.id.popularitasFilm);
            txtTahun = view.findViewById(R.id.tahunTayang);
            ratingBar = view.findViewById(R.id.ratingFilm);
            imageView = view.findViewById(R.id.coverFilm);
        }
    }
}
