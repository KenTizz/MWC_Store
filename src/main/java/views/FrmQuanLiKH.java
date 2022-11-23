/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.KhachHang;
import services.IKhachHangService;
import services.impl.KhachHangService;
import utilities.Helper;

/**
 *
 * @author KimChi
 */
public class FrmQuanLiKH extends javax.swing.JPanel {

    private IKhachHangService iKhachHangService;
    private DefaultTableModel dtm = new DefaultTableModel();
    private Helper helper;

    private KhachHang khachHang = null;
    public FrmQuanLiKH() {
        initComponents();
        this.iKhachHangService = new KhachHangService();
        this.helper = new Helper();
        loadDataToTabel(iKhachHangService.getAll());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_Search = new swing.TextField();
        btn_delete = new swing.Button();
        txt_Ma = new swing.TextField();
        lbl_Total = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_update = new swing.Button();
        btn_add = new swing.Button();
        txt_DiaChi = new swing.TextField();
        txt_DiemTL = new swing.TextField();
        txt_Ten = new swing.TextField();
        txt_SDT = new swing.TextField();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Khachhang = new javax.swing.JTable();

        txt_Search.setToolTipText("");
        txt_Search.setLabelText("Search");
        txt_Search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_SearchCaretUpdate(evt);
            }
        });

        btn_delete.setText("Xóa");
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        txt_Ma.setEditable(false);
        txt_Ma.setToolTipText("");
        txt_Ma.setLabelText("Mã :");

        lbl_Total.setForeground(new java.awt.Color(255, 51, 51));
        lbl_Total.setText("Total : 0");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Khách Hàng");

        btn_update.setText("Cập nhật");
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setText("Thêm");
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        txt_DiaChi.setToolTipText("");
        txt_DiaChi.setLabelText("Địa chỉ :");

        txt_DiemTL.setEditable(false);
        txt_DiemTL.setToolTipText("");
        txt_DiemTL.setLabelText("Điểm tích lũy :");

        txt_Ten.setToolTipText("");
        txt_Ten.setLabelText("Tên : ");

        txt_SDT.setToolTipText("");
        txt_SDT.setLabelText("SĐT :");

        tbl_Khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên", "Địa chỉ", "Số điện thoại", "Điểm tích lũy"
            }
        ));
        tbl_Khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Khachhang);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_DiemTL, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_DiemTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Total))
                        .addGap(18, 18, 18)
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_SearchCaretUpdate
        loadDataToTabel(iKhachHangService.findByName(txt_Search.getText()));
    }//GEN-LAST:event_txt_SearchCaretUpdate

    private void tbl_KhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhachhangMouseClicked
        try {
            int index = tbl_Khachhang.getSelectedRow();

            txt_Ma.setText(tbl_Khachhang.getValueAt(index, 1).toString());
            txt_Ten.setText(tbl_Khachhang.getValueAt(index, 2).toString());
            txt_DiaChi.setText(tbl_Khachhang.getValueAt(index, 3).toString());
            txt_SDT.setText(tbl_Khachhang.getValueAt(index, 4).toString());
            txt_DiemTL.setText(tbl_Khachhang.getValueAt(index, 5).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbl_KhachhangMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int row = tbl_Khachhang.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần xóa!");
        } else {
            KhachHang kh = iKhachHangService.getObj((String) tbl_Khachhang.getValueAt(row, 1));
            iKhachHangService.delete(kh);

            helper.alert(this, "Xóa thành công");
            loadDataToTabel(iKhachHangService.getAll());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int row = tbl_Khachhang.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Chọn 1 dòng khách hàng");
            return;
        }
        KhachHang kh = this.getDataFromInput();
        KhachHang khach = iKhachHangService.getObj(txt_Ma.getText().trim());
        khach.setTen(kh.getTen());
        khach.setDiaChi(kh.getDiaChi());
        khach.setSoDt(kh.getSoDt());
        this.iKhachHangService.save(khach);
        loadDataToTabel(iKhachHangService.getAll());
        helper.alert(this, "Sửa thành công");
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (checkNull()) {
            return;
        }
        KhachHang kh = this.getDataFromInput();
        this.iKhachHangService.save(kh);
        this.loadDataToTabel(this.iKhachHangService.getAll());
        helper.alert(this, "Thêm thành công");
    }//GEN-LAST:event_btn_addActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_add;
    private swing.Button btn_delete;
    private swing.Button btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Total;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tbl_Khachhang;
    private swing.TextField txt_DiaChi;
    private swing.TextField txt_DiemTL;
    private swing.TextField txt_Ma;
    private swing.TextField txt_SDT;
    private swing.TextField txt_Search;
    private swing.TextField txt_Ten;
    // End of variables declaration//GEN-END:variables
    private void loadDataToTabel(List<KhachHang> list) {
        dtm = (DefaultTableModel) tbl_Khachhang.getModel();

        dtm.setRowCount(0);
        int i = 0;

        for (KhachHang kh : list) {
            Object[] rowData = new Object[]{
                i++,
                kh.getMa(),
                kh.getTen(),
                kh.getDiaChi(),
                kh.getSoDt(),
                kh.getDiemTichLuy()
            };
            dtm.addRow(rowData);
        }
        lbl_Total.setText("Total:" + list.size());
    
    }
    private boolean checkNull() {
        if (helper.checkNull(txt_Ten, "Tên")
                || helper.checkRegex(txt_Ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")) {
            return true;
        }
        if (helper.checkNull(txt_DiaChi, "Ðịa chỉ")
                || helper.checkRegex(txt_DiaChi, "(\\S+ )*\\S+", "Địa chỉ không hợp lệ!")) {
            return true;
        }
        if (helper.checkNull(txt_SDT, "Số điện thoại")
                || helper.checkRegex(txt_SDT, "^0[0-9]{9,10}$", "Số điện thoại không hợp lệ!")) {
            return true;
        }

        return false;

    }
     private KhachHang getDataFromInput() {
        KhachHang kh = new KhachHang();

        String result;
        for (int i = 0; i < iKhachHangService.getAll().size() + 1; i++) {
            result = "KH" + i;
            if (iKhachHangService.getObj(result) == null) {
                kh.setMa(result);
                break;
            } else {
                continue;
            }
        }

        String tenKH = txt_Ten.getText().trim();
        String diachi = txt_DiaChi.getText().trim();
        String sdt = txt_SDT.getText().trim();

        kh.setTen(tenKH);
        kh.setDiaChi(diachi);
        kh.setSoDt(sdt);
        kh.setDiemTichLuy(0);

        return kh;
    }
}
