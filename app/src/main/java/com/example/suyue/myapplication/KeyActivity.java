package com.example.suyue.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class KeyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);
    }

    //key事件已經實作，覆寫即可
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){       //判斷按下的是哪一鍵，取名方式為KeyEvent.KEYCODE_(數字)
            EditText e=(EditText)findViewById(R.id.edit);
            e.setText("按下BACK鍵...");
            return true;  //true表示事件全權由我處理 false表示會傳遞下一個事件，需自己建立
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        TextView t=(TextView)findViewById(R.id.output);
        t.setText("按下的KeyCode按鍵碼: "+ keyCode);
        return super.onKeyUp(keyCode, event);
    }
}
