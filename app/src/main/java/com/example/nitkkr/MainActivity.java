package com.example.nitkkr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
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
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.quicklearning)
                    Toast.makeText(MainActivity.this, "Quick Learning Selected", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.blog)
                    Toast.makeText(MainActivity.this, "Blog Selected", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.notes)
                    Toast.makeText(MainActivity.this, "Notes Selected", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.syllabus)
                    Toast.makeText(MainActivity.this, "Syllabus Selected", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.pyqs)
                    Toast.makeText(MainActivity.this, "PYQs Selected", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.contactus)
                    Toast.makeText(MainActivity.this, "Contact Us Selected", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.share)
                    Toast.makeText(MainActivity.this, "Share Selected", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.aboutus)
                    Toast.makeText(MainActivity.this, "About Us Selected", Toast.LENGTH_SHORT).show();
                else if (itemId == R.id.logout)
                    Toast.makeText(MainActivity.this, "Logout Selected", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Unknown Item Selected", Toast.LENGTH_SHORT).show();

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
}