package com.example.ungdunggiay;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class KhachHang {
    @PrimaryKey(autoGenerate = true)
   private int id;
   private String tenKH;
   private String soDienThoai;
   private String diaChi;
   private String email;

    public KhachHang(String tenKH, String soDienThoai, String diaChi) {
        this.tenKH = tenKH;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public KhachHang() {

    }

    public KhachHang(String email) {
        this.email = email;
    }

    public KhachHang(String tenKH, String soDienThoai, String diaChi, String email) {
        this.tenKH = tenKH;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
