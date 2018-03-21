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

public class QuestionDialogFragment extends DialogFragment {
    NoticeDialogListener mListener;
    Bundle bundle;


    public interface NoticeDialogListener{
        public void onDialogClick(DialogFragment dialog, int res);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener = (NoticeDialogListener) context;
        }catch(ClassCastException e){
            String msg = "Must Implement NoticeDialogListener";
            throw new ClassCastException(context.toString() + msg);
        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        final int a = args.getInt("a");
        final int b = args.getInt("b");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(args.getString("title"));
        builder.setMessage(args.getString("msg"));
        builder.setPositiveButton(args.getString("Q1"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onDialogClick(QuestionDialogFragment.this, a + b);
            }
        });
        builder.setNegativeButton(args.getString("Q2"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onDialogClick(QuestionDialogFragment.this, a*b);
            }
        });


        return builder.create();
    }
}



