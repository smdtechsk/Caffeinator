// Copyright 2019 SMD Technologies, s.r.o. All rights reserved.

package sk.smdtech.caffeinator.Activities;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import sk.smdtech.caffeinator.R;

public class GraphActivity extends AppCompatActivity {

    // UI Data
    private DrawerLayout drawer_layout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        // UI
        drawer_layout = (DrawerLayout)findViewById(R.id.graph_activity_drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawer_layout,R.string.Open, R.string.Close);
        drawerToggle.setDrawerIndicatorEnabled(true);

        drawer_layout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navView = (NavigationView)findViewById(R.id.graph_activity_nv);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if(id == R.id.overview) {
                    switchIntent(MainActivity.class);
                } else if(id == R.id.graph) {
                    switchIntent(GraphActivity.class);
                }
                finish();
                return true;
            }
        });
    }

    private void switchIntent(Class targetClass) {
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }
}