package com.example.khaerulumam.submissionexpert4.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.khaerulumam.submissionexpert4.fragment.FilmFragment;
import com.example.khaerulumam.submissionexpert4.fragment.FilmSQLiteFragment;
import com.example.khaerulumam.submissionexpert4.fragment.TVShowFragment;
import com.example.khaerulumam.submissionexpert4.fragment.TVShowSqliteFragment;


public class ViewPagerSqliteAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public ViewPagerSqliteAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FilmSQLiteFragment filmSQLiteFragment = new FilmSQLiteFragment();
                return filmSQLiteFragment;
            case 1:
                TVShowSqliteFragment tvShowSqliteFragment = new TVShowSqliteFragment();
                return tvShowSqliteFragment;

                default:
                    return null;

        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
