package kr.or.dgit.bigdata.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DGIT3-12 on 2018-03-19.
 */

public class SaveCounterFragment extends Fragment {
    public static final SaveCounterFragment getInstance(){
        SaveCounterFragment scf = new SaveCounterFragment();
        return scf;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.countfragment, container, false);

        Button btnIncrease = root.findViewById(R.id.btnIncrease);
        final TextView textCounter = root.findViewById(R.id.txtCounter);
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(textCounter.getText().toString());
                textCounter.setText(Integer.toString(count+1));
            }
        });

        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView textCounter = getView().findViewById(R.id.txtCounter);
        int a = Integer.parseInt(textCounter.getText().toString());
        outState.putInt("counter", a);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState != null){
            int a = savedInstanceState.getInt("counter");
            TextView textCounter = getView().findViewById(R.id.txtCounter);
            textCounter.setText(String.valueOf(a));

        }

    }


}
