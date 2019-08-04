package com.nkima.blacktwitter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class NotificationsFragTabsAccessor extends FragmentPagerAdapter {

    NotificationsFragTabsAccessor(FragmentManager fm) {
        super( fm );
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                Notofications_AllFragment notoficationsAllFragment = new Notofications_AllFragment();
                return notoficationsAllFragment;

            case 1:
                Notofications_MentionsFragment notoficationsMentionsFragment = new Notofications_MentionsFragment();
                return notoficationsMentionsFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "All";

            case 1:
                return "Mentions";

            default:
                return null;
        }
    }
}
