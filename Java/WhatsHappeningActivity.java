package com.nkima.blacktwitter;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class WhatsHappeningActivity extends AppCompatActivity {
    private ImageView closeTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_whats_happening );

        closeTweet = findViewById( R.id.closeTweetGround );
        closeTweet.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popUpMenu();
            }

            private void popUpMenu() {
                AlertDialog.Builder builder = new AlertDialog.Builder( WhatsHappeningActivity.this, R.style.AlertDialog );
                builder.setTitle( "Save Draft!" );

                builder.setPositiveButton( "DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        goBack();
                    }

                } );
                builder.setNegativeButton( "SAVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText( WhatsHappeningActivity.this, "Saved", Toast.LENGTH_SHORT ).show();
                        goBack();
                        dialogInterface.cancel();
                    }
                } );
                builder.show();
            }
        } );
    }

    private void goBack() {
        Intent intent = new Intent( WhatsHappeningActivity.this, MainActivity.class );
        startActivity( intent );
    }
}
