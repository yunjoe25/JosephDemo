package com.kjdy.josephdemo.launchMode;

import android.content.Intent;
import android.os.Bundle;

import com.kjdy.josephdemo.BaseActivity;
import com.kjdy.josephdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yunjo on 2/22/2017.
 */

public class singleTaskActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletask);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.singletaskBt1)
    public void button1Click(){
        Intent intent = new Intent(this, standardActivity.class); //initializing intent
        startActivity(intent);

    }
    @OnClick(R.id.singletaskBt2)
    public void button2Click(){
        Intent intent = new Intent(this, singleTopActivity.class); //initializing intent
        startActivity(intent);

    }
    @OnClick(R.id.singletaskBt3)
    public void button3Click(){
        Intent intent = new Intent(this, singleTaskActivity.class); //initializing intent
        startActivity(intent);

    }
    @OnClick(R.id.singletaskBt4)
    public void button4Click(){
        Intent intent = new Intent(this, singleInstanceActivity.class); //initializing intent
        startActivity(intent);

    }
}
