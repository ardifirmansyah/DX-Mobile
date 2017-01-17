/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
    
    /* defenisi view */
    private Home home;
    private AddCustomer addCustomer;
    private AddTransaction addTransaction;
    private ViewCustomer viewCustomer;
    private ViewTransaction viewTransaction;
    
    /* Constructor */
    public MainController(Application model) {
        this.model = model;
        this.view = new PanelContainer();
        
        /* instansiasi view */
        home = new Home();
        addCustomer = new AddCustomer();
        addTransaction = new AddTransaction();
        viewCustomer = new ViewCustomer();
        viewTransaction = new ViewTransaction();
        
        addCustomer.addListener(this);
//        addTransaction
//        viewCustomer
//        viewTransaction
        
        mainPanel = view.getMainPanel();
        mainPanel.add(home, "0");
        mainPanel.add(addCustomer, "1");
        mainPanel.add(addTransaction, "2");
        mainPanel.add(viewCustomer, "3");
        mainPanel.add(viewTransaction, "4");
        currentView = "1";
        
        view.getCardLayout()
                .show(mainPanel, currentView);
        view.setVisible(true);
        view.addListener(this);
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
