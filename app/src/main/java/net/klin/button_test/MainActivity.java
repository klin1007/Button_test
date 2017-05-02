package net.klin.button_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView pv1;
    private TextView pv2;
    private TextView pv3;
    private Button bt1;
    private Button bt2;
    private Spinner sp1;
    private ListView lv1;

    private String func[] = {"餘額查詢","交易明細","最新消息","投資理財","離開"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews_Main();

        //設定按下Button(bt1)後TextView會顯示:按下Button
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pv1.setText("按下Button");
            }
        });

        //設定按下Button2(bt2)後;跳至計算BMI頁面
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNextPage();
            }
        });

        //設定按下Spinner
        final ArrayAdapter <CharSequence> nAdapter = ArrayAdapter.createFromResource(
                this,R.array.notify_array,android.R.layout.simple_spinner_item);
        nAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(nAdapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,nAdapter.getItem(i),Toast.LENGTH_LONG).show();
//                pv3.setText(nAdapter.getItem(i).toString());
                pv3.setText(sp1.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                pv3.setText("還沒選擇");
            }
        });

        //設定按下ListView
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,func);
        lv1.setAdapter(adapter);


     }

    private void findViews_Main() {
        pv1 = (TextView) findViewById(R.id.textView);
        pv2 = (TextView) findViewById(R.id.textView2);
        bt1 = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        sp1 = (Spinner) findViewById(R.id.notify_spinner);
        pv3 = (TextView) findViewById(R.id.textView3);
        lv1 = (ListView) findViewById(R.id.list);
    }

    private void startNextPage() {
//        //初始化Intent物件
//        Intent intent = new Intent();
//        //傳送資料至第二頁
///*        intent.putExtra("Name","Tom");
//        intent.putExtra("Year",12);*/
//        Bundle bundle = new Bundle();
//        bundle.putString("Name", "Tom");
//        bundle.putInt("Year", 12);
//        intent.putExtra("Bundle", bundle);
//        //從MainActivity 到Main2Activity
//        intent.setClass(this, Main2Activity.class);
//        //開啟Activity
//        startActivity(intent);

        //初始化Intent物件
        Intent intent = new Intent();
        //從MainActivity 到 BMI
        intent.setClass(this, BMI.class);
        //開啟Activity
        startActivity(intent);
    }
}
