package com.kjdy.josephdemo.CustomDialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.kjdy.josephdemo.BaseActivity;
import com.kjdy.josephdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yunjo on 3/8/2017.
 */

public class MainCustomDialog extends Dialog {
    private MainCustomDialog.ICustomDialogEventListener listener;
    private int checkedID;

//    @OnClick(R.id.main_custom_dialog_ok)
//    public void onClick(){
//
//    }
    @OnClick(R.id.main_custom_dialog_cancel)
    public void cancelClick(){
        listener.noClickListener();
        dismiss();
    }
    @BindView(R.id.rdg)
    RadioGroup radioGroup;
    @OnClick(R.id.main_custom_dialog_ok)
    public void okClick(){
        switch (checkedID){
            case R.id.rb1:
                listener.firstOptionListener();
                dismiss();
                break;
            case R.id.rb2:
                listener.secondOptionListener();
                dismiss();
                break;
            default:
                listener.onClickListener();
                dismiss();
                break;
        }
    }


    public interface ICustomDialogEventListener{
        public void onClickListener();
        public void noClickListener();
        public void firstOptionListener();
        public void secondOptionListener();
    }


    public MainCustomDialog(@NonNull Context context, MainCustomDialog.ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_custom_dialog);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;
            }


        });
    }

}
