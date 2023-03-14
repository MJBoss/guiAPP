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
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_school", "root", "");
            }catch(SQLException e){
                System.err.println("Cannot connect to database: " + e.getMessage());
            }
        
        
    }
    
    public ResultSet getData(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
    
    
    public void updateRecord(int id, String name, String email) {
    try {
        // Load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        // Establish a connection to the database
        
        // Create a prepared statement for the update query
        String sql = "UPDATE mytable SET name = ?, email = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Set the parameters for the prepared statement
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setInt(3, id);

        // Execute the update query
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println(rowsAffected + " rows updated.");

        // Close the prepared statement and connection
        preparedStatement.close();
        connection.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}
    
    
    
}
