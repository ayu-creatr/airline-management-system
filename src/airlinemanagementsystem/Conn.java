/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

/**
 *
 * @author hp
 */
import java.sql.*;

public class Conn
{
    
    Connection c; // connection string
    Statement s;
    public Conn()
    {
        try 
        {
            //Java Database connectivity
            //Registering driver
            Class.forName("com.mysql.cj.jdbc.Driver"); //Driver for sql
            
            //creating connection string by providing local host i.e. MySQL workbench
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "Ayug@2023");  
            s = c.createStatement(); // for making statement of connection string
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
