package com.kjdy.josephdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.kjdy.josephdemo.adapter.ListViewAdapter;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

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
        listView.setOnItemClickListener(this);
    }

    //making a toast when item is clicked
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"listView was clicked at position: "+position, Toast.LENGTH_LONG).show();


    }
}
