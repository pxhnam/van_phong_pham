package app;

import connection.DataAccess;
import handle.IDCode;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import user.User;

public class frmProd extends javax.swing.JFrame {

    private DataAccess access;
    private User user;
    private static String code;
    private IDCode id;

    public frmProd() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        init();
    }

    public void init() {
        access = new DataAccess();
        user = new User();
        loadData();
        loadType();
        loadUnit();
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
    }

    public void loadData() {
        try {
            access = new DataAccess();
            ResultSet res = access.Query("SELECT * FROM Mat_Hang WHERE Vo_Hieu_Hoa = 0");
            DefaultTableModel tableModel;
            tableModel = (DefaultTableModel) tableProd.getModel();
            tableModel.setRowCount(0);
            while (res.next()) {
                tableModel.addRow(new Object[]{
                    res.getString("MaMH"),
                    res.getString("Ten_Mat_Hang"),
                    convertMoney(res.getFloat("Gia_Ban")),
                    res.getString("DVT")});
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void loadInfor(String code) {
        taInfor.setText("");
        try {
            ResultSet res = access.Query("SELECT * FROM Mat_Hang WHERE MaMH = '" + code + "'");
            if (res.next()) {
                taInfor.append("Mã Hàng: " + res.getString("MaMH"));
                taInfor.append("\nTên Mặt Hàng: " + res.getString("Ten_Mat_Hang"));
                taInfor.append("\nGiá Bán: " + convertMoney(res.getFloat("Gia_Ban")) + " VNĐ");
                taInfor.append("\nDVT: " + res.getString("DVT"));
                taInfor.append("\nMã Loại: " + res.getString("MaLoai"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public String convertMoney(float money) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        return df.format(money);
    }

    public void loadType() {
        ResultSet res = access.Query("SELECT * FROM Loai_Mat_Hang WHERE Vo_Hieu_Hoa = 0");
        try {
            while (res.next()) {
                cmbType.addItem(res.getString("MaLoai"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void loadUnit() {
        cmbUnit.addItem("Cái");
        cmbUnit.addItem("Chiếc");
        cmbUnit.addItem("Cây");
        cmbUnit.addItem("Tờ");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProd = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cmbType = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        cmbUnit = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        txtPrice = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtNameProd = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taInfor = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh Mục Mặt Hàng");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân Viên Bán Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat Alternates Light", 0, 15))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N

        tableProd.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
        tableProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Mặt Hàng", "Tên Mặt Hàng", "Giá Bán", "DVT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProd.setFocusable(false);
        tableProd.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableProd.setRowHeight(20);
        tableProd.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tableProd.setShowVerticalLines(false);
        tableProd.getTableHeader().setResizingAllowed(false);
        tableProd.getTableHeader().setReorderingAllowed(false);
        tableProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProd);
        tableProd.getTableHeader().setOpaque(false);
        tableProd.getTableHeader().setFont(new Font("Courier New", Font.BOLD, 15));
        tableProd.setRowHeight(25);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );

        btnAdd.setFont(new java.awt.Font("Montserrat Medium", 0, 13)); // NOI18N
        btnAdd.setText("THÊM");
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Montserrat Medium", 0, 13)); // NOI18N
        btnEdit.setText("SỬA");
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Montserrat Medium", 0, 13)); // NOI18N
        btnRemove.setText("XÓA");
        btnRemove.setFocusPainted(false);
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Montserrat Medium", 0, 13)); // NOI18N
        btnSave.setText("LƯU");
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Montserrat Medium", 0, 13)); // NOI18N
        btnCancel.setText("HỦY");
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Montserrat Medium", 0, 13)); // NOI18N
        btnRefresh.setText("LÀM MỚI");
        btnRefresh.setFocusPainted(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại Mặt Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 13))); // NOI18N

        cmbType.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbType, 0, 144, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DVT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 13))); // NOI18N

        cmbUnit.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giá Bán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 13))); // NOI18N

        txtPrice.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tên Mặt Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 13))); // NOI18N

        txtNameProd.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNameProd, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNameProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 13))); // NOI18N

        taInfor.setEditable(false);
        taInfor.setColumns(20);
        taInfor.setRows(5);
        jScrollPane1.setViewportView(taInfor);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnRemove)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdMouseClicked
        try {
            int row = this.tableProd.getSelectedRow();
            String ID = (this.tableProd.getModel()).getValueAt(row, 0).toString();
            loadInfor(ID);
            String query = "SELECT * FROM Mat_Hang WHERE MaMH = '" + ID + "' ";
            ResultSet res = access.Query(query);
            if (res.next()) {
                txtNameProd.setText(res.getString("Ten_Mat_Hang"));
                txtPrice.setText(res.getFloat("Gia_Ban") + "");
                cmbType.setSelectedItem(res.getString("MaLoai"));
                cmbUnit.setSelectedItem(res.getString("DVT"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmProd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableProdMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        disableButton(0);
        Refresh();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        disableButton(1);
        code = null;
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = this.tableProd.getSelectedRow();
        if (row != -1) {
            disableButton(1);
            code = (this.tableProd.getModel()).getValueAt(row, 0).toString();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int row = this.tableProd.getSelectedRow();
        if (row != -1) {
            try {
                String ID = (this.tableProd.getModel()).getValueAt(row, 0).toString();
                String name = (this.tableProd.getModel()).getValueAt(row, 1).toString();
                int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa " + name + " không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    String query = "UPDATE Mat_Hang SET Vo_Hieu_Hoa = 1 WHERE MaMH = '" + ID + "' ";
                    int res = access.Update(query);
                    if (res != 0) {
                        loadData();
                    } else {
                        System.out.println("Xóa thất bại!!!");
                    }
                }
            } catch (HeadlessException e) {
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        disableButton(0);
        if (!"".equals(txtNameProd.getText().trim()) || !"".equals(txtPrice.getText().trim())) {
            try {
                String MaMH;
                String TenMH = txtNameProd.getText();
                Float Gia = Float.parseFloat(txtPrice.getText());
                String DVT = (String) cmbUnit.getSelectedItem();
                String MaLoai = (String) cmbType.getSelectedItem();
                String query;
                if (code == null) {
                    id = new IDCode();
                    MaMH = id.generate("MH", "MaMH", "Mat_Hang");
                    query = "INSERT INTO Mat_Hang VALUES ('" + MaMH + "','" + TenMH + "','" + Gia + "','" + DVT + "','" + MaLoai + "',0)";
                } else {
                    MaMH = code;
                    query = "UPDATE Mat_Hang SET Ten_Mat_Hang = '" + TenMH + "', Gia_Ban = '" + Gia + "', DVT = '" + DVT + "', MaLoai = '" + MaLoai + "' WHERE MaMH ='" + MaMH + "'";
                }
                if (MaMH.trim().equals("")) {
                    return;
                }
                int res = access.Update(query);
                if (res != 0) {
                    loadData();
                    Refresh();
                } else {
                    System.out.println("Thất bại!!!");
                }
            } catch (NumberFormatException ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    public void Refresh() {
        loadData();
        cmbType.setSelectedIndex(0);
        cmbUnit.setSelectedIndex(0);
        txtNameProd.setText("");
        txtPrice.setText("");
        taInfor.setText("");
    }

    public void disableButton(int i) {
        switch (i) {
            case 0: {
                btnAdd.setEnabled(true);
                btnEdit.setEnabled(true);
                btnSave.setEnabled(false);
                btnCancel.setEnabled(false);
                tableProd.setEnabled(true);
                break;
            }
            case 1: {
                btnAdd.setEnabled(false);
                btnEdit.setEnabled(false);
                btnSave.setEnabled(true);
                btnCancel.setEnabled(true);
                tableProd.setEnabled(false);
                break;
            }
            default:
                break;
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmProd().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JComboBox<String> cmbUnit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taInfor;
    private javax.swing.JTable tableProd;
    private javax.swing.JTextField txtNameProd;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
