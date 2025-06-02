package donasisosial.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/donasisosial";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // kosong jika pakai default XAMPP

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
 
    
  public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/donasisosial";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}


}
