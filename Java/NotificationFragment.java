package com.nkima.blacktwitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NotificationFragment extends Fragment {
    private NotificationsFragTabsAccessor notificationsFragTabsAccessor;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton tweet;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate( R.layout.fragment_notifications, container, false );

        notificationsFragTabsAccessor = new NotificationsFragTabsAccessor( getChildFragmentManager() );

        tabLayout = rootView.findViewById( R.id.ntf_frag_TabLayout );

        viewPager = rootView.findViewById( R.id.ntf_frag_viewPager );

        viewPager.setAdapter( notificationsFragTabsAccessor );

        tabLayout.setupWithViewPager( viewPager );

        tweet = rootView.findViewById( R.id.tweetButton );
        tweet.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getContext(), WhatsHappeningActivity.class ) );
            }
        } );

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
