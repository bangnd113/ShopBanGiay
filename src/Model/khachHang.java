/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author puddi
 */
public class khachHang {
    private String maKH;
    private String tenKH;
    private String gTinh;
    private String sdt;
    private String email;
    private String diaChi;
    private int trangThai;

    public khachHang() {
    }

    public khachHang(String maKH, String tenKH, String gTinh, String sdt, String email, String diaChi, int trangThai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gTinh = gTinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getgTinh() {
        return gTinh;
    }

    public void setgTinh(String gTinh) {
        this.gTinh = gTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThai() {
        return trangThai;
    }
    public String getTThai(){
        return (trangThai>0)?"Còn hoạt động":"Dừng";
    }
    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    

    public Object [] todatarow(){
         return new Object[]{
            this.maKH, this.tenKH, this.gTinh, this.sdt, this.email, this.diaChi,this.getTThai()
        };
    }
}
