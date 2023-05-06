package com.example.apppbc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apppbc.model.Film;

public class DetailFilmActivity extends AppCompatActivity {
    private Button bookBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Film film = (Film) bundle.get("film");
        TextView tvTitleFilm = findViewById(R.id.tv_title);
        tvTitleFilm.setText(film.getTitle());
        bookBt = findViewById(R.id.buttonBook);
        bookBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailFilmActivity.this, BookingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("film",film);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}