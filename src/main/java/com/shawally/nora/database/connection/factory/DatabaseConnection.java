
package com.shawally.nora.database.connection.factory;

import com.shawally.nora.database.connection.config.ConnectionConfig;

/**
 * <p>
 * An abstract representation of a DB connection, and the possible operations.
 * </p>
 * @author Sabry <Shawally.Sabry@gmail.com>
 */
public interface DatabaseConnection {
    
    public void connect(final ConnectionConfig config);
    
    public int insert();
    
    public int update();
    
    public int delete();
    
    public void close();
}
