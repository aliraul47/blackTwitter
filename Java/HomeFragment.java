package com.nkima.blacktwitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

public class HomeFragment extends Fragment {
    private FloatingActionButton tweet;
    private TextView theTweetDetails;
    private CircularImageView picture;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate( R.layout.fragment_home, container, false );

        tweet = rootView.findViewById( R.id.tweetButton );
        tweet.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getContext(), WhatsHappeningActivity.class ) );
            }
        } );
        theTweetDetails = rootView.findViewById( R.id.tweet_made_tv );
        theTweetDetails.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getContext(), TweetActivity.class ) );
            }
        } );
        picture = rootView.findViewById( R.id.profile_pic );
        picture.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getContext(), ProfileActivity.class ) );
            }
        } );
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
