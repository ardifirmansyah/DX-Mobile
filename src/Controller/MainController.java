/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Customer;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ardifirmansyah
 */
public class MainController extends MouseAdapter implements ActionListener {
    private Application model;
    private PanelContainer view;
    
    private String currentView;
    private JPanel mainPanel;
    private JComboBox cbCustomer;
    
    /* defenisi view */
    private Login login;
    private Home home;
    private AddCustomer addCustomer;
    private AddTransaction addTransaction;
    private ViewCustomer viewCustomer;
    private ViewTransaction viewTransaction;
    
    /* Constructor */
    public MainController(Application model) throws SQLException {
        this.model = model;
        this.view = new PanelContainer();
        
        /* instansiasi view */
        login = new Login();
        home = new Home();
        addCustomer = new AddCustomer();
        addTransaction = new AddTransaction();
        viewCustomer = new ViewCustomer();
        viewTransaction = new ViewTransaction();
        
        cbCustomer = addTransaction.getCbCustomer();
        
        view.addListener(this);
        login.addListener(this);
        addCustomer.addListener(this);
        addTransaction.addListener(this);
//        viewCustomer
//        viewTransaction
        
        mainPanel = view.getMainPanel();
        mainPanel.add(home, "0");
        mainPanel.add(addCustomer, "1");
        mainPanel.add(addTransaction, "2");
        mainPanel.add(viewCustomer, "3");
        mainPanel.add(viewTransaction, "4");
        
        currentView = "not found";
        
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(login.getBtnLogin())) {
            /* login handler */
            
//            if (login.getUsername().equals("admin")) {
//                if (login.getPassword().equals("dxmobile")) {
//                    login.dispose();
                    currentView = "0";
                    view.setVisible(true);
                    view.setLocationRelativeTo(null);
                    view.getCardLayout()
                            .show(mainPanel, currentView);
//                }
//                else {
//                    JOptionPane.showMessageDialog(login, "Login gagal");
//                }
//            }
//            else {
//                JOptionPane.showMessageDialog(login, "Login gagal");
//            }
        }
        
        if (source.equals(view.getBtnHome())) {
            currentView = "0";
        }
        else if (source.equals(view.getBtnAddCustomer())) {
            currentView = "1";
        }
        else if (source.equals(view.getBtnAddTransaction())) {
            cbCustomer.removeAllItems();
            currentView = "2";
        }
        else if (source.equals(view.getBtnViewCustomer())) {
            currentView = "3";
        }
        else if (source.equals(view.getBtnViewTransaction())) {
            currentView = "4";
        }
        else if (source.equals(view.getBtnLogout())) {
            int confirm = JOptionPane.showConfirmDialog(view, "Apakah anda yakin untuk logout?");
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
            else {
                currentView = "0";
            }
        }
        
        switch (currentView) {
            case "0": {
                view.getCardLayout().show(mainPanel, currentView);
            }
            case "1": {
                view.getCardLayout().show(mainPanel, currentView);
                Customer c = null;
                if (source.equals(addCustomer.getBtnSubmit())) {
                    String namaCustomer = addCustomer.getCustomerName();
                    addCustomer.setCustomerName(namaCustomer);
                    if (namaCustomer.isEmpty()) {
                        JOptionPane.showMessageDialog(view, "Nama pelanggan tidak boleh kosong");
                    }
                    else {
                        try {
                            c = model.getCustomerByName(namaCustomer);
                            if (c == null) {
                                c = new Customer(namaCustomer);
                                model.addCustomer(c);
                                c = model.getCustomerByName(namaCustomer);
                                if (c != null) {
                                    JOptionPane.showMessageDialog(view, "Customer baru berhasil ditambah. ID : " + c.getIdPelanggan());
                                }
                                else {
                                    JOptionPane.showMessageDialog(view, "Customer gagal ditambahkan.");
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(view, "Nama customer sudah ada. Masukkan nama lain");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                addCustomer.reset();
            }
            case "2": {
                try {
                    addTransaction.setCustomerItem(model.loadCustomer());
                    view.getCardLayout().show(mainPanel, currentView);
                    if (source.equals(addTransaction.getBtnSubmit())) {
                        Object selected = cbCustomer.getSelectedItem();
                        /* insert transaksi */
                        System.out.println(selected);
                        
                        /* fungsi dibawah ini bisa dimasukkan fungsi reset view */
                        addTransaction.reset();
                        addTransaction.setCustomerItem(model.loadCustomer());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case "3": {
                view.getCardLayout().show(mainPanel, currentView);
            }
            case "4": {
                view.getCardLayout().show(mainPanel, currentView);
            }
        }
    }
}
