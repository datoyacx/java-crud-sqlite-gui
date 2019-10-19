/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.controller;
import crud.controller.interMahasiswa;
import crud.model.Mahasiswa;
import crud.conn.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Touyashi
 */
public class controllerMahasiswa implements interMahasiswa{

    public Mahasiswa insert(Mahasiswa o) throws SQLException {//untuk insert ke database
        java.sql.Connection conn = new DBConnection().connect();
        PreparedStatement st = conn.prepareStatement("INSERT INTO mahasiswa (nim, nama, tanggallahir, jeniskelamin, jurusan, profilegambar, nilaiuts, nilaiuas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        st.setString(1, o.getNIM());
        st.setString(2, o.getNama());
        st.setString(3, o.getTanggalLahir());
        st.setString(4, o.getJenisKelamin());
        st.setString(5, o.getJurusan());
        st.setString(6, o.getProfileGambar());
        st.setString(7, String.valueOf((float) o.getNilaiUTS()));
        st.setString(8, String.valueOf((float) o.getNilaiUAS()));
        st.executeUpdate();
        return o;
    }
    public void update(Mahasiswa o) throws SQLException {//untuk update ke database
        java.sql.Connection conn = new DBConnection().connect();
        
        PreparedStatement st = conn.prepareStatement("update mahasiswa set nim=?, nama=?, tanggallahir=?, jeniskelamin=?, jurusan=?, profilegambar=?, nilaiuts=?, nilaiuas=? where id=?");
        
        st.setString(1, o.getNIM());
        st.setString(2, o.getNama());
        st.setString(3, o.getTanggalLahir());
        st.setString(4, o.getJenisKelamin());
        st.setString(5, o.getJurusan());
        st.setString(6, o.getProfileGambar());
        st.setString(7, String.valueOf((float) o.getNilaiUTS()));
        st.setString(8, String.valueOf((float) o.getNilaiUAS()));
        st.setInt(9, o.getId());
        st.executeUpdate();
    }

    public void delete(int ids) throws SQLException {// untuk delete berdasarkan nim
        java.sql.Connection conn = new DBConnection().connect();
        PreparedStatement st = conn.prepareStatement("delete from mahasiswa where id=?");
        st.setInt(1, ids);
        st.executeUpdate();
    }
    
    public Mahasiswa find(int ids) throws SQLException {// untuk delete berdasarkan nim
        java.sql.Connection conn = new DBConnection().connect();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM mahasiswa WHERE id = ?");
        ps.setInt(1, ids);
        ResultSet rs = ps.executeQuery();
        Mahasiswa wako = null;
        while(rs.next()){
            wako = new Mahasiswa(
                    rs.getInt("id"),
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getString("tanggallahir"),
                    rs.getString("jeniskelamin"),
                    rs.getString("jurusan"),
                    rs.getString("profilegambar"),
                    rs.getFloat("nilaiuts"),
                    rs.getFloat("nilaiuas")
            );
        }
        return wako;
    }

    public List<Mahasiswa> getAll(String nama) throws SQLException { // untuk read all, jadi semua data diambil dan ditampilkan
        java.sql.Connection conn = new DBConnection().connect();
        ResultSet rs = null;
        if ("".equals(nama)) {
            Statement st = conn.createStatement();
            rs = st.executeQuery("select * from mahasiswa");
        } else {
            String sqls = "SELECT * FROM mahasiswa WHERE nama LIKE '%"+nama+"%'";
            PreparedStatement ps = conn.prepareStatement(sqls);
            rs = ps.executeQuery();
        }

        List<Mahasiswa> list = new ArrayList();
        while(rs.next()){
            Mahasiswa mhs = new Mahasiswa(
                    rs.getInt("id"),
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getString("tanggallahir"),
                    rs.getString("jeniskelamin"),
                    rs.getString("jurusan"),
                    rs.getString("profilegambar"),
                    rs.getFloat("nilaiuts"),
                    rs.getFloat("nilaiuas")
            );
            list.add(mhs);
        }
        return list;
    }
    
}
