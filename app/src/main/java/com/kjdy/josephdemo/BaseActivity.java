package com.kjdy.josephdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void toActivity(Class name){
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    public void showToastLong(String content){
        Toast.makeText(this,content,Toast.LENGTH_LONG).show();
    }

    public void showToastShort(String content){
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }
}


