package com.example.khaerulumam.submissionexpert4.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.khaerulumam.submissionexpert4.fragment.FilmFragment;
import com.example.khaerulumam.submissionexpert4.fragment.TVShowFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public ViewPagerAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FilmFragment filmFragmentment = new FilmFragment();
                return filmFragmentment;
            case 1:
                TVShowFragment tvShowFragment = new TVShowFragment();
                return tvShowFragment;

                default:
                    return null;

        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
