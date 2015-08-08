
package gzrd.wsclient.menu.wsinterface;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gzrd.wsclient.menu.wsinterface package. 
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

    private final static QName _GetAllMenusByUserIdAndAppCodeResponse_QNAME = new QName("http://hugeinfo.com.cn", "getAllMenusByUserIdAndAppCodeResponse");
    private final static QName _GetAllMenusByUserIdAndAppCode_QNAME = new QName("http://hugeinfo.com.cn", "getAllMenusByUserIdAndAppCode");
    private final static QName _GetSetupMenusByUserIdAndAppCodeResponse_QNAME = new QName("http://hugeinfo.com.cn", "getSetupMenusByUserIdAndAppCodeResponse");
    private final static QName _GetMenusByUserIdAndAppCode_QNAME = new QName("http://hugeinfo.com.cn", "getMenusByUserIdAndAppCode");
    private final static QName _GetMenusByUserIdAndAppCodeResponse_QNAME = new QName("http://hugeinfo.com.cn", "getMenusByUserIdAndAppCodeResponse");
    private final static QName _GetSetupMenusByUserIdAndAppCode_QNAME = new QName("http://hugeinfo.com.cn", "getSetupMenusByUserIdAndAppCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gzrd.wsclient.menu.wsinterface
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link gzrd.wsclient.menu.wsinterface.GetSetupMenusByUserIdAndAppCodeResponse }
     * 
     */
    public GetSetupMenusByUserIdAndAppCodeResponse createGetSetupMenusByUserIdAndAppCodeResponse() {
        return new GetSetupMenusByUserIdAndAppCodeResponse();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.menu.wsinterface.GetAllMenusByUserIdAndAppCodeResponse }
     * 
     */
    public GetAllMenusByUserIdAndAppCodeResponse createGetAllMenusByUserIdAndAppCodeResponse() {
        return new GetAllMenusByUserIdAndAppCodeResponse();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.menu.wsinterface.GetAllMenusByUserIdAndAppCode }
     * 
     */
    public GetAllMenusByUserIdAndAppCode createGetAllMenusByUserIdAndAppCode() {
        return new GetAllMenusByUserIdAndAppCode();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.menu.wsinterface.GetMenusByUserIdAndAppCode }
     * 
     */
    public GetMenusByUserIdAndAppCode createGetMenusByUserIdAndAppCode() {
        return new GetMenusByUserIdAndAppCode();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.menu.wsinterface.GetSetupMenusByUserIdAndAppCode }
     * 
     */
    public GetSetupMenusByUserIdAndAppCode createGetSetupMenusByUserIdAndAppCode() {
        return new GetSetupMenusByUserIdAndAppCode();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.menu.wsinterface.GetMenusByUserIdAndAppCodeResponse }
     * 
     */
    public GetMenusByUserIdAndAppCodeResponse createGetMenusByUserIdAndAppCodeResponse() {
        return new GetMenusByUserIdAndAppCodeResponse();
    }

    /**
     * Create an instance of {@link Menu }
     * 
     */
    public Menu createMenu() {
        return new Menu();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.menu.wsinterface.GetAllMenusByUserIdAndAppCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getAllMenusByUserIdAndAppCodeResponse")
    public JAXBElement<GetAllMenusByUserIdAndAppCodeResponse> createGetAllMenusByUserIdAndAppCodeResponse(GetAllMenusByUserIdAndAppCodeResponse value) {
        return new JAXBElement<GetAllMenusByUserIdAndAppCodeResponse>(_GetAllMenusByUserIdAndAppCodeResponse_QNAME, GetAllMenusByUserIdAndAppCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.menu.wsinterface.GetAllMenusByUserIdAndAppCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getAllMenusByUserIdAndAppCode")
    public JAXBElement<GetAllMenusByUserIdAndAppCode> createGetAllMenusByUserIdAndAppCode(GetAllMenusByUserIdAndAppCode value) {
        return new JAXBElement<GetAllMenusByUserIdAndAppCode>(_GetAllMenusByUserIdAndAppCode_QNAME, GetAllMenusByUserIdAndAppCode.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.menu.wsinterface.GetSetupMenusByUserIdAndAppCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getSetupMenusByUserIdAndAppCodeResponse")
    public JAXBElement<GetSetupMenusByUserIdAndAppCodeResponse> createGetSetupMenusByUserIdAndAppCodeResponse(GetSetupMenusByUserIdAndAppCodeResponse value) {
        return new JAXBElement<GetSetupMenusByUserIdAndAppCodeResponse>(_GetSetupMenusByUserIdAndAppCodeResponse_QNAME, GetSetupMenusByUserIdAndAppCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.menu.wsinterface.GetMenusByUserIdAndAppCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getMenusByUserIdAndAppCode")
    public JAXBElement<GetMenusByUserIdAndAppCode> createGetMenusByUserIdAndAppCode(GetMenusByUserIdAndAppCode value) {
        return new JAXBElement<GetMenusByUserIdAndAppCode>(_GetMenusByUserIdAndAppCode_QNAME, GetMenusByUserIdAndAppCode.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.menu.wsinterface.GetMenusByUserIdAndAppCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getMenusByUserIdAndAppCodeResponse")
    public JAXBElement<GetMenusByUserIdAndAppCodeResponse> createGetMenusByUserIdAndAppCodeResponse(GetMenusByUserIdAndAppCodeResponse value) {
        return new JAXBElement<GetMenusByUserIdAndAppCodeResponse>(_GetMenusByUserIdAndAppCodeResponse_QNAME, GetMenusByUserIdAndAppCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.menu.wsinterface.GetSetupMenusByUserIdAndAppCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getSetupMenusByUserIdAndAppCode")
    public JAXBElement<GetSetupMenusByUserIdAndAppCode> createGetSetupMenusByUserIdAndAppCode(GetSetupMenusByUserIdAndAppCode value) {
        return new JAXBElement<GetSetupMenusByUserIdAndAppCode>(_GetSetupMenusByUserIdAndAppCode_QNAME, GetSetupMenusByUserIdAndAppCode.class, null, value);
    }

}
