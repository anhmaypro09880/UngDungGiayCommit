package com.example.ungdunggiay;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface  HoaDonDao {
    @Insert
    void themHoaDon(HoaDon hoaDon);
    @Query("select * from HoaDon")
    List<HoaDon> getAll();
    @Insert
    void themCTHD(ChiTietHoaDon chiTietHoaDon);
    @Insert
    void  themHD_CT(HoaDon_ChiTiet hoaDon_chiTiet);
    @Query("select * from ChiTietHoaDon where maHoaDon=:maHoaDon")
    List<ChiTietHoaDon> getCTHD(int maHoaDon);
    @Query("select * from HoaDon where maKH=:maKH")
    List<HoaDon> getHoaDonByKH(int maKH);

}
