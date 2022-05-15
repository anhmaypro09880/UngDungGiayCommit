package com.example.ungdunggiay;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = HoaDon.class,
        parentColumns = "id",
        childColumns = "maHoaDon",deferred = true
        ))
public class ChiTietHoaDon {
    @PrimaryKey(autoGenerate = true)
    private int id;
    String hinh;
    String tenSP;
    int donGia;
    int soLuong;
    int size;
    int maHoaDon;

    public ChiTietHoaDon(int maChiTiet, String hinh, String tenSP, int donGia, int soLuong) {
        this.id = maChiTiet;
        this.hinh = hinh;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ChiTietHoaDon(String hinh, String tenSP, int donGia, int soLuong, int maHoaDon) {
        this.hinh = hinh;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.maHoaDon = maHoaDon;
    }

    public ChiTietHoaDon(int id, String hinh, String tenSP, int donGia, int soLuong, int maHoaDon) {
        this.id = id;
        this.hinh = hinh;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.maHoaDon = maHoaDon;
    }

    public ChiTietHoaDon(String hinh, String tenSP, int donGia, int soLuong, int size, int maHoaDon) {
        this.hinh = hinh;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.size = size;
        this.maHoaDon = maHoaDon;
    }

    public ChiTietHoaDon() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
