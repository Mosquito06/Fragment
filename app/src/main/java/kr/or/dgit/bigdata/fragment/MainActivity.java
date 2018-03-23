package kr.or.dgit.bigdata.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ArrayList<String> datas;
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas = new ArrayList<>();
        listView = findViewById(R.id.main_list_view);

        datas.add("FragmentLifeCycle");
        datas.add("FragmentReuse");
        datas.add("FragmentManager");
        datas.add("FragmentTransfer");
        datas.add("FragmentDataTransfer");
        datas.add("ListFragmentEx");
        datas.add("ListFragementDivideEx");
        datas.add("FragementApplications");
        datas.add("MultiDisplayFragmentEx");
        datas.add("PrefFragment");
        datas.add("Main3Activity");
        datas.add("ViewPager");
        datas.add("ItemListActivity");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), getPackageName() + "." + datas.get(i));
        intent.putExtra("title", String.format("%s %02d", "프래그먼트 ", i+1));
        startActivity(intent);

    }
}
