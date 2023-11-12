/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author puddi
 */
public class SanPham {

    private String maSP;
    private String tenSP;
    private String donGia;
    private String giamGia;
    private String mauSac;
    private String chatLieu;
    private String kichThuoc;
    private String tenDM;
    private String nhaSX;
    private String nuocSX;
    private String trangThai;
    private String soLuong;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
    }

    public SanPham(String maSP, String tenSP, String donGia, String giamGia, String mauSac, String chatLieu, String kichThuoc, String tenDM, String nhaSX, String nuocSX, String trangThai, String soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.giamGia = giamGia;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.kichThuoc = kichThuoc;
        this.tenDM = tenDM;
        this.nhaSX = nhaSX;
        this.nuocSX = nuocSX;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    public String getNuocSX() {
        return nuocSX;
    }

    public void setNuocSX(String nuocSX) {
        this.nuocSX = nuocSX;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public Object[] todataRow() {
        return new Object[]{ this.maSP, this.tenSP, this.donGia,this.giamGia,this,mauSac,this.chatLieu,this.kichThuoc ,this.soLuong};
    }
}
