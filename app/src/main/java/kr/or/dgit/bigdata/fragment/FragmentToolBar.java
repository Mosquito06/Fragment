package kr.or.dgit.bigdata.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 * Created by DGIT3-12 on 2018-03-20.
 */

public class FragmentToolBar extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private int seekValue = 10;
    private EditText editText;

    ToolBarListener activityCallBack;

    public interface ToolBarListener{
        void onButtonClick(int fontSize, String text);
        void onButtonClick(int fontSize);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityCallBack = (ToolBarListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement TollbarListener");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);
        editText = view.findViewById(R.id.editText);
        SeekBar seekBar = view.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        Button btn = view.findViewById(R.id.fragementBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(view);
            }
        });

        return view;

    }

    private void buttonClicked(View view) {
        activityCallBack.onButtonClick(seekValue, editText.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        seekValue = i;
        activityCallBack.onButtonClick(seekValue);
        Toast.makeText(getActivity(), seekValue + "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
