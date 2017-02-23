package com.kjdy.josephdemo;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.kjdy.josephdemo.bean.Book;
import com.kjdy.josephdemo.launchMode.standardActivity;
import com.kjdy.josephdemo.util.UtilLog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private ImageButton bt1,bt3;

    // Butterknife implementation of button
    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent intent = new Intent(this, DialogActivity.class); //initializing intent
        startActivityForResult(intent,2);
//        toActivity(DialogActivity.class);
    }

    @OnClick(R.id.topBt1)
    public void button1Click(){
        Intent intent = new Intent(this,  standardActivity.class); //initializing intent
        startActivityForResult(intent,2);
//        toActivity(DialogActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
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
                intent.putExtra("key","value");//putting string
                Bundle bundle = new Bundle();// bundle
                bundle.putInt("Integer", 12345); // int bundle


                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Joseph");
                bundle.putSerializable("book", book); // can only store object in bundle ***************
                intent.putExtras(bundle);

                startActivityForResult(intent,1); // go to other activity
            }
        });

        // more practical when user clicks the button frequently
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListViewActivity.class); //initializing intent
                startActivityForResult(intent,3);
//                toActivity(ListViewActivity.class);
//
//                Intent intent = new Intent(v.getContext(), ListViewActivity.class); //initializing intent
//                startActivity(intent); // go to other activity
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1: // 1 = ViewPagerActivity
                String message = data.getStringExtra("message");
                showToastShort(message);
                break;
            case 2:
                showToastShort("Dialog");
                break;
            case 3:
                showToastShort("ListViewActivity");
                break;
            default:

        }
    }

    // called in ImageButton: onclick function (activity_main.xml)
    // everytime function is called, program searches for id making process long
    public void onClick(View v){
//        Toast.makeText(this,"Button2 was clicked", Toast.LENGTH_SHORT).show();

        //Base Activity
        showToastLong("Button 2 was clicked");
        //setting up to turn on log report for application
        // d = debug, v = verbose, i = info, e = error
        UtilLog.logD("testD", "Toast");



    }
}
