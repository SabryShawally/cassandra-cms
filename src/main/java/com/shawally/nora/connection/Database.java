
package com.shawally.nora.connection;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Session;
import com.shawally.nora.connection.config.ConnectionConfig;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * A singleton for the Database access.
 * </p>
 * @author Sabry <Shawally.Sabry@gmail.com>
 */
@Component
public class Database {
    
    @Autowired
    private ConnectionConfig config;
    
    //TODO: Hide the cassandra specific details in an adapter class.
    private Session session;
    private Cluster cluster;
    
    private static class LazyHolder {
        private static final Database INSTANCE = new Database();
    }
    
    private Database() {
        
    }

    @PostConstruct
    private void onInit() {
        final Builder clusterBuilder = Cluster.builder();
        this.cluster
                = clusterBuilder.addContactPoint(config.getHost()).build();
        this.session = cluster.connect();
    }
    
    public void setConfig(ConnectionConfig config) {
        this.config = config;
    }

    public ConnectionConfig getConfig() {
        return config;
    }
    
    public static Database getInstance() {
        return LazyHolder.INSTANCE;
    }
    
    @PreDestroy
    public void close() {
        this.session.close();
        this.cluster.close();
    }
}
