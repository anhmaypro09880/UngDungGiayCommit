package com.example.ungdunggiay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SanPhamAdapter extends BaseAdapter {
    Context ctx;
    int layout;
    ArrayList<SanPham> list;

//    private IClickLisner clickLisner;
//
//    public interface IClickLisner{
//        void newDisplay();
//
//    }



    public SanPhamAdapter(Context ctx, int layout, ArrayList<SanPham> list) {
        this.ctx = ctx;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        view = LayoutInflater.from(ctx).inflate(layout,viewGroup,false);

        TextView txtTenSP = view.findViewById(R.id.txtTenSP);
        TextView txtdonGia = view.findViewById(R.id.txtdonGia);
        ImageView img = view.findViewById(R.id.imgShoes);
//        ConstraintLayout con1 = view.findViewById(R.id.cons1);
//        ConstraintLayout con2 = view.findViewById(R.id.cons2);






        txtdonGia.setText(tach(Integer.parseInt(list.get(i).getGiaTien()))+"VND");
        txtTenSP.setText(list.get(i).getTenSanPham());
//        img.setImageResource(list.get(i).getHinh1());
        Picasso.get().load(list.get(i).getHinh1()).into(img);



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
