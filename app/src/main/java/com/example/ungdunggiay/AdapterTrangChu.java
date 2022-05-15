package com.example.ungdunggiay;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class AdapterTrangChu extends RecyclerView.Adapter<GiayViewHolder>{

    private List<SanPham> listGiay;
    private Context context;
    private LayoutInflater layoutInflater;
    private Adaptergiohang.IClickLisner clickLisner;

//    private MainSanPham spDao = new MainSanPham();
//    public interface IClickLisner {
//        void onClickIteam();
//
//    }

    public AdapterTrangChu(List<SanPham> listGiay, Context context) {
        this.listGiay = listGiay;
        this.context = context;
    }

    @NonNull
    @Override
    public GiayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_giay3,parent,false);
        GiayViewHolder viewHolder = new GiayViewHolder(itemView);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull GiayViewHolder holder, int position) {
        SanPham giay = this.listGiay.get(position);
        Picasso.get().load(giay.getHinh1()).into(holder.img);
        // Bind data to viewholder
        holder.ten.setText(giay.getTenSanPham());
        holder.gia.setText(tach(Integer.parseInt(giay.getGiaTien()))+"Đ");
        int i = position;
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context,"aaaaa",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context,ActivityDetailProduct.class);
                intent.putExtra("tenSanPham",listGiay.get(i).getTenSanPham());
                intent.putExtra("moTa",listGiay.get(i).getMoTa());
                intent.putExtra("giaThanh",listGiay.get(i).getGiaTien());
                intent.putExtra("hinh1",listGiay.get(i).getHinh1());
                intent.putExtra("hinh2",listGiay.get(i).getHinh2());
                intent.putExtra("hinh3",listGiay.get(i).getHinh3());
                intent.putExtra("hinh4",listGiay.get(i).getHinh4());
                intent.putExtra("danhGia",listGiay.get(i).getDanhGia());
                intent.putExtra("email",MainMenu.email);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.listGiay.size();
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

//    public class GiayViewHolder extends RecyclerView.ViewHolder {
//
//        ImageView img;
//        TextView ten;
//        TextView gia;
//
//        public GiayViewHolder(@NonNull View itemView) {
//            super(itemView);
//            img = itemView.findViewById(R.id.img_giay1);
//            ten = itemView.findViewById(R.id.tv_name1);
//            gia = itemView.findViewById(R.id.tv_gia1);
//
//        }
//    }


}
