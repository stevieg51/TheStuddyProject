package com.example.thestuddyproject;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPage extends AppCompatActivity
        implements BottomNavigationView
        .OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        bottomNavigationView
                = findViewById(R.id.bottom_navigation);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.nav_clock);
    }
    HomeFragment homeFragment = new HomeFragment();
    ToDoFragment toDoFragment = new ToDoFragment();
    CalendarFragment calendarFragment = new CalendarFragment();

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {
        int theItem = item.getItemId();
        if (theItem == R.id.nav_clock) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, homeFragment)
                    .commit();
            return true;
        } else if (theItem == R.id.nav_cal) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, calendarFragment)
                    .commit();
            return true;
        } else if (theItem ==  R.id.toDo) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, toDoFragment)
                    .commit();
            return true;
        }
       return false;
    }
}

