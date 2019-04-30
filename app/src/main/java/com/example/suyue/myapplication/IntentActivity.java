package com.example.suyue.myapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity {
    EditText e;
    Intent i;
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }
    //利用bundle在Activity中傳遞資料
    public void btn1Click(View v){
        e=(EditText)findViewById(R.id.e1);
        i=new Intent(this, FIntentActivity.class);
        b=new Bundle();
        b.putString("tempc", e.getText().toString());
        i.putExtras(b);
        startActivity(i);
    }

    //利用bundle回傳資料
    public void btn2Click(View v){
        e=(EditText)findViewById(R.id.e2);
        i=new Intent(this, FIntentActivity.class);
        b=new Bundle();
        b.putString("tempc2", e.getText().toString());
        i.putExtras(b);
        startActivityForResult(i, 1);  //第二參數為回傳之活動編碼，可能有多個活動傳回資料
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    b=data.getExtras();
                    TextView out=(TextView)findViewById(R.id.out1);
                    out.setText("攝氏轉華式溫度: "+ b.getDouble("result"));
                }
                break;
            case 2:
                if(resultCode==RESULT_OK){
                    String s=data.getData().toString();
                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                    i=new Intent(Intent.ACTION_VIEW, Uri.parse(s));
                    startActivity(i);
                }
        }
    }

    public void btn3Click(View v){
        Button btn=(Button)v;
        switch(btn.getId()){
            case R.id.b3:
                i=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:24.1371137,120.6866493,17"));
                startActivity(i);
                break;
            case R.id.b4:
                i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+0930954299"));
                startActivity(i);
                break;
            case R.id.b5:
                i=new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:harmonics41@gmail.com"));
                startActivity(i);
                break;
            case R.id.b6:
                e=(EditText)findViewById(R.id.e3);
                i=new Intent(Intent.ACTION_WEB_SEARCH);
                i.putExtra(SearchManager.QUERY, e.getText().toString());
                startActivity(i);
                break;
            case R.id.b7:
                e=(EditText)findViewById(R.id.e4);
                i=new Intent(Intent.ACTION_VIEW, Uri.parse(e.getText().toString()));
                startActivity(i);
                break;
        }
    }
    public void btn4Click(View v){
        i=new Intent(Intent.ACTION_PICK);
        i.setType(ContactsContract.Contacts.CONTENT_TYPE);      //提供聯絡人清單來進行選取
        startActivityForResult(i, 2);
    }

    //ACTION_VIEW 顯示資料給使用者檢視
    //ACTION_EDIT 顯示資料給使用者編輯
    //ACTION_DIAL 顯示撥號
    //ACTION_CALL 打電話
    //ACTION_PICK 選取URI目錄下的資料
    //ACTION_SENDTO 寄送電子郵件
    //ACTION_WEB_SEARCH Web搜尋
    //ACTION_MAIN 啟動如同是程式進入點的主程式
}
