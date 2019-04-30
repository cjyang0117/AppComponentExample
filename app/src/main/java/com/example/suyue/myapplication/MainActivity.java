package com.example.suyue.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//Android 系統架構
//Linux Kernel Layer(Linux核心層)
    //包含硬體驅動、電源管理、記憶體管理等
//Native Layer(原生函式庫層)
    //C、C++所寫支援生函式庫，必須透過架構層來應用
//Application Framework Layer(應用程式架構層)
    //提供JAVA撰寫之API類別給應用層使用
//Applications Layer(應用層式層)
    //APP

//Android APP的組成元素
//Activity
    //應用程式由單至多個活動所組成
//Broadcast Receiver
    //系統會送出廣播給廣播接受者以接受動作，常見的應用為鬧鐘，響鈴前不會占用CPU與記憶體資源
//Service
    //常見的應用為音樂播放器，可讓音樂於背景中播放，允許背景執行程式
//Content Provider
    //使某應用程式可以分享資料給其他應用程式，常見的應用為通訊錄，其他程式可以讀取通訊錄內容


//Option menu建置
//res右鍵>New>Android resource file
//File name=menu_main > Resource type=Menu
//始可拉元件Menu Item  PS:showAsAction=never
//插入函式 Code>Override Methods>選擇onCreateOptionsMenu && onOptionsItemSelected

//新增Activity
//java>New>Activity>EmptyActivity
public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, View.OnLongClickListener {   //紅色燈泡>implements method
    private Intent intent;
    private TextView output;
    private float s=30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.b1);
        btn.setOnClickListener(this);
        btn.setOnLongClickListener(this);
        output=(TextView)findViewById(R.id.lab);
        output.setTextSize(30);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.i1:
                intent=new Intent(this, KeyActivity.class);
                startActivity(intent);
                break;
            case R.id.i2:
                intent=new Intent(this, TouchActivity.class);
                startActivity(intent);
                break;
            case R.id.i3:
                intent=new Intent(this, BoxActivity.class);
                startActivity(intent);
                break;
            case R.id.i4:
                intent=new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
            case R.id.i5:
                intent=new Intent(this, DialogActivity.class);
                startActivity(intent);
                break;
            case R.id.i6:
                intent=new Intent(this, IntentActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        s++;
        //output.setText(String.valueOf(s));
        output.setTextSize(s);
    }

    @Override
    public boolean onLongClick(View view) {
        s=30;
        output.setTextSize(30);
        return true; //true表示事件全權由我處理 false表示會傳遞下一個事件(onClick)
    }
}
