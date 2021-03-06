package gzrd.wsclient.user;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.13
 * 2015-02-06T15:45:19.194+08:00
 * Generated source version: 2.7.13
 * 
 */
@WebServiceClient(name = "UserWebService", 
                  wsdlLocation = "http://192.168.0.150:8080/rdup/ws/UserWebService?wsdl",
                  targetNamespace = "http://hugeinfo.com.cn") 
public class UserWebService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://hugeinfo.com.cn", "UserWebService");
    public final static QName UserWebServicePort = new QName("http://hugeinfo.com.cn", "UserWebServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://192.168.0.150:8080/rdup/ws/UserWebService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(UserWebService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://192.168.0.150:8080/rdup/ws/UserWebService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public UserWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UserWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserWebService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns UserWebService
     */
    @WebEndpoint(name = "UserWebServicePort")
    public UserWebService getUserWebServicePort() {
        return super.getPort(UserWebServicePort, UserWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserWebService
     */
    @WebEndpoint(name = "UserWebServicePort")
    public UserWebService getUserWebServicePort(WebServiceFeature... features) {
        return super.getPort(UserWebServicePort, UserWebService.class, features);
    }

}
