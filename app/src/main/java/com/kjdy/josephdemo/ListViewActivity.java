package com.kjdy.josephdemo;

import android.support.v7.app.AppCompatActivity;
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

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayList<String> ListResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListResult = new ArrayList<String>();
        createFakeResult();
        initialView();

    }

    private void createFakeResult(){
        ListResult.add("A");
        ListResult.add("B");
        ListResult.add("C");
        ListResult.add("D");
        ListResult.add("E");
        ListResult.add("F");
        ListResult.add("G");
        ListResult.add("H");
        ListResult.add("I");
        ListResult.add("J");
        ListResult.add("K");
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

        //QUIZ = why this
        LinearLayout listViewHeader = (LinearLayout)view.findViewById(R.id.list_view_header);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, ListResult);
        listView.addHeaderView(listViewHeader);



        TextView tv = new TextView(this);
        tv.setText("We have no more content.");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);

    }

    //making a toast when item is clicked
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"listView was clicked at position: "+position, Toast.LENGTH_LONG).show();
        //key = your class name
        Log.d("testListViewActivity",String.valueOf(position));

    }
}
