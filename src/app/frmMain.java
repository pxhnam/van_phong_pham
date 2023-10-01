package app;

import connection.DataAccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import user.User;

public class frmMain extends javax.swing.JFrame {

    private final DataAccess access;
    private User user;

    public frmMain() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        access = new DataAccess();
        user = new User();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuListProd = new javax.swing.JMenu();
        miProd = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuUserAuth = new javax.swing.JMenu();
        miAuth = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuListProd.setText("Danh Mục Sản Phẩm");

        miProd.setText("Sản Phẩm");
        miProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProdActionPerformed(evt);
            }
        });
        menuListProd.add(miProd);

        jMenuItem2.setText("Loại Sản Phẩm");
        menuListProd.add(jMenuItem2);

        jMenuItem3.setText("Nhà Cung Cấp");
        menuListProd.add(jMenuItem3);

        jMenuBar1.add(menuListProd);

        menuUserAuth.setText("Phân Quyền Người Dùng");

        miAuth.setText("Phân Quyền");
        miAuth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuthActionPerformed(evt);
            }
        });
        menuUserAuth.add(miAuth);

        jMenuBar1.add(menuUserAuth);

        menuLogout.setText("Đăng Xuất");
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuLogout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAuthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuthActionPerformed
        String query = "SELECT * FROM Nhan_Vien Where MaNV = '" + user.getMaNV() + "'";
        try {
            ResultSet res = access.Query(query);
            if (res.next()) {
                if (res.getInt("Quyen") == 1) {
                    new frmAuth().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Bạn không có quyền này!!!");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_miAuthActionPerformed

    private void menuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseClicked
        new frmLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuLogoutMouseClicked

    private void miProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProdActionPerformed
        new frmProd().setVisible(true);
    }//GEN-LAST:event_miProdActionPerformed

    /**
     * @param args the command line arguments
     */
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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu menuListProd;
    private javax.swing.JMenu menuLogout;
    private javax.swing.JMenu menuUserAuth;
    private javax.swing.JMenuItem miAuth;
    private javax.swing.JMenuItem miProd;
    // End of variables declaration//GEN-END:variables
}
