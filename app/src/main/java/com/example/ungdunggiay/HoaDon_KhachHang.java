package com.example.ungdunggiay;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "HoaDon_KhachHang",
        primaryKeys = { "maHoaDon", "maKH" },
        foreignKeys = {
                @ForeignKey(entity = HoaDon.class,
                        parentColumns = "id",
                        childColumns = "maHoaDon"),
                @ForeignKey(entity = com.example.ungdunggiay.KhachHang.class,
                        parentColumns = "id",
                        childColumns = "maKH")
        })
public class HoaDon_KhachHang {
    int maHoaDon;
    int maKH;
}
