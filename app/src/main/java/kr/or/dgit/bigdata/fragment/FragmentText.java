package kr.or.dgit.bigdata.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by DGIT3-12 on 2018-03-20.
 */

public class FragmentText extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        textView = view.findViewById(R.id.textView);

        return view;
    }

    public void changeTextProperties(int fontSize, String text){
        textView.setTextSize(fontSize);
        textView.setText(text);
    }

    public void changeTextProperties(int fontSize){
        textView.setTextSize(fontSize);
    }
}
