package kr.or.dgit.bigdata.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by DGIT3-12 on 2018-03-21.
 */

public class ListDialogFragment extends DialogFragment {
    NoticeListDialogListener mListener;


    public interface NoticeListDialogListener{
        void onListDialogClick(DialogFragment dialog, String res);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener = (NoticeListDialogListener) context;
        }catch(ClassCastException e){
            String msg = "Must Implement NoticeListDialogListener";
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
                .setItems(R.array.fruit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] fruit = getResources().getStringArray(R.array.fruit);
                        mListener.onListDialogClick(ListDialogFragment.this, fruit[i]);
                    }
                })
                .setNegativeButton("취소", null).create();
    }
}
