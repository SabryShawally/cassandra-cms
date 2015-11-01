
package com.shawally.nora.database.connection.factory;

import com.shawally.nora.database.DatabaseProvider;

/**
 * <p>
 * A factory of the available database connections.
 * </p>
 * @author Sabry <Shawally.Sabry@gmail.com>
 */
public class DatabaseConnectionFactory {
    
    public static DatabaseConnection getDatabaseConnection(final DatabaseProvider provider) {
        
        if (provider == null) {
            throw new IllegalArgumentException("Database provider cannot be null");
        }
        
        switch (provider) {
            case CASSANDRA:
                return new CassandraDatabaseConnection();
            case MYSQL:
                return new MySqlDatabaseConnection();
        }
        
        return null;
    }
}
