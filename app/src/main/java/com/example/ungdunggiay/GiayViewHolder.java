package com.example.ungdunggiay;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GiayViewHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView ten;
    TextView gia;
    Context ctx ;

    public GiayViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img_giay1);
        ten = itemView.findViewById(R.id.tv_name1);
        gia = itemView.findViewById(R.id.tv_gia1);
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent()
//            }
//        });
    }
}
