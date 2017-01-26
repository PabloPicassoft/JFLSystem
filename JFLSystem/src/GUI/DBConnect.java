/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Paul
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Paul
 */

public class DBConnect {

    ResultSet rs;
    public ResultSet connect(String SQLStatment){
        
        try {
   
            String host = "jdbc:derby://localhost:1527/JFLDB";
            String uName = "JFLAdmin";
            String uPass= "JFLAdmin";
            
            Connection connection = DriverManager.getConnection(host, uName, uPass);
            
            Statement smt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            
            String getRecord = SQLStatment;
            
            rs = smt.executeQuery(getRecord);
            
            
            //Statement smtEditable = connection.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Statement smtUneditable = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            
            //query to show all records in specific result set.
            /*String showAllPlayerRecords = "SELECT * FROM PLAYERS";
            String showAllTeams = "SELECT * FROM TEAMS";
            String showAllMatchesPlayed = "SELECT * FROM MATCHES";
            String showAllReferees = "SELECT * FROM REFEREE";
            String showLeagueTable = "SELECT * FROM LEAGUETABLE";*/
            
            //store 'view all records' queries in result sets
            /*ResultSet allPlayersRS = smtUneditable.executeQuery(showAllPlayerRecords);
            ResultSet allTeamsRS = smtUneditable.executeQuery(showAllTeams);
            ResultSet allMatchesRS = smtUneditable.executeQuery(showAllMatchesPlayed);
            ResultSet allRefereesRS = smtUneditable.executeQuery(showAllReferees);
            ResultSet viewLeagueTableRS = smtUneditable.executeQuery(showLeagueTable);*/
            
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        return rs;
    }
}
