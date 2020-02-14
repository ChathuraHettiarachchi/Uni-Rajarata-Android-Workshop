package com.choota.recyclerviewsample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.choota.recyclerviewsample.R;
import com.choota.recyclerviewsample.models.ChatModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<ChatModel> items;
    private Context context;

    public ChatAdapter(List<ChatModel> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_chat_item, parent, false);

        return new ChatViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        ChatModel item = items.get(position);

        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());

        Picasso.get()
                .load(item.getImage())
                .error(R.color.colorPrimaryDark)
                .into(holder.profileImage);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description;
        public ImageView profileImage;


        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            profileImage = itemView.findViewById(R.id.profileImage);
        }
    }
}
