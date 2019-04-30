package com.example.suyue.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

//Class改名方式 > 直接在下方改名 > 紅燈泡rename file > AndroidManifest.xml改名
public class BoxActivity extends AppCompatActivity
    implements RadioGroup.OnCheckedChangeListener, TextWatcher, CompoundButton.OnCheckedChangeListener{
    private RadioGroup r;
    private TextView out;
    private EditText txt;
    private int[] chkbox={R.id.box3, R.id.box4};
    private String str="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        RadioGroup rg=(RadioGroup)findViewById(R.id.g2);
        rg.setOnCheckedChangeListener(this);

        txt=(EditText)findViewById(R.id.ed);
        txt.addTextChangedListener(this);

        //以迴圈連續註冊事件
        for(int i:chkbox){
            CheckBox chk=(CheckBox)findViewById(i);
            chk.setOnCheckedChangeListener(this);
        }
    }
    //RadioGroup不用實作介面
    public void btnClick(View v){
        r=(RadioGroup)findViewById(R.id.g1);
        out=(TextView) findViewById(R.id.out1);
        switch (r.getCheckedRadioButtonId()){
            case R.id.rboy:
                out.setText("你是男生");
                break;
            case R.id.rgirl:
                out.setText("妳是女生");
                break;
        }
    }
    //RadioGroup的選項改變事件
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        out=(TextView)findViewById(R.id.out2);
        switch (i){
            case R.id.rgboy:
                out.setText("你是帥哥");
                break;
            case R.id.rggirl:
                out.setText("妳是美女");
                break;
        }
    }
    //EditText的文字改變事件
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        out=(TextView)findViewById(R.id.out3);
        out.setText(txt.getText().toString());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    public void btn2Click(View v){
        str="";
        CheckBox chk=(CheckBox)findViewById(R.id.box1);
        if(chk.isChecked()){
            str+=chk.getText()+" ";
        }
        chk=(CheckBox)findViewById(R.id.box2);
        if(chk.isChecked()){
            str+=chk.getText()+" ";
        }
        out=(TextView)findViewById(R.id.out4);
        out.setText(str);
    }
    //CheckBox的選項改變事件
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        str="";
        switch (compoundButton.getId()){
            case R.id.box3:
                str+="你點選了羊肉\n";
                break;
            case R.id.box4:
                str+="你點選了牛肉\n";
                break;
        }
        show();
    }
    public void show(){
        out=(TextView)findViewById(R.id.out5);
        for(int i:chkbox){
            CheckBox chk=(CheckBox)findViewById(i);
            if(chk.isChecked()){
                str+=chk.getText()+"\n";
            }
        }
        out.setText(str);
    }
}
