// Generated by OABuilder
package com.viaoa.docbuilder.model.oa;
 
import java.util.*;
import java.util.logging.*;
import java.sql.*;
import javax.xml.bind.annotation.*;
import com.viaoa.object.*;
import com.viaoa.hub.*;
import com.viaoa.scheduler.*;
import com.viaoa.util.*;
import com.viaoa.annotation.*;
import com.viaoa.util.OADateTime;
import com.viaoa.docbuilder.delegate.oa.*;
import com.viaoa.docbuilder.model.oa.filter.*;
import com.viaoa.docbuilder.model.oa.propertypath.*;
 
@OAClass(
    lowerName = "page",
    pluralName = "Pages",
    shortName = "pg",
    displayName = "Page",
    displayProperty = "id"
)
@OATable(
    indexes = {
        @OAIndex(name = "PageClassInfo", fkey = true, columns = { @OAIndexColumn(name = "ClassInfoId") }), 
        @OAIndex(name = "PageSection", fkey = true, columns = { @OAIndexColumn(name = "SectionId") })
    }
)
@XmlRootElement(name = "page")
@XmlType(factoryMethod = "jaxbCreate")
@XmlAccessorType(XmlAccessType.NONE)
public class Page extends OAObject {
    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(Page.class.getName());

    public static final String PROPERTY_Id = "Id";
    public static final String P_Id = "Id";
    public static final String PROPERTY_Created = "Created";
    public static final String P_Created = "Created";
    public static final String PROPERTY_Seq = "Seq";
    public static final String P_Seq = "Seq";
    public static final String PROPERTY_Name = "Name";
    public static final String P_Name = "Name";
    public static final String PROPERTY_Doc = "Doc";
    public static final String P_Doc = "Doc";
     
     
    public static final String PROPERTY_ClassInfo = "ClassInfo";
    public static final String P_ClassInfo = "ClassInfo";
    public static final String PROPERTY_Codes = "Codes";
    public static final String P_Codes = "Codes";
    public static final String PROPERTY_ImageStores = "ImageStores";
    public static final String P_ImageStores = "ImageStores";
    public static final String PROPERTY_LinkInfos = "LinkInfos";
    public static final String P_LinkInfos = "LinkInfos";
    public static final String PROPERTY_PackageInfo = "PackageInfo";
    public static final String P_PackageInfo = "PackageInfo";
    public static final String PROPERTY_ProjectInfo = "ProjectInfo";
    public static final String P_ProjectInfo = "ProjectInfo";
    public static final String PROPERTY_ReferenceClassInfos = "ReferenceClassInfos";
    public static final String P_ReferenceClassInfos = "ReferenceClassInfos";
    public static final String PROPERTY_Section = "Section";
    public static final String P_Section = "Section";
     
    protected volatile int id;
    protected volatile OADateTime created;
    protected volatile int seq;
    protected volatile String name;
    protected volatile String doc;
     
    // Links to other objects.
    protected volatile transient ClassInfo classInfo;
    protected transient Hub<Code> hubCodes;
    protected transient Hub<ImageStore> hubImageStores;
    protected transient Hub<ClassInfo> hubReferenceClassInfos;
    protected volatile transient Section section;
     
    public Page() {
        if (!isLoading()) setObjectDefaults();
    }
    @Override
    public void setObjectDefaults() {
        setCreated(new OADateTime());
    }
     
    public Page(int id) {
        this();
        setId(id);
    }
     

    @XmlAttribute(name="oaSingleId")
    public Integer getJaxbGuid() {
        return super.getJaxbGuid();
    }

    @OAProperty(isUnique = true, trackPrimitiveNull = false, displayLength = 6)
    @OAId()
    @XmlTransient
    @OAColumn(sqlType = java.sql.Types.INTEGER)
    public int getId() {
        return id;
    }
    public void setId(int newValue) {
        int old = id;
        fireBeforePropertyChange(P_Id, old, newValue);
        this.id = newValue;
        firePropertyChange(P_Id, old, this.id);
    }
    @XmlID
    @XmlAttribute(name="id")
    public String getJaxbId() {
        // note: jaxb spec requires id to be a string
        if (!getJaxbShouldInclude(P_Id)) return null;
        return ""+id;
    }
    public void setJaxbId(String id) {
        if (getJaxbAllowPropertyChange(P_Id, this.id, id)) {
            setId((int) OAConv.convert(int.class, id));
        }
    }

