package com.example.student.module21_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;
    private EditText numa;
    private EditText numb;
    private Button btn1,btn2,btn3,btn4,btn5,btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tvResult);
        numa = findViewById(R.id.edtnuma);
        numb = findViewById(R.id.edtnumb);

        btn1 = findViewById(R.id.btnSum);
        btn2 = findViewById(R.id.btnMinus);
        btn3 = findViewById(R.id.btnMulti);
        btn4 = findViewById(R.id.btnDevide);
        btn5 = findViewById(R.id.btnUoc);
        btn6 = findViewById(R.id.btnExit);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        float so1 = Float.parseFloat(numa.getText().toString());
        float so2 = Float.parseFloat(numb.getText().toString());

        switch (view.getId()){
            case R.id.btnSum:
                tv.setText(Float.toString(so1+so2));
                break;
            case R.id.btnMinus:
                tv.setText(Float.toString(so1-so2));
                break;
            case R.id.btnMulti:
                tv.setText(Float.toString(so1*so2));
                break;
            case R.id.btnDevide:
                tv.setText(Float.toString(so1/so2));
                break;
            case R.id.btnUoc:
                while (so1 != so2) {
                    if (so1 > so2) {
                        so1 -= so2;
                    } else {
                        so2 -= so1;
                    }
                }
                tv.setText(Float.toString(so1));
                break;
            case R.id.btnExit:
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                break;
                default:
                    tv.setText("Error");

        }
    }
}
