/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet2022;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marie-Vonise LORDEUS
 */
public class ConnectToDb {
    public void chargerDriver(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public Connection connexion(String userName, String passwordDb, String dbName)  throws SQLException{
        String url ="jdbc:mysql://localhost:3306/" +"biblioteque_db";
        String user = "root";
        String password ="";
       
        Connection conn =DriverManager.getConnection(url, user, password);
        
        return conn;
    }
    
    public Statement requete(Connection connexion) throws SQLException{
       Statement stat = connexion.createStatement(); 
       
       return stat;
    }
        
 }
