package com.kjdy.josephdemo;

import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.kjdy.josephdemo.CustomDialog.MainCustomDialog;
import com.kjdy.josephdemo.bean.Book;
import com.kjdy.josephdemo.launchMode.standardActivity;
import com.kjdy.josephdemo.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnTouchListener, NavigationView.OnNavigationItemSelectedListener{

    private ImageButton bt1,bt3;
    private GestureDetector mGestureDetector;
    OnSwipeListener onSwipeTouchListener;
    @BindView(R.id.main_fl) FrameLayout fl;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
//    final DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);

    // Butterknife implementation of button
    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent intent = new Intent(this, DialogActivity.class); //initializing intent
        startActivityForResult(intent,2);
    }

    @OnClick(R.id.topBt1)
    public void button1Click(){
        Intent intent = new Intent(this,  standardActivity.class); //initializing intent
        startActivityForResult(intent,2);
    }
    @OnClick(R.id.topBt2)
    public void buttonTop2Click(){
        drawer.openDrawer(Gravity.LEFT);
    }

    @OnClick(R.id.bt_main_timer)
    public void buttonTimerClick(){
        toActivity(TimerActivity.class);
    }
    @OnClick(R.id.bt_animation)
    public void buttonAnimationClick(){
        toActivity(AnimationActivity.class);
    }
    @OnClick(R.id.bt_animator)
    public void buttonAnimatorClick(){
        toActivity(AnimatorActivity.class);
    }
    @OnClick(R.id.bt_main_custom_diag)
    public void buttonMainCustomClick(){
        final MainCustomDialog dialog = new MainCustomDialog(this, new MainCustomDialog.ICustomDialogEventListener() {
            public void onClickListener() {
                Intent intent = new Intent();
                intent.putExtra("message","MainCustomDialog");
                setResult(RESULT_OK, intent); // before onBackPressed();
            }
            public void noClickListener() {
                Intent intent = new Intent();
                intent.putExtra("message","MainCustomDialog");
                setResult(RESULT_CANCELED, intent); // before onBackPressed();
                toActivity(ViewPagerActivity.class);
            }
            public void firstOptionListener(){
                Intent intent = new Intent();
                intent.putExtra("message","MainCustomDialog");
                setResult(RESULT_OK, intent); // before onBackPressed();
                toActivity(DialogActivity.class);
            }
            public void secondOptionListener(){
                Intent intent = new Intent();
                intent.putExtra("message","MainCustomDialog");
                setResult(RESULT_OK, intent); // before onBackPressed();
                toActivity(ListViewActivity.class);
            }
        });
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);
        initialView();
        initialListener();
        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);
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
    @Override
    public boolean onTouch(View v, MotionEvent event){
        return mGestureDetector.onTouchEvent(event);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
//            UtilLog.logD("MyGesture", "OnDown");
//            showToastShort("onDown");
            return true;
            //bonus = why true in main
        }

        @Override
        public void onShowPress(MotionEvent e) {
//            UtilLog.logD("MyGesture", "OnShowPress");
//            showToastShort("onShowPress");
        }

        @Override
        public void onLongPress(MotionEvent e) {
//            UtilLog.logD("MyGesture", "onLongPress");
//            showToastShort("onLongPress");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
//            UtilLog.logD("MyGesture", "onSingleTapUp");
//            showToastShort("onSingleTapUp");
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
//            UtilLog.logD("MyGesture", "onSingleTapConfirmed");
//            showToastShort("onSingleTapConfirmed");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            //check if e2.getX - e1.getX (positive: negative)
            //determine whether if user is scrolling left to right || or right to left
            //animator trans() => (100 , -200) [sliding left]
            //animator trans() => (-200, 100) [sliding right]
//            UtilLog.logD("MyGesture","onScroll "+ (e2.getX() - e1.getX()) + "   "+ distanceX   );
//            if(e2.getX() - e1.getX() < 0){
//                showToastShort(""+distanceX);
//            }
////            showToastShort("onScroll");
////            showToastShort("onScroll"+ (e2.getX() - e1.getX()) + "   "+ distanceX   );

            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//            showToastShort("onFling");
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
//            showToastShort("onDoubleTap");
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
//            showToastShort("onDoubleTapEvent");
            return true;
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
