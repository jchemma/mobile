package com.example.chemm.jimdemo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.chemm.jimdemo.dialog.CustomDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.id.message;

/**
 * Created by chemm on 2/15/2017.
 */

public class DialogActivity extends BaseActivity{

    private int checkedID;
    public final int DIALOG = 12345;

    Handler handler = new  Handler() {
        @Override
        public void handleMessage(Message message) {
            switch(message.what) {
                case DIALOG:
                    Bundle bundle = message.getData();
                    String s = bundle.getString("msg");
                    toastShort("Dialog Message: " +s);
                    String content = message.getData().getString("msg");
                    break;
                default:
            }
            super.handleMessage(message);
        }
    };

    @BindView(R.id.rdg) RadioGroup radioGroup;

    @OnClick(R.id.dialog_ok)
    public void onClick(){
        switch(checkedID){
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
        }
    }

    private void customDialog(){
        final CustomDialog dialog = new CustomDialog(this,new CustomDialog.ICustomDialogEventListener(){
            @Override
            public void onClickListener(){
                toastShort("Ok Button was clicked");
                Intent intent = new Intent();
                intent.putExtra("message", "ViewPager");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        dialog.show();

    }

    private void inputDialog(){
        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(this);
        inputDialog.setTitle("I'm an Input Dialog").setView(editText);
        inputDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                toastShort(editText.getText().toString());
            }
        });
        inputDialog.setNegativeButton("Cancel",null).show();
    }

    private void progressDialog(){
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Downloading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();

        new Thread(new Runnable(){

            @Override
            public void run() {
                int progress = 0;
                while(progress < MAX_PROGRESS){
                    try{
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    }catch(InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                progressDialog.cancel();
                Bundle bundle = new Bundle();
                bundle.putString("message", "Download Success");
                Message message = new Message().obtain();
                message.what = DIALOG;
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }).start();
    }

    ProgressDialog waitingDialog;

    private void waitingDialog(){
        waitingDialog = new ProgressDialog(this);
        waitingDialog.setTitle("I'm a Waiting Dialog");
        waitingDialog.setMessage("Waiting...");
        waitingDialog.setCancelable(true);
        waitingDialog.show();
        waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener(){
            @Override
            public void onDismiss(DialogInterface dialog){
                toastShort("Dialog was cancelled");
            }
        });
    }

    ArrayList<Integer> choices = new ArrayList<>();

    private void normalDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Alert Title");
        builder.setMessage("This is a normal dialogue.");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                toastShort("You clicked Yes");
            }
        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                toastShort("You clicked Neutral");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                toastShort("You clicked Cancel");
            }
        });

        builder.show();
    }

    public void listDialog(){
        final String[] items = {"item1","item2","item3","item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a List Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toastShort("You clicked: "+items[which]);
            }
        });
        builder.show();
    }

    int choice = 0;

    public void singleChoiceDialog() {
        final String[] items = {"item1", "item2", "item3", "item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a Single Choice Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toastShort("You clicked: " + choice);
            }
        });
        builder.show();
    }

    public void multiChoiceDialog() {
        final String[] items = { "item1", "item2", "item3", "item4" };
        final boolean initChoiceSets[]={false, false, false, false};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a multi-choice Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMultiChoiceItems(items, initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
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
                String str = "";
                for (int i = 0; i < size; i++) {
                    str += items[choices.get(i)] + " ";
                }
                toastShort("You chose: "+str);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                toastShort("You clicked Cancel");
            }
        });
        builder.show();
    }

    public void showDialog() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                toastShort("You checked the radio button"+checkedId);
                checkedID = checkedId;
            }
        });
    }
}
