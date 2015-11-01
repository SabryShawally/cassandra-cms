
package com.shawally.nora.database.connection.config;

import org.springframework.stereotype.Component;

/**
 * <p>
 * A simple class that holds the connection details for the Cassandra node.
 * </p>
 * @author Sabry <Shawally.Sabry@gmail.com>
 */
@Component
public class ConnectionConfig {
    
    private String host;
    private int port;
    private String username;
    private String password;
    private String database;
    
    public ConnectionConfig() {
        
    }
    
    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }
    
    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
