package com.lotifurrahman.navigationdrawer;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.lotifurrahman.navigationdrawer.ui.gallery.GalleryFragment;
import com.lotifurrahman.navigationdrawer.ui.home.HomeFragment;
import com.lotifurrahman.navigationdrawer.ui.slideshow.SlideshowFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    GalleryFragment galleryFragment;
    HomeFragment homeFragment;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        //FloatingActionButton
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                setTitle("Nav home");
                Toast.makeText(this, "Nav home", Toast.LENGTH_LONG).show();
                homeFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, homeFragment)
                        .commit();
                break;

            case R.id.nav_gallery:
                setTitle("Nav gallery");
                Toast.makeText(this, "Nav gallery", Toast.LENGTH_LONG).show();
                galleryFragment = new GalleryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, galleryFragment)
                        .commit();
                break;
            case R.id.nav_slideshow:
                Toast.makeText(this, "Nav Slideshow", Toast.LENGTH_LONG).show();
                SlideshowFragment slideshowFragment = new SlideshowFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, slideshowFragment)
                        .commit();
                break;
        }
        return false;
    }
}