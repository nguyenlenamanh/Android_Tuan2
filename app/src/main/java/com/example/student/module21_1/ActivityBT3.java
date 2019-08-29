package com.example.student.module21_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ActivityBT3 extends AppCompatActivity {

    private Button btnConvert;
    private EditText edt2,edt3;
    String result = new String();
    private List<String> Can = new ArrayList<String>() {
        {
            add("Canh");
            add("Tân");
            add("Nhâm");
            add("Quý");
            add("Giáp");
            add("Ất");
            add("Bính");
            add("Đinh");
            add("Mậu");
            add("Kỷ");
        }
    };

    private List<String> Chi = new ArrayList<String>() {
        {
            add("Thân");
            add("Dậu");
            add("Tuất");
            add("Hợi");
            add("Tý");
            add("Sửu");
            add("Dần");
            add("Mẹo");
            add("Thìn");
            add("Tỵ");
            add("Ngọ");
            add("Mùi");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt3);

        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);

        btnConvert = findViewById(R.id.btnConvert);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = Integer.parseInt(edt2.getText().toString());
                result += Can.get(year % 10) + " " + Chi.get(year % 12);
                edt3.setText(result.toString());
            }
        });
    }
}
