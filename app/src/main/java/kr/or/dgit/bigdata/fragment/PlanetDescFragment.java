package kr.or.dgit.bigdata.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by DGIT3-12 on 2018-03-22.
 */

public class PlanetDescFragment extends Fragment {
    int mNowIndex;

    public static PlanetDescFragment newInstance(int index){
        PlanetDescFragment pdf = new PlanetDescFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        pdf.setArguments(args);
        return pdf;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] planetDescs = getResources().getStringArray(R.array.planet_desc);

        View view = inflater.inflate(R.layout.planet_desc_fragment, container, false);
        TextView text = view.findViewById(R.id.planetdesc);

        if(savedInstanceState != null){
            mNowIndex = savedInstanceState.getInt("index");
        }else{
            Bundle args = getArguments();
            mNowIndex = args.getInt("index");
        }

        text.setText(planetDescs[mNowIndex]);

        return view;

    }
}
