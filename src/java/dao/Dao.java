/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikolas
 */
public class Dao {
    
     static {
        try {
            //Registrando o driver da forma mais utilizada
            // MySQL
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
     
      public Connection getConnection(boolean autoCommit) {        
        //Conectando-se ao SGBD
        Connection conn = null;
        try {
            // MySQL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaDeProvas", "root", "");
           
           
            conn.setAutoCommit(autoCommit);            
        } catch(SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);            
        }
        //Só queremos que a operação seja confirmada após darmos um commit na conexão
        return conn;
    }
    
}
