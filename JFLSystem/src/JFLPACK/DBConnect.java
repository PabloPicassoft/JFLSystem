/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFLPACK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Paul
 */

public class DBConnect {
    public static void main(String[] args) {

        try {
            String host = "jdbc:derby://localhost:1527/JFLDB [JFLAdmin on JFLADMIN]";
            String uName = "JFLAdmin";
            String uPass= "JFLAdmin";
            
            Connection con = DriverManager.getConnection(host, uName, uPass);
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        
    }
}
