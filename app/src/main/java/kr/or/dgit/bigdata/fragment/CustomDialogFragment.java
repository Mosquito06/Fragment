package kr.or.dgit.bigdata.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by DGIT3-12 on 2018-03-21.
 */

public class CustomDialogFragment extends DialogFragment {
    NoticeCustomDialogListener mListener;


    public interface NoticeCustomDialogListener{
        void onCustomDialogClick(DialogFragment dialog, String res);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener = (NoticeCustomDialogListener) context;
        }catch(ClassCastException e){
            String msg = "Must Implement NoticeCustomDialogListener";
            throw new ClassCastException(context.toString() + msg);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        final LinearLayout layout = (LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.customer_order, null);
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(args.getString("msg"))
                .setView(layout)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText product = layout.findViewById(R.id.product);
                        EditText number = layout.findViewById(R.id.number);
                        CheckBox payMethod = layout.findViewById(R.id.paymethod);
                        StringBuilder sb = new StringBuilder();
                        sb.append(product.getText() + " ");
                        sb.append(number.getText() + "개");
                        sb.append(payMethod.isChecked()?"착불 결제" : "");
                        mListener.onCustomDialogClick(CustomDialogFragment.this, sb.toString());

                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onCustomDialogClick(CustomDialogFragment.this, "주문을 취소했습니다.");
                    }
                }).create();
    }
}
