package com.example.ungdunggiay;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "GioHang_KhachHang",
        primaryKeys = { "maGioHang", "maKH" },
        foreignKeys = {
                @ForeignKey(entity = com.example.ungdunggiay.GioHang.class,
                        parentColumns = "id",
                        childColumns = "maGioHang"),
                @ForeignKey(entity = KhachHang.class,
                        parentColumns = "id",
                        childColumns = "maKH")
        })
public class GioHang_KhachHang {
    int maGioHang;
    int maKH;

    public GioHang_KhachHang(int maGioHang, int maKH) {
        this.maGioHang = maGioHang;
        this.maKH = maKH;
    }

    public GioHang_KhachHang() {

    }

    public int getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(int maGioHang) {
        this.maGioHang = maGioHang;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }
}
