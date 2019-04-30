package com.example.suyue.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fintent);

        //compute();
    }

    private void compute(){
        int c;
        double f;
        Bundle b=this.getIntent().getExtras();
        if(b!=null){
            c=Integer.parseInt(b.getString("tempc"));
            f=(9.0*c)/5.0+32.0;  //浮點數運算
            TextView out=(TextView)findViewById(R.id.out1);
            out.setText("攝氏轉華式溫度: "+ f);
        }
    }

    public void btn1Click(View v){
        int c;
        double f;
        Bundle b=this.getIntent().getExtras();
        if(b!=null){
            c=Integer.parseInt(b.getString("tempc2"));
            f=(9.0*c)/5.0+32.0;  //浮點數運算

            Intent ri=new Intent();
            Bundle rb=new Bundle();
            rb.putDouble("result", f); //第一個參數為key
            ri.putExtras(rb);
            setResult(RESULT_OK, ri); //第一個參數為計算成功或失敗
            finish();
        }
    }
}
