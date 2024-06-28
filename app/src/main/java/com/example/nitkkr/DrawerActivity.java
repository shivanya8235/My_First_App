package com.example.nitkkr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                    if(itemId ==  R.id.quicklearning)
                        Toast.makeText(DrawerActivity.this, "Quick Learning Selected", Toast.LENGTH_SHORT).show();

                    else if(itemId == R.id.blog)
                        Toast.makeText(DrawerActivity.this, "Blog Selected", Toast.LENGTH_SHORT).show();
                    else if(itemId == R.id.notes)
                        Toast.makeText(DrawerActivity.this, "Notes Selected", Toast.LENGTH_SHORT).show();
                    else if(itemId ==  R.id.syllabus)
                        Toast.makeText(DrawerActivity.this, "Syllabus Selected", Toast.LENGTH_SHORT).show();
                    else if(itemId == R.id.pyqs)
                        Toast.makeText(DrawerActivity.this, "PYQs Selected", Toast.LENGTH_SHORT).show();
                    else if(itemId == R.id.contactus)
                        Toast.makeText(DrawerActivity.this, "Contact Us Selected", Toast.LENGTH_SHORT).show();
                    else if(itemId == R.id.share)
                        Toast.makeText(DrawerActivity.this, "Share Selected", Toast.LENGTH_SHORT).show();
                    else if(itemId == R.id.aboutus)
                        Toast.makeText(DrawerActivity.this, "About Us Selected", Toast.LENGTH_SHORT).show();
                    else if (itemId == R.id.logout)
                        Toast.makeText(DrawerActivity.this, "Logout Selected", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DrawerActivity.this, "Unknown Item Selected", Toast.LENGTH_SHORT).show();

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
