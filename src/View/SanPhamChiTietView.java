/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.ChatLieu;
import Model.DanhMuc;
import Model.MauSac;
import Model.NhaSanXuat;
import Model.SanPham;
import Service.ChatLieuService;
import Service.DanhMucService;
import Service.MauSacSevice;
import Service.NhaSanXuatSevice;
import Service.SanPhamService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author puddi
 */
public class SanPhamChiTietView extends javax.swing.JFrame {

    SanPhamService spService = new SanPhamService();
    DanhMucService dmService = new DanhMucService();
    NhaSanXuatSevice nsxService = new NhaSanXuatSevice();
    MauSacSevice msService = new MauSacSevice();
    ChatLieuService clService = new ChatLieuService();

    public SanPhamChiTietView() {
        initComponents();

    }

    private void updateMauSacCombobox() {
        List<MauSac> mauSacList = msService.getAllMS();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (MauSac mauSac : mauSacList) {
            model.addElement(mauSac.getTenMS());
        }
        cbMau.setModel(model);
    }

    private void updateDanhMucCombobox() {
        // Gọi phương thức để lấy danh sách danh mục mới từ cơ sở dữ liệu hoặc nơi bạn lưu trữ chúng
        List<DanhMuc> danhMucList = dmService.getAllDM();
        // Tạo một DefaultComboBoxModel<String> mới
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        // Thêm các mục từ danh sách DanhMuc vào model với toString()
        for (DanhMuc danhMuc : danhMucList) {
            model.addElement(danhMuc.getTenDM());
        }
        // Gán model cho JComboBox
        cbDanhMuc.setModel(model);
    }

    private void updateNSXCombobox() {
        List<NhaSanXuat> nsxList = nsxService.getAllNSX();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (NhaSanXuat nsx : nsxList) {
            model.addElement(nsx.getTenNSX());
        }
        cbNSX.setModel(model);
    }

    private void updateCLCombobox() {
        List<ChatLieu> clList = clService.getAllChatLieu();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (ChatLieu cl : clList) {
            model.addElement(cl.getTenCL());
        }
        cbChatLieu.setModel(model);
    }

    public void fillFormCTSP(String maSP) {
        updateCLCombobox();
        updateDanhMucCombobox();
        updateMauSacCombobox();
        updateNSXCombobox();
        List<SanPham> list = spService.findSP(maSP);
        SanPham sp = list.get(0);
        txtMaCTSP.setText(sp.getMaSPCT());
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
        txtSoLuong.setText(sp.getSoLuong());
        txtXuatXu.setText(sp.getXuatXu());
        txtMoTa.setText(sp.getMoTa());
        cbChatLieu.setSelectedItem(sp.getChatLieu());
        cbKichThuoc.setSelectedItem(sp.getKichThuoc());
        cbMau.setSelectedItem(sp.getMauSac());
        cbNSX.setSelectedItem(sp.getNhaSX());
        txtDonGia.setText(sp.getDonGia2());
        txtBarcode.setText(sp.getBarcode());
        String tenDM = null;
        for (DanhMuc dm : dmService.getAllDM()) {
            if (dm.getMaDM().equalsIgnoreCase(sp.getMaDM())) {
                tenDM = dm.getTenDM();
                break;
            }
        }
        cbDanhMuc.setSelectedItem(tenDM);
    }

    boolean checkDataOnForm() {
        if (txtMaSP.getText().trim().isEmpty()
                || txtMaSP.getText().trim().isEmpty()
                || txtTenSP.getText().trim().isEmpty()
                || txtXuatXu.getText().trim().isEmpty()
                || txtSoLuong.getText().trim().isEmpty()
                || txtMaCTSP.getText().trim().isEmpty()
                || txtMoTa.getText().trim().isEmpty()
                || txtDonGia.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin!");
            return false;
        }

        boolean i = false, f = false;
        for (SanPham sp : spService.getAllSP()) {
            if (txtMaSP.getText().trim().equals(sp.getMaSP())) {
                i = true;
            }
            if (txtMaCTSP.getText().trim().equals(sp.getMaSP())) {
                f = true;
            }
        }
        if (i || f) {
            JOptionPane.showMessageDialog(this, "Đã tồn tại mã sản phẩm hoặc mã sản phẩm chi tiết!");
            return false;
        }

        return true;
    }

    boolean checkDataOnForm2() {
        if (txtMaSP.getText().trim().isEmpty()
                || txtMaSP.getText().trim().isEmpty()
                || txtTenSP.getText().trim().isEmpty()
                || txtXuatXu.getText().trim().isEmpty()
                || txtSoLuong.getText().trim().isEmpty()
                || txtMaCTSP.getText().trim().isEmpty()
                || txtMoTa.getText().trim().isEmpty()
                || txtDonGia.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin!");
            return false;
        }
        return true;
    }