    @OAProperty(defaultValue = "new OADateTime()", displayLength = 15, isProcessed = true)
    @OAColumn(sqlType = java.sql.Types.TIMESTAMP)
    public OADateTime getCreated() {
        return created;
    }
    public void setCreated(OADateTime newValue) {
        OADateTime old = created;
        fireBeforePropertyChange(P_Created, old, newValue);
        this.created = newValue;
        firePropertyChange(P_Created, old, this.created);
    }
    @XmlElement(name="created", nillable=true)
    public OADateTime getJaxbCreated() {
        if (!getJaxbShouldInclude(P_Created)) return null;
        return getCreated();
    }
    public void setJaxbCreated(OADateTime newValue) {
        if (getJaxbAllowPropertyChange(P_Created, this.created, newValue)) {
            setCreated(newValue);
        }
    }

    @OAProperty(displayLength = 6, isAutoSeq = true)
    @OAColumn(sqlType = java.sql.Types.INTEGER)
    public int getSeq() {
        return seq;
    }
    public void setSeq(int newValue) {
        int old = seq;
        fireBeforePropertyChange(P_Seq, old, newValue);
        this.seq = newValue;
        firePropertyChange(P_Seq, old, this.seq);
    }
    @XmlElement(name="seq")
    public Integer getJaxbSeq() {
        if (!getJaxbShouldInclude(P_Seq)) return null;
        return getSeq();
    }
    public void setJaxbSeq(Integer newValue) {
        if (getJaxbAllowPropertyChange(P_Seq, this.seq, newValue)) {
            setSeq(newValue);
        }
    }

    @OAProperty(maxLength = 35, displayLength = 20)
    @OAColumn(maxLength = 35)
    public String getName() {
        return name;
    }
    public void setName(String newValue) {
        String old = name;
        fireBeforePropertyChange(P_Name, old, newValue);
        this.name = newValue;
        firePropertyChange(P_Name, old, this.name);
    }
    @XmlElement(name="name", nillable=true)
    public String getJaxbName() {
        if (!getJaxbShouldInclude(P_Name)) return null;
        return getName();
    }
    public void setJaxbName(String newValue) {
        if (getJaxbAllowPropertyChange(P_Name, this.name, newValue)) {
            setName(newValue);
        }
    }

    @OAProperty(displayLength = 30, columnLength = 20, isHtml = true)
    @OAColumn(sqlType = java.sql.Types.CLOB)
    public String getDoc() {
        return doc;
    }
    public void setDoc(String newValue) {
        String old = doc;
        fireBeforePropertyChange(P_Doc, old, newValue);
        this.doc = newValue;
        firePropertyChange(P_Doc, old, this.doc);
    }
    @XmlElement(name="doc", nillable=true)
    public String getJaxbDoc() {
        if (!getJaxbShouldInclude(P_Doc)) return null;
        return getDoc();
    }
    public void setJaxbDoc(String newValue) {
        if (getJaxbAllowPropertyChange(P_Doc, this.doc, newValue)) {
            setDoc(newValue);
        }
    }

