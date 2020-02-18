package com.choota.splash.services.sync;

import android.content.Context;

import com.choota.splash.helpers.Const;
import com.choota.splash.services.api.ServiceGenerator;
import com.choota.splash.services.api.response.PopularMoviesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMoviesSync {

    private Context context;
    private PopularMoviesCallback callback;

    public PopularMoviesSync(Context context, PopularMoviesCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void movies() {
        new ServiceGenerator(context).getApiInstance().popularMovies(Const.API_KRY)
                .enqueue(new Callback<PopularMoviesResponse>() {
                    @Override
                    public void onResponse(Call<PopularMoviesResponse> call, Response<PopularMoviesResponse> response) {
                        if (response.isSuccessful()) {
                            callback.onMoviesResponse(true, response.body());
                        } else {
                            callback.onMoviesResponse(false, null);
                        }
                    }

                    @Override
                    public void onFailure(Call<PopularMoviesResponse> call, Throwable t) {
                        callback.onMoviesResponse(false, null);
                    }
                });
    }

    public interface PopularMoviesCallback {
        void onMoviesResponse(boolean status, PopularMoviesResponse response);
    }
}
