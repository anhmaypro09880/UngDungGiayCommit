package com.example.ungdunggiay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ActivityDetailProduct extends AppCompatActivity {
    TextView tenSanPham,giaTien,moTaa,txtSoLuong;
    ImageView img1,img2,img3,img4,imgReudece,imgIncrease;
    Context ctx;
    Button btn39,btn40,btn41,btn42,btn43,btnMuaNgay;
    public int size=39;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        DatabaseHoaDon db = Room.databaseBuilder(getApplicationContext(),
                DatabaseHoaDon.class,"HoadonBH1.db").allowMainThreadQueries().build();
        KhachHangDao khachHangDao = db.KhachHangDao();
        GioHangDao gioHangDao = db.GioHangDao();
        HoaDonDao hoaDonDao = db.HoaDonDao();
        Intent intent = this.getIntent();



        String name = intent.getStringExtra("tenSanPham");
        String giaThanh = intent.getStringExtra("giaThanh");
        String moTa = intent.getStringExtra("moTa");
        String hinh1 = intent.getStringExtra("hinh1");
        String hinh2 = intent.getStringExtra("hinh2");
        String hinh3 = intent.getStringExtra("hinh3");
        String hinh4 = intent.getStringExtra("hinh4");
        String danhGia = intent.getStringExtra("danhGia");


        khaiBao();
        tenSanPham.setText(name);

        moTaa.setText(moTa);
        giaTien.setText(tach(Integer.parseInt(giaThanh))+"VND");

        Picasso.get().load(hinh1).into(img1);
        Picasso.get().load(hinh2).into(img2);
        Picasso.get().load(hinh3).into(img3);
        Picasso.get().load(hinh4).into(img4);

       onClickBtn40();
       onClickBtn41();
       onClickBtn42();
       onClickBtn43();
       onClickBtn39();
       btnMuaNgay();

       int a = 1;

       ImageView cart = findViewById(R.id.idimgcart);
       String email = intent.getStringExtra("email");
       KhachHang khachHang = khachHangDao.getkhEmail(email);
       cart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               TextView txtSoluong = findViewById(R.id.txtSoLuong);

               GioHang gioHang = new GioHang(hinh1,name,Integer.parseInt(giaThanh),Integer.parseInt(txtSoluong.getText().toString()),size,khachHang.getId());
               gioHangDao.ThemGioHang(gioHang);
               Toast.makeText(ActivityDetailProduct.this,"Thêm vào giỏ hàng thành công",Toast.LENGTH_SHORT).show();
           }
       });

        Button btnMuaNgay = findViewById(R.id.btnMuaNgay);
        btnMuaNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<HoaDon> dshd = hoaDonDao.getAll();
                int ma = dshd.size()+1;
                String soLuong = txtSoLuong.getText().toString();
                int sl = Integer.parseInt(soLuong);

                hoaDonDao.themHoaDon(new HoaDon(khachHang.getId()));

                hoaDonDao.themCTHD(new ChiTietHoaDon(hinh1,name,Integer.parseInt(giaThanh),sl,size,ma));
                Toast.makeText(ActivityDetailProduct.this,"Đặt hàng thành công",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ActivityDetailProduct.this,MainMenu.class);
                i.putExtra("email",MainMenu.email);
                startActivity(i);

            }
        });
        imgIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soLuong = txtSoLuong.getText().toString();
                int sl = Integer.parseInt(soLuong);
                int sol = sl+1;
                txtSoLuong.setText(""+sol);
            }
        });

        imgReudece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soLuong = txtSoLuong.getText().toString();
                int sl = Integer.parseInt(soLuong);
                int sol = sl-1;
                txtSoLuong.setText(""+sol);
                if(sol <0){
                    txtSoLuong.setText("0");
                }
            }
        });




    }



    private void btnMuaNgay() {
        btnMuaNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void onClickBtn39() {
        btn39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn39.setBackground(getDrawable(R.drawable.list_size39));
                btn40.setBackground(getDrawable(R.drawable.list_size));
                btn43.setBackground(getDrawable(R.drawable.list_size));
                btn42.setBackground(getDrawable(R.drawable.list_size));
                btn41.setBackground(getDrawable(R.drawable.list_size));
                size=39;
            }
        });
    }

    private void onClickBtn43() {
        btn43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn43.setBackground(getDrawable(R.drawable.list_size39));
                btn39.setBackground(getDrawable(R.drawable.list_size));
                btn40.setBackground(getDrawable(R.drawable.list_size));
                btn42.setBackground(getDrawable(R.drawable.list_size));
                btn41.setBackground(getDrawable(R.drawable.list_size));
                size=43;
            }
        });
    }

    private void onClickBtn42() {
        btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn42.setBackground(getDrawable(R.drawable.list_size39));
                btn39.setBackground(getDrawable(R.drawable.list_size));
                btn41.setBackground(getDrawable(R.drawable.list_size));
                btn40.setBackground(getDrawable(R.drawable.list_size));
                btn43.setBackground(getDrawable(R.drawable.list_size));
                size = 42;
            }
        });
    }

    private void onClickBtn41() {
        btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn41.setBackground(getDrawable(R.drawable.list_size39));
                btn39.setBackground(getDrawable(R.drawable.list_size));
                btn40.setBackground(getDrawable(R.drawable.list_size));
                btn42.setBackground(getDrawable(R.drawable.list_size));
                btn43.setBackground(getDrawable(R.drawable.list_size));
                size = 41;
            }
        });
    }

    private void onClickBtn40() {
        btn40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn40.setBackground(getDrawable(R.drawable.list_size39));
                btn39.setBackground(getDrawable(R.drawable.list_size));
                btn41.setBackground(getDrawable(R.drawable.list_size));
                btn42.setBackground(getDrawable(R.drawable.list_size));
                btn43.setBackground(getDrawable(R.drawable.list_size));
                size = 40;
            }
        });
    }

    private void khaiBao() {
        tenSanPham = findViewById(R.id.txtTenSanPhamDetail);
        moTaa = findViewById(R.id.txtMoTa);
        giaTien = findViewById(R.id.txtGiaThanhDetail);
        img1 = findViewById(R.id.imgShoesDetail);
        img2 = findViewById(R.id.imgHinh2);
        img3 = findViewById(R.id.imgHinh3);
        img4 = findViewById(R.id.imgHinh4);

         btn39 = findViewById(R.id.btn39);
         btn40 = findViewById(R.id.btn40);
         btn41 = findViewById(R.id.btn41);
         btn42 = findViewById(R.id.btn42);
         btn43 = findViewById(R.id.btn43);
         btnMuaNgay = findViewById(R.id.btnMuaNgay);
         imgIncrease = findViewById(R.id.imgIncrease);
         imgReudece = findViewById(R.id.imgReduce);
         txtSoLuong = findViewById(R.id.txtSoLuong);

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