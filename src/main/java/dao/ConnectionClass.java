package dao;

import java.sql.*;

public class ConnectionClass {
    static final String JDBC_DRIVER = "jdbc:mysql://127.0.0.1:3306/world";
    private static final String USER = "root";
    private static final String PASS = "123456";

    public Connection createConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_DRIVER, USER, PASS);
    }

}
