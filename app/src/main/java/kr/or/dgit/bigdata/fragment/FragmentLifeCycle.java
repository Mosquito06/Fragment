package kr.or.dgit.bigdata.fragment;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentLifeCycle extends AppCompatActivity {
    final static String TAG = "Fragment_Life_Cycle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Activity - onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_life_cycle);
        setTitle(getIntent().getStringExtra("title"));
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "Activity - onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "Activity - onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "Activity - onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "Activity - onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Activity - onDestroy()");
        super.onDestroy();
    }

    public static class CounterFragment extends Fragment{
        @Override
        public void onAttach(Context context) {
            Log.d(TAG, "\tFragment - onAttach()");
            super.onAttach(context);
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            Log.d(TAG, "\tFragment - onCreate()");
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            Log.d(TAG, "\tFragment - onCreateView()");
            View root = inflater.inflate(R.layout.countfragment, container, false);
            Button btnIncrease = root.findViewById(R.id.btnIncrease);
            final TextView textCounter = root.findViewById(R.id.txtCounter);
            btnIncrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int count = Integer.parseInt(textCounter.getText().toString());
                    textCounter.setText(Integer.toString(count+1));
                }
            });

            return root;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            Log.d(TAG, "\tFragment - onActivityCreated()");
            super.onActivityCreated(savedInstanceState);
        }

        @Override
        public void onStart() {
            Log.d(TAG, "\tFragment - onStart()");
            super.onStart();
        }

        @Override
        public void onResume() {
            Log.d(TAG, "\tFragment - onResume()");
            super.onResume();
        }

        @Override
        public void onPause() {
            Log.d(TAG, "\tFragment - onPause()");
            super.onPause();
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            TextView textCounter = getView().findViewById(R.id.txtCounter);
            int a = Integer.parseInt(textCounter.getText().toString());
            outState.putInt("counter", a);
        }

        @Override
        public void onStop() {
            Log.d(TAG, "\tFragment - onStop()");
            super.onStop();
        }

        @Override
        public void onViewStateRestored(Bundle savedInstanceState) {
            super.onViewStateRestored(savedInstanceState);
            if(savedInstanceState != null){
                int a = savedInstanceState.getInt("counter");
                TextView textCounter = getView().findViewById(R.id.txtCounter);
                textCounter.setText(String.valueOf(a));

            }

        }

        @Override
        public void onDestroyView() {
            Log.d(TAG, "\tFragment - onDestroyView()");
            super.onDestroyView();
        }

        @Override
        public void onDestroy() {
            Log.d(TAG, "\tFragment - onDestroy()");
            super.onDestroy();
        }

        @Override
        public void onDetach() {
            Log.d(TAG, "\tFragment - onDetach()");
            super.onDetach();
        }
    }
}
