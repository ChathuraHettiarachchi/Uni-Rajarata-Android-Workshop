package com.choota.recyclerviewsample.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.choota.recyclerviewsample.R;
import com.choota.recyclerviewsample.adapters.ChatAdapter;
import com.choota.recyclerviewsample.models.ChatModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        populateRecyclerView();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void populateRecyclerView(){
        adapter = new ChatAdapter(generateItems(), this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private List<ChatModel> generateItems(){
        List<ChatModel> dataSet = new ArrayList<>();

        dataSet.add(new ChatModel("Chathura Hettiarachchi", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://blog.hubspot.com/hubfs/instagram-famous.jpg?t=1536925361854"));
        dataSet.add(new ChatModel("Shamalka Herath", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://thoughtcatalog.files.wordpress.com/2016/02/24103673509_709db4d0ed_k.jpg?w=786&h=524"));
        dataSet.add(new ChatModel("John Samaraakoon", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://i.guim.co.uk/img/media/f30270ce63597d332d3fe76bd6c571e51055aad2/0_0_596_426/master/596.jpg?width=300&quality=85&auto=format&fit=max&s=7b2dd74345db39f769637a067db1fffe"));
        dataSet.add(new ChatModel("Chathura Hettiarachchi", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://blog.hubspot.com/hubfs/instagram-famous.jpg?t=1536925361854"));
        dataSet.add(new ChatModel("Shamalka Herath", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://thoughtcatalog.files.wordpress.com/2016/02/24103673509_709db4d0ed_k.jpg?w=786&h=524"));
        dataSet.add(new ChatModel("John Samaraakoon", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://i.guim.co.uk/img/media/f30270ce63597d332d3fe76bd6c571e51055aad2/0_0_596_426/master/596.jpg?width=300&quality=85&auto=format&fit=max&s=7b2dd74345db39f769637a067db1fffe"));
        dataSet.add(new ChatModel("Chathura Hettiarachchi", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://blog.hubspot.com/hubfs/instagram-famous.jpg?t=1536925361854"));
        dataSet.add(new ChatModel("Shamalka Herath", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://thoughtcatalog.files.wordpress.com/2016/02/24103673509_709db4d0ed_k.jpg?w=786&h=524"));
        dataSet.add(new ChatModel("John Samaraakoon", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://i.guim.co.uk/img/media/f30270ce63597d332d3fe76bd6c571e51055aad2/0_0_596_426/master/596.jpg?width=300&quality=85&auto=format&fit=max&s=7b2dd74345db39f769637a067db1fffe"));
        dataSet.add(new ChatModel("Chathura Hettiarachchi", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://blog.hubspot.com/hubfs/instagram-famous.jpg?t=1536925361854"));
        dataSet.add(new ChatModel("Shamalka Herath", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://thoughtcatalog.files.wordpress.com/2016/02/24103673509_709db4d0ed_k.jpg?w=786&h=524"));
        dataSet.add(new ChatModel("John Samaraakoon", "A powerful image downloading and caching library for Android. A powerful image downloading and caching library for Android","https://i.guim.co.uk/img/media/f30270ce63597d332d3fe76bd6c571e51055aad2/0_0_596_426/master/596.jpg?width=300&quality=85&auto=format&fit=max&s=7b2dd74345db39f769637a067db1fffe"));

        return dataSet;
    }
}
