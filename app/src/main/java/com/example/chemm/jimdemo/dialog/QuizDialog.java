package com.example.chemm.jimdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.RadioGroup;

import com.example.chemm.jimdemo.DialogActivity;
import com.example.chemm.jimdemo.ListViewActivity;
import com.example.chemm.jimdemo.ViewPagerActivity;
import com.example.chemm.jimdemo.dialog.CustomDialog.ICustomDialogEventListener;

import com.example.chemm.jimdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chemm on 3/8/2017.
 */

public class QuizDialog extends Dialog{

    private int id;


    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onButton1ClickListener();
        public void onButton2ClickListener();
        public void onButton3ClickListener();
    }

    @BindView(R.id.quiz_radio_group) RadioGroup radioGroup;

    @OnClick(R.id.quiz_dialog_ok)
    public void clickOk(){
        switch(id){
            case R.id.qrb1:
                listener.onButton1ClickListener();
                break;
            case R.id.qrb2:
                listener.onButton2ClickListener();
                break;
            default:
        }
        dismiss();
    }

    public QuizDialog(@NonNull Context context, ICustomDialogEventListener listener){
        super(context, R.style.dialog);
        this.listener = listener;
    }

    @OnClick(R.id.quiz_dialog_cancel)
    public void clickCancel(){
        listener.onButton3ClickListener();
        dismiss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int iD) {
                id = iD;
            }
        });
    }
}
