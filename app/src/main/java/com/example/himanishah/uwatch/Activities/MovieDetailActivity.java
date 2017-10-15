package com.example.himanishah.uwatch.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.himanishah.uwatch.Fragments.MovieDetailFragment;
import com.example.himanishah.uwatch.R;

public class MovieDetailActivity extends AppCompatActivity {

    private Bundle bundle;
    private Fragment movieDetail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //Creating Fragment MovieDetailFragment
        bundle = getIntent().getExtras();
        movieDetail = new MovieDetailFragment();
        movieDetail.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.movie_detail_container, movieDetail)
                .commit();
    }
}

