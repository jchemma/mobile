package com.example.chemm.jimdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.chemm.jimdemo.bean.Book;
import com.example.chemm.jimdemo.util.UtilLog;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private ImageButton button1;
    private ImageButton button3;

    @OnClick(R.id.button2)
    public void button2click(){
        Intent intent = new Intent(this,DialogActivity.class);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();

        //TODO: Butterknife
    }

    private void initialView(){
        button1 = (ImageButton) findViewById(R.id.button1);
        button3 = (ImageButton) findViewById(R.id.button3);
    }

    private void initialListener(){
        button1.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               Toast.makeText(view.getContext(),"Button 1 was clicked.",Toast.LENGTH_LONG).show();
               Intent intent = new Intent(view.getContext(), ViewPagerActivity.class);
               intent.putExtra("key","value");
               Bundle bundle = new Bundle();
               bundle.putInt("Integer", 12345);
               Book book = new Book();
               book.setName("Android");
               book.setAuthor("Jim Chemmalakuzhy");
               bundle.putSerializable("book",book);
               intent.putExtras(bundle);
               startActivity(intent);
           }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                toActivity(ListViewActivity.class);
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
                break;
            case 3:
                break;
            default:
        }
    }

    public void onClick(View view){
        toastLong("Button 2 was clicked");
        UtilLog.logD("TestD","Toast");
    }
}
