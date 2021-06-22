// Copied from OATemplate project by OABuilder 06/20/21 11:44 AM
package com.viaoa.docbuilder.webservice.server;

import java.rmi.Remote;

public interface HelloInterface extends Remote {
    public String getHello(String name);
}
