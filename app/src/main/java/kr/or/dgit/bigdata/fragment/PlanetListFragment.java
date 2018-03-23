package kr.or.dgit.bigdata.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by DGIT3-12 on 2018-03-22.
 */

public class PlanetListFragment extends ListFragment {

    String[] planet;
    int mListIndex;
    boolean mMumltiPain;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        planet = getResources().getStringArray(R.array.planet);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, planet));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        if(savedInstanceState != null){
            mListIndex = savedInstanceState.getInt("lastIndex");
        }

        View descPanel = getActivity().findViewById(R.id.planetdesc);
        if(descPanel != null && descPanel.getVisibility() == View.VISIBLE){
            mMumltiPain = true;
            onListItemClick(getListView(), null, mListIndex, 0);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lastIndex", mListIndex);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mListIndex = position;
        getListView().setItemChecked(position, true);

        if(mMumltiPain){
            android.support.v4.app.FragmentManager fm = getFragmentManager();
            PlanetDescFragment df = (PlanetDescFragment)fm.findFragmentById(R.id.planetdesc);

            if(df == null || df.mNowIndex != position){
                df = PlanetDescFragment.newInstance(position);
                fm.beginTransaction().replace(R.id.planetdesc, df).commit();
            }
        }else{
            Intent intent = new Intent(getActivity(), PlanerDescActivity.class);
            intent.putExtra("index", position);
            startActivity(intent);
        }
    }
}
