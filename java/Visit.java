package com.example.le_souvenir;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Visit extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private String[] visitData = {"Schloss Hohenzollen", "Tokyo Tower"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);

        // initialise ToolBar
        android.support.v7.widget.Toolbar toolbar =
                (android.support.v7.widget.Toolbar) findViewById(R.id.toolbarVisit);
        setSupportActionBar(toolbar);

        // initialise DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_navig);
        }

        // initialise FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabVisit);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Visit.this, Sightseeing.class);
                startActivity(intent);
            }
        });

        // initialise NavigationView
        navView.setCheckedItem(R.id.trip_list);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.trip_list:
                        Intent intentTrip = new Intent(Visit.this, MainActivity.class);
                        startActivity(intentTrip);
                        break;
                    case R.id.luggage_list:
                        Intent intentLuggage = new Intent(Visit.this, LuggageList.class);
                        startActivity(intentLuggage);
                        break;
                    case R.id.diary:
                        Intent intentDiary = new Intent(Visit.this, DiaryBook.class);
                        startActivity(intentDiary);
                        break;
                    case R.id.budget:
                        Intent intentBudget = new Intent(Visit.this, MyBudget.class);
                        startActivity(intentBudget);
                        break;
                    default:
                }
                return true;
            }
        });

        // initialise ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Visit.this, android.R.layout.simple_list_item_1,
                visitData);
        ListView listView = (ListView) findViewById(R.id.visit_list);
        listView.setAdapter(adapter);


        // initialise buttons
        Button toStay = (Button) findViewById(R.id.buttonStay);
        toStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Visit.this, Stay.class);
                startActivity(intent);
            }
        });

        Button toVisit = (Button) findViewById(R.id.buttonVisit);
        toVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Visit.this, Visit.class);
                startActivity(intent);
            }
        });

        Button toShop = (Button) findViewById(R.id.buttonShop);
        toShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Visit.this, Shop.class);
                startActivity(intent);
            }
        });

        Button toDiary = (Button) findViewById(R.id.buttonDiary);
        toDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Visit.this, DiaryBook.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }
}
