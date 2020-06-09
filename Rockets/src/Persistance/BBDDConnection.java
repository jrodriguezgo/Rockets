package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BBDDConnection {

	private Connection connection;
    private static BBDDConnection instance;
    
    public BBDDConnection(String usuari, String password) throws Exception {
      	 try {
      		Class.forName ("oracle.jdbc.driver.OracleDriver");
           } catch (Exception e) {
               throw new Exception("ERROR connection ORACLE. Driver not found. " + e.getMessage());
           }
      	 ferConnexio(usuari,password);
      }

	private void ferConnexio(String usuari, String password) throws Exception {
    	try {
    		connection = DriverManager.getConnection("jdbc:oracle:thin:@kali.tecnocampus.cat:1521:sapiens", usuari, password);
         } catch (Exception e) {
             throw new Exception("ERROR connection ORACLE. " + e.getMessage());
          }
    }
    
    public synchronized static BBDDConnection getInstancia (String usuari, String password) throws Exception {
    	if (instance == null) {
    		instance = new BBDDConnection(usuari, password);
    	} else if (instance.connection.isClosed()){
    		instance.ferConnexio(usuari, password);
    		}
    	return instance;
    }
    
    public static BBDDConnection getInstancia () throws Exception {
    	if (instance == null) {
    		throw new Exception ("Error, first is needed the connexion with the login and password");
    	}
    	return instance;
    }
    
    public Statement createStatement() throws SQLException {
       return connection.createStatement();
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public void close() throws SQLException {
    	connection.close();
    }

    public boolean isClosed() throws SQLException {
       return connection.isClosed();
    }
    
}