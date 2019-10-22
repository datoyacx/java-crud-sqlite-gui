/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.model;

/**
 *
 * @author Touyashi
 */
public class Mahasiswa {
    int id;
    String nim, nama, profilegambar, jurusan, jeniskelamin, tanggallahir, agama;
    float nilaiuts, nilaiuas;
    
    public Mahasiswa() {
    }
    
    public Mahasiswa (int id, String nim, String nama, String tanggallahir, String jeniskelamin, String jurusan,  String profilegambar, float nilaiuts, float nilaiuas, String agama) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.profilegambar = profilegambar;
        this.jeniskelamin = jeniskelamin;
        this.jurusan = jurusan;
        this.tanggallahir = tanggallahir;
        this.nilaiuts = nilaiuts;
        this.nilaiuas = nilaiuas;
        this.agama = agama;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getNIM() {
        return this.nim;
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public String getGrade() {
        float nilaiA = this.getNilaiAkhir();
        String hasil = "F";
        if (nilaiA >= 90) {
            hasil = "A";
        } else if (nilaiA >= 80) {
            hasil = "B";
        } else if (nilaiA >= 70) {
            hasil = "C";
        } else if (nilaiA >= 60) {
            hasil = "D";
        } else if (nilaiA >= 50) {
            hasil = "E";
        } else {
            hasil = "F";
        }
        
        return hasil;
    }
    
    public String getProfileGambar() {
        return this.profilegambar;
    }
    
    public String getJurusan() {
        return this.jurusan;
    }
    
    public String getJenisKelamin() {
        return this.jeniskelamin;
    }
    
    public String getTanggalLahir() {
        return this.tanggallahir;
    }
    
    public float getNilaiUTS() {
        return this.nilaiuts;
    }
    
    public float getNilaiUAS() {
        return this.nilaiuas;
    }
    
    public float setNilaiUTS(float nilaii) {
        return this.nilaiuts = nilaii;
    }
    
    public float setNilaiUAS(float nilaii) {
        return this.nilaiuas = nilaii;
    }
    
    public float getNilaiAkhir() {
        float hasil1 = nilaiuts*30/100;
        float hasil2 = nilaiuas*70/100;
        float hasil3 = hasil1+hasil2;
        return hasil3;
    }
    
    public String getAgama() {
        return this.agama;
    }
    
}
