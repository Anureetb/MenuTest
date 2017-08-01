package com.example.anureet.menutest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anureet on 14-07-2017.
 */

class ViewPagerAdapter  extends FragmentPagerAdapter{
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
    @Override
    public int getCount() {

        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        switch (position){
//                case 0:
//                    return "payment";
//                case 1:
//                    return "debt";
//                case 2:
//                    return "Notes";
//        }
        return "TAB" + position;
    }
}
