package com.example.ungdunggiay;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "HoaDon_ChiTiet",
        primaryKeys = { "maHoaDon", "maChiTiet" },
        foreignKeys = {
                @ForeignKey(entity = HoaDon.class,
                        parentColumns = "id",
                        childColumns = "maHoaDon"),
                @ForeignKey(entity = ChiTietHoaDon.class,
                        parentColumns = "id",
                        childColumns = "maChiTiet")
        })
public class HoaDon_ChiTiet {
    int maHoaDon;
    int maChiTiet;


    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaChiTiet() {
        return maChiTiet;
    }

    public void setMaChiTiet(int maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public HoaDon_ChiTiet() {

    }
}
