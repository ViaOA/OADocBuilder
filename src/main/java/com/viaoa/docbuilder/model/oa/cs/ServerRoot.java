// Copied from OATemplate project by OABuilder 07/01/16 07:41 AM
package com.viaoa.docbuilder.model.oa.cs;

import java.util.*;
import javax.xml.bind.annotation.*;

import com.viaoa.docbuilder.model.oa.*;
import com.viaoa.docbuilder.model.oa.propertypath.*;
import com.viaoa.annotation.*;
import com.viaoa.hub.*;
import com.viaoa.object.*;
import com.viaoa.util.*;

/**
 * Root Object that is automatically updated between the Server and Clients. ServerController will do the selects for these objects. Model
 * will share these hubs after the application is started.
 */

@OAClass(useDataSource = false, displayProperty = "Id")
@XmlRootElement(name = "serverRoot")
@XmlType(factoryMethod = "jaxbCreate")
@XmlAccessorType(XmlAccessType.NONE)
public class ServerRoot extends OAObject {
	private static final long serialVersionUID = 1L;

	public static final String PROPERTY_Id = "Id";
	public static final String P_Id = "Id";

	/*$$Start: ServerRoot1 $$*/
    // lookups, preselects
    public static final String P_AppServers = "AppServers";
    public static final String P_AppUsers = "AppUsers";
    public static final String P_ProjectInfos = "ProjectInfos";
    public static final String P_Tutorials = "Tutorials";
    // autoCreateOne
    public static final String P_CreateOneAppServerHub = "CreateOneAppServerHub";
    // filters
    // UI containers
    public static final String P_AppUserLogins = "AppUserLogins";
    public static final String P_AppUserErrors = "AppUserErrors";
/*$$End: ServerRoot1 $$*/

	protected int id;
	/*$$Start: ServerRoot2 $$*/
    // lookups, preselects
    protected transient Hub<AppServer> hubAppServers;
    protected transient Hub<AppUser> hubAppUsers;
    protected transient Hub<ProjectInfo> hubProjectInfos;
    protected transient Hub<Tutorial> hubTutorials;
    // autoCreateOne
    protected transient Hub<AppServer> hubCreateOneAppServer;
    // filters
    // UI containers
    protected transient Hub<AppUserLogin> hubAppUserLogins;
    protected transient Hub<AppUserError> hubAppUserErrors;
/*$$End: ServerRoot2 $$*/

	public ServerRoot() {
		setId(777);
	}

	@XmlAttribute(name = "oaSingleId")
	public Integer getJaxbGuid() {
		return super.getJaxbGuid();
	}

	@OAProperty(displayName = "Id")
	@OAId
	@XmlTransient
	public int getId() {
		return id;
	}

	public void setId(int id) {
		int old = this.id;
		this.id = id;
		firePropertyChange(PROPERTY_Id, old, id);
	}

	@XmlID
	@XmlAttribute(name = "id")
	public String getJaxbId() {
		// note: jaxb spec requires id to be a string
		if (!getJaxbShouldInclude(P_Id)) {
			return null;
		}
		return "" + id;
	}

	public void setJaxbId(String id) {
		if (getJaxbAllowPropertyChange(P_Id, this.id, id)) {
			setId((int) OAConv.convert(int.class, id));
		}
	}

