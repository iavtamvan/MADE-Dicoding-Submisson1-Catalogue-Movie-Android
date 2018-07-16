package com.example.root.submission1catalougemovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.submission1catalougemovie.Adapter.MovieAdapter;
import com.example.root.submission1catalougemovie.Helper.Config;
import com.example.root.submission1catalougemovie.Model.MovieModel;
import com.example.root.submission1catalougemovie.Model.ResultsItem;
import com.example.root.submission1catalougemovie.Rest.GAS.ApiService;
import com.example.root.submission1catalougemovie.Rest.GAS.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private EditText edtCariMovie;
    private Button btnCariMovie;

    private ArrayList<ResultsItem> listResults;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();

        listResults = new ArrayList<>();

        btnCariMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataMovie();
            }
        });
    }

    private void getDataMovie() {
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getMovie(edtCariMovie.getText().toString().trim())
                .enqueue(new Callback<MovieModel>() {
                    @Override
                    public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                        if (response.isSuccessful()) {
                            listResults = response.body().getResults();
                            MovieAdapter adapter = new MovieAdapter(HomeActivity.this, listResults);
                            rv.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
                            rv.setAdapter(adapter);
                            Toast.makeText(HomeActivity.this, "sukses", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(HomeActivity.this, Config.ERROR_LIST, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieModel> call, Throwable t) {
                        Toast.makeText(HomeActivity.this, Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        edtCariMovie = (EditText) findViewById(R.id.edt_cari_movie);
        btnCariMovie = (Button) findViewById(R.id.btn_cari_movie);
        rv = (RecyclerView) findViewById(R.id.rv);
    }
}
