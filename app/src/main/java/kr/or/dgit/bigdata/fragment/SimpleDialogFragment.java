package kr.or.dgit.bigdata.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by DGIT3-12 on 2018-03-21.
 */

public class SimpleDialogFragment extends DialogFragment {

    public static SimpleDialogFragment newInstance(String title, String message){
        SimpleDialogFragment sdf = new SimpleDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("message", message);
        sdf.setArguments(args);
        return sdf;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        String title = args.getString("title");
        String msg = args.getString("message");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("확인", listener);
        builder.setNegativeButton("닫기", listener);

        return builder.show();
    }

    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            switch(i){
                case DialogInterface.BUTTON_POSITIVE:
                    doPositiveClick();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    doNegativeClick();
                    break;
            }
        }
    };

    private void doNegativeClick() {
        Toast.makeText(getActivity(), "Negative Click!", Toast.LENGTH_SHORT).show();
    }

    private void doPositiveClick() {
        Toast.makeText(getActivity(), "Positive Click!", Toast.LENGTH_SHORT).show();
    }


}