	/*$$Start: ServerRoot3 $$*/
    // lookups, preselects
    @OAMany(toClass = AppServer.class, cascadeSave = true)
    @XmlTransient
    public Hub<AppServer> getAppServers() {
        if (hubAppServers == null) {
            hubAppServers = (Hub<AppServer>) super.getHub(P_AppServers);
        }
        return hubAppServers;
    }
    @XmlElementWrapper(name="appServers")
    @XmlElement(name="appServer", type=AppServer.class)
    protected List<AppServer> getJaxbAppServers() {
        return getJaxbHub(P_AppServers);
    }
    @XmlElementWrapper(name="refAppServers")
    @XmlElement(name="appServers", type=AppServer.class)
    @XmlIDREF
    protected List<AppServer> getJaxbRefAppServers() {
        return getJaxbRefHub(P_AppServers);
    }
    protected void setJaxbRefAppServers(List<AppServer> lst) {
        // no-op, since jaxb sends lst=hubAppServers;
    }
    @OAMany(toClass = AppUser.class, cascadeSave = true)
    @XmlTransient
    public Hub<AppUser> getAppUsers() {
        if (hubAppUsers == null) {
            hubAppUsers = (Hub<AppUser>) super.getHub(P_AppUsers);
        }
        return hubAppUsers;
    }
    @XmlElementWrapper(name="appUsers")
    @XmlElement(name="appUser", type=AppUser.class)
    protected List<AppUser> getJaxbAppUsers() {
        return getJaxbHub(P_AppUsers);
    }
    @XmlElementWrapper(name="refAppUsers")
    @XmlElement(name="appUsers", type=AppUser.class)
    @XmlIDREF
    protected List<AppUser> getJaxbRefAppUsers() {
        return getJaxbRefHub(P_AppUsers);
    }
    protected void setJaxbRefAppUsers(List<AppUser> lst) {
        // no-op, since jaxb sends lst=hubAppUsers;
    }
    @OAMany(toClass = ProjectInfo.class, cascadeSave = true)
    @XmlTransient
    public Hub<ProjectInfo> getProjectInfos() {
        if (hubProjectInfos == null) {
            hubProjectInfos = (Hub<ProjectInfo>) super.getHub(P_ProjectInfos);
        }
        return hubProjectInfos;
    }
    @XmlElementWrapper(name="projectInfos")
    @XmlElement(name="projectInfo", type=ProjectInfo.class)
    protected List<ProjectInfo> getJaxbProjectInfos() {
        return getJaxbHub(P_ProjectInfos);
    }
    @XmlElementWrapper(name="refProjectInfos")
    @XmlElement(name="projectInfos", type=ProjectInfo.class)
    @XmlIDREF
    protected List<ProjectInfo> getJaxbRefProjectInfos() {
        return getJaxbRefHub(P_ProjectInfos);
    }
    protected void setJaxbRefProjectInfos(List<ProjectInfo> lst) {
        // no-op, since jaxb sends lst=hubProjectInfos;
    }
    @OAMany(toClass = Tutorial.class, cascadeSave = true)
    @XmlTransient
    public Hub<Tutorial> getTutorials() {
        if (hubTutorials == null) {
            hubTutorials = (Hub<Tutorial>) super.getHub(P_Tutorials);
        }
        return hubTutorials;
    }
    @XmlElementWrapper(name="tutorials")
    @XmlElement(name="tutorial", type=Tutorial.class)
    protected List<Tutorial> getJaxbTutorials() {
        return getJaxbHub(P_Tutorials);
    }
    @XmlElementWrapper(name="refTutorials")
    @XmlElement(name="tutorials", type=Tutorial.class)
    @XmlIDREF
    protected List<Tutorial> getJaxbRefTutorials() {
        return getJaxbRefHub(P_Tutorials);
    }
    protected void setJaxbRefTutorials(List<Tutorial> lst) {
        // no-op, since jaxb sends lst=hubTutorials;
    }
    // autoCreatedOne
    @OAMany(toClass = AppServer.class, cascadeSave = true)
    public Hub<AppServer> getCreateOneAppServerHub() {
        if (hubCreateOneAppServer == null) {
            hubCreateOneAppServer = (Hub<AppServer>) super.getHub(P_CreateOneAppServerHub);
        }
        return hubCreateOneAppServer;
    }
    // filters
    // UI containers
    @OAMany(toClass = AppUserLogin.class, isCalculated = true, cascadeSave = true)
    public Hub<AppUserLogin> getAppUserLogins() {
        if (hubAppUserLogins == null) {
            hubAppUserLogins = (Hub<AppUserLogin>) super.getHub(P_AppUserLogins);
            String pp = AppUserPP.appUserLogins().lastDayFilter().pp;
            HubMerger hm = new HubMerger(this.getAppUsers(), hubAppUserLogins, pp, false, true);
        }
        return hubAppUserLogins;
    }
    @OAMany(toClass = AppUserError.class, isCalculated = true, cascadeSave = true)
    public Hub<AppUserError> getAppUserErrors() {
        if (hubAppUserErrors == null) {
            hubAppUserErrors = (Hub<AppUserError>) super.getHub(P_AppUserErrors);
            String pp = AppUserPP.appUserLogins().appUserErrors().pp;
            HubMerger hm = new HubMerger(this.getAppUsers(), hubAppUserErrors, pp, false, true);
        }
        return hubAppUserErrors;
    }
/*$$End: ServerRoot3 $$*/

	public static ServerRoot jaxbCreate() {
		ServerRoot serverRoot = (ServerRoot) OAObject.jaxbCreateInstance(ServerRoot.class);
		if (serverRoot == null) {
			serverRoot = new ServerRoot();
		}
		return serverRoot;
	}
}
