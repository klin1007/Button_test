package net.klin.button_test;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMI extends AppCompatActivity {
    private TextView tvWeight;
    private TextView tvHeight;
    private TextView tvResult;
    private EditText etWeight;
    private EditText etHeight;
    private Button   btBMI;
    private Button   btHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        findViews();  //取得畫面上各控件TextView、EditText、Button

        //按下BMI按鈕
        btBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bmi();
            }
        });

        //按下HELP按鈕
        btHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                help();
            }

            private void help() {
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("BMI計算方式");
//                builder.setMessage("體重(kg)/身高的平方(m)");
//                builder.setPositiveButton("OK",null);
//                builder.show();
              new AlertDialog.Builder(BMI.this)
                             .setTitle("BMI計算方式")
                             .setMessage("體重(kg)/身高的平方(m)")
                             .setPositiveButton("OK",null)
                             .show();
            }
        });

    }

    private void bmi() {
        String strWeight = etWeight.getText().toString();
        String strHeight = etHeight.getText().toString();
        Float fltWeight = Float.parseFloat(strWeight);
        Float fltHeight = Float.parseFloat(strHeight);
        Float fltBMI = fltWeight/(fltHeight*fltHeight);
        tvResult.setText(String.valueOf(fltBMI));
        Log.d("BMI", String.valueOf(fltBMI));
//        Toast(this,String.valueOf(fltBMI),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,String.valueOf(fltBMI),Toast.LENGTH_SHORT).show();
//        new AlertDialog.Builder(this).setMessage(fltBMI + "").setTitle("BMI計算").show();
        //產生Builder物件
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //呼叫setMessage方法設定顯示文字
        builder.setMessage(fltBMI + "");
        //呼叫setTitle方法設定抬頭
        builder.setTitle("BMI計算");
        //設定OK按鈕
        builder.setPositiveButton("OK",null);
        //設定Cancel按鈕
        builder.setNeutralButton("Cancel",null);
        //顯示對話框
        builder.show();
//        Log.d("BMI", String.valueOf(bmi));
    }

    private void findViews() {
        tvWeight = (TextView) findViewById(R.id.ed_weight);
        tvHeight = (TextView) findViewById(R.id.ed_height);
        tvResult = (TextView) findViewById(R.id.textView6);
        etWeight = (EditText) findViewById(R.id.ed_weight);
        etHeight = (EditText) findViewById(R.id.ed_height);
        btBMI = (Button) findViewById(R.id.bt_BMI);
        btHelp = (Button) findViewById(R.id.bt_help);
    }
}
