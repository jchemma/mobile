package com.example.chemm.jimdemo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jchemma on 3/1/17.
 */

public class AnimationActivity extends BaseActivity {

    private Animation alphaAnimation;
    private Animation setAnimation;
    private Animation transposeAnimation;
    private Animation scaleAnimation;
    private Animation rotateAnimation;

    @BindView(R.id.animation_text)
    TextView tv;

    @OnClick(R.id.animation_alpha)
    public void alpha(){
        tv.startAnimation(alphaAnimation);
    }

    @OnClick(R.id.animation_rotate)
    public void rotate(){
        tv.startAnimation(rotateAnimation);
    }

    @OnClick(R.id.animation_scale)
    public void scale(){
        tv.startAnimation(scaleAnimation);
    }

    @OnClick(R.id.animation_set)
    public void set(){
        tv.startAnimation(setAnimation);
    }

    @OnClick(R.id.animation_transpose)
    public void transpose(){
        tv.startAnimation(transposeAnimation);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        initialAnimation();
        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                toastShort("Click");
            }
        });
    }

    private void initialAnimation(){
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.set);
        transposeAnimation = AnimationUtils.loadAnimation(this, R.anim.transpose);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
    }
}
