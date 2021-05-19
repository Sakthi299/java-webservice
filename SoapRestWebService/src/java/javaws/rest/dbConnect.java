package javaws.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {
    
protected static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:81/";
        String dbName = "application";  
        String dbUsername = "root";
        String dbPassword = "";
            
        Class.forName(dbDriver);
        Connection conn = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword); 
        return conn; 
    } 
} 

