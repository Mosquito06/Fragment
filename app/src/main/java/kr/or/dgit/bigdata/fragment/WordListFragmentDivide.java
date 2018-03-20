package kr.or.dgit.bigdata.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by DGIT3-12 on 2018-03-20.
 */

public class WordListFragmentDivide extends ListFragment{
    String[] words;
    String[] desc;
    OnWordChangeListener mListener;

    public interface OnWordChangeListener{
        void onWordChanged(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener = (OnWordChangeListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException("activity must implements OnWordChangeListener");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(ArrayAdapter.createFromResource(getContext(), R.array.word,android.R.layout.simple_list_item_1));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mListener.onWordChanged(position);
    }
}