    @OAOne(
        displayName = "Class Info", 
        reverseName = ClassInfo.P_Page, 
        allowCreateNew = false, 
        allowAddExisting = false, 
        isOneAndOnlyOne = true
    )
    @OAFkey(columns = {"ClassInfoId"})
    @XmlTransient
    public ClassInfo getClassInfo() {
        if (classInfo == null) {
            classInfo = (ClassInfo) getObject(P_ClassInfo);
        }
        return classInfo;
    }
    public void setClassInfo(ClassInfo newValue) {
        ClassInfo old = this.classInfo;
        fireBeforePropertyChange(P_ClassInfo, old, newValue);
        this.classInfo = newValue;
        firePropertyChange(P_ClassInfo, old, this.classInfo);
    }
    @XmlElement(name="classInfo")
    public ClassInfo getJaxbClassInfo() {
        Object obj = super.getJaxbObject(P_ClassInfo);
        return (ClassInfo) obj;
    }
    public void setJaxbClassInfo(ClassInfo newValue) {
        if (getJaxbAllowPropertyChange(P_ClassInfo, this.classInfo, newValue)) {
            setClassInfo(newValue);
        }
    }
    @XmlElement(name="refClassInfo")
    @XmlIDREF
    public ClassInfo getJaxbRefClassInfo() {
        Object obj = super.getJaxbRefObject(P_ClassInfo);
        return (ClassInfo) obj;
    }
    public void setJaxbRefClassInfo(ClassInfo newValue) {
        setJaxbClassInfo(newValue);
    }
    @XmlElement(name="classInfoId", nillable=true)
    public String getJaxbClassInfoId() {
        String s = super.getJaxbId(P_ClassInfo);
        return s;
    }
    public void setJaxbClassInfoId(String id) {
        setJaxbId(P_ClassInfo, id);
    }
     
    @OAMany(
        toClass = Code.class, 
        reverseName = Code.P_Page
    )
    @XmlTransient
    public Hub<Code> getCodes() {
        if (hubCodes == null) {
            hubCodes = (Hub<Code>) getHub(P_Codes);
        }
        return hubCodes;
    }
    @XmlElementWrapper(name="codes")
    @XmlElement(name="code", type=Code.class)
    protected List<Code> getJaxbCodes() {
        return getJaxbHub(P_Codes);
    }
    @XmlElementWrapper(name="refCodes")
    @XmlElement(name="code", type=Code.class)
    @XmlIDREF
    protected List<Code> getJaxbRefCodes() {
        return getJaxbRefHub(P_Codes); 
    }
    protected void setJaxbRefCodes(List<Code> lst) {
        // no-op, since jaxb sends lst=hubCodes 
    }
     
    @OAMany(
        displayName = "Image Stores", 
        toClass = ImageStore.class, 
        reverseName = ImageStore.P_Pages, 
        cascadeSave = true, 
        cascadeDelete = true
    )
    @OALinkTable(name = "PageImageStore", indexName = "ImageInfoPage", columns = {"PageId"})
    @XmlTransient
    public Hub<ImageStore> getImageStores() {
        if (hubImageStores == null) {
            hubImageStores = (Hub<ImageStore>) getHub(P_ImageStores);
        }
        return hubImageStores;
    }
    @XmlElementWrapper(name="imageStores")
    @XmlElement(name="imageStore", type=ImageStore.class)
    protected List<ImageStore> getJaxbImageStores() {
        return getJaxbHub(P_ImageStores);
    }
    @XmlElementWrapper(name="refImageStores")
    @XmlElement(name="imageStore", type=ImageStore.class)
    @XmlIDREF
    protected List<ImageStore> getJaxbRefImageStores() {
        return getJaxbRefHub(P_ImageStores); 
    }
    protected void setJaxbRefImageStores(List<ImageStore> lst) {
        // no-op, since jaxb sends lst=hubImageStores 
    }
     
    @OAMany(
        displayName = "Link Infos", 
        toClass = LinkInfo.class, 
        reverseName = LinkInfo.P_Page, 
        createMethod = false
    )
    @XmlTransient
    private Hub<LinkInfo> getLinkInfos() {
        // oamodel has createMethod set to false, this method exists only for annotations.
        return null;
    }
     
    @OAOne(
        displayName = "Package Info", 
        reverseName = PackageInfo.P_Page, 
        allowCreateNew = false, 
        allowAddExisting = false, 
        isOneAndOnlyOne = true
    )
    @XmlTransient
    private PackageInfo getPackageInfo() {
        // oamodel has createMethod set to false, this method exists only for annotations.
        return null;
    }
     
    @OAOne(
        displayName = "Project Info", 
        reverseName = ProjectInfo.P_Page, 
        allowCreateNew = false, 
        allowAddExisting = false
    )
    @XmlTransient
    private ProjectInfo getProjectInfo() {
        // oamodel has createMethod set to false, this method exists only for annotations.
        return null;
    }
     
