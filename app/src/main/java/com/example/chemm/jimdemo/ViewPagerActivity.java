package com.example.chemm.jimdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.chemm.jimdemo.adapter.ViewPagerAdapter;
import com.example.chemm.jimdemo.bean.Book;
import com.example.chemm.jimdemo.fragment.ContentFragment;
import com.example.chemm.jimdemo.fragment.HistoryFragment;
import com.example.chemm.jimdemo.fragment.Jim1Fragment;
import com.example.chemm.jimdemo.fragment.Jim2Fragment;
import com.example.chemm.jimdemo.fragment.Jim3Fragment;
import com.example.chemm.jimdemo.fragment.Jim4Fragment;
import com.example.chemm.jimdemo.fragment.Jim5Fragment;
import com.example.chemm.jimdemo.fragment.LoginFragment;
import com.example.chemm.jimdemo.util.UtilLog;

import java.util.ArrayList;

/**
 * Created by chemm on 2/14/2017.
 */

public class ViewPagerActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private TextView text;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        String message = intent.getStringExtra("key");

//        int number = bundle.getInt("Integer",2);
//        int fakeNumber = bundle.getInt("fake",0);
//        Book book = (Book)bundle.getSerializable("book");

//        UtilLog.logD("ViewPagerActivity, value is: ",message);
//        UtilLog.logD("ViewPagerActivity, number is: ",""+number);
//        UtilLog.logD("ViewPagerActivity, fake number is: ",String.valueOf(fakeNumber));
//        UtilLog.logD("ViewPagerActivity, book name is: ", book.getName());
        initialize();
    }

    private void initialize(){
        text = (TextView) findViewById(R.id.text_view);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        fragmentArrayList.add(new HistoryFragment());
        fragmentArrayList.add(new LoginFragment());
        fragmentArrayList.add(new ContentFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setFragments(fragmentArrayList);
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("message", "ViewPager");
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }
}
