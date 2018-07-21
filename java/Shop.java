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

public class Shop extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private String[] shopData = {"RitterSport", "Dorayaki"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        // initialise ToolBar
        android.support.v7.widget.Toolbar toolbar =
                (android.support.v7.widget.Toolbar) findViewById(R.id.toolbarShop);
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
    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabShop);
        fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Shop.this, ToBuy.class);

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
                    Intent intentTrip = new Intent(Shop.this, MainActivity.class);
                    startActivity(intentTrip);
                    break;
                case R.id.luggage_list:
                    Intent intentLuggage = new Intent(Shop.this, LuggageList.class);
                    startActivity(intentLuggage);
                    break;
                case R.id.diary:
                    Intent intentDiary = new Intent(Shop.this, DiaryBook.class);
                    startActivity(intentDiary);
                    break;
                case R.id.budget:
                    Intent intentBudget = new Intent(Shop.this, MyBudget.class);
                    startActivity(intentBudget);
                    break;
                default:
            }
            return true;
        }
    });


    // initialise ListView
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            Shop.this, android.R.layout.simple_list_item_1,
            shopData);
    ListView listView = (ListView) findViewById(R.id.shop_list);
        listView.setAdapter(adapter);


    // initialise buttons
    Button toStay = (Button) findViewById(R.id.buttonStay);
        toStay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Shop.this, Stay.class);
            startActivity(intent);
        }
    });

    Button toVisit = (Button) findViewById(R.id.buttonVisit);
        toVisit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Shop.this, Visit.class);
            startActivity(intent);
        }
    });

    Button toShop = (Button) findViewById(R.id.buttonShop);
        toShop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent =  new Intent(Shop.this, Shop.class);
            startActivity(intent);
        }
    });

    Button toDiary = (Button) findViewById(R.id.buttonDiary);
        toDiary.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Shop.this, DiaryBook.class);
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
