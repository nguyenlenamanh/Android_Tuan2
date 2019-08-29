package com.example.student.module21_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityBT5 extends AppCompatActivity implements View.OnClickListener {

    EditText tenkh, soluong, tongkh, tongkhV, tongThu;
    TextView tongTien;
    CheckBox chkVIP;
    Button tinhTT, tiep, thongke,close;

    int tongKH = 0, tongKHVIP = 0;
    double tongDoanhThu = 0;

    final double priceSingle = 20000;
    final double percentDiscount = 0.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt5);

        // TextBox
        tenkh = findViewById(R.id.txtTenKH);
        soluong = findViewById(R.id.txtSL);
        tongkh = findViewById(R.id.txtTongKH);
        tongkhV = findViewById(R.id.txtTongVIP);
        tongThu = findViewById(R.id.txtTongThu);

        // Label
        tongTien = findViewById(R.id.lbTongTien);

        // Button
        tinhTT = findViewById(R.id.btnTinhTT);
        tiep = findViewById(R.id.btnTiep);
        thongke = findViewById(R.id.btnThongKe);
        close = findViewById(R.id.btnClose);

        // Checkbox
        chkVIP = findViewById(R.id.ckbVIP);

        // Set Event Click
        tinhTT.setOnClickListener(this);
        tiep.setOnClickListener(this);
        thongke.setOnClickListener(this);
        close.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnTinhTT:
                int sl = Integer.parseInt(soluong.getText().toString());
                double tongtien = (chkVIP.isChecked()) ? sl * priceSingle * (1-percentDiscount) : sl * priceSingle;
                tongTien.setText(Double.toString(tongtien));

                tongKH++;
                if(chkVIP.isChecked()) tongKHVIP++;

                tongDoanhThu += tongtien;
                break;
            case R.id.btnTiep:
                tenkh.setText("");
                soluong.setText("");
                chkVIP.setChecked(false);
                tongTien.setText("");
                tenkh.requestFocus();
                break;
            case R.id.btnThongKe:
                tongkh.setText(Integer.toString(tongKH));
                tongkhV.setText(Integer.toString(tongKHVIP));
                tongThu.setText(Double.toString(tongDoanhThu));
                break;
            case R.id.btnClose:
                Toast.makeText(this, "Test",
                        Toast.LENGTH_LONG).show();
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                break;
                default:
                    break;
        }
    }
}

