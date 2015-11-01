
package com.shawally.nora.database.connection.factory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.shawally.nora.database.connection.config.ConnectionConfig;

/**
 * <p>
 * An implementation of the Cassandra database as a database provider.
 * </p>
 * @author Sabry <Shawally.Sabry@gmail.com>
 */
public class CassandraDatabaseConnection implements DatabaseConnection {

    private Session session;
    private Cluster cluster;
    
    @Override
    public void connect(final ConnectionConfig config) {
        final Cluster.Builder clusterBuilder = Cluster.builder();
        this.cluster
                = clusterBuilder.addContactPoint(config.getHost()).build();
        this.session = cluster.connect();
    }

    @Override
    public int insert() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close() {
        session.close();
        cluster.close();
    }
}
