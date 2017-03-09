package com.kjdy.josephdemo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kjdy.josephdemo.adapter.ListViewAdapter;
import com.kjdy.josephdemo.adapter.ViewPagerAdapter;
import com.kjdy.josephdemo.headerFragment.FirstHeaderFragment;
import com.kjdy.josephdemo.headerFragment.SecondHeaderFragment;
import com.kjdy.josephdemo.headerFragment.ThirdHeaderFragment;



import java.util.ArrayList;

public class ListViewActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ViewPager viewPager;
    private ArrayList<String> ListResult;
    private ArrayList<Fragment> headFragmentList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListResult = new ArrayList<String>();
//        viewPager = (ViewPager) findViewById(R.id.list_view_pager);
        createFakeResult();
        initialView();
    }

    private void createFakeResult(){
        ListResult.add("AZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
        ListResult.add("B");
        ListResult.add("CGGGGGGGGGGGGGGGGGGG");
        ListResult.add("D");
        ListResult.add("E");
        ListResult.add("F");
        ListResult.add("G");
        ListResult.add("H");
        ListResult.add("I");
        ListResult.add("J");
        ListResult.add("KHHHHH");
        ListResult.add("L");
        ListResult.add("M");
        ListResult.add("N");
        ListResult.add("O");
        ListResult.add("P");
        ListResult.add("Q");

    }

    private void initialView() {

        listView = (ListView) findViewById(R.id.list_view);

        //null = group
        View view = getLayoutInflater().inflate(R.layout.list_view_header, null);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, ListResult);


        //QUIZ = why this
        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);
//        viewPager = (ViewPager) findViewById(R.id.list_view_pager);
        viewPager = (ViewPager) view.findViewById(R.id.list_view_pager);

        headFragmentList.add(new FirstHeaderFragment());
        headFragmentList.add(new SecondHeaderFragment());
        headFragmentList.add(new ThirdHeaderFragment());

        ViewPagerAdapter viewPageAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());

        viewPageAdapter.setContent(headFragmentList);
        viewPager.setAdapter(viewPageAdapter);

        listView.addHeaderView(listViewHeader);

        // footer
        // Textview added manually
        TextView tv = new TextView(this);
        tv.setText("We have no more content.");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);

        listView.addFooterView(tv);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);

        showToastShort("ListViewActivity.java was executed");
    }



    //making a toast when item is clicked
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"listView was clicked at position: "+ position, Toast.LENGTH_SHORT).show();
        //key = your class name
        Log.d("testListViewActivity",String.valueOf(position));

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("message","ListViewActivity");
        setResult(RESULT_OK, intent); // before onBackPressed();
//        setResult();
        super.onBackPressed();
    }
}
