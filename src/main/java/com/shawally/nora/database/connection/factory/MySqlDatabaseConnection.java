
package com.shawally.nora.database.connection.factory;

import com.shawally.nora.database.connection.config.ConnectionConfig;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <p>
 * A MySQL database connection.
 * </p>
 * @author Sabry <Shawally.Sabry@gmail.com>
 */
public class MySqlDatabaseConnection implements DatabaseConnection {

    private Connection connection;
    
    @Override
    public void connect(final ConnectionConfig config) {
        //TODO: Not nice
        final String connectionUrl
                = "jdbc:mysql://" 
                + config.getHost() 
                + ":" + config.getPort() 
                + "/" +  config.getDatabase();
        
        try {
            connection 
                    = DriverManager.getConnection(
                            connectionUrl, config.getUsername(), config.getPassword());
            
            
        } catch (final Exception ex) {
            
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (final Exception ex) {
            
        }
    }
}
