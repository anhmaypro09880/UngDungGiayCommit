package com.example.ungdunggiay;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {HoaDon.class, com.example.ungdunggiay.ChiTietHoaDon.class,HoaDon_ChiTiet.class, com.example.ungdunggiay.KhachHang.class, com.example.ungdunggiay.HoaDon_KhachHang.class, com.example.ungdunggiay.GioHang.class, com.example.ungdunggiay.GioHang_KhachHang.class},version = 1)
public abstract class DatabaseHoaDon extends RoomDatabase {
    public abstract HoaDonDao HoaDonDao();
    public abstract KhachHangDao KhachHangDao();
    public abstract com.example.ungdunggiay.GioHangDao GioHangDao();
}
