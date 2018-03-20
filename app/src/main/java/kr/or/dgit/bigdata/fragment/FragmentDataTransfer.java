package kr.or.dgit.bigdata.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentDataTransfer extends AppCompatActivity implements FragmentToolBar.ToolBarListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_data_transfer);
    }

    @Override
    public void onButtonClick(int fontSize, String text) {
        FragmentText textFragment = (FragmentText)getSupportFragmentManager().findFragmentById(R.id.text_fragment);
        textFragment.changeTextProperties(fontSize, text);
    }

    @Override
    public void onButtonClick(int fontSize) {
        FragmentText textFragment = (FragmentText)getSupportFragmentManager().findFragmentById(R.id.text_fragment);
        textFragment.changeTextProperties(fontSize);
    }
}
