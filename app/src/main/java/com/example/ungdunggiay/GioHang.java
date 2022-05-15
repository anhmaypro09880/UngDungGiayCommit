package com.example.ungdunggiay;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = KhachHang.class,
        parentColumns = "id",
        childColumns = "maKH",deferred = true
))
public class GioHang {
    @PrimaryKey(autoGenerate = true)
    int id;
    private String hinh;
    private String ten;
    private int giatien;
    private int soluong;
    int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int maKH;


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

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public GioHang() {

    }

    public GioHang(String hinh, String ten, int giatien, int soluong) {
        this.hinh = hinh;
        this.ten = ten;
        this.giatien = giatien;
        this.soluong = soluong;
    }

    public GioHang(String hinh, String ten, int giatien, int soluong, int maKH) {
        this.hinh = hinh;
        this.ten = ten;
        this.giatien = giatien;
        this.soluong = soluong;
        this.maKH = maKH;
    }

    public GioHang(String hinh, String ten, int giatien, int soluong, int size, int maKH) {
        this.hinh = hinh;
        this.ten = ten;
        this.giatien = giatien;
        this.soluong = soluong;
        this.size = size;
        this.maKH = maKH;
    }
}
