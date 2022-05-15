package com.example.ungdunggiay;

public class SanPham {
    private String id;
    private String tenSanPham;
    private String moTa;
    private String giaTien;
    private String size;
    private String hinh1;
    private String hinh2;
    private String danhGia;
    private String hinh3;
    private String hinh4;

    public SanPham() {
    }

    public SanPham(String id, String tenSanPham, String moTa, String giaTien, String size, String hinh1, String hinh2, String danhGia, String hinh3, String hinh4) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.giaTien = giaTien;
        this.size = size;
        this.hinh1 = hinh1;
        this.hinh2 = hinh2;
        this.danhGia = danhGia;
        this.hinh3 = hinh3;
        this.hinh4 = hinh4;
    }

    public SanPham(String id, String tenSanPham, String moTa, String giaTien, String size, String hinh1, String hinh2, String hinh3, String hinh4) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.giaTien = giaTien;
        this.size = size;
        this.hinh1 = hinh1;
        this.hinh2 = hinh2;
        this.hinh3 = hinh3;
        this.hinh4 = hinh4;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getHinh1() {
        return hinh1;
    }

    public void setHinh1(String hinh1) {
        this.hinh1 = hinh1;
    }

    public String getHinh2() {
        return hinh2;
    }

    public void setHinh2(String hinh2) {
        this.hinh2 = hinh2;
    }

    public String getHinh3() {
        return hinh3;
    }

    public void setHinh3(String hinh3) {
        this.hinh3 = hinh3;
    }

    public String getHinh4() {
        return hinh4;
    }

    public void setHinh4(String hinh4) {
        this.hinh4 = hinh4;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }
}
