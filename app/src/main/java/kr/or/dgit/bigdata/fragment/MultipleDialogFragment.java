package kr.or.dgit.bigdata.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.ArrayList;

/**
 * Created by DGIT3-12 on 2018-03-21.
 */

public class MultipleDialogFragment extends DialogFragment {
    NoticeMultipleDialogListener mListener;
    ArrayList<Integer> mSelectLists = new ArrayList<>();


    public interface NoticeMultipleDialogListener{
        void onMultipleDialogClick(DialogFragment dialog, String res);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener = (NoticeMultipleDialogListener) context;
        }catch(ClassCastException e){
            String msg = "Must Implement NoticeMultipleDialogListener";
            throw new ClassCastException(context.toString() + msg);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();

        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(args.getString("msg"))
                .setMultiChoiceItems(R.array.fruit, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                        if(isChecked){
                            mSelectLists.add(i);
                        }else if(mSelectLists.contains(i)){
                            mSelectLists.remove(i);
                        }
                    }
                })
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] fruits = getResources().getStringArray(R.array.fruit);
                        StringBuilder sb = new StringBuilder();
                        for(int idx : mSelectLists){
                            sb.append(fruits[idx] + ",");
                        }
                        sb.delete(sb.length()-2, sb.length()-1);
                        mListener.onMultipleDialogClick(MultipleDialogFragment.this, sb.toString());
                    }
                })
                .setNegativeButton("취소", null).create();
    }
}
