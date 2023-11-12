/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author puddi
 */
public class hoaDon {
    private String maHD;
    private String tongTien;
    private String thanhToan;
    private String tienThua;
    private String hinhThucTT;
    private String hThGiaoHang;
    private String trangThai;
    private String ghiChu;

    public hoaDon() {
    }

    public hoaDon(String maHD, String tongTien, String thanhToan, String tienThua, String hinhThucTT, String hThGiaoHang, String trangThai, String ghiChu) {
        this.maHD = maHD;
        this.tongTien = tongTien;
        this.thanhToan = thanhToan;
        this.tienThua = tienThua;
        this.hinhThucTT = hinhThucTT;
        this.hThGiaoHang = hThGiaoHang;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getTienThua() {
        return tienThua;
    }

    public void setTienThua(String tienThua) {
        this.tienThua = tienThua;
    }

    public String getHinhThucTT() {
        return hinhThucTT;
    }

    public void setHinhThucTT(String hinhThucTT) {
        this.hinhThucTT = hinhThucTT;
    }

    public String gethThGiaoHang() {
        return hThGiaoHang;
    }

    public void sethThGiaoHang(String hThGiaoHang) {
        this.hThGiaoHang = hThGiaoHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
