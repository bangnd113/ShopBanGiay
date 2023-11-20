/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author puddi
 */
public class HoaDonService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<HoaDon> getAllHD() {
        sql = "select ct.MaHD,ct.MaHDCT,hd.MaKH,ct.TenKH,ct.MaSP,ct.TenSP,\n"
                + "ct.DonGia,ct.SoLuong,ct.GhiChu,hd.NgayTao,hd.TongTien\n"
                + "from HoaDon hd\n"
                + "join HoaDonCT ct on hd.MaHD= ct.MaHD";
        List<HoaDon> list = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11));
                list.add(hoaDon);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HoaDon> getAllHDGoc() {
        sql = "select hd.MaHD, hd.NgayTao,hd.TongTien\n"
                + "from HoaDon hd";
        List<HoaDon> list = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(hoaDon);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HoaDon> findHoaDonCT(String maHD) {
        sql = "select ct.MaHDCT,ct.MaHD,ct.TenKH,ct.MaSP,ct.TenSP,\n"
                + "ct.DonGia,ct.SoLuong,ct.GhiChu\n"
                + "from HoaDon hd\n"
                + "join HoaDonCT ct on hd.MaHD= ct.MaHD\n"
                + "where hd.maHD = ?";
        List<HoaDon> list = new ArrayList<>();
        try {
            con = DBconnect1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(
                        rs.getString(2), 
                        rs.getString(1), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getString(7), 
                        rs.getString(8));
                list.add(hoaDon);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
