/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ardifirmansyah
 */
public class Customer {
    private int idPelanggan;
    private String namaPelanggan;
    private int hutang;
    
    public Customer(String namaPelanggan) {
        this.idPelanggan = -1;
        this.namaPelanggan = namaPelanggan;
        this.hutang = 0;
    }
    
    public Customer(int idPelanggan, String namaPelanggan, int hutang) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.hutang = hutang;
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
    
    
}
