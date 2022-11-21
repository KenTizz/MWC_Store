package views;

import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.UUID;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.ChucVu;
import models.NguoiDung;
import services.IChucVuService;
import services.INguoiDungService;
import services.impl.ChucVuService;
import services.impl.NguoiDungService;
import swing.Table;
import utilities.Helper;

/**
 *
 * @author VU NGUYEN HUONG
 * 
 * 
 */
public class FrmNhanVien extends javax.swing.JPanel {
    
    private ButtonGroup btn = new ButtonGroup();
    private DefaultTableModel defaultTableModel;
    private INguoiDungService nguoidungSV;
    private IChucVuService iChucVuService;
    private Helper helper;
    private String filename;
    
    public FrmNhanVien() {
        initComponents();
        nguoidungSV = new NguoiDungService();
        LoadData(nguoidungSV.getListNhanVien("CV2"));
        GioiTinh();
        iChucVuService = new ChucVuService();
        Table.apply(jScrollPane1, Table.TableType.DEFAULT);
        helper = new Helper();
       
    }
    
    public void GioiTinh(){
        btn.add(rd_nam);
        btn.add(rd_nu);
    }
    public void LoadData(List<NguoiDung> list){
        defaultTableModel = (DefaultTableModel) tb_nhanvien.getModel();
        defaultTableModel.setRowCount(0);
        int stt = 1;
        for (NguoiDung x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++,x.getMa(),x.getTen(),x.getEmail(),x.getSdt(),x.getDiaChi(),x.getTrangThai(),x.getHinhAnh()
            });
                
        }
    }
    public NguoiDung getForm(){
        NguoiDung nguoidung = new NguoiDung();
        int index = tb_nhanvien.getSelectedRow();
        String ma = txt_ma1.getText();
        nguoidung.setMa(ma);
        String ten = txt_ten.getText();
        nguoidung.setTen(ten);
        String email = txt_email.getText();
        nguoidung.setEmail(email);
        String sdt = txt_sdt.getText();
        nguoidung.setSdt(sdt);
        String diachi = txt_diachi.getText();
        nguoidung.setDiaChi(diachi);
        nguoidung.setHinhAnh("defaultavt.jpg");
        nguoidung.setMatKhau(txt_matkhau.getPassword().toString());
        ChucVu cv = iChucVuService.getAll().get(1);
        nguoidung.setChucVu(cv);
        int gioitinh;
        if(rd_nam.isSelected()){
            gioitinh = 0;
        }else{
            gioitinh = 1;
        }
        nguoidung.setGioiTinh(gioitinh);
        int trangthai;
        if(cb_trangthai.getSelectedItem().equals("Còn Làm")){
            trangthai = 0;
        }else{
            trangthai = 1;
        }
        nguoidung.setTrangThai(trangthai);
        if (filename == null) {
            filename = tb_nhanvien.getValueAt(index, 2).toString();
        } else {
            filename = filename;
        }

        if (lblHinhAnh.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng đính kèm ảnh !", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }

   
        nguoidung.setHinhAnh(filename);
        return nguoidung;
    }
    private boolean checkNull() {
        if (helper.checkNull(txt_ten, "Tên")
                || helper.checkRegex(txt_ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")) {
            return true;
        } else if (!rd_nam.isSelected() && !rd_nu.isSelected()) {
            helper.error(this, "chưa chọn giới tính");
            return true;
        }
        return false;

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btn_scanqr = new swing.Button();
        txt_email = new swing.TextField();
        txt_ten = new swing.TextField();
        txt_diachi = new swing.TextField();
        rd_nam = new swing.RadioButtonCustom();
        rd_nu = new swing.RadioButtonCustom();
        txt_ma1 = new swing.TextField();
        txt_sdt = new swing.TextField();
        txt_matkhau = new swing.PasswordField();
        cb_trangthai = new swing.Combobox();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_nhanvien = new javax.swing.JTable();
        btn_them = new swing.Button();
        btn_sua = new swing.Button();
        btn_xoa = new swing.Button();
        txt_timkiem = new swing.TextField();
        lblHinhAnh = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        btn_scanqr.setText("Quét QR");
        btn_scanqr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_scanqrActionPerformed(evt);
            }
        });

        txt_email.setLabelText("Email");

        txt_ten.setLabelText("Tên");

        txt_diachi.setLabelText("Địa chỉ");

        buttonGroup1.add(rd_nam);
        rd_nam.setText("Nam");

        buttonGroup1.add(rd_nu);
        rd_nu.setText("Nữ");

        txt_ma1.setLabelText("Mã");

        txt_sdt.setLabelText("SDT");

        txt_matkhau.setText("passwordField1");
        txt_matkhau.setLabelText("Mật Khẩu");

        cb_trangthai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Còn Làm", "Đã Nghỉ" }));
        cb_trangthai.setLabeText("Trạng Thái");

        tb_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Email", "Số Điện Thoại", "Địa Chỉ", "Trạng Thái"
            }
        ));
        tb_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_nhanvien);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        txt_timkiem.setLabelText("Tìm Kiếm");
        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });
        txt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemActionPerformed(evt);
            }
        });

        lblHinhAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_scanqr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_diachi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_ma1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_trangthai, txt_diachi, txt_email, txt_ma1, txt_matkhau, txt_sdt, txt_ten});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_sua, btn_them, btn_xoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btn_scanqr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_sua, btn_them, btn_xoa});

    }// </editor-fold>//GEN-END:initComponents

    private void btn_scanqrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_scanqrActionPerformed
        FrmQRCCD qRCCD = new FrmQRCCD();
        qRCCD.setVisible(true);
