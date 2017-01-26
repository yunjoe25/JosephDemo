package com.kjdy.josephdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.kjdy.josephdemo.adapter.ListViewAdapter;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initialView();
    }

    private void initialView() {
        listView = (ListView) findViewById(R.id.list_view);
        //QUIZ = why this
        ListViewAdapter listViewAdapter = new ListViewAdapter(this);
        listView.setAdapter(listViewAdapter);

    }
}
