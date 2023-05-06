package com.example.apppbc;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apppbc.adapter.FilmAdapter;
import com.example.apppbc.api.ApiFilm;
import com.example.apppbc.api.ApiService;
import com.example.apppbc.model.Film;
import com.example.apppbc.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainAppActivity  extends AppCompatActivity  {
    private RecyclerView recyclerViewFilm;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainapp);
        recyclerViewFilm = findViewById(R.id.rcv_film);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerViewFilm.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        recyclerViewFilm.addItemDecoration(itemDecoration);
        callApiListFilm();

    }

    private void callApiListFilm() {
        ApiFilm.apiFilm.listFilm().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                Toast.makeText(MainAppActivity.this, "Đăng ký thành công",Toast.LENGTH_SHORT).show();
                List<Film> listFilm = response.body();
                FilmAdapter filmAdapter = new FilmAdapter(MainAppActivity.this,listFilm);
                recyclerViewFilm.setAdapter(filmAdapter);

            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Toast.makeText(MainAppActivity.this, "Đăng ký thất bại",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
