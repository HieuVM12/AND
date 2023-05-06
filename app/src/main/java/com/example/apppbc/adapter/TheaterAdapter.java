package com.example.apppbc.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apppbc.BookDetailActivity;
import com.example.apppbc.DetailFilmActivity;
import com.example.apppbc.R;
import com.example.apppbc.model.Date;
import com.example.apppbc.model.Theater;

import java.util.List;

public class TheaterAdapter extends RecyclerView.Adapter<TheaterAdapter.TheaterViewHolder> {
    private final List<Theater> listTheater;
    private Context mContext;

    public TheaterAdapter(Context mContext,List<Theater> listTheater){
        this.mContext = mContext;
        this.listTheater = listTheater;
    }
    @NonNull
    @Override
    public TheaterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listtheater,parent,false);
        return new TheaterAdapter.TheaterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheaterViewHolder holder, int position) {
        Theater theater = listTheater.get(position);
        if(theater==null){
            return;
        }

        holder.tvTheater.setText(theater.getNameTheater());


        holder.tvH1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShowDetail(holder.tvH1.getText().toString());
            }
        });
        holder.tvH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShowDetail(holder.tvH1.getText().toString());
            }
        });
        holder.tvH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShowDetail(holder.tvH1.getText().toString());
            }
        });
        holder.tvH4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShowDetail(holder.tvH1.getText().toString());
            }
        });
        holder.tvH5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShowDetail(holder.tvH1.getText().toString());
            }
        });


    }

    private void onClickShowDetail(String hour) {
        Intent intent = new Intent(mContext, BookDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("film",hour);
        intent.putExtras(bundle);
        mContext.startActivity  (intent);
    }

    @Override
    public int getItemCount() {
        if(listTheater != null) {
            return listTheater.size();
        }
        return 0;
    }

    public static class TheaterViewHolder extends RecyclerView.ViewHolder{
        private CardView layoutFilm;
        private final TextView tvTheater;
        private TextView tvH1;
        private TextView tvH2;
        private TextView tvH3;
        private TextView tvH4;
        private TextView tvH5;


        public TheaterViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutFilm = itemView.findViewById(R.id.layout_film);
            tvTheater = itemView.findViewById(R.id.tv_theater);

            tvH1 = itemView.findViewById(R.id.tv_hour1);
            tvH2 = itemView.findViewById(R.id.tv_hour2);
            tvH3 = itemView.findViewById(R.id.tv_hour3);
            tvH4 = itemView.findViewById(R.id.tv_hour4);
            tvH5 = itemView.findViewById(R.id.tv_hour5);

        }
    }
}
