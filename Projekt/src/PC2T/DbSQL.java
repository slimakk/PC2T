package PC2T;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSQL {
    private Connection conn;
    public boolean Connect()
    {
        conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:students.db");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public void Disconnect()
    {
        if(conn != null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
