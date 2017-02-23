package com.kjdy.josephdemo.launchMode;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.kjdy.josephdemo.BaseActivity;
import com.kjdy.josephdemo.DialogActivity;
import com.kjdy.josephdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yunjo on 2/22/2017.
 */

public class standardActivity extends BaseActivity {
    private Button bt1,bt2,bt3,bt4;


    @OnClick(R.id.standardBt1)
    public void button1Click(){
        Intent intent = new Intent(this, standardActivity.class); //initializing intent
        startActivity(intent);

    }

    @OnClick(R.id.standardBt2)
    public void button2Click(){
        Intent intent = new Intent(this, singleTopActivity.class); //initializing intent
        startActivity(intent);

    }
    @OnClick(R.id.standardBt3)
    public void button3Click(){
        Intent intent = new Intent(this, singleTaskActivity.class); //initializing intent
        startActivity(intent);

    }
    @OnClick(R.id.standardBt4)
    public void button4Click(){
        Intent intent = new Intent(this, singleInstanceActivity.class); //initializing intent
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        ButterKnife.bind(this);
        initialView();
    }
    private void initialView(){
        bt1 = (Button) findViewById(R.id.standardBt1);
        bt2 = (Button) findViewById(R.id.standardBt2);
        bt3 = (Button) findViewById(R.id.standardBt3);
        bt4 = (Button) findViewById(R.id.standardBt4);

    }


}
