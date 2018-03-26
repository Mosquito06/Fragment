package kr.or.dgit.bigdata.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    android.support.v4.view.ViewPager viewPager;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        relativeLayout = (RelativeLayout) findViewById(R.id.lab2_container);
        viewPager = ( android.support.v4.view.ViewPager) findViewById(R.id.lab2_viewpager);
        viewPager.setAdapter(new MyPagerAdater(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.lab2_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);
    }

    class MyPagerAdater extends FragmentPagerAdapter{
        List<Fragment> fragments = new ArrayList<Fragment>();
        private String[] titles = {"TAB1", "TAB2", "TAB3"};

        public MyPagerAdater(android.support.v4.app.FragmentManager fm) {
            super(fm);
            fragments.add(new OneFragment());
            fragments.add(new TwoFragment());
            fragments.add(new ThreeFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

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
}
