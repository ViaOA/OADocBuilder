// Copied from OATemplate project by OABuilder 07/01/16 07:41 AM
package com.viaoa.docbuilder.model.oa.cs;

import com.viaoa.object.*;
import com.viaoa.docbuilder.delegate.RemoteDelegate;
import com.viaoa.docbuilder.model.oa.*;
import com.viaoa.annotation.*;
import com.viaoa.hub.*;


/**
 * Root Object that is automatically updated between the Server and Clients.
 * ServerController will do the selects for these objects.
 * Model will share these hubs after the application is started.
 * */
@OAClass(
    useDataSource = false,
    displayProperty = "Id"
)
public class ClientRoot extends OAObject {
    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_Id = "Id";
    public static final String PROPERTY_ConnectionInfo = "ConnectionInfo";
    /*$$Start: ClientRoot1 $$*/
    /*$$End: ClientRoot1 $$*/

    protected int id;	

    // Hub
    /*$$Start: ClientRoot2 $$*/
    /*$$End: ClientRoot2 $$*/
	
    @OAProperty(displayName = "Id")
    @OAId
    public int getId() {
		return id;
	}
	public void setId(int id) {
		int old = this.id;
		this.id = id;
		firePropertyChange("id", old, id);
	}
	
    /*$$Start: ClientRoot3 $$*/
    /*$$End: ClientRoot3 $$*/

	
}
