package kr.or.dgit.bigdata.fragment;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FragementApplications extends AppCompatActivity implements QuestionDialogFragment.NoticeDialogListener,
        ListDialogFragment.NoticeListDialogListener, SingleDialogFragment.NoticeSingleDialogListener,
        MultipleDialogFragment.NoticeMultipleDialogListener, CustomDialogFragment.NoticeCustomDialogListener{
    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragement_applications);

        mTextView = findViewById(R.id.result_text);
    }

    public void btnClick(View view) {
        switch (view.getId()){
            case R.id.dialogBtn:
                SimpleDialogFragment sdf = SimpleDialogFragment.newInstance("알립니다.", "대화상자를 열었습니다.");
                sdf.setCancelable(false);
                sdf.show(getSupportFragmentManager(), "Dialog");
                break;
            case R.id.questionBtn:
                QuestionDialogFragment qdf = new QuestionDialogFragment();
                Bundle args = new Bundle();
                args.putString("title", "질문");
                args.putString("msg", "어떤 연산을 하시겠습니까?");
                args.putString("Q1", "덧셈");
                args.putString("Q2", "곱셈");
                args.putInt("a", 3);
                args.putInt("b", 4);
                qdf.setArguments(args);
                qdf.show(getSupportFragmentManager(), "Dialog");
                break;
            case R.id.listBtn:
                ListDialogFragment ldf = new ListDialogFragment();
                Bundle args2 = new Bundle();
                args2.putString("msg", "음식을 선택하세요.");
                ldf.setArguments(args2);
                ldf.show(getSupportFragmentManager(), "ListDialog");
                break;
            case R.id.singleChoiceBtn:
                SingleDialogFragment sdf2 = new SingleDialogFragment();
                Bundle args3 = new Bundle();
                args3.putString("msg", "과일을 선택하세요.");
                sdf2.setArguments(args3);
                sdf2.show(getSupportFragmentManager(), "SingleDialog");
                break;
            case R.id.multiChoiceBtn:
                MultipleDialogFragment mdf = new MultipleDialogFragment();
                Bundle args4 = new Bundle();
                args4.putString("msg", "과일을 선택하세요.");
                mdf.setArguments(args4);
                mdf.show(getSupportFragmentManager(), "MultiDialog");

                break;
            case R.id.customBtn:
                CustomDialogFragment cdf = new CustomDialogFragment();
                Bundle args5 = new Bundle();
                args5.putString("msg", "과일을 선택하세요.");
                cdf.setArguments(args5);
                cdf.show(getSupportFragmentManager(), "CustomDialog");
                break;
        }


    }

    @Override
    public void onDialogClick(DialogFragment dialog, int res) {
        mTextView.setText("연산결과 = " + res);
        Toast.makeText(this, "연산을 완료하였습니다.", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onListDialogClick(DialogFragment dialog, String res) {
        mTextView.setText("선택과일 = " + res);
        Toast.makeText(this, res + " 를 선택하였습니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSingleDialogClick(DialogFragment dialog, String res) {
        mTextView.setText("선택과일 = " + res);
        Toast.makeText(this, res + " 를 선택하였습니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMultipleDialogClick(DialogFragment dialog, String res) {
        mTextView.setText("선택과일 = " + res);
        Toast.makeText(this, res + " 를 선택하였습니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCustomDialogClick(DialogFragment dialog, String res) {
        mTextView.setText("선택과일 = " + res);
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
    }
}
