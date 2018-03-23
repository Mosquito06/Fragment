package kr.or.dgit.bigdata.fragment;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlanerDescActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planer_desc);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        int index = getIntent().getExtras().getInt("index");
        PlanetDescFragment details = PlanetDescFragment.newInstance(index);
        getSupportFragmentManager().beginTransaction().add(android.R.id.content, details).commit();

    }
}
