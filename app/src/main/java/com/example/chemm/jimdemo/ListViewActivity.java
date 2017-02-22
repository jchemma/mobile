package com.example.chemm.jimdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.example.chemm.jimdemo.adapter.ViewPagerAdapter;
import com.example.chemm.jimdemo.fragment.ContentFragment;
import com.example.chemm.jimdemo.fragment.HistoryFragment;
import com.example.chemm.jimdemo.fragment.Jim1Fragment;
import com.example.chemm.jimdemo.fragment.Jim2Fragment;
import com.example.chemm.jimdemo.fragment.Jim3Fragment;
import com.example.chemm.jimdemo.fragment.Jim4Fragment;
import com.example.chemm.jimdemo.fragment.Jim5Fragment;
import com.example.chemm.jimdemo.fragment.LoginFragment;

import java.util.ArrayList;

/**
 * Created by chemm on 2/14/2017.
 */

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    private ArrayList<String> listResult;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listResult = new ArrayList<>();
        createFakeResult();
        initialView();
    }

    public void createFakeResult() {
        listResult.add("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaA");
        listResult.add("BBBBBBBBBBBBBBBBBBBBBBBBB");
        listResult.add("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        listResult.add("DD");
        listResult.add("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        listResult.add("F");
        listResult.add("GGGGGGGGGG");
        listResult.add("H");
        listResult.add("I");
        listResult.add("J");
        listResult.add("K");
        listResult.add("L");
        listResult.add("M");
        listResult.add("N");
        listResult.add("O");
        listResult.add("P");
        listResult.add("Q");
    }

    private void initialView() {
        listView = (ListView) findViewById(R.id.list_view);
        View view = getLayoutInflater().inflate(R.layout.list_view_header, null);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager_2);
        // Currently, your ViewPager shows up as a header, but you need to create eight
        // new fragments. Add it to the fragmentList like below, but with new Fragments
        // Right click the Fragment folder, create New --> Fragment --> Fragment (Blank)
        // Name it whatever you want: In each java file in the fragment folder, you'll want
        // to: everything that isn't the super.onDetch() line in onDetach
        // on the onAttach method, delete everything but super.onAttach();
        // Then delete the entire onButtonPressed() method

        fragmentList.add(new HistoryFragment());
        fragmentList.add(new ContentFragment());
        fragmentList.add(new LoginFragment());
        fragmentList.add(new Jim1Fragment());
        fragmentList.add(new Jim2Fragment());
        fragmentList.add(new Jim3Fragment());
        fragmentList.add(new Jim4Fragment());
        fragmentList.add(new Jim5Fragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setFragments(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);

        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("We have no more content.");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"ListView as clicked at position: "+ position, Toast.LENGTH_LONG).show();
        Log.d("testListViewActivity",String.valueOf(position));
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
