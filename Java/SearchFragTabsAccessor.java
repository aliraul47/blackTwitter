package com.nkima.blacktwitter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SearchFragTabsAccessor extends FragmentPagerAdapter {

    SearchFragTabsAccessor(FragmentManager fm) {
        super( fm );
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                Search_ForYouFragment search_forYouFragment = new Search_ForYouFragment();
                return search_forYouFragment;

            case 1:
                Search_NewsFragment search_newsFragment = new Search_NewsFragment();
                return search_newsFragment;

            case 2:
                Search_SportsFragment search_sportsFragment = new Search_SportsFragment();
                return search_sportsFragment;

            case 3:
                Search_FunFragment search_funFragment = new Search_FunFragment();
                return search_funFragment;

            case 4:
                Search_EntertainmentFragment search_entertainmentFragment = new Search_EntertainmentFragment();
                return search_entertainmentFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "For you";

            case 1:
                return "News";

            case 2:
                return "Sports";

            case 3:
                return "Fun";

            case 4:
                return "Entertainment";

            default:
                return null;
        }
    }
}
