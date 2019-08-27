package com.example.student.module21_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityBT2 extends AppCompatActivity {

    private Button btntoC,btntoF,btnClear;
    private EditText txtC,txtF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt2);

        btntoC = findViewById(R.id.btnToC);
        btntoF = findViewById(R.id.btnToF);
        btnClear = findViewById(R.id.btnClear);

        txtC = findViewById(R.id.edtC);
        txtF = findViewById(R.id.edtF);

        //Set Event Listener

        btntoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtF.getText().toString().trim().isEmpty()) return;;

                float result = (Float.parseFloat(txtF.getText().toString()) - 32) * 5/9;
                txtC.setText(Float.toString(result));
            }
        });

        btntoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtC.getText().toString().trim().isEmpty()) return;;

                float result = (Float.parseFloat(txtC.getText().toString()) * 9/5) + 32;
                txtF.setText(Float.toString(result));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtC.setText("");
                txtF.setText("");
            }
        });

    }
}
