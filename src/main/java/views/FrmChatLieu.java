package views;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.ChatLieu;
import services.IChatLieuService;
import services.impl.ChatLieuService;
import swing.Table;
import ui.EventPagination;
import ui.NotificationMess;
import ui.Page;
import ui.PaginationItemRenderStyle1;
import utilities.ExportChatLieu;
import utilities.Helper;
import utilities.ImportChatlieu;

/**
 *
 * @author dell
 */
public class FrmChatLieu extends javax.swing.JPanel {

    private DefaultTableModel defaultTableModel;
    private IChatLieuService chatLieuService;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    private Helper helper;
    private Page pg = new Page();
    Integer limit = 5;
    Integer totalData = 0;

    /**
     * Creates new form FrmSizeOK
     */
    public FrmChatLieu() {
        initComponents();
        chatLieuService = new ChatLieuService();
        initComponents();
        helper = new Helper();
        pagination(txt_search.getText());
        pagination1.setPagegination(1, pg.getTotalPage());
        pg.setCurrent(1);
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
        Table.apply(jScrollPane1, Table.TableType.MULTI_LINE);
    }

    public void pagination(String ten) {
        totalData = chatLieuService.getSearch(ten).size();
        int totalPage = (int) Math.ceil(totalData.doubleValue() / limit);
        pg.setTotalPage(totalPage);
        if (pg.getTotalPage() < pg.getCurrent()) {
            pagination1.setPagegination(pg.getTotalPage(), pg.getTotalPage());
            loadTable(chatLieuService.pagination(pg.getTotalPage(), limit, ten));
        } else {
            pagination1.setPagegination(pg.getCurrent(), pg.getTotalPage());
            loadTable(chatLieuService.pagination(pg.getCurrent(), limit, ten));
        }
        clear();
        pagination1.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                loadTable(chatLieuService.pagination(page, limit, ten));
                pg.setCurrent(page);
            }
        });
    }

    public void clear() {
        txt_Ma.setText("");
        txt_Ten.setText("");
        rd_DangKinhDoanh.setSelected(true);
    }

    public void loadTable(List<ChatLieu> list) {

        defaultTableModel = (DefaultTableModel) tbl_Table.getModel();
        defaultTableModel.setRowCount(0);
        for (ChatLieu chatLieu : list) {
            defaultTableModel.addRow(new Object[]{
                chatLieu.getMa(),
                chatLieu.getTen(),
                format.format(chatLieu.getNgayThem()),
                format.format(chatLieu.getNgaySuaCuoi()),
                chatLieu.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            });
        }
    }

    public int getTrangThaiInt() {
        if (rd_DangKinhDoanh.isSelected()) {
            return 0;
        } else {
            return 1;
        }
    }

    public ChatLieu getdata() {
        ChatLieu chatLieu = new ChatLieu();
        chatLieu.setTen(txt_Ten.getText().trim());
        chatLieu.setTrangThai(getTrangThaiInt());
        chatLieu.setNgayThem(new Date());
        chatLieu.setNgaySuaCuoi(new Date());
        return chatLieu;
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
        tbl_Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pagination1 = new swing.Pagination();
        btn_importExcel = new swing.Button();
        btn_exportExcel = new swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        txt_Ma.setEditable(false);
        txt_Ma.setToolTipText("");
        txt_Ma.setLabelText("Mã :");

        buttonGroup1.add(rd_DangKinhDoanh);
        rd_DangKinhDoanh.setSelected(true);
        rd_DangKinhDoanh.setText("Đang kinh doanh");

        buttonGroup1.add(rd_NgungKinhDoanh);
        rd_NgungKinhDoanh.setText("Ngừng kinh doanh");

        btn_update.setBackground(new java.awt.Color(102, 102, 102));
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Cập nhật");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(102, 102, 102));
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
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

        tbl_Table.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Table);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("CHẤT LIỆU");

        jPanel1.setBackground(new java.awt.Color(153, 51, 255));

        pagination1.setBackground(new java.awt.Color(153, 51, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_importExcel.setBackground(new java.awt.Color(0, 102, 0));
        btn_importExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_importExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        btn_importExcel.setText("Import Excel");
        btn_importExcel.setFocusPainted(false);
        btn_importExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_importExcelActionPerformed(evt);
            }
        });

        btn_exportExcel.setBackground(new java.awt.Color(0, 102, 0));
        btn_exportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        btn_exportExcel.setText("Export Excel");
        btn_exportExcel.setFocusPainted(false);
        btn_exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_search, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Ma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rd_NgungKinhDoanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rd_DangKinhDoanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_importExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_exportExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(222, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rd_DangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rd_NgungKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_importExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        int row = tbl_Table.getSelectedRow();
        if (row == -1) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Chọn 1 dòng chất liệu để cập nhật");
            panel.showNotification();
            return;
        }
        ChatLieu chatLieu = getdata();
        String ma = tbl_Table.getValueAt(row, 0).toString();
        if (txt_Ten.getText().trim().length() == 0) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Không được sửa rỗng !");
            panel.showNotification();
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật không ?", "Confirm", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            ChatLieu cl = chatLieuService.getObject(ma);
            cl.setTen(chatLieu.getTen());
            cl.setTrangThai(chatLieu.getTrangThai());
            cl.setNgaySuaCuoi(chatLieu.getNgaySuaCuoi());
            chatLieuService.save(cl);
            pagination(txt_search.getText());
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Cập Nhật Thành Công !");
            panel.showNotification();
        } else {
            return;
        }


    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:

        ChatLieu cl = getdata();
        String result;
        for (int i = 0; i < chatLieuService.getAll().size() + 1; i++) {
            result = "CL" + i;
            if (chatLieuService.getObject(result) == null) {
                cl.setMa(result);
                break;
            } else {
                continue;
            }
        }
        if (cl.getTen().length() == 0) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Chưa Nhập Tên !");
            panel.showNotification();
            return;
        }
        chatLieuService.save(cl);
        pagination(txt_search.getText());
        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Thêm thành công");
        panel.showNotification();

    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_searchCaretUpdate
        // TODO add your handling code here:
        pagination(txt_search.getText());
    }//GEN-LAST:event_txt_searchCaretUpdate

    private void tbl_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TableMouseClicked
        // TODO add your handling code here:
        int row = tbl_Table.getSelectedRow();
        txt_Ma.setText(tbl_Table.getValueAt(row, 0).toString());
        txt_Ten.setText(tbl_Table.getValueAt(row, 1).toString());
        if (tbl_Table.getValueAt(row, 4).toString().equals("Đang kinh doanh")) {
            rd_DangKinhDoanh.setSelected(true);
        } else {
            rd_NgungKinhDoanh.setSelected(true);
        }
    }//GEN-LAST:event_tbl_TableMouseClicked

    private void btn_importExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_importExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Import Excel");
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileOpen = fileChooser.getSelectedFile();
            try {
                List<ChatLieu> list = ImportChatlieu.readExcel(fileOpen.getAbsolutePath());

                if (helper.confirm(this, "Xác nhận thêm " + list.size() + " chất liệu ?")) {
                    for (ChatLieu x : list) {
                        ChatLieu d = chatLieuService.getObject(x.getMa());
                        if (d != null) {

                            continue;
                        } else {
                            chatLieuService.save(x);
                        }

                    }
                    pagination(txt_search.getText());
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Import File Excel thành công");
                    panel.showNotification();
                }
            } catch (Exception e) {
                e.printStackTrace();
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Import File Excel thất bại");
                panel.showNotification();
            }
            System.out.println("Save as file: " + fileOpen.getAbsolutePath());
        }
    }//GEN-LAST:event_btn_importExcelActionPerformed

    private void btn_exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Export Excel");
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                if (helper.confirm(this, "File Path: " + fileToSave.getAbsolutePath() + filter.getDescription() + ". Xác nhận xuất file ?")) {
                    ExportChatLieu.writeExcel(chatLieuService.getAll(), fileToSave.getAbsolutePath() + filter.getDescription());
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Xuất File Excel thành công");
                    panel.showNotification();
                }
            } catch (Exception e) {
                e.printStackTrace();
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Xuất File Excel thất bại");
                panel.showNotification();
            }
            System.out.println("Save as file: " + fileToSave.getAbsolutePath() + filter.getDescription());
        }
    }//GEN-LAST:event_btn_exportExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_add;
    private swing.Button btn_exportExcel;
    private swing.Button btn_importExcel;
    private swing.Button btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.Pagination pagination1;
    private swing.RadioButtonCustom rd_DangKinhDoanh;
    private swing.RadioButtonCustom rd_NgungKinhDoanh;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tbl_Table;
    private swing.TextField txt_Ma;
    private swing.TextField txt_Ten;
    private swing.TextField txt_search;
    // End of variables declaration//GEN-END:variables
}
