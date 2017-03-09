package com.kjdy.josephdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.RadioGroup;

import com.kjdy.josephdemo.CustomDialog.CustomDialog;
import com.kjdy.josephdemo.CustomDialog.MainCustomDialog;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

/**
 * Created by yunjo on 3/8/2017.
 */

public class DialogMainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//        customDialog();
    }
//    private void customDialog() {
//        final MainCustomDialog dialog = new MainCustomDialog(this, new DialogMainCustomDialog.ICustomDialogEventListener() {
//            @Override
//            public void onClickListener() {
////                showToastShort("OK Button was clicked");
//                Intent intent = new Intent();
//                intent.putExtra("message","DialogActivity");
//                setResult(RESULT_OK, intent); // before onBackPressed();
////        setResult();
//
//                finish();
//            }
//        });
////        dialog.setTitle("HELLO");
//        dialog.show();
//
//    }

}
