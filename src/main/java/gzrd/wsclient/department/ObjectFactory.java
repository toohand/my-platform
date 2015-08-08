
package gzrd.wsclient.department;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gzrd.wsclient.department package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDeptInfByIdResponse_QNAME = new QName("http://hugeinfo.com.cn", "getDeptInfByIdResponse");
    private final static QName _DeptExists_QNAME = new QName("http://hugeinfo.com.cn", "deptExists");
    private final static QName _UpdateDeptFuncById_QNAME = new QName("http://hugeinfo.com.cn", "updateDeptFuncById");
    private final static QName _UpdateDeptFuncByIdResponse_QNAME = new QName("http://hugeinfo.com.cn", "updateDeptFuncByIdResponse");
    private final static QName _GetDeptChangeInfos_QNAME = new QName("http://hugeinfo.com.cn", "getDeptChangeInfos");
    private final static QName _GetDeptsForUser_QNAME = new QName("http://hugeinfo.com.cn", "getDeptsForUser");
    private final static QName _GetDeptsForUserResponse_QNAME = new QName("http://hugeinfo.com.cn", "getDeptsForUserResponse");
    private final static QName _DeptExistsResponse_QNAME = new QName("http://hugeinfo.com.cn", "deptExistsResponse");
    private final static QName _GetDeptsByOrgId_QNAME = new QName("http://hugeinfo.com.cn", "getDeptsByOrgId");
    private final static QName _GetDeptInfById_QNAME = new QName("http://hugeinfo.com.cn", "getDeptInfById");
    private final static QName _GetDeptsByOrgIdResponse_QNAME = new QName("http://hugeinfo.com.cn", "getDeptsByOrgIdResponse");
    private final static QName _GetDeptChangeInfosResponse_QNAME = new QName("http://hugeinfo.com.cn", "getDeptChangeInfosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gzrd.wsclient.department
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.UpdateDeptFuncByIdResponse }
     * 
     */
    public UpdateDeptFuncByIdResponse createUpdateDeptFuncByIdResponse() {
        return new UpdateDeptFuncByIdResponse();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.UpdateDeptFuncById }
     * 
     */
    public UpdateDeptFuncById createUpdateDeptFuncById() {
        return new UpdateDeptFuncById();
    }

    /**
     * Create an instance of {@link DeptExists }
     * 
     */
    public DeptExists createDeptExists() {
        return new DeptExists();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.GetDeptInfByIdResponse }
     * 
     */
    public GetDeptInfByIdResponse createGetDeptInfByIdResponse() {
        return new GetDeptInfByIdResponse();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.GetDeptsByOrgIdResponse }
     * 
     */
    public GetDeptsByOrgIdResponse createGetDeptsByOrgIdResponse() {
        return new GetDeptsByOrgIdResponse();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.GetDeptInfById }
     * 
     */
    public GetDeptInfById createGetDeptInfById() {
        return new GetDeptInfById();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.GetDeptChangeInfosResponse }
     * 
     */
    public GetDeptChangeInfosResponse createGetDeptChangeInfosResponse() {
        return new GetDeptChangeInfosResponse();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.GetDeptsByOrgId }
     * 
     */
    public GetDeptsByOrgId createGetDeptsByOrgId() {
        return new GetDeptsByOrgId();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.DeptExistsResponse }
     * 
     */
    public DeptExistsResponse createDeptExistsResponse() {
        return new DeptExistsResponse();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.GetDeptsForUserResponse }
     * 
     */
    public GetDeptsForUserResponse createGetDeptsForUserResponse() {
        return new GetDeptsForUserResponse();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.GetDeptsForUser }
     * 
     */
    public GetDeptsForUser createGetDeptsForUser() {
        return new GetDeptsForUser();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.GetDeptChangeInfos }
     * 
     */
    public GetDeptChangeInfos createGetDeptChangeInfos() {
        return new GetDeptChangeInfos();
    }

    /**
     * Create an instance of {@link Dept }
     * 
     */
    public Dept createDept() {
        return new Dept();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.department.UpDeptChangeForm }
     * 
     */
    public UpDeptChangeForm createUpDeptChangeForm() {
        return new UpDeptChangeForm();
    }

    /**
     * Create an instance of {@link UserInfo }
     * 
     */
    public UserInfo createUserInfo() {
        return new UserInfo();
    }

    /**
     * Create an instance of {@link Position }
     * 
     */
    public Position createPosition() {
        return new Position();
    }

    /**
     * Create an instance of {@link Deptment }
     * 
     */
    public Deptment createDeptment() {
        return new Deptment();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.department.GetDeptInfByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getDeptInfByIdResponse")
    public JAXBElement<GetDeptInfByIdResponse> createGetDeptInfByIdResponse(GetDeptInfByIdResponse value) {
        return new JAXBElement<GetDeptInfByIdResponse>(_GetDeptInfByIdResponse_QNAME, GetDeptInfByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link DeptExists }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "deptExists")
    public JAXBElement<DeptExists> createDeptExists(DeptExists value) {
        return new JAXBElement<DeptExists>(_DeptExists_QNAME, DeptExists.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.department.UpdateDeptFuncById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "updateDeptFuncById")
    public JAXBElement<UpdateDeptFuncById> createUpdateDeptFuncById(UpdateDeptFuncById value) {
        return new JAXBElement<UpdateDeptFuncById>(_UpdateDeptFuncById_QNAME, UpdateDeptFuncById.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.department.UpdateDeptFuncByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "updateDeptFuncByIdResponse")
    public JAXBElement<UpdateDeptFuncByIdResponse> createUpdateDeptFuncByIdResponse(UpdateDeptFuncByIdResponse value) {
        return new JAXBElement<UpdateDeptFuncByIdResponse>(_UpdateDeptFuncByIdResponse_QNAME, UpdateDeptFuncByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.department.GetDeptChangeInfos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getDeptChangeInfos")
    public JAXBElement<GetDeptChangeInfos> createGetDeptChangeInfos(GetDeptChangeInfos value) {
        return new JAXBElement<GetDeptChangeInfos>(_GetDeptChangeInfos_QNAME, GetDeptChangeInfos.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.department.GetDeptsForUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getDeptsForUser")
    public JAXBElement<GetDeptsForUser> createGetDeptsForUser(GetDeptsForUser value) {
        return new JAXBElement<GetDeptsForUser>(_GetDeptsForUser_QNAME, GetDeptsForUser.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.department.GetDeptsForUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getDeptsForUserResponse")
    public JAXBElement<GetDeptsForUserResponse> createGetDeptsForUserResponse(GetDeptsForUserResponse value) {
        return new JAXBElement<GetDeptsForUserResponse>(_GetDeptsForUserResponse_QNAME, GetDeptsForUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.department.DeptExistsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "deptExistsResponse")
    public JAXBElement<DeptExistsResponse> createDeptExistsResponse(DeptExistsResponse value) {
        return new JAXBElement<DeptExistsResponse>(_DeptExistsResponse_QNAME, DeptExistsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.department.GetDeptsByOrgId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getDeptsByOrgId")
    public JAXBElement<GetDeptsByOrgId> createGetDeptsByOrgId(GetDeptsByOrgId value) {
        return new JAXBElement<GetDeptsByOrgId>(_GetDeptsByOrgId_QNAME, GetDeptsByOrgId.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.department.GetDeptInfById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getDeptInfById")
    public JAXBElement<GetDeptInfById> createGetDeptInfById(GetDeptInfById value) {
        return new JAXBElement<GetDeptInfById>(_GetDeptInfById_QNAME, GetDeptInfById.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.department.GetDeptsByOrgIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getDeptsByOrgIdResponse")
    public JAXBElement<GetDeptsByOrgIdResponse> createGetDeptsByOrgIdResponse(GetDeptsByOrgIdResponse value) {
        return new JAXBElement<GetDeptsByOrgIdResponse>(_GetDeptsByOrgIdResponse_QNAME, GetDeptsByOrgIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.department.GetDeptChangeInfosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getDeptChangeInfosResponse")
    public JAXBElement<GetDeptChangeInfosResponse> createGetDeptChangeInfosResponse(GetDeptChangeInfosResponse value) {
        return new JAXBElement<GetDeptChangeInfosResponse>(_GetDeptChangeInfosResponse_QNAME, GetDeptChangeInfosResponse.class, null, value);
    }

}
