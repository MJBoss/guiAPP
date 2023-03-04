/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.*;

/**
 *
 * @author busta
 */
public class DBConnector {
    
    private Connection connection;
    
    public DBConnector() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mike", "root", "");
    }
    
    public ResultSet getData() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT s_id, s_name FROM tbl_students");
        return resultSet;
    }
    
}
