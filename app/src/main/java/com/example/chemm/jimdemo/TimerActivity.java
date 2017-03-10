package com.example.chemm.jimdemo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jchemma on 2/27/17.
 */

public class TimerActivity extends BaseActivity {

    private int time;

    @BindView(R.id.edit_timer_field)
    EditText editText;

    @BindView(R.id.timer_button)
    Button timerButton;

    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if(time > 0){
                editText.setText(String.valueOf(time));
                handler.postDelayed(this,1000);
            }
        }
    };


    final View.OnClickListener start = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            time = Integer.valueOf(editText.getText().toString());
            timerButton.setText("Stop");
            timerButton.setOnClickListener(stop);
            handler.postDelayed(runnable,1000);
            editText.setEnabled(false);
        }
    };

    final View.OnClickListener stop = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            timerButton.setText("Reset");
            timerButton.setOnClickListener(reset);
            handler.removeCallbacks(runnable);

        }
    };

    final View.OnClickListener reset = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            timerButton.setText("Start");
            timerButton.setOnClickListener(start);
            handler.removeCallbacks(runnable);
            editText.setEnabled(true);
            editText.setText("20");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        ButterKnife.bind(this);
        timerButton.setOnClickListener(start);
    }
}
