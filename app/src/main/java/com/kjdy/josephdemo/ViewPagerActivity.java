package com.kjdy.josephdemo;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.kjdy.josephdemo.adapter.ViewPagerAdapter;
import com.kjdy.josephdemo.bean.Book;
import com.kjdy.josephdemo.fragment.ContentFragment;
import com.kjdy.josephdemo.fragment.HistoryFragment;
import com.kjdy.josephdemo.fragment.LoginFragment;
import com.kjdy.josephdemo.util.UtilLog;

import java.util.ArrayList;

public class ViewPagerActivity extends BaseActivity {

    private  ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
//    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        showToastLong("ViewPagerActivity.java was executed.");

        Intent intent = getIntent(); // pass on object from one to another activities
        Bundle bundle = intent.getExtras();// pass on object from one to another activities

        Book book = (Book) bundle.getSerializable("book");


        String message = intent.getStringExtra("key");

        int number = bundle.getInt("Integer", 0);
        int fakeNumber = bundle.getInt("fake",0);

        UtilLog.logD("ViewPagerActivity, value is ", message);
        UtilLog.logD("ViewPagerActivity, number is ", ""+number);
        UtilLog.logD("ViewPagerActivity, number is ", String.valueOf(fakeNumber));
        UtilLog.logD("ViewPagerActivity, book author is ", book.getAuthor());

        initialView();

    }

    private void initialView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        fragmentList.add(new LoginFragment());

        //control initial & destroy
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        
//        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setupWithViewPager(viewPager);

    }

    // create when clicked from the running process
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("message","ViewPager");
        setResult(RESULT_OK, intent); // before onBackPressed();
//        setResult();
        super.onBackPressed();

    }
}
