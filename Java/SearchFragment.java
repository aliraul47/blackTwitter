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

public class SearchFragment extends Fragment {
    private SearchFragTabsAccessor searchFragTabsAccessor;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton tweet;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate( R.layout.fragment_search, container, false );

        searchFragTabsAccessor = new SearchFragTabsAccessor( getChildFragmentManager() );

        tabLayout = rootView.findViewById( R.id.search_frag_TabLayout );

        viewPager = rootView.findViewById( R.id.search_frag_viewPager );

        viewPager.setAdapter( searchFragTabsAccessor );

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
