package com.anningtex.bottomtabbar.seven;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.anningtex.bottomtabbar.five.fragment.BaseFragment;
import com.anningtex.bottomtabbar.four.OneFragment;
import com.anningtex.bottomtabbar.four.ThreeFragment;
import com.anningtex.bottomtabbar.four.TwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Song
 */
public class FourAdapter extends FragmentPagerAdapter {
    private SevenActivity activity;
    private int count = 0;
    private List<BaseFragment> fragments = new ArrayList<>();

    public FourAdapter(FragmentManager fm, SevenActivity activity) {
        super(fm);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new OneFragment();
        } else if (position == 1) {
            return new TwoFragment();
        } else {
            return new ThreeFragment();
        }
//          return fragments.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