    public SanPham getDataOnForm() {
        String maSP, tenSP, maDM = null, maNSX = null, donGia, trangThai, maSPCT, chatLieu, kichThuoc, mauSac, soLuong, nhaSX, xuatXu, moTa;
        maSPCT = txtMaCTSP.getText().trim();
        maSP = txtMaSP.getText().trim();
        tenSP = txtTenSP.getText();
        soLuong = txtSoLuong.getText().trim();
        xuatXu = txtXuatXu.getText().trim();
        moTa = txtMoTa.getText().trim();
        chatLieu = cbChatLieu.getSelectedItem().toString();
        donGia = txtDonGia.getText().trim();
        if (Integer.parseInt(txtSoLuong.getText().trim()) > 0) {
            trangThai = "1";
        } else {
            trangThai = "0";
        }
        kichThuoc = cbKichThuoc.getSelectedItem().toString();
        mauSac = cbMau.getSelectedItem().toString();
        nhaSX = cbNSX.getSelectedItem().toString();
        for (DanhMuc object : dmService.getAllDM()) {
            if (object.getTenDM().equalsIgnoreCase(cbDanhMuc.getSelectedItem().toString())) {
                maDM = object.getMaDM();
                break;
            }
        }

//        for (NhaSanXuat object : nsxService.getAllNSX()) {
//            if (object.getTenNSX().equalsIgnoreCase(nhaSX)) {
//                maNSX = object.getMaNSX();
//                break;
//            }
//        }
        for (NhaSanXuat object : nsxService.getAllNSX()) {
            if (object.getTenNSX().equalsIgnoreCase(cbNSX.getSelectedItem().toString())) {
                maNSX = object.getMaNSX();
                break;
            }
        }
        System.out.println(maNSX);
        return new SanPham(maSP, tenSP, maDM, maNSX, donGia, trangThai, maSPCT, chatLieu, kichThuoc, mauSac, soLuong, nhaSX, xuatXu, moTa);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaCTSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtMaSP = new javax.swing.JTextField();
        cbChatLieu = new javax.swing.JComboBox<>();
        cbKichThuoc = new javax.swing.JComboBox<>();
        cbMau = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        cbNSX = new javax.swing.JComboBox<>();
        txtXuatXu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnThemSP = new javax.swing.JButton();
        btnSuaSP = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbDanhMuc = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi Tiết Sản Phẩm");

        jPanel1.setBackground(new java.awt.Color(183, 151, 104));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CHI TIẾT SẢN PHẨM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(25, 25, 25))
        );

        jLabel3.setText("Mã CTSP");

        jLabel4.setText("Mã Sản Phẩm");

        jLabel5.setText("Tên Sản Phẩm");

        jLabel6.setText("Chất liệu");

        jLabel7.setText("Kích thước");

        jLabel8.setText("Màu");

        cbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vải", "Da" }));

        cbKichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43" }));

        cbMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vàng sọc đỏ", "Xanh nõn chuối", "Đỏ xanh nhạt" }));

        jLabel9.setText("Số lượng");

        jLabel10.setText("Nhà Sản Xuất");

        jLabel12.setText("Xuất xứ");

        jLabel13.setText("Mô tả");

        cbNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Skechers", "Adidas", "Asic", "Converse", "Nike", "New Balance", "Puma", "Reebok" }));

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        btnThemSP.setText("Thêm");
        btnThemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemSPMouseClicked(evt);
            }
        });

        btnSuaSP.setText("Sửa");
        btnSuaSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaSPMouseClicked(evt);
            }
        });

        jLabel11.setText("Danh mục");

        cbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giày Bata", "Giày lười", "Giày da" }));

        jLabel14.setText("Đơn giá");

        jLabel15.setText("VNĐ");

        jLabel16.setText("Barcode");

        jButton1.setText("+");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbChatLieu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbKichThuoc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbMau, javax.swing.GroupLayout.Alignment.LEADING, 0, 126, Short.MAX_VALUE))))
                    .addComponent(jLabel5))
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuong)
                            .addComponent(cbNSX, 0, 190, Short.MAX_VALUE)
                            .addComponent(txtXuatXu))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBarcode)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15))
                            .addComponent(cbDanhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemSP)
                .addGap(200, 200, 200)
                .addComponent(btnSuaSP)
                .addGap(477, 477, 477))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(cbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)))
                    .addComponent(jLabel11))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jButton1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaSP)
                    .addComponent(btnThemSP))
                .addGap(104, 104, 104))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemSPMouseClicked
        SanPham sp = getDataOnForm();
        if (checkDataOnForm()) {
            if (spService.addSP(sp) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        }


    }//GEN-LAST:event_btnThemSPMouseClicked

    private void btnSuaSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaSPMouseClicked
        SanPham sp = getDataOnForm();
        if (checkDataOnForm2()) {
            if (spService.xoaSP(sp) > 0) {
                if (spService.addSP(sp) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại!"
                        + "Không tìm thấy sản phẩm cần sửa!");
            }
        }


    }//GEN-LAST:event_btnSuaSPMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SanPhamChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamChiTietView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaSP;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JComboBox<String> cbChatLieu;
    private javax.swing.JComboBox<String> cbDanhMuc;
    private javax.swing.JComboBox<String> cbKichThuoc;
    private javax.swing.JComboBox<String> cbMau;
    private javax.swing.JComboBox<String> cbNSX;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaCTSP;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}
