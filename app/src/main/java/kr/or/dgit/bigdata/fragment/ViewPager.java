package kr.or.dgit.bigdata.fragment;

import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        android.support.v4.view.ViewPager pager = (android.support.v4.view.ViewPager) findViewById(R.id.lab2_pager);
        MyPagerAdater pagerAdater = new MyPagerAdater(getSupportFragmentManager());
        pager.setAdapter(pagerAdater);
    }


    class MyPagerAdater extends FragmentPagerAdapter{
        ArrayList<Fragment> fragments;

        public MyPagerAdater(android.support.v4.app.FragmentManager manager) {
            super(manager);
            fragments = new ArrayList<>();
            fragments.add(new OneFragment());
            fragments.add(new ThreeFragment());
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
    }
}
