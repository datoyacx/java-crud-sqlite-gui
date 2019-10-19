/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Touyashi
 */
public class DBConnection {
    private Connection conn;
    
    public Connection connect() {
       //untuk koneksi ke driver
       try{
           Class.forName("org.sqlite.JDBC");
           //JOptionPane.showMessageDialog(null, "Berhasil load driver");
           //System.out.println("Berhasil load driver");
       }catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null, "Tidak ada Driver!\n" + ex);
       }
 
       //untuk koneksi ke database
       try{
           String url="jdbc:sqlite:db/crud.db";
           conn = DriverManager.getConnection(url);
           //System.out.println("Berhasil koneksi"); 
       } catch(SQLException se) {
           System.out.println("Gagal koneksi "+se);
           JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
       }
       return conn;
    }
    
}
