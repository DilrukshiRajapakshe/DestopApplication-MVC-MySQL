package IJSE.DEP.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnecter {
    public  static Connection conn;

    public  static Connection conn() throws SQLException, ClassNotFoundException {
        if(conn == null) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/salehouse", "root", "root");
            System.out.println("Connected to the database..");
        }
        return conn;
    }
}
