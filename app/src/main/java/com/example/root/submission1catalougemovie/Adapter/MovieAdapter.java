package com.example.root.submission1catalougemovie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.root.submission1catalougemovie.DetailActivity;
import com.example.root.submission1catalougemovie.Helper.Config;
import com.example.root.submission1catalougemovie.Model.ResultsItem;
import com.example.root.submission1catalougemovie.R;

import java.util.ArrayList;

/**
 * Created by root on 7/16/18.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context context;
    //TODO 1
    private ArrayList<ResultsItem> listPopuler;

    //    private ArrayList<MovieModel> listData;

    //TODO 2
    public MovieAdapter(Context context, ArrayList<ResultsItem> listPopuler) {
        this.context = context;
        this.listPopuler = listPopuler;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,
                parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieAdapter.MyViewHolder holder, final int position) {
        //TODO 3
//        http://image.tmdb.org/t/p/w185/5N20rQURev5CNDcMjHVUZhpoCNC.jpg
        holder.tvJudulFilm.setText(listPopuler.get(position).getTitle());
        holder.tvoverview.setText(listPopuler.get(position).getOverview());
        holder.tvrelease.setText(listPopuler.get(position).getReleaseDate());

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + listPopuler.get(position).getPosterPath())
                .into(holder.ivGambarFilm);

        holder.cv_klick_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
//                holder.getItemId();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(Config.BUNDLE_POSTER_IMAGE, "https://image.tmdb.org/t/p/w500" +listPopuler.get(position).getPosterPath());
                intent.putExtra(Config.BUNDLE_TITTLE, holder.tvJudulFilm.getText().toString().trim());
                intent.putExtra(Config.BUNDLE_OVERVIEW, listPopuler.get(position).getOverview());
                intent.putExtra(Config.BUNDLE_RELEASE_DATE, holder.tvrelease.getText().toString().trim());

                intent.putExtra(Config.BUNDLE_VOTE_COUNT, listPopuler.get(position).getVoteCount());
                intent.putExtra(Config.BUNDLE_VOTE_AVERAGE, listPopuler.get(position).getVoteAverage());
                intent.putExtra(Config.BUNDLE_POPULARITY, listPopuler.get(position).getPopularity());
                intent.putExtra(Config.BUNDLE_ORIGINAL_LANGUAGE, listPopuler.get(position).getOriginalLanguage());
                intent.putExtra(Config.BUNDLE_BACKDROPH_IMAGE, "https://image.tmdb.org/t/p/w500" + listPopuler.get(position).getBackdropPath());
                context.startActivity(intent);
            }
        });
    }

    //TODO 4
    @Override
    public int getItemCount() {
        return listPopuler.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGambarFilm;
        TextView tvJudulFilm;
        TextView tvoverview;
        TextView tvrelease;
        CardView cv_klick_detail;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivGambarFilm = itemView.findViewById(R.id.iv_poster);
            tvJudulFilm = itemView.findViewById(R.id.tv_tittle);
            tvoverview = itemView.findViewById(R.id.tv_overview);
            tvrelease = itemView.findViewById(R.id.tv_release);
            cv_klick_detail = itemView.findViewById(R.id.cv_klick_detail);
        }
    }
}
