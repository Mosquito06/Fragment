package kr.or.dgit.bigdata.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListFragementDivideEx extends AppCompatActivity implements WordListFragmentDivide.OnWordChangeListener{
    private TextView mTextView;
    private String[] desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragement_divide_ex);

        mTextView = findViewById(R.id.tvWordDec);
        desc = getResources().getStringArray(R.array.word_desc);

    }

    @Override
    public void onWordChanged(int index) {
        mTextView.setText(desc[index]);
    }
}