    @OAMany(
        displayName = "Reference Class Infos", 
        toClass = ClassInfo.class, 
        reverseName = ClassInfo.P_ReferencePages
    )
    @OALinkTable(name = "PageClassInfo", indexName = "ClassInfoReferencePage", columns = {"PageId"})
    @XmlTransient
    public Hub<ClassInfo> getReferenceClassInfos() {
        if (hubReferenceClassInfos == null) {
            hubReferenceClassInfos = (Hub<ClassInfo>) getHub(P_ReferenceClassInfos);
        }
        return hubReferenceClassInfos;
    }
    @XmlElementWrapper(name="referenceClassInfos")
    @XmlElement(name="classInfo", type=ClassInfo.class)
    protected List<ClassInfo> getJaxbReferenceClassInfos() {
        return getJaxbHub(P_ReferenceClassInfos);
    }
    @XmlElementWrapper(name="refReferenceClassInfos")
    @XmlElement(name="classInfo", type=ClassInfo.class)
    @XmlIDREF
    protected List<ClassInfo> getJaxbRefReferenceClassInfos() {
        return getJaxbRefHub(P_ReferenceClassInfos); 
    }
    protected void setJaxbRefReferenceClassInfos(List<ClassInfo> lst) {
        // no-op, since jaxb sends lst=hubReferenceClassInfos 
    }
     
    @OAOne(
        reverseName = Section.P_Page, 
        allowCreateNew = false, 
        allowAddExisting = false, 
        isOneAndOnlyOne = true
    )
    @OAFkey(columns = {"SectionId"})
    @XmlTransient
    public Section getSection() {
        if (section == null) {
            section = (Section) getObject(P_Section);
        }
        return section;
    }
    public void setSection(Section newValue) {
        Section old = this.section;
        fireBeforePropertyChange(P_Section, old, newValue);
        this.section = newValue;
        firePropertyChange(P_Section, old, this.section);
    }
    @XmlElement(name="section")
    public Section getJaxbSection() {
        Object obj = super.getJaxbObject(P_Section);
        return (Section) obj;
    }
    public void setJaxbSection(Section newValue) {
        if (getJaxbAllowPropertyChange(P_Section, this.section, newValue)) {
            setSection(newValue);
        }
    }
    @XmlElement(name="refSection")
    @XmlIDREF
    public Section getJaxbRefSection() {
        Object obj = super.getJaxbRefObject(P_Section);
        return (Section) obj;
    }
    public void setJaxbRefSection(Section newValue) {
        setJaxbSection(newValue);
    }
    @XmlElement(name="sectionId", nillable=true)
    public String getJaxbSectionId() {
        String s = super.getJaxbId(P_Section);
        return s;
    }
    public void setJaxbSectionId(String id) {
        setJaxbId(P_Section, id);
    }
     
    public void load(ResultSet rs, int id) throws SQLException {
        this.id = id;
        java.sql.Timestamp timestamp;
        timestamp = rs.getTimestamp(2);
        if (timestamp != null) this.created = new OADateTime(timestamp);
        this.seq = (int) rs.getInt(3);
        if (rs.wasNull()) {
            OAObjectInfoDelegate.setPrimitiveNull(this, Page.P_Seq, true);
        }
        this.name = rs.getString(4);
        this.doc = rs.getString(5);
        int classInfoFkey = rs.getInt(6);
        if (!rs.wasNull() && classInfoFkey > 0) {
            setProperty(P_ClassInfo, new OAObjectKey(classInfoFkey));
        }
        int sectionFkey = rs.getInt(7);
        if (!rs.wasNull() && sectionFkey > 0) {
            setProperty(P_Section, new OAObjectKey(sectionFkey));
        }
        if (rs.getMetaData().getColumnCount() != 7) {
            throw new SQLException("invalid number of columns for load method");
        }

        this.changedFlag = false;
        this.newFlag = false;
    }
    public static Page jaxbCreate() {
        Page page = (Page) OAObject.jaxbCreateInstance(Page.class);
        if (page == null) page = new Page();
        return page;
    }
}
 
