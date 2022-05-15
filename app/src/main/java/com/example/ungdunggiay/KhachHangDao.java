package com.example.ungdunggiay;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface KhachHangDao {
    @Insert
    void ThemKH(com.example.ungdunggiay.KhachHang kh);
    @Query("select * from KhachHang")
    List<com.example.ungdunggiay.KhachHang> getKHAll();
    @Query("select * from KhachHang where email=:email")
    KhachHang getkhEmail(String email);
    @Update
    void Update(KhachHang khachHang);

}
