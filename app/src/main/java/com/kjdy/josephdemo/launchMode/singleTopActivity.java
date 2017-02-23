package com.kjdy.josephdemo.launchMode;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.kjdy.josephdemo.BaseActivity;
import com.kjdy.josephdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yunjo on 2/22/2017.
 */

public class singleTopActivity extends BaseActivity {
    //private Button bt1,bt2,bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletop);
        ButterKnife.bind(this);
        initialView();
    }

    @OnClick(R.id.singletopBT1)
    public void button1Click(){
        Intent intent = new Intent(this, standardActivity.class); //initializing intent
        startActivity(intent);

    }

    @OnClick(R.id.singletopBt2)
    public void button2Click(){
        Intent intent = new Intent(this, singleTopActivity.class); //initializing intent
        startActivity(intent);

    }
    @OnClick(R.id.singletopBt3)
    public void button3Click(){
        Intent intent = new Intent(this, singleTaskActivity.class); //initializing intent
        startActivity(intent);

    }
    @OnClick(R.id.singletopBt4)
    public void button4Click(){
        Intent intent = new Intent(this, singleInstanceActivity.class); //initializing intent
        startActivity(intent);

    }

    private void initialView(){

//        bt1 = (Button) findViewById(R.id.singletopBT1);
//        bt2 = (Button) findViewById(R.id.standardBt2);
//        bt3 = (Button) findViewById(R.id.standardBt3);
//        bt4 = (Button) findViewById(R.id.standardBt4);
    }
}
