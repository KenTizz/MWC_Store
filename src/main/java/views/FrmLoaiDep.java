package views;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.LoaiDep;
import services.ILoaiDepService;
import services.impl.LoaiDepService;
import swing.Table;
import ui.EventPagination;
import ui.NotificationMess;
import ui.Page;
import ui.PaginationItemRenderStyle1;
import utilities.Helper;

/**
 *
 * @author dell
 */
public class FrmLoaiDep extends javax.swing.JPanel {

    private ILoaiDepService loaidepSV;
    private DefaultTableModel defaultTableModel;
    private Helper helper;
    private SimpleDateFormat formatD = new SimpleDateFormat("dd-MM-yyyy");
    
    private Page pg = new Page();
    private int checkSearchCT = 0;

    Integer limit = 5;
    Integer totalData = 0;

    /**
     * Creates new form FrmSizeOK
     */
    public FrmLoaiDep() {
        initComponents();
        loaidepSV = new LoaiDepService();
        helper = new Helper();
        pagination();
        pagination1.setPagegination(1, pg.getTotalPage());
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
        Table.apply(jScrollPane1, Table.TableType.MULTI_LINE);
    }
    
    public void pagination() {
        LoadTabale(loaidepSV.pagination( pg.getCurrent(), limit));
        totalData = loaidepSV.getAll().size();
        int totalPage = (int) Math.ceil(totalData.doubleValue() / limit);
        pg.setTotalPage(totalPage);
        pagination1.setPagegination(pg.getCurrent(), pg.getTotalPage());
        pagination1.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                LoadTabale(loaidepSV.pagination( page, limit));
                pg.setCurrent(page);
                pagination1.setPagegination(pg.getCurrent(), pg.getTotalPage());
            }
        });
    }

    public void LoadTabale(List<LoaiDep> list) {
        defaultTableModel = (DefaultTableModel) tb_Table.getModel();
        defaultTableModel.setRowCount(0);
        for (LoaiDep x : list) {
            Object[] row = {
                x.getMa(), x.getTen(), formatD.format(x.getNgayThem()), formatD.format(x.getNgaySuaCuoi()),
                x.getTrangThai() == 0 ? "Đang Kinh Doanh" : "Ngừng Kinh Doanh"
            };
            defaultTableModel.addRow(row);
        }
        lbl_Total.setText("Total:" + list.size());
    }

    private boolean checkNull() {
        if (helper.checkNull(txt_Ten, "Tên")
                || helper.checkRegex(txt_Ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")) {
            return true;
        }
        return false;

    }

    private LoaiDep getForm() {
        LoaiDep loaiDep = new LoaiDep();
        String result;
        for (int i = 0; i < loaidepSV.getAll().size() + 1; i++) {
            result = "LD" + i;
            if (loaidepSV.getObj(result) == null) {
                loaiDep.setMa(result);
                break;
            } else {
                continue;
            }
        }
        String ten = txt_Ten.getText();
        int trangthai;
        if (rd_DangKinhDoanh.isSelected()) {
            trangthai = 0;
        } else {
            trangthai = 1;
        }
        loaiDep.setTen(ten);
        loaiDep.setNgayThem(new Date());
        loaiDep.setNgaySuaCuoi(new Date());
        loaiDep.setTrangThai(trangthai);
        return loaiDep;

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
        txt_Ma = new swing.TextField();
        rd_DangKinhDoanh = new swing.RadioButtonCustom();
        rd_NgungKinhDoanh = new swing.RadioButtonCustom();
        btn_update = new swing.Button();
        btn_add = new swing.Button();
        txt_search = new swing.TextField();
        txt_Ten = new swing.TextField();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Table = new javax.swing.JTable();
        lbl_Total = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pagination1 = new swing.Pagination();

        setBackground(new java.awt.Color(255, 255, 255));

        txt_Ma.setEditable(false);
        txt_Ma.setToolTipText("");
        txt_Ma.setLabelText("Mã :");

        buttonGroup1.add(rd_DangKinhDoanh);
        rd_DangKinhDoanh.setSelected(true);
        rd_DangKinhDoanh.setText("Đang kinh doanh");

        buttonGroup1.add(rd_NgungKinhDoanh);
        rd_NgungKinhDoanh.setText("Ngừng kinh doanh");

        btn_update.setText("Cập nhật");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        txt_search.setLabelText("Search");
        txt_search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_searchCaretUpdate(evt);
            }
        });

        txt_Ten.setToolTipText("");
        txt_Ten.setLabelText("Tên : ");

        tb_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Ngày thêm", "Ngày sửa cuối", "Trạng thái"
            }
        ));
        tb_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Table);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lbl_Total.setForeground(new java.awt.Color(255, 0, 51));
        lbl_Total.setText("Total: 0");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("LOẠI DÉP");

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        pagination1.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_search, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_NgungKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_DangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Total))
                        .addGap(18, 18, 18)
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rd_DangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rd_NgungKinhDoanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Total))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        int row = tb_Table.getSelectedRow();
        if (row == -1) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Chọn 1 dòng loại dép để cập nhật");
            panel.showNotification();
            return;
        }
        LoaiDep loaidep = getForm();
        LoaiDep loai = loaidepSV.getObj(txt_Ma.getText().trim());
        loai.setTen(loaidep.getTen());
        loai.setNgaySuaCuoi(loaidep.getNgaySuaCuoi());
        loai.setTrangThai(loaidep.getTrangThai());
        this.loaidepSV.save(loai);
        if (checkSearchCT == 0) {
            loai = loaidepSV.pagination( pg.getCurrent(), limit).get(row);
        } else {
            loai = loaidepSV.findByName(txt_search.getText()).get(row);
        }
        pagination();
        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Cập nhật thành công");
        panel.showNotification();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        if (checkNull()) {
            return;
        }
        LoaiDep loaidep = getForm();
        this.loaidepSV.save(loaidep);
        pagination();
        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Thêm thành công");
        panel.showNotification();
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_searchCaretUpdate
        // TODO add your handling code here:
        LoadTabale(loaidepSV.findByName(txt_search.getText()));
    }//GEN-LAST:event_txt_searchCaretUpdate

    private void tb_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_TableMouseClicked
        // TODO add your handling code here:
        int row = tb_Table.getSelectedRow();
        txt_Ma.setText(tb_Table.getValueAt(row, 0).toString());
        txt_Ten.setText(tb_Table.getValueAt(row, 1).toString());
        if (tb_Table.getValueAt(row, 4).equals("Đang kinh doanh")) {
            rd_DangKinhDoanh.setSelected(true);
        } else {
            rd_NgungKinhDoanh.setSelected(true);
        }
    }//GEN-LAST:event_tb_TableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_add;
    private swing.Button btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Total;
    private swing.Pagination pagination1;
    private swing.RadioButtonCustom rd_DangKinhDoanh;
    private swing.RadioButtonCustom rd_NgungKinhDoanh;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tb_Table;
    private swing.TextField txt_Ma;
    private swing.TextField txt_Ten;
    private swing.TextField txt_search;
    // End of variables declaration//GEN-END:variables
}
