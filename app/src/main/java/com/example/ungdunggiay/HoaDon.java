package com.example.ungdunggiay;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(foreignKeys = @ForeignKey(entity = KhachHang.class,
        parentColumns = "id",
        childColumns = "maKH",deferred = true
))
public class HoaDon {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int maKH;

    public HoaDon(int maKH) {
        this.maKH = maKH;
    }

    public HoaDon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }
}
