package com.kjdy.josephdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
                Toast.makeText(v.getContext(),"Button1 was clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // more practical when user clicks the button frequently
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListViewActivity.class); //initializing intent
                startActivity(intent); // go to other activity
            }
        });

    }

    // called in ImageButton: onclick function (activity_main.xml)
    // everytime function is called, program searches for id making process long
    public void onClick(View v){
        Toast.makeText(this,"Button2 was clicked", Toast.LENGTH_SHORT).show();
    }
}
