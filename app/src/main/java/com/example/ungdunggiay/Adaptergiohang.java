package com.example.ungdunggiay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.room.Room;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class Adaptergiohang extends BaseAdapter {
    Context context;
    ArrayList<com.example.ungdunggiay.GioHang> arrayList;
    int idItem;

//    DatabaseHoaDon db = Room.databaseBuilder(context.getApplicationContext(),
//            DatabaseHoaDon.class,"HoadonBH1.db").allowMainThreadQueries().build();
    private IClickLisner clickLisner;
    public interface IClickLisner {
        void onClickCongIteam(com.example.ungdunggiay.GioHang en);
        void onClickTruIteam(com.example.ungdunggiay.GioHang en);
    }

    public Adaptergiohang(Context context, ArrayList<com.example.ungdunggiay.GioHang> arrayList, int idItem, IClickLisner clickLisner) {
        this.context = context;
        this.arrayList = arrayList;
        this.idItem = idItem;
        this.clickLisner = clickLisner;
    }

    public Adaptergiohang(Context context, ArrayList<com.example.ungdunggiay.GioHang> arrayList, int idItem) {
        this.context = context;
        this.arrayList = arrayList;
        this.idItem = idItem;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(idItem,viewGroup,false);
        ImageView hinh = view.findViewById(R.id.idhinh);
        TextView ten = view.findViewById(R.id.idten);
        TextView gia = view.findViewById(R.id.idgia);
        TextView soluong = view.findViewById(R.id.idsoluong);
        ImageView cong1 = view.findViewById(R.id.cong);
        TextView size = view.findViewById(R.id.idsize);



        Picasso.get().load(arrayList.get(i).getHinh()).into(hinh);
        ten.setText(arrayList.get(i).getTen());
        gia.setText(tach(arrayList.get(i).getGiatien())+"VND");
        soluong.setText(String.valueOf(arrayList.get(i).getSoluong()));
        size.setText(""+arrayList.get(i).getSize());
        int soluongmua = arrayList.get(i).getSoluong();
        ImageView tru = view.findViewById(R.id.tru);
        ImageView cong = view.findViewById(R.id.cong);
        com.example.ungdunggiay.GioHang en = arrayList.get(i);



//        cong.setOnClickListener(new View.OnClickListener() {z
//            @Override
//            public void onClick(View view) {
//                clickLisner.onClickCongIteam(en);
//            }
//        });
//        tru.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                clickLisner.onClickTruIteam(en);
//            }
//        });




        cong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GioHang sp = new GioHang();
//                sp.setHinh("data:image/jpeg;base64,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");
//                sp.setSoluong(arrayList.get(i).getSoluong());
//                sp.setHinh("https://firebasestorage.googleapis.com/v0/b/ungdunggiay.appspot.com/o/giay-removebg-preview.png?alt=media&token=ff0aa5d3-911c-4c7f-b100-42ab7edf230d");
                sp.setHinh(arrayList.get(i).getHinh());
                sp.setTen(arrayList.get(i).getTen());
                sp.setId(arrayList.get(i).getId());
                sp.setGiatien(arrayList.get(i).getGiatien());
                sp.setSoluong(arrayList.get(i).getSoluong()+1);
                sp.setMaKH(arrayList.get(i).getMaKH());
                sp.setSize(arrayList.get(i).getSize());
                ActivityGioHang.gioHangDao.UpdateGioHang(sp);
                int tong = sp.getGiatien()*sp.getSoluong();
//                gia.setText(tach(tong)+"VND");




                ActivityGioHang.arrayListchinh.set(i,sp);
                int  tongtien=0;
//                MainActivity.adapter.notifyDataSetChanged();
                for (int i = 0; i < ActivityGioHang.arrayListchinh.size(); i++)
                {
                    tongtien+=(ActivityGioHang.arrayListchinh.get(i).getGiatien())* ActivityGioHang.arrayListchinh.get(i).getSoluong();
                }
                ActivityGioHang.tong.setText(tach(tongtien)+"VND");
                soluong.setText(String.valueOf(sp.getSoluong()));

                ;
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayList.get(i).getSoluong()>1)
                {
                    com.example.ungdunggiay.GioHang sp = new com.example.ungdunggiay.GioHang();
                    sp.setHinh(arrayList.get(i).getHinh());
                    sp.setTen(arrayList.get(i).getTen());
                    sp.setId(arrayList.get(i).getId());
                    sp.setGiatien(arrayList.get(i).getGiatien());
                    sp.setSoluong(arrayList.get(i).getSoluong()-1);
                    sp.setMaKH(arrayList.get(i).getMaKH());
                    sp.setSize(arrayList.get(i).getSize());
                    ActivityGioHang.gioHangDao.UpdateGioHang(sp);
                    int tong = sp.getGiatien()*sp.getSoluong();
//                    gia.setText(tach(tong)+"VND");
                    ActivityGioHang.arrayListchinh.set(i,sp);
                    int  tongtien=0;
//                MainActivity.adapter.notifyDataSetChanged();
                    for (int i = 0; i < ActivityGioHang.arrayListchinh.size(); i++)
                    {
                        tongtien+=(ActivityGioHang.arrayListchinh.get(i).getGiatien())* ActivityGioHang.arrayListchinh.get(i).getSoluong();
                    }
                    ActivityGioHang.tong.setText(tach(tongtien)+"VND");
                    soluong.setText(String.valueOf(sp.getSoluong()));
                }
                else{
                    ActivityGioHang.gioHangDao.deleteGioHang(ActivityGioHang.arrayListchinh.get(i));
                    ActivityGioHang.arrayListchinh.remove(i);
                    int  tongtien=0;
                    for (int i = 0; i < ActivityGioHang.arrayListchinh.size(); i++)
                    {
                        tongtien+=(ActivityGioHang.arrayListchinh.get(i).getGiatien())* ActivityGioHang.arrayListchinh.get(i).getSoluong();
                    }
                    ActivityGioHang.tong.setText(tach(tongtien)+"VND");
                    ActivityGioHang.adapter.notifyDataSetChanged();
                    if(ActivityGioHang.arrayListchinh.size()==0)
                    {
                        ActivityGioHang.tong.setText("0VND");


                    }

                }



            }
        });


        return view;
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
