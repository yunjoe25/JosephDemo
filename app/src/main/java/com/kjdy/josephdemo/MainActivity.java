package com.kjdy.josephdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.kjdy.josephdemo.util.UtilLog;

public class MainActivity extends BaseActivity {

    private ImageButton bt1,bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
    }

    private void initialView(){
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
    }



    private void initialListener(){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"bt1 clicked", Toast.LENGTH_LONG).show();
                showToastLong("button 1 was clicked");
                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class); //initializing intent
                startActivity(intent); // go to other activity
            }
        });

        // more practical when user clicks the button frequently
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(ListViewActivity.class);
//
//                Intent intent = new Intent(v.getContext(), ListViewActivity.class); //initializing intent
//                startActivity(intent); // go to other activity
            }
        });

    }

    // called in ImageButton: onclick function (activity_main.xml)
    // everytime function is called, program searches for id making process long
    public void onClick(View v){
//        Toast.makeText(this,"Button2 was clicked", Toast.LENGTH_SHORT).show();

        //Base Activity
        showToastLong("Button 2 was clicked");
        //setting up to turn on log report for application
        UtilLog.logD("testD", "Toast");

//        Log.d("testD","Toast");
        // d = debug, v = verbose, i = info, e = error
//        Log.e("testD","Toast");
//        Log.i("testD","Toast");
//        Log.v("testD","Toast");
//        Log.w("testD","Toast");


    }
}
