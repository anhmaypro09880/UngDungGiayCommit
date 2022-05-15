package com.example.ungdunggiay;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class ActivityDonHang extends AppCompatActivity {
    public com.example.ungdunggiay.Adapterdonhang adapterdonhang;
    ListView listView;
    public  ArrayList<ChiTietHoaDon> dsCTHD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_donhang);
        DatabaseHoaDon db = Room.databaseBuilder(getApplicationContext(),
                DatabaseHoaDon.class,"HoadonBH1.db").allowMainThreadQueries().build();
        HoaDonDao hoaDonDao = db.HoaDonDao();
        GioHangDao gioHangDao = db.GioHangDao();
        KhachHangDao khachHangDao = db.KhachHangDao();
        Intent intent = this.getIntent();
        String email = intent.getStringExtra("email");
        KhachHang khachHang = khachHangDao.getkhEmail(email);
        List<HoaDon> dsHoaDon = hoaDonDao.getHoaDonByKH(khachHang.getId());


//        List<com.example.ungdunggiay.GioHang> dsGioHang = gioHangDao.getGioHang(1);
        dsCTHD = new ArrayList<>();
        for(int i = 0 ; i < dsHoaDon.size();i++){
            List<ChiTietHoaDon> ds1 = hoaDonDao.getCTHD(dsHoaDon.get(i).getId());
            for(int j = 0;j<ds1.size();j++)
            {
                dsCTHD.add(ds1.get(j));
            }
        }

//        test.setText("a:"+dsGioHang.size());
        listView =findViewById(R.id.listViewDonHang);
        adapterdonhang = new com.example.ungdunggiay.Adapterdonhang(ActivityDonHang.this,dsCTHD,R.layout.itemdonhang);
        listView.setAdapter(adapterdonhang);
    }
}