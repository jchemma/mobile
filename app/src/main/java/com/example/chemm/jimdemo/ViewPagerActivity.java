package com.example.chemm.jimdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.chemm.jimdemo.adapter.ViewPagerAdapter;
import com.example.chemm.jimdemo.bean.Book;
import com.example.chemm.jimdemo.fragment.ContentFragment;
import com.example.chemm.jimdemo.fragment.HistoryFragment;
import com.example.chemm.jimdemo.fragment.LoginFragment;
import com.example.chemm.jimdemo.util.UtilLog;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by chemm on 2/14/2017.
 */

public class ViewPagerActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        String message = intent.getStringExtra("key");
        int number = bundle.getInt("Integer",0);
        int fakeNumber = bundle.getInt("fake",0);
        Book book = (Book)bundle.getSerializable("book");

        UtilLog.logD("ViewPagerActivity, value is: ",message);
        UtilLog.logD("ViewPagerActivity, number is: ",""+number);
        UtilLog.logD("ViewPagerActivity, fake number is: ",String.valueOf(fakeNumber));
        UtilLog.logD("ViewPagerActivity, book author is: ", book.getAuthor());
        initial();
    }

    private void initial(){
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        fragmentArrayList.add(new HistoryFragment());
        fragmentArrayList.add(new LoginFragment());
        fragmentArrayList.add(new ContentFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentArrayList);
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
