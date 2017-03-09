package com.kjdy.josephdemo;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yunjo on 3/1/2017.
 */

public class AnimationActivity extends BaseActivity {

    private Animation alphaAnimation;
    private Animation scaleAnimation;
    private Animation rotateAnimation;
    private Animation transAnimation;
    private Animation setAnimation;

    @BindView(R.id.anim_tv)
    TextView tv;

    @OnClick(R.id.animation_1)
    public void onAnimation1Click(){
        tv.startAnimation(alphaAnimation);
    }

    @OnClick(R.id.animation_2)
    public void onAnimation2Click(){
        tv.startAnimation(scaleAnimation);
    }

    @OnClick(R.id.animation_3)
    public void onAnimation3Click(){
        tv.startAnimation(rotateAnimation);
    }

    @OnClick(R.id.animation_4)
    public void onAnimation4Click(){
        tv.startAnimation(transAnimation);
    }

    @OnClick(R.id.animation_5)
    public void onAnimation5Click(){
        tv.startAnimation(setAnimation);
    }


    private void initialAnimation() {
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        transAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity);
        ButterKnife.bind(this);
        initialAnimation();
    }



}
