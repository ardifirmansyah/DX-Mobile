/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author ardifirmansyah
 */
public class Transaction {
    private int idTransaksi;
    private String kodeProduk;
    private String deskripsiProduk;
    private String nomorHp;
    private long hargaBeli;
    private long hargaJual;
    private Date tanggalTransaksi;
    private long terbayar;

    // constructor untuk pembuatan
    public Transaction(int idTransaksi, String kodeProduk, String deskripsiProduk, String nomorHp, long hargaBeli, long hargaJual, Date tanggalTransaksi, long terbayar) {
        this.idTransaksi = idTransaksi;
        this.kodeProduk = kodeProduk;
        this.deskripsiProduk = deskripsiProduk;
        this.nomorHp = nomorHp;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.tanggalTransaksi = tanggalTransaksi;
        this.terbayar = terbayar;
    }

    
    // constructor untuk pemanggilan
    public Transaction(String kodeProduk, String deskripsiProduk, String nomorHp, long hargaBeli, long hargaJual, Date tanggalTransaksi, long terbayar) {
        this.idTransaksi = -1;
        this.kodeProduk = kodeProduk;
        this.deskripsiProduk = deskripsiProduk;
        this.nomorHp = nomorHp;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.tanggalTransaksi = tanggalTransaksi;
        this.terbayar = terbayar;
    }
    
    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getDeskripsiProduk() {
        return deskripsiProduk;
    }

    public void setDeskripsiProduk(String deskripsiProduk) {
        this.deskripsiProduk = deskripsiProduk;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public long getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(long hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public long getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(long hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public long getTerbayar() {
        return terbayar;
    }

    public void setTerbayar(long terbayar) {
        this.terbayar = terbayar;
    }
}
