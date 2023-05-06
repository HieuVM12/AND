package com.example.apppbc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apppbc.adapter.BookingAdapter;
import com.example.apppbc.adapter.FilmAdapter;
import com.example.apppbc.adapter.TheaterAdapter;
import com.example.apppbc.api.ApiFilm;
import com.example.apppbc.model.Date;
import com.example.apppbc.model.Film;
import com.example.apppbc.model.Theater;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFilm;
    private RecyclerView recyclerViewTheater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        recyclerViewFilm = findViewById(R.id.rcv_date);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerViewFilm.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        recyclerViewFilm.addItemDecoration(itemDecoration);

        List<Date> listDate = new ArrayList<>();
        Date date;
        for(int i=1; i<=30;i++){
            date = new Date(Long.parseLong(i+""),i+"","5","2023");
            listDate.add(date);
        }
        BookingAdapter bookingAdapter = new BookingAdapter(this,listDate);
        recyclerViewFilm.setAdapter(bookingAdapter);



        recyclerViewTheater = findViewById(R.id.rcv_theater);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerViewTheater.setLayoutManager(linearLayoutManager1);
        DividerItemDecoration itemDecoration1 = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerViewTheater.addItemDecoration(itemDecoration1);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Film film = (Film) bundle.get("film");
        callApiListTheater(film);





    }

    private void callApiListTheater(Film film) {
        ApiFilm.apiFilm.getFilm(film.getId()).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {

                Film film = response.body();
                TheaterAdapter theaterAdapter = new TheaterAdapter(BookingActivity.this,film.getSchedule().getTheater());
                recyclerViewTheater.setAdapter(theaterAdapter);

            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                Toast.makeText(BookingActivity.this, "Đăng ký thất bại",Toast.LENGTH_SHORT).show();

            }
        });
    }
}