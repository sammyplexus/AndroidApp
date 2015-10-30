package com.firstapp.samuelagbede.wordfinder;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by SamuelAgbede on 8/12/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    Fragment f;
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: f = new WelcomePage();
                break;
            case 1: f = new MainPage();
                break;
            case 2:f =  new about();
        }
        return f;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
