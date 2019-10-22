/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.conn;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 
       String pathdb = "db/crud.db";
       Path x = Paths.get(pathdb);
       boolean isDbExist = Files.exists(x);
       String url="jdbc:sqlite:"+pathdb;
       //untuk koneksi ke database
       try {
           conn = DriverManager.getConnection(url);
           
           if (isDbExist == false) {
               DatabaseMetaData meta = conn.getMetaData();
               String yehh = "CREATE TABLE mahasiswa ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'nim' TEXT, 'nama' TEXT, 'tanggallahir' TEXT, 'jeniskelamin' TEXT, 'jurusan' TEXT, 'profilegambar' TEXT, 'nilaiuts' INTEGER, 'nilaiuas' INTEGER, 'agama' TEXT)";
               PreparedStatement st = conn.prepareStatement(yehh);
               st.executeUpdate();
               System.out.println("no db:( don't worry ill create it yo");
           }
       } catch(SQLException se) {
           System.out.println("Gagal koneksi "+se);
           JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
       }
       return conn;
    }
    
}
