package com.example.chemm.jimdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by jchemma on 2/22/17.
 */

public class LetterActivityB extends BaseActivity {

    private Button toA;
    private Button toB;
    private Button toC;
    private Button toD;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_b);
        initialView();
        initialListener();
        ButterKnife.bind(this);
    }

    private void initialView(){
        toA = (Button)findViewById(R.id.a_button);
        toB = (Button)findViewById(R.id.b_button);
        toC = (Button)findViewById(R.id.c_button);
        toD = (Button)findViewById(R.id.d_button);
    }

    private void initialListener(){
        toA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(), "Opening A", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),LetterActivityA.class);
                startActivity(intent);
            }
        });

        toB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(), "Opening B", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),LetterActivityB.class);
                startActivity(intent);
            }
        });

        toC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(), "Opening C", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),LetterActivityC.class);
                startActivity(intent);
            }
        });

        toD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(), "Opening D", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),LetterActivityD.class);
                startActivity(intent);
            }
        });
    }

}
