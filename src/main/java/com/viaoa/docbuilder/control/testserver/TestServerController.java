// Copied from OATemplate project by OABuilder 06/20/21 11:44 AM
package com.viaoa.docbuilder.control.testserver;

import com.viaoa.docbuilder.datasource.DataSource;
import com.viaoa.docbuilder.resource.Resource;
import com.viaoa.datasource.objectcache.OADataSourceObjectCache;

/**
 * barebones test server, with only db connection.
 * @author vvia
 *
 */
public class TestServerController {

    public TestServerController() {
    }
    
    public void start() throws Exception {
        Resource.setRunType(Resource.RUNTYPE_Server);
        Resource.getServerProperties();

        String driver = Resource.getValue(Resource.DB_JDBC_Driver);

        DataSource dataSource = new DataSource();
        dataSource.open();
        dataSource.getOADataSource().setAssignIdOnCreate(true);

        OADataSourceObjectCache dsObjectCache = new OADataSourceObjectCache(); // for non-DB objects
    }
    
    
    public static void main(String[] args) throws Exception {
        TestServerController cont = new TestServerController();
        System.out.println("calling start");
        cont.start();
        System.out.println("done");
    }
    
}
