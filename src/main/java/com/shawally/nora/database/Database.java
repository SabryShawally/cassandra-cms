
package com.shawally.nora.database;

import com.shawally.nora.database.connection.config.ConnectionConfig;
import com.shawally.nora.database.connection.factory.DatabaseConnection;
import com.shawally.nora.database.connection.factory.DatabaseConnectionFactory;
import javax.annotation.PostConstruct;
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
    
    private DatabaseProvider databaseProvider;
    
    private DatabaseConnection databaseConnection;
    
    private static class LazyHolder {
        private static final Database INSTANCE = new Database();
    }
    
    private Database() {
    }

    @PostConstruct
    private void onInit() {
        this.databaseConnection
                = DatabaseConnectionFactory.getDatabaseConnection(databaseProvider);
        this.databaseConnection.connect(config);
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

    public DatabaseProvider getDatabaseProvider() {
        return databaseProvider;
    }

    public void setDatabaseProvider(final DatabaseProvider databaseProvider) {
        this.databaseProvider = databaseProvider;
    }

    public DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }

    public void setDatabaseConnection(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
