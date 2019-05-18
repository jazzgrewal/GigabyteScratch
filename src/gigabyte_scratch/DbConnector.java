/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gigabyte_scratch;

import java.sql.*;
/**
 *
 * @author jaski
 */
public class DbConnector {
    Connection conn = null;

    public static Connection ConnectDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver"); //register jdbc driver
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jazz_gym", "root", "");
            //System.out.println("Succes connection");
            // JOptionPane.showMessageDialog(null, "Connected to db");
            return conn;

        } catch (Exception e) {
           //default condition no error display
            return null;
        }

    }
}
