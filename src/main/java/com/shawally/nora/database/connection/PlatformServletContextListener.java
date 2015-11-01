
package com.shawally.nora.database.connection;

import com.shawally.nora.database.Database;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

/**
 *
 * @author Sabry <Shawally.Sabry@gmail.com>
 */
public class PlatformServletContextListener implements ServletContextListener {

    private static final Logger log
            = Logger.getLogger(PlatformServletContextListener.class);
    
    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        Database.getInstance();
    }

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
    }
}
