package com.example.khaerulumam.submissionexpert4.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.example.khaerulumam.submissionexpert4.model.FilmEntity;
import com.example.khaerulumam.submissionexpert4.model.FilmModel;

import java.util.ArrayList;

public class ListFilmSQliteAdapter extends RecyclerView.Adapter<ListFilmSQliteAdapter.ListViewHolder> {
    private ArrayList<FilmEntity> list;
    private final Context mContext;
//
    public ListFilmSQliteAdapter(Context context, ArrayList<FilmEntity> filmEntities) {
        this.mContext = context;
        this.list = filmEntities;
    }

    public void setData(ArrayList<FilmEntity> data){
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
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {

        final FilmEntity filmModel = list.get(position);
        holder.txtJudul.setText(filmModel.getJudul());
        holder.txtPopularitas.setText(holder.itemView.getResources().getString(R.string.popularitasFilm)+filmModel.getPopularitas());
        holder.txtTahun.setText(holder.itemView.getResources().getString(R.string.episodePertama)+filmModel.getTahunTayang());
        holder.ratingBar.setRating(Float.parseFloat(String.valueOf(filmModel.getRating())));
        Glide.with(holder.itemView.getContext()).load(filmModel.getCover()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(holder.itemView.getContext(), DetailFilmActivity.class);
                pindah.putExtra("id",filmModel.getId());
                pindah.putExtra("film",list.get(position));
                holder.itemView.getContext().startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list.size()> 0) {
            return list.size();
        } else {
         return 0;
        }
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
