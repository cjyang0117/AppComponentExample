package com.example.suyue.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener{
    private String stk[], course[]={"美式漢堡","特選牛排","義大利麵","牛肉麵"};;
    private Spinner sp;
    private ListView lv;
    private TextView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //建立清單項目有兩種方式
        //1. 在字串資源string.xml建立 > 使用元件之entries屬性連接 > getResource使用
        stk=getResources().getStringArray(R.array.steaks);
        //2. 若想要程式執行才出現項目，可以使用Adapter接合器連接來取代entries，此時項目可以在字串資源string.xml建立，也可以使用字串陣列建立
        sp=(Spinner)findViewById(R.id.sp2);
        ArrayAdapter<String>a1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, course);
        //ArrayAdapter<String>a1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, stk);
        sp.setAdapter(a1);

        //Spinner的選取項目事件，需implement
        sp=(Spinner)findViewById(R.id.sp2);
        sp.setOnItemSelectedListener(this);

        //ListView的按一下事件，需要implements
        lv=(ListView)findViewById(R.id.lv);
        lv.setOnItemClickListener(this);
    }

    public void btnClick(View v){
        sp=(Spinner)findViewById(R.id.sp1);
        int index=sp.getSelectedItemPosition();  //String s=sp.getSelectedItem().toString(); 也可直接取得項目
        out=(TextView)findViewById(R.id.out1);
        out.setText("牛排要: "+stk[index]);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        sp=(Spinner)findViewById(R.id.sp2);
        out=(TextView)findViewById(R.id.out2);
        switch(i){
            case 0:
                out.setText("我想要吃"+course[0]);
                break;
            case 1:
                out.setText("我想要吃"+course[1]);
                break;
            case 2:
                out.setText("我想要吃"+course[2]);
                break;
            case 3:
                out.setText("我想要吃"+course[3]);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    //ListView的按一下事件，需要implements
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        out=(TextView)findViewById(R.id.out3);
        out.setText("我想要吃"+stk[i]);
    }
}
