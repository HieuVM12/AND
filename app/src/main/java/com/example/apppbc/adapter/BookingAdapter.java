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
import com.example.apppbc.model.Date;
import com.example.apppbc.model.Film;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {
    private final List<Date> listDate;
    private Context mContext;
    public BookingAdapter(Context mContext,List<Date> listDate){
        this.mContext = mContext;
        this.listDate = listDate;
    }
    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listdate,parent,false);
        return new BookingAdapter.BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        Date date = listDate.get(position);
        if(date==null){
            return;
        }

        holder.tvDay.setText(date.getDate());
        holder.tvMonth.setText(date.getMonth());

        holder.layoutFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShowDetail(date);
            }
        });


    }

    private void onClickShowDetail(Date date) {
        Intent intent = new Intent(mContext, DetailFilmActivity.class);
        Bundle bundle = new Bundle();
//        bundle.putSerializable("film",film);
//        intent.putExtras(bundle);
//        mContext.startActivity  (intent);
    }

    @Override
    public int getItemCount() {
        if(listDate != null) {
            return listDate.size();
        }
        return 0;
    }

    public static class BookingViewHolder extends RecyclerView.ViewHolder{
        private CardView layoutFilm;
        private final TextView tvDay;
        private final TextView tvMonth;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutFilm = itemView.findViewById(R.id.layout_film);
            tvDay = itemView.findViewById(R.id.tv_day);
            tvMonth = itemView.findViewById(R.id.tv_month);

        }
    }
}
