package com.example.ungdunggiay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityThongTinCaNhan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        Intent intent = this.getIntent();
        String email = intent.getStringExtra("email");
        DatabaseHoaDon db = Room.databaseBuilder(getApplicationContext(),
                DatabaseHoaDon.class,"HoadonBH1.db").allowMainThreadQueries().build();
        KhachHangDao khachHangDao = db.KhachHangDao();
        KhachHang khachHang = khachHangDao.getkhEmail(email);
        EditText edtTen = findViewById(R.id.edtTen);
        EditText edtDC = findViewById(R.id.edtDiaChi);
        EditText edtSdt = findViewById(R.id.edtSdt);

        edtTen.setText(khachHang.getTenKH());
        edtDC.setText(khachHang.getDiaChi());
        edtSdt.setText(khachHang.getSoDienThoai());

        Button btnXn = findViewById(R.id.btnXn);
        btnXn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtTen.getText().toString();
                String diaChi = edtDC.getText().toString();
                String Sdt = edtSdt.getText().toString();
                khachHang.setDiaChi(diaChi);
                khachHang.setTenKH(name);
                khachHang.setSoDienThoai(Sdt);
                khachHangDao.Update(khachHang);
                Toast.makeText(ActivityThongTinCaNhan.this,"Cập nhật thông tin thành công",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ActivityThongTinCaNhan.this,MainMenu.class);
                i.putExtra("email",MainMenu.email);
                startActivity(i);
            }
        });

    }
}