package kr.or.dgit.bigdata.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by DGIT3-12 on 2018-03-20.
 */

public class WordListFragment extends ListFragment {
    String[] words;
    String[] desc;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        words = getResources().getStringArray(R.array.word);
        desc = getResources().getStringArray(R.array.word_desc);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, words));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(), words[position] + " : " +desc[position], Toast.LENGTH_SHORT).show();
    }
}
