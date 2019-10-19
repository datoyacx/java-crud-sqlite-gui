/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.controller;

import crud.model.Mahasiswa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Touyashi
 */
public interface interMahasiswa {
    Mahasiswa insert(Mahasiswa o) throws SQLException;

    void update(Mahasiswa o) throws SQLException;

    void delete(int ids) throws SQLException;
    
    Mahasiswa find(int ids) throws SQLException;

    List<Mahasiswa> getAll(String nama) throws SQLException;
}
