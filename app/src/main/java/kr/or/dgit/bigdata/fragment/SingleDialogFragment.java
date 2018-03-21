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

public class SingleDialogFragment extends DialogFragment {
    NoticeSingleDialogListener mListener;
    int mSelect;


    public interface NoticeSingleDialogListener{
        void onSingleDialogClick(DialogFragment dialog, String res);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener = (NoticeSingleDialogListener) context;
        }catch(ClassCastException e){
            String msg = "Must Implement NoticeSingleDialogListener";
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
                .setSingleChoiceItems(R.array.fruit, mSelect, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mSelect = i;
                    }
                })
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] fruits = getResources().getStringArray(R.array.fruit);
                        mListener.onSingleDialogClick(SingleDialogFragment.this, fruits[mSelect]);
                    }
                })
                .setNegativeButton("취소", null).create();

    }
}
