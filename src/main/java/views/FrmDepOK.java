package views;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.Dep;
import services.IDepService;
import services.impl.DepService;
import swing.Table;
import utilities.Helper;

/**
 *
 * @author dell
 */
public class FrmDepOK extends javax.swing.JPanel {
    
    private ButtonGroup buttonGroup;
    private DefaultTableModel dtm;
    private IDepService iDepService;
    private Helper helper;
    private String fileName;


    /**
     * Creates new form FrmDepOK
     */
    public FrmDepOK() {
        initComponents();

        this.dtm = new DefaultTableModel();

        this.iDepService = new DepService();

        loadDataToTable(this.iDepService.getList());

        this.helper = new Helper();

        tblDep.getTableHeader().setReorderingAllowed(false);
        Table.apply(jScrollPane1, Table.TableType.MULTI_LINE);
    }
   

    private void loadDataToTable(List<Dep> list) {
        dtm = (DefaultTableModel) tblDep.getModel();

        dtm.setRowCount(0);

        for (Dep dep : list) {
            Object[] rowData = new Object[]{
                dep.getMa(),
                dep.getTen(),
                dep.getHinhAnh(),
                dep.getNgayThem(),
                dep.getNgaySuaCuoi(),
                dep.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            };
            dtm.addRow(rowData);
        }
        lbl_Total.setText("Total: " + list.size());
    }

    private Dep getDataFromInput() {

        Dep dep = new Dep();

        int index = tblDep.getSelectedRow();

        String ten = txtTen.getText().trim();
        int trangthai;

        String result;
        for (int i = 1; i < iDepService.getList().size() + 1; i++) {

            result = "SP0" + i;
            if (iDepService.getObj(result) == null) {
                dep.setMa(result);
                break;
            } else {
                continue;
            }
        }

        if (rdoDangkinhdoanh.isSelected() == false && rdoNgungkinhdoanh.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Hãy set Trạng thái cho sản phẩm");
            return null;
        }

        if (rdoDangkinhdoanh.isSelected()) {
            trangthai = 0;
        } else {
            trangthai = 1;
        }

        if (fileName == null) {
            fileName = tblDep.getValueAt(index, 2).toString();
        } else {
            fileName = fileName;
        }

        if (lblHinhAnh.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng đính kèm ảnh !", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        dep.setTen(ten);
        dep.setHinhAnh(fileName);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        dep.setNgayThem(date);
        dep.setNgaySuaCuoi(date);
        dep.setTrangThai(trangthai);

        return dep;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtTimKiem = new swing.TextField();
        txtMa = new swing.TextField();
        txtTen = new swing.TextField();
        rdoDangkinhdoanh = new swing.RadioButtonCustom();
        rdoNgungkinhdoanh = new swing.RadioButtonCustom();
        lblHinhAnh = new javax.swing.JLabel();
        btnThem = new swing.Button();
        btnSua = new swing.Button();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDep = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txtTimKiem.setLabelText("Tìm kiếm");
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        txtMa.setEditable(false);
        txtMa.setLabelText("Mã");

        txtTen.setLabelText("Tên");

        buttonGroup1.add(rdoDangkinhdoanh);
        rdoDangkinhdoanh.setText("Ðang kinh doanh");

        buttonGroup1.add(rdoNgungkinhdoanh);
        rdoNgungkinhdoanh.setText("Ngừng kinh doanh");

        lblHinhAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Cập nhật");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        tblDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Hình Ảnh", "Ngày thêm", "Ngày Sửa Cuối", "Trạng thái"
            }
        ));
        tblDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDep);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("DÉP");

        lbl_Total.setForeground(new java.awt.Color(255, 0, 51));
        lbl_Total.setText("Total: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoDangkinhdoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdoNgungkinhdoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Total)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE))
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoDangkinhdoanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNgungkinhdoanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Total))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        loadDataToTable(iDepService.getObjByName(txtTimKiem.getText()));
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void tblDepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepMouseClicked
        int index = tblDep.getSelectedRow();

        Dep dep = iDepService.getObj(tblDep.getValueAt(index, 0).toString());

        txtMa.setText(tblDep.getValueAt(index, 0).toString());
        txtTen.setText(tblDep.getValueAt(index, 1).toString());
        ImageIcon i = utilities.ImageUltil.resizeIcon(new ImageIcon("images/products/" + dep.getHinhAnh()), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
        lblHinhAnh.setIcon(i);
        if (tblDep.getValueAt(index, 5).toString().equals("Đang kinh doanh")) {
            rdoDangkinhdoanh.setSelected(true);
        } else {
            rdoNgungkinhdoanh.setSelected(true);
        }
    }//GEN-LAST:event_tblDepMouseClicked

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        JFileChooser fileChooser = new JFileChooser("images/products/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*jpg", "jpg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                fileName = fileChooser.getSelectedFile().getPath();
                ImageIcon icon = new ImageIcon(fileName);
                Image image = icon.getImage();
                Image imageResize = utilities.ImageUltil.resize(image, lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
                icon = new ImageIcon(imageResize);
                lblHinhAnh.setIcon(icon);
                File file = new File(fileName);
                file.renameTo(new File("images/products/" + file.getName()));
                fileName = file.getName();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_lblHinhAnhMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Dep dep = this.getDataFromInput();

        if (dep == null) {
            return;
        }

        this.iDepService.save(dep);
        this.loadDataToTable(this.iDepService.getList());
        helper.alert(this, "Thêm thành công");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int index = tblDep.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 sản phẩm");
            return;
        }

        Dep dep = this.getDataFromInput();

        Dep d = this.iDepService.getObj(txtMa.getText().trim());
        d.setTen(dep.getTen());
        d.setHinhAnh(fileName);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        d.setNgaySuaCuoi(date);
        d.setTrangThai(dep.getTrangThai());

        this.iDepService.save(d);
        loadDataToTable(this.iDepService.getList());
        JOptionPane.showMessageDialog(this, "Đã cập nhật");
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnSua;
    private swing.Button btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lbl_Total;
    private swing.RadioButtonCustom rdoDangkinhdoanh;
    private swing.RadioButtonCustom rdoNgungkinhdoanh;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tblDep;
    private swing.TextField txtMa;
    private swing.TextField txtTen;
    private swing.TextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}