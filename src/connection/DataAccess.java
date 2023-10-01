package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {

    private Connection connection;
    private Statement stmt;

    public DataAccess() {
        try {
            MyConnection myConnection = new MyConnection();
            connection = myConnection.getConnection();
            stmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public int Update(String str) {
        try {
            int i = stmt.executeUpdate(str);
            return i;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return -1;
        }
    }

    public ResultSet Query(String str) {
        try {
            ResultSet rs = stmt.executeQuery(str);
            return rs;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
