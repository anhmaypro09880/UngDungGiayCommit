package com.example.ungdunggiay;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class ActivityGioHang extends AppCompatActivity {
    public static com.example.ungdunggiay.Adaptergiohang adapter;
    public static com.example.ungdunggiay.DatabaseHoaDon db;
    public static HoaDonDao hoaDonDao;
    public static GioHangDao gioHangDao;
    public static KhachHangDao khachHangDao;

    ListView listView;
    public static  ArrayList<com.example.ungdunggiay.GioHang> arrayListchinh;

    public static TextView tong;
    public static List<com.example.ungdunggiay.GioHang> dsGioHang;
//    TextView tong = findViewById(R.id.idtongtien);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);

        arrayListchinh = new ArrayList<>();
         db= Room.databaseBuilder(getApplicationContext(),
                 com.example.ungdunggiay.DatabaseHoaDon.class,"HoadonBH1.db").allowMainThreadQueries().build();


//        HoaDon hoaDon= new HoaDon(2);
//        hoaDonDao.themHoaDon(hoaDon);
//        List<HoaDon> hoaDon1 = hoaDonDao.getAll();
//        hoaDonDao.themCTHD(new ChiTietHoaDon(1,1,"CTHD1",1,100,2));
//        List<ChiTietHoaDon> chiTietHoaDons = hoaDonDao.getCTHD(2);

//        Toast.makeText(MainActivity.this,"so hoa don: ",Toast.LENGTH_LONG);
        hoaDonDao= db.HoaDonDao();
        gioHangDao=db.GioHangDao();
        KhachHangDao khachHangDao = db.KhachHangDao();
        com.example.ungdunggiay.GioHangDao gioHangDao = db.GioHangDao();

        khachHangDao.ThemKH(new KhachHang("Dao Cao Thang","0385553842","Go Vap"));
//        hoaDonDao.themHoaDon(new HoaDon(1));
//        hoaDonDao.themHoaDon(new HoaDon(1));

//        hoaDonDao.themCTHD(new ChiTietHoaDon(1,"CTHD1",1,100,1));
//        hoaDonDao.themCTHD(new ChiTietHoaDon(1,"CTHD2",1,100,1));
        List<com.example.ungdunggiay.KhachHang> dskh = khachHangDao.getKHAll();

        List<com.example.ungdunggiay.ChiTietHoaDon> ds = hoaDonDao.getCTHD(2);
//        gioHangDao.ThemGioHang(new GioHang("https://firebasestorage.googleapis.com/v0/b/ungdunggiay.appspot.com/o/giay-removebg-preview.png?alt=media&token=ff0aa5d3-911c-4c7f-b100-42ab7edf230d","Giay 2",200000,2,39,1));
       Intent intent = this.getIntent();
       String email;
       email = intent.getStringExtra("email");
       KhachHang khachHang = khachHangDao.getkhEmail(email);
//       dsGioHang.removeAll(dsGioHang);
       dsGioHang = gioHangDao.getGioHang(khachHang.getId());
//       arrayListchinh.removeAll(arrayListchinh);
//        for(int j = 0;j<dsGioHang.size();j++)
//        {
//            arrayListchinh.add(dsGioHang.get(0));
//        }


        listView = findViewById(R.id.listspGioHang);
//        int size = arrayListchinh.size();
//        for(int i=0;i<size;i++)
//        {
//            arrayListchinh.remove(i);
//        }


        for(int i =0;i<dsGioHang.size();i++)
        {
            arrayListchinh.add(dsGioHang.get(i));
        }

//        arrayListchinh.add(new GioHang(R.drawable.giay,"Giay 4",400000,4));
        tong = findViewById(R.id.idtongtien);
        int tongtien = 0;
        for (int i = 0 ; i < arrayListchinh.size();i++)
        {
            tongtien+=arrayListchinh.get(i).getGiatien()*arrayListchinh.get(i).getSoluong();
        }




        tong.setText(""+tach(tongtien)+"VND");
        SanPhamAdapter adapter1;
        ArrayList<SanPham> test = new ArrayList<>();
//        test.add(new SanPham("1","2","3","4","5",null,null,null,null));
        adapter1 = new SanPhamAdapter(this,R.layout.list_viewsanpham,test);
        adapter = new Adaptergiohang(this,arrayListchinh,R.layout.item_giohang);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityGioHang.this,"ban da chon",Toast.LENGTH_LONG).show();
            }
        });

        ImageView btnDatHang = findViewById(R.id.btndathang);
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ma = hoaDonDao.getAll().size()+1;

                if(arrayListchinh.size()==0)
                {
                    Toast.makeText(ActivityGioHang.this,"Không có sản phẩm",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    hoaDonDao.themHoaDon(new HoaDon(khachHang.getId()));
                    for(int i = 0 ; i <arrayListchinh.size();i++)
                    {
                        hoaDonDao.themCTHD(new ChiTietHoaDon(arrayListchinh.get(i).getHinh(),arrayListchinh.get(i).getTen(),arrayListchinh.get(i).getGiatien(),arrayListchinh.get(i).getSoluong(),arrayListchinh.get(i).getSize(),ma));
                        gioHangDao.deleteGioHang(dsGioHang.get(i));
                        tong.setText("0VND");

                        Toast.makeText(ActivityGioHang.this,"Đặt hàng thành công",Toast.LENGTH_SHORT).show();

                        Intent intent1 = new Intent(ActivityGioHang.this,MainMenu.class);
                        intent1.putExtra("email",email);
                        startActivity(intent1);
                    }


                }

            }
        });
