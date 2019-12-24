package com.illicitintelligence.androidexamples.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.illicitintelligence.androidexamples.view.IncomingFragment;
import com.illicitintelligence.androidexamples.view.MissedFragment;
import com.illicitintelligence.androidexamples.view.OutgoingFragment;

public class HomeFragmentAdapter extends FragmentPagerAdapter {

    private final int INCOMING_CALLS = 0;
    private final int OUTGOING_CALLS = 1;
    private final int MISSED_CALLS = 2;

    public HomeFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment returnFragment = null;

        switch (position) {
            case INCOMING_CALLS:
                returnFragment = new IncomingFragment();
                break;
            case OUTGOING_CALLS:
                returnFragment = new OutgoingFragment();
                break;
            case MISSED_CALLS:
                returnFragment = new MissedFragment();
                break;
            default:
                returnFragment = new Fragment();
                break;
        }
        return returnFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
