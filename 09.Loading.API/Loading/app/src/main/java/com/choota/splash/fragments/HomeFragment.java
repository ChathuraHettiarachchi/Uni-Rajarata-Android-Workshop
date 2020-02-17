package com.choota.splash.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.choota.splash.R;
import com.choota.splash.adapters.PopularMoviesAdapter;
import com.choota.splash.services.api.response.PopularMoviesResponse;
import com.choota.splash.services.sync.PopularMoviesSync;

public class HomeFragment extends Fragment implements PopularMoviesSync.PopularMoviesCallback {

    private RecyclerView recyclerViewPopularMovies;
    private ProgressBar progress;

    private PopularMoviesAdapter adapter;

    // constructor
    public HomeFragment() {
    }

    // new instance method
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI(view);
    }

    private void initUI(View view) {
        progress = view.findViewById(R.id.progress);

        recyclerViewPopularMovies = view.findViewById(R.id.recyclerViewMovies);
        recyclerViewPopularMovies.setVisibility(View.INVISIBLE);
        recyclerViewPopularMovies.setLayoutManager(new LinearLayoutManager(getActivity()));

        loadMovies();
    }

    private void loadMovies() {
        // sync with api
        new PopularMoviesSync(getActivity(), this).movies();
    }

    @Override
    public void onMoviesResponse(boolean status, PopularMoviesResponse response) {
        if (status) {
            progress.setVisibility(View.INVISIBLE);

            adapter = new PopularMoviesAdapter(response.getResults());
            recyclerViewPopularMovies.setVisibility(View.VISIBLE);
            recyclerViewPopularMovies.setAdapter(adapter);
        } else {
            Toast.makeText(getActivity(), "Something went wrong..!", Toast.LENGTH_LONG).show();
        }
    }
}
