
package gzrd.wsclient.navigation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gzrd.wsclient.navigation package. 
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

    private final static QName _GetMenusNavigationByPosIdResponse_QNAME = new QName("http://hugeinfo.com.cn", "getMenusNavigationByPosIdResponse");
    private final static QName _GetMenusNavigationByPosId_QNAME = new QName("http://hugeinfo.com.cn", "getMenusNavigationByPosId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gzrd.wsclient.navigation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link gzrd.wsclient.navigation.GetMenusNavigationByPosId }
     * 
     */
    public GetMenusNavigationByPosId createGetMenusNavigationByPosId() {
        return new GetMenusNavigationByPosId();
    }

    /**
     * Create an instance of {@link gzrd.wsclient.navigation.GetMenusNavigationByPosIdResponse }
     * 
     */
    public GetMenusNavigationByPosIdResponse createGetMenusNavigationByPosIdResponse() {
        return new GetMenusNavigationByPosIdResponse();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.navigation.GetMenusNavigationByPosIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getMenusNavigationByPosIdResponse")
    public JAXBElement<GetMenusNavigationByPosIdResponse> createGetMenusNavigationByPosIdResponse(GetMenusNavigationByPosIdResponse value) {
        return new JAXBElement<GetMenusNavigationByPosIdResponse>(_GetMenusNavigationByPosIdResponse_QNAME, GetMenusNavigationByPosIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link gzrd.wsclient.navigation.GetMenusNavigationByPosId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hugeinfo.com.cn", name = "getMenusNavigationByPosId")
    public JAXBElement<GetMenusNavigationByPosId> createGetMenusNavigationByPosId(GetMenusNavigationByPosId value) {
        return new JAXBElement<GetMenusNavigationByPosId>(_GetMenusNavigationByPosId_QNAME, GetMenusNavigationByPosId.class, null, value);
    }

}
