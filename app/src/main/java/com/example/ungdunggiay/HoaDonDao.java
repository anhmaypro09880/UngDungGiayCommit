package com.example.ungdunggiay;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface  HoaDonDao {
    @Insert
    void themHoaDon(com.example.ungdunggiay.HoaDon hoaDon);
    @Query("select * from HoaDon")
    List<com.example.ungdunggiay.HoaDon> getAll();
    @Insert
    void themCTHD(com.example.ungdunggiay.ChiTietHoaDon chiTietHoaDon);
    @Insert
    void  themHD_CT(com.example.ungdunggiay.HoaDon_ChiTiet hoaDon_chiTiet);
    @Query("select * from ChiTietHoaDon where maHoaDon=:maHoaDon")
    List<com.example.ungdunggiay.ChiTietHoaDon> getCTHD(int maHoaDon);
    @Query("select * from HoaDon where maKH=:maKH")
    List<com.example.ungdunggiay.HoaDon> getHoaDonByKH(int maKH);

}
