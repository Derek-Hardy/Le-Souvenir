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
import android.widget.ListView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private String[] tripData = {"Germany", "Japan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Make sure this is before calling super.onCreate
        setTheme(R.style.AppTheme);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.exit(0);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise ToolBar
        android.support.v7.widget.Toolbar toolbar =
                (android.support.v7.widget.Toolbar) findViewById(R.id.toolbarMain);
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
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(MainActivity.this, CreateNewTrip.class);
                startActivity(intentCreate);
            }
        });

        // initialise NavigationView
        navView.setCheckedItem(R.id.trip_list);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.trip_list:
                        Intent intentTrip = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intentTrip);
                        break;
                    case R.id.luggage_list:
                        Intent intentLuggage = new Intent(MainActivity.this, LuggageList.class);
                        startActivity(intentLuggage);
                        break;
                    case R.id.diary:
                        Intent intentDiary = new Intent(MainActivity.this, DiaryBook.class);
                        startActivity(intentDiary);
                        break;
                    case R.id.budget:
                        Intent intentBudget = new Intent(MainActivity.this, MyBudget.class);
                        startActivity(intentBudget);
                        break;
                    default:
                }
                return true;
            }
        });

        // initialise ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1,
                tripData);
        ListView listView = (ListView) findViewById(R.id.main_list);
        listView.setAdapter(adapter);

    }

    // To open the drawer menu
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
