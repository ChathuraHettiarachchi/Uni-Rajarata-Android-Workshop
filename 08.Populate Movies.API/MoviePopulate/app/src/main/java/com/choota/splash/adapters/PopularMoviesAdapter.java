package com.choota.splash.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.choota.splash.R;
import com.choota.splash.helpers.Const;
import com.choota.splash.services.api.response.PopularMovie;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.MoviesHolder> {

    private List<PopularMovie> items;

    public PopularMoviesAdapter(List<PopularMovie> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_home_movie, parent, false);

        return new MoviesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesHolder holder, int position) {
        PopularMovie item = items.get(position);

        holder.title.setText(item.getTitle());
        holder.rating.setText(item.getVoteAverage() + "/10");
        holder.genres.setText("Genres here");
        holder.releaseDate.setText(item.getReleaseDate());

        String imagePath = Const.IMAGE_BASE_URL+item.getPosterPath();
        Picasso.get()
                .load(imagePath)
                .placeholder(R.color.placeholder)
                .error(R.color.error)
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public class MoviesHolder extends RecyclerView.ViewHolder {

        public TextView title, rating, releaseDate, genres;
        public RoundedImageView poster;

        public MoviesHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtTitle);
            genres = itemView.findViewById(R.id.txtGenres);
            rating = itemView.findViewById(R.id.txtRating);
            releaseDate = itemView.findViewById(R.id.txtReleaseDate);
            poster = itemView.findViewById(R.id.imgPoster);
        }
    }
}
