
package com.shawally.nora.connection.config;

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
}
