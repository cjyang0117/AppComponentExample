package com.example.suyue.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DialogActivity extends AppCompatActivity
    implements DialogInterface.OnClickListener, DialogInterface.OnMultiChoiceClickListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener{

    String[] item={"Samsung", "HTC", "ASUS", "Apple"};
    boolean[] chked=new boolean[4];

    private Calendar dt=Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void btnClick(View v){
        Toast.makeText(this, "Hey! How are you?", Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "Hey! How are you?", Toast.LENGTH_LONG).show();
    }
    public void btn1Click(View v){
        AlertDialog.Builder b=new AlertDialog.Builder(this);

        //串聯呼叫法
        b.setTitle("標題視窗")
         .setMessage("你確定要結束本活動嗎?")
         .setPositiveButton("GO", this)       //若只是要顯示文字窗，沒有處理事件，第二個參數為null
         .setNegativeButton("Cancel", this)
         .show();
    }
    public  void btn2Click(View v){
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setTitle("Choose a color");
        String[] ops={"紅色", "綠色", "藍色"};
        b.setItems(ops, this);   ////選擇後觸發Dialog點擊事件
        //b.
        b.setNegativeButton("取消", null);
        b.show();
    }
    public void btn3Click(View v){
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setTitle("請勾選選項")
         .setPositiveButton("確定", this)  //觸發Dialog點擊事件
         .setNegativeButton("取消", null)
         .setMultiChoiceItems(item, chked, this) //設定複選選項、是否勾選布林值
         .show();
    }
    public void btn4Click(View v){
        DatePickerDialog dlg=new DatePickerDialog(this, this,
                dt.get(Calendar.YEAR),
                dt.get(Calendar.MONTH),                   //設定初始時間
                dt.get(Calendar.DAY_OF_MONTH));
        dlg.show(); //顯示日期方塊
    }
    public void btn5Click(View v){
        TimePickerDialog dlg=new TimePickerDialog(this, this,
                dt.get(Calendar.HOUR),
                dt.get(Calendar.MINUTE),true);  //設定初始時間 true為24小時制
        dlg.show();
    }
    //在此為筆記方便，沒有另外宣告傾聽者物件
    //對話方塊的確認、放棄、取消事件，需implements
    //單選事件，需implements，與對話方塊事件相同!!
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        /*switch (i){
            case DialogInterface.BUTTON_POSITIVE:
                finish();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(this, "按下取消", Toast.LENGTH_SHORT);
                break;
        }*/

        Button btn=(Button)findViewById(R.id.b3);
        switch (i){
            case 0:
                btn.setBackgroundColor(Color.RED);
                break;
            case 1:
                btn.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                btn.setBackgroundColor(Color.BLUE);
                break;
        }

        String s="";
        for(int in=0;in<item.length;in++){
            if(chked[in]){
                s+=item[in]+" ";
            }
        }
        TextView out=(TextView)findViewById(R.id.out1);
        out.setText(s);
    }

    //複選方塊的點選事件，需implements
    @Override
    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
        Toast.makeText(this, item[i]+(b ? "勾選":"沒有勾選"), Toast.LENGTH_SHORT).show();
    }
    //日期傾聽者，需implements
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        TextView out=(TextView)findViewById(R.id.out2);
        out.setText("日期: "+i+"/"+(i1+1)+"/"+i2);
    }
    //時間傾聽者，需implements
    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        TextView out=(TextView)findViewById(R.id.out2);
        out.setText("時間: "+i+":"+i1);
    }
}
