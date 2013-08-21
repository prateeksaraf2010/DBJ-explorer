/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database_explore;

/**
 *
 * @author prateek
 */
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author prateek
 */
public class MyConnection {
    public Connection myfuncconnection()
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prateek","root","");
         //   System.out.println("AAA");
            return con;
        }
        catch(Exception e)
        {
          System.out.println(e);
            return con;
        }
   }
    public Statement createstmt(Connection con)
    { 
        Statement stmt=null;
  
    try
    {
       stmt=con.createStatement();
     //   System.out.println("AAAB");
       return stmt;
    }
    catch(Exception e)
    {
       System.out.println(e);
        return stmt;
    }
    
}
    public void update(Statement stmt,String str)
    {
        try
        {
        stmt.executeUpdate(str);
        
    }   
        catch(Exception e)
        {
            System.out.println(e);
        }
}
    public void filltable(Statement stmt,JTable tb1,String str)
    {
        int i=0;
        int j=0;
        try
        {
        
        ResultSet rs=stmt.executeQuery(str);
            
        while(rs.next())
        {
            //System.out.println("execute1");
            j=0;
            String un=rs.getString("USERNAME");
            String ps=rs.getString("PASSWORD");
            tb1.setValueAt(un,i,j);
            j++;
            tb1.setValueAt(ps,i,j);
            i++;
        //    System.out.println(un+" "+ps);
        }
        
    }
        catch(Exception e)
        {
            System.out.println(" exception in my connection");
        }
    }
    public void fillcombobox(Statement stmt,JComboBox cb1,String str,String columnnm)
    {
                try
        {
        
        ResultSet rs=stmt.executeQuery(str);
            
        while(rs.next())
        {
          //  System.out.println("execute1");
           
            String un=rs.getString(columnnm);
            cb1.addItem(un);
            }
        
    }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void setnewtextandpass(String v1,String v2,JTextField jf,JPasswordField jp)
    {
        jf.setText(v1);
        jp.setText(v2);
    }
   
}
