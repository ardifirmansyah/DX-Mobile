/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ardifirmansyah
 */
public class Application {
    private ArrayList<Transaction> listTransaction;
    private ArrayList<Customer> listCustomer;
    private Database db;
    
    public Application() {
        try {
            db = new Database();
            if (db.connect() != null) {
                JOptionPane.showMessageDialog(new JFrame(), "Koneksi berhasil");
            }
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(new JFrame(), se.getMessage());
            JOptionPane.showMessageDialog(new JFrame(), "Akan keluar program");
            System.exit(0);
        }
    }
    
    public void addCustomer(Customer c) throws SQLException {
        db.addCustomer(c);
    }
    
    public Customer getCustomerByName(String name) throws SQLException {
        return db.getCustomerByName(name);
    }
}
