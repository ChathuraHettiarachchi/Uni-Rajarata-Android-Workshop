package com.choota.splash.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.choota.splash.R;
import com.choota.splash.services.api.response.PopularMoviesResponse;
import com.choota.splash.services.sync.PopularMoviesSync;

public class HomeFragment extends Fragment implements PopularMoviesSync.PopularMoviesCallback {

    // constructor
    public HomeFragment() {
    }

    // new instance method
    public static HomeFragment newInstance(){
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

        initUI();
    }

    private void initUI() {
        // sync with api
        new PopularMoviesSync(getActivity(), this).movies();
    }

    @Override
    public void onMoviesResponse(boolean status, PopularMoviesResponse response) {
        if (status)
            Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getActivity(), "Not working", Toast.LENGTH_LONG).show();
    }
}
