/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author hp
 */
public class Login extends JFrame implements ActionListener{
    JButton reset, close, submit;
    JTextField tfusername;
    JPasswordField tfpassword;
    public Login()
    {
        //For setting background color white
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Login box for display
        
        JLabel lfusername = new JLabel("Username   : ");
        JLabel lfpassword = new JLabel("Password   : ");
        
        lfusername.setBounds(20, 30, 100, 30);//setting location
        lfpassword.setBounds(20, 80, 100, 30);
        
        add(lfusername);
        add(lfpassword);
        
        tfusername = new JTextField();
        tfusername.setBounds(130, 30, 230, 30);
        add(tfusername);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 80, 230, 30);
        add(tfpassword);
        
        
        submit = new JButton("Submit");
        submit.setBounds(20, 135, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        
        reset = new JButton("Reset");
        reset.setBounds(140, 135, 100, 30);
        reset.addActionListener(this);
        add(reset);
        
        
        close = new JButton("Close");
        close.setBounds(260, 135, 100, 30);
        close.addActionListener(this);
        add(close);
        
        
        //For setting frame size   
        setSize(400, 250);
        
        //For setting frame in centre of the screen 
        setLocation(600, 250);
        
        //For making frame visible
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submit)
        {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            try 
            {
                Conn c = new Conn();
                
                String query = "select * from login where username = '"+username+"'  and password = '"+password+"'";
                ResultSet rs = c.s.executeQuery(query); // ResultSet is the result return by Select query of SQL
                
                if(rs.next())
                {
                    new Home();
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or Password");
                    setVisible(false);
                }
            }
            catch(Exception f)
            {
                f.printStackTrace();
            }
        }
        else if (e.getSource() == reset)
        {
            tfusername.setText("");
            tfpassword.setText("");
        }
        else
        {
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new Login();
    }
}
