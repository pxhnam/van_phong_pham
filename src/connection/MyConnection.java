package connection;

import java.sql.*;
import javax.swing.JOptionPane;

public class MyConnection {

    public Connection getConnection() {
        Connection connection = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/van_phong_pham";
            connection = DriverManager.getConnection(URL, "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
}
