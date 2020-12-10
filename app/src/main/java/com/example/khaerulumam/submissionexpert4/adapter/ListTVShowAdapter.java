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
import com.example.khaerulumam.submissionexpert4.DetailTVShowActivity;
import com.example.khaerulumam.submissionexpert4.R;
import com.example.khaerulumam.submissionexpert4.model.TVShowModel;

import java.util.ArrayList;

public class ListTVShowAdapter extends RecyclerView.Adapter<ListTVShowAdapter.ListViewHolder> {
    private ArrayList<TVShowModel.ResultsEntity> list;
//
    public ListTVShowAdapter(ArrayList<TVShowModel.ResultsEntity> list) {
        this.list = list;
    }

    public void setData(ArrayList<TVShowModel.ResultsEntity> data){
        list.clear();
        list.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_tv_rv, parent, false);
        return new ListViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {

        final TVShowModel.ResultsEntity tvShowModel = list.get(position);
        holder.txtJudul.setText(tvShowModel.getOriginalName());
        holder.txtPopularitas.setText(holder.itemView.getResources().getString(R.string.popularitasFilm)+tvShowModel.getPopularity());
        holder.txtEpisode.setText(holder.itemView.getResources().getString(R.string.episodePertama)+tvShowModel.getFirstAirDate());
        holder.ratingBar.setRating(Float.parseFloat(String.valueOf(tvShowModel.getVoteAverage())));
        Glide.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w185/"+tvShowModel.getPosterPath()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(holder.itemView.getContext(), DetailTVShowActivity.class);
                pindah.putExtra("id",tvShowModel.getId());
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
         TextView txtJudul, txtPopularitas, txtEpisode;
         RatingBar ratingBar;
         ImageView imageView;
        ListViewHolder(@NonNull View view) {
            super(view);

            txtJudul = view.findViewById(R.id.judulTV);
            txtPopularitas = view.findViewById(R.id.popularitasTV);
            txtEpisode = view.findViewById(R.id.episodePertama);
            ratingBar = view.findViewById(R.id.ratingTV);
            imageView = view.findViewById(R.id.coverTV);
        }
    }
}