//        NguoiDung nd = qRCCD.getNguoiDung();
//        txt_ma.setText(nd.getMa());
//        txt_ten.setText("");
//        txt_diachi.setText("");
//        if ("" == "Nam") {
//            rd_nam.setSelected(true);
//        } else {
//            rd_nu.setSelected(true);
//        }

//         txt_ma.setText("");
//        txt_ten.setText("");
//        txt_diachi.setText("");
//        if ("" == "Nam") {
//            rd_nam.setSelected(true);
//        } else {
//            rd_nu.setSelected(true);
//        }
    }//GEN-LAST:event_btn_scanqrActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if(checkNull()){
            return;
        }
        NguoiDung nguoidung = getForm();
        this.nguoidungSV.save(nguoidung);
        LoadData(nguoidungSV.getListNhanVien("CV2"));
        JOptionPane.showMessageDialog(this, "Them thanh cong");
    }//GEN-LAST:event_btn_themActionPerformed

    private void tb_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nhanvienMouseClicked
        int row = tb_nhanvien.getSelectedRow();
        NguoiDung nuoidung = nguoidungSV.getListNhanVien("CV2").get(row);
        txt_ma1.setText(nuoidung.getMa());
        txt_diachi.setText(nuoidung.getDiaChi());
        txt_email.setText(nuoidung.getEmail());
        txt_matkhau.setText(nuoidung.getMatKhau());
        txt_sdt.setText(nuoidung.getSdt());
        txt_ten.setText(nuoidung.getTen());
        cb_trangthai.setSelectedIndex(nuoidung.getTrangThai());
        rd_nam.setSelected(nuoidung.getGioiTinh()==0);
        rd_nu.setSelected(nuoidung.getGioiTinh()==1);
        ImageIcon i = utilities.ImageUltil.resizeIcon(new ImageIcon("images/users/" + nuoidung.getHinhAnh()), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
        lblHinhAnh.setIcon(i);
        
    }//GEN-LAST:event_tb_nhanvienMouseClicked

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int row = tb_nhanvien.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this,"Chon 1 dong de sua");
            return;
        }
        NguoiDung nguoidung = getForm();
        NguoiDung nguoi = nguoidungSV.getObj(txt_ma1.getText().trim());
     
        nguoi.setTen(nguoidung.getTen());
        nguoi.setDiaChi(nguoidung.getDiaChi());
        nguoi.setEmail(nguoidung.getEmail());
        nguoi.setSdt(nguoidung.getSdt());
        nguoi.setTrangThai(nguoidung.getTrangThai());
        nguoi.setGioiTinh(nguoidung.getGioiTinh());
        nguoi.setMatKhau(nguoidung.getMatKhau());
        nguoi.setHinhAnh(nguoidung.getHinhAnh());
        this.nguoidungSV.save(nguoi);
        LoadData(nguoidungSV.getListNhanVien("CV2"));
        JOptionPane.showMessageDialog(this, "Sủa Thành Công");
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        int row = tb_nhanvien.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng để xóa");
            return;
        }
        NguoiDung nguoiDung = nguoidungSV.getListNhanVien("CV2").get(row);
        this.nguoidungSV.delete(nguoiDung);
        LoadData(nguoidungSV.getListNhanVien("CV2"));
        JOptionPane.showMessageDialog(this,"Xóa Thành Công");
        
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void txt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemActionPerformed
        
    }//GEN-LAST:event_txt_timkiemActionPerformed

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate
        LoadData(nguoidungSV.findByName("CV2", txt_timkiem.getText().trim()));
    }//GEN-LAST:event_txt_timkiemCaretUpdate

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        JFileChooser fileChooser = new JFileChooser("images/users/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*jpg", "jpg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                filename = fileChooser.getSelectedFile().getPath();
                ImageIcon icon = new ImageIcon(filename);
                Image image = icon.getImage();
                Image imageResize = utilities.ImageUltil.resize(image, lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
                icon = new ImageIcon(imageResize);
                lblHinhAnh.setIcon(icon);
                File file = new File(filename);
                file.renameTo(new File("images/users/" + file.getName()));
                filename = file.getName();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_lblHinhAnhMouseClicked

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_scanqr;
    private swing.Button btn_sua;
    private swing.Button btn_them;
    private swing.Button btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private swing.Combobox cb_trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private swing.RadioButtonCustom rd_nam;
    private swing.RadioButtonCustom rd_nu;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tb_nhanvien;
    private swing.TextField txt_diachi;
    private swing.TextField txt_email;
    private swing.TextField txt_ma1;
    private swing.PasswordField txt_matkhau;
    private swing.TextField txt_sdt;
    private swing.TextField txt_ten;
    private swing.TextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
