package com.nkima.blacktwitter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Profile_TabsAccessor extends FragmentPagerAdapter {

    Profile_TabsAccessor(FragmentManager fm) {
        super( fm );
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                Profile_TweetsFragment profile_tweetsFragment = new Profile_TweetsFragment();
                return profile_tweetsFragment;

            case 1:
                Profile_TweetsAndRepliesFragment profile_tweetsAndRepliesFragment = new Profile_TweetsAndRepliesFragment();
                return profile_tweetsAndRepliesFragment;

            case 2:
                Profile_MediaFragment profile_mediaFragment = new Profile_MediaFragment();
                return profile_mediaFragment;

            case 3:
                Profile_LikesFragment profile_likesFragment = new Profile_LikesFragment();
                return profile_likesFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Tweets";

            case 1:
                return "Tweets n Replies";

            case 2:
                return "Media";

            case 3:
                return "Likes";

            default:
                return null;
        }
    }
}
