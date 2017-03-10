package com.example.chemm.jimdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.GestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.chemm.jimdemo.bean.Book;
import com.example.chemm.jimdemo.dialog.CustomDialog;
import com.example.chemm.jimdemo.dialog.QuizDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity{

    private ImageButton button1;
    private ImageButton button3;
    private ImageButton topLeftButton;
    private ImageButton topRightButton;
    private GestureDetector gestureDetector;

    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;

    @OnClick(R.id.timer_button)
    public void onClickTimer(){
        toActivity(TimerActivity.class);
    }

    @OnClick(R.id.animation_button)
    public void onClickAnimation(){
        toActivity(AnimationActivity.class);
    }

    @OnClick(R.id.animator_button)
    public void onClickAnimator(){
        toActivity(AnimatorActivity.class);
    }

    @OnClick(R.id.quiz_button)
    public void clickQuizButton(){
        final QuizDialog dialog = new QuizDialog(this, new QuizDialog.ICustomDialogEventListener() {
            @Override
            public void onButton1ClickListener() {
                toActivity(ViewPagerActivity.class);
            }

            @Override
            public void onButton2ClickListener() {
                toActivity(DialogActivity.class);
            }


            @Override
            public void onButton3ClickListener() {
                toActivity(ListViewActivity.class);
            }
        });
        dialog.show();
    }

    @OnClick(R.id.button2)
    public void button2click(){
        Intent intent = new Intent(this,DialogActivity.class);
        startActivityForResult(intent,2);

//        what to do when you dont have butterknife
//        button2.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                Toast.makeText(view.getContext(), "Button 2", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
        //gestureDetector = new GestureDetector(this, new SimpleGestureListener());
        //frameLayout.setOnTouchListener(this);
    }

    private void initialView(){
        button1 = (ImageButton) findViewById(R.id.button1);
        button3 = (ImageButton) findViewById(R.id.button3);
        topLeftButton = (ImageButton) findViewById(R.id.topLeftButton);
        topRightButton = (ImageButton) findViewById(R.id.topRightButton);
    }

    private void initialListener(){
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(),"Button 1 was clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);

                Book book = new Book();
                book.setName("Book's Name");
                book.setAuthor("Book's Author");
                bundle.putSerializable("book",book);

                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                toastShort("Button 3 was clicked");
                Intent intent = new Intent(view.getContext(),ListViewActivity.class);
                startActivityForResult(intent, 3);
            }
        });

        topLeftButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(), "View Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), ViewPagerActivity.class);
                startActivity(intent);
            }
        });

        topRightButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(), "Letter Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), LetterActivityA.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("ListView");
                break;
            default:
        }
    }



//    public void onClick(View view){
//        toastLong("Button 2 was clicked");
//        UtilLog.logD("TestD","Toast");
//    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        return gestureDetector.onTouchEvent(event);
//    }

//    private class SimpleGestureListener extends GestureDetector.SimpleOnGestureListener {
//        public boolean onDown(MotionEvent e){
//            UtilLog.logD("MyGesture", "onDown");
//            toastShort("onDown");
//            return true;
//        }
//
//        public void onShowPress(MotionEvent e){
//            UtilLog.logD("MyGesture", "onShowPress");
//            toastShort("onShowPress");
//        }
//
//        public void onLongPress(MotionEvent e){
//            UtilLog.logD("MyGesture", "onLongPress");
//            toastShort("onLongPress");
//        }
//
//        public boolean onSingleTapConfirmed(MotionEvent even){
//            toastShort("onSingleTapConfirmed");
//            return true;
//        }
//
//        public boolean onScroll(MotionEvent even1, MotionEvent event2, float distanceX, float distanceY){
//            UtilLog.logD("MyGesture", "onScroll: " + (event2.getX()-event2.getX())+ "  "+distanceX);
//            toastShort("Scrolling...");
//            return true;
//        }
//
//        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
//            toastShort("onFling");
//            return true;
//        }
//
//        public boolean onDoubleTap(MotionEvent event){
//            toastShort("onDoubleTap");
//            return true;
//        }
//
//        public boolean onDoubleTapEvent(MotionEvent event){
//            toastShort("onDoubleTapEvent");
//            return true;
//        }
//    }
}
