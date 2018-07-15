package com.example.root.submission1catalougemovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.root.submission1catalougemovie.Helper.Config;

public class DetailMovieActivity extends AppCompatActivity {

    String image;
    String tittle;
    String overview;
    String release;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        Intent intent = getIntent();
        image  = intent.getStringExtra(Config.BUNDLE_IMAGE);
        tittle = intent.getStringExtra(Config.BUNDLE_TITTLE);
        overview = intent.getStringExtra(Config.BUNDLE_OVERVIEW);
        release = intent.getStringExtra(Config.BUNDLE_RELEASE_DATE);

        Toast.makeText(this, "" + image + tittle + overview + release, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "" + image + tittle + overview + release, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "" + image + tittle + overview + release, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "" + image + tittle + overview + release, Toast.LENGTH_SHORT).show();

    }
}
