/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author ardifirmansyah
 */
public class Customer {
    private int idPelanggan;
    private String namaPelanggan;
    private int hutang;
    private ArrayList<Transaction> listTransaksi;
    
    // constructor untuk pembuatan
    public Customer(String namaPelanggan) {
        this.idPelanggan = -1;
        this.namaPelanggan = namaPelanggan;
        this.hutang = 0;
        this.listTransaksi = new ArrayList<>();
    }
    
    // constructor untuk pemanggilan
    public Customer(int idPelanggan, 
            String namaPelanggan, 
            int hutang, ArrayList<Transaction> listTransaksi) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.hutang = hutang;
        this.listTransaksi = listTransaksi;
    }

    public Customer(int idPelanggan, String namaPelanggan, int hutang) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.hutang = hutang;
    }
 
    public ArrayList<Transaction> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(ArrayList<Transaction> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }
    
    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    
    public int getIdPelanggan() {
        return idPelanggan;
    }
    
    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }
    
    public String getNamaPelanggan() {
        return namaPelanggan;
    }
    
    public void setHutang(int hutang) {
        this.hutang = hutang;
    }
    
    public int getHutang() {
        return hutang;
    }
    
    @Override
    public String toString() {
        return namaPelanggan;
    }
}
