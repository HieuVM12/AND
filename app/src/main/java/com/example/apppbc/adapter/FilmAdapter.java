package com.example.apppbc.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apppbc.DetailFilmActivity;
import com.example.apppbc.R;
import com.example.apppbc.model.Film;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {
    private final List<Film> listFilm;
    private Context mContext;
    public FilmAdapter(Context mContext,List<Film> listFilm){
        this.mContext = mContext;
        this.listFilm = listFilm;
    }
    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listfilm,parent,false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        Film film = listFilm.get(position);
        if(film==null){
            return;
        }
//        holder.tvId.setText(String.valueOf(film.getId()));
        holder.tvTitle.setText(film.getTitle());
//        holder.tvDirector.setText(film.getDirector());
//        holder.tvDes.setText(film.getDes());
//        holder.tvAge.setText(film.getAge());
//        holder.tvTime.setText(film.getTime());
        holder.tvSrcImg.setImageResource(film.getSrcImg());
        holder.tvCategory.setText(film.getCategory());
        holder.layoutFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShowDetail(film);
            }
        });


    }

    private void onClickShowDetail(Film film) {
        Intent intent = new Intent(mContext, DetailFilmActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("film",film);
        intent.putExtras(bundle);
        mContext.startActivity  (intent);
    }

    @Override
    public int getItemCount() {
        if(listFilm != null) {
            return listFilm.size();
        }
        return 0;
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder{
//        private final TextView tvId;
        private CardView layoutFilm;
        private final TextView tvTitle;
//        private final TextView tvDes;
//        private final TextView tvDirector;
//        private final TextView tvTime;
        private final TextView tvCategory;
        private final ImageView tvSrcImg;
//        private final TextView tvAge;
        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutFilm = itemView.findViewById(R.id.layout_film);
//            tvId = itemView.findViewById(R.id.tv_id);
            tvTitle = itemView.findViewById(R.id.tv_title);
//            tvDes = itemView.findViewById(R.id.tv_des);
//            tvDirector = itemView.findViewById(R.id.tv_director);
//            tvTime = itemView.findViewById(R.id.tv_time);
            tvCategory = itemView.findViewById(R.id.tv_category);
            tvSrcImg = itemView.findViewById(R.id.tv_srcImg);
//            tvAge = itemView.findViewById(R.id.tv_age);
        }
    }
}
