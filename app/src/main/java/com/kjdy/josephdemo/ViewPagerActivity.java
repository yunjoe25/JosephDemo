package com.kjdy.josephdemo;

//import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kjdy.josephdemo.adapter.ViewPagerAdapter;
import com.kjdy.josephdemo.fragment.ContentFragment;
import com.kjdy.josephdemo.fragment.HistoryFragment;
import com.kjdy.josephdemo.fragment.LoginFragment;

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
        initialView();

    }
//    @Override
//    public CharSequenceget PagerTitle(int position){
//        return fragmentList.get(position).;
//    }

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
}
