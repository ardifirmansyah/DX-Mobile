/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.MainController;
import Model.Application;
import java.sql.SQLException;

/**
 *
 * @author ardifirmansyah
 */
public class Driver {
    public static void main(String[] args) throws SQLException {
        Application app = new Application();
        new MainController(app);
    }
}
