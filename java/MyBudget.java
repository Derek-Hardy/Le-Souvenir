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

public class MyBudget extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private String[] budgetData = {"Germany", "Japan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_budget);

        // initialise ToolBar
        android.support.v7.widget.Toolbar toolbar =
                (android.support.v7.widget.Toolbar) findViewById(R.id.toolbarBudget);
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
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabBudget);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // need to create a luggage item creation page
                Intent intent = new Intent(MyBudget.this, InputBudget.class);

                startActivity(intent);
                // need to change to 'startActivityForResult()' later
            }
        });

        // initialise NavigationView
        navView.setCheckedItem(R.id.trip_list);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.trip_list:
                        Intent intentTrip = new Intent(MyBudget.this, MainActivity.class);
                        startActivity(intentTrip);
                        break;
                    case R.id.luggage_list:
                        Intent intentLuggage = new Intent(MyBudget.this, LuggageList.class);
                        startActivity(intentLuggage);
                        break;
                    case R.id.diary:
                        Intent intentDiary = new Intent(MyBudget.this, DiaryBook.class);
                        startActivity(intentDiary);
                        break;
                    case R.id.budget:
                        Intent intentBudget = new Intent(MyBudget.this, MyBudget.class);
                        startActivity(intentBudget);
                        break;
                    default:
                }
                return true;
            }
        });

        // initialise ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MyBudget.this, android.R.layout.simple_list_item_1,
                budgetData);
        ListView listView = (ListView) findViewById(R.id.budget_list);
        listView.setAdapter(adapter);
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
