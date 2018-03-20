package kr.or.dgit.bigdata.fragment;

import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FragmentTransfer extends AppCompatActivity {
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transfer);
        setTitle(getIntent().getStringExtra("title"));
        mEditText = findViewById(R.id.startNum);
   }

    public void mAddClick(View view) {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        int start = Integer.parseInt(mEditText.getText().toString());
        CounterFragment cf = CounterFragment.newInstace(start);
        ft.addToBackStack(null);
        ft.add(R.id.frame, cf, "counter");
        ft.commit();

    }
}
