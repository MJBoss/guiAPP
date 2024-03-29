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
    
    public DBConnector(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scc_db", "root", "");
            }catch(SQLException e){
                System.err.println("Cannot connect to database: " + e.getMessage());
            }
        
        
    }
    
    
    //for SELECT or DISPLAY data, must be inside the connector class
    public ResultSet getData(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
    
       //for INSERT or CREATE data, must be inside the connector class
    public void insertData(String sql){
            try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.executeUpdate();
            System.out.println("Inserted Successfully!");
            pstmt.close();
            }catch(SQLException e){
                System.out.println("Connection Error: "+e);
            }
    }
    
      //for DELETE or REMOVE data, must be inside the connector class
    public void deleteData(int id) {
    try {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM tbl_student WHERE st_id = ?");
        stmt.setInt(1, id);
        int rowsDeleted = stmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println(rowsDeleted + " rows were deleted.");
        } else {
            System.out.println("No rows were deleted.");
        }
        stmt.close();
        connection.close();
    } catch (SQLException e) {
        System.out.println("Error deleting data: " + e.getMessage());
    }
}
    
      //for UPDATE or CHANGE data, must be inside the connector class
    public int updateData(String sql){
        int num = 0;
        try {
       
            String query = sql;
            PreparedStatement pstmt = connection.prepareStatement(query);
            int rowsUpdated = pstmt.executeUpdate();
            if(rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
                num = 1;
            } else {
                System.out.println("Data update failed!");
                num = 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return num;
    }
    
    
}
