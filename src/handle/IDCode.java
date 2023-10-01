package handle;

import connection.DataAccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IDCode {

    private DataAccess access;

    public IDCode() {
        access = new DataAccess();
    }

    public String generate(String str, String col, String table) {
        String query = "SELECT * FROM " + table + "";
        String code = "";
        try {
            ResultSet res = access.Query(query);
            int max = 0;
            String[] s;
            int num;
            while (res.next()) {
                s = res.getString(col).split(str);
                num = Integer.parseInt(s[1]);
                if (num > max) {
                    max = num;
                }
            }
            max++;
            code = str + max;
        } catch (SQLException ex) {
            Logger.getLogger(IDCode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return code;
    }
}
