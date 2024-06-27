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

public class Drawer extends AppCompatActivity {

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
                switch (item.getItemId()) {
                    case R.id.quicklearning:
                        Toast.makeText(Drawer.this, "Quick Learning Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.blog:
                        Toast.makeText(Drawer.this, "Blog Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.notes:
                        Toast.makeText(Drawer.this, "Notes Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.syllabus:
                        Toast.makeText(Drawer.this, "Syllabus Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.pyqs:
                        Toast.makeText(Drawer.this, "PYQs Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.contactus:
                        Toast.makeText(Drawer.this, "Contact Us Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.share:
                        Toast.makeText(Drawer.this, "Share Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.aboutus:
                        Toast.makeText(Drawer.this, "About Us Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.logout:
                        Toast.makeText(Drawer.this, "Logout Selected", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(Drawer.this, "Unknown Item Selected", Toast.LENGTH_SHORT).show();
                        break;
                }
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
