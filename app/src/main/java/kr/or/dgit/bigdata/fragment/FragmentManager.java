package kr.or.dgit.bigdata.fragment;

import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentManager extends AppCompatActivity {
    android.support.v4.app.FragmentManager mFragmentManager;
    android.support.v4.app.Fragment mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_manager);
        setTitle(getIntent().getStringExtra("title"));
        mFragmentManager = getSupportFragmentManager();

    }

    public static class TextFragment extends Fragment{
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.textfragment, container, false);
            TextView text = root.findViewById(R.id.text);
            text.setSaveEnabled(true);
            return root;
        }
    }

    public void mAddClick(View view) {
        mFragment = mFragmentManager.findFragmentById(R.id.frame);
        if(mFragment == null){
            SaveCounterFragment scf = SaveCounterFragment.getInstance();
            mFragmentManager.beginTransaction().add(R.id.frame, scf, "saveCounter").commit();
        }else{
            Toast.makeText(this, "이미 추가되었습니다.", Toast.LENGTH_SHORT).show();
        }

    }

    public void mRemoveClick(View view) {
        mFragment = mFragmentManager.findFragmentById(R.id.frame);
        if(mFragment == null){
            Toast.makeText(this, "삭제할 프래그먼트가 존재하지 않음", Toast.LENGTH_SHORT).show();
        }else{
            mFragmentManager.beginTransaction().remove(mFragment).commit();
        }
    }

    public void mReplaceClick(View view) {
        mFragment = mFragmentManager.findFragmentById(R.id.frame);
        if(mFragment == null){
            Toast.makeText(this, "교체할 프래그먼트가 존재하지 않음", Toast.LENGTH_SHORT).show();
        }else{
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            if(mFragment.getTag().equals("saveCounter")){
                TextFragment tf = new TextFragment();
                ft.replace(R.id.frame, tf, "textFragment");
            }else{
                SaveCounterFragment scf = SaveCounterFragment.getInstance();
                ft.replace(R.id.frame, scf, "saveCounter");
            }

            ft.commit();
        }

    }

    public void mHideClick(View view) {
        mFragment = mFragmentManager.findFragmentById(R.id.frame);
        Button btn = findViewById(R.id.btnHide);
        if(mFragment == null){
            Toast.makeText(this, "프래그먼트가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
        }else{
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            if(mFragment.isHidden()){
                ft.show(mFragment);
                btn.setText("Hide");
            }else{
                ft.hide(mFragment);
                btn.setText("Show");
            }

            ft.commit();
        }

    }
}
