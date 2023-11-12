/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Interface.InF_NhanVIen;
import Service.DBconnect1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVien {

    private String MaNV;
    private String HoTen;
    private String GioiTinh;
    private String DiaChi;
    private int SDT;
    private String Email;
    private int Luong;
    private String ChucVu;
    private String TrangThai;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String HoTen, String GioiTinh, String DiaChi, int SDT, String Email, int Luong, String ChucVu, String TrangThai) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
        this.Luong = Luong;
        this.ChucVu = ChucVu;
        this.TrangThai = TrangThai;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Object[] toDaTaRowNV() {
        return new Object[]{
            this.MaNV, this.HoTen, this.GioiTinh, this.DiaChi,
            this.SDT, this.Luong, this.ChucVu, this.TrangThai
        }; 
    }
    public Object[] toDaTaRowNV1() {
        return new Object[]{
            this.MaNV, this.HoTen, this.GioiTinh, this.DiaChi,
            this.SDT, this.Luong, this.ChucVu, this.TrangThai
        }; 
    }
}
