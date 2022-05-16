package com.example.ungdunggiay;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GioHangDao {
    @Insert
    void ThemGioHang(GioHang gioHang);
    @Query("select * from GioHang where maKH=:maKH")
    List<GioHang> getGioHang(int maKH);
    @Update
    void UpdateGioHang(GioHang gioHang);
    @Query("select * from GioHang where id=:id")
    GioHang getGioHang(String id);
    @Delete
    void deleteGioHang(GioHang gioHang);

}
