package kr.or.dgit.bigdata.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListFragmentEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        if(fm.findFragmentById(android.R.id.content) == null){
            WordListFragment wordListFragment = new WordListFragment();
            fm.beginTransaction().add(android.R.id.content, wordListFragment).commit();
        }
    }
}
