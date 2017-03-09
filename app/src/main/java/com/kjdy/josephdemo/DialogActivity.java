package com.kjdy.josephdemo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.kjdy.josephdemo.CustomDialog.CustomDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yunjo on 2/13/2017.
 */


//Quiz = android manifest =/ application crash
public class DialogActivity extends BaseActivity {

    private int checkedID;
    private final int DIALOG = 12345;


    //progress bar
    Handler mHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case DIALOG :
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    showToastShort("Dialog Message: "+s);
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }

    };
    //Butterknife implementation
    @BindView(R.id.rdg) RadioGroup radioGroup;
    @OnClick(R.id.dialog_ok)
    public void okClick(){
        switch (checkedID){
            case R.id.rb1:
                normalDialog();
                break;
            case R.id.rb2:
                listDialog();
                break;
            case R.id.rb3:
                singleChoiceDialog();
                break;
            case R.id.rb4:
                multiChoiceDialog();
                break;
            case R.id.rb5:
                waitingDialog();
                break;
            case R.id.rb6:
                progressDialog();
                break;
            case R.id.rb7:
                inputDialog();
                break;
            case R.id.rb8:
                customDialog();
                break;
            default:
                break;
        }
    }

    private void customDialog() {
        final CustomDialog dialog = new CustomDialog(this, new CustomDialog.ICustomDialogEventListener() {
            @Override
            public void onClickListener() {
//                showToastShort("OK Button was clicked");
                Intent intent = new Intent();
                intent.putExtra("message","DialogActivity");
                setResult(RESULT_OK, intent); // before onBackPressed();
//        setResult();

                finish();
            }
        });
        dialog.setTitle("HELLO");
        dialog.show();

    }

    //input dialog
    private void inputDialog() {
        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(this);
        inputDialog.setTitle("I am an input Dialog").setView(editText);
        inputDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort(editText.getText().toString());
            }
        });
        inputDialog.setNegativeButton("Cancel",null).show();

    }

    // progress bar dialog
    private void progressDialog() {
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Downloading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while(progress < MAX_PROGRESS){
                    try{
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
//                showToastShort("Download Success");

                Bundle bundle = new Bundle();
                bundle.putString("msg", "Download success");

                Message msg = new Message();
//                Message msg =  mHandler.obtainMessage();
                msg.what =  DIALOG;
                msg.setData(bundle);
                mHandler.sendMessage(msg);
                progressDialog.cancel();
//                showToastShort("Download success");
            }
        }).start();

    }

    //waiting dialog
    ProgressDialog waitingDialog;
    private void waitingDialog() {
        waitingDialog = new ProgressDialog(this);
        waitingDialog.setTitle("I am a waiting Dialog");
        waitingDialog.setMessage("Waiting...");
        waitingDialog.setCancelable(true);
        waitingDialog.show();
        waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                showToastShort("Dialog was cancelled.");
                //stop download thread if user click outside
            }
        });
     // this allows different activity to recognize waitingDialog termination
//        waitingDialog.dismiss();
    }

    // multiple choice dialog
    ArrayList<Integer> choices = new ArrayList<>();
    private void multiChoiceDialog() {
        final String[] items = {"item1","item2","item3","item4"};
        final boolean initChoiceSets[] = {false,false,false,false};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("multipleChoiceDialog");
        builder.setMultiChoiceItems(items,initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    choices.add(which);
                } else {
                    choices.remove(which);
                }
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = choices.size();
                String str ="";
                for(int i =0; i<size;i++){
                    str +=items[choices.get(i)] + " ";
                }
                showToastShort("You chose: " + str);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                showToastShort("Cancel was clicked");
            }
        });
        builder.show();
    }

    //single choice dialog
    int choice=0;
    private void singleChoiceDialog() {
        final String[] items = {"item1","item2","item3","item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("singleChoiceDialog");
        builder.setSingleChoiceItems(items,choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;

            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("You clicked"+ choice);
            }
        });
        builder.show();
    }

    // list dialog
    private void listDialog() {
        final String[] items = {"item1","item2","item3","item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("ListDialog");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("You clicked : "+items[which]);
            }
        });

        builder.show();
    }

    //normal dialog
    private void normalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("AlertTitle");
        builder.setMessage("This is a normal Dialog");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("You clicked Yes");
            }
        });

        builder.setNeutralButton("Maybe", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("You clicked Maybe");
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("You clicked No");
            }
        });

        builder.show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;
                showToastShort("You checked the RadioButton"+ checkedId);
            }


        });

    }



}
