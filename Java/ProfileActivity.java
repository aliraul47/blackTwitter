package com.nkima.blacktwitter;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private Toolbar mainProfileToolBar;
    private Profile_TabsAccessor profile_tabsAccessor;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton tweet;
    private TextView followStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_profile );

        mainProfileToolBar = findViewById( R.id.profile_Toolbar );
        setSupportActionBar( mainProfileToolBar );
        getSupportActionBar().setTitle( "" );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setDisplayShowHomeEnabled( true );

        profile_tabsAccessor = new Profile_TabsAccessor( getSupportFragmentManager() );

        tabLayout = findViewById( R.id.profile_TabsLayout );

        viewPager = findViewById( R.id.profile_viewPager );

        viewPager.setAdapter( profile_tabsAccessor );

        tabLayout.setupWithViewPager( viewPager );

        tweet = findViewById( R.id.tweetButton );
        tweet.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( ProfileActivity.this, WhatsHappeningActivity.class ) );
            }
        } );

        followStatus = findViewById( R.id.follow_status );
        followStatus.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popUpQuestion();
                //startActivity( new Intent( ProfileActivity.this, WhatsHappeningActivity.class ) );
            }

            private void popUpQuestion() {
                AlertDialog.Builder builder = new AlertDialog.Builder( ProfileActivity.this, R.style.AlertDialog );
                builder.setTitle( "Unfollow!" );
                TextView draftNotice = new TextView( ProfileActivity.this );
                draftNotice.setText( R.string.follow_info );
                builder.setView( draftNotice );

                builder.setPositiveButton( "YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        changeStatus();
                    }

                    private void changeStatus() {
                        followStatus.setText( "Follow" );
                    }
                } );
                builder.setNegativeButton( "NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                } );
                builder.show();
            }
        } );

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.profile_menu, menu );

        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected( item );

        if (item.getItemId() == R.id.action_share) {
        }
        return true;
    }
}
