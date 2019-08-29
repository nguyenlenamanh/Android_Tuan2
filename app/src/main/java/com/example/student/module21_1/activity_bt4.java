package com.example.student.module21_1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.regex.Pattern;

public class activity_bt4 extends AppCompatActivity {

    EditText tbName, tbCMND;
    CheckBox cb1,cb2,cb3;
    Button btnCheck;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt4);

        tbName = findViewById(R.id.tb1);
        tbCMND = findViewById(R.id.tb2);
        radioGroup = findViewById(R.id.radioGroup);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);

        btnCheck = findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alertDialog = new AlertDialog.Builder(activity_bt4.this).create();
                alertDialog.setTitle("Hiển thị");
                alertDialog.setMessage(Check(tbName.getText().toString(),tbCMND.getText().toString()));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
    }

    protected String Check(String name,String cmnd) {

        boolean checkName = Pattern.matches(".{3,}",name);

        if(!checkName) return "Tên không hợp lệ. Không được bỏ trống và ít nhất là 3 ký tự.";

        boolean checkCMND = Pattern.matches("[0-9]{9}",cmnd);

        if(!checkCMND) return "CMND không hợp lệ. Gồm 9 số.";

        if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked()) return "Chọn ít nhất 1 sở thích";

        if(radioGroup.getCheckedRadioButtonId() == -1) {
            radioGroup.check(R.id.rdDefault);
        }

        return "Thành công";
    }
}
