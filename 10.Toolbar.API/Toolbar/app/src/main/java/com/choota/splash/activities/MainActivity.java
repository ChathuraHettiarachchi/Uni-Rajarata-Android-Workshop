package com.choota.splash.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.choota.splash.R;
import com.choota.splash.fragments.FavoriteFragment;
import com.choota.splash.fragments.HomeFragment;
import com.choota.splash.fragments.SearchFragment;
import com.choota.splash.fragments.UpcomingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    TextView pageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        pageTitle = findViewById(R.id.pageTitle);

        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        // make ui populated on first start
        // openFragment(HomeFragment.newInstance());

        // using navigation
        bottomNav.setSelectedItemId(R.id.navigationHome);
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.navigationHome:
                    pageTitle.setText("Popular Movies");
                    openFragment(HomeFragment.newInstance());
                    return true;
                case R.id.navigationSearch:
                    pageTitle.setText("Search");
                    openFragment(SearchFragment.newInstance());
                    return true;
                case R.id.navigationFavorite:
                    pageTitle.setText("Favorites");
                    openFragment(FavoriteFragment.newInstance());
                    return true;
                case R.id.navigationUpcomming:
                    pageTitle.setText("Upcoming Movies");
                    openFragment(UpcomingFragment.newInstance());
                    return true;
            }
            return false;
        }
    };
}
