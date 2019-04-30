package com.example.suyue.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TouchActivity extends AppCompatActivity
    implements View.OnTouchListener{    //紅色燈泡>implements method
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        //加入返回鍵 > AndroidManifest.xml 在所屬Activity加上parent
        //此行程式只需在第2個活動打一次，便可以套用全部子活動
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        output=(TextView)findViewById(R.id.output);
        output.setTextSize(30);

        RelativeLayout layout=(RelativeLayout)findViewById(R.id.rlayout); //需設定觸控之介面與ID
        layout.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //手機震動 > AndroidManifest.xml加上使用權限 (可用Alt+Enter，在以下使用函式時)
        Vibrator vb=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        int act=motionEvent.getAction();
        switch (act){
            case MotionEvent.ACTION_DOWN:
                output.setText("ACTION_DOWN");
                output.setTextColor(Color.RED);
                vb.vibrate(2000);
                break;
            case MotionEvent.ACTION_UP:
                output.setText("ACTION_UP");
                output.setTextColor(Color.GREEN);
                vb.cancel();
                break;
            case MotionEvent.ACTION_MOVE:
                float x=motionEvent.getX();
                float y=motionEvent.getY();
                output.setText("X= "+x+"\nY= "+y);
                output.setTextColor(Color.BLUE);
                break;
        }
        return true; //true表示事件全權由我處理 false表示會傳遞下一個事件
    }
}
