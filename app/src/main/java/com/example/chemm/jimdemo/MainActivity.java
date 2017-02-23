package com.example.chemm.jimdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.chemm.jimdemo.bean.Book;
import com.example.chemm.jimdemo.util.UtilLog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private ImageButton button1;
    private ImageButton button3;
    private ImageButton topLeftButton;
    private ImageButton topRightButton;

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

    public void onClick(View view){
        toastLong("Button 2 was clicked");
        UtilLog.logD("TestD","Toast");
    }
}
