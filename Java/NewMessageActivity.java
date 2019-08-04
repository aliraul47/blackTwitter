package com.nkima.blacktwitter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class NewMessageActivity extends AppCompatActivity {
    private Toolbar mainProfileToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_new_message );

        mainProfileToolBar = findViewById( R.id.new_msg_Toolbar );
        setSupportActionBar( mainProfileToolBar );
        getSupportActionBar().setTitle( "New Message" );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setDisplayShowHomeEnabled( true );
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
