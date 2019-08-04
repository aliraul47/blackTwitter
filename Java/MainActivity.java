package com.nkima.blacktwitter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar mainProfileToolBar;
    private NavigationView navigationView;
    private ImageView blockedButton;
    private View drawerFooter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Fragment homeFragment = new HomeFragment();
                    loadFragment( homeFragment );
                    break;
                case R.id.navigation_search:
                    Fragment srchFragment = new SearchFragment();
                    loadFragment( srchFragment );
                    break;
                case R.id.navigation_notifications:
                    Fragment ntfFragment = new NotificationFragment();
                    loadFragment( ntfFragment );
                    break;
                case R.id.navigation_messages:
                    Fragment messagesFragment = new MessagesFragment();
                    loadFragment( messagesFragment );
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        HomeFragment homeFragment = new HomeFragment();

        loadFragment( homeFragment );

        BottomNavigationView navigation = findViewById( R.id.navigation );
        navigation.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener );

        mainProfileToolBar = findViewById( R.id.mainHomeToolbar );
        setSupportActionBar( mainProfileToolBar );
        getSupportActionBar().setTitle( "Home" );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setDisplayShowHomeEnabled( true );

        drawerLayout = findViewById( R.id.profile_drawer_layout );
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, mainProfileToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawerLayout.addDrawerListener( actionBarDrawerToggle );
        actionBarDrawerToggle.syncState();
        navigationView = findViewById( R.id.profile_nav_view );
        navigationView.setNavigationItemSelectedListener( this );
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace( R.id.frameLayout, fragment );
        transaction.addToBackStack( null );
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