//        ImageView back = findViewById(R.id.idimgBack);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ActivityGioHang.this,MainMenu.class);
//                startActivity(intent);
//            }
//        });


    }
    public String XoaKhoangTrang(String text)
    {
        String chuoi = "";

        for (int i = 0; i< text.length();i++)
        {	char ca = text.charAt(i);
            if(ca != '.' )
            {
                chuoi+=String.valueOf(text.charAt(i));
            }
        }
        return chuoi;
    }
    public String tach(int luong)
    {
        int chucnghin,tramnghin,trieu,nghin,tram,chuc,dvi;
        trieu=(int)  (luong/1000000);
        tramnghin =  (int)((luong-(trieu*1000000))/100000);
        chucnghin= (int) ((luong-(trieu*1000000)-(tramnghin*100000))/10000);
        nghin = (int)((luong - (trieu*1000000)-(tramnghin*100000) - (chucnghin*10000))/1000);
        tram =(int) ((luong - (trieu*1000000)-(tramnghin*100000) - (chucnghin*10000) - (nghin*1000))/100);
        chuc = (int)((luong - (trieu*1000000)-(tramnghin*100000) - (chucnghin*10000) - (nghin*1000) - (tram*100))/10);
        dvi = (int)((luong - (trieu*1000000)-(tramnghin*100000) - (chucnghin*10000) - (nghin*1000) - (tram*100)-(chuc *10)));

        if(trieu>0)
        {
            return (""+trieu+"."+tramnghin+""+chucnghin+""+nghin+"."+tram+""+chuc+""+dvi);
        }
        else if(trieu==0 && tramnghin>0)
        {
            return(""+tramnghin+chucnghin+nghin+"."+tram+chuc+dvi);
        }
        else if(trieu==0 && tramnghin == 0 && chucnghin >0)
        {
            return (""+chucnghin+nghin+"."+tram+chuc+dvi);
        }
        else if(trieu==0 && tramnghin == 0 && chucnghin == 0 && nghin >0)
        {
            return(""+nghin+"."+tram+chuc+dvi);
        }
        else if(trieu==0 && tramnghin == 0 && chucnghin == 0 && nghin == 0 &&  tram>0)
        {
            return(""+tram+chuc+dvi);
        }
        else if(trieu==0 && tramnghin == 0 && chucnghin == 0 && nghin == 0 && tram == 0 &&  chuc > 0)
        {
            return(""+chuc+dvi);
        }
        else
        {
            return(""+dvi);
        }
    }
}