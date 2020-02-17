package com.choota.splash.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.choota.splash.R;
import com.choota.splash.fragments.FavoriteFragment;
import com.choota.splash.fragments.HomeFragment;
import com.choota.splash.fragments.SearchFragment;
import com.choota.splash.fragments.UpcomingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
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
                    openFragment(HomeFragment.newInstance());
                    return true;
                case R.id.navigationSearch:
                    openFragment(SearchFragment.newInstance());
                    return true;
                case R.id.navigationFavorite:
                    openFragment(FavoriteFragment.newInstance());
                    return true;
                case R.id.navigationUpcomming:
                    openFragment(UpcomingFragment.newInstance());
                    return true;
            }
            return false;
        }
    };
}
