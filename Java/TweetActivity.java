package com.nkima.blacktwitter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class TweetActivity extends AppCompatActivity {
    private Toolbar mainProfileToolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tweet );

        mainProfileToolBar = findViewById( R.id.tweet_Toolbar );
        setSupportActionBar( mainProfileToolBar );
        getSupportActionBar().setTitle( "Tweet" );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setDisplayShowHomeEnabled( true );
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
