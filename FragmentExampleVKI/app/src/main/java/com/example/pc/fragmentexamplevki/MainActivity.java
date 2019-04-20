package com.example.pc.fragmentexamplevki;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.pc.fragmentexamplevki.fragments.DietListFragment;
import com.example.pc.fragmentexamplevki.fragments.HealthFragment;
import com.example.pc.fragmentexamplevki.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationItemView bottomNavigationItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationBottom);

        navigation.setOnNavigationItemSelectedListener( mOnNavigationSelectedListener);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, new HomeFragment());
        transaction.commit();
    }
    //Tıklanma ile hangi sayfaya gitmek istediğimizi belirtiyoruz.
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new HealthFragment();
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new DietListFragment();
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, selectedFragment);
            transaction.commit();
            return true;
        }
    };
}