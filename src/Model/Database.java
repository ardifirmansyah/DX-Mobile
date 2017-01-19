/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ardifirmansyah
 */
public class Database {
    private String connectionUrl = 
            "jdbc:sqlserver://dxmobile.database.windows.net:1433;"
            + "database=dxmobile;user=dxmobile@dxmobile;"
            + "password=Kimono123;"
            + "encrypt=true;trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;";
    
    private Statement statement;
    private Connection connection;
    
    public Connection connect() throws SQLException {
        connection = DriverManager.getConnection(connectionUrl);
        statement = connection.createStatement();
        return connection;
    }
    
    public void addCustomer(Customer c) throws SQLException {
        String query = "insert into pelanggan "
                + "(namaPelanggan,hutang) values ("
                + "'" + c.getNamaPelanggan() + "',"
                + c.getHutang() + ")";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        int generatedId = -1;
        if (rs.next()) {
            generatedId = rs.getInt(1);
        }
        c.setIdPelanggan(generatedId);
    }
    
    public Customer getCustomerByName(String name) throws SQLException {
        Customer c = null;
        String query = "select * from pelanggan where namaPelanggan='"
                + name + "'";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            c = new Customer(rs.getInt(1), 
                    rs.getString(2), 
                    rs.getInt(3));
        }
        return c;
    }

    public ArrayList<Customer> loadCustomer() throws SQLException {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        Customer c = null;
        String query = "select * from pelanggan";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            c = new Customer(rs.getInt(1), 
                    rs.getString(2), 
                    rs.getInt(3));
            listCustomer.add(c);
        }
        return listCustomer;
    }
}
