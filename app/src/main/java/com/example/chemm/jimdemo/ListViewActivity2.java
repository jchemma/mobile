package com.example.chemm.jimdemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chemm.jimdemo.adapter.ListViewAdapter;

import java.util.ArrayList;

/**
 * Created by chemm on 2/15/2017.
 */

public class ListViewActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    private ArrayList<String> list;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        list = new ArrayList<>();
        createFakeResult();
        initialView();
    }

    public void createFakeResult(){
        list.add("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaA");
        list.add("BBBBBBBBBBBBBBBBBBBBBBBBB");
        list.add("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        list.add("DD");
        list.add("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        list.add("F");
        list.add("GGGGGGGGGG");
        list.add("H");
        list.add("I");
        list.add("J");
        list.add("K");
        list.add("L");
        list.add("M");
        list.add("N");
        list.add("O");
        list.add("P");
        list.add("Q");
    }

    private void initialView(){
        listView = (ListView) findViewById(R.id.list_view);
        View view = getLayoutInflater().inflate(R.layout.list_view_header, null);
        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, list);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("We have no more content");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Toast.makeText(this, "ListView as clicked at position: " + position, Toast.LENGTH_LONG).show();
        Log.d("testListViewActivity", String.valueOf(position));
    }

}
