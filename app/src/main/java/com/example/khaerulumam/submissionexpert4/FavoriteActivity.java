package com.example.khaerulumam.submissionexpert4;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.khaerulumam.submissionexpert4.adapter.ViewPagerAdapter;
import com.example.khaerulumam.submissionexpert4.adapter.ViewPagerSqliteAdapter;
import com.google.android.material.tabs.TabLayout;

public class FavoriteActivity extends AppCompatActivity {

   private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private ViewPagerSqliteAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        toolbar.setTitle(getResources().getString(R.string.list_daftar_fil_tvshow));
        setSupportActionBar(toolbar);

        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.film)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tv_show)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPagerAdapter = new ViewPagerSqliteAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        invalidateOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()){
            case R.id.settings:
                Intent pindah = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(pindah);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
